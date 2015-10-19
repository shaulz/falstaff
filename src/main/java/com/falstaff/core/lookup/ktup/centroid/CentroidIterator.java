package com.falstaff.core.lookup.ktup.centroid;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

import com.falstaff.core.lookup.ktup.IKtup;

public class CentroidIterator<T extends IKtup> implements
		Iterator<IKtupCentroid<T>> {

	private Comparator<IKtupCentroid<T>> centroidComparator = new Comparator<IKtupCentroid<T>>() {
		@Override
		public int compare(IKtupCentroid<T> c1, IKtupCentroid<T> c2) {
			// prefer those with more alignables
			int c = (new Integer(c2.getAlignablesCount()).compareTo(new Integer(c1
					.getAlignablesCount())));
			// prefer those less repeating
			if (c == 0) {
				c = (new Integer(c1.getKtupsCount()).compareTo(new Integer(c2
					.getKtupsCount())));
			}
			return c;
		}
	};

	private INKtupCentroidFilter<T> filter;
	private NavigableMap<Integer, List<IKtupCentroid<T>>> centroids;
	private Iterator<IKtupCentroid<T>> iterator;
	private Integer currentAlignablesCount;
	private IKtupCentroid<T> current;

	public CentroidIterator(List<IKtupCentroid<T>> centroidsList,
			INKtupCentroidFilter<T> filter) {
		this.filter = filter;
		centroids = new TreeMap<Integer, List<IKtupCentroid<T>>>();
		for (IKtupCentroid<T> centroid : centroidsList) {
			int alignablesCount = centroid.getAlignablesCount();
			if (!centroids.containsKey(alignablesCount)) {
				centroids.put(alignablesCount,
						new LinkedList<IKtupCentroid<T>>());
			}
			centroids.get(alignablesCount).add(centroid);
		}
		for (Integer alignablesCount : centroids.keySet()) {
			Collections
					.sort(centroids.get(alignablesCount), centroidComparator);
		}
		if (!centroids.isEmpty()) {
			currentAlignablesCount = centroids.lastKey();
		}
		if (currentAlignablesCount != null) {
			iterator = centroids.get(currentAlignablesCount).iterator();
			setCurrent();
		}
	}

	private void setCurrent() {
		if (currentAlignablesCount == null) {
			return;
		}
		while (true) {
			current = null;
			while (iterator.hasNext()) {
				current = iterator.next();
				if (current.getAlignablesCount() != currentAlignablesCount) {
					if (filter != null && filter.filter(current)) {
						current = null;
						continue;
					}
					int alignablesCount = current.getAlignablesCount();
					if (!centroids.containsKey(alignablesCount)) {
						centroids.put(alignablesCount,
								new LinkedList<IKtupCentroid<T>>());
					}
					List<IKtupCentroid<T>> centroidsList = centroids
							.get(alignablesCount);
					int index = Collections.binarySearch(centroidsList,
							current, centroidComparator);
					if (index < 0) {
						index = -index - 1;
					}
					centroidsList.add(current);
					current = null;
				}
				else {
					if (filter != null && filter.filter(current)) {
						current = null;
						continue;
					}
					break;
				}
			}
			
			if (current != null) {
				break;
			}
			currentAlignablesCount = centroids.lowerKey(currentAlignablesCount);
			if (currentAlignablesCount == null) {
				break;
			}
			iterator = centroids.get(currentAlignablesCount).iterator();
		}
	}

	@Override
	public boolean hasNext() {
		if (current != null && current.getAlignablesCount() != currentAlignablesCount) {
			setCurrent();
		}
		return current != null;
	}

	@Override
	public IKtupCentroid<T> next() {
		if (current != null && current.getAlignablesCount() != currentAlignablesCount) {
			setCurrent();
		}
		IKtupCentroid<T> nextCentroid = current;
		setCurrent();
		return nextCentroid;
	}

	@Override
	public void remove() {
	}

}
