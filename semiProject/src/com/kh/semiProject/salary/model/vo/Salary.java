package com.kh.semiProject.salary.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Salary implements Serializable {

	private static final long serialVersionUID = 1997L;
	
	private String professorNo;
	private Date amountDate;
	private int totalAmount;
	private int tax;
	private String bankName;
	private String bankNo;
	
	public Salary() {
		super();
	}

	public Salary(String professorNo, Date amountDate, int totalAmount, int tax, String bankName, String bankNo) {
		super();
		this.professorNo = professorNo;
		this.amountDate = amountDate;
		this.totalAmount = totalAmount;
		this.tax = tax;
		this.bankName = bankName;
		this.bankNo = bankNo;
	}

	@Override
	public String toString() {
		return "Salary [professorNo=" + professorNo + ", amountDate=" + amountDate + ", totalAmount=" + totalAmount
				+ ", tax=" + tax + ", bankName=" + bankName + ", bankNo=" + bankNo + "]";
	}

	public String getProfessorNo() {
		return professorNo;
	}

	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}

	public Date getAmountDate() {
		return amountDate;
	}

	public void setAmountDate(Date amountDate) {
		this.amountDate = amountDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	
	

}
