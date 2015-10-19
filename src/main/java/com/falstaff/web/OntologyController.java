package com.falstaff.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.service.OntologyService;

@Controller
public class OntologyController {
	
	@Autowired
	OntologyService ontologyService;

	@RequestMapping(value="/rest/ontology", method = RequestMethod.GET, params="name")
    @ResponseBody
    public FileFormatOntology getFileFormatOntology(@RequestParam("name") String name) {
        return ontologyService.getOntology(name);
    }

}
