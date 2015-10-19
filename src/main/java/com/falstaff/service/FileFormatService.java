package com.falstaff.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falstaff.core.classification.FeaturedSample;
import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.classification.FormatQuery;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.core.ontology.FileFormatOntologyFirstGroup;
import com.falstaff.core.ontology.FileFormatOntologySecondGroup;
import com.falstaff.crawler.FileFormatsCrawler;
import com.falstaff.repository.dao.FileFormatDao;

@Service
public class FileFormatService {

	@Autowired
	private FileFormatDao fileFormatDao;
	
	@Autowired
	private AsyncOntologyUpdater asyncOntologyUpdater;
	
	@Autowired
	FileFormatsCrawler fileFormatsCrawler;
	
	@Autowired
	OntologyService ontologyService;
	
	@Autowired
	MagicNumberService magicNumberService;
	
	public static class ClassifiedFileFormatOntologyFirstGroup {
		private FileFormatOntologyFirstGroup fileFormatOntologyFirstGroup;
		private Boolean missClassified;
		
		public ClassifiedFileFormatOntologyFirstGroup(
				FileFormatOntologyFirstGroup fileFormatOntologyFirstGroup,
				Boolean missClassified) {
			super();
			this.fileFormatOntologyFirstGroup = fileFormatOntologyFirstGroup;
			this.missClassified = missClassified;
		}

		public FileFormatOntologyFirstGroup getFileFormatOntologyFirstGroup() {
			return fileFormatOntologyFirstGroup;
		}

		public void setFileFormatOntologyFirstGroup(
				FileFormatOntologyFirstGroup fileFormatOntologyFirstGroup) {
			this.fileFormatOntologyFirstGroup = fileFormatOntologyFirstGroup;
		}

		public Boolean getMissClassified() {
			return missClassified;
		}

		public void setMissClassified(Boolean missClassified) {
			this.missClassified = missClassified;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((fileFormatOntologyFirstGroup == null) ? 0
							: fileFormatOntologyFirstGroup.hashCode());
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
			ClassifiedFileFormatOntologyFirstGroup other = (ClassifiedFileFormatOntologyFirstGroup) obj;
			if (fileFormatOntologyFirstGroup != other.fileFormatOntologyFirstGroup)
				return false;
			return true;
		}
	}
	
	public static class ClassifiedFileFormatOntologySecondGroup {
		private FileFormatOntologySecondGroup fileFormatOntologySecondGroup;
		private Boolean missClassified;
		
		public ClassifiedFileFormatOntologySecondGroup(
				FileFormatOntologySecondGroup fileFormatOntologySecondGroup,
				Boolean missClassified) {
			super();
			this.fileFormatOntologySecondGroup = fileFormatOntologySecondGroup;
			this.missClassified = missClassified;
		}

		public FileFormatOntologySecondGroup getFileFormatOntologySecondGroup() {
			return fileFormatOntologySecondGroup;
		}

		public void setFileFormatOntologySecondGroup(
				FileFormatOntologySecondGroup fileFormatOntologySecondGroup) {
			this.fileFormatOntologySecondGroup = fileFormatOntologySecondGroup;
		}

		public Boolean getMissClassified() {
			return missClassified;
		}

		public void setMissClassified(Boolean missClassified) {
			this.missClassified = missClassified;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((fileFormatOntologySecondGroup == null) ? 0
							: fileFormatOntologySecondGroup.hashCode());
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
			ClassifiedFileFormatOntologySecondGroup other = (ClassifiedFileFormatOntologySecondGroup) obj;
			if (fileFormatOntologySecondGroup != other.fileFormatOntologySecondGroup)
				return false;
			return true;
		}
	}
		
	public Map<ClassifiedFileFormatOntologyFirstGroup, Map<ClassifiedFileFormatOntologySecondGroup,List<FileFormat>>> getFormatsTree(Set<FileFormat> filter, boolean include) {
		Map<ClassifiedFileFormatOntologyFirstGroup, Map<ClassifiedFileFormatOntologySecondGroup,List<FileFormat>>> formatsTree = new LinkedHashMap<ClassifiedFileFormatOntologyFirstGroup, Map<ClassifiedFileFormatOntologySecondGroup,List<FileFormat>>>();
		for (FileFormat format : fileFormatDao.getFormats()) {
			if (filter != null && !filter.contains(format) && include) {
				continue;
			}
			if (filter != null && filter.contains(format) && !include) {
				continue;
			}
			FileFormatOntology formatOntology = format.getOntology();
			if (!format.getName().equals(formatOntology.getName())) {
				continue;
			}
			FileFormatOntologyFirstGroup firstGroup = formatOntology.getFirstGroup();
			ClassifiedFileFormatOntologyFirstGroup classifiedFileFormatOntologyFirstGroup = new ClassifiedFileFormatOntologyFirstGroup(firstGroup, format.isMissClassified());
			if (!formatsTree.containsKey(classifiedFileFormatOntologyFirstGroup)) {
				formatsTree.put(classifiedFileFormatOntologyFirstGroup, new LinkedHashMap<ClassifiedFileFormatOntologySecondGroup,List<FileFormat>>());
			}
			else {
				if (format.isMissClassified() != null && format.isMissClassified()) {
					Map<ClassifiedFileFormatOntologySecondGroup, List<FileFormat>> value = formatsTree.get(classifiedFileFormatOntologyFirstGroup);
					formatsTree.remove(classifiedFileFormatOntologyFirstGroup);
					formatsTree.put(classifiedFileFormatOntologyFirstGroup, value);
				}
			}
			Map<ClassifiedFileFormatOntologySecondGroup,List<FileFormat>> secondGroupFormatsTree = formatsTree.get(classifiedFileFormatOntologyFirstGroup);
			FileFormatOntologySecondGroup secondGroup = formatOntology.getSecondGroup();
			ClassifiedFileFormatOntologySecondGroup classifiedFileFormatOntologySecondGroup = new ClassifiedFileFormatOntologySecondGroup(secondGroup, format.isMissClassified());
			if (!secondGroupFormatsTree.containsKey(classifiedFileFormatOntologySecondGroup)) {
				secondGroupFormatsTree.put(classifiedFileFormatOntologySecondGroup, new LinkedList<FileFormat>());
			}
			else {
				if (format.isMissClassified() != null && format.isMissClassified()) {
					List<FileFormat> value = secondGroupFormatsTree.get(classifiedFileFormatOntologySecondGroup);
					secondGroupFormatsTree.remove(classifiedFileFormatOntologySecondGroup);
					secondGroupFormatsTree.put(classifiedFileFormatOntologySecondGroup, value);
				}				
			}
			List<FileFormat> formatsList = secondGroupFormatsTree.get(classifiedFileFormatOntologySecondGroup);
			formatsList.add(format);
		}
		
		return formatsTree;
	}
	
	public void save(FileFormat fileFormat) throws IOException {
		List<FeaturedSamplesSet> samplesSets = fileFormat.getSamples();
		if (samplesSets != null) {
			for (FeaturedSamplesSet samplesSet : samplesSets) {
				List<FeaturedSample> samples = samplesSet.getSamples();
				if (samples == null) {
					continue;
				}
				for (FeaturedSample sample : samples) {
					sample.setFeatures(null);
				}
			}
		}
		fileFormatDao.save(fileFormat);
	}
	
	public void updateFileFormatsAll() throws IOException {
		ProcessMonitor processMonitor = new ProcessMonitor();
		fileFormatsCrawler.setProcessMonitor(processMonitor);
		asyncOntologyUpdater.update();
	}
	
	public Set<FileFormat> getNewFormats() {
		return ontologyService.getOntology().getNewFormats();
	}
	
	public Set<FileFormat> getUpdatedFormats() {
		return ontologyService.getOntology().getUpdatedFormats();
	}
	
	public Set<FileFormat> getDeletedFormats() {
		return ontologyService.getOntology().getDeletedFormats();
	}
	
	public Set<FileFormat> getMagicUnsetFormats() {
		return ontologyService.getOntology().getMagicUnsetFormats();
	}
	
	public FileFormat getNewFormat(long id) {
		return ontologyService.getOntology().getNewFormat(id);
	}

	public synchronized FileFormat createFormat(Integer formatId) throws IOException {
		FileFormat fileFormat = ontologyService.getOntology().createFormat(formatId);
		if (fileFormat != null) {
			fileFormat.getClassifier().addFormat(fileFormat);
			save(fileFormat);
			ontologyService.saveOntology();
		}
		
		magicNumberService.addOntologyRelated(fileFormat.getOntology());
		
		return fileFormat;
	}
	
	public synchronized FileFormat updateFormat(FileFormat fileFormat) throws IOException {
		fileFormat = ontologyService.getOntology().updateFormat(fileFormat);
		if (fileFormat != null) {
			save(fileFormat);
			ontologyService.saveOntology();
		}
		
		magicNumberService.addOntologyRelated(fileFormat.getOntology());
		
		return fileFormat;
	}
	
	public synchronized void deleteFormat(FileFormat fileFormat) throws IOException {
		ontologyService.getOntology().deleteFormat(fileFormat);
		ontologyService.saveOntology();
		magicNumberService.deleteOntologyRelated(fileFormat.getOntology());
	}
	
	public List<FileFormat> searchFormats(FormatQuery query) {
		List<FileFormat> formats = new LinkedList<FileFormat>();
		
		Set<FileFormat> formatsAll = null;
		
		if (!query.getPending()) {
			formatsAll = new HashSet<FileFormat>(fileFormatDao.getFormats());
		}
		else {
			if (query.getPendingQueue().equals(FormatQuery.PendingQueue.update)) {
				formatsAll = getUpdatedFormats();
			}
			
			if (query.getPendingQueue().equals(FormatQuery.PendingQueue.create)) {
				formatsAll = getNewFormats();
			}
			
			if (query.getPendingQueue().equals(FormatQuery.PendingQueue.delete)) {
				formatsAll = getDeletedFormats();
			}
			
			if (query.getPendingQueue().equals(FormatQuery.PendingQueue.magic)) {
				formatsAll = getMagicUnsetFormats();
			}
		}
		
		if (query.getExtension() != null && !query.getExtension().equals("") && !query.getExtension().startsWith(".")) {
			query.setExtension("." + query.getExtension());
		}
		
		for (FileFormat format : formatsAll) {
			if (!format.getName().equals(format.getOntology().getName())) {
				continue;
			}
			
			if (query.getName() != null && !query.getName().equals("")) {
				if (!format.getName().equalsIgnoreCase(query.getName())) {
					continue;
				}
			}
			
			if (query.getExtension() != null && !query.getExtension().equals("")) {
				if (!format.getOntology().getExtensions().contains(query.getExtension().toLowerCase())) {
					continue;
				}					
			}
			
			if (query.getPronomId() != null && !query.getPronomId().equals("")) {
				if (!format.getPronomIds().contains(query.getPronomId().toLowerCase())) {
					continue;
				}					
			}
			
			if (query.getFddId() != null && !query.getFddId().equals("")) {
				if (!format.getFddIds().contains(query.getFddId().toLowerCase())) {
					continue;
				}					
			}
			
			if (query.getMimeType() != null && !query.getMimeType().equals("")) {
				if (!format.getMimeTypes().contains(query.getMimeType().toLowerCase())) {
					continue;
				}					
			}
			
			formats.add(format);
		}
		
		Collections.sort(formats, query.new FormatQuerySort());
		
		return formats;
	}

	public List<FileFormat> getFormats() {
		return fileFormatDao.getFormats();
	}
	
	
}
