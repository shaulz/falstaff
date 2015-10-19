package com.falstaff.core.classification;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults.ClassificationResult;
import com.falstaff.core.classification.IdentificationResponse.IdentificationResult;
import com.falstaff.core.classification.IdentificationResponse.IdentificationResult.Identification;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.util.IdGenerator;

public class IdentificationBatch {
	
	private static final Logger log = LoggerFactory
			.getLogger(IdentificationBatch.class.getName());

	private List<IIdentifiableAlignable> alignables;
	private List<IIdentifiableAlignable> identifications;
	private long id;
	private FeaturedClassifier classifier;
	private ReentrantReadWriteLock alignablesLock = new ReentrantReadWriteLock();
	private ReentrantReadWriteLock identificationsLock = new ReentrantReadWriteLock();
	private int bulkIndex;
	private Calendar created;
	private int bulkSize;
	
	public IdentificationBatch(FeaturedClassifier classifier, int bulkSize) {
		this.classifier = classifier;
		this.bulkSize = bulkSize;
		id = IdGenerator.getIdGenerator().getId(IdentificationBatch.class.getName());
		alignables = new LinkedList<IIdentifiableAlignable>();
		identifications = new LinkedList<IIdentifiableAlignable>();
		bulkIndex = 0;
		created = Calendar.getInstance();
		log.info("batch " + id + " was created");
	}
	
	public class IdentificationBulk {
		private int startIndex;
		private int endIndex;
		
		public IdentificationBulk(int startIndex, int endIndex) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			log.info("batch " + id + " bulk from " + startIndex + " to " + endIndex + " was created");
		}

		public int getStartIndex() {
			return startIndex;
		}

		public int getEndIndex() {
			return endIndex;
		}
		
		public List<IIdentifiableAlignable> getAlignables() {
			List<IIdentifiableAlignable> bulkAlignables;
			alignablesLock.readLock().lock();
			try {
				bulkAlignables = new LinkedList<IIdentifiableAlignable>(alignables.subList(startIndex, endIndex));
			}
			finally {
				alignablesLock.readLock().unlock();
			}
			return bulkAlignables;
		}
		
		public void identify() {
			List<IIdentifiableAlignable> alignables = getAlignables();
			classifier.getFeatureAssigner().transform(alignables);
			for (IIdentifiableAlignable alignable : alignables) {
				ClassificationResults results = classifier.score(alignable.getFeatures());
				alignable.setIdentificationResult(results);
				if (results.getResults().size() == 0) {
					log.info("alignable " + alignable.getFileName() + " from batch " + id + " was not identified with any format");
				}
				for (ClassificationResult result : results.getResults()) {
					log.info("alignable " + alignable.getFileName() + " from batch " + id + " was identified with format " + result.getFormatName() + " and probability " + result.getProbability());
				}
			}
			log.info("batch " + id + " bulk from " + startIndex + " to " + endIndex + " identification completed");
			identificationsLock.writeLock().lock();
			try {
				for (IIdentifiableAlignable alignable : alignables) {
					alignable.setSequence(null);
				}
				identifications.addAll(alignables);
			}
			finally {
				identificationsLock.writeLock().unlock();
			}
		}
	}
	
	public void addAlignable(IIdentifiableAlignable alignable) {
		alignablesLock.writeLock().lock();
		try {
			alignables.add(alignable);
		}
		finally {
			alignablesLock.writeLock().unlock();
		}
	}
	
	public void addAlignables(Collection<IIdentifiableAlignable> alignables) {
		alignablesLock.writeLock().lock();
		try {
			alignables.addAll(alignables);
		}
		finally {
			alignablesLock.writeLock().unlock();
		}
	}
	
	public IdentificationBulk getBulk() {
		IdentificationBulk bulk = null;
		alignablesLock.writeLock().lock();
		try {
			if (bulkIndex < alignables.size()) {
				int availableBulkSize = Math.min(bulkSize, alignables.size() - bulkIndex);
				bulk = new IdentificationBulk(bulkIndex, bulkIndex + availableBulkSize);
				bulkIndex = bulkIndex + availableBulkSize;
			}
		}
		finally {
			alignablesLock.writeLock().unlock();
		}
		
		return bulk;
	}
	
	public IdentificationResponse getIdentificationResponse(int fromIndex) {
		IdentificationResponse response = new IdentificationResponse(getURL());
		identificationsLock.readLock().lock();
		try {
			for (int index = fromIndex; index < identifications.size(); index++) {
				IIdentifiableAlignable alignable = identifications.get(index);
				IdentificationResult result = new IdentificationResult(getClassifier().getName(), getClassifierURL(), alignable.getFileName());
				List<ClassificationResult> classificationResult = alignable.getIdentificationResult().getResults();
				result.setFeatures(alignable.getFeatures());
				for (ClassificationResult classification : classificationResult) {
					Identification identification = new Identification(classification.getFormatName(), "/falstaff/formats/" + classification.getFormat().getId(), classification.getProbability());
					result.addIdentification(identification);
				}
				response.addResult(result);
			}
		}
		finally {
			identificationsLock.readLock().unlock();
		}
		
		alignablesLock.readLock().lock(); 
		try {
			response.setUploaded(alignables.size());
		}
		finally {
			alignablesLock.readLock().unlock(); 
		}
		
		return response;
	}
	
	public String getURL() {
		return getClassifierURL() + "/identifications/" + getId();
	}

	public long getId() {
		return id;
	}

	public FeaturedClassifier getClassifier() {
		return classifier;
	}
	
	public String getClassifierURL() {
		return "/falstaff/classifiers/" + classifier.getId();
	}

	public Calendar getCreated() {
		return created;
	}
}
