package com.falstaff.web;

import java.io.IOException;
import java.util.Calendar;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.falstaff.core.classification.FeaturedClassifier;
import com.falstaff.core.classification.FeaturedSignature;
import com.falstaff.core.classification.FeaturedSignaturesSet;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.service.FeaturedClassifierService;

@Controller
public class FeaturedClassifierController {

	@Autowired
	FeaturedClassifierService featuredClassifierService;
	
	private static final Logger logger = LoggerFactory.getLogger(FeaturedClassifierController.class.getName());

	@RequestMapping(value="/classifiers", method = RequestMethod.GET, params = "operation=view")
	public ModelAndView viewClassifiersAll() {
		return new ModelAndView("classifiers/view-all", "classifiers", featuredClassifierService.readAll());	
	}
	
	@RequestMapping(value="/classifiers", method = RequestMethod.GET, params = "operation=create")
	public ModelAndView createClassifierForm() {
		FeaturedClassifier classifier = new FeaturedClassifier();
		return new ModelAndView("classifiers/create", "classifier", classifier);	
	}
	
	@RequestMapping(value="/classifiers", method = RequestMethod.POST)
	public ModelAndView createClassifier(@ModelAttribute("classifier") @Valid FeaturedClassifier classifier, BindingResult result
			) {
		featuredClassifierService.create(classifier);
		return new ModelAndView("classifiers/view", "classifier", classifier);	
	}
	
	@RequestMapping(value="/classifiers/{classifierId}", method = RequestMethod.GET)
	public ModelAndView viewClassifier(@PathVariable("classifierId") FeaturedClassifier classifier) {
		ModelAndView modelAndView =  new ModelAndView("classifiers/view", "classifier", classifier);
		modelAndView.addObject("formatsTree", featuredClassifierService.getFormatsTree(classifier));
		modelAndView.addObject("formatsAddTree", featuredClassifierService.getFormatsAddTree(classifier));
		return modelAndView;
	}
	
	@RequestMapping(value="/classifiers/{classifierId}", method = RequestMethod.POST, params="add-format")
	public ModelAndView addFormat(@PathVariable("classifierId") FeaturedClassifier classifier, @RequestParam("add-format") String formatName) throws IOException {
		logger.info("adding format " + formatName + " to classifier " + classifier.getName());
		featuredClassifierService.addFormat(classifier, formatName);
		ModelAndView modelAndView = new ModelAndView("redirect:/classifiers/{classifierId}", "classifierId", classifier.getId());
		modelAndView.addObject("classifierId", classifier.getId());
		return modelAndView;
	}
	
	@RequestMapping(value="/classifiers/{classifierId}", method = RequestMethod.POST, params="delete-format")
	public ModelAndView deleteFormat(@PathVariable("classifierId") FeaturedClassifier classifier, @RequestParam("delete-format") String formatName) throws IOException {
		logger.info("deleting format " + formatName + " from classifier " + classifier.getName());
		featuredClassifierService.deleteFormat(classifier, formatName);
		ModelAndView modelAndView = new ModelAndView("redirect:/classifiers/{classifierId}", "classifierId", classifier.getId());
		modelAndView.addObject("classifierId", classifier.getId());
		return modelAndView;
	}
	
	@RequestMapping(value="/classifiers/{classifierId}", method = RequestMethod.POST, params="operation=update")
	public ModelAndView updateClassifier(@PathVariable("classifierId") FeaturedClassifier classifier, @ModelAttribute("classifier") @Valid FeaturedClassifier updatedClassifier) throws IOException {
		classifier.setName(updatedClassifier.getName());
		classifier.setDescription(updatedClassifier.getDescription());
		classifier.setUpdated(Calendar.getInstance());
		classifier.setAssignFileProperties(updatedClassifier.getAssignFileProperties());
		featuredClassifierService.save(classifier);
		logger.info("classifier " + classifier.getName() + " was updated");
		ModelAndView modelAndView = new ModelAndView("classifiers/view", "classifier", classifier);
		modelAndView.addObject("formatsTree", featuredClassifierService.getFormatsTree(classifier));
		return modelAndView;
	}
	
	@RequestMapping(value="/classifiers/{classifierId}", method = RequestMethod.POST, params="operation=delete")
	public ModelAndView deleteClassifier(@PathVariable("classifierId") FeaturedClassifier classifier) throws IOException {
		featuredClassifierService.delete(classifier);
		logger.info("classifier " + classifier.getName() + " was deleted");
		return new ModelAndView("/classifiers/view-all");
	}
	
	@RequestMapping(value="/classifiers/{classifierId}", method = RequestMethod.POST, params="operation=train")
	public ModelAndView trainClassifier(@PathVariable("classifierId") FeaturedClassifier classifier) throws IOException {
		featuredClassifierService.train(classifier);
		ModelAndView modelAndView = new ModelAndView("classifiers/view", "classifier", classifier);
		modelAndView.addObject("formatsTree", featuredClassifierService.getFormatsTree(classifier));
		return modelAndView;
	}
	
	@RequestMapping(value="/classifiers/{classifierId}", method = RequestMethod.POST, params="operation=test")
	public ModelAndView testClassifier(@PathVariable("classifierId") FeaturedClassifier classifier) throws IOException {
		featuredClassifierService.test(classifier);
		ModelAndView modelAndView = new ModelAndView("classifiers/view", "classifier", classifier);
		modelAndView.addObject("formatsTree", featuredClassifierService.getFormatsTree(classifier));
		return modelAndView;
	}
	
	@RequestMapping(value="/classifiers/{classifierId}/monitor", method = RequestMethod.GET)
	public String viewClassifierProgressStatus(Model model, @PathVariable("classifierId") FeaturedClassifier classifier) {
		model.addAttribute("processMonitor", classifier.getProcessMonitor());		
		return "execution/process-view :: process";
	}

	@RequestMapping(value="/rest/classifiers", method = RequestMethod.GET, params="classifier")
    @ResponseBody
    public FeaturedClassifier getFileFormatOntology(@RequestParam("classifier") String classifier) {
        return featuredClassifierService.get(classifier);
    }
}
