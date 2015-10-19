package com.falstaff.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.core.ontology.Ontology;
import com.falstaff.repository.dao.OntologyDao;

@Service
public class OntologyService {

	@Autowired
	private OntologyDao ontologyDao;

	public Ontology getOntology() {
		return ontologyDao.getOntology();
	}
	
	public FileFormatOntology getOntology(String ontologyName) {
		Ontology ontology = getOntology();
		return ontology.getByName(ontologyName);
	}
	
	public void saveOntology() throws IOException {
		ontologyDao.save();
	}
}
