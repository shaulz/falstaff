package com.falstaff.core.ontology;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public enum FileFormatOntologyFirstGroup {
	electronic_file_formats("Electronic File Formats"),
	languages("Languages");
	
	private String name;

	private FileFormatOntologyFirstGroup(String name) {
		this.name = name;
	}

	private static final Map<String, FileFormatOntologyFirstGroup> map;
	static {
		map = new HashMap<String, FileFormatOntologyFirstGroup>();
		for (FileFormatOntologyFirstGroup v : FileFormatOntologyFirstGroup
				.values()) {
			map.put(v.name, v);
		}
	}
	
	public static FileFormatOntologyFirstGroup findByName(String name) {
	    return map.get(name);
	}
	
	public static List<String> getNames() {
		List<String> names = new LinkedList<String>();
		for (FileFormatOntologyFirstGroup v : FileFormatOntologyFirstGroup
				.values()) {
			names.add(v.name);
		}
		return names;
	}

	public String getName() {
		return name;
	}
}
