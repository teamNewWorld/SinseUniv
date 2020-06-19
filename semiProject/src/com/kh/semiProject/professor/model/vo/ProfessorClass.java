package com.kh.semiProject.professor.model.vo;

import com.kh.semiProject.member.model.vo.Student;

public class ProfessorClass extends Student {
	private String prf_no;
	private String cls_no;
	private String cls_name;
	private int capacity;
	private int days;
	private int average;
	private int year;
	private int semester;
	private String cls_type;
	
	public ProfessorClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ProfessorClass(String prf_no, String cls_no, String cls_name, int capacity, int average, int year, int semester) {
	      super();
	      this.prf_no = prf_no;
	      this.cls_no = cls_no;
	      this.cls_name = cls_name;
	      this.capacity = capacity;
	      this.average = average;
	      this.year = year;
	      this.semester = semester;
	   }



	   public ProfessorClass(String prf_no, String cls_no, String cls_name, int capacity, int days, int average, int year,
	         int semester, String cls_type) {
	      super();
	      this.prf_no = prf_no;
	      this.cls_no = cls_no;
	      this.cls_name = cls_name;
	      this.capacity = capacity;
	      this.days = days;
	      this.average = average;
	      this.year = year;
	      this.semester = semester;
	      this.cls_type = cls_type;
	   }



	public int getAverage() {
		return average;
	}



	public void setAverage(int average) {
		this.average = average;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public int getSemester() {
		return semester;
	}



	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getCls_type() {
		return cls_type;
	}
	
	public void setCls_type(String cls_type) {
		this.cls_type = cls_type;
	}

	public String getPrf_no() {
		return prf_no;
	}
	public void setPrf_no(String prf_no) {
		this.prf_no = prf_no;
	}
	public String getCls_no() {
		return cls_no;
	}
	public void setCls_no(String cls_no) {
		this.cls_no = cls_no;
	}
	public String getCls_name() {
		return cls_name;
	}
	public void setCls_name(String cls_name) {
		this.cls_name = cls_name;
	}
	public int getCapacity() {
		int cap = (int)(this.capacity * 0.66);
		
		return cap;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getDays() {
		int avg = this.average;
		return avg*16;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	
}
