package com.kh.semiProject.counselComment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class CounselComment implements Serializable {

	private static final long serialVersionUID = 1994L;
	
	private int ccno;
	private int cno;
	private String cccontent;
	private String ccwriter;
	private Date ccdate;

	public CounselComment() {
		super();
	}

	public CounselComment(int cno, String cccontent, String ccwriter) {
		super();
		this.cno = cno;
		this.cccontent = cccontent;
		this.ccwriter = ccwriter;
	}

	public CounselComment(int ccno, int cno, String cccontent, String ccwriter, Date ccdate) {
		super();
		this.ccno = ccno;
		this.cno = cno;
		this.cccontent = cccontent;
		this.ccwriter = ccwriter;
		this.ccdate = ccdate;

	}

	@Override
	public String toString() {
		return "CounselComment [ccno=" + ccno + ", cno=" + cno + ", cccontent=" + cccontent + ", ccwriter=" + ccwriter
				+ ", ccdate=" + ccdate + "]";
	}

	public int getCcno() {
		return ccno;
	}

	public void setCcno(int ccno) {
		this.ccno = ccno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCccontent() {
		return cccontent;
	}

	public void setCccontent(String cccontent) {
		this.cccontent = cccontent;
	}

	public String getCcwriter() {
		return ccwriter;
	}

	public void setCcwriter(String ccwriter) {
		this.ccwriter = ccwriter;
	}

	public Date getCcdate() {
		return ccdate;
	}

	public void setCcdate(Date ccdate) {
		this.ccdate = ccdate;
	}

	
	
	
}
