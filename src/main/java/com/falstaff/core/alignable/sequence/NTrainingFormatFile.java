package com.falstaff.core.alignable.sequence;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class NTrainingFormatFile extends NFormatFile {

	private Map<String, String> formats;

	public NTrainingFormatFile() {
		super();
	}

	public NTrainingFormatFile(File file) {
		super(file);
		formats = new HashMap<String, String>();
	}
	
	public void addFormat(String formatType, String format) {
		formats.put(formatType, format);
	}

	public String getFormat(String formatType) {
		return formats.get(formatType);
	}

}
