package com.falstaff.repository.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.classification.FeaturedClassifier;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.repository.ds.FlatDS;

@Component
public class FeaturedClassifierDao implements Converter<String, FeaturedClassifier> {

	private static final Logger log = LoggerFactory
	.getLogger(FeaturedClassifierDao.class.getName());
	
	@Autowired
	private FlatDS flatDS;
	
	@Autowired
	private FileFormatDao formatDao;
	
	private List<FeaturedClassifier> classifiers;
	
	@PostConstruct
	public void init() {
		
		/*
		List<FileFormat> allFormats = formatDao.getFormats();
		Set<FileFormat> formats = new HashSet<FileFormat>();
		for (FileFormat format : allFormats) {
			if (!format.getName().equals(format.getOntology().getName())) {
				continue;
			}
			formats.add(format);
		}
		FeaturedClassifier falstaff = new FeaturedClassifier("falstaff", 4, 0.1, formats);
		falstaff.setCreated(Calendar.getInstance());
		falstaff.setUpdated(falstaff.getCreated());
		save(falstaff);
		*/
		
		readAll();
		
		for (FeaturedClassifier classifier : classifiers) {
			classifier.setRwl(new ReentrantReadWriteLock());
		}
		
		// set signatures ids
		for (FeaturedClassifier classifier : classifiers) {
			Set<NSignature> signatures = classifier.getSignatures();
			if (signatures == null) {
				continue;
			}
			for (NSignature signature : signatures) {
				signature.setSignatureId();
			}
		}
		
		// set formats classifiers
		for (FileFormat fileFormat : formatDao.getFormats()) {
			String classifierName = fileFormat.getClassifierName();
			if (classifierName == null) {
				//log.warn("file format " + fileFormat.getName() + " has no classifier assigned");
				continue;
			}
			for (FeaturedClassifier classifier : classifiers) {
				if (classifierName.equals(classifier.getName())) {
					fileFormat.setClassifier(classifier);
					//log.info("file format " + fileFormat.getName() + " is classified by " + classifier.getId());
					classifier.addFormat(fileFormat);
				}
			}
		}
		
		// set new formats classifiers
		for (FileFormat fileFormat : formatDao.getNewFormats()) {
			fileFormat.setClassifierName("falstaff");
			String classifierName = fileFormat.getClassifierName();
			if (classifierName == null) {
				continue;
			}
			for (FeaturedClassifier classifier : classifiers) {
				if (classifierName.equals(classifier.getName())) {
					fileFormat.setClassifier(classifier);
				}
			}
		}		
		// set feature assigner
		for (FeaturedClassifier classifier : classifiers) {
			classifier.setFeatureAssigner();
		}
	}
	
	public void create(FeaturedClassifier classifier) {
		save(classifier);
		classifiers.add(classifier);
	}
	
	public void save(FeaturedClassifier classifier) {
		File path = flatDS.classifierPath(classifier);
		File dataPath = flatDS.classifierDataPath(classifier);
		try {
			flatDS.save(classifier, path);
			FileOutputStream fos = new FileOutputStream(dataPath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(classifier.getWeights());
			oos.close();
		} catch (IOException e) {
			log.error("failed to create classifier " + path + e.getMessage());	
		}
	}
		
	public FeaturedClassifier read(FeaturedClassifier classifier) {
		
		File path = flatDS.classifierPath(classifier);
		File dataPath = flatDS.classifierDataPath(classifier);
		
		FeaturedClassifier savedClassifier = (FeaturedClassifier)flatDS.read(path);
		FileInputStream fis;
		try {
			fis = new FileInputStream(dataPath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			double weights[][] = (double[][])ois.readObject();
			fis.close();
			savedClassifier.setWeights(weights);
		} catch (IOException | ClassNotFoundException e) {
			log.error("failed to read classifier " + path + e.getMessage());
			return null;	
		}

		return savedClassifier;
	}
	
	public FeaturedClassifier delete(FeaturedClassifier classifier) {
		File path = flatDS.classifierPath(classifier);
		File dataPath = flatDS.classifierDataPath(classifier);

		FeaturedClassifier savedClassifier = (FeaturedClassifier)flatDS.read(path);
		try {
			flatDS.delete(path);
			flatDS.delete(dataPath);
		} catch (IOException e) {
			log.error("failed to delete classifier " + path + e.getMessage());
			return null;
		}
		return savedClassifier;
	}
	
	public List<FeaturedClassifier> readAll() {
		if (classifiers != null) {
			return classifiers;
		}
		classifiers = new LinkedList<FeaturedClassifier>();
		List<String> classifiersNames = flatDS.getClassifiersNames();
		for (String classifierName : classifiersNames) {
			FeaturedClassifier classifier = new FeaturedClassifier(classifierName);
			classifiers.add(read(classifier));
		}
		
		Collections.sort(classifiers, new Comparator<FeaturedClassifier>() {
	        @Override
	        public int compare(final FeaturedClassifier c1, final FeaturedClassifier c2) {
	            int result = c1.getName().compareTo(c2.getName());
	            return result;
	        }
	    } );
		
		return classifiers;
	}

	@Override
	public FeaturedClassifier convert(String source) {
		Long id = new Long(source);
		return get(id);
	}
	
	public FeaturedClassifier get(long id) {
		for (FeaturedClassifier classifier : classifiers) {
			if (classifier.getId() == id) {
				return classifier;
			}
		}
		return null;
	}
	
	public FeaturedClassifier get(String name) {
		for (FeaturedClassifier classifier : classifiers) {
			if (classifier.getName().equals(name)) {
				return classifier;
			}
		}
		return null;
	}

}
