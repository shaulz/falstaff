package com.falstaff.core.aligner.cluster;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cern.colt.list.IntArrayList;
import cern.colt.map.AbstractIntDoubleMap;
import cern.colt.map.OpenIntDoubleHashMap;
import cern.colt.matrix.DoubleFactory1D;
import cern.colt.matrix.DoubleFactory2D;
import cern.colt.matrix.DoubleMatrix1D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.linalg.EigenvalueDecomposition;
import cern.jet.math.Functions;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;

@Component("spectralCluster")
@Qualifier("spectralCluster")
@Scope("prototype")
public class NSpectralCluster extends NSingleLinkCluster {
	private static final Logger log = LoggerFactory
			.getLogger(NSpectralCluster.class.getName());

	/**
	 * The class number of each point in the dataset
	 */
	protected int[] cluster;
	/**
	 * The number of different clusters found
	 */
	protected int numOfClusters = 0;
	/**
	 * The alpha star parameter value
	 */
	protected double alphaStar = 0.5;

	/**
	 * The using sparse matrix flag
	 */
	protected boolean useSparseMatrix = false;
	
	protected DoubleMatrix2D scoresMatrix;
	
	@Autowired
	NSingleLinkSingleCluster singleLinkSingleCluster;


	/**
	 * Merges two sets of points represented as integer vectors. The sets are
	 * not overlapped.
	 * 
	 * @param a
	 *            the first set of points
	 * @param b
	 *            the second set of points
	 * @return the union of the two sets
	 */
	protected int[] merge(final int[] a, final int[] b) {
		final int[] c = new int[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}

	/**
	 * Computes the association degree between two partitions of a graph.<br>
	 * The association degree is defined as the sum of the weights of all the
	 * edges between points of the two partitions.
	 * 
	 * @param W
	 *            the weight matrix of the graph
	 * @param a
	 *            the points of the first partition
	 * @param b
	 *            the points of the second partition
	 * @return the association degree
	 */
	protected static double asso(final DoubleMatrix2D W, final int[] a,
			final int[] b) {
		return W.viewSelection(a, b).zSum();
	}

	/**
	 * Returns the normalized association degree between two partitions of a
	 * graph.
	 * 
	 * @param W
	 *            the weight matrix of the graph
	 * @param a
	 *            the points of the first partition
	 * @param b
	 *            the points of the second partition
	 * @return the normalized association degree
	 */
	protected double Nasso(final DoubleMatrix2D W, final int[] a, final int[] b) {
		return Nasso(W, a, b, merge(a, b));
	}

	/**
	 * Returns the normalized association degree between two partitions of a
	 * graph w.r.t. a given subgraph.
	 * 
	 * @param W
	 *            the weight matrix of the graph
	 * @param a
	 *            the points of the first partition
	 * @param b
	 *            the points of the second partition
	 * @param c
	 *            the points of the subgraph
	 * @return the normalized association degree
	 */
	protected double Nasso(final DoubleMatrix2D W, final int[] a,
			final int[] b, final int[] c) {
		return asso(W, a, a) / asso(W, a, c) + asso(W, b, b) / asso(W, b, c);
	}

	/**
	 * Returns the normalized dissimilarity degree (or cut) between two
	 * partitions of a graph.
	 * 
	 * @param W
	 *            the weight matrix of the graph
	 * @param a
	 *            the points of the first partition
	 * @param b
	 *            the points of the second partition
	 * @return the normalized cut
	 */
	protected double Ncut(final DoubleMatrix2D W, final int[] a, final int[] b) {
		return 2 - Nasso(W, a, b);
	}

	/**
	 * Returns the normalized dissimilarity degree (or cut) between two
	 * partitions of a graph w.r.t. a given subgraph.
	 * 
	 * @param W
	 *            the weight matrix of the graph
	 * @param a
	 *            the points of the first partition
	 * @param b
	 *            the points of the second partition
	 * @param c
	 *            the points of the subgraph.
	 * @return the normalized cut
	 */
	protected double Ncut(final DoubleMatrix2D W, final int[] a, final int[] b,
			final int[] c) {
		return 2 - Nasso(W, a, b, c);
	}

	/**
	 * Returns the best cut of a graph w.r.t. the degree of dissimilarity
	 * between points of different partitions and the degree of similarity
	 * between points of the same partition.
	 * 
	 * @param W
	 *            the weight matrix of the graph
	 * @return an array of two elements, each of these contains the points of a
	 *         partition
	 */
	protected int[][] bestCut(final DoubleMatrix2D W) {
		int n = W.columns();
		// Builds the diagonal matrices D and D^(-1/2) (represented as their
		// diagonals)
		final DoubleMatrix1D d = DoubleFactory1D.dense.make(n);
		final DoubleMatrix1D d_minus_1_2 = DoubleFactory1D.dense.make(n);
		for (int i = 0; i < n; i++) {
			double d_i = W.viewRow(i).zSum();
			d.set(i, d_i);
			d_minus_1_2.set(i, 1 / Math.sqrt(d_i));
		}
		final DoubleMatrix2D D = DoubleFactory2D.sparse.diagonal(d);
		final DoubleMatrix2D X = D.copy();
		// X = D^(-1/2) * (D - W) * D^(-1/2)
		X.assign(W, Functions.minus);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				X.set(i, j,
						X.get(i, j) * d_minus_1_2.get(i) * d_minus_1_2.get(j));

		// Computes the eigenvalues and the eigenvectors of X
		final EigenvalueDecomposition e = new EigenvalueDecomposition(X);
		final DoubleMatrix1D lambda = e.getRealEigenvalues();
		// Selects the eigenvector z_2 associated with the second smallest
		// eigenvalue
		// Creates a map that contains the pairs <index, eigevalue>
		final AbstractIntDoubleMap map = new OpenIntDoubleHashMap(n);
		for (int i = 0; i < n; i++)
			map.put(i, Math.abs(lambda.get(i)));
		final IntArrayList list = new IntArrayList();
		// Sorts the map on the value
		map.keysSortedByValue(list);
		// Gets the index of the second smallest element
		final int i_2 = list.get(1);
		// y_2 = D^(-1/2) * z_2
		final DoubleMatrix1D y_2 = e.getV().viewColumn(i_2).copy();
		y_2.assign(d_minus_1_2, Functions.mult);
		// Creates a map that contains the pairs <i, y_2[i]>
		map.clear();
		for (int i = 0; i < n; i++)
			map.put(i, y_2.get(i));
		// Sorts the map on the value
		map.keysSortedByValue(list);
		// Search the element in the map previuosly ordered that minimizes the
		// cut of the partition
		double best_cut = Double.POSITIVE_INFINITY;
		final int[][] partition = new int[2][];
		// The array v contains all the elements of the graph ordered by their
		// projection on vector y_2
		final int[] c = list.elements();
		// For each admissible splitting point i
		for (int i = 1; i < n; i++) {
			// The array a contains all the elements that have a projection on
			// vector y_2 less or equal to the one of i-th element
			// The array b contains the remaining elements
			final int[] a = new int[i];
			final int[] b = new int[n - i];
			System.arraycopy(c, 0, a, 0, i);
			System.arraycopy(c, i, b, 0, n - i);
			final double cut = Ncut(W, a, b, c);
			if (cut < best_cut) {
				best_cut = cut;
				partition[0] = a;
				partition[1] = b;
			}
		}
		return partition;
	}
	
	protected void initScores() {
		super.initScores();
		
		scoresMatrix = useSparseMatrix ? DoubleFactory2D.sparse.make(
				filledKtupsCount, filledKtupsCount) : DoubleFactory2D.dense.make(filledKtupsCount, filledKtupsCount);
		
		for (int i = 0; i < filledKtupsCount; i++) {
			IScorableKtup ktupI = getKtup(i);
			for (int j = 0; j < filledKtupsCount; j++) {
				if (j > i) {
					break;
				}
				if (j == i) {
					int score = score(ktupI, ktupI);
					scoresMatrix.set(i, j, score);
					continue;
				}
					
				if (scoreTableIndexAlignable[i] == scoreTableIndexAlignable[j]) {
					IScorableKtup ktupJ = getKtup(j);
					int score = score(ktupI, ktupJ);
					scoresMatrix.set(i, j, score);
					scoresMatrix.set(j, i, score);
				}
				else {
					scoresMatrix.set(i, j, scores[i][j]);
					scoresMatrix.set(j, i, scores[j][i]);					
				}
			}
		}
	}
	
	/**
	 * Splits recursively the points of the graph while the value of the best
	 * cut found is less of a specified limit (the alpha star factor).
	 * 
	 * @param W
	 *            the weight matrix of the graph
	 * @param alphaStar
	 *            the alpha star factor
	 * @return an array of sets of points (partitions)
	 */
	protected int[][] partition(final DoubleMatrix2D W/* , double alpha_star */) {
		// If the graph contains only one point
		if (W.columns() == 1) {
			int[][] p = new int[1][1];
			p[0][0] = 0;
			return p;
		}
		// Otherwise
		// Computes the best cut
		final int[][] cut = bestCut(W);
		// Computes the value of the found cut
		final double cutVal = Ncut(W, cut[0], cut[1], null);
		// If the value is less than alpha star
		log.info("cut value " + cutVal);
		if (cutVal < alphaStar) {
			// Recursively partitions the first one found ...
			final DoubleMatrix2D W0 = W.viewSelection(cut[0], cut[0]);
			final int[][] p0 = partition(W0 /* , alpha_star */);
			// ... and the second one
			final DoubleMatrix2D W1 = W.viewSelection(cut[1], cut[1]);
			final int[][] p1 = partition(W1 /* , alpha_star */);
			// Merges the partitions found in the previous recursive steps
			final int[][] p = new int[p0.length + p1.length][];
			for (int i = 0; i < p0.length; i++) {
				p[i] = new int[p0[i].length];
				for (int j = 0; j < p0[i].length; j++)
					p[i][j] = cut[0][p0[i][j]];
			}
			for (int i = 0; i < p1.length; i++) {
				p[i + p0.length] = new int[p1[i].length];
				for (int j = 0; j < p1[i].length; j++)
					p[i + p0.length][j] = cut[1][p1[i][j]];
			}
			return p;
		}
		// Otherwise returns the partitions found in current step
		// w/o recursive invocation
		int[][] p = new int[1][W.columns()];
		for (int i = 0; i < p[0].length; i++)
			p[0][i] = i;
		return p;
	}

	/**
	 * Returns the number of clusters found.
	 * 
	 * @return the number of clusters
	 */
	public int numberOfClusters() {
		return numOfClusters;
	}

	/**
	 * Generates a clusterer by the mean of spectral clustering algorithm.
	 * 
	 * @param data
	 *            set of instances serving as training data
	 */
	protected void buildClusterer() {
		/*
		 * final double[][] v1 = new double[n][]; for (int i = 0; i < n; i++)
		 * v1[i] = data.instance(i).toDoubleArray(); final DoubleMatrix2D v =
		 * DoubleFactory2D.dense.make(v1);
		 */

		// Compute point partitions
		final int[][] p = partition(scoresMatrix /* , alpha_star */);

		// Deploys results
		numOfClusters = p.length;
		cluster = new int[filledKtupsCount];
		for (int i = 0; i < p.length; i++)
			for (int j = 0; j < p[i].length; j++)
				cluster[p[i][j]] = i;
	}

	/**
	 * Returns a string describing this clusterer
	 * 
	 * @return a description of the evaluator suitable for displaying in the
	 *         explorer/experimenter gui
	 */
	public String globalInfo() {
		return "Cluster data using spectral methods";
	}

	/**
	 * Sets the new value of the alpha star factor.
	 * 
	 * @param alpah_star
	 *            the new value (0 &lt; alpha_star &lt; 1)
	 * @exception Exception
	 *                if alpha_star is not between 0 and 1
	 */
	public void setAlphaStar(final double alphaStar) throws Exception {
		if ((alphaStar > 0) && (alphaStar < 1))
			this.alphaStar = alphaStar;
		else
			throw new Exception("alpha_star must be between 0 and 1");
	}

	/**
	 * Returns the current value of the alpha star factor.
	 * 
	 * @return the alpha star factor
	 */
	public double getAlphaStar() {
		return alphaStar;
	}

	/**
	 * Returns the tip text for this property
	 * 
	 * @return tip text for this property suitable for displaying in the
	 *         explorer/experimenter gui
	 */
	public String alphaStarTipText() {
		return "set maximum allowable normalized cut value. The algorithm stops the recursive partitioning when it does not find a cut that has a value below this factor. Use this argument to limit the number of clusters.";
	}

	/**
	 * Sets the use of sparse representation for similarity matrix.
	 * 
	 * @param useSparseMatrix
	 *            true for sparse matrix representation
	 */
	public void setUseSparseMatrix(final boolean useSparseMatrix) {
		this.useSparseMatrix = useSparseMatrix;
	}

	/**
	 * Returns the status of using sparse matrix flag.
	 * 
	 * @return the status of using sparse matrix flag
	 */
	public boolean getUseSparseMatrix() {
		return useSparseMatrix;
	}

	/**
	 * Returns the tip text for this property.
	 * 
	 * @return tip text for this property suitable for displaying in the
	 *         explorer/experimenter gui
	 */
	public String useSparseMatrixTipText() {
		return "use sparse representation for similarity matrix. It can improve the memory efficiency";
	}

	public int[] getCluster() {
		return cluster;
	}
	
	public List<INMultipleAlignment> cluster(List<IScorableKtup> orderedKtups, INKtupCentroidFilter<IScorableKtup> filter) {
		
		List<INMultipleAlignment> alignments = new ArrayList<INMultipleAlignment>();
		
		initKtups(orderedKtups, filter);

		initScores();
		
		buildClusterer();
		
		for (int i = 0; i < numOfClusters; i++) {
			INMultipleAlignment alignment = clusterOne(i);
			if (alignment != null) {
				alignments.add(alignment);
			}
			/*
			for (int j = 0; j < filledKtupsCount; j++) {
				if (cluster[j] == i) {
					IScorableKtup ktup = getKtup(j);
					INScorableAlignable alignable = ktup.getAlignable();
					int start = Math.max(0, ktup.getOffset() - 10);
					int end = Math.min(alignable.length() - 1, ktup.getOffset() + ktup.getLength() - 1 + 10);
					log.info("cluster " + i + " alignable " + alignable.getChars(start, end) + "\n");
				}
			}
			*/
		}
		
		return alignments;
	}
	
	private INMultipleAlignment clusterOne(int clusterIndex) {
		// copy ktups
		IScorableKtup[][] clusterKtups = new IScorableKtup[alignablesCount][];
		int[] clusterKtupsCount = new int[alignablesCount];
		int clusterAlignablesCount = 0;
		for (int i = 0; i < alignablesCount; i++) {
			clusterKtups[i] = new IScorableKtup[ktups[i].length];
			clusterKtupsCount[i] = 0;
			for (int j = 0; j < clusterKtups[i].length; j++) {
				int ktupIndex = alignableScoreTableIndexes[i][j];
				if (cluster[ktupIndex] == clusterIndex) {
					clusterKtups[i][j] = ktups[i][j];
					clusterKtupsCount[i]++;
				}
			}
			if (clusterKtupsCount[i] > 0) {
				clusterAlignablesCount++;
			}
		}
		
		singleLinkSingleCluster.init(clusterAlignablesCount, clusterKtups, clusterKtupsCount, alignableIdToAlignableIndex, alignableScoreTableIndexes, scoreTableIndexAlignable, scoreTableIndexAlignableIndex, filledKtupsCount, scores, filter);

		INMultipleAlignment alignment = singleLinkSingleCluster.clusterOne();
		
		return alignment;
	}

}
