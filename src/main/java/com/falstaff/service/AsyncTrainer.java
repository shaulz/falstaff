package com.falstaff.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.classification.FeaturedClassifier;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.execution.ProcessStatus;
import com.falstaff.core.ontology.Ontology;
import com.falstaff.repository.dao.FeaturedClassifierDao;

@Component
public class AsyncTrainer {

	private static final Logger log = LoggerFactory
			.getLogger(AsyncTrainer.class.getName());
	
	@Autowired
	FeaturedSignaturesSetService featuredSignaturesSetService;
	
	@Autowired
	private OntologyService ontologyService;
	
	@Autowired
	private FileFormatService formatService;
	
	@Autowired
	private FeaturedClassifierDao classifierDao;
	
	@Value("${falstaff.core.service.simulated_features_number}")
	private int simulatedFeaturesNumber;
	
	@Value("${falstaff.core.service.alignment_ktup_length}")
	private int alignmentKtupLength;
	
	@Value("${falstaff.core.service.classifications_bulk_size}")
	private int classificationsBulkSize;
	
	@Value("${falstaff.core.service.classifications_result_cutoff}")
	private double classificationResultCutoff;

	@Async
	public void train(FeaturedClassifier classifier) throws IOException {
		try {
			classifier.getRwl().writeLock().lock();
			Ontology ontology = ontologyService.getOntology();
			Set<Integer> fileFixedSizes = ontology.getFileFixedSizes();
			Set<Pattern> fileNamePatterns = ontology.getFileNamePatterns();
			classifier.train(simulatedFeaturesNumber, classificationsBulkSize, alignmentKtupLength, classificationResultCutoff, fileFixedSizes, fileNamePatterns);
	
			// save formats
			Collection<FileFormat> formats = classifier.getFormats();
			for (FileFormat format : formats) {
				formatService.save(format);
			}
			
			// save classifier
			save(classifier);
			log.info("train of classifier " + classifier.getName() + " completed successfully");
			classifier.getProcessMonitor().setStatus(ProcessStatus.FINISHED);
		} catch (Exception e) {
			log.error("train of classifier " + classifier.getName() + " failed " + e);
		}
		finally {
			classifier.getRwl().writeLock().unlock();
		}
	}
	
	public void save(FeaturedClassifier classifier) {
		classifierDao.save(classifier);
	}

	@Async
	public void test(FeaturedClassifier classifier) throws IOException {
		classifier.test(classificationsBulkSize);

		// save formats
		Collection<FileFormat> formats = classifier.getFormats();
		for (FileFormat format : formats) {
			formatService.save(format);
		}
		
		// save classifier
		save(classifier);
		log.info("test of classifier " + classifier.getName() + " completed successfully");
		classifier.getProcessMonitor().setStatus(ProcessStatus.FINISHED);
	}

}
