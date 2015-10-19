package com.falstaff.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.core.ontology.MagicNumbers;
import com.falstaff.core.ontology.MagicNumbers.MagicNumberRecord;
import com.falstaff.core.ontology.MagicNumbers.MagicNumberRecord.MagicOntologyRelation;
import com.falstaff.core.ontology.MagicNumbers.OntologyMagicRelations;
import com.falstaff.core.ontology.MagicNumbers.OntologyMagicRelations.OntologyMagicRecord;
import com.falstaff.crawler.MagicNumberCrawler;
import com.falstaff.repository.dao.MagicNumbersDao;

@Service
public class MagicNumberService {
	
	private static final Logger log = LoggerFactory
	.getLogger(MagicNumberService.class.getName());

	@Autowired
	private MagicNumbersDao magicNumbersDao;
	
	@Autowired
	private MagicNumberCrawler magicNumberCrawler;
	
	@Autowired
	private OntologyService ontologyService;

	public MagicNumbers getMagicNumbers() {
		return magicNumbersDao.getMagicNumbers();
	}
	
	public void saveMagicNumbers() throws IOException {
		magicNumbersDao.save();
	}
	
	public void create() throws IOException {
		magicNumberCrawler.run();
		MagicNumbers magicNumbers = magicNumberCrawler.getMagicNumbers();
		magicNumbers.setUpdateDate(Calendar.getInstance());
		magicNumbersDao.setMagicNumbers(magicNumbers);
	}

	public void linkMagic(FileFormatOntology ontology, OntologyMagicRelations updatedRelations) throws IOException {
		OntologyMagicRelations relations = ontology.getMagicRelations();
		relations.setVerified(true);
		MagicNumbers magicNumbers = magicNumbersDao.getMagicNumbers();
		for (OntologyMagicRecord updatedRelation : updatedRelations.getRelations()) {
			for (OntologyMagicRecord relation : relations.getRelations()) {
				if (updatedRelation.getMagicNumberRecord().getId() == relation.getMagicNumberRecord().getId()) {
					relation.setRelated(updatedRelation.getRelated());
					relation.setInOntologyDescription(updatedRelation.getInOntologyDescription());
					MagicNumberRecord magicNumberRecord = magicNumbers.getMagicNumber(updatedRelation.getMagicNumberRecord().getId());
					MagicOntologyRelation magicOntologyRelation = magicNumberRecord.getOntologyRelation(ontology.getName());
					magicOntologyRelation.setRelated(updatedRelation.getRelated());
					magicOntologyRelation.setInOntologyDescription(updatedRelation.getInOntologyDescription());
					magicOntologyRelation.setVerified(true);
				}
			}
		}
		
		magicNumbersDao.save();
	}
	
	public void addOntologyRelated(FileFormatOntology fileFormatOntology) throws IOException {
		boolean updated = getMagicNumbers().addOntologyRelated(fileFormatOntology);
		if (updated) {
			saveMagicNumbers();
		}
		
		OntologyMagicRelations relation = getMagicNumbers().getOntologyRelated(fileFormatOntology);
		fileFormatOntology.setMagicRelations(relation);
	}
	
	public void deleteOntologyRelated(FileFormatOntology fileFormatOntology) throws IOException {
		boolean deleted = getMagicNumbers().deleteOntologyRelated(fileFormatOntology);
		if (deleted) {
			saveMagicNumbers();
		}
	}
	
}

