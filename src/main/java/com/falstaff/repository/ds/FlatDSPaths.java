package com.falstaff.repository.ds;

import java.util.regex.Pattern;

public class FlatDSPaths {
	
	public static final String dataDir = "data";
	public static final String formatsDir = "formats";
	public static final String pronomDir = "pronom";
	public static final String featuresDir = "features";
	public static final String classifiersDir = "classifiers";
	
	
	public static final String classifierFolder = "classifier";
/*
	public static String formatRegExp = formatsDir + "/((?:(?!" + signaturesDir + ")(?!" + formatSetsDir + ")(?!" + pronomDir + ")(?:[^/]+/))*)(?!" + signaturesDir + ")(?!" + formatSetsDir + ")(?!" + pronomDir + ")([^/]+)";
	public static Pattern formatPattern = Pattern.compile(formatRegExp);
	
	public static String formatSignatureSetRegExp = formatRegExp + "/" + signaturesDir;
	public static Pattern formatSignatureSetPattern = Pattern.compile(formatSignatureSetRegExp);
	
	public static String formatSampleSetRegExp = formatRegExp + "/" + formatSetsDir + "/([^/]+)";
	public static Pattern formatSampleSetPattern = Pattern.compile(formatSampleSetRegExp);
	
	public static String formatSampleSetSignatureSetRegExp = formatSampleSetRegExp + "/" + signaturesDir;
	public static Pattern formatSampleSetSignatureSetPattern = Pattern.compile(formatSampleSetSignatureSetRegExp);
*/
	public static String pronomRegExp = pronomDir;
	public static Pattern pronomPattern = Pattern.compile(pronomRegExp);
/*	
	public static String featuresSetRegExp = featuresDir;
	public static Pattern featureSetPattern = Pattern.compile(featuresSetRegExp);
*/
	public static String ontologyRegExp = "([^/]+)" + "/" + "([^/]+)" + "/" + "([^/]+)" + "/";
/*	
	public static String ontologySignaturesRegExp = classifierFolder + "/" + "([^/]+)" + "/" + "(.+)" + "/" + "([^/]+)";
	public static Pattern ontologySignaturesPattern = Pattern.compile(ontologySignaturesRegExp);
	
	public static String signaturesRegExp = signaturesDir + "/" + ontologyRegExp + ontologySignaturesRegExp;
	public static Pattern signaturesPattern = Pattern.compile(signaturesRegExp);
	
	public static String signaturesAllRegExp = signaturesDir + "/" + classifierFolder + "/" + "([^/]+)";
	public static Pattern signaturesAllPattern = Pattern.compile(signaturesAllRegExp);
	
	public static String ontologyFeaturesRegExp = classifierFolder + "/" + "([^/]+)" + "/" + "(.+)";
	public static Pattern ontologyFeaturesPattern = Pattern.compile(ontologyFeaturesRegExp);

	public static String featuresRegExp = featuresDir + "/" + ontologyRegExp + ontologyFeaturesRegExp;;
	public static Pattern featuresPattern = Pattern.compile(featuresRegExp);
	
	public static String featuresAllRegExp = featuresDir + "/" + classifierFolder + "/" + "([^/]+)";
	public static Pattern featuresAllPattern = Pattern.compile(featuresAllRegExp);
	
	public static String ontologySamplesRegExp = classifierFolder + "/" + "([^/]+)" + "/" + "(.+)";
	public static Pattern ontologySamplesPattern = Pattern.compile(ontologySamplesRegExp);

	public static String samplesRegExp = samplesDir + "/" + ontologyRegExp + ontologySamplesRegExp;;
	public static Pattern samplesPattern = Pattern.compile(samplesRegExp);
*/
	public static String classifierRegExp = classifiersDir + "/" + ".*\\.xml";
	public static Pattern classifierPattern = Pattern.compile(classifierRegExp);

}
