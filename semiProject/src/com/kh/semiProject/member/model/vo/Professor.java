package com.kh.semiProject.member.model.vo;

import java.io.Serializable;

public class Professor extends Department implements Serializable {


	private static final long serialVersionUID = 1002L;
	private String professorNo;
	private String professorName;
	private String professorSsn;
	private String proAddress;
	private String deptNo;
	private String professorPwd;
	private String proEmail;
	private String proPhone;
	private String proImage;
	
	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Professor(String professorNo, String professorPwd) {
		super();
		this.professorNo = professorNo;
		this.professorPwd = professorPwd;
	}


	public Professor(String professorNo, String professorName, String professorSsn, String proAddress, String deptNo,
			String professorPwd, String proEmail, String proPhone, String proImage) {
		super();
		this.professorNo = professorNo;
		this.professorName = professorName;
		this.professorSsn = professorSsn;
		this.proAddress = proAddress;
		this.deptNo = deptNo;
		this.professorPwd = professorPwd;
		this.proEmail = proEmail;
		this.proPhone = proPhone;
		this.proImage = proImage;
	}


	@Override
	public String toString() {
		return "Professor [professorNo=" + professorNo + ", professorName=" + professorName + ", professorSsn="
				+ professorSsn + ", proAddress=" + proAddress + ", deptNo=" + deptNo + ", professorPwd=" + professorPwd
				+ ", proEmail=" + proEmail + ", proPhone=" + proPhone + ", proImage=" + proImage + "]";
	}


	public String getProfessorNo() {
		return professorNo;
	}


	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}


	public String getProfessorName() {
		return professorName;
	}


	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}


	public String getProfessorSsn() {
		return professorSsn;
	}


	public void setProfessorSsn(String professorSsn) {
		this.professorSsn = professorSsn;
	}


	public String getProAddress() {
		return proAddress;
	}


	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}


	public String getDeptNo() {
		return deptNo;
	}


	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}


	public String getProfessorPwd() {
		return professorPwd;
	}


	public void setProfessorPwd(String professorPwd) {
		this.professorPwd = professorPwd;
	}


	public String getProEmail() {
		return proEmail;
	}


	public void setProEmail(String proEmail) {
		this.proEmail = proEmail;
	}


	public String getProPhone() {
		return proPhone;
	}


	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}


	public String getProImage() {
		return proImage;
	}


	public void setProImage(String proImage) {
		this.proImage = proImage;
	}



	
}
