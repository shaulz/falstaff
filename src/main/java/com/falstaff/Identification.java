package com.falstaff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="identification")
@XmlType(propOrder = { "file", "formatName", "formatURL"})
public class Identification {

	private String file;
	private String formatName;
	private String formatURL;

	@XmlElement
	public String getFormatName() {
		return formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	@XmlElement
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@XmlElement
	public String getFormatURL() {
		return formatURL;
	}

	public void setFormatURL(String formatURL) {
		this.formatURL = formatURL;
	}

	public Identification(String file, String formatName, String formatURL) {
		super();
		this.file = file;
		this.formatName = formatName;
		this.formatURL = formatURL;
	}

	public Identification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
