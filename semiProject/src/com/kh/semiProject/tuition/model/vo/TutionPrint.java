package com.kh.semiProject.tuition.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class TutionPrint implements Serializable{
	private String studentno;
	private int price;
	private Date enrolldate;
	private int enrollmoney;
	private String enrollyn;
	private int scholarshipprice;
	
	public TutionPrint() {	super(); }

	public TutionPrint(String studentno, int price, Date enrolldate, int enrollmoney, String enrollyn,
			int scholarshipprice) {
		super();
		this.studentno = studentno;
		this.price = price;
		this.enrolldate = enrolldate;
		this.enrollmoney = enrollmoney;
		this.enrollyn = enrollyn;
		this.scholarshipprice= scholarshipprice;
	}

	@Override
	public String toString() {
		return "TutionPrint [studentno=" + studentno + ", price=" + price + ", enrolldate=" + enrolldate
				+ ", enrollmoney=" + enrollmoney + ", enrollyn=" + enrollyn + ", scholarshipprice="
				+ scholarshipprice + "]";
	}

	public String getStudentno() {
		return studentno;
	}

	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	public int getEnrollmoney() {
		return enrollmoney;
	}

	public void setEnrollmoney(int enrollmoney) {
		this.enrollmoney = enrollmoney;
	}

	public String getEnrollyn() {
		return enrollyn;
	}

	public void setEnrollyn(String enrollyn) {
		this.enrollyn = enrollyn;
	}

	public int getScholarshipprice() {
		return scholarshipprice;
	}

	public void setScholarshipprice(int scholarshipprice) {
		this.scholarshipprice = scholarshipprice;
	}
	
	
	
	
	
	
}
