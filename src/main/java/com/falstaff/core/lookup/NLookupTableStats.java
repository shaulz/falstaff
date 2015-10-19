package com.falstaff.core.lookup;

import com.falstaff.core.util.Histogram;

public class NLookupTableStats {

	// histogram of number of times ktup was filled into the table
	private Histogram<Integer> ktupsInCentroidCounts;
	
	// histogram of number of ktups of alignable in centroid
	private Histogram<Integer> alignableKtupsInCentroidCounts;
	
	// histogram of number of alignables in centroid
	private Histogram<Integer> alignablesInCentroidCounts;
	
	private int centroidsCount;
	private int ktupsCount;
	
	public NLookupTableStats() {
		ktupsInCentroidCounts = new Histogram<Integer>();
		alignableKtupsInCentroidCounts = new Histogram<Integer>();
		alignablesInCentroidCounts = new Histogram<Integer>();
		centroidsCount = 0;
		ktupsCount = 0;
	}

	public Histogram<Integer> getKtupsInCentroidCounts() {
		return ktupsInCentroidCounts;
	}


	public Histogram<Integer> getAlignableKtupsInCentroidCounts() {
		return alignableKtupsInCentroidCounts;
	}


	public Histogram<Integer> getAlignablesInCentroidCounts() {
		return alignablesInCentroidCounts;
	}

	public int getCentroidsCount() {
		return centroidsCount;
	}

	public void setCentroidsCount(int centroidsCount) {
		this.centroidsCount = centroidsCount;
	}

	public int getKtupsCount() {
		return ktupsCount;
	}

	public void setKtupsCount(int ktupsCount) {
		this.ktupsCount = ktupsCount;
	}
	
	public void clear() {
		ktupsInCentroidCounts = new Histogram<Integer>();
		alignableKtupsInCentroidCounts = new Histogram<Integer>();
		alignablesInCentroidCounts = new Histogram<Integer>();
		centroidsCount = 0;
		ktupsCount = 0;		
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("\n\nktups count " + ktupsCount).append("\n\ncentroids count " + centroidsCount).append("\n\nNumber of ktups in centroid\n").append(ktupsInCentroidCounts.toString()).
		append("\nNumber of alignables in centroid\n").append(alignablesInCentroidCounts.toString()).
		append("\nNumber of ktups of alignable in centroid\n").append(alignableKtupsInCentroidCounts.toString());
		return b.toString();
	}
	
}
