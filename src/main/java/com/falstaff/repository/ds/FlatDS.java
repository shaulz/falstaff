package com.falstaff.repository.ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FeaturedClassifier;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.repository.ds.FlatDSPaths;
import com.thoughtworks.xstream.XStream;

@Component
public class FlatDS {
	
	@Autowired
	Environment environment;

	public static final String formatFile = "format.xml";
	public static final String pronomFile = "pronom.xml";
	public static final String classifierFile = "classifier.xml";
	public static final String classifierDataFile = "classifier.data";
	public static final String ontologyFile = "ontology.xml";
	public static final String magicNumbersFile = "magicNumbers.xml";

	private static final Logger log = LoggerFactory
	.getLogger(FlatDS.class.getName());
	
	@Value("#{ environment['FALSTAFF_HOME'] }/data")
	private String repositoryRoot;
	
	@Value("${falstaff.core.classification.samples_root}")
	private String samplesRoot;

	private File data;
	private File formatsRoot;
	private File classifiersRoot;
	private File pronomRoot;
	
	public File getFormatsRoot() {
		return formatsRoot;
	}	

	public FlatDS() throws IOException {
	}

	@PostConstruct
	private void init() throws IOException {
		data = new File(repositoryRoot);
		formatsRoot = new File(data, FlatDSPaths.formatsDir);
		classifiersRoot = new File(data,FlatDSPaths.classifiersDir);
		pronomRoot = new File(data,FlatDSPaths.pronomDir);
		if (!data.exists()) {
			if (!data.mkdirs()) {
				throw new IOException("Unable to create "
						+ data.getAbsolutePath());
			}
		}
		if (!formatsRoot.exists()) {
			if (!formatsRoot.mkdir()) {
				throw new IOException("Unable to create "
						+ formatsRoot.getAbsolutePath());
			}
		}
		if (!classifiersRoot.exists()) {
			if (!classifiersRoot.mkdir()) {
				throw new IOException("Unable to create "
						+ classifiersRoot.getAbsolutePath());
			}
		}
		if (!pronomRoot.exists()) {
			if (!pronomRoot.mkdir()) {
				throw new IOException("Unable to create "
						+ pronomRoot.getAbsolutePath());
			}
		}
	}
	
/*		
	private String formatSampleTypeDir(FormatSampleSetType type) {
		if (type.equals(FormatSampleSetType.TRAIN)) {
			return trainDir;
		}
		if (type.equals(FormatSampleSetType.TEST)) {
			return testDir;
		}
		return null;
	}
	
	public File formatSampleSetPath(Format format) {		
		File dirPath = new File(formatsRoot, format.getName());
		dirPath = new File(dirPath,FlatDSPaths.formatSetsDir);
		return dirPath;
	}
	
	public File formatSampleSetPath(FormatSampleSet formatSampleSet) {		
		File dirPath = new File(formatsRoot, formatSampleSet.getFormatName());
		dirPath = new File(dirPath,FlatDSPaths.formatSetsDir);
		dirPath = new File(dirPath, formatSampleSet.getName());
		return dirPath;
	}

	public File formatSampleSetPath(FormatSampleSet formatSampleSet, FormatSampleSetType type) {		
		File dirPath = new File(formatsRoot, formatSampleSet.getFormatName());
		dirPath = new File(dirPath,FlatDSPaths.formatSetsDir);
		dirPath = new File(dirPath, formatSampleSet.getName());
		dirPath = new File(dirPath,formatSampleTypeDir(type));
		return dirPath;
	}
	
	public File formatSampleSetMetadataPath(FormatSampleSet formatSampleSet, FormatSampleSetType type) {
		File metadataPath = new File(formatSampleSetPath(formatSampleSet, type), FlatDS.formatSampleSetMetadataFile);
		return metadataPath;
	}
	
	public File formatSamplePath(FormatSampleSet formatSampleSet, FormatSampleSetType type, FormatSample formatSample) {
		File formatSamplePath = new File(formatSampleSetPath(formatSampleSet, type), formatSample.getName());
		return formatSamplePath;
	}
	
	public File signatureSetPath(FormatSampleSet formatSampleSet) {		
		File signatureSetPath = new File(formatsRoot,formatSampleSet.getFormatName());
		signatureSetPath = new File(signatureSetPath, FlatDSPaths.formatSetsDir);
		signatureSetPath = new File(signatureSetPath, formatSampleSet.getName());
		signatureSetPath = new File(signatureSetPath, FlatDSPaths.signaturesDir);
		signatureSetPath = new File(signatureSetPath, formatSampleSetSignaturesFile);
		return signatureSetPath;
	}
	
	public File signatureSetPath(Format format) {		
		File signatureSetPath = formatPath(format);
		signatureSetPath = new File(signatureSetPath, FlatDSPaths.signaturesDir);
		signatureSetPath = new File(signatureSetPath, formatSampleSetSignaturesFile);
		return signatureSetPath;
	}
	
	public File signatureSetPath() {	
		File signatureSetPath = new File(signaturesRoot, formatSampleSetSignaturesFile);
		return signatureSetPath;
	}
	*/
	public File getSignaturesPath(FileFormatOntology formatOntology, String classifierName, String signaturesName, String signaturesSource) {
		String ontologyName = formatOntology.getFullName();
		File signaturesRoot = new File(data, "signatures");
		File signaturesPath = new File(signaturesRoot, ontologyName);
		signaturesPath = new File(signaturesPath, FlatDSPaths.classifierFolder);
		signaturesPath = new File(signaturesPath, classifierName);
		signaturesPath = new File(signaturesPath, signaturesName);
		signaturesPath = new File(signaturesPath, signaturesSource);
		signaturesPath = new File(signaturesPath, "signatures.xml");
		return signaturesPath;
	}
	
	public void createSamplesSetFolder(FeaturedSamplesSet samplesSet) throws IOException {
		String ontologyName = samplesSet.getFormat().getOntology().getFullName();
		File samplesSetFolder = new File(samplesRoot, ontologyName);
		samplesSetFolder = new File(samplesSetFolder, formatFolderName(samplesSet.getFormat()));
		samplesSetFolder = new File(samplesSetFolder, samplesSet.getName());
		if (!samplesSetFolder.exists()) {
			if (!samplesSetFolder.mkdirs()) {
				throw new IOException("Unable to create "
						+ samplesSetFolder.getAbsolutePath());
			}
		}
		samplesSet.setFolder(samplesSetFolder.getAbsolutePath());
	}
	
	/*
	public File getFeaturesPath(FileFormatOntology formatOntology, String classifierName, String featuresName) {	
		String ontologyName = formatOntology.getFullName();
		File featuresPath = new File(featuresRoot, ontologyName);
		featuresPath = new File(featuresPath, FlatDSPaths.classifierFolder);
		featuresPath = new File(featuresPath, classifierName);
		featuresPath = new File(featuresPath, featuresName);
		featuresPath = new File(featuresPath, featuresFile);
		return featuresPath;
	}
	
	public File getClassifierPath(String classifierName) {	
		File classifierPath = new File(classifiersRoot, classifierName);
		classifierPath = new File(classifierPath, classifierFile);
		return classifierPath;
	}
	
	public File getClassifierDataPath(String classifierName) {	
		File classifierDataPath = new File(classifiersRoot, classifierName);
		classifierDataPath = new File(classifierDataPath, classifierDataFile);
		return classifierDataPath;
	}
	
	public File getSamplesPath(FileFormatOntology formatOntology, String classifierName, String samplesName) {	
		String ontologyName = formatOntology.getFullName();
		File samplesPath = new File(samplesRoot, ontologyName);
		samplesPath = new File(samplesPath, FlatDSPaths.classifierFolder);
		samplesPath = new File(samplesPath, classifierName);
		samplesPath = new File(samplesPath, samplesName);
		samplesPath = new File(samplesPath, samplesFile);
		return samplesPath;
	}
	
	public File formatPath(Format format) {	
		return new File(formatsRoot,format.getName());
	}
	
	public File formatFilePath(Format format) {	
		return new File(formatPath(format), formatFile);
	}
	
	public File getPronomPath(FileFormatOntology formatOntology, String puid) {	
		String ontologyName = formatOntology.getFullName();
		File pronomPath = new File(pronomRoot, ontologyName);
		pronomPath = new File(pronomPath, puid);
		pronomPath = new File(pronomPath, pronomFile);
		return pronomPath;
	}
		
	public File featureSetPath() {		
		File featureSetPath = new File(featuresRoot, featuresFile);
		return featureSetPath;
	}
	
	*/
	public File ontologyPath(String ontologyFile) {
		File file = new File(repositoryRoot,ontologyFile);
		return file;
	}
	
	public File magicNumbersPath(String magicNumbersFile) {
		File file = new File(repositoryRoot,magicNumbersFile);
		return file;
	}
	
	/*
	public File featuresSetPath(String featuresFilePath) {	
		File featureFile = new File(repositoryRoot, featuresFilePath);
		return featureFile;
	}
	*/
	
	public String getOntologyPath(FileFormatOntology formatOntology) {
		char separator = '/';
		StringBuilder sb = new StringBuilder();
		sb.append(formatOntology.getFirstGroup().toString()).append(separator)
				.append(formatOntology.getSecondGroup().toString()).append(separator);
		sb.append(formatURLToFileName(formatOntology));

		return sb.toString();
	}
	
	private String formatURLToFileName(FileFormatOntology formatOntology) {	
		if (!formatOntology.getFormatUrl().startsWith(FileFormatOntology.formatUrlPrefix)) {
			return null;
		}
		String fileName = formatOntology.getFormatUrl().replaceFirst(FileFormatOntology.formatUrlPrefix,"").replace(':', '_');
		return fileName;
	}
	
	private String formatFolderName(FileFormat fileFormat) {
		if (fileFormat.getName().equals(fileFormat.getOntology().getName())) {
			return formatURLToFileName(fileFormat.getOntology());
		}
		return fileFormat.getName();
	}
		
	public File fileFormatPath(FileFormat fileFormat) {
		String ontologyPath = getOntologyPath(fileFormat.getOntology());
		File formatPath = new File(formatsRoot, ontologyPath);
		String formatFolder = formatFolderName(fileFormat);
		formatPath = new File(formatPath, formatFolder);
		formatPath = new File(formatPath, formatFile);
		return formatPath;
	}
	
	public File classifierPath(FeaturedClassifier classifier) {	
		File classifierPath = new File(classifiersRoot, classifier.getName());
		classifierPath = new File(classifierPath, classifierFile);
		return classifierPath;
	}
	
	public File classifierDataPath(FeaturedClassifier classifier) {	
		File classifierDataPath = new File(classifiersRoot, classifier.getName());
		classifierDataPath = new File(classifierDataPath, classifierDataFile);
		return classifierDataPath;
	}
	
	public List<String> getClassifiersNames() {
		List<String> classifiersNames = new LinkedList<String>();
		String pattern = "**/" + classifierFile;	
		List<File> files = FlatDSFinder.find(classifiersRoot, pattern);

		for (File file : files) {
			String classifierName = file.getParentFile().getName();
			classifiersNames.add(classifierName);
		}
		
		return classifiersNames;
	}

				
	public void delete(File f) throws IOException {
		  if (f.isDirectory()) {
		    for (File c : f.listFiles())
		      delete(c);
		  }
		  if (!f.delete())
		    throw new FileNotFoundException("Failed to delete file: " + f);
	}
	
	public void save(Object o, File path) throws IOException {
		File dir = path.getParentFile();
		dir.mkdirs();
		XStream xstream = new XStream();
		String xml = xstream.toXML(o);
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(path));
			out.write(xml);
			out.close();
		} catch (IOException e) {
			log.error("failed to create object " + path + e.getMessage());
			throw e;	
		}
	}
	
	public Object read(File path) {
		File dir = path.getParentFile();
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			StringBuffer xml = new StringBuffer();
			String line;
			while ((line = in.readLine()) != null) {
				//System.out.println("buffer size " + xml.length());
				xml.append(line);
			}
			//System.out.println("finished reading " + path.toString());
			in.close();
			
			XStream xstream = new XStream();
			Object o = xstream.fromXML(xml.toString());
			return o;
		} catch (FileNotFoundException e) {
			log.error("failed to read object " + path + e.getMessage());
			return null;	
		} catch (IOException e) {
			log.error("failed to read object " + path + e.getMessage());
			return null;	
		}

	}
	
	/*
	public List<File> getClassifierSignaturesPaths(String classifierName) {
		String pattern = "** /" + FlatDSPaths.classifierFolder + "/" + classifierName + "/** /" + signaturesFile;
		List<File> paths = FlatDSFinder.find(signaturesRoot, pattern);
		return paths;
	}
	
	*/
	public List<String> getClassifierSignaturesNames(FileFormatOntology formatOntology, String classifierName) {
		String ontologyName = formatOntology.getFullName();
		List<String> classifierSignaturesNames = new LinkedList<String>();
		File signaturesRoot = new File(data, "signatures");
		String pattern = "**/" + ontologyName + "/" + FlatDSPaths.classifierFolder + "/" + classifierName + "/**/" + "signatures.xml";
		
		List<File> files = FlatDSFinder.find(signaturesRoot, pattern);
		for (File file : files) {
			Path path = file.toPath();
			// remove the source and the signature file
			path = path.getParent().getParent();
			File signaturesFile = new File(signaturesRoot, ontologyName);
			signaturesFile = new File(signaturesFile, FlatDSPaths.classifierFolder);
			signaturesFile = new File(signaturesFile, classifierName);
			Path signaturesPath = signaturesFile.toPath();
			Path signatureNamePath = signaturesPath.relativize(path);
			int nameCount = signatureNamePath.getNameCount();
			String signatureName = signatureNamePath.getName(0).toString();
			for (int i = 1; i < nameCount; i++) {
				signatureName = signatureName + '/' + signatureNamePath.getName(i).toString();
			}
			classifierSignaturesNames.add(signatureName);
		}
		return classifierSignaturesNames;
	}
	
	public List<String> getClassifierSignatureSources(FileFormatOntology formatOntology, String classifierName, String signatureName) {
		String ontologyName = formatOntology.getFullName();
		List<String> classifierSignatureSources = new LinkedList<String>();
		File signaturesRoot = new File(data, "signatures");
		String pattern = "**/" + ontologyName + "/" + FlatDSPaths.classifierFolder + "/" + classifierName + "/" + signatureName + "/*/" + "signatures.xml";
		List<File> files = FlatDSFinder.find(signaturesRoot, pattern);
		for (File file : files) {
			Path path = file.toPath();
			// remove the signature file
			path = path.getParent();
			File signaturesPath = new File(signaturesRoot, ontologyName);
			signaturesPath = new File(signaturesPath, FlatDSPaths.classifierFolder);
			signaturesPath = new File(signaturesPath, classifierName);
			signaturesPath = new File(signaturesPath, signatureName);
			Path signatureNamePath = signaturesPath.toPath().relativize(path);
			String source = signatureNamePath.toString();
			classifierSignatureSources.add(source);
		}
		return classifierSignatureSources;
	}
	
	/*
	public List<File> getClassifierSignaturesPaths(String classifierName, String sourceName) {
		String pattern = "** /" + FlatDSPaths.classifierFolder + "/" + classifierName + "/** /" + sourceName + "/" + signaturesFile;
		List<File> paths = FlatDSFinder.find(signaturesRoot, pattern);
		return paths;
	}
	
	public List<String> getClassifierSamplesNames(FileFormatOntology formatOntology, String classifierName) {
		String ontologyName = formatOntology.getFullName();
		List<String> classifierSamplesNames = new LinkedList<String>();
		String pattern = "** /" + ontologyName + "/" + FlatDSPaths.classifierFolder + "/" + classifierName + "/** /" + samplesFile;
		List<File> files = FlatDSFinder.find(samplesRoot, pattern);
		for (File file : files) {
			Path path = file.toPath();
			// remove the samples file
			path = path.getParent();
			File samplesFile = new File(samplesRoot, ontologyName);
			samplesFile = new File(samplesFile, FlatDSPaths.classifierFolder);
			samplesFile = new File(samplesFile, classifierName);
			Path samplesPath = samplesFile.toPath();
			Path samplesNamePath = samplesPath.relativize(path);
			int nameCount = samplesNamePath.getNameCount();
			String samplesName = samplesNamePath.getName(0).toString();
			for (int i = 1; i < nameCount; i++) {
				samplesName = samplesName + '/' + samplesNamePath.getName(i).toString();
			}
			classifierSamplesNames.add(samplesName);
		}
		return classifierSamplesNames;
	}
	
	public List<String> getClassifierFeaturesNames(FileFormatOntology formatOntology, String classifierName) {
		String ontologyName = formatOntology.getFullName();
		List<String> classifierFeaturesNames = new LinkedList<String>();
		String pattern = "** /" + ontologyName + "/" + FlatDSPaths.classifierFolder + "/" + classifierName + "/** /" + featuresFile;
		List<File> files = FlatDSFinder.find(featuresRoot, pattern);
		for (File file : files) {
			Path path = file.toPath();
			// remove the source and the signature file
			path = path.getParent();
			File featuresFile = new File(featuresRoot, ontologyName);
			featuresFile = new File(featuresFile, FlatDSPaths.classifierFolder);
			featuresFile = new File(featuresFile, classifierName);
			Path featuresPath = featuresFile.toPath();
			Path featureNamePath = featuresPath.relativize(path);
			int nameCount = featureNamePath.getNameCount();
			String featureName = featureNamePath.getName(0).toString();
			for (int i = 1; i < nameCount; i++) {
				featureName = featureName + '/' + featureNamePath.getName(i).toString();
			}
			classifierFeaturesNames.add(featureName);
		}
		return classifierFeaturesNames;
	}
	
	public List<File> getClassifierFeaturesPaths(String classifierName) {
		String pattern = "** /" + FlatDSPaths.classifierFolder + "/" + classifierName + "/** /" + featuresFile;
		List<File> paths = FlatDSFinder.find(featuresRoot, pattern);
		return paths;
	}
	*/
}
