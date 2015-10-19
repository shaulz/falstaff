package com.falstaff.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.falstaff.core.classification.FeaturedClassifier;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.classification.FormatQuery;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.repository.dao.FeaturedClassifierDao;
import com.falstaff.service.FileFormatService.ClassifiedFileFormatOntologyFirstGroup;
import com.falstaff.service.FileFormatService.ClassifiedFileFormatOntologySecondGroup;

@Service
public class FeaturedClassifierService {
	
	private static final Logger log = LoggerFactory
			.getLogger(FeaturedClassifierService.class.getName());

	
	@Autowired
	FeaturedSignaturesSetService featuredSignaturesSetService;
	
	@Autowired
	private OntologyService ontologyService;
	
	@Autowired
	private FileFormatService formatService;
	
	@Autowired
	private FeaturedClassifierDao classifierDao;
	
	@Autowired
	private AsyncTrainer asyncTrainer;
	
	@Value("${falstaff.core.service.simulated_features_number}")
	private int simulatedFeaturesNumber;
	
	@Value("${falstaff.core.service.alignment_ktup_length}")
	private int alignmentKtupLength;
	
	@Value("${falstaff.core.service.classifications_bulk_size}")
	private int classificationsBulkSize;
	
	@Value("${falstaff.core.service.classifications_result_cutoff}")
	private double classificationResultCutoff;

	public void train(FeaturedClassifier classifier) throws IOException {
		try {
			classifier.getRwl().writeLock().lock();
			ProcessMonitor processMonitor = new ProcessMonitor();
			processMonitor.setProcessName("train");
			classifier.setProcessMonitor(processMonitor);
			asyncTrainer.train(classifier);
		} catch (Exception e) {
			log.error("train of classifier " + classifier.getName() + " failed " + e);
		}
		finally {
			classifier.getRwl().writeLock().unlock();
		}
		
	}
	
	public void test(FeaturedClassifier classifier) throws IOException {
		try {
			classifier.getRwl().writeLock().lock();
			ProcessMonitor processMonitor = new ProcessMonitor();
			processMonitor.setProcessName("test");
			classifier.setProcessMonitor(processMonitor);
			asyncTrainer.test(classifier);
		} catch (Exception e) {
			log.error("test of classifier " + classifier.getName() + " failed " + e);
		}
		finally {
			classifier.getRwl().writeLock().unlock();
		}
		
	}
	
	public void save(FeaturedClassifier classifier) {
		classifierDao.save(classifier);
	}

	public FeaturedClassifier read(FeaturedClassifier classifier) {
		return classifierDao.read(classifier);
	}
	
	public FeaturedClassifier delete(FeaturedClassifier classifier) {
		return classifierDao.delete(classifier);
	}

	public List<FeaturedClassifier> readAll() {
		return classifierDao.readAll();
	}
	
	public Map<ClassifiedFileFormatOntologyFirstGroup, Map<ClassifiedFileFormatOntologySecondGroup,List<FileFormat>>> getFormatsTree(FeaturedClassifier classifier) {
		return formatService.getFormatsTree(new HashSet<FileFormat>(classifier.getFormats()), true);
	}
	
	public Map<ClassifiedFileFormatOntologyFirstGroup, Map<ClassifiedFileFormatOntologySecondGroup,List<FileFormat>>> getFormatsAddTree(FeaturedClassifier classifier) {
		return formatService.getFormatsTree(new HashSet<FileFormat>(classifier.getFormats()), false);
	}

	public FeaturedClassifier get(String name) {
		return classifierDao.get(name);
	}

	public void create(FeaturedClassifier classifier) {
		classifier.setCreated(Calendar.getInstance());
		classifierDao.create(classifier);
	}

	public void addFormat(FeaturedClassifier classifier, String formatName) throws IOException {
		FormatQuery formatQuery = new FormatQuery();
		formatQuery.setName(formatName);
		FileFormat format = formatService.searchFormats(formatQuery).get(0);
		FeaturedClassifier formatClassifier = format.getClassifier();
		if (formatClassifier != null) {
			formatClassifier.deleteFormat(format);
		}
		format.setClassifier(classifier);
		formatService.save(format);
		classifier.addFormat(format);
	}

	public void deleteFormat(FeaturedClassifier classifier, String formatName) throws IOException {
		FileFormat format = classifier.deleteFormat(formatName);
		if (format != null) {
			format.setClassifier(null);
		}
		formatService.save(format);
	}
}
