package com.falstaff;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="identificationBulk")
public class IdentificationBulk {
	
	private List<Identification> identifications;
	
	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "identificationList")
	// XmlElement sets the name of the entities
	@XmlElement(name = "identification")
	public List<Identification> getIdentifications() {
		return identifications;
	}

	public void setIdentifications(List<Identification> identifications) {
		this.identifications = identifications;
	}

	public IdentificationBulk() {
		identifications = new LinkedList<Identification>();
	}

}
