package com.falstaff.core.lookup.ktup;

import com.falstaff.core.alignable.INLookupAlignable;

public interface IKtup<T extends INLookupAlignable>  {
	public void set(int offset, int length);
	public void shift(int offset);
	public T getAlignable();
	public int getOffset();
	public int getLength();
	public Byte getByte(int i);
	public String getChars();
}