package com.falstaff.core.ontology;

import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.ontology.MagicNumbers.MagicNumberRecord;
import com.falstaff.core.ontology.MagicNumbers.OntologyMagicRelations;
import com.falstaff.core.ontology.MagicNumbers.OntologyMagicRelations.OntologyMagicRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class FileFormatOntology {
	public static String formatUrlPrefix = "http://fileformats.archiveteam.org/wiki/";
	private FileFormatOntologyFirstGroup firstGroup;
	private FileFormatOntologySecondGroup secondGroup;
	private String subgroup;
	private String name;
	private Set<String> pronomIds;
	private Set<String> fddIds;
	private Set<String> mimeTypes;
	private Set<String> extensions;
	private String formatUrl;
	private Set<String> formatUrlHeaders;
	private Set<SampleUrl> sampleUrls;
	private String fileNameRegularExpression;
	private transient Pattern fileNamePattern;
	private Integer fixedSize;
	boolean error;
	private String sync;
	private Calendar updateDate;
	private transient OntologyMagicRelations magicRelations;

	public static class SampleUrl {
		private String url;
		private String description;
		private Integer samplesNumber;
			
		public SampleUrl() {
			super();
		}

		public SampleUrl(String url, String description) {
			super();
			this.url = url;
			this.description = description;
		}
		
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getSamplesNumber() {
			return samplesNumber;
		}

		public void setSamplesNumber(Integer samplesNumber) {
			this.samplesNumber = samplesNumber;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((url == null) ? 0 : url.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SampleUrl other = (SampleUrl) obj;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (url == null) {
				if (other.url != null)
					return false;
			} else if (!url.equals(other.url))
				return false;
			return true;
		}

		/*
		private FileFormatOntology getOuterType() {
			return FileFormatOntology.this;
		}
		*/
		
	}
	
	public FileFormatOntology() {
		super();
	}

	public FileFormatOntology(FileFormatOntologyFirstGroup firstGroup, FileFormatOntologySecondGroup secondGroup, String name) {
		super();
		this.firstGroup = firstGroup;
		this.secondGroup = secondGroup;
		this.name = name;
		pronomIds = new HashSet<String>();
		fddIds = new HashSet<String>();
		mimeTypes = new HashSet<String>();
		extensions = new HashSet<String>();
		formatUrlHeaders = new HashSet<String>();
		sampleUrls = new HashSet<SampleUrl>();
		error = false;
	}

	public FileFormatOntology(String formatUrl) {
		super();
		this.formatUrl = formatUrl;
		error = true;
	}

	public void addPronomId(String pronomId) {
		pronomIds.add(pronomId);
	}
	
	public void addFddId(String fddId) {
		fddIds.add(fddId);
	}
	
	public void addExtension(String extension) {
		extensions.add(extension);
	}
	
	public void addMimeType(String mimeType) {
		mimeTypes.add(mimeType);
	}
	
	public void addFormatUrlHeader(String header) {
		formatUrlHeaders.add(header);
	}
	
	public void addSampleUrl(String url, String text) {
		SampleUrl sampleUrl = new SampleUrl(url, text);
		sampleUrls.add(sampleUrl);
	}

	public String getFormatUrl() {
		return formatUrl;
	}

	public void setFormatUrl(String formatUrl) {
		this.formatUrl = formatUrl;
	}

	public FileFormatOntologySecondGroup getSecondGroup() {
		return secondGroup;
	}
	
	public FileFormatOntologyFirstGroup getFirstGroup() {
		return firstGroup;
	}

	public String getName() {
		return name;
	}

	public Set<String> getPronomIds() {
		if (pronomIds == null) {
			pronomIds = new HashSet<String>();
		}
		return pronomIds;
	}

	public Set<String> getFddIds() {
		if (fddIds == null) {
			fddIds = new HashSet<String>();
		}
		return fddIds;
	}

	public Set<String> getMimeTypes() {
		if (mimeTypes == null) {
			mimeTypes = new HashSet<String>();
		}
		return mimeTypes;
	}

	public Set<String> getExtensions() {
		if (extensions == null) {
			extensions = new HashSet<String>();
		}
		return extensions;
	}

	public Set<String> getFormatUrlHeaders() {
		if (formatUrlHeaders == null) {
			formatUrlHeaders = new HashSet<String>();
		}
		return formatUrlHeaders;
	}

	public Set<SampleUrl> getSampleUrls() {
		if (sampleUrls == null) {
			sampleUrls = new HashSet<SampleUrl>();
		}
		return sampleUrls;
	}

	public String getSubgroup() {
		return subgroup;
	}

	public void setSubgroup(String subgroup) {
		this.subgroup = subgroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((formatUrl == null) ? 0 : formatUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileFormatOntology other = (FileFormatOntology) obj;
		if (formatUrl == null) {
			if (other.formatUrl != null)
				return false;
		} else if (!formatUrl.equals(other.formatUrl))
			return false;
		return true;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	
	
	@JsonIgnore
	public String getFullName() {
		char separator = '/';
		StringBuilder sb = new StringBuilder();
		sb.append(firstGroup.toString()).append(separator)
				.append(secondGroup.toString()).append(separator);
		sb.append(nameToFileName());

		return sb.toString();
	}

	public String nameToFileName() {
		char separator = '/';
		char escape = '%';
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (ch < ' ' || ch >= 0x7F || ch == separator || ch == ' '
					|| (ch == '.' && i == 0) // we don't want to collide with
												// "." or ".."!
					|| ch == '(' || ch == ')' || ch == ':' || ch == escape) {
				sb.append(escape);
				if (ch < 0x10) {
					sb.append('0');
				}
				sb.append(Integer.toHexString(ch));
			} else {
				sb.append(ch);
			}
		}
		
		
		return sb.toString();
	}
	
	
	@JsonIgnore
	public Pattern getFileNamePattern() {
		if (fileNamePattern == null && fileNameRegularExpression != null) {
			fileNamePattern = Pattern.compile(fileNameRegularExpression);
		}
		return fileNamePattern;
	}

	@JsonIgnore
	public void setFileNamePattern(String fileNameRegularExpression) {
		this.fileNameRegularExpression = fileNameRegularExpression;
		this.fileNamePattern = Pattern.compile(fileNameRegularExpression);
	}

	public Integer getFixedSize() {
		return fixedSize;
	}

	public String getFileNameRegularExpression() {
		return fileNameRegularExpression;
	}

	public void setFixedSize(Integer fixedSize) {
		this.fixedSize = fixedSize;
	}
	
	@JsonIgnore
	public List<FileFormat> getFileFormats() {
		List<FileFormat> fileFormats = new LinkedList<FileFormat>();
		// main format
		FileFormat fileFormat = new FileFormat(name, this);
		fileFormats.add(fileFormat);
		for (String pronomId : pronomIds) {
			fileFormat = new FileFormat(pronomId, this);
			fileFormats.add(fileFormat);
		}
		return fileFormats;
	}

	public String getSync() {
		if (sync == null) {
			sync = "";
		}
		return sync;
	}
	
	@JsonIgnore
	public String getSyncHtml() {
		return getSync().replaceAll("was removed","was removed <br />").replaceAll("was added","was added <br />");
	}

	@JsonIgnore
	public void setSync(FileFormatOntology ontology) {
		
		sync = "";

		if (!getName().equals(ontology.getName())) {
			sync += "name changed from " + getName() + " to "
					+ ontology.getName() + "\n";
		}

		// format groups

		// first group
		if (!getFirstGroup().getName()
				.equals(ontology.getFirstGroup().getName())) {
			sync += "first group changed from "
					+ getFirstGroup().getName() + " to "
					+ ontology.getFirstGroup().getName() + "\n";
		}

		if (!getSecondGroup().getName()
				.equals(ontology.getSecondGroup().getName())) {
			sync += "second group changed from "
					+ getSecondGroup().getName() + " to "
					+ ontology.getSecondGroup().getName() + "\n";
		}

		// extensions
		for (String extension1 : getExtensions()) {
			if (!ontology.getExtensions().contains(extension1)) {
				sync += "extension " + extension1 + " was removed\n";
			}
		}

		for (String extension2 : ontology.getExtensions()) {
			if (!getExtensions().contains(extension2)) {
				sync += "extension " + extension2 + " was added\n";
			}
		}

		// mime
		for (String mime1 : getMimeTypes()) {
			if (!ontology.getMimeTypes().contains(mime1)) {
				sync += "MIME type" + mime1 + " was removed\n";
			}
		}

		for (String mime2 : ontology.getMimeTypes()) {
			if (!getMimeTypes().contains(mime2)) {
				sync += "MIME type " + mime2 + " was added\n";
			}
		}

		// fdd
		for (String fddId1 : getFddIds()) {
			if (!ontology.getFddIds().contains(fddId1)) {
				sync += "fdd id " + fddId1 + " was removed\n";
			}
		}

		for (String fddId2 : ontology.getFddIds()) {
			if (!getFddIds().contains(fddId2)) {
				sync += "fdd id " + fddId2 + " was added\n";
			}
		}

		// pronom
		for (String pronomId1 : getPronomIds()) {
			if (!ontology.getPronomIds().contains(pronomId1)) {
				sync += "pronom id " + pronomId1 + " was removed\n";
			}
		}

		for (String pronomId2 : ontology.getPronomIds()) {
			if (!getPronomIds().contains(pronomId2)) {
				sync += "pronom id " + pronomId2 + " was added\n";
			}
		}

		// all links in the sample file
		for (SampleUrl url2 : ontology.getSampleUrls()) {
			if (!getSampleUrls().contains(url2)) {
				sync += "sample URL " + url2.getUrl() + " was added\n";
			}
		}

		// page headers
		for (String header1 : getFormatUrlHeaders()) {
			if (!ontology.getFormatUrlHeaders().contains(header1)) {
				sync += "description header " + header1 + " was removed\n";
			}
		}

		for (String header2 : ontology.getFormatUrlHeaders()) {
			if (!getFormatUrlHeaders().contains(header2)) {
				sync += "description header " + header2 + " was added\n";
			}
		}
	}
	
	@JsonIgnore
	public boolean isAutomaticUpdate(FileFormatOntology ontology) {
		
		if (!getName().equals(ontology.getName())) {
			return false;
		}
		
		for (String extension1 : getExtensions()) {
			if (!ontology.getExtensions().contains(extension1)) {
				return false;
			}
		}

		for (String extension2 : ontology.getExtensions()) {
			if (!getExtensions().contains(extension2)) {
				return false;
			}
		}
		
		for (String pronomId1 : getPronomIds()) {
			if (!ontology.getPronomIds().contains(pronomId1)) {
				return false;
			}
		}

		for (String pronomId2 : ontology.getPronomIds()) {
			if (!getPronomIds().contains(pronomId2)) {
				return false;
			}
		}
		
		for (SampleUrl url2 : ontology.getSampleUrls()) {
			if (!getSampleUrls().contains(url2)) {
				return false;
			}
		}
		
		return true;
	}
	
	public void update(FileFormatOntology ontology) {
		setName(ontology.getName());
		setFirstGroup(ontology.getFirstGroup());
		setSecondGroup(ontology.getSecondGroup());
		getExtensions().clear();
		getExtensions().addAll(ontology.getExtensions());
		getMimeTypes().clear();
		getMimeTypes().addAll(ontology.getMimeTypes());
		getFddIds().clear();
		getFddIds().addAll(ontology.getFddIds());
		getPronomIds().clear();
		getPronomIds().addAll(ontology.getPronomIds());
		for (SampleUrl sampleUrl : ontology.getSampleUrls()) {
			addSampleUrl(sampleUrl.getUrl(), sampleUrl.getDescription());
		}
		getFormatUrlHeaders().clear();
		getFormatUrlHeaders().addAll(ontology.getFormatUrlHeaders());
		
		sync = "";
		setUpdateDate(Calendar.getInstance());
	}
	
	@JsonIgnore
	public boolean isAutomaticCreate() {
		
		if (getPronomIds().size() > 0) {
			return false;
		}
		
		if (getSampleUrls().size() > 0) {
			return false;
		}
		
		return true;
	}	

	public Calendar getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}

	public void setFirstGroup(FileFormatOntologyFirstGroup firstGroup) {
		this.firstGroup = firstGroup;
	}

	public void setSecondGroup(FileFormatOntologySecondGroup secondGroup) {
		this.secondGroup = secondGroup;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OntologyMagicRelations getMagicRelations() {
		return magicRelations;
	}

	public void setMagicRelations(OntologyMagicRelations magicRelations) {
		this.magicRelations = magicRelations;
	}
	
	@JsonIgnore
	public List<MagicNumberRecord> getRelatedMagicNumberRecords() {
		List<MagicNumberRecord> records = new LinkedList<MagicNumberRecord>();
		if (!magicRelations.getVerified()) {
			return records;
		}
		for (OntologyMagicRecord relation : magicRelations.getRelations()) {
			if (relation.getRelated()) {
				records.add(relation.getMagicNumberRecord());
			}
		}
		
		return records;
	}
}
