package com.kh.semiProject.find.model.vo;

import java.io.Serializable;

public class FindId implements Serializable {

	private static final long serialVersionUID = 113L;
	
	private String name;
	private String ssn1;
	private String ssn2;
	
	public FindId() { super(); }

	public FindId(String name, String ssn1, String ssn2) {
		super();
		this.name = name;
		this.ssn1 = ssn1;
		this.ssn2 = ssn2;
	}

	@Override
	public String toString() {
		return "FindId [name=" + name + ", ssn1=" + ssn1 + ", ssn2=" + ssn2 + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn1() {
		return ssn1;
	}

	public void setSsn1(String ssn1) {
		this.ssn1 = ssn1;
	}

	public String getSsn2() {
		return ssn2;
	}

	public void setSsn2(String ssn2) {
		this.ssn2 = ssn2;
	}

	
	
	

}
