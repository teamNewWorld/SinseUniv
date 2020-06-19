package com.kh.semiProject.tuition.model.dao;

import static com.kh.semiProject.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semiProject.tuition.model.vo.Tution;
import com.kh.semiProject.tuition.model.vo.TutionPrint;

public class TutionDAO {
private Properties prop;
	
	public TutionDAO() {
		prop = new Properties();
		
		String filePath = TutionDAO.class
							.getResource("/config/tution.properties")
							.getPath();
		// NoticeDAO.class: NoticeDAO 클래스가 있는 위치에서 다음 문장을 실행하라는 뜻
		
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public ArrayList<TutionPrint> selectList(Connection con, String studentNo) {
		ArrayList<TutionPrint> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, studentNo);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<TutionPrint>();
			
			while(rset.next()) {
				TutionPrint tp = new TutionPrint();
				
				tp.setStudentno(rset.getString(1));
				tp.setPrice(rset.getInt(2));
				tp.setEnrolldate(rset.getDate(3));
				tp.setEnrollmoney(rset.getInt(4));
				tp.setEnrollyn(rset.getString(5));
				tp.setScholarshipprice(rset.getInt(6));
				
				
				list.add(tp);
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public String selectStuList(Connection con, String s3) {
		String result = s3; // 결과를 담을 객체
		PreparedStatement pstmt = null; // 쿼리 실행할 객체
		ResultSet rset = null; // Select 결과를 받아 올 객체

		// 프로퍼티 수정해야합니다
		// DB에 설정한 값으로
		String sql = prop.getProperty("selectStudent");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, s3);

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

	public TutionPrint selectOne(Connection con, Date EnrollDate, String Stu) {
		TutionPrint tp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, Stu);
			pstmt.setDate(2, EnrollDate);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				tp = new TutionPrint ();
				
				tp.setEnrolldate(rset.getDate("ENROLLDATE"));
				tp.setStudentno(rset.getString("STUDENT_NO"));
				tp.setPrice(rset.getInt("PRICE"));
				tp.setEnrollmoney(rset.getInt("ENROLLMONEY"));
				tp.setEnrollyn(rset.getString("ENROLL_YN"));
				tp.setScholarshipprice(rset.getInt("SCHOLARSHIP_PRICE"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		
		}
		return tp;

	}

	public ArrayList<TutionPrint> semesterList(Connection con, String sno, int year, int smt) {
		ArrayList<TutionPrint> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSmt");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sno);
			pstmt.setInt(2, year);
			
			if(smt==1) pstmt.setInt(3, 3);
			else if(smt==2) pstmt.setInt(3, 9);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<TutionPrint>();
			
			while(rset.next()) {
				TutionPrint tp = new TutionPrint();
				
				tp.setStudentno(rset.getString(1));
				tp.setPrice(rset.getInt(2));
				tp.setEnrolldate(rset.getDate(3));
				tp.setEnrollmoney(rset.getInt(4));
				tp.setEnrollyn(rset.getString(5));
				tp.setScholarshipprice(rset.getInt(6));
				
				
				list.add(tp);
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
