package com.falstaff.repository.dao;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.falstaff.repository.ds.FlatDS;
import com.falstaff.core.ontology.Ontology;

@Component
public class OntologyDao {

	private static final Logger log = LoggerFactory
	.getLogger(OntologyDao.class.getName());
	
	@Autowired
	private FlatDS flatDS;	
	
	private Ontology ontology;
	
	@PostConstruct
	public void init() {
		ontology = (Ontology)flatDS.read(flatDS.ontologyPath(FlatDS.ontologyFile));
		ontology.setRwl(new ReentrantReadWriteLock());
	}

	public Ontology getOntology() {
		return ontology;
	}

	public synchronized void setOntology(Ontology ontology) throws IOException {
		this.ontology = ontology;
		flatDS.save(ontology, flatDS.ontologyPath(FlatDS.ontologyFile));
	}
	
	public void save() throws IOException {
		flatDS.save(ontology, flatDS.ontologyPath(FlatDS.ontologyFile));
	}
	
}
