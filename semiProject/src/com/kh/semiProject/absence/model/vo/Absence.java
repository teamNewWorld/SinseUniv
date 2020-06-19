package com.kh.semiProject.absence.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Absence implements Serializable{
	private String studentno;
	private Date startdate;
	private Date enddate;
	private String abstype;
	private Date subdate;
	private String reason;
	private String state;
	

	public Absence() {	super();   }

	
	public Absence(String studentno, Date startdate, Date enddate, String abstype, Date subdate, String reason, String state) {
		super();
		this.studentno = studentno;
		this.startdate = startdate;
		this.enddate = enddate;
		this.abstype = abstype;
		this.subdate = subdate;
		this.reason = reason;
		this.state = state;
	}


	@Override
	public String toString() {
		return "Absence [studentno=" + studentno + ", startdate=" + startdate + ", enddate=" + enddate + ", abstype="
				+ abstype + ", subdate=" + subdate + ", reason=" + reason +", state=" + state + "]";
	}


	public String getStudentno() {
		return studentno;
	}


	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getEnddate() {
		return enddate;
	}


	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


	public String getAbstype() {
		return abstype;
	}


	public void setAbstype(String abstype) {
		this.abstype = abstype;
	}


	public Date getSubdate() {
		return subdate;
	}


	public void setSubdate(Date subdate) {
		this.subdate = subdate;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
