package com.falstaff.repository.dao;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.core.ontology.MagicNumbers;
import com.falstaff.core.ontology.MagicNumbers.MagicNumberRecord;
import com.falstaff.core.ontology.MagicNumbers.OntologyMagicRelations;
import com.falstaff.repository.ds.FlatDS;

@Component
public class MagicNumbersDao {

	private static final Logger log = LoggerFactory
	.getLogger(MagicNumbersDao.class.getName());
	
	@Autowired
	private FlatDS flatDS;	
	
	@Autowired
	private OntologyDao ontologyDao;
	
	private MagicNumbers magicNumbers;
	
	@PostConstruct
	public void init() throws IOException {
		magicNumbers = (MagicNumbers)flatDS.read(flatDS.magicNumbersPath(FlatDS.magicNumbersFile));
		if (magicNumbers != null) {
			magicNumbers.setRwl(new ReentrantReadWriteLock());
		}
		
		for (int i = 0; i < magicNumbers.getMagicNumbers().size(); i++) {
			magicNumbers.getMagicNumbers().get(i).setId(i);
		}
		
		// update ontologies
		boolean updated = magicNumbers.setOntologyRelated(ontologyDao.getOntology());
		if (updated) {
			save();
		}
		
		for (FileFormatOntology fileFormatOntology : ontologyDao.getOntology().getOntologies()) {
			OntologyMagicRelations ontologyRelated = magicNumbers.getOntologyRelated(fileFormatOntology);
			fileFormatOntology.setMagicRelations(ontologyRelated);	
		}
	}

	public MagicNumbers getMagicNumbers() {
		return magicNumbers;
	}

	public synchronized void setMagicNumbers(MagicNumbers magicNumbers) throws IOException {
		this.magicNumbers = magicNumbers;
		flatDS.save(magicNumbers, flatDS.magicNumbersPath(FlatDS.magicNumbersFile));
	}
	
	public void save() throws IOException {
		flatDS.save(magicNumbers, flatDS.magicNumbersPath(FlatDS.magicNumbersFile));
	}
	
}