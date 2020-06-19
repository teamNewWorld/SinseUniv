package com.kh.semiProject.boardComment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class BoardComment implements Serializable{


		private static final long serialVersionUID = 15881588L;
		
		private int bcno;
		private int bno;
		private String bccontent;
		private String bcwriter;
		private Date bcdate;
		private String studentno;
		private int refbcno;
		private int bclevel;
		
		//기본 생성자
		public BoardComment() {
			super();
		
		}

		//전체 생성자
		public BoardComment(int bcno, int bno, String bccontent, String bcwriter, Date bcdate, String studentno,
				int refbcno, int bclevel) {
			super();
			this.bcno = bcno;
			this.bno = bno;
			this.bccontent = bccontent;
			this.bcwriter = bcwriter;
			this.bcdate = bcdate;
			this.studentno = studentno;
			this.refbcno = refbcno;
			this.bclevel = bclevel;
		}


		// 댓글추가 생성자
		public BoardComment(int bno, String bccontent, String bcwriter, int refbcno, int bclevel) {
			super();
			this.bno = bno;
			this.bccontent = bccontent;
			this.bcwriter = bcwriter;
			this.refbcno = refbcno;
			this.bclevel = bclevel;
		}

		@Override
		public String toString() {
			return "BoardComment [bcno=" + bcno + ", bno=" + bno + ", bccontent=" + bccontent + ", bcwriter=" + bcwriter
					+ ", bcdate=" + bcdate + ", studentno=" + studentno + ", refbcno=" + refbcno + ", bclevel="
					+ bclevel + "]";
		}

		public int getBcno() {
			return bcno;
		}

		public void setBcno(int bcno) {
			this.bcno = bcno;
		}

		public int getBno() {
			return bno;
		}

		public void setBno(int bno) {
			this.bno = bno;
		}

		public String getBccontent() {
			return bccontent;
		}

		public void setBccontent(String bccontent) {
			this.bccontent = bccontent;
		}

		public String getBcwriter() {
			return bcwriter;
		}

		public void setBcwriter(String bcwriter) {
			this.bcwriter = bcwriter;
		}

		public Date getBcdate() {
			return bcdate;
		}

		public void setBcdate(Date bcdate) {
			this.bcdate = bcdate;
		}

		public String getStudentno() {
			return studentno;
		}

		public void setStudentno(String studentno) {
			this.studentno = studentno;
		}

		public int getRefbcno() {
			return refbcno;
		}

		public void setRefbcno(int refbcno) {
			this.refbcno = refbcno;
		}

		public int getBclevel() {
			return bclevel;
		}

		public void setBclevel(int bclevel) {
			this.bclevel = bclevel;
		}
		
	
}