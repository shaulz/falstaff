package com.falstaff.core.lookup.ktup;

import com.falstaff.core.alignable.INLookupAlignable;
import com.falstaff.core.score.Alphabet;

public class NArrayKtup<T extends INLookupAlignable> implements IKtup<T> {
	
	protected int offset;
	protected int length;
	protected T alignable;
	protected byte value[];
	protected int[] array;
	protected int hashValue;	
	
	public NArrayKtup(int offset, int length, T alignable, int array[]) {
		super();
		this.offset = offset;
		this.length = length;
		this.alignable = alignable;
		this.array = array;
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
		set(offset, length);
	}
	
	private void computeValue() {
		value = new byte[length];
		for (int i = 0; i < length; i++) {
			value[i] = (byte)array[offset + i];
		}
	}
	
	
	private void computeHashValue() {
	    hashValue = 0;
	    for (int i = 0; i < length ; i++) {
	        hashValue = 31 * hashValue + (int)(value[i] & 0xFF);
	    }
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
		return value[i]; 
	}

	public byte[] getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		return value.equals(((NArrayKtup)obj).getValue());
	}
	
	@Override
	public String toString() {
		final StringBuilder hex = new StringBuilder(2 * length);
		for (int i = 0 ; i < length ; i++) {
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


	@Override
	public String getChars() {
		final StringBuilder chars = new StringBuilder(2 * length);
		for (int i = 0 ; i < length ; i++) {
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

}