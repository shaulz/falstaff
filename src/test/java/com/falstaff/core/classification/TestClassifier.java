package com.falstaff.core.classification;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;
import com.falstaff.core.feature.FeatureType;
import com.falstaff.core.feature.IFeature;
import com.falstaff.core.maxent.Datum;

import org.junit.Test;

public class TestClassifier {
	
	public class SimpleFeature implements IFeature {
		private String name;

		private SimpleFeature(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public FeatureType getType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	@Test
	public void test() {
		int samples = 100;
		List<Datum> datums = new LinkedList<Datum>();
		for (int i = 0; i < samples; i++) {
			String label = "f1";
			List<String> features = new LinkedList<String>();
			features.add("a");
			Datum datum = new Datum(label, features);
			datums.add(datum);
		}
		for (int i = 0; i < samples; i++) {
			String label = "f2";
			List<String> features = new LinkedList<String>();
			features.add("a");
			features.add("b");
			Datum datum = new Datum(label, features);
			datums.add(datum);
		}
		
		for (int i = 0; i < samples; i++) {
			String label = "f3";
			List<String> features = new LinkedList<String>();
			features.add("a");
			features.add("b");
			features.add("c");
			Datum datum = new Datum(label, features);
			datums.add(datum);
		}
		
		FeaturedClassifier classifier = new FeaturedClassifier("test", 4 , 0.1, new HashSet<FileFormat>());
		classifier.train(datums);
		
		List<IFeature> test = new LinkedList<IFeature>();
		test.add(new SimpleFeature("a"));
		ClassificationResults results = classifier.score(test);

		System.out.println("\ntesting shared feature, should get f1");
		for (ClassificationResults.ClassificationResult result : results.getResults()) {
			String formatName = result.getFormat().getName();
			double probability = result.getProbability();
			System.out.println("format " + formatName + " with probability " + probability);
		}
		
		test = new LinkedList<IFeature>();
		test.add(new SimpleFeature("a"));
		test.add(new SimpleFeature("b"));
		results = classifier.score(test);

		System.out.println("\ntesting second shared feature, should get f2");
		for (ClassificationResults.ClassificationResult result : results.getResults()) {
			String formatName = result.getFormat().getName();
			double probability = result.getProbability();
			System.out.println("format " + formatName + " with probability " + probability);
		}
		
		test = new LinkedList<IFeature>();
		test.add(new SimpleFeature("a"));
		test.add(new SimpleFeature("b"));
		test.add(new SimpleFeature("c"));
		results = classifier.score(test);

		System.out.println("\ntesting not shared feature, should get f3");
		for (ClassificationResults.ClassificationResult result : results.getResults()) {
			String formatName = result.getFormat().getName();
			double probability = result.getProbability();
			System.out.println("format " + formatName + " with probability " + probability);
		}
	}
	
	@Test
	public void testManyFormats() {
		List<Datum> datums = new LinkedList<Datum>();
		
		int samples = 10;
		for (int i = 0; i < samples; i++) {
			String label = "f1";
			List<String> features = new LinkedList<String>();
			features.add("a");
			Datum datum = new Datum(label, features);
			datums.add(datum);
		}
		for (int i = 0; i < samples; i++) {
			String label = "f2";
			List<String> features = new LinkedList<String>();
			features.add("a");
			features.add("b");
			Datum datum = new Datum(label, features);
			datums.add(datum);
		}
		
		for (int i = 0; i < samples; i++) {
			String label = "f3";
			List<String> features = new LinkedList<String>();
			features.add("a");
			features.add("b");
			features.add("c");
			Datum datum = new Datum(label, features);
			datums.add(datum);
		}
		
		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < samples; j++) {
				List<String> features = new LinkedList<String>();
				features.add(Integer.toString(i));
				Datum datum = new Datum(Integer.toString(i), features);
				datums.add(datum);
			}
		}
		FeaturedClassifier classifier = new FeaturedClassifier("test", 4 , 0.1, new HashSet<FileFormat>());
		classifier.train(datums);
		List<IFeature> test = new LinkedList<IFeature>();
		test.add(new SimpleFeature(Integer.toString(596)));
		
		ClassificationResults results = classifier.score(test);
		for (ClassificationResults.ClassificationResult result : results.getResults()) {
			String formatName = result.getFormat().getName();
			double probability = result.getProbability();
			System.out.println("format " + formatName + " with probability " + probability);
		}
		
		test = new LinkedList<IFeature>();
		test.add(new SimpleFeature("a"));
		test.add(new SimpleFeature("b"));
		test.add(new SimpleFeature("c"));
		results = classifier.score(test);

		System.out.println("\ntesting not shared feature, should get f3");
		for (ClassificationResults.ClassificationResult result : results.getResults()) {
			String formatName = result.getFormat().getName();
			double probability = result.getProbability();
			System.out.println("format " + formatName + " with probability " + probability);
		}
	}
}
