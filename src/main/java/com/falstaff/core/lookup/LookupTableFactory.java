package com.falstaff.core.lookup;

import com.falstaff.core.lookup.ktup.IKtup;

public class LookupTableFactory<T extends IKtup> {
	
	public enum LookupType {
		MEMORY,
		TREE,
		TREE_COMPACT
	}

	public INLookupTable<T> getTable(LookupType lookupType, int ktupLength) {
		switch (lookupType) {
		case MEMORY:
			return new NLookupTableMemory<T>(ktupLength);
		case TREE:
			return new NNTreeLookupTable<T>(ktupLength);
		case TREE_COMPACT:
			return new NTreeCompactLookupTable<T>(ktupLength);
		default:
			return null;
		}
	
	}

}
