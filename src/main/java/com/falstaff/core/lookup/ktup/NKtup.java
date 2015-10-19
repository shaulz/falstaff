package com.falstaff.core.lookup.ktup;

import java.util.Comparator;

import com.falstaff.core.alignable.INContinuousAlignable;

public class NKtup<T extends INContinuousAlignable> implements IKtup<T> {
	
	protected int offset;
	protected int length;
	protected T alignable;
	protected long value;
	protected int hashValue;
	
	public static class NKtupComparator implements Comparator<NKtup> {

		@Override
		public int compare(NKtup k1, NKtup k2) {
			long diff = k1.getValue() - k2.getValue();
			if (diff == 0) {
				return 0;
			}
			return (k1.getValue() - k2.getValue() < 0 ? -1 : 1);
		}		
	}
	
	public NKtup(NKtup<T> ktup) {
		this.offset = ktup.getOffset();
		this.length = ktup.getLength();
		this.alignable = ktup.getAlignable();
		this.value = ktup.getValue();
		this.hashValue = ktup.hashCode();
	}
	
	
	public NKtup(int offset, int length, T alignable) {
		super();
		this.offset = offset;
		this.length = length;
		this.alignable = alignable;
		computeValue();
		computeHashValue();
	}
	
	/* (non-Javadoc)
	 * @see com.falstaff.core.lookup.ktup.IKtup#set(int, int)
	 */
	@Override
	public void set(int offset, int length) {
		this.offset = offset;
		this.length = length;
		computeValue();
		computeHashValue();		
	}
	
	/* (non-Javadoc)
	 * @see com.falstaff.core.lookup.ktup.IKtup#shift(int)
	 */
	@Override
	public void shift(int offset) {
		if (this.offset + 1 != offset) {
			set(offset, length);
			return;
		}
		this.offset = offset;
		shiftValue();
		computeHashValue();
	}
	
	private void computeValue() {
		value = 0;
		for (int i = length - 1; i >= 0; i--) {
			value = 0x100l * value + (long)(alignable.getByte(offset + i) & 0xFF);
		}
	}
	
	private void shiftValue() {
		value = (value >> 8) | (((long)(alignable.getByte(offset + length - 1) & 0xFF)) << ((length - 1) << 3));
	}
	
	private void computeHashValue() {
	    hashValue = 0;
	    for (int i = 0; i < length ; i++) {
	        hashValue = 31 * hashValue + (int)(alignable.getByte(offset + i) & 0xFF);
	    }
	}

	public NKtup(int offset, int length) {
		super();
		this.offset = offset;
		this.length = length;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.lookup.ktup.IKtup#getAlignable()
	 */
	@Override
	public T getAlignable() {
		return alignable;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.lookup.ktup.IKtup#getOffset()
	 */
	@Override
	public int getOffset() {
		return offset;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.lookup.ktup.IKtup#getLength()
	 */
	@Override
	public int getLength() {
		return length;
	}
	
	/* (non-Javadoc)
	 * @see com.falstaff.core.lookup.ktup.IKtup#getByte(int)
	 */
	@Override
	public Byte getByte(int i) {
		//return alignable.byteAt(offset + i);
		return (byte)((value << ((7 - i) << 3) ) >> (7 << 3)); 
	}

	public long getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		return value == ((NKtup)obj).getValue();
	}
	
	@Override
	public String toString() {
		return alignable.getHex(offset,offset + length - 1);
	}
	
	@Override
	public String getChars() {
		return alignable.getChars(offset,offset + length - 1);
	}


	@Override
	public int hashCode() {
		return hashValue;
	}
}
