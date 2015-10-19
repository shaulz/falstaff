package com.falstaff.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.falstaff.core.alignable.sequence.NSequenceAlignable;
import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.aligner.CentroidsClusterer;
import com.falstaff.core.aligner.ClustererContext;
import com.falstaff.core.aligner.MagicClustererContext;
import com.falstaff.core.aligner.MagicNumberClusterer;
import com.falstaff.core.aligner.SignaturesBuilder;
import com.falstaff.core.aligner.cluster.NClusterStrategy;
import com.falstaff.core.aligner.cluster.NSingleLinkSingleCluster;
import com.falstaff.core.aligner.cluster.NSpectralCluster;
import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.AlignedSignaturesSet;
import com.falstaff.core.classification.FeaturedSignature;
import com.falstaff.core.classification.FeaturedSignature.SamplesSetMatch;
import com.falstaff.core.classification.FeaturedSignaturesSet;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.classification.MagicSignaturesSet;
import com.falstaff.core.classification.PronomSignaturesSet;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.lookup.INLookupTable;
import com.falstaff.core.lookup.NLookupTableMemory;
import com.falstaff.core.lookup.NTreeCompactLookupTable;
import com.falstaff.core.lookup.filter.NKtupScoreFilter;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.CountsCentroidFilter;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;
import com.falstaff.core.masker.NLowComplexityMasker;
import com.falstaff.core.ontology.MagicNumbers.MagicNumberRecord;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.EntropyScoreCalculator;
import com.falstaff.repository.dao.FeaturedSignaturesSetDao;
import com.falstaff.repository.dao.FileFormatDao;

@Service
public class FeaturedSignaturesSetService implements BeanFactoryAware {
	
	private static final Logger log = LoggerFactory
	.getLogger(FeaturedSignaturesSetService.class.getName());

	private static final String maxMagicPositionShift = null;

	@Autowired
	FeaturedSignaturesSetDao featuredSignaturesSetDao;
	
	@Autowired
	FileFormatDao fileFormatDao;
	
	@Autowired
	AsyncAligner asyncAligner;
	
	@Value("${falstaff.core.service.alignment_ktup_length}")
	private int alignmentKtupLength;
	
	@Value("${falstaff.core.service.magic_alignment_ktup_length}")
	private int magicAlignmentKtupLength;
	
	@Value("${falstaff.core.service.min_score_alternatives_count}")
	private int minScoreAlternativesCount;
	
	@Value("${falstaff.core.service.magic_min_score_alternatives_count}")
	private int magicMinScoreAlternativesCount;
	
	@Value("${falstaff.core.service.ktup_score_cutoff}")
	private int ktupScoreCutoff;
	
	@Value("${falstaff.core.service.magic_ktup_score_cutoff}")
	private int magicKtupScoreCutoff;
	
	@Value("${falstaff.core.service.ktup_min_alignables_fraction_cutoff}")
	private double ktupMinAlignablesFractionCutoff;
	
	@Value("${falstaff.core.service.magic_ktup_min_alignables_fraction_cutoff}")
	private double magicKtupMinAlignablesFractionCutoff;
	
	@Value("${falstaff.core.service.ktup_min_alignables_cutoff}")
	private int ktupMinAlignablesCutoff;
	
	@Value("${falstaff.core.service.magic_ktup_min_alignables_cutoff}")
	private int magicKtupMinAlignablesCutoff;
	
	@Value("${falstaff.core.service.magic_max_position_shift}")
	private int magicMaxPositionShift;
	
	@Value("${falstaff.core.service.magic_offset}")
	private int magicOffset;
	
	@Value("${falstaff.core.service.low_complexity_masker}")
	private boolean lowComplexityMasker;	
	
	@Value("${falstaff.core.classification.alignable_sequece_length}")
	private int alignableSequenceLength;
	
	private BeanFactory beanFactory;
	
	@PostConstruct
	public void init() {
		NSequenceAlignable.HEADER_LENGTH = alignableSequenceLength / 2;
	}
	
	public FeaturedSignaturesSet create(FeaturedSignaturesSet signaturesSet) throws IOException {
		signaturesSet.setCreated(Calendar.getInstance());
		signaturesSet.setUpdated(signaturesSet.getCreated());
		featuredSignaturesSetDao.save(signaturesSet);
		return signaturesSet;
	}
	
	public FeaturedSignaturesSet setFormat(FeaturedSignaturesSet signaturesSet, FileFormat fileFormat) throws IOException {
		signaturesSet.setFormat(fileFormat);
		fileFormat.updateSignaturesSet(signaturesSet);
		return signaturesSet;
	}
	
	public AlignerContext defaultAlignerContext(FeaturedSamplesSet samplesSet) {
		ClustererContext variablePositionContext = new ClustererContext(alignmentKtupLength, minScoreAlternativesCount, ktupScoreCutoff, ktupMinAlignablesFractionCutoff, ktupMinAlignablesCutoff);
		MagicClustererContext magicContext = new MagicClustererContext(magicAlignmentKtupLength, magicMinScoreAlternativesCount, magicKtupScoreCutoff, magicKtupMinAlignablesFractionCutoff, magicKtupMinAlignablesCutoff, magicMaxPositionShift, magicOffset);
		AlignedSignaturesSet signaturesSet = new AlignedSignaturesSet(samplesSet);
		AlignerContext alignerContext = new AlignerContext(true, true, lowComplexityMasker, variablePositionContext, magicContext, signaturesSet);
		return alignerContext;
	}
	
	public void createAligned(FeaturedSamplesSet samplesSet, AlignerContext alignerContext) throws IOException {
		NSpectralCluster spectralCluster = (NSpectralCluster)beanFactory.getBean("spectralCluster");
		NSingleLinkSingleCluster singleLinkSingleCluster = (NSingleLinkSingleCluster)beanFactory.getBean("singleLinkSingleCluster");
		alignerContext.getSignaturesSet().setProcessMonitor(new ProcessMonitor());
		asyncAligner.align(samplesSet, spectralCluster, singleLinkSingleCluster, alignerContext);
		return;
	}
	
	public void createAligned(AlignedSignaturesSet signaturesSet, FeaturedSamplesSet samplesSet) throws IOException {
		NSpectralCluster spectralCluster = (NSpectralCluster)beanFactory.getBean("spectralCluster");
		NSingleLinkSingleCluster singleLinkSingleCluster = (NSingleLinkSingleCluster)beanFactory.getBean("singleLinkSingleCluster");
		signaturesSet.setProcessMonitor(new ProcessMonitor());
		asyncAligner.align(signaturesSet, samplesSet, minScoreAlternativesCount, ktupMinAlignablesFractionCutoff, ktupScoreCutoff, alignmentKtupLength, spectralCluster, magicAlignmentKtupLength, lowComplexityMasker, singleLinkSingleCluster);
		return;
	}
	
	public FeaturedSignaturesSet createPronom(PronomSignaturesSet signaturesSet) throws IOException {
		signaturesSet.setSignatures();
		return create(signaturesSet);
	}
	
	public FeaturedSignature createSignature(FeaturedSignaturesSet signaturesSet, FeaturedSignature signature) throws IOException {
		signaturesSet.addSignature(signature);
		signaturesSet.setUpdated(Calendar.getInstance());
		featuredSignaturesSetDao.save(signaturesSet);
		return signature;
	}
	
	public void save(FeaturedSignaturesSet signaturesSet) throws IOException {
		featuredSignaturesSetDao.save(signaturesSet);
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
	      this.beanFactory = beanFactory;
	}

	public FeaturedSignaturesSet createMagic(MagicSignaturesSet signaturesSet) throws IOException {
		for (MagicNumberRecord magicNumberRecord : signaturesSet.getFormat().getOntology().getRelatedMagicNumberRecords()) {
			signaturesSet.addSignatures(magicNumberRecord.getSignatures());
		}
		return create(signaturesSet);
	}

	public Map<FeaturedSamplesSet, SamplesSetMatch> signatureFormatCoverage(FeaturedSignature signature) {
		FileFormat format = signature.getSignaturesSet().getFormat();
		format.setSignatureCoverage(signature);
		return signature.getFormatCoverage();
	}
}
