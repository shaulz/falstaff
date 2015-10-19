package com.falstaff.core.classification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.feature.IFeature;
import com.falstaff.core.feature.NSignatureFeature;
import com.falstaff.core.feature.NFileNameRegExpFeature;
import com.falstaff.core.feature.NFileSizeFeature;
import com.falstaff.core.feature.NFileExtensionFeature;
import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults.ClassificationResult;
import com.falstaff.core.maxent.Datum;
import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.core.util.IdGenerator;

public class FeaturedSignature implements IDatumSource {

	@NotNull(message = "regular expression is required.")
	private NSignature signature;
	private List<SignatureSimulatedFeaturedSample> simulatedSamples;
	private FeaturedSignaturesSet signaturesSet;
	protected transient int id;
	private transient Map<FeaturedSamplesSet, SamplesSetMatch> formatCoverage;
	
	public static class SamplesSetMatch {
		private List<FeaturedSample> matchedSamples;
		private List<FeaturedSample> unmatchedSamples;
		
		public SamplesSetMatch() {
			matchedSamples = new LinkedList<FeaturedSample>();
			unmatchedSamples = new LinkedList<FeaturedSample>();
		}

		public List<FeaturedSample> getMatchedSamples() {
			return matchedSamples;
		}

		public void setMatchedSamples(List<FeaturedSample> matchedSamples) {
			this.matchedSamples = matchedSamples;
		}

		public List<FeaturedSample> getUnmatchedSamples() {
			return unmatchedSamples;
		}

		public void setUnmatchedSamples(List<FeaturedSample> unmatchedSamples) {
			this.unmatchedSamples = unmatchedSamples;
		}
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = IdGenerator.getIdGenerator().getId(FeaturedSignature.class.getName());
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public FeaturedSignature() {
	}
	
	public FeaturedSignature(NSignature signature, FeaturedSignaturesSet signaturesSet) {
		super();
		this.signature = signature;
		this.signaturesSet = signaturesSet;
		setId();
	}
	
	public FeaturedSignature(FeaturedSignaturesSet signaturesSet) {
		super();
		this.signaturesSet = signaturesSet;
		setId();
	}



	public void setSimulatedSamples() {
		simulatedSamples = new LinkedList<SignatureSimulatedFeaturedSample>();
		FileFormatOntology formatOntology = signaturesSet.getFormat().getOntology();
		Integer fileFixedSize = formatOntology.getFixedSize();
		Pattern fileNamePattern = formatOntology.getFileNamePattern();
		List<String> extensions = new ArrayList<String>(formatOntology.getExtensions());

		Set<NSignature> featureSignatures = new HashSet<NSignature>(
				signature.getFeatureSignatures(true));
		Set<IFeature> simulatedFeatures = new HashSet<IFeature>();
		for (NSignature featureSignature : featureSignatures) {
			NSignatureFeature signatureFeature = new NSignatureFeature(
					featureSignature);
			simulatedFeatures.add(signatureFeature);
		}
		
		if (fileFixedSize != null) {
			simulatedFeatures.add(new NFileSizeFeature(new Long(fileFixedSize), false));
		}
		if (fileNamePattern != null) {
			simulatedFeatures.add(new NFileNameRegExpFeature(fileNamePattern));
		}

		// add signature with all possible extensions
		for (int i = 0; i < extensions.size(); i++) {
			// add extension
			Set<IFeature> featuresWithExtensionNames = new HashSet<IFeature>(simulatedFeatures);
			String extension = extensions.get(i);
			NFileExtensionFeature extensionFeature = new NFileExtensionFeature(extension, false);
			featuresWithExtensionNames.add(extensionFeature);
			SignatureSimulatedFeaturedSample sample = new SignatureSimulatedFeaturedSample(featuresWithExtensionNames, this);
			simulatedSamples.add(sample);
		}
		// add signature without extension
		SignatureSimulatedFeaturedSample sample = new SignatureSimulatedFeaturedSample(simulatedFeatures, this);
		simulatedSamples.add(sample);
	}

	public NSignature getSignature() {
		return signature;
	}

	public void setSignature(NSignature signature) {
		this.signature = signature;
		simulatedSamples = new LinkedList<SignatureSimulatedFeaturedSample>();
	}

	public FeaturedSignaturesSet getSignaturesSet() {
		return signaturesSet;
	}
	
	public void setSignaturesSet(FeaturedSignaturesSet signaturesSet) {
		this.signaturesSet = signaturesSet;
	}
	
	public List<SignatureSimulatedFeaturedSample> getSimulatedSamples() {
		return simulatedSamples;
	}

	public void setSimulatedSamples(
			List<SignatureSimulatedFeaturedSample> simulatedSamples) {
		this.simulatedSamples = simulatedSamples;
	}

	@Override
	public List<Datum> getDatum(int simulatedFeaturesNumber) {
		List<Datum> datums = new LinkedList<Datum>();
		if (simulatedSamples == null) {
			return datums;
		}
		List<Set<IFeature>> features = new LinkedList<Set<IFeature>>();
		for (int i = 0; i < Math.max(simulatedFeaturesNumber, simulatedSamples.size()); i++) {
			features.add(simulatedSamples.get(i % simulatedSamples.size()).getFeatures());
		}
		if (features == null || features.isEmpty()) {
			return datums;
		}
		for (Set<IFeature> featuresSet : features) {
			Set<String> featuresNames = new HashSet<String>();
			for (IFeature feature : featuresSet) {
				featuresNames.add(feature.getName());
			}
			Datum datum = new Datum(signaturesSet.getFormat().getName(), featuresNames);
			datums.add(datum);
		}
		return datums;
	}
	
	public void test() {
		if (simulatedSamples == null) {
			return;
		}
		for (SignatureSimulatedFeaturedSample sample : simulatedSamples) {
			ClassificationResults results = signaturesSet.getFormat().getClassifier().score(sample.getFeatures());
			sample.setTestingResults(results);
			List<ClassificationResult> result = results.getResults();
			if (result.size() > 0) {
				signaturesSet.getFormat().getClassifier().updateScores(result.get(0).getFormat().getName(), signaturesSet.getFormat().getName());
			}
		}
	}
	
	public Boolean isMissClassified() {
		if (simulatedSamples == null) {
			return false;
		}
		
		Boolean missClassified = false; 
		for (SignatureSimulatedFeaturedSample sample : simulatedSamples) {
			Boolean sampleMissClassified = sample.isMissClassified();
			if (sampleMissClassified == null) {
				return null;
			}
			if (sampleMissClassified) {
				missClassified = true;
			}
		}
		
		return missClassified;
	}

	public Map<FeaturedSamplesSet, SamplesSetMatch> getFormatCoverage() {
		if (formatCoverage == null) {
			return new HashMap<FeaturedSamplesSet, SamplesSetMatch>();
		}
		return formatCoverage;
	}

	public void setFormatCoverage(Map<FeaturedSamplesSet, SamplesSetMatch> formatCoverage) {
		this.formatCoverage = formatCoverage;
	}
}
