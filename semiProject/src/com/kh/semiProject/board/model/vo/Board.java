package com.kh.semiProject.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {

	private static final long serialVersionUID = 999999L;
	
	
	private int bno;					// 게시글 번호
	private String btitle;			// 게시글 제목
	private String bcontent;		// 게시글 내용
	private String bwriter;		// 게시글 저자
	private String studentNo;   // 학생 아이디
	private int bcount;				// 게시글 조회수
	private Date bdate;				// 게시글 날짜
	private String status;			// 게시글 삭제여부 (Y : 일반, N : 삭제함)
	
	// 기본 생성자
	public Board() {	super();	}

	
	// 전체생성자
	public Board(int bno, String btitle, String bcontent, String bwriter, String studentNo, int bcount, Date bdate,
			String status) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.studentNo = studentNo;
		this.bcount = bcount;
		this.bdate = bdate;
		this.status = status;
	}


	// 대숲에 필요한 생성자
	public Board(String btitle, String bcontent, String bwriter) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
	}


	@Override
	public String toString() {
		return "Board [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", studentNo=" + studentNo + ", bcount=" + bcount + ", bdate=" + bdate + ", status=" + status + "]";
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public String getBwriter() {
		return bwriter;
	}


	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}


	public String getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}


	public int getBcount() {
		return bcount;
	}


	public void setBcount(int bcount) {
		this.bcount = bcount;
	}


	public Date getBdate() {
		return bdate;
	}


	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
	
	
}
