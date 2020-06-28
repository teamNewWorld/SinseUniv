package com.kh.semiProject.Student.model.vo;

import java.io.Serializable;

import com.kh.semiProject.professor.model.vo.ClsPlan;

public class Sugang extends ClsPlan implements Serializable{

	private static final long serialVersionUID = 1L;
	


	private double score;
	private String grade;

	private String retake;

	public Sugang() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Sugang(String prf_no, String cls_no, String cls_name, int capacity, int days, int average, int year,
			int semester, String cls_type) {
		super(prf_no, cls_no, cls_name, capacity, days, average, year, semester, cls_type);
		// TODO Auto-generated constructor stub
	}





	public Sugang(String prf_no, String cls_no, String cls_name, int capacity, int average, int year, int semester) {
		super(prf_no, cls_no, cls_name, capacity, average, year, semester);
		// TODO Auto-generated constructor stub
	}





	public Sugang(String goal, String book, String pGrade, String pGrade2, String pPlan, String etc, String cheat) {
		super(goal, book, pGrade, pGrade2, pPlan, etc, cheat);
		// TODO Auto-generated constructor stub
	}





	public String getRetake() {
		return retake;
	}





	public void setRetake(String retake) {
		this.retake = retake;
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


	@Override
	public String toString() {
		return "Sugang [score=" + score + ", grade=" + grade + ", retake=" + retake + ", getGoal()=" + getGoal()
				+ ", getBook()=" + getBook() + ", getpGrade()=" + getpGrade() + ", getpGrade2()=" + getpGrade2()
				+ ", getpPlan()=" + getpPlan() + ", getEtc()=" + getEtc() + ", getCheat()=" + getCheat()
				+ ", getYear()=" + getYear() + ", getCls_type()=" + getCls_type() + ", getCls_no()=" + getCls_no()
				+ ", getCls_name()=" + getCls_name() + ", getProfessorName()=" + getProfessorName() + ", getProEmail()="
				+ getProEmail() + ", getProPhone()=" + getProPhone() + ", getDeptName()=" + getDeptName() + "]";
	}

	
	
	
}
