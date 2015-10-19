package com.falstaff.core.classification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.feature.IFeature;
import com.falstaff.core.maxent.Datum;
import com.falstaff.core.maxent.Index;
import com.falstaff.core.maxent.LogConditionalObjectiveFunction;
import com.falstaff.core.maxent.QNMinimizer;
import com.falstaff.core.util.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class NClassifier {
	
	private static final Logger log = LoggerFactory
			.getLogger(NClassifier.class.getName());

	transient private double[][] weights;
	private Index featureIndex;
	protected Index formatIndex;
	transient private int[][] scores;
	private double[] precision;
	private double[] recall;
	private double[] F;
	
	protected long id;
		
	public NClassifier() {
		id = IdGenerator.getIdGenerator().getId(this.getClass().getName());
	}

	public void train(List<Datum> features) {
		LogConditionalObjectiveFunction obj = new LogConditionalObjectiveFunction(features);
		double[] initial = new double[obj.domainDimension()];
		/*
		 * original 15
		 */
		QNMinimizer minimizer = new QNMinimizer(15);
		/*
		 * original
		double[][] weightsTranspose = obj.to2D(minimizer.minimize(obj, 1e-4, initial,
				-1, null));
		*/

		double[][] weightsTranspose = obj.to2D(minimizer.minimize(obj, 1e-4, initial,
				-1, null));
		
		// transpose weights
		weights = new double[weightsTranspose[0].length][];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = new double[weightsTranspose.length]; 
		}
		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < weights[i].length; j ++) {
				weights[i][j] = weightsTranspose[j][i];
			}
		}
		
		featureIndex = obj.featureIndex;
		formatIndex = obj.labelIndex;
	}

	public void train(Index featureIndex, Index formatIndex, double[][] weights) {
		// transpose weights
		this.weights = new double[weights[0].length][];
		for (int i = 0; i < this.weights.length; i++) {
			this.weights[i] = new double[weights.length]; 
		}
		for (int i = 0; i < this.weights.length; i++) {
			for (int j = 0; j < this.weights[i].length; j ++) {
				this.weights[i][j] = weights[j][i];
			}
		}
		this.featureIndex = featureIndex;
		this.formatIndex = formatIndex;
	}
	
	protected void initScores() {
		scores = new int[getFormatsCount()][];
		for (int i = 0; i < getFormatsCount(); i++) {
			scores[i] = new int[getFormatsCount()];
			for (int j = 0; j < getFormatsCount(); j++) {
				scores[i][j] = 0;
			}
		}
	}
	
	protected void initPrecision() {
		precision = new double[getFormatsCount()];
		for (int i = 0; i < getFormatsCount(); i++) {
			int sum = 0;
			for (int j = 0; j < getFormatsCount(); j++) {
				sum += scores[i][j];
			}
			if (sum == 0) {
				precision[i] = 1.0;
			}
			else {
				precision[i] = ((double)scores[i][i]) / ((double)sum);
			}
		}
	}
	
	protected void initRecall() {
		recall = new double[getFormatsCount()];
		for (int j = 0; j < getFormatsCount(); j++) {
			int sum = 0;
			for (int i = 0; i < getFormatsCount(); i++) {
				sum += scores[i][j];
			}
			if (sum == 0) {
				recall[j] = 1.0;
			}
			else {
				recall[j] = ((double)scores[j][j]) / ((double)sum);
			}
		}
	}
	
	protected void initF() {
		F = new double[getFormatsCount()];
		for (int i = 0; i < getFormatsCount(); i++) {
			F[i] = 2.0 * precision[i] * recall[i] / (precision[i] + recall[i]);
		}
	}
	
	public double[] formatsWeights(IFeature feature) {
		int index = featureIndex.indexOf(feature.getName());
		if (index < 0) {
			return null;
		}
		return weights[featureIndex.indexOf(feature.getName())];
	}
	
	public double formatFetureWeight(String format, String feature) {
		int featureInd = featureIndex.indexOf(feature);		
		if (featureInd < 0) {
			return 0.0;
		}
		int formatInd = formatIndex.indexOf(format);
		if (formatInd < 0) {
			throw new RuntimeException("format " + format + " does not exist in a feature set");
		}
		
		return weights[featureInd][formatInd];
	}
	
	@JsonIgnore
	public int getFormatsCount() {
		return formatIndex.size();
	}
	
	public String getFormat(int index) {
		return (String)formatIndex.get(index);
	}
	
	public boolean hasFormat(String format) {
		return formatIndex.indexOf(format) > 0;
	}
	
	@JsonIgnore
	public Set<String> getFormatsNames() {
		Set<String> formatsNames = new HashSet<String>();
		for (int i = 0; i < formatIndex.size(); i++) {
			formatsNames.add((String)formatIndex.get(i));
		}
		return formatsNames;
	}
	
	public void updateScores(String predictedFormat, String actualFormat) {
		if (scores == null) {
			initScores();
		}
		int i = formatIndex.indexOf(actualFormat);
		int j = formatIndex.indexOf(predictedFormat);
		if (i < 0) {
			throw new RuntimeException("format " + predictedFormat + " is undefined in feature set");
		}
		if (j < 0) {
			throw new RuntimeException("format " + actualFormat + " is undefined in feature set");
		}
		scores[i][j]++;
		//log.info("scores updated for predicted format " + predictedFormat + " and actual format " + actualFormat + ", the value of scores at [" + i + "," + j +"] is " + scores[i][j]);
	}
	
	public Double getPrecision(String format) {
		int i = formatIndex.indexOf(format);
		Double precisionValue = getPrecision(i);
		//log.info("precision of format " + format + " with index " + i + " is " + precisionValue);
		return precisionValue;
	}
	
	protected Double getPrecision(int index) {
		if (precision == null) {
			return null;
		}
		return precision[index];
	}

	public Double getRecall(String format) {
		int i = formatIndex.indexOf(format);
		return getRecall(i);
	}
	
	protected Double getRecall(int index) {
		if (recall == null) {
			return null;
		}
		return recall[index];
	}
	
	public Double getF(String format) {
		int i = formatIndex.indexOf(format);
		return getF(i);
	}
	
	protected Double getF(int index) {
		if (precision == null) {
			return null;
		}
		if (recall == null) {
			return null;
		}		
		if (F == null) {
			return null;
		}
		return F[index];
	}
	
	protected void resetRelevance() {
		scores = null;
		precision = null;
		recall = null;
		F = null;
	}
	
	public String relevanceToString() {
		StringBuffer relevance = new StringBuffer();
		for (int i = 0; i < getFormatsCount(); i++) {
			relevance.append(formatIndex.get(i));
			relevance.append(" precision ").append(getPrecision(i));
			relevance.append(" recall ").append(getRecall(i));
			relevance.append(" F ").append(getF(i));
			relevance.append("\n");
		}
		
		return relevance.toString();
	}
	
	@JsonIgnore
	public double[][] getWeights() {
		return weights;
	}

	public void setWeights(double[][] weights) {
		this.weights = weights;
	}

	public long getId() {
		return id;
	}
}
