package com.falstaff.core.score;

public class Blast {

	/****************************************************************************
	 * For more accuracy in the calculation of K, set K_SUMLIMIT to 0.00001. For
	 * high speed in the calculation of K, use a K_SUMLIMIT of 0.001 Note:
	 * statistical significance is often not greatly affected by the value of K,
	 * so high accuracy is generally unwarranted.
	 *****************************************************************************/
	private static double BLAST_KARLIN_K_SUMLIMIT_DEFAULT = 0.0001;
	/** < K_SUMLIMIT_DEFAULT == sumlimit used in BlastKarlinLHtoK() */

	private static double BLAST_KARLIN_LAMBDA_ACCURACY_DEFAULT = 1.e-5;
	/** < LAMBDA_ACCURACY_DEFAULT == accuracy to which Lambda should be calc'd */

	private static int BLAST_KARLIN_LAMBDA_ITER_DEFAULT = 17;
	/**
	 * < LAMBDA_ITER_DEFAULT == no. of iterations in LambdaBis =
	 * ln(accuracy)/ln(2)
	 */

	private static double BLAST_KARLIN_LAMBDA0_DEFAULT = 0.5;
	/** < Initial guess for the value of Lambda in BlastKarlinLambdaNR */

	private static int BLAST_KARLIN_K_ITER_MAX = 100;
	/** < upper limit on iterations for BlastKarlinLHtoK */

	public static boolean ADD_GEOMETRIC_TERMS_TO_K = false;

	public static int BLAST_SCORE_MIN = Short.MIN_VALUE;
	/** < minimum allowed score (for one letter comparison). */
	public static int BLAST_SCORE_MAX = Short.MAX_VALUE;
	/** < maximum allowed score (for one letter comparison). */

	public static int BLAST_SCORE_RANGE_MAX = (BLAST_SCORE_MAX - BLAST_SCORE_MIN);

	/** < maximum allowed range of BLAST scores. */

	/*
	 * Blast_CalcLambdaFullPrecision -- interface documented in
	 * composition_adjustment.h.
	 * 
	 * If the average score for a composition is negative, and the maximum score
	 * that occurs with nonzero probability is positive, then statistical
	 * parameter Lambda exists and is the unique, positive solution to
	 * 
	 * phi(lambda) = sum_{i,j} P_1(i) P_2(j) exp(S_{ij} lambda) - 1 = 0,
	 * 
	 * where S_{ij} is the matrix "score" and P_1 and P_2 are row_probs and
	 * col_probs respectively.
	 * 
	 * It is simpler to solve this problem in x = exp(-lambda) than it is to
	 * solve it in lambda, because we know that for x, a solution lies in [0,1].
	 * Furthermore, if M is the largest S_{ij} so that P_1(i) and P_2(j) are
	 * nonzero, then the function
	 * 
	 * f(x) = -x^M - sum_{i,j} P_1(i) P_2(j) x^{M - S_{ij}},
	 * 
	 * obtained by multiplying phi(lambda) by x^M, is well behaved in (0,1] --
	 * if the scores are integers, it is a polynomial. Since x = 0 is not a
	 * solution, x solves f(x) = 0 in [0,1), if and only if lambda = -ln(x) is a
	 * positive solution to phi(lambda). Therefore, we may define a safeguarded
	 * Newton iteration to find a solution of f(x) = 0.
	 * 
	 * For the most part, this is a standard safeguarded Newton iteration:
	 * define an interval of uncertainty [a,b] with f(a) > 0 and f(b) < 0
	 * (except for the initial value b = 1, where f(b) = 0); evaluate the
	 * function and use the sign of that value to shrink the interval of
	 * uncertainty; compute a Newton step; and if the Newton step suggests a
	 * point outside the interval of uncertainty or fails to decrease the
	 * function sufficiently, then bisect. There are three further details
	 * needed to understand the algorithm:
	 * 
	 * 1) If y the unique solution in [0,1], then f is positive to the left of
	 * y, and negative to the right. Therefore, we may determine whether the
	 * Newton step -f(x)/f'(x) is moving toward, or away from, y by examining
	 * the sign of f'(x). If f'(x) >= 0, we bisect, instead of taking the Newton
	 * step. 2) There is a neighborhood around x = 1 for which f'(x) >= 0, so
	 * (1) prevents convergence to x = 1. 3) Conditions like fabs(p) <
	 * lambda_tolerance * x * (1-x) are used in convergence criteria because
	 * these values translate to a bound on the relative error in lambda. This
	 * is proved in the "Blast Scoring Parameters" document that accompanies the
	 * BLAST code.
	 * 
	 * We have observed that in typical cases the safeguarded Newton iteration
	 * on f(x) requires half the iterations of a Newton iteration on
	 * phi(lambda). More importantly, the iteration on f(x) is robust and
	 * doesn't overflow; defining a robust safeguarded Newton iteration on
	 * phi(lambda) that cannot converge to zero and that is protected against
	 * overflow is more difficult. So (despite the length of this comment) the
	 * Newton iteration on f(x) is the simpler solution.
	 */
	public static double calcLambdaFullPrecision(double score[][], int alphsize,
			double row_prob[], double col_prob[], double lambda_tolerance,
			double function_tolerance, int max_iterations) {
		double lambda;
		double f = 4; /*
					 * The current function value; initially set to a value
					 * greater than any possible real value of f
					 */
		double left = 0, right = 1; /*
									 * (left, right) is an interval containing a
									 * solution
									 */
		double x = 0.367879441171; /* The current iterate; initially exp(-1) */
		boolean is_newton = false; /*
									 * true if the last iteration was a Newton
									 * step; initially false
									 */
		int i, j, k; /* iteration indices */
		/* maximum score that occurs with nonzero probability */
		double max_score = 0.0;
		/* average score */
		double avg_score = 0.0;

		/* Find the maximum score with nonzero probability */
		for (i = 0; i < alphsize; i++) {
			if (row_prob[i] == 0.0) {
				continue;
			}
			for (j = 0; j < alphsize; j++) {
				if (col_prob[j] == 0.0) {
					continue;
				}
				if (max_score < score[i][j]) {
					max_score = score[i][j];
				}
				avg_score += row_prob[i] * col_prob[j] * score[i][j];
			}
		}
		if (max_score <= 0.0 || avg_score >= 0) {
			/*
			 * The iteration cannot converge if max_score is nonpositive or the
			 * average score is nonnegative; lambda doesn't exist
			 */
			lambda = -1.0;
			return lambda;
		}
		for (k = 0; k < max_iterations; k++) {
			double slope; /* slope of f at x */
			double fold = f; /* previous value of f */
			double x_pow_max_score; /* x raised to the power max_score */
			lambda = -Math.log(x); /* the iterate lambda, see above */
			boolean was_newton = is_newton; /*
											 * true if the previous iteration
											 * was a Newton step; instead of a
											 * bisection step
											 */
			/* Evaluate the function and its derivative */
			x_pow_max_score = Math.exp(-max_score * lambda);
			f = -x_pow_max_score;
			slope = max_score * f / x;
			for (i = 0; i < alphsize; i++) {
				if (row_prob[i] == 0.0) {
					continue;
				}
				for (j = 0; j < alphsize; j++) {
					double ff; /* a term in the sum used to compute f */

					if (col_prob[j] == 0.0) {
						continue;
					}
					if (max_score != score[i][j]) {
						double diff_score = max_score - score[i][j];

						ff = row_prob[i] * col_prob[j]
								* Math.exp(-lambda * diff_score);
						slope += diff_score * ff / x;
					} else {
						ff = row_prob[i] * col_prob[j];
					}
					f += ff;
				}
			}
			/* Finished evaluating the function and its derivative */
			if (f > 0) {
				left = x; /* move the left endpoint */
			} else if (f < 0) {
				right = x; /* move the right endpoint */
			} else { /* f == 0 */
				break; /* x is an exact solution */
			}
			if (right - left <= 2 * left * (1 - right) * lambda_tolerance
					&& Math.abs(f / x_pow_max_score) <= function_tolerance) {
				/* The midpoint of the interval converged */
				x = (left + right) / 2;
				break;
			}
			if ((was_newton && Math.abs(f) > 0.9 * Math.abs(fold))
			/*
			 * if the previous iteration was a Newton step but didn't decrease f
			 * sufficiently; or
			 */
			|| slope >= 0
			/* if a Newton step will move us away from the desired solution */
			) {/* then */
				x = (left + right) / 2; /* bisect */
			} else {
				double p = -f / slope; /* The Newton step */
				double y = x + p; /* The proposed next iterate */
				if (y <= left || y >= right) { /*
												 * The proposed iterate is not
												 * in (left,right)
												 */
					x = (left + right) / 2; /* bisect */
				} else {/* The proposed iterate is in (left,right). Accept it. */
					is_newton = true;
					x = y;
					if (Math.abs(p) <= lambda_tolerance * x * (1 - x)
							&& Math.abs(f / x_pow_max_score) <= function_tolerance)
						break;
				}
			}
		} /* End for all iterations k */
		lambda = (k < max_iterations) ? -Math.log(x) : -1.0;
		return lambda;
	}

	/**
	 * Holds score frequencies used in calculation of Karlin-Altschul parameters
	 * for an ungapped search.
	 */
	public static class Blast_ScoreFreq {

		private int score_min;
		/** < lowest allowed scores */
		private int score_max;
		/** < highest allowed scores */
		private int obs_min;
		/** < lowest observed (actual) scores */
		private int obs_max;
		/** < highest observed (actual) scores */
		private double score_avg;
		/** < arrays for frequency of given score */
		private double[] sprob;
		/** < arrays for frequency of given score, shifted down by score_min. */
		private Pointer scoreProbabilities;

		public Blast_ScoreFreq(int score_min, int score_max, double[] probabilities) {
			super();
			this.score_min = score_min;
			this.score_max = score_max;

			this.obs_min = score_min;
			this.obs_max = score_max;

			int range = score_max - score_min + 1;
			if (probabilities.length != range) {
				throw new RuntimeException("probabilities length " + probabilities.length + " is different from the range " + range);
			}
			
			for (int i = 0; i < range; i++) {
				if (probabilities[i] != 0.0) {
					this.obs_min += i;
					break;
				}
			}
			
			for (int i = 0; i < range; i++) {
				if (probabilities[range - i - 1] != 0.0) {
					this.obs_max -= i;
					break;
				}
			}
			
			sprob = probabilities;
			score_avg = 0.0;
			for (int i = 0; i < range; i++) {
				score_avg += probabilities[i] * (i + score_min); 
			}			
			scoreProbabilities = new Pointer(sprob, -score_min);
		}

		public double getScoreProbability(int score) {
			return scoreProbabilities.get(score);
		}

		public double getScore_avg() {
			return score_avg;
		}

		public Pointer getScoreProbabilities() {
			return scoreProbabilities;
		}

		public int getScore_min() {
			return score_min;
		}

		public int getScore_max() {
			return score_max;
		}

		public int getObs_min() {
			return obs_min;
		}

		public int getObs_max() {
			return obs_max;
		}
	}

	/**
	 * Structure to hold the Karlin-Altschul parameters.
	 */
	public static class Blast_KarlinBlk {
		private double Lambda;
		/** < Lambda value used in statistics */
		private double K;
		/** < K value used in statistics */
		private double logK;
		/** < natural log of K value used in statistics */
		private double H;
		/** < H value used in statistics */
		private double paramC;

		/** < for use in seed. */
		public double getLambda() {
			return Lambda;
		}

		public void setLambda(double lambda) {
			Lambda = lambda;
		}

		public double getK() {
			return K;
		}

		public void setK(double k) {
			K = k;
		}

		public double getLogK() {
			return logK;
		}

		public void setLogK(double logK) {
			this.logK = logK;
		}

		public double getH() {
			return H;
		}

		public void setH(double h) {
			H = h;
		}

		public double getParamC() {
			return paramC;
		}

		public void setParamC(double paramC) {
			this.paramC = paramC;
		}

	}

	public static class Pointer {

		private double[] array;
		private int pointer;

		public Pointer(double[] array, int pointer) {
			super();
			this.array = array;
			this.pointer = pointer;
		}

		public Pointer(Pointer ptr, int shift) {
			this.array = ptr.getArray();
			this.pointer = ptr.getPointer() + shift;
		}

		public double get() {
			return array[pointer];
		}

		public double get(int index) {
			return array[pointer + index];
		}

		public void set(double value) {
			array[pointer] = value;
		}

		public void setPointer(int pointer) {
			this.pointer = pointer;
		}

		public void increment() {
			pointer++;
		}

		public void decrement() {
			pointer--;
		}

		public double[] getArray() {
			return array;
		}

		public int getPointer() {
			return pointer;
		}
	}

	static private int BLAST_Gcd(int a, int b) {
		int c;

		b = Math.abs(b);
		if (b > a) {
			c = a;
			a = b;
			b = c;
		}

		while (b != 0) {
			c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	static double BLAST_Expm1(double x) {
		double absx = Math.abs(x);

		if (absx > .33)
			return Math.exp(x) - 1.;

		if (absx < 1.e-16)
			return x;

		return x
				* (1. + x
						* (1. / 2. + x
								* (1. / 6. + x
										* (1. / 24. + x
												* (1. / 120. + x
														* (1. / 720. + x
																* (1. / 5040. + x
																		* (1. / 40320. + x
																				* (1. / 362880. + x
																						* (1. / 3628800. + x
																								* (1. / 39916800. + x
																										* (1. / 479001600. + x / 6227020800.))))))))))));
	}

	/**
	 * Check that the lo and hi score are within the allowed ranges
	 * 
	 * @param lo
	 *            the lowest permitted value [in]
	 * @param hi
	 *            the highest permitted value [in]
	 * @return zero on success, 1 otherwise
	 */

	static int BlastScoreChk(int lo, int hi) {
		if (lo >= 0 || hi <= 0 || lo < BLAST_SCORE_MIN || hi > BLAST_SCORE_MAX)
			return 1;

		if (hi - lo > BLAST_SCORE_RANGE_MAX)
			return 1;

		return 0;
	}

	static double BLAST_Powi(double x, int n) {
		double y;

		if (n == 0)
			return 1.;

		if (x == 0.) {
			if (n < 0) {
				return Double.MAX_VALUE;
			}
			return 0.;
		}

		if (n < 0) {
			x = 1. / x;
			n = -n;
		}

		y = 1.;
		while (n > 0) {
			if ((n & 1) != 0)
				y *= x;
			n /= 2;
			x *= x;
		}
		return y;
	}

	/**
	 * The following procedure computes K. The input includes Lambda, H, and an
	 * array of probabilities for each score. There are distinct closed form for
	 * three cases: 1. high score is 1 low score is -1 2. high score is 1 low
	 * score is not -1 3. low score is -1, high score is not 1
	 * 
	 * Otherwise, in most cases the value is computed as: -exp(-2.0*outerSum) /
	 * ((H/lambda)*(exp(-lambda) - 1) The last term (exp(-lambda) - 1) can be
	 * computed in two different ways depending on whether lambda is small or
	 * not. outerSum is a sum of the terms innerSum/j, where j is denoted by
	 * iterCounter in the code. The sum is truncated when the new term
	 * innersum/j i sufficiently small. innerSum is a weighted sum of the
	 * probabilities of of achieving a total score i in a gapless alignment,
	 * which we denote by P(i,j). of exactly j characters. innerSum(j) has two
	 * parts Sum over i < 0 P(i,j)exp(-i * lambda) + Sum over i >=0 P(i,j) The
	 * terms P(i,j) are computed by dynamic programming. An earlier version was
	 * flawed in that ignored the special case 1 and tried to replace the tail
	 * of the computation of outerSum by a geometric series, but the base of the
	 * geometric series was not accurately estimated in some cases.
	 * 
	 * @param sfp
	 *            object holding scoring frequency information [in]
	 * @param lambda
	 *            a Karlin-Altschul parameter [in]
	 * @param H
	 *            a Karlin-Altschul parameter [in]
	 * @return K, another Karlin-Altschul parameter
	 */

	static double BlastKarlinLHtoK(Blast_ScoreFreq sfp, double lambda, double H) {
		/*
		 * The next array stores the probabilities of getting each possible
		 * score in an alignment of fixed length; the array is shifted during
		 * part of the computation, so that entry 0 is for score 0.
		 */
		double[] alignmentScoreProbabilities = null;
		int low; /* Lowest score (must be negative) */
		int high; /* Highest score (must be positive) */
		int range; /* range of scores, computed as high - low */
		double K; /* local copy of K to return */
		int i; /* loop index */
		int iterCounter; /* counter on iterations */
		int divisor; /*
					 * candidate divisor of all scores with non-zero
					 * probabilities
					 */
		/* highest and lowest possible alignment scores for current length */
		int lowAlignmentScore, highAlignmentScore;
		int first, last; /* loop indices for dynamic program */
		double innerSum;
		double oldsum, oldsum2; /*
								 * values of innerSum on previous iterations
								 */
		double outerSum; /*
						 * holds sum over j of (innerSum for iteration j/j)
						 */

		double score_avg; /* average score */
		/*
		 * first term to use in the closed form for the case where high == 1 or
		 * low == -1, but not both
		 */
		double firstTermClosedForm; /* usually store H/lambda */
		int iterlimit; /* upper limit on iterations */
		double sumlimit; /*
						 * lower limit on contributions to sum over scores
						 */
		double expMinusLambda; /* e^^(-Lambda) */

		if (lambda <= 0. || H <= 0.) {
			/*
			 * Theory dictates that H and lambda must be positive, so return -1
			 * to indicate an error
			 */
			return -1.;
		}

		/*
		 * Karlin-Altschul theory works only if the expected score is negative
		 */
		if (sfp.score_avg >= 0.0) {
			return -1.;
		}

		low = sfp.obs_min;
		high = sfp.obs_max;
		range = high - low;

		/* array of score probabilities reindexed so that low is at index 0 */
		Pointer probArrayStartLow = new Pointer(sfp.getScoreProbabilities(),
				low);

		/*
		 * Look for the greatest common divisor ("delta" in Appendix of PNAS 87
		 * of Karlin&Altschul (1990)
		 */
		for (i = 1, divisor = -low; i <= range && divisor > 1; ++i) {
			if (probArrayStartLow.get(i) != 0.0)
				divisor = BLAST_Gcd(divisor, i);
		}

		high /= divisor;
		low /= divisor;
		lambda *= divisor;

		range = high - low;

		firstTermClosedForm = H / lambda;
		expMinusLambda = Math.exp((double) -lambda);

		if (low == -1 && high == 1) {
			K = (sfp.getScoreProbability(low * divisor) - sfp
					.getScoreProbability(high * divisor))
					* (sfp.getScoreProbability(low * divisor) - sfp
							.getScoreProbability(high * divisor))
					/ sfp.getScoreProbability(low * divisor);
			return (K);
		}

		if (low == -1 || high == 1) {
			if (high != 1) {
				score_avg = sfp.score_avg / divisor;
				firstTermClosedForm = (score_avg * score_avg)
						/ firstTermClosedForm;
			}
			return firstTermClosedForm * (1.0 - expMinusLambda);
		}

		sumlimit = BLAST_KARLIN_K_SUMLIMIT_DEFAULT;
		iterlimit = BLAST_KARLIN_K_ITER_MAX;

		alignmentScoreProbabilities = new double[iterlimit * range + 1];
		if (alignmentScoreProbabilities == null)
			return -1.;

		outerSum = 0.;
		lowAlignmentScore = highAlignmentScore = 0;
		alignmentScoreProbabilities[0] = innerSum = oldsum = oldsum2 = 1.;

		/* pointers used in dynamic program */
		Pointer ptrP, ptr1, ptr2, ptr1e;

		for (iterCounter = 0; ((iterCounter < iterlimit) && (innerSum > sumlimit)); outerSum += innerSum /= ++iterCounter) {
			first = last = range;
			lowAlignmentScore += low;
			highAlignmentScore += high;
			/* dynamic program to compute P(i,j) */
			for (ptrP = new Pointer(alignmentScoreProbabilities,
					highAlignmentScore - lowAlignmentScore); ptrP.getPointer() >= 0; ptrP
					.set(innerSum), ptrP.decrement()) {
				ptr1 = new Pointer(ptrP, -first);
				ptr1e = new Pointer(ptrP, -last);
				ptr2 = new Pointer(probArrayStartLow, first);
				for (innerSum = 0.; ptr1.getPointer() >= ptr1e.getPointer();) {
					innerSum += ptr1.get() * ptr2.get();
					ptr1.decrement();
					ptr2.increment();
				}
				if (first != 0)
					--first;
				if (ptrP.getPointer() <= range)
					--last;
			}
			/* Horner's rule */
			ptrP.increment();
			innerSum = ptrP.get();
			for (i = lowAlignmentScore + 1; i < 0; i++) {
				ptrP.increment();
				innerSum = ptrP.get() + innerSum * expMinusLambda;
			}
			innerSum *= expMinusLambda;

			for (; i <= highAlignmentScore; ++i) {
				ptrP.increment();
				innerSum += ptrP.get();
			}
			oldsum2 = oldsum;
			oldsum = innerSum;
		}

		if (ADD_GEOMETRIC_TERMS_TO_K) {
			/*
			 * old code assumed that the later terms in sum were asymptotically
			 * comparable to those of a geometric progression, and tried to
			 * speed up convergence by guessing the estimated ratio between
			 * sucessive terms and using the explicit terms of a geometric
			 * progression to speed up convergence. However, the assumption does
			 * not always hold, and convergenece of the above code is fast
			 * enough in practice
			 */
			/* Terms of geometric progression added for correction */

			double ratio; /*
						 * fraction used to generate the geometric progression
						 */

			ratio = oldsum / oldsum2;
			if (ratio >= (1.0 - sumlimit * 0.001)) {
				K = -1.;
				return K;
			}
			sumlimit *= 0.01;
			while (innerSum > sumlimit) {
				oldsum *= ratio;
				outerSum += innerSum = oldsum / ++iterCounter;
			}
		}

		K = -Math.exp((double) -2.0 * outerSum)
				/ (firstTermClosedForm * BLAST_Expm1(-(double) lambda));

		return K;
	}

	/**
	 * Find positive solution to
	 * 
	 * sum_{i=low}^{high} exp(i lambda) * probs[i] = 1.
	 * 
	 * Note that this solution does not exist unless the average score is
	 * negative and the largest score that occurs with nonzero probability is
	 * positive.
	 * 
	 * @param probs
	 *            probabilities of a score occurring
	 * @param d
	 *            the gcd of the possible scores. This equals 1 if the scores
	 *            are not a lattice
	 * @param low
	 *            the lowest possible score that occurs with nonzero probability
	 * @param high
	 *            the highest possible score that occurs with nonzero
	 *            probability.
	 * @param lambda0
	 *            an initial guess for lambda
	 * @param tolx
	 *            the tolerance to which lambda must be computed
	 * @param itmax
	 *            the maximum number of times the function may be evaluated
	 * @param maxNewton
	 *            the maximum permissible number of Newton iterations; after
	 *            that the computation will proceed by bisection.
	 * @param *itn the number of iterations needed to compute Lambda, or itmax
	 *        if Lambda could not be computed.
	 * 
	 *        Let phi(lambda) = sum_{i=low}^{high} exp(i lambda) - 1. Then
	 *        phi(lambda) may be written
	 * 
	 *        phi(lamdba) = exp(u lambda) f( exp(-lambda) )
	 * 
	 *        where f(x) is a polynomial that has exactly two zeros, one at x =
	 *        1 and one at x = exp(-lamdba). It is simpler to solve this problem
	 *        in x = exp(-lambda) than it is to solve it in lambda, because we
	 *        know that for x, a solution lies in [0,1], and because Newton's
	 *        method is generally more stable and efficient for polynomials than
	 *        it is for exponentials.
	 * 
	 *        For the most part, this function is a standard safeguarded Newton
	 *        iteration: define an interval of uncertainty [a,b] with f(a) > 0
	 *        and f(b) < 0 (except for the initial value b = 1, where f(b) = 0);
	 *        evaluate the function and use the sign of that value to shrink the
	 *        interval of uncertainty; compute a Newton step; and if the Newton
	 *        step suggests a point outside the interval of uncertainty or fails
	 *        to decrease the function sufficiently, then bisect. There are
	 *        three further details needed to understand the algorithm:
	 * 
	 *        1) If y the unique solution in [0,1], then f is positive to the
	 *        left of y, and negative to the right. Therefore, we may determine
	 *        whether the Newton step -f(x)/f'(x) is moving toward, or away
	 *        from, y by examining the sign of f'(x). If f'(x) >= 0, we bisect
	 *        instead of taking the Newton step. 2) There is a neighborhood
	 *        around x = 1 for which f'(x) >= 0, so (1) prevents convergence to
	 *        x = 1 (and for a similar reason prevents convergence to x = 0, if
	 *        the function is incorrectly called with probs[high] == 0). 3)
	 *        Conditions like fabs(p) < lambda_tolerance * x * (1-x) are used in
	 *        convergence criteria because these values translate to a bound on
	 *        the relative error in lambda. This is proved in the
	 *        "Blast Scoring Parameters" document that accompanies the BLAST
	 *        code.
	 * 
	 *        The iteration on f(x) is robust and doesn't overflow; defining a
	 *        robust safeguarded Newton iteration on phi(lambda) that cannot
	 *        converge to lambda = 0 and that is protected against overflow is
	 *        more difficult. So (despite the length of this comment) the Newton
	 *        iteration on f(x) is the simpler solution.
	 */
	static double NlmKarlinLambdaNR(Pointer probs, int d, int low, int high,
			double lambda0, double tolx, int itmax, int maxNewton, int[] itn) {
		int k;
		double x0, x, a = 0, b = 1;
		double f = 4; /* Larger than any possible value of the poly in [0,1] */
		int isNewton = 0; /* we haven't yet taken a Newton step. */

		assert (d > 0);

		x0 = Math.exp(-lambda0);
		x = (0 < x0 && x0 < 1) ? x0 : .5;

		for (k = 0; k < itmax; k++) { /* all iteration indices k */
			int i;
			double g, fold = f;
			int wasNewton = isNewton; /* If true, then the previous step was a */
			/* Newton step */
			isNewton = 0; /* Assume that this step is not */

			/* Horner's rule for evaluating a polynomial and its derivative */
			g = 0;
			f = probs.get(low);
			for (i = low + d; i < 0; i += d) {
				g = x * g + f;
				f = f * x + probs.get(i);
			}
			g = x * g + f;
			f = f * x + probs.get(0) - 1;
			for (i = d; i <= high; i += d) {
				g = x * g + f;
				f = f * x + probs.get(i);
			}
			/* End Horner's rule */

			if (f > 0) {
				a = x; /* move the left endpoint */
			} else if (f < 0) {
				b = x; /* move the right endpoint */
			} else { /* f == 0 */
				break; /* x is an exact solution */
			}
			if (b - a < 2 * a * (1 - b) * tolx) {
				/* The midpoint of the interval converged */
				x = (a + b) / 2;
				break;
			}

			if (k >= maxNewton ||
			/* If convergence of Newton's method appears to be failing; or */
			(wasNewton != 0 && Math.abs(f) > .9 * Math.abs(fold)) ||
			/*
			 * if the previous iteration was a Newton step but didn't decrease f
			 * sufficiently; or
			 */
			g >= 0
			/* if a Newton step will move us away from the desired solution */
			) { /* then */
				/* bisect */
				x = (a + b) / 2;
			} else {
				/* try a Newton step */
				double p = -f / g;
				double y = x + p;
				if (y <= a || y >= b) { /* The proposed iterate is not in (a,b) */
					x = (a + b) / 2;
				} else { /* The proposed iterate is in (a,b). Accept it. */
					isNewton = 1;
					x = y;
					if (Math.abs(p) < tolx * x * (1 - x))
						break; /* Converged */
				} /* else the proposed iterate is in (a,b) */
			} /* else try a Newton step. */
		} /* end for all iteration indices k */
		itn[0] = k;
		return -Math.log(x) / d;
	}

	public static double Blast_KarlinLambdaNR(Blast_ScoreFreq sfp, double initialLambdaGuess) {
		int low; /* Lowest score (must be negative) */
		int high; /* Highest score (must be positive) */
		int[] itn;
		int i, d;
		Pointer sprob;
		double returnValue;

		low = sfp.getObs_min();
		high = sfp.getObs_max();
		if (sfp.getScore_avg() >= 0.) { /* Expected score must be negative */
			return -1.0;
		}
		if (BlastScoreChk(low, high) != 0)
			return -1.;

		/* Find greatest common divisor of all scores */
		for (i = 1, d = -low; i <= high - low && d > 1; ++i) {
			if (sfp.getScoreProbability(i + low) != 0.0) {
				d = BLAST_Gcd(d, i);
			}
		}

		itn = new int[1];

		sprob = sfp.getScoreProbabilities();

		returnValue = NlmKarlinLambdaNR(sprob, d, low, high,
				initialLambdaGuess, BLAST_KARLIN_LAMBDA_ACCURACY_DEFAULT, 20,
				20 + BLAST_KARLIN_LAMBDA_ITER_DEFAULT, itn);

		return returnValue;
	}

	/**
	 * Calculate H, the relative entropy of the p's and q's
	 * 
	 * @param sfp
	 *            object containing scoring frequency information [in]
	 * @param lambda
	 *            a Karlin-Altschul parameter [in]
	 * @return H, a Karlin-Altschul parameter
	 */
	static double BlastKarlinLtoH(Blast_ScoreFreq sfp, double lambda) {
		int score;
		double H, etonlam, sum, scale;

		Pointer probs = sfp.getScoreProbabilities();
		int low = sfp.getObs_min(), high = sfp.getObs_max();

		if (lambda < 0.) {
			return -1.;
		}
		if (BlastScoreChk(low, high) != 0)
			return -1.;

		etonlam = Math.exp(-lambda);
		sum = low * probs.get(low);
		for (score = low + 1; score <= high; score++) {
			sum = score * probs.get(score) + etonlam * sum;
		}

		scale = BLAST_Powi(etonlam, high);
		if (scale > 0.0) {
			H = lambda * sum / scale;
		} else { /* Underflow of exp( -lambda * high ) */
			H = lambda * Math.exp(lambda * high + Math.log(sum));
		}
		return H;
	}

	/****************
	 * Statistical Significance Parameter Subroutine ****************
	 * 
	 * Version 1.0 February 2, 1990 Version 1.2 July 6, 1990
	 * 
	 * Program by: Stephen Altschul
	 * 
	 * Address: National Center for Biotechnology Information National Library
	 * of Medicine National Institutes of Health Bethesda, MD 20894
	 * 
	 * Internet: altschul@ncbi.nlm.nih.gov
	 * 
	 * See: Karlin, S. & Altschul, S.F. "Methods for Assessing the Statistical
	 * Significance of Molecular Sequence Features by Using General Scoring
	 * Schemes," Proc. Natl. Acad. Sci. USA 87 (1990), 2264-2268.
	 * 
	 * Computes the parameters lambda and K for use in calculating the
	 * statistical significance of high-scoring segments or subalignments.
	 * 
	 * The scoring scheme must be integer valued. A positive score must be
	 * possible, but the expected (mean) score must be negative.
	 * 
	 * A program that calls this routine must provide the value of the lowest
	 * possible score, the value of the greatest possible score, and a pointer
	 * to an array of probabilities for the occurrence of all scores between
	 * these two extreme scores. For example, if score -2 occurs with
	 * probability 0.7, score 0 occurs with probability 0.1, and score 3 occurs
	 * with probability 0.2, then the subroutine must be called with low = -2,
	 * high = 3, and pr pointing to the array of values { 0.7, 0.0, 0.1, 0.0,
	 * 0.0, 0.2 }. The calling program must also provide pointers to lambda and
	 * K; the subroutine will then calculate the values of these two parameters.
	 * In this example, lambda=0.330 and K=0.154.
	 * 
	 * The parameters lambda and K can be used as follows. Suppose we are given
	 * a length N random sequence of independent letters. Associated with each
	 * letter is a score, and the probabilities of the letters determine the
	 * probability for each score. Let S be the aggregate score of the highest
	 * scoring contiguous segment of this sequence. Then if N is sufficiently
	 * large (greater than 100), the following bound on the probability that S
	 * is greater than or equal to x applies:
	 * 
	 * P( S >= x ) <= 1 - exp [ - KN exp ( - lambda * x ) ].
	 * 
	 * In other words, the p-value for this segment can be written as
	 * 1-exp[-KN*exp(-lambda*S)].
	 * 
	 * This formula can be applied to pairwise sequence comparison by assigning
	 * scores to pairs of letters (e.g. amino acids), and by replacing N in the
	 * formula with N*M, where N and M are the lengths of the two sequences
	 * being compared.
	 * 
	 * In addition, letting y = KN*exp(-lambda*S), the p-value for finding m
	 * distinct segments all with score >= S is given by:
	 * 
	 * 2 m-1 -y 1 - [ 1 + y + y /2! + ... + y /(m-1)! ] e
	 * 
	 * Notice that for m=1 this formula reduces to 1-exp(-y), which is the same
	 * as the previous formula.
	 *******************************************************************************/
	public static int Blast_KarlinBlkUngappedCalc(Blast_KarlinBlk kbp, Blast_ScoreFreq sfp) {

		if (kbp == null || sfp == null)
			return 1;

		/* Calculate the parameter Lambda */

		double Lambda = Blast_KarlinLambdaNR(sfp, BLAST_KARLIN_LAMBDA0_DEFAULT);
		kbp.setLambda(Lambda);
		if (kbp.getLambda() < 0.) {
			kbp.setLambda(-1.);
			kbp.setH(-1.);
			kbp.setK(-1.);
			kbp.setLogK(Double.MAX_VALUE);
			return 1;
		}

		/* Calculate H */

		double H = BlastKarlinLtoH(sfp, kbp.getLambda());
		kbp.setH(H);
		if (kbp.getH() < 0.) {
			kbp.setLambda(-1.);
			kbp.setH(-1.);
			kbp.setK(-1.);
			kbp.setLogK(Double.MAX_VALUE);
			return 1;
		}

		/* Calculate K and log(K) */

		double K = BlastKarlinLHtoK(sfp, kbp.getLambda(), kbp.getH());
		kbp.setK(K);
		if (kbp.getK() < 0.) {
			kbp.setLambda(-1.);
			kbp.setH(-1.);
			kbp.setK(-1.);
			kbp.setLogK(Double.MAX_VALUE);
			return 1;
		}

		kbp.setLogK(Math.log(kbp.getK()));

		/* Normal return */
		return 0;
	}

}
