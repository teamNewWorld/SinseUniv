package com.kh.semiProject.Student.model.vo;

public class Achievement {
	private String stu_no;
	private String cls_no;
	private String cls_name;
	private String profs_no;
	private int average;
	private double point;
	private String Correction;
	private int year;
	private int semester;
	private String retake;
	private String grade;


	public Achievement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Achievement(String stu_no, String cls_no, String cls_name, String profs_no, int average, double point,
			String correction, int year, int semester, String retake, String grade) {
		super();
		this.stu_no = stu_no;
		this.cls_no = cls_no;
		this.cls_name = cls_name;
		this.profs_no = profs_no;
		this.average = average;
		this.point = point;
		Correction = correction;
		this.year = year;
		this.semester = semester;
		this.retake = retake;
		this.grade = grade;
	}


	public Achievement(String stu_no, String cls_no, String cls_name, String profs_no, double point, int year,
			int semester) {
		super();
		this.stu_no = stu_no;
		this.cls_no = cls_no;
		this.cls_name = cls_name;
		this.profs_no = profs_no;
		this.point = point;
		this.year = year;
		this.semester = semester;
	}

	public String getStu_no() {
		return stu_no;
	}

	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
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

	public String getProfs_no() {
		return profs_no;
	}

	public void setProfs_no(String profs_no) {
		this.profs_no = profs_no;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getCorrection() {
		return Correction;
	}

	public void setCorrection(String correction) {
		Correction = correction;
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

	public String getRetake() {
		return retake;
	}

	public void setRetake(String retake) {
		this.retake = retake;
	}

	public String getGrade() {
		double s = this.getPoint();
		
		if(s>4.0) grade = "A+";
		else if(s>3.5) grade = "A";
		else if(s>3.0) grade = "B+";
		else if(s>2.5) grade = "B";
		else if(s>2.0) grade = "C+";
		else if(s>1.5) grade = "C";
		else if(s>1.0) grade = "D";
		else grade = "F";
		
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}



	
}
