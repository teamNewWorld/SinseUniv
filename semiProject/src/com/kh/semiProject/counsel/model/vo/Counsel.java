package com.kh.semiProject.counsel.model.vo;

import java.io.Serializable;
import java.sql.Date;

import com.kh.semiProject.member.model.vo.Student;

public class Counsel extends Student implements Serializable{

	private static final long serialVersionUID = 486L;
	
	private int cno;
	private String cwriter;
	private String ctitle;
	private String ctype;
	private Date cdate;
	private String ccontent;
	private String cemail;
	private String studentNo;
	private String professorNo;
	private String onOff;
	private String status;
	
	public Counsel() {	super();	}

	public Counsel(int cno, String cwriter, String ctitle, String ctype, Date cdate, String ccontent, String cemail,
			String studentNo, String professorNo, String onOff, String status) {
		super();
		this.cno = cno;
		this.cwriter = cwriter;
		this.ctitle = ctitle;
		this.ctype = ctype;
		this.cdate = cdate;
		this.ccontent = ccontent;
		this.cemail = cemail;
		this.studentNo = studentNo;
		this.professorNo = professorNo;
		this.onOff = onOff;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Counsel [cno=" + cno + ", cwriter=" + cwriter + ", ctitle=" + ctitle + ", ctype=" + ctype + ", cdate="
				+ cdate + ", ccontent=" + ccontent + ", cemail=" + cemail + ", studentNo=" + studentNo
				+ ", professorNo=" + professorNo + ", onOff=" + onOff + ", status=" + status + "]";
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCwriter() {
		return cwriter;
	}

	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
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

	public String getOnOff() {
		return onOff;
	}

	public void setOnOff(String onOff) {
		this.onOff = onOff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
