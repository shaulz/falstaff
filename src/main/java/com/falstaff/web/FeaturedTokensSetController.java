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
import com.falstaff.core.classification.FeaturedTokensSet;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.feature.TokenFeature;
import com.falstaff.service.FeaturedTokensSetService;
import com.falstaff.service.FileFormatService;
import com.falstaff.service.LexerContext;

@Controller
public class FeaturedTokensSetController {

	@Autowired
	FileFormatService fileFormatService;
	
	@Autowired
	FeaturedTokensSetService featuredTokensSetService;
	
	private static final Logger logger = LoggerFactory.getLogger(FeaturedTokensSetController.class.getName());
		
	@RequestMapping(value="/formats/{formatId}/tokens-sets", method = RequestMethod.GET)
	public ModelAndView formFeaturedTokensSet(@RequestParam("samplesSetId") int samplesSetId, @PathVariable("formatId") FileFormat fileFormat) throws IOException {
		ModelAndView modelAndView = new ModelAndView("tokens-sets/form", "fileFormat", fileFormat);
		modelAndView.addObject("samplesSetId", samplesSetId);
		LexerContext context = featuredTokensSetService.defaultLexerContext(fileFormat.getSamplesSet(samplesSetId));
		modelAndView.addObject("context", context);
		return modelAndView;
	}
		
	@RequestMapping(value="/formats/{formatId}/tokens-sets", method = RequestMethod.POST)
	//public ModelAndView createAlignedTokensSet(@RequestParam("samplesSetId") int samplesSetId, @PathVariable("formatId") FileFormat fileFormat, @ModelAttribute @Valid AlignedTokensSet tokensSet, BindingResult result,
	//		RedirectAttributes redirect) throws IOException {
	public ModelAndView createTokensSet(@RequestParam("samplesSetId") int samplesSetId, @PathVariable("formatId") FileFormat fileFormat,	@ModelAttribute @Valid LexerContext context, BindingResult result, RedirectAttributes redirect) throws IOException {

		FeaturedSamplesSet samplesSet = fileFormat.getSamplesSet(samplesSetId);
		featuredTokensSetService.setFormat(context.getTokensSet(), fileFormat);
		featuredTokensSetService.lex(samplesSet, context);
		
		redirect.addFlashAttribute("globalMessage", "Successfully lexed tokens set");
		ModelAndView modelAndView = new ModelAndView("redirect:/formats/{formatId}/tokens-sets/{tokensSetId}", "tokensSetId", context.getTokensSet().getId());
		modelAndView.addObject("formatId", fileFormat.getId());
		return modelAndView;
	}
	
	@RequestMapping(value="/formats/{formatId}/tokens-sets/{tokensSetId}", method = RequestMethod.GET)
	public ModelAndView viewTokensSet(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("tokensSetId") String tokensSetId) {
		FeaturedTokensSet tokensSet = fileFormat.getTokensSet(new Integer(tokensSetId));
		return new ModelAndView("tokens-sets/view", "tokensSet", tokensSet);
	}
	
	@RequestMapping(value="/formats/{formatId}/tokens-sets/{tokensSetId}/tokens/monitor", method = RequestMethod.GET)
	public String viewTokensSetProgressStatus(Model model, @PathVariable("formatId") FileFormat fileFormat, @PathVariable("tokensSetId") String tokensSetId) {
		FeaturedTokensSet tokensSet = fileFormat.getTokensSet(new Integer(tokensSetId));
		model.addAttribute("processMonitor", tokensSet.getProcessMonitor());		
		return "execution/process-view :: process";
	}
		
	@RequestMapping(value="/formats/{formatId}/tokens-sets/{tokensSetId}", method = RequestMethod.POST, params="operation=delete")
	public ModelAndView deleteTokensSet(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("tokensSetId") String tokensSetId) throws IOException {
		FeaturedTokensSet tokensSet = fileFormat.getTokensSet(new Integer(tokensSetId));
		logger.warn("token set " + tokensSet.getName() + " will be deleted");
		fileFormat.clearTokensSet(new Integer(tokensSetId));
		fileFormatService.save(fileFormat);
		return new ModelAndView("formats/view", "fileFormat", fileFormat);
	}
	
	@RequestMapping(value="/formats/{formatId}/tokens-sets/{tokensSetId}", method = RequestMethod.POST, params="operation=update")
	public ModelAndView updateTokensSet(@PathVariable("formatId") FileFormat fileFormat, @ModelAttribute("tokensSet") @Valid FeaturedTokensSet updatedTokensSet, @PathVariable("tokensSetId") String tokensSetId) throws IOException {
		FeaturedTokensSet tokensSet = fileFormat.getTokensSet(new Integer(tokensSetId));
		logger.info("token set " + tokensSet.getName() + " will be updated");
		tokensSet.setName(updatedTokensSet.getName());
		tokensSet.setDescription(updatedTokensSet.getDescription());
		featuredTokensSetService.save(tokensSet);
		return new ModelAndView("tokens-sets/view", "tokensSet", tokensSet);
	}
	
	@RequestMapping(value="/formats/{formatId}/tokens-sets/{tokensSetId}/tokens/{tokenId}", method = RequestMethod.GET)
	public ModelAndView viewToken(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("tokensSetId") String tokensSetId, @PathVariable("tokenId") String tokenId) {
		FeaturedTokensSet tokensSet = fileFormat.getTokensSet(new Integer(tokensSetId));
		TokenFeature token = tokensSet.getTokenFeature(new Integer(tokenId));
		return new ModelAndView("tokens/view", "token", token);
	}

	@RequestMapping(value="/formats/{formatId}/tokens-sets/{tokensSetId}/tokens", method = RequestMethod.GET)
	public ModelAndView formToken(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("tokensSetId") String tokensSetId) {
		FeaturedTokensSet tokensSet = fileFormat.getTokensSet(new Integer(tokensSetId));
		TokenFeature token = new TokenFeature("");
		return new ModelAndView("tokens/create", "token", token);
	}
	
	@RequestMapping(value="/formats/{formatId}/tokens-sets/{tokensSetId}/tokens", method = RequestMethod.POST)
	public ModelAndView createToken(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("tokensSetId") String tokensSetId, @ModelAttribute("token") @Valid TokenFeature token, BindingResult result,
			RedirectAttributes redirect) throws IOException {
		FeaturedTokensSet tokensSet = fileFormat.getTokensSet(new Integer(tokensSetId));
		featuredTokensSetService.createTokenFeature(tokensSet, token);
		return new ModelAndView("tokens/view", "token", token);
	}

	@RequestMapping(value="/formats/{formatId}/tokens-sets/{tokensSetId}/tokens/{tokenId}", method = RequestMethod.POST, params="operation=delete")
	public ModelAndView deleteToken(@PathVariable("formatId") FileFormat fileFormat, @PathVariable("tokensSetId") String tokensSetId, @PathVariable("tokenId") String tokenId) throws IOException {
		FeaturedTokensSet tokensSet = fileFormat.getTokensSet(new Integer(tokensSetId));
		TokenFeature token = tokensSet.getTokenFeature(new Integer(tokenId));
		logger.warn("token " + token.getName() + " from token set " + tokensSet.getName() + " will be deleted");
		tokensSet.clearTokenFeature(token.getId());
		tokensSet.setUpdated(Calendar.getInstance());
		featuredTokensSetService.save(tokensSet);
		return new ModelAndView("tokens-sets/view", "tokensSet", tokensSet);
	}
	
	@RequestMapping(value="/formats/{formatId}/tokens-sets/{tokensSetId}/tokens/{tokenId}", method = RequestMethod.POST, params="operation=update")
	public ModelAndView updateToken(@PathVariable("formatId") FileFormat fileFormat, @ModelAttribute("token") @Valid TokenFeature updatedToken, @PathVariable("tokensSetId") String tokensSetId, @PathVariable("tokenId") String tokenId) throws IOException {
		FeaturedTokensSet tokensSet = fileFormat.getTokensSet(new Integer(tokensSetId));
		TokenFeature token = tokensSet.getTokenFeature(new Integer(tokenId));
		logger.info("token " + token.getName() + " from token set " + tokensSet.getName() + " will be updated");
		token.setName(updatedToken.getName());
		tokensSet.setUpdated(Calendar.getInstance());
		featuredTokensSetService.save(tokensSet);
		return new ModelAndView("tokens/view", "token", token);
	}

}
