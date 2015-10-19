package com.falstaff.core.aligner;

import java.io.File;
import java.util.Collection;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.alignable.sequence.NFormatFile;
import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.feature.NFileExtensionFeature;
import com.falstaff.core.feature.NFileNameRegExpFeature;
import com.falstaff.core.feature.NFileSizeFeature;
import com.falstaff.core.feature.NModificationDateFeature;

public class NFilePropertiesFeatureAssigner extends NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> {
	
	private static final Logger log = LoggerFactory
			.getLogger(NFilePropertiesFeatureAssigner.class.getName());

	private Set<Integer> fileSizes;
	private Set<Pattern> fileNamePatterns;
	
	public NFilePropertiesFeatureAssigner() {
		super();
	}

	public Set<Integer> getFileSizes() {
		return fileSizes;
	}

	public void setFileSizes(Set<Integer> fileSizes) {
		this.fileSizes = fileSizes;
	}

	public Set<Pattern> getFileNamePatterns() {
		return fileNamePatterns;
	}

	public void setFileNamePatterns(Set<Pattern> fileNamePatterns) {
		this.fileNamePatterns = fileNamePatterns;
	}

	@Override
	public Collection<? extends INFeaturedAlignable> transformInternal(
			Collection<? extends INFeaturedAlignable> formatFiles) {
		int assignedFormatFilesCount = 0;
		for (INFeaturedAlignable formatFile : formatFiles) {
			assign(formatFile);
			assignedFormatFilesCount++;
			if (processMonitor != null) {
				processMonitor.setPercentageCompleted(assignedFormatFilesCount * 100 / formatFiles.size());
			}
		}
		return formatFiles;
	}
	
	private void assign(INFeaturedAlignable formatFile) {
		int featuresCount = 0;
		if (fileNamePatterns != null) {
			Set<NFileNameRegExpFeature> fileNameFeatures = NFileNameRegExpFeature.createFileNameRegExpFeatures(formatFile.getFileName(), fileNamePatterns);
			if (fileNameFeatures != null) {
				for (NFileNameRegExpFeature fileNameRegExpFeature : fileNameFeatures) {
					formatFile.addFeature(fileNameRegExpFeature);
					log.info("feature " + fileNameRegExpFeature.getName() + " asigned to file " + formatFile.getFileName());
					featuresCount++;
				}
			}
		}
		
		NFileExtensionFeature fileExtensionFeature = new NFileExtensionFeature(formatFile.getFileName(), true);
		if (fileExtensionFeature.getName() != null) {
			formatFile.addFeature(fileExtensionFeature);
			log.info("feature " + fileExtensionFeature.getName() + " asigned to file " + formatFile.getFileName());
			featuresCount++;
		}
		
		NFileSizeFeature fileSizeFeature = new NFileSizeFeature(formatFile.getFileSize(), true);
		formatFile.addFeature(fileSizeFeature);
		
		if (fileSizes != null) {
			fileSizeFeature = new NFileSizeFeature(formatFile.getFileSize(), fileSizes);
			if (fileSizeFeature.getName() != null) {
				formatFile.addFeature(fileSizeFeature);
				log.info("feature " + fileSizeFeature.getName() + " asigned to file " + formatFile.getFileName());
				featuresCount++;
			}
		}
		
		NModificationDateFeature modificationDateFeature = new NModificationDateFeature(formatFile.getLastModified());
		formatFile.addFeature(modificationDateFeature);
		log.info("feature " + modificationDateFeature.getName() + " asigned to file " + formatFile.getFileName());
		featuresCount++;
		log.debug("number of file features assigned to file " + formatFile.getFileName() + " is " + featuresCount);
	}

	@Override
	public void clear() {
	}

	@Override
	public String getName() {
		return "file propeties features assigner";
	}
}
