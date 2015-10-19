package com.falstaff.core.classification;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.falstaff.core.feature.IFeature;

public class IdentificationResponse {

	private String batchURL;
	private int uploaded;
	private List<IdentificationResult> results;
	
	public static class IdentificationResult {
		private String classifierName;
		private String classifierURL;
		private String fileName;
		private List<Identification> identifications;
		private Set<IFeature> features;
		
		public static class Identification {
			private String formatName;
			private String formatURL;
			private double probability;
						
			public Identification() {
			}

			public Identification(String formatName, String formatURL,
					double probability) {
				super();
				this.formatName = formatName;
				this.formatURL = formatURL;
				this.probability = probability;
			}

			public String getFormatName() {
				return formatName;
			}

			public String getFormatURL() {
				return formatURL;
			}

			public double getProbability() {
				return probability;
			}
			
		}
		
		public IdentificationResult() {
		}

		public IdentificationResult(String classifierName,
				String classifierURL, String fileName) {
			super();
			this.classifierName = classifierName;
			this.classifierURL = classifierURL;
			this.fileName = fileName;
			identifications = new LinkedList<Identification>();
		}
		
		public void addIdentification(Identification identification) {
			identifications.add(identification);
		}

		public String getClassifierName() {
			return classifierName;
		}

		public String getClassifierURL() {
			return classifierURL;
		}

		public String getFileName() {
			return fileName;
		}

		public List<Identification> getIdentifications() {
			return identifications;
		}

		public Set<IFeature> getFeatures() {
			return features;
		}

		public void setFeatures(Set<IFeature> features) {
			this.features = features;
		}
	}
	
	public IdentificationResponse() {
		results = new LinkedList<IdentificationResult>();
		uploaded = 0;
	}

	public IdentificationResponse(String batchURL) {
		super();
		this.batchURL = batchURL;
		results = new LinkedList<IdentificationResult>();
		uploaded = 0;
	}

	public void addResult(IdentificationResult result) {
		results.add(result);
	}

	public String getBatchURL() {
		return batchURL;
	}

	public List<IdentificationResult> getResults() {
		return results;
	}

	public int getUploaded() {
		return uploaded;
	}

	public void setUploaded(int uploaded) {
		this.uploaded = uploaded;
	}
}
