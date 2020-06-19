package com.kh.semiProject.member.model.vo;

import java.io.Serializable;

public class Department implements Serializable {

	private static final long serialVersionUID = 38317L;
	
	private String deptNo;
	private String deptName;
	private String category;
	private String openYn;
	private int memNum;
	
	public Department() { super(); }

	public Department(String deptNo, String deptName, String category, String openYn, int memNum) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.category = category;
		this.openYn = openYn;
		this.memNum = memNum;
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", category=" + category + ", openYn="
				+ openYn + ", memNum=" + memNum + "]";
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOpenYn() {
		return openYn;
	}

	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	
	
	
}
