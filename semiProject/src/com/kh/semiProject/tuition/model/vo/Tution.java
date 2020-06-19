package com.kh.semiProject.tuition.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Tution implements Serializable{

	private String studentNo;
	private String deptNo;
	private int enrollMoney;
	private String enrollYn;
	private Date enrollDate;
	
	public Tution() {
		super();
		
	}

	public Tution(String studentNo, String deptNo, int enrollMoney, String enrollYn, Date enrollDate) {
		super();
		this.studentNo = studentNo;
		this.deptNo = deptNo;
		this.enrollMoney = enrollMoney;
		this.enrollYn = enrollYn;
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "tuition [studentNo=" + studentNo + ", deptNo=" + deptNo + ", enrollMoney=" + enrollMoney + ", enrollYn="
				+ enrollYn + ", enrollDate=" + enrollDate + "]";
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public int getEnrollMoney() {
		return enrollMoney;
	}

	public void setEnrollMoney(int enrollMoney) {
		this.enrollMoney = enrollMoney;
	}

	public String getEnrollYn() {
		return enrollYn;
	}

	public void setEnrollYn(String enrollYn) {
		this.enrollYn = enrollYn;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date date) {
		this.enrollDate = date;
	}
	
}
