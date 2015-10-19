package com.falstaff.core.classification;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import com.falstaff.core.util.IdGenerator;

public class Samples {

	transient private long id;
	private FileFormat format;
	private List<String> paths;
	
	public Samples(FileFormat format, List<String> paths) {
		super();
		this.format = format;
		this.paths = paths;
		id = IdGenerator.getIdGenerator().getId(this.getClass().getName());
	}

	public FileFormat getFormat() {
		return format;
	}

	public void setFormat(FileFormat format) {
		this.format = format;
	}

	public List<String> getPaths() {
		return paths;
	}

	public void setPaths(List<String> paths) {
		this.paths = paths;
	}
	
	public List<File> getFiles() {
		List<File> files = new LinkedList<File>();
		for (String path : paths) {
			File file = new File(path);
			files.add(file);
		}
		return files;
	}
}
