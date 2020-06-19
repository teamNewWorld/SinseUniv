package com.kh.semiProject.Student.model.vo;

public class Sugang {

	private String stu_no;
	private String cls_no;
	private String pfs_no;
	private String cls_name;
	private double score;
	private String grade;
	private int year;
	private int semester;
	private String retake;

	public Sugang() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Sugang(String stu_no, String cls_no, String pfs_no, String cls_name, double score, String grade, int year,
			int semester, String retake) {
		super();
		this.stu_no = stu_no;
		this.cls_no = cls_no;
		this.pfs_no = pfs_no;
		this.cls_name = cls_name;
		this.score = score;
		this.grade = grade;
		this.year = year;
		this.semester = semester;
		this.retake = retake;
	}


	public Sugang(String stu_no, String cls_no, String cls_name, double score, int year, int semester, String retake) {
		super();
		this.stu_no = stu_no;
		this.cls_no = cls_no;
		this.cls_name = cls_name;
		this.score = score;
		this.year = year;
		this.semester = semester;
		this.retake = retake;
	}




	public String getRetake() {
		return retake;
	}





	public void setRetake(String retake) {
		this.retake = retake;
	}





	public String getCls_name() {
		return cls_name;
	}

	public void setCls_name(String cls_name) {
		this.cls_name = cls_name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getGrade() {
		double s = this.getScore();
		
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

	public String getPfs_no() {
		return pfs_no;
	}

	public void setPfs_no(String pfs_no) {
		this.pfs_no = pfs_no;
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

	@Override
	public String toString() {
		return "Sugang [stu_no=" + stu_no + ", cls_no=" + cls_no + ", pfs_no=" + pfs_no + ", year=" + year
				+ ", semester=" + semester + "]";
	}
	
	
}
