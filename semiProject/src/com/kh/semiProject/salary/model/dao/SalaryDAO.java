package com.kh.semiProject.salary.model.dao;

import static com.kh.semiProject.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Properties;

import com.kh.semiProject.member.exception.MemberException;
import com.kh.semiProject.member.model.vo.Professor;
import com.kh.semiProject.salary.model.vo.Salary;

public class SalaryDAO {
	
	private Properties prop;
	
	public SalaryDAO() {
		prop = new Properties();
		
		String filePath = SalaryDAO.class
							.getResource("/config/salary.properties")
							.getPath();
		// NoticeDAO.class: NoticeDAO 클래스가 있는 위치에서 다음 문장을 실행하라는 뜻
		
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public ArrayList<Salary> selectList(Connection con, String professorNo) {
		ArrayList<Salary> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, professorNo);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Salary>();
			
			while(rset.next()) {
				Salary sa = new Salary();
				
				sa.setProfessorNo(rset.getString(1));
				sa.setAmountDate(rset.getDate(2));
				sa.setTotalAmount(rset.getInt(3));
				sa.setTax(rset.getInt(4));
				sa.setBankName(rset.getString(5));
				sa.setBankNo(rset.getString(6));
				
				list.add(sa);
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public String selectProList(Connection con, String p3) {
		String result = p3; // 결과를 담을 객체
		PreparedStatement pstmt = null; // 쿼리 실행할 객체
		ResultSet rset = null; // Select 결과를 받아 올 객체

		// 프로퍼티 수정해야합니다
		// DB에 설정한 값으로
		String sql = prop.getProperty("selectProfessor");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, p3);

			rset = pstmt.executeQuery();

			System.out.println("result 조회 전 : " + result);



			System.out.println("result 조회 후 : " + result);

		} catch (SQLException e) {

			e.printStackTrace();


		} finally {
			close(pstmt);
		}

		return result;
	}

	public Salary selectOne(Connection con, Date SalaryDate) {
		Salary s = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql =prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setDate(1, SalaryDate);
		
			rset = pstmt.executeQuery();
		
			while(rset.next()) {
				s = new Salary();
				
				s.setAmountDate(rset.getDate("amountdate"));
				s.setProfessorNo(rset.getString("PROFESSOR_NO"));
				s.setTotalAmount(rset.getInt("totalamount"));
				s.setTax(rset.getInt("tax"));
				s.setBankName(rset.getString("bankname"));
				s.setBankNo(rset.getString("bank_no"));
				
		
			}
		
			System.out.println(s);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		
		}
		return s;
	}

	public ArrayList<Salary> selectSemester(Connection con, String pno, int year, int smt) {
		ArrayList<Salary> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = null;
		
		if(smt==1) {
			sql = "SELECT * FROM SALARY WHERE PROFESSOR_NO = ? AND EXTRACT(YEAR FROM AMOUNTDATE)= ? AND EXTRACT(MONTH FROM AMOUNTDATE)<7";
		}
		else {
			sql = "SELECT * FROM SALARY WHERE PROFESSOR_NO = ? AND EXTRACT(YEAR FROM AMOUNTDATE)= ? AND EXTRACT(MONTH FROM AMOUNTDATE)>6";
		}
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pno);
			pstmt.setInt(2, year);
		
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Salary>();
			
			while(rset.next()) {
				Salary sa = new Salary();
				
				sa.setProfessorNo(rset.getString(1));
				sa.setAmountDate(rset.getDate(2));
				sa.setTotalAmount(rset.getInt(3));
				sa.setTax(rset.getInt(4));
				sa.setBankName(rset.getString(5));
				sa.setBankNo(rset.getString(6));
				
				list.add(sa);
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}






