package com.falstaff.core.classification;

import java.util.List;

import com.falstaff.core.maxent.Datum;

public interface IDatumSource {
	List<Datum> getDatum(int simulatedFeaturesNumber);
}
