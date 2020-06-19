package com.kh.semiProject.member.model.vo;

import java.io.Serializable;

public class Student extends Professor implements Serializable{

	private static final long serialVersionUID = 1004L;
		
	 // 1. 필드변수 / 멤버 변수
	   private String studentNo;   
	   private String professorNo;
	   private String deptNo;
	   private String name; 
	   private String gender;   
	   private String studentSsn;      
	   private String phone;    
	   private String email;   
	   private String address;
	   private String graduateYn;  
	   private String absenceYn;    
	   private String returnYn;
	   private int totalPoint;
	   private int currentPoint;
	   private String studentPwd;
	   private String image;
	
	   // 기본 생성자
	   public Student() {   	super();	}


	public Student(String studentNo, String studentPwd) {
		super();
		this.studentNo = studentNo;
		this.studentPwd = studentPwd;
	}


	public Student(String studentNo, String phone, String email, String address, String studentPwd) {
		super();
		this.studentNo = studentNo;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.studentPwd = studentPwd;
	}


	public Student(String studentNo, String deptNo, String name, String gender, String studentSsn, String phone,
			String email, String address, String studentPwd) {
		super();
		this.studentNo = studentNo;
		this.deptNo = deptNo;
		this.name = name;
		this.gender = gender;
		this.studentSsn = studentSsn;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.studentPwd = studentPwd;
	}


	public Student(String studentNo, String professorNo, String deptNo, String name, String gender, String studentSsn,
			String phone, String email, String address, String graduateYn, String absenceYn, String returnYn,
			int totalPoint, int currentPoint, String studentPwd, String image) {
		super();
		this.studentNo = studentNo;
		this.professorNo = professorNo;
		this.deptNo = deptNo;
		this.name = name;
		this.gender = gender;
		this.studentSsn = studentSsn;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.graduateYn = graduateYn;
		this.absenceYn = absenceYn;
		this.returnYn = returnYn;
		this.totalPoint = totalPoint;
		this.currentPoint = currentPoint;
		this.studentPwd = studentPwd;
		this.image = image;
	}


	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", professorNo=" + professorNo + ", deptNo=" + deptNo + ", name="
				+ name + ", gender=" + gender + ", studentSsn=" + studentSsn + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", graduateYn=" + graduateYn + ", absenceYn=" + absenceYn + ", returnYn="
				+ returnYn + ", totalPoint=" + totalPoint + ", currentPoint=" + currentPoint + ", studentPwd="
				+ studentPwd + ", image=" + image + "]";
	}


	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public String getProfessorNo() {
		return professorNo;
	}


	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}


	public String getDeptNo() {
		return deptNo;
	}


	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getStudentSsn() {
		return studentSsn;
	}


	public void setStudentSsn(String studentSsn) {
		this.studentSsn = studentSsn;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getGraduateYn() {
		return graduateYn;
	}


	public void setGraduateYn(String graduateYn) {
		this.graduateYn = graduateYn;
	}


	public String getAbsenceYn() {
		return absenceYn;
	}


	public void setAbsenceYn(String absenceYn) {
		this.absenceYn = absenceYn;
	}


	public String getReturnYn() {
		return returnYn;
	}


	public void setReturnYn(String returnYn) {
		this.returnYn = returnYn;
	}


	public int getTotalPoint() {
		return totalPoint;
	}


	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}


	public int getCurrentPoint() {
		return currentPoint;
	}


	public void setCurrentPoint(int currentPoint) {
		this.currentPoint = currentPoint;
	}


	public String getStudentPwd() {
		return studentPwd;
	}


	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	
	
}
