package com.falstaff.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.falstaff.core.ontology.MagicNumbers;
import com.falstaff.service.MagicNumberService;
import com.falstaff.service.OntologyService;

@Controller
public class MagicNumberController {

	@Autowired
	OntologyService ontologyService;

	@Autowired
	MagicNumberService magicNumberService;
	
	@RequestMapping(value="/rest/magic", method = RequestMethod.GET)
    @ResponseBody
    public MagicNumbers getMagicNumbers() {
        return magicNumberService.getMagicNumbers();
    }

}
