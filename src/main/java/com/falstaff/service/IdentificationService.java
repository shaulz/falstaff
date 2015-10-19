package com.falstaff.service;

import java.util.Collection;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.falstaff.core.classification.FeaturedClassifier;
import com.falstaff.core.classification.IIdentifiableAlignable;
import com.falstaff.core.classification.IdentificationBatch;
import com.falstaff.core.classification.IdentificationBatch.IdentificationBulk;
import com.falstaff.repository.dao.FileFormatDao;
import com.falstaff.repository.dao.IdentificationDao;

@Service
public class IdentificationService {
	
	private static final Logger log = LoggerFactory
	.getLogger(IdentificationService.class.getName());

	@Autowired
	private IdentificationDao identificationDao;
	
	@Autowired
	AsyncIdentifier asyncIdentifier;
	
	@Value("${falstaff.core.service.classifications_bulk_size}")
	private int classificationsBulkSize;
	
	@Value("${falstaff.core.classification.alignable_sequece_length}")
	private int alignableSequenceLength;

	public IdentificationBatch createIdentification(FeaturedClassifier classifier, Collection<IIdentifiableAlignable> alignables) {
		IdentificationBatch identification = new IdentificationBatch(classifier, classificationsBulkSize);
		if (alignables != null) {
			identification.addAlignables(alignables);
		}
		identificationDao.saveIdentification(identification);
		return identification;
	}
	
	public IdentificationBatch createIdentification(FeaturedClassifier classifier) {
		return createIdentification(classifier, new LinkedList<IIdentifiableAlignable>());
	}
	
	public IdentificationBatch updateIdentification(long identificationId, Collection<IIdentifiableAlignable> alignables) {
		IdentificationBatch identification = identificationDao.readIdentification(identificationId);
		if (identification == null) {
			throw new RuntimeException("failed to read identification with id " + identificationId);
		}
		if (alignables != null) {
			identification.addAlignables(alignables);
		}
		return identification;
	}

	public IdentificationBatch readIdentification(long id) {
		return identificationDao.readIdentification(id);
	}	

	public void identify(IdentificationBatch identificationBatch) {
		IdentificationBulk identificationBulk = identificationBatch.getBulk();
		while (identificationBulk != null) {
			asyncIdentifier.identify(identificationBulk);
			identificationBulk = identificationBatch.getBulk();
		}
	}

	public int getAlignableSequenceLength() {
		return alignableSequenceLength;
	}

	public void setAlignableSequenceLength(int alignableSequenceLength) {
		this.alignableSequenceLength = alignableSequenceLength;
	}
}
