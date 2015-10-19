package com.falstaff.core.alignable;

import java.util.ListIterator;

import com.falstaff.core.geometry1D.BoundedSegmentedLine;
import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.score.Alphabet;
import com.falstaff.core.score.IScoreCalculator;
import com.falstaff.core.util.IdGenerator;

public abstract class NAbstractAlignable<T extends IKtup> implements INContinuousAlignable<T> {
	
	protected transient int id;
	protected transient BoundedSegmentedLine mask = null;


	public NAbstractAlignable() {
		setId();
	}	

	public int getId() {
		return id;
	}

	public void setId() {
		id = IdGenerator.getIdGenerator().getId(this.getClass().getName());
	}

	public class ByteIteratorImpl implements ListIterator<Byte> {
		int index;

		public ByteIteratorImpl() {
			index = -1;
		}

		@Override
		public boolean hasNext() {
			return index < length() - 1;
		}

		@Override
		public Byte next() {
			index++;
			return getByte(index);
		}

		@Override
		public boolean hasPrevious() {
			return index > 0;
		}

		@Override
		public Byte previous() {
			index--;
			return getByte(index);
		}

		@Override
		public int nextIndex() {
			return index + 1;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void remove() {
		}

		@Override
		public void set(Byte e) {
		}

		@Override
		public void add(Byte e) {
		}
	}

	public ListIterator<Byte> byteIterator() {
		return new ByteIteratorImpl();
	}

	// masking
	
	public void mask(Segment segment) {
		if (mask == null) {
			initMask();
		}
		mask.addSegment(segment);
	}

	public BoundedSegmentedLine getMask() {
		return mask;
	}

	public void initMask() {
		mask = new BoundedSegmentedLine(0, length());
	}
	
	// pretty printing
	
	public String getHex() {
		return getHex(0,length() - 1);
	}

	public String getHex(int start, int end) {
		final StringBuilder hex = new StringBuilder(2 * (end - start + 1));
		for (int i = start ; i <= end ; i++) {
			Byte b = getByte(i);
			if (b != null) {
				hex.append(Alphabet.byte2hex(b));
			}
			else {
				hex.append(Alphabet.UNDEFINED_HEX);
			}
		}
		return hex.toString();
	}
		
	public String getChars() {
		return getChars(0,length() - 1);		
	}
	
	public String getChars(int start, int end) {
		final StringBuilder chars = new StringBuilder(2 * (end - start + 1));
		for (int i = start ; i <= end ; i++) {
			Byte b = getByte(i);
			if (b != null) {
				chars.append(Alphabet.byte2chars(b));
			}
			else {
				chars.append(Alphabet.UNDEFINED_CHARS);
			}
		}
		return chars.toString();
	}	
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder(2 * length() + 1);
		string.append(getHex());
		String charString = getChars();
		if (charString != null) 
			string.append(" ").append(charString);
		return string.toString();
	}

	public String toString(Segment segment) {
		StringBuilder string = new StringBuilder(2 * length() + 1);
		string.append(getHex(segment.getStart(),segment.getEnd()));
		String charString = getChars(segment.getStart(),segment.getEnd());
		if (charString != null) 
			string.append(" ").append(charString);
		return string.toString();
	}

}
