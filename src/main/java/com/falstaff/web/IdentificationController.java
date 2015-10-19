/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.falstaff.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.falstaff.Identification;
import com.falstaff.IdentificationBulk;
import com.falstaff.core.alignable.sequence.NClassifiedFormatFile;
import com.falstaff.core.classification.FeaturedClassifier;
import com.falstaff.core.classification.IdentificationBatch;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.classification.IdentificationRequest;
import com.falstaff.core.classification.IdentificationResponse;
import com.falstaff.service.FileFormatService;
import com.falstaff.service.IdentificationService;

@Controller
@RequestMapping("/")
public class IdentificationController {
	
	@Autowired
	IdentificationService identificationService;
	
	private static final Logger logger = LoggerFactory.getLogger(IdentificationController.class.getName());

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView identifications() {
		return formIdentification();
	}
	
	@RequestMapping(value="/identifications", method = RequestMethod.GET)
	public ModelAndView formIdentification() {
		ModelAndView modelAndView = new ModelAndView("identifications/create");
		modelAndView.addObject("alignableSequenceLength", identificationService.getAlignableSequenceLength());
		return modelAndView;
	}

	@RequestMapping(value="/classifiers/{classifierId}/identifications", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public IdentificationResponse createIdentification(@PathVariable("classifierId") FeaturedClassifier classifier, MultipartHttpServletRequest mrequest) throws UnsupportedEncodingException {		
		IdentificationBatch identificationBatch = identificationService.createIdentification(classifier);
		addAlignables(mrequest, identificationBatch);
		identificationService.identify(identificationBatch);
		IdentificationResponse response = identificationBatch.getIdentificationResponse(0);
		return response;
	}
	
	@RequestMapping(value="/rest/classifiers/{classifierId}/identifications", method = RequestMethod.POST)
	@ResponseBody
	public IdentificationResponse createIdentification(@PathVariable("classifierId") FeaturedClassifier classifier, @RequestBody List<File> files) throws UnsupportedEncodingException {		
		IdentificationBatch identificationBatch = identificationService.createIdentification(classifier);
		addAlignables(files, identificationBatch);
		identificationService.identify(identificationBatch);
		IdentificationResponse response = identificationBatch.getIdentificationResponse(0);
		return response;
	}

	@RequestMapping(value="/classifiers/{classifierId}/identifications/{identificationId}", method = RequestMethod.POST, produces = "application/json; charset=UTF-8", params="operation=update")
	@ResponseBody
	public IdentificationResponse updateIdentification(@PathVariable("classifierId") FeaturedClassifier classifier, @PathVariable("identificationId") IdentificationBatch identificationBatch, @RequestParam("from") int from, MultipartHttpServletRequest mrequest) throws UnsupportedEncodingException {
		addAlignables(mrequest, identificationBatch);
		identificationService.identify(identificationBatch);
		IdentificationResponse response = identificationBatch.getIdentificationResponse(from);
		return response;
	}
	
	@RequestMapping(value="/classifiers/{classifierId}/identifications/{identificationId}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8", params="operation=read")
	@ResponseBody
	public IdentificationResponse readIdentification(@PathVariable("classifierId") FeaturedClassifier classifier, @PathVariable("identificationId") IdentificationBatch identificationBatch, @RequestParam("from") int from) {
		IdentificationResponse response = identificationBatch.getIdentificationResponse(from);
		return response;
	}
	
	private void addAlignables(MultipartHttpServletRequest mrequest, IdentificationBatch identificationBatch) throws UnsupportedEncodingException {
		mrequest.setCharacterEncoding("UTF-8");
		Map<String, MultipartFile> fileMap = mrequest.getFileMap();
		logger.info("received identification request with " + fileMap.size() + " files with encoding " + mrequest.getCharacterEncoding());
		for (String name : fileMap.keySet()) {
			MultipartFile multipartFile = fileMap.get(name);
			try {
				byte[] bytes = multipartFile.getBytes();
				String originalName = multipartFile.getOriginalFilename();
				long modificationDate = new Long(mrequest.getParameter(name + ".modificationDate"));
				Date date = new Date(modificationDate);
				String formatted = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				String sizeString = mrequest.getParameter(name + ".originalSize");
				Long originalSize = new Long(sizeString);
				logger.info(" size = " + bytes.length + " original name " + originalName + " modificationDate " + formatted + " original size " + originalSize);
				IdentificationRequest identification = new IdentificationRequest(bytes, originalName, originalSize, modificationDate);
				identificationBatch.addAlignable(identification);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
	
	private void addAlignables(List<File> files,
			IdentificationBatch identificationBatch) {
		for (File file : files) {
			NClassifiedFormatFile classifiedFormatFile = new NClassifiedFormatFile(file);
			identificationBatch.addAlignable(classifiedFormatFile);
		}
		
	}

}
