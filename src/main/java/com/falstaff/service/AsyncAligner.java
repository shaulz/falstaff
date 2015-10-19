package com.falstaff.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.aligner.CentroidsClusterer;
import com.falstaff.core.aligner.ClustererContext;
import com.falstaff.core.aligner.ContentPropertiesFeatureAssigner;
import com.falstaff.core.aligner.Lexer;
import com.falstaff.core.aligner.MagicClustererContext;
import com.falstaff.core.aligner.MagicNumberClusterer;
import com.falstaff.core.aligner.NFilePropertiesFeatureAssigner;
import com.falstaff.core.aligner.SignaturesBuilder;
import com.falstaff.core.aligner.cluster.NClusterStrategy;
import com.falstaff.core.aligner.cluster.NSingleLinkSingleCluster;
import com.falstaff.core.aligner.cluster.NSpectralCluster;
import com.falstaff.core.classification.AlignedSignaturesSet;
import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FeaturedSignaturesSet;
import com.falstaff.core.classification.FeaturedTokensSet;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.execution.ProcessStatus;
import com.falstaff.core.feature.TokenFeature;
import com.falstaff.core.lookup.INLookupTable;
import com.falstaff.core.lookup.LookupTableFactory.LookupType;
import com.falstaff.core.lookup.NLookupTableMemory;
import com.falstaff.core.lookup.NTreeCompactLookupTable;
import com.falstaff.core.lookup.filter.NKtupScoreFilter;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.CountsCentroidFilter;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;
import com.falstaff.core.masker.NLowComplexityMasker;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.EntropyScoreCalculator;
import com.falstaff.repository.dao.FeaturedSignaturesSetDao;
import com.falstaff.repository.dao.FeaturedTokensSetDao;

@Component
public class AsyncAligner {

	private static final Logger log = LoggerFactory
			.getLogger(AsyncAligner.class.getName());
	
	@Autowired
	FeaturedSignaturesSetDao featuredSignaturesSetDao;
	
	@Autowired
	FeaturedTokensSetDao featuredTokensSetDao;

	@Async
	public void align(FeaturedSignaturesSet signaturesSet, FeaturedSamplesSet samplesSet, int minScoreAlternativesCount, double ktupMinAlignablesFractionCutoff, int ktupScoreCutoff, int alignmentKtupLength, NSpectralCluster spectralCluster, int magicAlignmentKtupLength, boolean lowComplexityMasker, NSingleLinkSingleCluster singleLinkSingleCluster) {
		/*
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("i =" + i);
		}
		*/
		
		ByteDistribution distribution = samplesSet.getByteDistribution();
		int aligningSamplesCount = samplesSet.getAligningSamplesCount();
		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(
				distribution, aligningSamplesCount, minScoreAlternativesCount);

		NLowComplexityMasker masker = new NLowComplexityMasker();
		masker.setProcessMonitor(signaturesSet);

		// calculate filter
		int signatureMinAlignablesCutoff = (int) (aligningSamplesCount * ktupMinAlignablesFractionCutoff);
		log.info("centroids filter set to minimum of "
				+ signatureMinAlignablesCutoff + " alignables");
		INKtupCentroidFilter<IScorableKtup> centroidFilter = new CountsCentroidFilter<IScorableKtup>(
				signatureMinAlignablesCutoff, signatureMinAlignablesCutoff);

		NKtupScoreFilter fillFilter = new NKtupScoreFilter(ktupScoreCutoff);

		INLookupTable<IScorableKtup> lookup = new NTreeCompactLookupTable<IScorableKtup>(
				alignmentKtupLength);

		// NClusterStrategy clusterStrategy = new NClusterStrategy(new
		// NSingleLinkCluster());
		NClusterStrategy clusterStrategy = new NClusterStrategy(spectralCluster);
		CentroidsClusterer centroidsCluster = new CentroidsClusterer(
				scoreCalculator, lookup, clusterStrategy);
		centroidsCluster.setPostFillFilter(centroidFilter);
		centroidsCluster.setFillFilter(fillFilter);
		centroidsCluster.setProcessMonitor(signaturesSet);

		SignaturesBuilder signaturesBuilder = new SignaturesBuilder();
		signaturesBuilder.setProcessMonitor(signaturesSet);

		masker.setNext(centroidsCluster);
		centroidsCluster.setNext(signaturesBuilder);

		Set<NSignature> signatures = null;
		if (lowComplexityMasker) {
			signatures = samplesSet.align(masker);
		} else {
			signatures = samplesSet.align(centroidsCluster);
		}

		// magic signatures
		INLookupTable<IScorableKtup> magicLookup = new NLookupTableMemory<IScorableKtup>(
				magicAlignmentKtupLength);

		NClusterStrategy magicClusterStrategy = new NClusterStrategy(
				singleLinkSingleCluster);
		MagicNumberClusterer magicCentroidsCluster = new MagicNumberClusterer(
				scoreCalculator, magicLookup, magicClusterStrategy);
		magicCentroidsCluster.setProcessMonitor(signaturesSet);

		signaturesBuilder = new SignaturesBuilder();
		signaturesBuilder.setProcessMonitor(signaturesSet);

		magicCentroidsCluster.setNext(signaturesBuilder);

		Set<NSignature> magicSignatures = null;

		magicSignatures = samplesSet.align(magicCentroidsCluster);
		signatures.addAll(magicSignatures);

		signaturesSet.addSignatures(signatures);
		signaturesSet.setCreated(Calendar.getInstance());
		signaturesSet.setUpdated(signaturesSet.getCreated());
		try {
			featuredSignaturesSetDao.save(signaturesSet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signaturesSet.setStatus(ProcessStatus.FINISHED);
	}

	@Async
	public void align(FeaturedSamplesSet samplesSet, NSpectralCluster spectralCluster,
			NSingleLinkSingleCluster singleLinkSingleCluster,
			AlignerContext alignerContext) {

		AlignedSignaturesSet signaturesSet = alignerContext.getSignaturesSet();
		NLowComplexityMasker masker = new NLowComplexityMasker();
		masker.setProcessMonitor(signaturesSet);

		// NClusterStrategy clusterStrategy = new NClusterStrategy(new
		// NSingleLinkCluster());
		NClusterStrategy clusterStrategy = new NClusterStrategy(spectralCluster);
		ClustererContext variablePositionContext = alignerContext.getVariablePositionContext();
		if (variablePositionContext.getLookupType() == null) {
			variablePositionContext.setLookupType(LookupType.TREE_COMPACT);
		}
		CentroidsClusterer centroidsCluster = new CentroidsClusterer(clusterStrategy, variablePositionContext);
		centroidsCluster.setProcessMonitor(signaturesSet);

		SignaturesBuilder signaturesBuilder = new SignaturesBuilder();
		signaturesBuilder.setProcessMonitor(signaturesSet);

		masker.setNext(centroidsCluster);
		centroidsCluster.setNext(signaturesBuilder);

		Set<NSignature> signatures = null;
		if (alignerContext.isLowComplexityMasker()) {
			signatures = samplesSet.align(masker);
		} else {
			signatures = samplesSet.align(centroidsCluster);
		}

		// magic signatures
		MagicClustererContext magicContext = alignerContext.getMagicContext();
		if (magicContext.getLookupType() == null) {
			magicContext.setLookupType(LookupType.MEMORY);
		}

		NClusterStrategy magicClusterStrategy = new NClusterStrategy(
				singleLinkSingleCluster);
		MagicNumberClusterer magicCentroidsCluster = new MagicNumberClusterer(magicClusterStrategy, magicContext);
		magicCentroidsCluster.setProcessMonitor(signaturesSet);

		signaturesBuilder = new SignaturesBuilder();
		signaturesBuilder.setProcessMonitor(signaturesSet);

		magicCentroidsCluster.setNext(signaturesBuilder);

		Set<NSignature> magicSignatures = null;

		magicSignatures = samplesSet.align(magicCentroidsCluster);
		signatures.addAll(magicSignatures);

		signaturesSet.addSignatures(signatures);
		signaturesSet.setCreated(Calendar.getInstance());
		signaturesSet.setUpdated(signaturesSet.getCreated());
		try {
			featuredSignaturesSetDao.save(signaturesSet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signaturesSet.setStatus(ProcessStatus.FINISHED);
		
	}
	
	@Async
	public void lex(FeaturedSamplesSet samplesSet, ContentPropertiesFeatureAssigner contentPropertiesFeatureAssigner, Lexer lexer, LexerContext context) {
		Set<TokenFeature> features = samplesSet.lex(contentPropertiesFeatureAssigner, lexer);
		FeaturedTokensSet tokens = context.getTokensSet();
		tokens.setTokens(features);
		tokens.setCreated(Calendar.getInstance());
		tokens.setUpdated(tokens.getCreated());
		//FeaturedTokensSet tokens = new FeaturedTokensSet(samplesSet.getName(), features, samplesSet.getFormat());
		//samplesSet.getFormat().addTokensSet(tokens);
		try {
			featuredTokensSetDao.save(tokens);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tokens.setStatus(ProcessStatus.FINISHED);
	}

}
