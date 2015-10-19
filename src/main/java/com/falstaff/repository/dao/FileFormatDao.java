package com.falstaff.repository.dao;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.classification.ExtensionSimulatedFeaturedSample;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults.ClassificationResult;
import com.falstaff.core.classification.FeaturedSample;
import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FeaturedSignature;
import com.falstaff.core.classification.FeaturedSignaturesSet;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.classification.SignatureSimulatedFeaturedSample;
import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.core.ontology.Ontology;
import com.falstaff.repository.ds.FlatDS;

@Component
public class FileFormatDao implements Converter<String, FileFormat> {

	private static final Logger log = LoggerFactory
	.getLogger(FileFormatDao.class.getName());
	
	@Autowired
	private FlatDS flatDS;
	
	@Autowired
	private OntologyDao ontologyDao;
	
	@PostConstruct
	public void init() throws Exception {
		Ontology ontology = ontologyDao.getOntology();
		
		// read formats
		List<FileFormat> formats = ontology.getFormats();
		
		Collections.sort(formats, new FileFormat.FormatsComparator()); 
		
		for (int i = 0; i < formats.size(); i++) {
			FileFormat initialFormat;
			FileFormat savedFormat = null;
			try {
				initialFormat = formats.get(i);
				savedFormat = read(initialFormat);
				if (savedFormat == null) {
					save(initialFormat);
				}
				else {
					savedFormat.setOntology(initialFormat.getOntology());
					formats.set(i, savedFormat);
					if (savedFormat.getId() != initialFormat.getId()) {
						savedFormat.setId(initialFormat.getId());
						save(savedFormat);
					}
				}
			} catch (Exception e) {
				log.error("failed to initialize format " + e.getMessage());
				throw e;
			}
			
		
			/*
			if (!savedFormat.getName().equals(savedFormat.getOntology().getName())) {
				continue;
			}
			
			
			if (savedFormat.getSignatures() != null) {	
				List<FeaturedSignaturesSet> signatures = new LinkedList<FeaturedSignaturesSet>(savedFormat.getSignatures());
				for (FeaturedSignaturesSet signaturesSet : signatures) {
					if (signaturesSet.getName().startsWith("fmt") || signaturesSet.getName().startsWith("x-fmt")) {
						PronomSignaturesSet pronomSignaturesSet = new PronomSignaturesSet(signaturesSet.getName(), signaturesSet);
						int j = savedFormat.clearSignaturesSet(signaturesSet);
						savedFormat.addSignaturesSet(pronomSignaturesSet, j);
					}
				}
			}
			
			if (savedFormat.getSamples() != null) {
				for (FeaturedSamplesSet samplesSet : savedFormat.getSamples()) {
					if (samplesSet.getName().startsWith("fmt") || samplesSet.getName().startsWith("x-fmt")) {
						samplesSet.setName("govdoc1/" + samplesSet.getName());
					}
				}
			}
			
			try {
				save(savedFormat);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			/*
			savedFormat.clearSignatures();
			String classifierName = "falstaff";
			List<String> signaturesNames = flatDS.getClassifierSignaturesNames(savedFormat.getOntology(), classifierName);
			log.info(signaturesNames.size() + " signatures were found for format " + savedFormat.getName());
			for (String signaturesName : signaturesNames) {
				List<String> sources = flatDS.getClassifierSignatureSources(savedFormat.getOntology(), classifierName, signaturesName);
				for (String source : sources) {
					Set<NSignature> signatures = read(savedFormat.getOntology(), classifierName, signaturesName, source);
					FeaturedSignaturesSet signaturesSet;
					if (SignaturesSource.valueOf(source.toUpperCase()).equals(SignaturesSource.FALSTAFF)) {
						FeaturedSamplesSet samples = savedFormat.getSamplesSet(signaturesName);
						if (samples == null && signaturesName.equals("openarchive")) {
							log.info("no samples set for signatures " + signaturesName + " in ontology " + savedFormat.getName());
							signaturesName = "archiveteam";
							samples = savedFormat.getSamplesSet(signaturesName);
						}
						signaturesSet = new AlignedSignaturesSet(samples, new LinkedList<NSignature>(signatures), savedFormat);
					}
					else {
						signaturesSet = new FeaturedSignaturesSet(signaturesName, SignaturesSource.valueOf(source.toUpperCase()), new LinkedList<NSignature>(signatures), savedFormat);
					}
					try {
						savedFormat.addSignaturesSet(signaturesSet);
						save(savedFormat);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			*/
		}
		
		
		Map<String, FileFormat> formatsMap = ontologyDao.getOntology().getFormatsMap();
		for (FileFormat format : formats) {
			formatsMap.put(format.getName(), format);
		}
		
		for (FileFormat format : formats) {
			List<ExtensionSimulatedFeaturedSample> formatSimulatedSamples = format.getSimulatedSamples();
			if (formatSimulatedSamples != null) {
				for (ExtensionSimulatedFeaturedSample formatSimulatedSample : formatSimulatedSamples) {
					ClassificationResults results = formatSimulatedSample.getTestingResults();
					if (results != null) {
						List<ClassificationResult> classifications = results.getResults();
						if (classifications != null) {
							Iterator<ClassificationResult> iterator = classifications.iterator();
							while (iterator.hasNext()) {
								ClassificationResult classification = iterator.next();
								FileFormat classifiedFormat = get(classification.getFormatName());
								if (classifiedFormat != null) {
									classification.setFormat(classifiedFormat);
								}
								else {
									iterator.remove();
								}
							}
						}
					}
				}
			}
			
			List<FeaturedSignaturesSet> signaturesSets = format.getSignatures();
			if (signaturesSets != null) {	
				for (FeaturedSignaturesSet signaturesSet : signaturesSets) {
					List<FeaturedSignature> signatures = signaturesSet.getSignatures();
					if (signatures != null) {		
						for (FeaturedSignature signature : signatures) {
							List<SignatureSimulatedFeaturedSample> signatureSimulatedSamples = signature.getSimulatedSamples();
							if (signatureSimulatedSamples != null) {
								for (SignatureSimulatedFeaturedSample signatureSimulatedSample : signatureSimulatedSamples) {
									ClassificationResults results = signatureSimulatedSample.getTestingResults();
									if (results != null) {
										List<ClassificationResult> classifications = results.getResults();
										if (classifications != null) {
											Iterator<ClassificationResult> iterator = classifications.iterator();
											while (iterator.hasNext()) {
												ClassificationResult classification = iterator.next();
												FileFormat classifiedFormat = get(classification.getFormatName());
												if (classifiedFormat != null) {
													classification.setFormat(classifiedFormat);
												}
												else {
													iterator.remove();
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			List<FeaturedSamplesSet> samplesSets = format.getSamples();
			if (samplesSets != null) {
				for (FeaturedSamplesSet samplesSet : samplesSets) {
					List<FeaturedSample> samples = samplesSet.getSamples();
					if (samples != null) {
						for (FeaturedSample sample : samples) {
							ClassificationResults results = sample.getTestingResults();
							if (results != null) {
								List<ClassificationResult> classifications = results.getResults();
								if (classifications != null) {
									Iterator<ClassificationResult> iterator = classifications.iterator();
									while (iterator.hasNext()) {
										ClassificationResult classification = iterator.next();
										FileFormat classifiedFormat = get(classification.getFormatName());
										if (classifiedFormat != null) {
											classification.setFormat(classifiedFormat);
										}
										else {
											iterator.remove();
										}
									}								
								}
							}
						}
					}
				}
			}
		}
		
		ontology.setNewFormats();
	}
	
	public Set<NSignature> read(FileFormatOntology formatOntology, String classifierName, String signaturesName, String signaturesSource) {
		
		Set<NSignature> signatures = new HashSet<NSignature>();
		
		File path = flatDS.getSignaturesPath(formatOntology, classifierName, signaturesName, signaturesSource);
		signatures = (Set<NSignature>)flatDS.read(path);
		for (NSignature signature : signatures) {
			signature.setSignatureId();
		}
		
		return signatures;
	}

	
	public synchronized FileFormat read(FileFormat fileFormat) throws IOException {
		File path = flatDS.fileFormatPath(fileFormat);
		log.info("reading format " + fileFormat.getName());
		return (FileFormat)flatDS.read(path);
	}
	
	public synchronized void save(FileFormat fileFormat) throws IOException {
		File path = flatDS.fileFormatPath(fileFormat);
		flatDS.save(fileFormat, path);
	}

	public List<FileFormat> getFormats() {
		return ontologyDao.getOntology().getFormats();
	}
	
	public Set<FileFormat> getNewFormats() {
		return ontologyDao.getOntology().getNewFormats();
	}

	public FileFormat get(long id) {
		return ontologyDao.getOntology().getFormat(id);
	}
	
	public FileFormat get(String name) {
		return ontologyDao.getOntology().getFormat(name);
	}

	@Override
	public FileFormat convert(String source) {
		Long id = new Long(source);
		return get(id);
	}
	
	public void add(FileFormat fileFormat) {
		ontologyDao.getOntology().addFormat(fileFormat);
	}
	
}
