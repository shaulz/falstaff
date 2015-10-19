package com.falstaff.web;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.classification.FormatQuery;
import com.falstaff.core.ontology.MagicNumbers.OntologyMagicRelations;
import com.falstaff.crawler.FileFormatsCrawler;
import com.falstaff.service.FeaturedSamplesSetService;
import com.falstaff.service.FileFormatService;
import com.falstaff.service.MagicNumberService;
import com.falstaff.service.OntologyService;

@Controller
public class FileFormatController {

	@Autowired
	FileFormatService fileFormatService;
	
	@Autowired
	OntologyService ontologyService;
	
	@Autowired
	FeaturedSamplesSetService featuredSamplesSetService;
		
	@Autowired
	FileFormatsCrawler fileFormatsCrawler;
	
	@Autowired
	MagicNumberService magicNumberService;

	private static final Logger logger = LoggerFactory.getLogger(FileFormatController.class.getName());

	@RequestMapping(value="/formats", method = RequestMethod.GET)
	public ModelAndView viewFileFormatsAll() {
		ModelAndView model = new ModelAndView("formats/view-tree", "formatsTree", fileFormatService.getFormatsTree(null, true));
		model.addObject("formatQuery", new FormatQuery());
		model.addObject("processMonitor", fileFormatsCrawler.getProcessMonitor());
		model.addObject("updateDate", ontologyService.getOntology().getUpdateDate());
		return model;	
	}
	
	@RequestMapping(value="/rest/formats", method = RequestMethod.GET)
	@ResponseBody
	public List<FileFormat> getFileFormats() {
		return fileFormatService.getFormats();
	}
	
	@RequestMapping(value="/formats", method = RequestMethod.POST, params = "operation=search")
	public ModelAndView viewFileFormatsSearch(@Valid FormatQuery formatQuery, BindingResult result,
			RedirectAttributes redirect) {
		ModelAndView model = new ModelAndView("formats/view-tree", "formatsTree", fileFormatService.getFormatsTree(null, true));
		model.addObject("searchedFormats", fileFormatService.searchFormats(formatQuery));
		if (formatQuery.getPending()) {
			model.addObject("operation", formatQuery.getPendingQueue().name());
		}
		model.addObject("processMonitor", fileFormatsCrawler.getProcessMonitor());
		model.addObject("updateDate", ontologyService.getOntology().getUpdateDate());
		return model;	
	}
	
	@RequestMapping(value="/formats/{formatId}", method = RequestMethod.GET)
	public ModelAndView viewFileFormat(@PathVariable("formatId") FileFormat fileFormat) {
		return new ModelAndView("formats/view", "fileFormat", fileFormat);		
	}
	
	@RequestMapping(value="/formats/{formatId}", method = RequestMethod.GET, params = "operation=create")
	public ModelAndView createFileFormatForm(@PathVariable("formatId") String formatId) {
		FileFormat fileFormat = fileFormatService.getNewFormat(new Integer(formatId));
		ModelAndView model = new ModelAndView("formats/view", "fileFormat", fileFormat);
		model.addObject("operation", "create");
		return model;		
	}
	
	@RequestMapping(value="/formats/{formatId}", method = RequestMethod.GET, params = "operation=update")
	public ModelAndView updateFileFormatForm(@PathVariable("formatId") FileFormat fileFormat) {
		ModelAndView model = new ModelAndView("formats/view", "fileFormat", fileFormat);
		model.addObject("operation", "update");
		return model;		
	}
	
	@RequestMapping(value="/formats/{formatId}", method = RequestMethod.GET, params = "operation=delete")
	public ModelAndView deleteFileFormatForm(@PathVariable("formatId") FileFormat fileFormat) {
		ModelAndView model = new ModelAndView("formats/view", "fileFormat", fileFormat);
		model.addObject("operation", "delete");
		return model;		
	}
	
	@RequestMapping(value="/formats/{formatId}", method = RequestMethod.POST, params = "operation=create")
	public ModelAndView createFileFormat(@PathVariable("formatId") String formatId) throws NumberFormatException, IOException {
		FileFormat fileFormat = fileFormatService.createFormat(new Integer(formatId));
		ModelAndView model = new ModelAndView("formats/view", "fileFormat", fileFormat);
		return model;		
	}
	
	@RequestMapping(value="/formats/{formatId}", method = RequestMethod.POST, params = "operation=update")
	public ModelAndView updateFileFormat(@PathVariable("formatId") FileFormat fileFormat) throws IOException {
		fileFormatService.updateFormat(fileFormat);
		ModelAndView model = new ModelAndView("formats/view", "fileFormat", fileFormat);
		return model;		
	}
	
	@RequestMapping(value="/formats/{formatId}", method = RequestMethod.POST, params = "operation=delete")
	public ModelAndView deleteFileFormat(@PathVariable("formatId") FileFormat fileFormat) throws IOException {
		fileFormatService.deleteFormat(fileFormat);
		return viewFileFormatsAll();		
	}
	
	@RequestMapping(value="/formats/samples", method = RequestMethod.POST)
	public ModelAndView createAllSamples() {
		try {
			featuredSamplesSetService.createAll();
		} catch (IOException e) {
			logger.error("create all samples failed " + e.getMessage());
		}
		return new ModelAndView("formats/view-tree", "formatsTree", fileFormatService.getFormatsTree(null, true));	
	}
	
	@RequestMapping(value="/formats", method = RequestMethod.POST)
	public ModelAndView updateFileFormatsAll() {
		try {
			fileFormatService.updateFileFormatsAll();
		} catch (IOException e) {
			logger.error("update file formats all failed " + e.getMessage());
		}
		ModelAndView model = new ModelAndView("formats/view-tree", "formatsTree", fileFormatService.getFormatsTree(null, true));
		model.addObject("processMonitor", fileFormatsCrawler.getProcessMonitor());
		return model;	
	}
	
	@RequestMapping(value="/formats/monitor", method = RequestMethod.GET)
	public String viewFileFormatsAllProgressStatus(Model model) {
		model.addAttribute("processMonitor", fileFormatsCrawler.getProcessMonitor());		
		return "execution/process-view :: process";
	}
	
	@RequestMapping(value="/formats/{formatId}/magic", method = RequestMethod.GET)
	public ModelAndView linkMagicForm(@PathVariable("formatId") FileFormat fileFormat) {
		ModelAndView model = new ModelAndView("formats/form-magic", "fileFormat", fileFormat);
		OntologyMagicRelations relations = fileFormat.getOntology().getMagicRelations();
		model.addObject("ontologyRelations", relations);
		return model;		
	}
	
	@RequestMapping(value="/formats/{formatId}/magic", method = RequestMethod.POST)
	public ModelAndView linkMagic(@PathVariable("formatId") FileFormat fileFormat, @ModelAttribute("ontologyRelations") @Valid OntologyMagicRelations ontologyRelations, BindingResult result) throws IOException {
		magicNumberService.linkMagic(fileFormat.getOntology(), ontologyRelations);
		ModelAndView model = new ModelAndView("formats/view", "fileFormat", fileFormat);
		model.addObject("operation", "update");
		return model;			
	}

}
