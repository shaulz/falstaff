package com.falstaff.repository.ds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.AutoPopulatingList;

import com.thoughtworks.xstream.XStream;

public class Test {
	
	public static class Inner {
		String fuku = "suku";
	}
	
	private String kuku = "muku";
	private List<Inner> inner = new ArrayList<Inner>(); 
	
	

	public String getKuku() {
		return kuku;
	}



	public void setKuku(String kuku) {
		this.kuku = kuku;
	}



	public List<Inner> getInner() {
		return new AutoPopulatingList<Inner>(inner, Inner.class);
	}



	public void setInner(List<Inner> inner) {
		this.inner = inner;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test test = new Test();
		test.getInner().add(new Inner());
		test.getInner().add(new Inner());
		XStream xstream = new XStream();
		String xml = xstream.toXML(test);
		System.out.println(xml);
	}

}
