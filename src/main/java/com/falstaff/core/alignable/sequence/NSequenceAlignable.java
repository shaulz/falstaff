package com.falstaff.core.alignable.sequence;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.ByteArrayCharSequence;
import com.falstaff.core.alignable.INContinuousAlignable;
import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.alignable.INSequenceAlignable;
import com.falstaff.core.alignable.NAbstractAlignable;
import com.falstaff.core.geometry1D.BoundedSegmentedLine;
import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.lookup.filter.INKtupFilter;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.NArrayKtup;
import com.falstaff.core.lookup.ktup.NKtup;

public class NSequenceAlignable<T extends IKtup> extends NAbstractAlignable<T> implements INSequenceAlignable<T> {
	
	private static final Logger log = LoggerFactory
			.getLogger(NSequenceAlignable.class.getName());
	
	public static int HEADER_LENGTH = 0x10000;
	
	protected transient byte[] sequence;
	protected String encoding;

	public NSequenceAlignable(byte[] sequence) {
		super();
		this.sequence = sequence;
	}
	
	public NSequenceAlignable(File file) {
		setSequenceFromFile(file);
	}
	
	public void setSequenceFromFile(File file) {
		if (file == null) {
			sequence = null;
			return;
		}
		if (file.length() < 3) {
			throw new RuntimeException(
					"cowardly refusing to process files less than 3 bytes " + file.getAbsolutePath());
		}
		
		int headerLength = Math.min(HEADER_LENGTH, (int)file.length() / 2);

		sequence = new byte[headerLength * 2];

		try {
			FileInputStream fis = new FileInputStream(file);
			fis.read(sequence, 0, headerLength);

			long bytesToSkip = file.length() - headerLength * 2;
			if (bytesToSkip > 0) {
				fis.skip(bytesToSkip);
			}
			
			byte[] tmp = new byte[headerLength];
			fis.read(tmp, 0, headerLength);
			System.arraycopy(tmp, 0, sequence, headerLength, headerLength);
			fis.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(
					"failed to read alignable from file " + e);
		} catch (IOException e) {
			throw new RuntimeException(
					"failed to read alignable from file " + e);
		}		
	}

	public NSequenceAlignable() {
		super();
		this.sequence = null;
	}
	
	public T getKtup(int index, int length) {
		return (T) new NKtup<INSequenceAlignable>(index, length, this);
	}	

	public class SequenceAlignableKtupIterator<T extends IKtup> implements INKtupIterator<T> {
		// iterator index points to the full sequence
		private int index;
		private int maxIndex;
		private final int length;
		BoundedSegmentedLine complementMask;
		ListIterator<Segment> complementIterator;
		Segment complementSegment = null;
		private INKtupFilter<T> filter;

		public SequenceAlignableKtupIterator(int length, INKtupFilter<T> filter) {
			this(length,0,sequence.length - 1, filter);
		}
		
		public SequenceAlignableKtupIterator(int length, int alignableStart, int alignableEnd, INKtupFilter<T> filter) {
			this.length = length;
			this.filter = filter;
			index = alignableStart;
			maxIndex = Math.min(sequence.length - length, alignableEnd - length + 1);
			if (mask != null) {
				complementMask = mask.complement();
			} else {
				complementMask = new BoundedSegmentedLine(0, sequence.length);
				complementMask.addSegment(new Segment(0,sequence.length));
			}
			complementIterator = complementMask.getSegments().listIterator();
			while (complementIterator.hasNext()) {
				complementSegment = complementIterator.next();				
				if (alignableStart <= complementSegment.getStart()) {
					index = complementSegment.getStart();
					break;
				}
				if (alignableStart <= complementSegment.getEnd() - length + 1) {
					break;
				}
			}
		}

		private SequenceAlignableKtupIterator(int index, int length,
				BoundedSegmentedLine complementMask,
				ListIterator<Segment> complementIterator,
				Segment complementSegment, int maxIndex, INKtupFilter<T> filter) {
			super();
			this.index = index;
			this.length = length;
			this.complementMask = complementMask;
			int segmentIndex = complementIterator.nextIndex();
			this.complementIterator = complementMask.getSegments().listIterator(segmentIndex);
			this.complementSegment = complementSegment;
			this.maxIndex = maxIndex;
			this.filter = filter;
		}

		public boolean hasNext() {
			if (index > maxIndex)
				return false;
			if (hasNextInSegment()) {
				return true;
			}
			while (complementIterator.hasNext()) {
				complementSegment = complementIterator.next();
				index = complementSegment.getStart();
				if (hasNextInSegment()) {
					return true;
				}
			}
			return false;
		}

		private boolean hasNextInSegment() {
			while (complementSegment != null
					&& index <= complementSegment.getEnd() - length + 1) {
				if (filter != null && filter.filter(sequence[index])) {
					index++;
					continue;
				}
				if (filter != null) {
					T ktup = (T)getKtup(index, length);
					if (!filter.filter(ktup)) {
						return true;
					}
				}
				else {
					return true;
				}
				index++;
			}
			return false;
		}
		
		public T next() {
			T ktup = (T)getKtup(index, length);
			index++;
			return ktup;
		}

		@Override
		public void remove() {
		}

		@Override
		public INKtupIterator<T> copy() {
			return new SequenceAlignableKtupIterator<>(index, length, complementMask, complementIterator, complementSegment, maxIndex, filter);
		}

		public INKtupFilter<T> getFilter() {
			return filter;
		}

		public void setFilter(INKtupFilter<T> filter) {
			this.filter = filter;
		}
		
	}
	
	@Override
	public INKtupIterator<T> ktupIterator(int ktupLength) {
		return ktupIterator(ktupLength, null);
	}

	@Override
	public INKtupIterator<T> ktupIterator(int ktupLength, INKtupFilter<T> filter) {
		return new SequenceAlignableKtupIterator<T>(ktupLength, filter);
	}
	
	@Override
	public int length() {
		return sequence.length;
	}

	@Override
	public Byte getByte(int index) {
		return sequence[index];
	}

	public void setSequence(byte[] sequence) {
		this.sequence = sequence;
	}

	public ByteArrayCharSequence charSequence() {
		return new ByteArrayCharSequence(sequence);
	}

	public byte[] getSequence() {
		return sequence;
	}

	@Override
	public ByteArrayCharSequence charSequence(Segment segment) {
		return new ByteArrayCharSequence(sequence, segment);
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public boolean isText() {
		return (encoding != null);
	}
}
