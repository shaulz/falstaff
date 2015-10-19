package com.falstaff.core.lookup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.centroid.CentroidIterator;
import com.falstaff.core.lookup.ktup.centroid.IKtupCentroid;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;

public class NTreeCompactLookupTable<T extends IKtup> extends NTreeAbstractLookupTable<T> implements INLookupTable<T> {
	
	private static final Logger log = LoggerFactory
			.getLogger(NTreeCompactLookupTable.class.getName());
	
	private ArrayList<Node> table;
	private NodePool nodePool;
	
	public NTreeCompactLookupTable(int ktupLength) {
		super(ktupLength);
		table = new ArrayList();
		nodePool = new NodePool();
	}
	
	public void clear() {
		super.clear();
		table = new ArrayList();
	}
	
	private class NodePool {
		private Map<Byte,Node> pool;

		public NodePool() {
			pool = new HashMap<Byte,Node>();
			for (int i = 0; i <= Byte.MAX_VALUE - Byte.MIN_VALUE; i++) {
				byte b = (byte)i;
				pool.put(b, new Node(b));
			}
		}
		
		public Node getNode(byte b) {
			return pool.get(b);
		}
	}

	private class Node {
		byte value;
		ArrayList children;

		public Node(byte value) {
			this.value = value;
			children = new ArrayList();
		}

		public byte getValue() {
			return value;
		}

		public ArrayList getChildren() {
			return children;
		}
		
		public void setChildren(ArrayList children) {
			this.children = children;
		}
	}

	Comparator<Node> nodeComparator = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
			return (new Byte(n1.getValue()).compareTo(new Byte(n2.getValue())));
		}
	};

	
	protected Leaf getLeaf(T ktup) {
		ArrayList node = table;
		for (int i = 0; i < ktupLength - 1; i++) {
			Node sibling = nodePool.getNode(ktup.getByte(i));
			int position = Collections.binarySearch(node, sibling,
					nodeComparator);
			if (position < 0) {
				return null;
			}
			sibling = (Node) node.get(position);
			node = sibling.getChildren();
		}
		if (node == null)
			return null;
		Leaf leaf = new Leaf(ktup.getByte(ktupLength - 1));

		int position = Collections.binarySearch(node, leaf, leafComparator);
		if (position < 0)
			return null;
		leaf = (Leaf) node.get(position);
		return leaf;
	}	

	
	private void remove(INKtupCentroidFilter<T> centroidFillFilter, Node node, int depth) {
		if (depth == ktupLength - 1) {
			ArrayList leafs = new ArrayList();
			for (Object leafNode : node.getChildren()) {
				if (!centroidFillFilter.filter((Leaf)leafNode)) {
					leafs.add(leafNode);
				}
			}
			node.setChildren(leafs);
		}
		else {
			for (Object childNode : node.getChildren()) {
				remove(centroidFillFilter, (Node)childNode, depth + 1);
			}
		}
	}
	
	protected void remove(INKtupCentroidFilter<T> centroidFillFilter, int partitionStart, int partitionEnd) {
		if (centroidFillFilter == null) {
			return;
		}
		for (Node node : table) {
			byte value = node.getValue();
			if (!(value + UNSIGNED_SHIFT >= partitionStart && value + UNSIGNED_SHIFT <= partitionEnd)) {
				continue;
			}
			remove(centroidFillFilter, node, 1);
		}
	}
	
	public void filter(int partitionStart, int partitionEnd,
			INKtupCentroidFilter<T> centroidFillFilter) {
		for (Node node : table) {
			byte value = node.getValue();
			if (!(value + UNSIGNED_SHIFT >= partitionStart && value
					+ UNSIGNED_SHIFT <= partitionEnd)) {
				continue;
			}
			remove(centroidFillFilter, node, 1);
		}
	}
	
	protected void countEntry(T ktup) {
		ArrayList node = table;
		for (int i = 0; i < ktupLength - 1; i++) {
			Node sibling = nodePool.getNode(ktup.getByte(i));
			int position = Collections.binarySearch(node, sibling,
					nodeComparator);
			if (position < 0) {
				position = -(position + 1);
				sibling = new Node(ktup.getByte(i));
				node.add(position, sibling);
			} else {
				sibling = (Node) node.get(position);
			}

			node = sibling.getChildren();
		}

		Leaf leaf = new Leaf(ktup.getByte(ktupLength - 1));

		int position = Collections.binarySearch(node, leaf, leafComparator);
		if (position < 0) {
			position = -(position + 1);
			node.add(position, leaf);
			int[] counters = leaf.getCounters();
			counters[LAST_ALIGNABLE_ID_INDEX] = ktup.getAlignable().getId();
			counters[ALIGNABLES_COUNT_INDEX] = 1;
			counters[KTUP_OFFSETS_COUNT_INDEX] = 1;
		} else {
			leaf = (Leaf) node.get(position);
			int[] counters = leaf.getCounters();
			if (ktup.getAlignable().getId() != counters[LAST_ALIGNABLE_ID_INDEX]) {
				counters[LAST_ALIGNABLE_ID_INDEX] = ktup.getAlignable().getId();
				counters[ALIGNABLES_COUNT_INDEX]++;
			}
			counters[KTUP_OFFSETS_COUNT_INDEX]++;
		}
	}
	
	private void fillStats(Node node, int depth) {
		for (Object childNode : node.getChildren()) {
			if (depth == ktupLength - 1) {
					Leaf leaf = (Leaf)childNode;
					leaf.fillStats();
			}
			else {
				fillStats((Node)childNode, depth + 1);
			}
		}
	}
	
	public void fillStats() {
		for (Node node : table) {
			fillStats(node, 1);
		}
	}
	
	private void allocate(ArrayList node, int depth, byte[] ktupBytes, int partitionStart, int partitionEnd) {
		if (depth == ktupLength - 1) {
			for (ListIterator iter = node.listIterator(node.size()); iter
					.hasPrevious();) {
				Leaf leaf = (Leaf) iter.previous();
				ktupBytes[ktupLength - 1] = leaf.getValue();
				int[] counters = leaf.getCounters();
				int[] offsets = new int[counters[ALIGNABLES_COUNT_INDEX]
						* 2 + counters[KTUP_OFFSETS_COUNT_INDEX]];
				counters[LAST_ALIGNABLE_ID_INDEX]= ALIGNABLE_ID_UNSET;
				leaf.setOffsets(offsets);
			}
		} else {
			for (int i = 0; i < node.size(); i++) {
				Node sibling = (Node) node.get(i);
				if (depth == 0) {
					byte value = sibling.getValue();
					if (!(value + UNSIGNED_SHIFT >= partitionStart && value + UNSIGNED_SHIFT <= partitionEnd)) {
						continue;
					}
				}
				ktupBytes[depth] = sibling.getValue();
				allocate(sibling.getChildren(), depth + 1, ktupBytes, partitionStart,partitionEnd);
			}
		}
	}
		
	private int clean(ArrayList node, int depth, int partitionStart, int partitionEnd) {
		if (depth == ktupLength - 1) {
			int size = 0;
			for (Object leaf : node) {
				size += ((Leaf)leaf).getAlignablesCount();
			}
			return size;
		} 
		else {			
			for (ListIterator iter = node.listIterator(node.size()); iter.hasPrevious();) {
				Node sibling = (Node) iter.previous();
				if (depth == 0) {
					byte value = sibling.getValue();
					if (!(value + UNSIGNED_SHIFT >= partitionStart && value + UNSIGNED_SHIFT <= partitionEnd)) {
						continue;
					}
				}
				int size = clean(sibling.getChildren(), depth + 1, partitionStart,partitionEnd);
				if (size == 0) {
					iter.remove();
					//log.debug("node at depth " + depth + " has been removed");
				}
			}
			return node.size();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void getCentroids(List<IKtupCentroid<T>> centroids, INKtupCentroidFilter<T> filter, Node node, int depth) {
		for (Object childNode : node.getChildren()) {
			if (depth == ktupLength - 1) {
				if (filter == null || !filter.filter((Leaf)childNode)) {
					centroids.add((Leaf)childNode);
				}
			}
			else {
				getCentroids(centroids, filter, (Node)childNode, depth + 1);
			}
		}
	}

	@Override
	public CentroidIterator<T> getCentroids(
			INKtupCentroidFilter<T> filter) {
		List<IKtupCentroid<T>> centroids =  new ArrayList<IKtupCentroid<T>>();
		for (Node node : table) {
			getCentroids(centroids, filter, node, 1);
		}
		return new CentroidIterator<T>(centroids, filter);
	}
	
	@SuppressWarnings("unchecked")
	private int getCentroidsCount(Node node, int depth) {
		int count = 0;
		for (Object childNode : node.getChildren()) {
			if (depth == ktupLength - 1) {
				count++;
			}
			else {
				count += getCentroidsCount((Node)childNode, depth + 1);
			}
		}
		return count;
	}

	@Override
	public int getCentroidsCount() {
		int count = 0;
		for (Node node : table) {
			count += getCentroidsCount(node, 1);
		}
		return count;
	}

	@Override
	protected void allocate(byte[] ktupBytes, int partitionStart,
			int partitionEnd) {
		allocate (table, 0, ktupBytes, partitionStart, partitionEnd);
		
	}

	@Override
	protected int clean(int partitionStart, int partitionEnd) {
		return clean(table, 0, partitionStart, partitionEnd);
	}

}
