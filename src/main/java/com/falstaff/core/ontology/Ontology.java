package com.falstaff.core.ontology;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.classification.FileFormat;

public class Ontology {

	public boolean remove(Object o) {
		return ontologies.remove(o);
	}

	private Set<FileFormatOntology> ontologies;
	private Set<FileFormatOntology> newOntologies;
	private Set<FileFormatOntology> updatedOntologies;
	private Set<FileFormatOntology> deletedOntologies;
	transient private Set<FileFormat> newFormats;
	transient private List<FileFormat> formats;
	transient private Map<String, FileFormat> formatsMap;
	private Calendar updateDate;
	private transient ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private static final Logger log = LoggerFactory
			.getLogger(Ontology.class.getName());
	
	public Ontology() {
		ontologies = new HashSet<FileFormatOntology>();
	}	

	public int size() {
		return ontologies.size();
	}

	public boolean contains(Object o) {
		return ontologies.contains(o);
	}

	public Iterator<FileFormatOntology> iterator() {
		return ontologies.iterator();
	}

	public boolean add(FileFormatOntology e) {
		return ontologies.add(e);
	}
	
	public Set<String> getUrls() {
		Set<String> urls = new HashSet<String>();
		for (FileFormatOntology formatOntology : ontologies) {
			if (!formatOntology.isError()) {
				urls.add(formatOntology.getFormatUrl());
			}
		}
		return urls;
	}
	
	public FileFormatOntology getByPronomId(String pronomId) {
		for (FileFormatOntology formatOntology : ontologies) {
			Set<String> pronomIds = formatOntology.getPronomIds();
			for (String formatPronomId : pronomIds) {
				if (formatPronomId.equals(pronomId)) {
					return formatOntology;
				}
			}
		}
		return null;
	}
	
	public FileFormatOntology getByUrl(String Url) {
		for (FileFormatOntology formatOntology : ontologies) {
			if (formatOntology.getFormatUrl().equals(Url)) {
				return formatOntology;
			}
		}
		return null;
	}
	
	public FileFormatOntology getByName(String ontologyName) {
		for (FileFormatOntology formatOntology : ontologies) {
			if (formatOntology.getName().equals(ontologyName)) {
				return formatOntology;
			}
		}
		return null;
	}
	
	public Set<Integer> getFileFixedSizes() {
		Set<Integer> fileFixedSizes = new HashSet<Integer>();
		for (FileFormatOntology formatOntology : ontologies) {
			Integer fileFixedSize = formatOntology.getFixedSize();
			if (fileFixedSize != null) {
				fileFixedSizes.add(fileFixedSize);
			}
		}
		return fileFixedSizes;
	}
	
	public Set<Pattern> getFileNamePatterns() {
		Set<Pattern> fileNamePatterns = new HashSet<Pattern>();
		for (FileFormatOntology formatOntology : ontologies) {
			Pattern fileNamePattern = formatOntology.getFileNamePattern();
			if (fileNamePattern != null) {
				fileNamePatterns.add(fileNamePattern);
			}
		}
		return fileNamePatterns;
	}
	
	public List<FileFormat> getFormats() {
		if (formats == null) {
			formats = new ArrayList<FileFormat>();
			for (FileFormatOntology formatOntology : ontologies) {
				formats.addAll(formatOntology.getFileFormats());
			}
		}
		return formats;
	}

	public Set<FileFormatOntology> getNewOntologies() {
		if (newOntologies == null) {
			newOntologies = new HashSet<FileFormatOntology>();
		}
		return newOntologies;
	}

	public Set<FileFormatOntology> getUpdatedOntologies() {
		if (updatedOntologies == null) {
			updatedOntologies = new HashSet<FileFormatOntology>();
		}
		return updatedOntologies;
	}

	public Set<FileFormatOntology> getDeletedOntologies() {
		if (deletedOntologies == null) {
			deletedOntologies = new HashSet<FileFormatOntology>();
		}
		return deletedOntologies;
	}

	public Calendar getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}

	public Set<FileFormatOntology> getOntologies() {
		return ontologies;
	}
	
	public void initUpdates() {
		newOntologies = new HashSet<FileFormatOntology>();
		updatedOntologies = new HashSet<FileFormatOntology>();
		deletedOntologies = new HashSet<FileFormatOntology>();
		newFormats = new HashSet<FileFormat>();
	}
	
	public void setNewFormats() {
		newFormats = new HashSet<FileFormat>();
		if (newOntologies == null) {
			return;
		}
		for (FileFormatOntology formatOntology : newOntologies) {
			FileFormat format = new FileFormat(formatOntology);
			newFormats.add(format);
		}
	}

	public Set<FileFormat> getNewFormats() {
		return newFormats;
	}
	
	public Set<FileFormat> getUpdatedFormats() {
		Set<FileFormat> updatedFormats = new HashSet<FileFormat>();
		if (updatedOntologies == null) {
			return updatedFormats;
		}
		for (FileFormatOntology formatOntology : updatedOntologies) {
			updatedFormats.add(getFormat(formatOntology.getName()));
		}
		return updatedFormats;
	}
	
	public Set<FileFormat> getDeletedFormats() {
		Set<FileFormat> deletedFormats = new HashSet<FileFormat>();
		if (deletedOntologies == null) {
			return deletedFormats;
		}
		for (FileFormatOntology formatOntology : deletedOntologies) {
			deletedFormats.add(getFormat(formatOntology.getName()));
		}
		return deletedFormats;
	}
	
	public Set<FileFormat> getMagicUnsetFormats() {
		Set<FileFormat> magicUnsetFormats = new HashSet<FileFormat>();
		for (FileFormatOntology formatOntology : ontologies) {
			if (!formatOntology.getMagicRelations().getVerified()) {
				magicUnsetFormats.add(getFormat(formatOntology.getName()));
			}
		}
		return magicUnsetFormats;
	}

	public FileFormat getFormat(long id) {
		for (FileFormat fileFormat : formats) {
			if (fileFormat.getId() == id) {
				return fileFormat;
			}
		}
		return null;
	}
	
	public FileFormat getNewFormat(long id) {
		if (newFormats == null) {
			return null;
		}
		for (FileFormat fileFormat : newFormats) {
			if (fileFormat.getId() == id) {
				return fileFormat;
			}
		}
		return null;
	}
	
	public FileFormat getFormat(String name) {
		return formatsMap.get(name);
	}
	
	public void addFormat(FileFormat fileFormat) {
		formats.add(fileFormat);
		formatsMap.put(fileFormat.getName(), fileFormat);
		Collections.sort(formats, new FileFormat.FormatsComparator());
	}

	public Map<String, FileFormat> getFormatsMap() {
		if (formatsMap == null) {
			formatsMap = new HashMap<String, FileFormat>();
		}
		return formatsMap;
	}

	public FileFormat createFormat(Integer formatId) {
		rwl.writeLock().lock();
		FileFormat newFileFormat = null;
		
		try {
			Iterator<FileFormat> iterator = newFormats.iterator();
			while (iterator.hasNext()) {
				FileFormat fileFormat = iterator.next();
				if (formatId == fileFormat.getId()) {
					newFileFormat = fileFormat;
					iterator.remove();
					break;
				}
			}
			
			if (newFileFormat == null) {
				return null;
			}
			
			newOntologies.remove(newFileFormat.getOntology());
			newFileFormat.getOntology().setUpdateDate(Calendar.getInstance());
			ontologies.add(newFileFormat.getOntology());
			
			addFormat(newFileFormat);			
		}
		catch (Exception e) {
			log.error("create of format with id " + formatId + " failed " + e.toString());
		}
		finally {
			rwl.writeLock().unlock();
		}
		
		return newFileFormat;
	}

	public FileFormat updateFormat(FileFormat fileFormat) {
		rwl.writeLock().lock();
		
		try {
			Iterator<FileFormatOntology> iterator = updatedOntologies.iterator();
			FileFormatOntology updatedFileFormatOntology = null;
			while (iterator.hasNext()) {
				FileFormatOntology fileFormatOntology = iterator.next();
				if (fileFormatOntology.getName().equals(fileFormat.getOntology().getName())) {
					updatedFileFormatOntology = fileFormatOntology;
					iterator.remove();
					break;
				}
			}
			
			if (updatedFileFormatOntology == null) {
				return fileFormat;
			}
			
			fileFormat.getOntology().update(updatedFileFormatOntology);		
		}
		catch (Exception e) {
			log.error("update of format with id " + fileFormat.getId() + " failed " + e.toString());
		}
		finally {
			rwl.writeLock().unlock();
		}
		
		return fileFormat;
	}

	public void deleteFormat(FileFormat fileFormat2Delete) {
		rwl.writeLock().lock();
		
		try {
			Iterator<FileFormat> iterator = formats.iterator();
			while (iterator.hasNext()) {
				FileFormat fileFormat = iterator.next();
				if (fileFormat2Delete.getId() == fileFormat.getId()) {
					fileFormat2Delete = fileFormat;
					iterator.remove();
					break;
				}
			}
			
			if (fileFormat2Delete == null) {
				return;
			}
			
			formatsMap.remove(fileFormat2Delete.getName());
			ontologies.remove(fileFormat2Delete.getOntology());
			deletedOntologies.remove(fileFormat2Delete.getOntology());
		}
		catch (Exception e) {
			log.error("delete of format with id " + fileFormat2Delete.getId() + " failed " + e.toString());
		}
		finally {
			rwl.writeLock().unlock();
		}
	}

	public void setRwl(ReentrantReadWriteLock rwl) {
		this.rwl = rwl;
	}
	
}
