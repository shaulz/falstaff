package com.falstaff.core.ontology;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.ontology.MagicNumbers.MagicNumberRecord.MagicOntologyRelation;
import com.falstaff.core.ontology.MagicNumbers.OntologyMagicRelations.OntologyMagicRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MagicNumbers {
	
	public static class MagicNumberRecord {
		private Set<NSignature> signatures;
		private Set<String> extensions;
		private String description;
		List<MagicOntologyRelation> ontologyRelations;
		transient private int id;
		
		public static class MagicOntologyRelation {
			private String ontologyName;
			private Boolean related;
			private Boolean inOntologyDescription;
			private Boolean verified;
			
			public MagicOntologyRelation(String ontologyName) {
				super();
				this.ontologyName = ontologyName;
				related = false;
				inOntologyDescription = false;
				verified = false;
			}

			public MagicOntologyRelation() {
				super();
			}

			public String getOntologyName() {
				return ontologyName;
			}

			public void setOntologyName(String ontologyName) {
				this.ontologyName = ontologyName;
			}

			public Boolean getRelated() {
				return related;
			}

			public void setRelated(Boolean related) {
				this.related = related;
			}

			public Boolean getInOntologyDescription() {
				return inOntologyDescription;
			}

			public Boolean getVerified() {
				return verified;
			}

			public void setVerified(Boolean verified) {
				this.verified = verified;
			}

			public void setInOntologyDescription(Boolean inOntologyDescription) {
				this.inOntologyDescription = inOntologyDescription;
			}		
		}
		
		public MagicNumberRecord() {
			signatures = new HashSet<NSignature>();
			extensions = new HashSet<String>();
		}

		public Set<NSignature> getSignatures() {
			return signatures;
		}

		public void setSignatures(Set<NSignature> signatures) {
			this.signatures = signatures;
		}

		public Set<String> getExtensions() {
			return extensions;
		}

		public void setExtensions(Set<String> extensions) {
			this.extensions = extensions;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public List<MagicOntologyRelation> getOntologyRelations() {
			return ontologyRelations;
		}

		public void setOntologyRelations(List<MagicOntologyRelation> ontologyRelations) {
			this.ontologyRelations = ontologyRelations;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("description : ").append(description).append("\nsignatures : ");
			for (NSignature signature : signatures) {
				builder.append(signature.getRegularExpression()).append(" ");
			}
			builder.append("\nextensions : ");
			for (String extension : extensions) {
				builder.append(extension).append(" ");
			}
			return builder.toString();
		}

		public MagicOntologyRelation getOntologyRelation(String ontologyName) {
			for (MagicOntologyRelation magicOntologyRelation : ontologyRelations) {
				if (magicOntologyRelation.getOntologyName().equals(ontologyName)) {
					return magicOntologyRelation;
				}
			}
			
			return null;
		}
	}
	
	public static class OntologyMagicRelations {
		
		public static class OntologyMagicRecord {
			
			private Boolean related;
			private Boolean inOntologyDescription;
			private MagicNumberRecord magicNumberRecord;
			
			public OntologyMagicRecord() {
				super();
				magicNumberRecord = new MagicNumberRecord();
			}

			public OntologyMagicRecord(FileFormatOntology ontology, MagicNumberRecord magicNumberRecord) {
				super();
				this.magicNumberRecord = magicNumberRecord;
				related = false;
				inOntologyDescription = false;
				
				for (MagicOntologyRelation magicOntologyRelation : magicNumberRecord.getOntologyRelations()) {
					if (magicOntologyRelation.getOntologyName().equals(ontology.getName())) {
						related = magicOntologyRelation.getRelated();
						inOntologyDescription = magicOntologyRelation.getInOntologyDescription();
						break;
					}
				}
			}

			public Boolean getRelated() {
				return related;
			}

			public void setRelated(Boolean related) {
				this.related = related;
			}

			public Boolean getInOntologyDescription() {
				return inOntologyDescription;
			}

			public void setInOntologyDescription(Boolean inOntologyDescription) {
				this.inOntologyDescription = inOntologyDescription;
			}

			public MagicNumberRecord getMagicNumberRecord() {
				return magicNumberRecord;
			}

			public void setMagicNumberRecord(MagicNumberRecord magicNumberRecord) {
				this.magicNumberRecord = magicNumberRecord;
			}
			
		}
		
		private List<OntologyMagicRecord> relations;
		private Boolean verified;

		public OntologyMagicRelations() {
			super();
			relations = new LinkedList<OntologyMagicRecord>();
			verified = true;
		}

		public List<OntologyMagicRecord> getRelations() {
			return relations;
		}

		public void addRelation(FileFormatOntology ontology, MagicNumberRecord magicNumberRecord) {
			OntologyMagicRecord ontologyMagicRecord = new OntologyMagicRecord(ontology, magicNumberRecord);
			if (relations == null) {
				relations = new LinkedList<OntologyMagicRecord>();
			}
			relations.add(ontologyMagicRecord);
			
			for (MagicOntologyRelation magicOntologyRelation : magicNumberRecord.getOntologyRelations()) {
				if (magicOntologyRelation.getOntologyName().equals(ontology.getName())) {
					verified = verified && magicOntologyRelation.getVerified();
					break;
				}
			}
		}

		public Boolean getVerified() {
			return verified;
		}

		public void setVerified(Boolean verified) {
			this.verified = verified;
		}
		
		@JsonIgnore
		public int getRelatedCount() {
			int relatedCount = 0;
			
			if (relations == null) {
				return relatedCount;
			}
			
			for (OntologyMagicRecord relation : relations) {
				if (relation.getRelated()) {
					relatedCount++;
				}
			}
			
			return relatedCount;
		}
	}
	
	private List<MagicNumberRecord> magicNumbers;
	private Calendar updateDate;
	private transient ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public MagicNumbers() {
		magicNumbers = new ArrayList<MagicNumberRecord>();
	}

	public List<MagicNumberRecord> getMagicNumbers() {
		return magicNumbers;
	}

	public void setMagicNumbers(List<MagicNumberRecord> magicNumbers) {
		this.magicNumbers = magicNumbers;
	}

	public Calendar getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}

	public void setRwl(ReentrantReadWriteLock rwl) {
		this.rwl = rwl;
	}
	
	public void initOntologyRelations(FileFormatOntology ontology) {
		for (MagicNumberRecord magicNumber : magicNumbers) {
			for (String magicExtension : magicNumber.getExtensions()) {
				if (ontology.getExtensions().contains("." + magicExtension.toLowerCase())) {
					if (magicNumber.getOntologyRelations() == null) {
						magicNumber.setOntologyRelations(new LinkedList<MagicOntologyRelation>());
					}
					// check if relation already exists
					boolean relationExists = false;
					for (MagicOntologyRelation magicOntologyRelation : magicNumber.getOntologyRelations()) {
						if (magicOntologyRelation.getOntologyName().equals(ontology.getName())) {
							relationExists = true;
						}
					}
					if (relationExists) {
						continue;
					}
					magicNumber.getOntologyRelations().add(new MagicOntologyRelation(ontology.getName()));
				}
			}
		}
	}
	
	public OntologyMagicRelations getOntologyRelated(FileFormatOntology ontology) {
		OntologyMagicRelations ontologyRelated = new OntologyMagicRelations();
		for (MagicNumberRecord magicNumber : magicNumbers) {
			for (MagicOntologyRelation magicOntologyRelation : magicNumber.getOntologyRelations()) {
				if (magicOntologyRelation.getOntologyName().equals(ontology.getName())) {
					ontologyRelated.addRelation(ontology, magicNumber);
					break;
				}
			}
		}
		
		return ontologyRelated;
	}
	
	public boolean deleteOntologyRelated(FileFormatOntology ontology) {
		boolean deleted = false;
		for (MagicNumberRecord magicNumber : magicNumbers) {
			Iterator<MagicOntologyRelation> iterator = magicNumber.getOntologyRelations().iterator();
			while (iterator.hasNext()) {
				MagicOntologyRelation magicOntologyRelation = iterator.next();
				if (magicOntologyRelation.getOntologyName().equals(ontology.getName())) {
					iterator.remove();
					deleted = true;
				}
			}
		}
		return deleted;
	}
	
	public boolean setOntologyRelated(Ontology ontology) {
		boolean updated = false;
		for (MagicNumberRecord magicNumber : getMagicNumbers()) {
			if (magicNumber.getOntologyRelations() != null) {
				continue;
			}
			magicNumber.setOntologyRelations(new LinkedList<MagicOntologyRelation>());
			for (FileFormatOntology formatOntology : ontology.getOntologies()) {
				for (String magicExtension : magicNumber.getExtensions()) {
					if (formatOntology.getExtensions().contains("." + magicExtension.toLowerCase())) {
						MagicOntologyRelation magicOntologyRelation = new MagicOntologyRelation(formatOntology.getName());
						magicNumber.getOntologyRelations().add(magicOntologyRelation);
						updated = true;
						break;
					}
				}
			}
		}
		
		return updated;
	}
	
	public boolean addOntologyRelated(FileFormatOntology formatOntology) {
		boolean updated = false;
		for (MagicNumberRecord magicNumber : getMagicNumbers()) {
			for (String magicExtension : magicNumber.getExtensions()) {
				if (formatOntology.getExtensions().contains("." + magicExtension.toLowerCase())) {
					boolean relationSet = false;
					for (MagicOntologyRelation magicOntologyRelation : magicNumber.getOntologyRelations()) {
						if (magicOntologyRelation.getOntologyName().equals(formatOntology.getName())) {
							relationSet = true;
							break;
						}
					}
					if (!relationSet) {
						MagicOntologyRelation magicOntologyRelation = new MagicOntologyRelation(formatOntology.getName());
						magicNumber.getOntologyRelations().add(magicOntologyRelation);
						updated = true;
					}
				}
			}
		}

		return updated;
	}

	public MagicNumberRecord getMagicNumber(int id) {
		return magicNumbers.get(id);
	}
}
