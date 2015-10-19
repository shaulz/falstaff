package com.falstaff.core.classification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults.ClassificationResult;
import com.falstaff.core.classification.FeaturedSignature.SamplesSetMatch;
import com.falstaff.core.feature.IFeature;
import com.falstaff.core.feature.NFileExtensionFeature;
import com.falstaff.core.feature.NFileNameRegExpFeature;
import com.falstaff.core.feature.NFileSizeFeature;
import com.falstaff.core.maxent.Datum;
import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.core.util.IdGenerator;

public class FileFormat  implements IDatumSource {

	private long id;
	private String name;
	transient private FileFormatOntology ontology;
	private List<FeaturedSamplesSet> samples;
	private List<FeaturedSignaturesSet> signatures;
	private List<ExtensionSimulatedFeaturedSample> simulatedSamples;
	private String classifierName;
	transient private FeaturedClassifier classifier;
	private Boolean missClassified;
	private List<FeaturedTokensSet> tokens;
	
	public static class FormatsComparator implements Comparator<FileFormat> {
        @Override
        public int compare(final FileFormat f1, final FileFormat f2) {
            int result = f1.getOntology().getFirstGroup().getName().compareTo(f2.getOntology().getFirstGroup().getName());
            if (result != 0) {
            	return result;
            }
            result = f1.getOntology().getSecondGroup().getName().compareTo(f2.getOntology().getSecondGroup().getName());
            if (result != 0) {
            	return result;
            }
            result = f1.getOntology().getName().compareTo(f2.getOntology().getName());
            if (result != 0) {
            	return result;
            }
            return f1.getName().compareTo(f2.getName());
        }
     }
	
	public FileFormat(String name, FileFormatOntology ontology) {
		super();
		this.name = name;
		this.ontology = ontology;
		samples = new LinkedList<FeaturedSamplesSet>();
		signatures = new LinkedList<FeaturedSignaturesSet>();
		tokens = new LinkedList<FeaturedTokensSet>();
		id = IdGenerator.getIdGenerator().getId(this.getClass().getName());
	}

	public FileFormat(FileFormatOntology ontology) {
		this(ontology.getName(), ontology);
	}
	
	public String getName() {
		return name;
	}

	public void setOntology(FileFormatOntology ontology) {
		this.ontology = ontology;
	}

	public FileFormatOntology getOntology() {
		return ontology;
	}

	public long getId() {
		return id;
	}

	public List<FeaturedSamplesSet> getSamples() {
		return samples;
	}
	
	public void clearSamples() {
		if (samples != null) {
			samples.clear();
		}
	}
	
	public void clearSamplesSet(FeaturedSamplesSet samplesSet) {
		clearSamplesSet(samplesSet.getName());
	}
	
	public void clearSamplesSet(String samplesSetName) {
		if (samples == null) {
			return;
		}
		for (int i = 0; i < samples.size(); i++) {
			if (samples.get(i).getName().equals(samplesSetName)) {
				samples.remove(i);
				break;
			}
		}
	}
	
	public void clearSamplesSet(int samplesSetId) {
		if (samples == null) {
			return;
		}
		for (int i = 0; i < samples.size(); i++) {
			if (samples.get(i).getId() == samplesSetId) {
				samples.remove(i);
				break;
			}
		}
	}
	
	public FeaturedSamplesSet addSamplesSet(FeaturedSamplesSet newSamplesSet) {
		if (samples == null) {
			samples = new LinkedList<FeaturedSamplesSet>();
		}
		for (FeaturedSamplesSet samplesSet : samples) {
			if (samplesSet.getName().equals(newSamplesSet.getName())) {
				throw new RuntimeException("sample set with name " + samplesSet.getName() + " already exists");
			}
		}
		newSamplesSet.setFormat(this);
		samples.add(newSamplesSet);
		return newSamplesSet;
	}
	
	public FeaturedSamplesSet updateSamplesSet(FeaturedSamplesSet samplesSet) {
		clearSamplesSet(samplesSet);
		return addSamplesSet(samplesSet);
	}
	
	public FeaturedSamplesSet getSamplesSet(int samplesSetId) {
		if (samples == null) {
			return null;
		}
		for (FeaturedSamplesSet featuredSamplesSet : samples) {
			if (featuredSamplesSet.getId() == samplesSetId) {
				return featuredSamplesSet;
			}
		}
		return null;
	}
	
	public FeaturedSamplesSet getSamplesSet(String samplesSetName) {
		if (samples == null) {
			return null;
		}
		for (FeaturedSamplesSet samplesSet : samples) {
			if (samplesSet.getName().equals(samplesSetName)) {
				return samplesSet;
			}
		}
		return null;		
	}
	
	public void clearSignatures() {
		if (signatures != null) {
			signatures.clear();
		}
	}
	
	public void clearSignaturesSet(FeaturedSignaturesSet signaturesSet) {
		clearSignaturesSet(signaturesSet.getName(), signaturesSet.getSource());
	}
	
	public void clearSignaturesSet(String signaturesSetName, SignaturesSource signaturesSetSource) {
		if (signatures == null) {
			return;
		}
		for (int i = 0; i < signatures.size(); i++) {
			if (signatures.get(i).getName().equals(signaturesSetName) && signatures.get(i).getSource().equals(signaturesSetSource)) {
				signatures.remove(i);
				break;
			}
		}
		return;
	}
	
	public void clearSignaturesSet(int signaturesSetId) {
		if (signatures == null) {
			return;
		}
		for (int i = 0; i < signatures.size(); i++) {
			if (signatures.get(i).getId() == signaturesSetId) {
				signatures.remove(i);
				break;
			}
		}
		return;
	}
	
	public FeaturedSignaturesSet addSignaturesSet(FeaturedSignaturesSet newSignaturesSet) {
		if (signatures == null) {
			signatures = new LinkedList<FeaturedSignaturesSet>();
		}
		for (FeaturedSignaturesSet signaturesSet : signatures) {
			if (signaturesSet.getName().equals(newSignaturesSet.getName())) {
				throw new RuntimeException("signatures set with name " + signaturesSet.getName() + " already exists");
			}
		}
		newSignaturesSet.setFormat(this);
		signatures.add(newSignaturesSet);
		return newSignaturesSet;
	}
	
	public FeaturedSignaturesSet updateSignaturesSet(FeaturedSignaturesSet signaturesSet) {
		clearSignaturesSet(signaturesSet);
		return addSignaturesSet(signaturesSet);
	}

	public List<FeaturedSignaturesSet> getSignatures() {
		return signatures;
	}
	
	public FeaturedSignaturesSet getSignaturesSet(int signaturesSetId) {
		if (signatures == null) {
			return null;
		}
		for (FeaturedSignaturesSet featuredSignaturesSet : signatures) {
			if (featuredSignaturesSet.getId() == signaturesSetId) {
				return featuredSignaturesSet;
			}
		}
		return null;
	}
	
	public FeaturedSignaturesSet getSignaturesSet(String signaturesSetName, SignaturesSource signaturesSetSource) {
		for (FeaturedSignaturesSet signaturesSet : signatures) {
			if (signaturesSet.getName().equals(signaturesSetName) && signaturesSet.getSource().equals(signaturesSetSource)) {
				return signaturesSet;
			}
		}
		return null;
	}
	
	////////////////////
	
	public void clearTokens() {
		if (tokens != null) {
			tokens.clear();
		}
	}
	
	public void clearTokensSet(FeaturedTokensSet tokensSet) {
		clearTokensSet(tokensSet.getName());
	}
	
	public void clearTokensSet(String tokensSetName) {
		if (tokens == null) {
			return;
		}
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).getName().equals(tokensSetName)) {
				tokens.remove(i);
				break;
			}
		}
		return;
	}
	
	public void clearTokensSet(int tokensSetId) {
		if (tokens == null) {
			return;
		}
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).getId() == tokensSetId) {
				tokens.remove(i);
				break;
			}
		}
		return;
	}
	
	public FeaturedTokensSet addTokensSet(FeaturedTokensSet newTokensSet) {
		if (tokens == null) {
			tokens = new LinkedList<FeaturedTokensSet>();
		}
		for (FeaturedTokensSet tokensSet : tokens) {
			if (tokensSet.getName().equals(newTokensSet.getName())) {
				throw new RuntimeException("tokens set with name " + tokensSet.getName() + " already exists");
			}
		}
		newTokensSet.setFormat(this);
		tokens.add(newTokensSet);
		return newTokensSet;
	}
	
	public FeaturedTokensSet updateTokensSet(FeaturedTokensSet tokensSet) {
		clearTokensSet(tokensSet);
		return addTokensSet(tokensSet);
	}

	public List<FeaturedTokensSet> getTokens() {
		return tokens;
	}
	
	public FeaturedTokensSet getTokensSet(int tokensSetId) {
		if (tokens == null) {
			return null;
		}
		for (FeaturedTokensSet featuredTokensSet : tokens) {
			if (featuredTokensSet.getId() == tokensSetId) {
				return featuredTokensSet;
			}
		}
		return null;
	}
	
	public FeaturedTokensSet getTokensSet(String tokensSetName) {
		for (FeaturedTokensSet tokensSet : tokens) {
			if (tokensSet.getName().equals(tokensSetName)) {
				return tokensSet;
			}
		}
		return null;
	}

	public Set<String> getPronomIds() {
		return ontology.getPronomIds();
	}
	
	public Set<String> getFddIds() {
		return ontology.getFddIds();
	}
	
	public Set<String> getMimeTypes() {
		return ontology.getMimeTypes();
	}
	
	public Calendar getUpdateDate() {
		return ontology.getUpdateDate();
	}

	@Override
	public List<Datum> getDatum(int simulatedFeaturesNumber) {
		List<Datum> datums = new LinkedList<Datum>();
		// simulated features
		if (signatures != null) {
			for (FeaturedSignaturesSet signaturesSet : signatures) {
				datums.addAll(signaturesSet.getDatum(simulatedFeaturesNumber));
			}
		}
		
		// real features
		if (samples != null) {
			for (FeaturedSamplesSet sampleSet : samples) {
				datums.addAll(sampleSet.getDatum(simulatedFeaturesNumber));
			}
		}
		
		// extensions
		if (simulatedSamples != null) {
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
				Datum datum = new Datum(name, featuresNames);
				datums.add(datum);
			}
		}
		
		return datums;
	}	
	
	public FeaturedClassifier getClassifier() {
		return classifier;
	}

	public void setClassifier(FeaturedClassifier classifier) {
		this.classifier = classifier;
		if (classifier != null) {
			classifierName = classifier.getName();
		}
		else {
			classifierName = null;
		}
	}
	
	public void clearTestingResults() {
		if (signatures != null) {
			for (FeaturedSignaturesSet signaturesSet : signatures) {
				for (FeaturedSignature signature : signaturesSet.getSignatures()) {
					if (signature.getSimulatedSamples() != null && signature.getSimulatedSamples().size() > 0) {
						for (SignatureSimulatedFeaturedSample sample : signature.getSimulatedSamples()) {
							sample.setTestingResults(null);
						}
					}
				}
			}
		}
		
		if (samples != null) {
			for (FeaturedSamplesSet samplesSet : samples) {
				if (samplesSet.getSamples() != null) {
					for (FeaturedSample sample : samplesSet.getSamples()) {
						sample.setTestingResults(null);
					}
				}
			}
		}
		
		if (simulatedSamples != null) {
			for (ExtensionSimulatedFeaturedSample sample : simulatedSamples) {
				sample.setTestingResults(null);
			}
		}
		
		missClassified = null;
	}

	public void setSimulatedSamples() {	
		
		simulatedSamples = null;
		
		// check if signatures features exist
		if (signatures != null) {
			for (FeaturedSignaturesSet signaturesSet : signatures) {
				for (FeaturedSignature signature : signaturesSet.getSignatures()) {
					if (signature.getSimulatedSamples() != null && signature.getSimulatedSamples().size() > 0) {
						return;
					}
				}
			}
		}
		
		// check if samples features exist
		if (samples != null) {
			for (FeaturedSamplesSet samplesSet : samples) {
				if (samplesSet.getSamples() != null) {
					for (FeaturedSample sample : samplesSet.getSamples()) {
						if (sample.getFeatures() != null && sample.getFeatures().size() > 0) {
							return;
						}
					}
				}
			}
		}
		
		Integer fileFixedSize = ontology.getFixedSize();
		Pattern fileNamePattern = ontology.getFileNamePattern();

		Set<IFeature> simulatedFeatures = new HashSet<IFeature>();
		List<String> extensions;
		if (ontology.getExtensions() != null) {
			extensions = new ArrayList<String>(ontology.getExtensions());
		}
		else {
			extensions = new ArrayList<String>();
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
			String extension = extensions.get(i % extensions.size());
			NFileExtensionFeature extensionFeature = new NFileExtensionFeature(extension, false);
			featuresWithExtensionNames.add(extensionFeature);
			ExtensionSimulatedFeaturedSample sample = new ExtensionSimulatedFeaturedSample(featuresWithExtensionNames, this);
			if (simulatedSamples == null) {
				simulatedSamples = new LinkedList<ExtensionSimulatedFeaturedSample>();
			}
			simulatedSamples.add(sample);
		}
	}
	
	public void setSimulatedSamples(List<ExtensionSimulatedFeaturedSample> samples) {
		simulatedSamples = samples;
	}
	
	public List<ExtensionSimulatedFeaturedSample> getSimulatedSamples() {
		return simulatedSamples;
	}

	public void test() {
		if (simulatedSamples == null) {
			return;
		}
		for (ExtensionSimulatedFeaturedSample sample : simulatedSamples) {
			ClassificationResults results = classifier.score(sample.getFeatures());
			sample.setTestingResults(results);
			List<ClassificationResult> result = results.getResults();
			if (result.size() > 0) {
				getClassifier().updateScores(result.get(0).getFormat().getName(), getName());
			}
		}
	}
	
	public Boolean isMissClassified() {
		return missClassified;
	}
	
	public void setMissClassified() {
		missClassified = null;
		
		if (signatures != null) {
			for (FeaturedSignaturesSet signaturesSet : signatures) {
				Boolean signaturesSetMissClassified = signaturesSet.isMissClassified();
				if (signaturesSetMissClassified == null) {
					continue;
				}
				if (signaturesSetMissClassified != null && missClassified == null) {
					missClassified = signaturesSetMissClassified;
					if (missClassified) {
						return;
					}
					continue;
				}
				if (signaturesSetMissClassified) {
					missClassified = true;
					return;
				}
			}
		}
				
		if (samples != null) {
			for (FeaturedSamplesSet samplesSet : samples) {
				Boolean samplesSetMissClassified = samplesSet.isMissClassified();
				if (samplesSetMissClassified == null) {
					continue;
				}
				if (samplesSetMissClassified != null && missClassified == null) {
					missClassified = samplesSetMissClassified;
					if (missClassified) {
						return;
					}
					continue;
				}
				if (samplesSetMissClassified) {
					missClassified = true;
					return;
				}
			}
		}
		
		if (simulatedSamples == null) {
			return;
		}

		for (ExtensionSimulatedFeaturedSample sample : simulatedSamples) {
			Boolean sampleMissClassified = sample.isMissClassified();
			if (sampleMissClassified == null) {
				continue;
			}
			if (sampleMissClassified != null && missClassified == null) {
				missClassified = sampleMissClassified;
				if (missClassified) {
					return;
				}
				continue;
			}
			if (sampleMissClassified) {
				missClassified = true;
				return;
			}
		}
	}
		
	public Double getRecall() {
		return classifier.getRecall(name);
	}
	
	public Double getPrecision() {
		return classifier.getPrecision(name);
	}
	
	public String getClassifierName() {
		return classifierName;
	}

	public void setClassifierName(String classifierName) {
		this.classifierName = classifierName;
	}

	public Double getF() {
		return classifier.getF(name);
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSignatureCoverage(FeaturedSignature signature) {
		if (samples == null) {
			return;
		}
		Map<FeaturedSamplesSet, SamplesSetMatch> formatCoverage = new HashMap<FeaturedSamplesSet, SamplesSetMatch>();
		for (FeaturedSamplesSet samplesSet : samples) {
			SamplesSetMatch coverage = samplesSet.getCoverage(signature);
			if (coverage != null) {
				formatCoverage.put(samplesSet, coverage);
			}
		}		
		signature.setFormatCoverage(formatCoverage);
	}
}
