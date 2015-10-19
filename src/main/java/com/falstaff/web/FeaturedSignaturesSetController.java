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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FeaturedSignature;
import com.falstaff.core.classification.FeaturedSignaturesSet;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.classification.MagicSignaturesSet;
import com.falstaff.core.classification.PronomSignaturesSet;
import com.falstaff.service.AlignerContext;
import com.falstaff.service.FeaturedSignaturesSetService;
import com.falstaff.service.FileFormatService;
import com.falstaff.service.MagicNumberService;

@Controller
public class FeaturedSignaturesSetController {

	@Autowired
	FileFormatService fileFormatService;
	
	@Autowired
	FeaturedSignaturesSetService featuredSignaturesSetService;
	
	@Autowired
	MagicNumberService magicNumberService;

	private static final Logger logger = LoggerFactory.getLogger(FeaturedSignaturesSetController.class.getName());
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets", method = RequestMethod.GET, params="ARCHIVETEAM")
	public ModelAndView formArchiveteamSignaturesSet(@PathVariable("formatId") FileFormat fileFormat) throws IOException {
		ModelAndView modelAndView = new ModelAndView("signatures-sets/form-archiveteam", "fileFormat", fileFormat);
		FeaturedSignaturesSet signaturesSet = new FeaturedSignaturesSet("archiveteam", fileFormat);
		modelAndView.addObject("signaturesSet", signaturesSet);
		return modelAndView;
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets", method = RequestMethod.GET, params="PRONOM")
	public ModelAndView formPronomSignaturesSet(@RequestParam("puid") String puid, @PathVariable("formatId") FileFormat fileFormat) throws IOException {
		ModelAndView modelAndView = new ModelAndView("signatures-sets/form-pronom", "fileFormat", fileFormat);
		PronomSignaturesSet signaturesSet = new PronomSignaturesSet(puid, fileFormat, false);
		modelAndView.addObject("signaturesSet", signaturesSet);
		return modelAndView;
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets", method = RequestMethod.GET, params="FALSTAFF")
	public ModelAndView formFalstaffSignaturesSet(@RequestParam("samplesSetId") int samplesSetId, @PathVariable("formatId") FileFormat fileFormat) throws IOException {
		ModelAndView modelAndView = new ModelAndView("signatures-sets/form-falstaff", "fileFormat", fileFormat);
		modelAndView.addObject("samplesSetId", samplesSetId);
		//AlignedSignaturesSet signaturesSet = new AlignedSignaturesSet(fileFormat.getSamplesSet(samplesSetId));
		//modelAndView.addObject("signaturesSet", signaturesSet);
		AlignerContext context = featuredSignaturesSetService.defaultAlignerContext(fileFormat.getSamplesSet(samplesSetId));
		modelAndView.addObject("context", context);
		return modelAndView;
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets", method = RequestMethod.GET, params="MAGIC")
	public ModelAndView formMagicSignaturesSet(@PathVariable("formatId") FileFormat fileFormat) throws IOException {
		ModelAndView modelAndView = new ModelAndView("signatures-sets/form-magic", "fileFormat", fileFormat);
		MagicSignaturesSet signaturesSet = new MagicSignaturesSet(fileFormat.getOntology().getRelatedMagicNumberRecords(), fileFormat, true);
		modelAndView.addObject("signaturesSet", signaturesSet);
		return modelAndView;
	}

	
	@RequestMapping(value="/formats/{formatId}/signatures-sets", method = RequestMethod.POST, params="ARCHIVETEAM")
	public ModelAndView createArchiveteamSignaturesSet(@PathVariable("formatId") FileFormat fileFormat, @ModelAttribute @Valid FeaturedSignaturesSet signaturesSet, BindingResult result,
			RedirectAttributes redirect) throws IOException {
		if (result.hasErrors()) {
			return new ModelAndView("signatures-sets/form-archiveteam", "formErrors", result.getAllErrors());
		}
		featuredSignaturesSetService.setFormat(signaturesSet, fileFormat);
		signaturesSet = featuredSignaturesSetService.create(signaturesSet);
		
		redirect.addFlashAttribute("globalMessage", "Successfully imported pronom signatures set");
		ModelAndView modelAndView = new ModelAndView("redirect:/formats/{formatId}/signatures-sets/{signaturesSetId}", "signaturesSetId", signaturesSet.getId());
		modelAndView.addObject("formatId", fileFormat.getId());
		return modelAndView;
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets", method = RequestMethod.POST, params="PRONOM")
	public ModelAndView createPronomSignaturesSet(@PathVariable("formatId") FileFormat fileFormat, @ModelAttribute @Valid PronomSignaturesSet signaturesSet, BindingResult result,
			RedirectAttributes redirect) throws IOException {
		if (result.hasErrors()) {
			return new ModelAndView("signatures-sets/form-pronom", "formErrors", result.getAllErrors());
		}
		featuredSignaturesSetService.setFormat(signaturesSet, fileFormat);
		signaturesSet = (PronomSignaturesSet) featuredSignaturesSetService.createPronom(signaturesSet);
		
		redirect.addFlashAttribute("globalMessage", "Successfully created a new signatures set");
		ModelAndView modelAndView = new ModelAndView("redirect:/formats/{formatId}/signatures-sets/{signaturesSetId}", "signaturesSetId", signaturesSet.getId());
		modelAndView.addObject("formatId", fileFormat.getId());
		return modelAndView;
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets", method = RequestMethod.POST, params="FALSTAFF")
	//public ModelAndView createAlignedSignaturesSet(@RequestParam("samplesSetId") int samplesSetId, @PathVariable("formatId") FileFormat fileFormat, @ModelAttribute @Valid AlignedSignaturesSet signaturesSet, BindingResult result,
	//		RedirectAttributes redirect) throws IOException {
	public ModelAndView createAlignedSignaturesSet(@RequestParam("samplesSetId") int samplesSetId, @PathVariable("formatId") FileFormat fileFormat,	@ModelAttribute @Valid AlignerContext context, BindingResult result, RedirectAttributes redirect) throws IOException {

		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(samplesSetId);
		featuredSignaturesSetService.setFormat(context.getSignaturesSet(), fileFormat);
		featuredSignaturesSetService.createAligned(samplesSet, context);
		
		redirect.addFlashAttribute("globalMessage", "Successfully computed signatures set");
		ModelAndView modelAndView = new ModelAndView("redirect:/formats/{formatId}/signatures-sets/{signaturesSetId}", "signaturesSetId", context.getSignaturesSet().getId());
		modelAndView.addObject("formatId", fileFormat.getId());
		return modelAndView;
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets", method = RequestMethod.POST, params="MAGIC")
	public ModelAndView createMagicSignaturesSet(@PathVariable("formatId") FileFormat fileFormat, @ModelAttribute @Valid MagicSignaturesSet signaturesSet, BindingResult result,
			RedirectAttributes redirect) throws IOException {
		if (result.hasErrors()) {
			return new ModelAndView("signatures-sets/form-magic", "formErrors", result.getAllErrors());
		}
		featuredSignaturesSetService.setFormat(signaturesSet, fileFormat);
		signaturesSet = (MagicSignaturesSet) featuredSignaturesSetService.createMagic(signaturesSet);
		
		redirect.addFlashAttribute("globalMessage", "Successfully created a new signatures set");
		ModelAndView modelAndView = new ModelAndView("redirect:/formats/{formatId}/signatures-sets/{signaturesSetId}", "signaturesSetId", signaturesSet.getId());
		modelAndView.addObject("formatId", fileFormat.getId());
		return modelAndView;
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets/{signaturesSetId}", method = RequestMethod.GET)
	public ModelAndView viewSignaturesSet(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("signaturesSetId") String signaturesSetId) {
		FeaturedSignaturesSet signaturesSet = fileFormat.getSignaturesSet(new Integer(signaturesSetId));
		return new ModelAndView("signatures-sets/view", "signaturesSet", signaturesSet);
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets/{signaturesSetId}/signatures/monitor", method = RequestMethod.GET)
	public String viewSignaturesSetProgressStatus(Model model, @PathVariable("formatId") FileFormat fileFormat, @PathVariable("signaturesSetId") String signaturesSetId) {
		FeaturedSignaturesSet signaturesSet = fileFormat.getSignaturesSet(new Integer(signaturesSetId));
		model.addAttribute("processMonitor", signaturesSet.getProcessMonitor());		
		return "execution/process-view :: process";
	}
		
	@RequestMapping(value="/formats/{formatId}/signatures-sets/{signaturesSetId}", method = RequestMethod.POST, params="operation=delete")
	public ModelAndView deleteSignaturesSet(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("signaturesSetId") String signaturesSetId) throws IOException {
		FeaturedSignaturesSet signaturesSet = fileFormat.getSignaturesSet(new Integer(signaturesSetId));
		logger.warn("signature set " + signaturesSet.getName() + " will be deleted");
		fileFormat.clearSignaturesSet(new Integer(signaturesSetId));
		fileFormatService.save(fileFormat);
		return new ModelAndView("formats/view", "fileFormat", fileFormat);
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets/{signaturesSetId}", method = RequestMethod.POST, params="operation=update")
	public ModelAndView updateSignaturesSet(@PathVariable("formatId") FileFormat fileFormat, @ModelAttribute("signaturesSet") @Valid FeaturedSignaturesSet updatedSignaturesSet, @PathVariable("signaturesSetId") String signaturesSetId) throws IOException {
		FeaturedSignaturesSet signaturesSet = fileFormat.getSignaturesSet(new Integer(signaturesSetId));
		logger.info("signature set " + signaturesSet.getName() + " will be updated");
		signaturesSet.setName(updatedSignaturesSet.getName());
		signaturesSet.setDescription(updatedSignaturesSet.getDescription());
		featuredSignaturesSetService.save(signaturesSet);
		return new ModelAndView("signatures-sets/view", "signaturesSet", signaturesSet);
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets/{signaturesSetId}/signatures/{signatureId}", method = RequestMethod.GET)
	public ModelAndView viewSignature(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("signaturesSetId") String signaturesSetId, @PathVariable("signatureId") String signatureId) {
		FeaturedSignaturesSet signaturesSet = fileFormat.getSignaturesSet(new Integer(signaturesSetId));
		FeaturedSignature signature = signaturesSet.getSignature(new Integer(signatureId));
		featuredSignaturesSetService.signatureFormatCoverage(signature);
		return new ModelAndView("signatures/view", "signature", signature);
	}

	@RequestMapping(value="/formats/{formatId}/signatures-sets/{signaturesSetId}/signatures", method = RequestMethod.GET)
	public ModelAndView formSignature(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("signaturesSetId") String signaturesSetId) {
		FeaturedSignaturesSet signaturesSet = fileFormat.getSignaturesSet(new Integer(signaturesSetId));
		FeaturedSignature signature = new FeaturedSignature(signaturesSet);
		return new ModelAndView("signatures/create", "signature", signature);
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets/{signaturesSetId}/signatures", method = RequestMethod.POST)
	public ModelAndView createSignature(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("signaturesSetId") String signaturesSetId, @ModelAttribute("signature") @Valid FeaturedSignature signature, BindingResult result,
			RedirectAttributes redirect) throws IOException {
		FeaturedSignaturesSet signaturesSet = fileFormat.getSignaturesSet(new Integer(signaturesSetId));
		featuredSignaturesSetService.createSignature(signaturesSet, signature);
		return new ModelAndView("signatures/view", "signature", signature);
	}

	@RequestMapping(value="/formats/{formatId}/signatures-sets/{signaturesSetId}/signatures/{signatureId}", method = RequestMethod.POST, params="operation=delete")
	public ModelAndView deleteSignature(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("signaturesSetId") String signaturesSetId, @PathVariable("signatureId") String signatureId) throws IOException {
		FeaturedSignaturesSet signaturesSet = fileFormat.getSignaturesSet(new Integer(signaturesSetId));
		FeaturedSignature signature = signaturesSet.getSignature(new Integer(signatureId));
		logger.warn("signature " + signature.getSignature().getRegularExpression() + " from signature set " + signaturesSet.getName() + " will be deleted");
		signaturesSet.clearSignature(signature.getId());
		signaturesSet.setUpdated(Calendar.getInstance());
		featuredSignaturesSetService.save(signaturesSet);
		return new ModelAndView("signatures-sets/view", "signaturesSet", signaturesSet);
	}
	
	@RequestMapping(value="/formats/{formatId}/signatures-sets/{signaturesSetId}/signatures/{signatureId}", method = RequestMethod.POST, params="operation=update")
	public ModelAndView updateSignature(@PathVariable("formatId") FileFormat fileFormat, @ModelAttribute("signature") @Valid FeaturedSignature updatedSignature, @PathVariable("signaturesSetId") String signaturesSetId, @PathVariable("signatureId") String signatureId) throws IOException {
		FeaturedSignaturesSet signaturesSet = fileFormat.getSignaturesSet(new Integer(signaturesSetId));
		FeaturedSignature signature = signaturesSet.getSignature(new Integer(signatureId));
		logger.info("signature " + signature.getSignature().getRegularExpression() + " from signature set " + signaturesSet.getName() + " will be updated");
		signature.getSignature().setRegularExpression(updatedSignature.getSignature().getRegularExpression());
		signature.getSignature().normalizeRegularExpression();
		signature.getSignature().resetFeatureSignatures();
		signaturesSet.setUpdated(Calendar.getInstance());
		featuredSignaturesSetService.save(signaturesSet);
		return new ModelAndView("signatures/view", "signature", signature);
	}

}
