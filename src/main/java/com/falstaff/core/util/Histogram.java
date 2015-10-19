package com.falstaff.core.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This is a basic histogram class.
 */
public class Histogram<T> {
	Map<T, Integer> hist = new HashMap<T, Integer>();

	public void increment(T val) {
		if (hist.containsKey(val)) {
			int i = hist.get(val);
			i++;
			hist.put(val, i);
		} else {
			hist.put(val, 1);
		}
	}

	/**
	 * Create a histogram slot bin for value val, and give it a count of 0.
	 */
	public void reset(T val) {
		hist.put(val, 0);
	}

	public void incrementN(T val, int j) {
		assert (j > 0);
		if (hist.containsKey(val)) {
			int i = hist.get(val);
			i += j;
			hist.put(val, i);
		} else {
			hist.put(val, j);
		}
	}

	/**
	 * Merge values,counts from h2 into this histogram
	 */
	public void merge(Histogram<T> h2) {
		if (h2 == null)
			return;
		for (T k : h2.keys()) {
			incrementN(k, h2.get(k));
		}
	}

	public int get(T val) {
		assert (val != null);
		if (hist.containsKey(val)) {
			return hist.get(val);
		}
		return 0;
	}

	public Set<T> keys() {
		return hist.keySet();
	}

	/**
	 * Returns the histogram in frequency sorted order
	 * 
	 * @return
	 */
	public SortedSet<Pair<T, Integer>> sorted() {

		// TODO (jon) change to use an array and Arrays.sort();

		SortedSet<Pair<T, Integer>> sort = new TreeSet<Pair<T, Integer>>(
				new Comparator<Pair<T, Integer>>() {
					@SuppressWarnings("unchecked")
					@Override
					public int compare(Pair<T, Integer> o1, Pair<T, Integer> o2) {
						int delta = o2.getRight() - o1.getRight();
						if (delta != 0)
							return delta;

						// TODO (jon) this is gross -- Move this comparable code
						// into a
						// static class in Pair.
						if (o1 instanceof Comparable
								&& o2 instanceof Comparable) {
							Comparable c1 = ((Comparable) o1.getLeft());
							Comparable c2 = ((Comparable) o2.getLeft());
							return c1.compareTo(c2);
						} else {
							// this is a performance killer for VBytes
							return o1.getLeft().toString()
									.compareTo(o2.getLeft().toString());
						}
					}
				});

		for (Map.Entry<T, Integer> ent : hist.entrySet()) {
			sort.add(new Pair<T, Integer>(ent.getKey(), ent.getValue()));
		}

		return sort;
	}

	/**
	 * Return the number of keys present in the histogram
	 */
	public int size() {
		return hist.size();
	}

	/**
	 * Return the total sum of counts present in the histogram
	 */
	public int total() {
		int hits1 = 0;
		for (int v : hist.values()) {
			hits1 += v;
		}
		return hits1;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (T key : hist.keySet()) {
			b.append(String.format("%6d :: %s,\n", hist.get(key), key));
		}
		return b.toString();
	}

}
