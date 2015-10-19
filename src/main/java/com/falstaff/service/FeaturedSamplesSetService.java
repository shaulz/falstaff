package com.falstaff.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.alignable.sequence.NSequenceAlignable;
import com.falstaff.core.aligner.NAbstractAligner;
import com.falstaff.core.classification.FeaturedClassifier;
import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FeaturedSample;
import com.falstaff.core.classification.FeaturedSignaturesSet;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.crawler.ILocalSamplesDownloader;
import com.falstaff.crawler.IRemoteSamplesDownloader;
import com.falstaff.crawler.RemoteSamplesDownloader;
import com.falstaff.repository.dao.FeaturedSamplesSetDao;
import com.falstaff.repository.dao.FileFormatDao;

@Service
public class FeaturedSamplesSetService {

	@Autowired
	FeaturedSamplesSetDao featuredSamplesSetDao;
	
	@Autowired
	FileFormatDao fileFormatDao;
	
	@Autowired
	AsyncSamplesDownloader asyncSamplesDownloader;
	
	@Value("${falstaff.core.aligner.filter_extensions}")
	private boolean filterExtensions;
	
	@Value("${falstaff.core.aligner.max_align_samples}")
	private int maxAlignSamples;
	
	@Value("${falstaff.core.classification.max_train_samples}")
	private int maxTrainSamples;
	
	@Value("${falstaff.core.classification.min_test_samples}")
	private int minTestSamples;
	
	@PostConstruct
	public void init() {
		FeaturedSamplesSet.maxAlignSamplesDefault = maxAlignSamples;
		FeaturedSamplesSet.maxTrainSamplesDefault = maxTrainSamples;
		FeaturedSamplesSet.minTestSamplesDefault = minTestSamples;
	}

	public void createAll() throws IOException {
		List<FileFormat> fileFormats = fileFormatDao.getFormats();
		for (FileFormat fileFormat : fileFormats) {
			FileFormatOntology fileOntology = fileFormat.getOntology();
			if (!fileFormat.getName().equals(fileOntology.getName())) {
				continue;
			}
			
			// archiveteam samples
			String samplesSetName = "archiveteam";
			String fullName = fileOntology.getFullName();
			File samplesDir = new File("F:\\fileformats\\archiveteam", fullName);
			create(samplesSetName, fileFormat, samplesDir.getAbsolutePath(), true);
			
			// versions			
			for (int i = 1; i <= 3; i++) {
				String version = "v" + i;
				samplesSetName = "archiveteam" + "/" + version;
				fullName = fileOntology.getFullName() + "\\" + version;
				samplesDir = new File("F:\\fileformats\\archiveteam", fullName);
				create(samplesSetName, fileFormat, samplesDir.getAbsolutePath(), true);
			}
			
			// openplanets samples
			fullName = fileOntology.getFullName();
			Set<String> puids = fileOntology.getPronomIds();
			if (puids == null) {
				continue;
			}
			for (String puid : puids) {
				samplesDir = new File("F:\\pronom\\openplanets", puid);
				samplesSetName = puid;
				create(samplesSetName, fileFormat, samplesDir.getAbsolutePath(), false);
			}
			
		}
	}
	
	private FeaturedSamplesSet create(String samplesSetName, FileFormat fileFormat, String path, boolean filterExtensions) throws IOException {		
		FeaturedSamplesSet samplesSet = new FeaturedSamplesSet(samplesSetName, path, fileFormat, maxTrainSamples, minTestSamples, maxAlignSamples);
		if (samplesSet.getSamples().size() > 0) {
			fileFormat.updateSamplesSet(samplesSet);
			featuredSamplesSetDao.save(samplesSet);
			return samplesSet;
		}
		return null;
	}
	
	public FeaturedSamplesSet create(FeaturedSamplesSet samplesSet) throws IOException {
		samplesSet.setCreated(Calendar.getInstance());
		samplesSet.setUpdated(samplesSet.getCreated());
		featuredSamplesSetDao.createSamplesSetFolder(samplesSet);
		featuredSamplesSetDao.save(samplesSet);
		return samplesSet;
	}	

	public FeaturedSamplesSet setFormat(FeaturedSamplesSet samplesSet, FileFormat fileFormat) throws IOException {
		samplesSet.setFormat(fileFormat);
		fileFormat.updateSamplesSet(samplesSet);
		return samplesSet;
	}
	
	public void save(FeaturedSamplesSet samplesSet) throws IOException {
		featuredSamplesSetDao.save(samplesSet);
	}

	public FeaturedSample createSample(byte[] bytes, String originalName,
			long modificationDate, FeaturedSamplesSet samplesSet) throws IOException {
		String samplesSetFolder = samplesSet.getFolder();
		Path samplePath = Paths.get(samplesSetFolder, originalName);
		Files.write(samplePath , bytes);
		Files.setLastModifiedTime(samplePath, FileTime.fromMillis(modificationDate));
		FeaturedSample featuredSample = new FeaturedSample(samplePath.toFile().getName(), samplesSet);
		samplesSet.addSample(featuredSample);
		return featuredSample;
	}
	
	public FeaturedSample getSample(FeaturedSamplesSet samplesSet, int sampleId) {
		FeaturedSample sample = samplesSet.getSample(sampleId);
		
		FeaturedClassifier classifier = samplesSet.getFormat().getClassifier();
		if (classifier != null) {
			sample.setFeatures(null);
			List<INFeaturedAlignable<IKtup>> featuredSamples = new LinkedList<INFeaturedAlignable<IKtup>>();
			featuredSamples.add(sample);
			NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> featureAssigner = classifier.getFeatureAssigner();
			samplesSet.setFeatures(featuredSamples, featureAssigner, 1);
		}
		return sample;
	}
	
	public void setSamples(FeaturedSamplesSet samplesSet) throws IOException {
		samplesSet.setSamples();
	}
	
	public void downloadRemote(IRemoteSamplesDownloader samplesDownloader) throws IOException {
		ProcessMonitor processMonitor = new ProcessMonitor();
		processMonitor.setProcessName("downloading from url " + samplesDownloader.getUrl());
		samplesDownloader.getSamplesSet().setProcessMonitor(processMonitor);
		asyncSamplesDownloader.downloadRemote(samplesDownloader);
	}
	
	public void downloadLocalRecursive(ILocalSamplesDownloader samplesDownloader) throws IOException {
		ProcessMonitor processMonitor = new ProcessMonitor();
		processMonitor.setProcessName("downloading from folder " + samplesDownloader.getFolder());
		samplesDownloader.getSamplesSet().setProcessMonitor(processMonitor);
		asyncSamplesDownloader.downloadLocalRecursive(samplesDownloader);
	}
	
	public void delete(FeaturedSamplesSet samplesSet) throws IOException {
		featuredSamplesSetDao.delete(samplesSet);
		samplesSet.getFormat().clearSamplesSet(samplesSet.getId());
		fileFormatDao.save(samplesSet.getFormat());
	}
}
