package com.falstaff.core.lookup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.centroid.CentroidIterator;
import com.falstaff.core.lookup.ktup.centroid.IKtupCentroid;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;
import com.falstaff.core.lookup.ktup.centroid.KtupCentroid;

public class NLookupTableMemory<T extends IKtup> extends NAbstractLookupTable<T> implements INLookupTable<T> {
	
	private Map<T, List<T>> table = null;
	
	public NLookupTableMemory(int ktupLength) {
		super(ktupLength);
		table = new HashMap<T, List<T>>();
	}

	private static final Logger log = LoggerFactory
			.getLogger(NLookupTableMemory.class.getName());

	@Override
	public boolean add(T ktup) {
		if (!table.containsKey(ktup)) {
			table.put(ktup, new ArrayList<T>());
		}
		table.get(ktup).add(ktup);
		return true;
	}

	@Override
	public void add(INKtupIterator<? extends T> iterator) {
		while (iterator.hasNext()) {
			T ktup = iterator.next();
			add(ktup);
		}		
	}

	@Override
	public void add(Collection<INKtupIterator<? extends T>> iterators,
			INKtupCentroidFilter<T> postFillFilter) {
		for (INKtupIterator<? extends T> iterator : iterators) {
			add(iterator);
		}
		remove(postFillFilter);
	}

	@Override
	public void remove(INKtupCentroidFilter<T> centroidFillFilter) {
		if (centroidFillFilter == null) {
			return;
		}
		Set<T> ktups = new HashSet<T>(table.keySet());
		for (T ktup : ktups) {
			KtupCentroid<T> centroid = new KtupCentroid<T>(table.get(ktup));
			if (centroidFillFilter.filter(centroid)) {
				table.remove(ktup);
			}
		}		
	}

	@Override
	public void remove(Collection<INKtupIterator<? extends T>> iterators,
			INKtupCentroidFilter<T> postFillFilter) {
		for (INKtupIterator<? extends T> iterator : iterators) {
			while (iterator.hasNext()) {
				T ktup = iterator.next();
				List<T> ktups = table.get(ktup);
				if (ktups == null) {
					continue;
				}
				Iterator<T> ktupsIterator = ktups.iterator();
				while (ktupsIterator.hasNext()) {
					T comparedKtup = ktupsIterator.next();
					if (ktup.getAlignable().getId() == comparedKtup.getAlignable().getId() && ktup.getOffset() == comparedKtup.getOffset()) {
						ktupsIterator.remove();
						break;
					}
				}
			}
		}
		Set<T> ktups = new HashSet<T>(table.keySet());
		for (T ktup : ktups) {
			if (table.get(ktup).size() == 0) {
				table.remove(ktup);
			}
		}
		remove(postFillFilter);
	}

	@Override
	public IKtupCentroid<T> getCentroid(T ktup, INKtupCentroidFilter<T> filter) {
		if (!table.containsKey(ktup)) {
			return null;
		}
		KtupCentroid<T> centroid = new KtupCentroid<T>(table.get(ktup));
		if (filter != null && filter.filter(centroid)) {
			return null;
		}
		return centroid;
	}

	@Override
	public CentroidIterator<T> getCentroids(INKtupCentroidFilter<T> filter) {
		List<IKtupCentroid<T>> centroids = new ArrayList<IKtupCentroid<T>>();
		for (T ktup : table.keySet()) {
			KtupCentroid<T> centroid = new KtupCentroid<T>(table.get(ktup));
			if (filter != null && filter.filter(centroid)) {
				continue;
			}
			centroids.add(centroid);
		}
		CentroidIterator<T> centroidIterator = new CentroidIterator<T>(centroids, filter);
		return centroidIterator;
	}

	@Override
	public int getCentroidsCount() {
		return table.size();
	}

	@Override
	public void clear() {
		table.clear();
	}

	@Override
	public void fillStats() {
		// TODO Auto-generated method stub
		
	}
}
