package com.falstaff.core.lookup;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.centroid.CentroidIterator;
import com.falstaff.core.lookup.ktup.centroid.IKtupCentroid;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;

public class NNTreeLookupTable<T extends IKtup> extends NTreeAbstractLookupTable<T> implements INLookupTable<T> {

	private static final Logger log = LoggerFactory
			.getLogger(NTreeCompactLookupTable.class.getName());

	private Object[] table;
	
	public NNTreeLookupTable(int ktupLength) {
		super(ktupLength);
		table = new Object[arity];
	}
	
	public void clear() {
		super.clear();
		table = new Object[arity];
	}	
	
	protected Leaf getLeaf(T ktup) {
		Object[] node = table;
		for (int i = 0; i < ktup.getLength() - 1; i++) {
			if (node == null)
				return null;
			node = (Object[]) node[ktup.getByte(i) + UNSIGNED_SHIFT];
		}
		if (node == null)
			return null;
		Leaf leaf = (Leaf)node[ktup.getByte(ktupLength - 1) + UNSIGNED_SHIFT];

		return leaf;
	}
	
	private void remove(INKtupCentroidFilter<T> centroidFillFilter, Object[] node, int depth) {
		if (depth == ktupLength - 1) {
			for (int i = 0; i < arity; i++) {
				Object leafNode = node[i];
				if (leafNode == null) {
					continue;
				}
				if (centroidFillFilter.filter((Leaf)leafNode)) {
					node[i] = null;
				}
			}
		}
		else {
			for (Object childNode : node) {
				if (childNode == null) {
					continue;
				}
				remove(centroidFillFilter, (Object[])childNode, depth + 1);
			}
		}
	}
	
	protected void remove(INKtupCentroidFilter<T> centroidFillFilter, int partitionStart, int partitionEnd) {
		if (centroidFillFilter == null) {
			return;
		}
		for (int i = 0; i < arity; i++) {
			Object[] node = (Object[]) table[i];
			if (!(i >= partitionStart && i <= partitionEnd)) {
				continue;
			}
			if (node == null) {
				continue;
			}
			remove(centroidFillFilter, node, 1);
		}
	}
	
	public void filter(int partitionStart, int partitionEnd,
			INKtupCentroidFilter<T> centroidFillFilter) {
		for (int i = 0; i < arity; i++) {
			if (!(i >= partitionStart && i <= partitionEnd)) {
				continue;
			}
			Object[] node = (Object[]) table[i];
			if (node == null) {
				continue;
			}
			remove(centroidFillFilter, node, 1);
		}
	}
	

	protected void countEntry(T ktup) {
		Object[] node = table;
		
		for (int i = 0; i < ktupLength - 1; i++) {
			if (node[ktup.getByte(i) + UNSIGNED_SHIFT] == null) {
				Object[] sibling = new Object[arity];
				node[ktup.getByte(i) + UNSIGNED_SHIFT] = sibling;
			}
			node = (Object[]) node[ktup.getByte(i) + UNSIGNED_SHIFT];
		}
		
		if (node[ktup.getByte(ktupLength - 1) + UNSIGNED_SHIFT] == null) {
			Leaf leaf = new Leaf(ktup.getByte(ktupLength - 1));
			node[ktup.getByte(ktupLength - 1) + UNSIGNED_SHIFT] = leaf;
			int[] counters = leaf.getCounters();
			counters[LAST_ALIGNABLE_ID_INDEX] = ktup.getAlignable().getId();
			counters[ALIGNABLES_COUNT_INDEX] = 1;
			counters[KTUP_OFFSETS_COUNT_INDEX] = 1;			
		} 
		else {
			Leaf leaf = (Leaf) node[ktup.getByte(ktupLength - 1) + UNSIGNED_SHIFT];
			int[] counters = leaf.getCounters();
			if (ktup.getAlignable().getId() != counters[LAST_ALIGNABLE_ID_INDEX]) {
				counters[LAST_ALIGNABLE_ID_INDEX] = ktup.getAlignable().getId();
				counters[ALIGNABLES_COUNT_INDEX]++;
			}
			counters[KTUP_OFFSETS_COUNT_INDEX]++;
		}
	}
	
	private void fillStats(Object[] node, int depth) {
		for (Object childNode : node) {
			if (childNode == null) {
				continue;
			}
			if (depth == ktupLength - 1) {
					Leaf leaf = (Leaf)childNode;
					leaf.fillStats();
			}
			else {
				fillStats((Object[])childNode, depth + 1);
			}
		}
	}
	
	public void fillStats() {
		for (Object node : table) {
			if (node == null) {
				continue;
			}
			fillStats((Object[])node, 1);
		}
	}
	
	protected void allocate(byte[] ktupBytes, int partitionStart, int partitionEnd) {
		allocate(table, 0, ktupBytes, partitionStart, partitionEnd);
	}
	
	private void allocate(Object[] node, int depth, byte[] ktupBytes, int partitionStart, int partitionEnd) {
		if (depth == ktupLength - 1) {
			for (int i = 0; i < arity; i++) {
				if (node[i] == null) {
					continue;
				}
				Leaf leaf = (Leaf)node[i];
				ktupBytes[ktupLength - 1] = leaf.getValue();
				int[] counters = leaf.getCounters();
				int[] offsets = new int[counters[ALIGNABLES_COUNT_INDEX]
						* 2 + counters[KTUP_OFFSETS_COUNT_INDEX]];
				counters[LAST_ALIGNABLE_ID_INDEX]= ALIGNABLE_ID_UNSET;
				leaf.setOffsets(offsets);
			}
			
		} else {
			for (int i = 0; i < arity; i++) {
				if (depth == 0) {
					if (!(i >= partitionStart && i <= partitionEnd)) {
						continue;
					}
				}
				if (node[i] != null) {
					allocate((Object[]) node[i], depth + 1, ktupBytes, partitionStart, partitionEnd);					
				}
			}
		}
	}
	
	protected int clean(int partitionStart, int partitionEnd) {
		return clean(table, 0, partitionStart, partitionEnd);
	}
		
	private int clean(Object[] node, int depth, int partitionStart, int partitionEnd) {
		if (depth == ktupLength - 1) {
			int size = 0;
			for (Object leaf : node) {
				if (leaf == null) {
					continue;
				}
				size += ((Leaf)leaf).getAlignablesCount();
			}
			return size;
		} 
		else {	
			int nodeSize = 0;
			for (int i = 0; i < arity; i++) {
				if (depth == 0) {
					if (!(i >= partitionStart && i <= partitionEnd)) {
						continue;
					}
				}
				if (node[i] == null) {
					continue;
				}
				Object[] sibling = (Object[])node[i];
				int siblingSize = clean(sibling, depth + 1, partitionStart, partitionEnd);
				if (siblingSize == 0) {
					node[i] = null;
				}
				nodeSize += siblingSize;
			}
			return nodeSize;
		}
	}

	
	@SuppressWarnings("unchecked")
	private void getCentroids(List<IKtupCentroid<T>> centroids, INKtupCentroidFilter<T> filter, Object[] node, int depth) {
		for (Object childNode : node) {
			if (childNode == null) {
				continue;
			}
			if (depth == ktupLength - 1) {
				if (filter == null || !filter.filter((Leaf)childNode)) {
					centroids.add((Leaf)childNode);
				}
			}
			else {
				getCentroids(centroids, filter, (Object[]) childNode, depth + 1);
			}
		}
	}

	@Override
	public CentroidIterator<T> getCentroids(
			INKtupCentroidFilter<T> filter) {
		List<IKtupCentroid<T>> centroids =  new ArrayList<IKtupCentroid<T>>();
		for (Object node : table) {
			if (node == null) {
				continue;
			}
			getCentroids(centroids, filter, (Object[])node, 1);
		}
		return new CentroidIterator<T>(centroids, filter);
	}
	
	@SuppressWarnings("unchecked")
	private int getCentroidsCount(Object[] node, int depth) {
		int count = 0;
		for (Object childNode : node) {
			if (childNode == null) {
				continue;
			}
			if (depth == ktupLength - 1) {
				count++;
			}
			else {
				count += getCentroidsCount((Object[])childNode, depth + 1);
			}
		}
		return count;
	}

	@Override
	public int getCentroidsCount() {
		int count = 0;
		for (Object node : table) {
			if (node == null) {
				continue;
			}
			count += getCentroidsCount((Object[])node, 1);
		}
		return count;
	}

}
