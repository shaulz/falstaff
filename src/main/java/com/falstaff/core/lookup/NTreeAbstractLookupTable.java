package com.falstaff.core.lookup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INContinuousAlignable;
import com.falstaff.core.alignable.INLookupAlignable;
import com.falstaff.core.lookup.filter.INKtupFilter;
import com.falstaff.core.lookup.filter.KtupFirstByteBoundsFilter;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.centroid.IKtupCentroid;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;

public abstract class NTreeAbstractLookupTable<T extends IKtup> extends NAbstractLookupTable<T> implements INLookupTable<T> {

	private static final Logger log = LoggerFactory
			.getLogger(NTreeAbstractLookupTable.class.getName());
	
	protected static final int arity = 256;
	protected static int tablePartitions = 10;
	protected static final int LAST_ALIGNABLE_ID_INDEX = 0;
	protected static final int ALIGNABLES_COUNT_INDEX = 1;
	protected static final int KTUP_OFFSETS_COUNT_INDEX = 2;
	protected static int ALIGNABLE_ID_UNSET = -1;
	protected static int UNSIGNED_SHIFT = -Byte.MIN_VALUE;
	
	protected HashMap<Integer, INLookupAlignable<T>> alignablesAll;
	
	public NTreeAbstractLookupTable(int ktupLength) {
		super(ktupLength);
		alignablesAll = new HashMap<Integer, INLookupAlignable<T>>();
	}
	
	protected Comparator<Leaf> leafComparator = new Comparator<Leaf>() {
		@Override
		public int compare(Leaf l1, Leaf l2) {
			return (new Byte(l1.getValue()).compareTo(new Byte(l2.getValue())));
		}
	};
	
	protected class Leaf implements IKtupCentroid<T> {
		byte value;
		int[] counters;
		int[] offsets;

		public Leaf(byte value) {
			this.value = value;
			counters = new int[3];
		}

		public byte getValue() {
			return value;
		}

		public int[] getCounters() {
			return counters;
		}

		public int[] getOffsets() {
			return offsets;
		}

		public void setOffsets(int[] offsets) {
			this.offsets = offsets;
		}

		@Override
		public List<T> getKtups() {
			ArrayList<T> ktups = new ArrayList<T>();
			int lastAlignableIdIndex = counters[LAST_ALIGNABLE_ID_INDEX];
			int lastAlignableId = offsets[lastAlignableIdIndex];
			int alignableIdIndex = 0;

			while (true) {
				int alignableId = offsets[alignableIdIndex];
				INLookupAlignable<T> alignable = alignablesAll.get(alignableId);
				int ktupCountIndex = alignableIdIndex + 1;
				int ktupsCount = offsets[ktupCountIndex];
				int ktupIndex = ktupCountIndex + 1;
				for (int i = 0; i < ktupsCount; i++) {
					int ktupOffset = offsets[ktupIndex + i];
					T ktup = alignable.getKtup(ktupOffset, ktupLength);
					ktups.add(ktup);
				}
				if (alignableId == lastAlignableId)
					break;
				alignableIdIndex = ktupIndex + ktupsCount;
			}
			return ktups;
		}

		@Override
		public int getKtupsCount() {
			return counters[KTUP_OFFSETS_COUNT_INDEX];
		}

		@Override
		public int getAlignablesCount() {
			return counters[ALIGNABLES_COUNT_INDEX];
		}
		
		protected void remove(Map<Integer,List<Integer>> alignables) {
			int lastAlignableIdIndex = counters[LAST_ALIGNABLE_ID_INDEX];
			int lastAlignableId = offsets[lastAlignableIdIndex];
			int alignableIdIndex = 0;
			int currentOffset = 0;
			int alignablesAfterRemove = 0;
			int ktupsAfterRemove = 0;
			int lastAlignableIdIndexAfterRemove = 0;
			// replace removed offsets with -1
			while (true) {
				int alignableId = offsets[alignableIdIndex];
				int ktupCountIndex = alignableIdIndex + 1;
				int alignableKtupsCount = offsets[ktupCountIndex];
				int ktupIndex = ktupCountIndex + 1;
				int ktupIndexSearch = ktupIndex;
				List<Integer> offsetsToRemove = alignables.get(alignableId);
				int alignableRemovedKtupsCount = 0;
				if (offsetsToRemove != null) {
					for (int offsetToRemove : offsetsToRemove) {
						while(ktupIndexSearch < ktupIndex + alignableKtupsCount && offsets[ktupIndexSearch] < offsetToRemove) {
							ktupIndexSearch++;
						}
						if (ktupIndexSearch == ktupIndex + alignableKtupsCount) {
							break;
						}
						if (offsets[ktupIndexSearch] == offsetToRemove) {
							offsets[ktupIndexSearch] = -1;
							alignableRemovedKtupsCount++;
							ktupIndexSearch++;
						}
					}
				}
				// remove alignable if all alignable ktups were removed
				if (alignableRemovedKtupsCount == alignableKtupsCount) {
					offsets[alignableIdIndex] = -1;
					offsets[ktupCountIndex] = -1;
				}
				else {
					alignablesAfterRemove++;
					offsets[ktupCountIndex] = offsets[ktupCountIndex] - alignableRemovedKtupsCount;
					// copy not removed offsets
					lastAlignableIdIndexAfterRemove = currentOffset;
					offsets[currentOffset++] = offsets[alignableIdIndex];					
					offsets[currentOffset++] = offsets[ktupCountIndex];
					for (int i = 0; i < alignableKtupsCount; i++) {
						int ktupOffset = offsets[ktupIndex + i];
						if (ktupOffset != -1) {
							offsets[currentOffset++] = ktupOffset;
							ktupsAfterRemove++;
						}
					}
				}
				if (alignableId == lastAlignableId)
					break;
				alignableIdIndex = ktupIndex + alignableKtupsCount;
			}
			counters[LAST_ALIGNABLE_ID_INDEX] = lastAlignableIdIndexAfterRemove;
			counters[KTUP_OFFSETS_COUNT_INDEX] = ktupsAfterRemove;
			counters[ALIGNABLES_COUNT_INDEX] = alignablesAfterRemove;
		}
		
		public void fillStats() {
			int lastAlignableIdIndex = counters[LAST_ALIGNABLE_ID_INDEX];
			int lastAlignableId = offsets[lastAlignableIdIndex];
			int alignableIdIndex = 0;

			while (true) {
				int alignableId = offsets[alignableIdIndex];
				int ktupCountIndex = alignableIdIndex + 1;
				int alignableKtupsCount = offsets[ktupCountIndex];
				stats.getAlignableKtupsInCentroidCounts().increment(alignableKtupsCount);
				int ktupIndex = ktupCountIndex + 1;
				if (alignableId == lastAlignableId)
					break;
				alignableIdIndex = ktupIndex + alignableKtupsCount;
			}
			stats.getAlignablesInCentroidCounts().increment(getAlignablesCount());
			stats.getKtupsInCentroidCounts().increment(getKtupsCount());
			stats.setCentroidsCount(stats.getCentroidsCount() + 1);
			stats.setKtupsCount(stats.getKtupsCount() + getKtupsCount());
		}
	}
	
	protected abstract Leaf getLeaf(T ktup);
	protected abstract void countEntry(T ktup);
	protected abstract void remove(INKtupCentroidFilter<T> centroidFillFilter, int partitionStart, int partitionEnd);
	protected abstract void allocate(byte[] ktupBytes, int partitionStart, int partitionEnd);
	protected abstract int clean(int partitionStart, int partitionEnd);
	
	@Override
	public boolean add(T ktup) {
		Leaf leaf = getLeaf(ktup);
		if (leaf == null) {
			return false;
		}
		int[] counters = leaf.getCounters();
		int[] offsets = leaf.getOffsets();
		int lastIdIndex = counters[LAST_ALIGNABLE_ID_INDEX];
		if (lastIdIndex == ALIGNABLE_ID_UNSET) {
			counters[LAST_ALIGNABLE_ID_INDEX] = 0;
			offsets[0] = ktup.getAlignable().getId();
			offsets[1] = 0;
			lastIdIndex = counters[LAST_ALIGNABLE_ID_INDEX];
		}
		int lastId = offsets[lastIdIndex];
		// lastIdIndex, ktups count, ktup offset1, ktup offset2,...
		if (lastId == ktup.getAlignable().getId()) {
			// 1 333 0 ; 1 333 1 ;
			offsets[lastIdIndex + 1] = offsets[lastIdIndex + 1] + 1;
			int offsetIndex = lastIdIndex + offsets[lastIdIndex + 1] + 1;
			offsets[offsetIndex] = ktup.getOffset();
		} else {
			lastIdIndex = lastIdIndex + 1 + offsets[lastIdIndex + 1] + 1;
			counters[LAST_ALIGNABLE_ID_INDEX] = lastIdIndex;
			offsets[lastIdIndex] = ktup.getAlignable().getId();
			offsets[lastIdIndex + 1] = 1;
			int offsetIndex = lastIdIndex + 1 + 1;
			offsets[offsetIndex] = ktup.getOffset();
		}
		return true;		
	}
	
	@Override
	public void add(INKtupIterator<? extends T> iterator) {
		boolean alignableRegistered = false;
		while (iterator.hasNext()) {
			T ktup = iterator.next();
			boolean ktupFilled = add(ktup);
			if (!alignableRegistered && ktupFilled) {
				INLookupAlignable alignable = ktup.getAlignable();
				alignablesAll.put(alignable.getId(), alignable);
				alignableRegistered = true;
			}
		}		
	}
	
	@Override
	public void add(Collection<INKtupIterator<? extends T>> iterators, INKtupCentroidFilter<T> postFillFilter) {
		byte ktupBytes[] = new byte[ktupLength];
		for (int partitionIndex = 0; partitionIndex < tablePartitions; partitionIndex++) {
			int partitionStart = getPartitionStart(partitionIndex);
			int partitionEnd = getPartitionEnd(partitionIndex);
			KtupFirstByteBoundsFilter filter = new KtupFirstByteBoundsFilter(partitionStart, partitionEnd);
			for (INKtupIterator<? extends T> iterator : iterators) {
				INKtupIterator<? extends T> iteratorCopy = iterator.copy();
				INKtupFilter<? extends T> iteratorFilter = iterator.getFilter();
				filter.setNextFilter(iteratorFilter);
				iteratorCopy.setFilter(filter);
				count(iteratorCopy,partitionStart,partitionEnd);
				filter.clear();
			}
			log.debug("lookup table partition from " + partitionStart + " to " + partitionEnd + " has been counted");
			allocate(ktupBytes,partitionStart,partitionEnd);
			log.debug("lookup table partition from " + partitionStart + " to " + partitionEnd + " has been allocated");
			for (INKtupIterator<? extends T> iterator : iterators) {
				INKtupIterator<? extends T> iteratorCopy = iterator.copy();
				INKtupFilter<? extends T> iteratorFilter = iterator.getFilter();
				filter.setNextFilter(iteratorFilter);
				iteratorCopy.setFilter(filter);
				add(iteratorCopy);
				filter.clear();
			}
			log.debug("lookup table partition from " + partitionStart + " to " + partitionEnd + " has been filled");
			remove(postFillFilter, partitionStart,partitionEnd);
			log.debug("lookup table partition from " + partitionStart + " to " + partitionEnd + " has been filtered");
			clean(partitionStart,partitionEnd);
			log.debug("lookup table partition from " + partitionStart + " to " + partitionEnd + " has been added");
		}

		if (log.isDebugEnabled()) {
			fillStats();
			log.debug(stats.toString());
		}
	}
	
	@Override
	public IKtupCentroid<T> getCentroid(T ktup, INKtupCentroidFilter<T> filter) {
		return getLeaf(ktup);
	}
	
	public void remove(INKtupCentroidFilter<T> centroidFillFilter) {
		if (centroidFillFilter == null) {
			return;
		}
		remove(centroidFillFilter, 0, 255);
	}
	
	@Override
	public void remove(Collection<INKtupIterator<? extends T>> iterators,
			INKtupCentroidFilter<T> postFillFilter) {
		
		// construct a map ktup -> alignable id -> offsets
		Map<T,Map<Integer,List<Integer>>> ktups = new HashMap<T,Map<Integer,List<Integer>>>();
		for (Iterator<? extends T> iterator : iterators) {
			while (iterator.hasNext()) {
				T ktup = iterator.next();
				int alignableId = ktup.getAlignable().getId();
				if (!ktups.containsKey(ktup)) {
					ktups.put(ktup,  new HashMap<Integer,List<Integer>>());
				}
				Map<Integer,List<Integer>> alignables = ktups.get(ktup);
				if (!alignables.containsKey(alignableId)) {
					alignables.put(alignableId, new ArrayList<Integer>());
				}
				List<Integer> offsets = alignables.get(alignableId);
				int offset = ktup.getOffset();
				offsets.add(offset);
			}
		}
		
		// sort offsets
		for (T ktup : ktups.keySet()) {
			Map<Integer,List<Integer>> alignables = ktups.get(ktup);
			for (int alignableId : alignables.keySet()) {
				List<Integer> offsets = alignables.get(alignableId);
				Collections.sort(offsets);
			}
		}
		
		// remove
		for (T ktup : ktups.keySet()) {
			Leaf leaf = getLeaf(ktup);
			if (leaf != null) {
				leaf.remove(ktups.get(ktup));
			}
		}
		
		remove(postFillFilter);
	}
	
	protected void count(Iterator<? extends T> iterator, int partitionStart, int partitionEnd) {
		while (iterator.hasNext()) {
			T ktup = iterator.next();
			Byte b = ktup.getByte(0);
			int bValue = b + UNSIGNED_SHIFT;
			if (bValue >= partitionStart && bValue <= partitionEnd)
				countEntry(ktup);
		}
	}
	
	private double getPartitionSize() {
		double size = (double) arity / (double) tablePartitions;
		return size;
	}

	// index starts from 0
	private int getPartitionStart(int partitionIndex) {
		return new Double(((double) partitionIndex) * getPartitionSize())
				.intValue();
	}

	private int getPartitionEnd(int partitionIndex) {
		if (partitionIndex == tablePartitions - 1) {
			return arity - 1;
		}
		return getPartitionStart(partitionIndex + 1) - 1;
	}

	public void clear() {
		super.clear();
		alignablesAll = new HashMap<Integer, INLookupAlignable<T>>();
	}
}
