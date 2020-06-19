package com.kh.semiProject.absence.model.dao;

import static com.kh.semiProject.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semiProject.absence.model.vo.Absence;

public class AbsenceDAO {
	private Properties prop;
	
	public AbsenceDAO() {
		prop = new Properties();
		
		String filePath = AbsenceDAO.class
						.getResource("/config/absence.properties")
						.getPath();
		try {
			prop.load(new FileReader(filePath));
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertAbsence(Connection con, Absence a) {
		int result = 0 ;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAbsence");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, a.getStudentno());
			pstmt.setDate(2, a.getStartdate());
			pstmt.setDate(3, a.getEnddate());
			pstmt.setString(4, a.getAbstype());
			pstmt.setDate(5, a.getSubdate());
			pstmt.setString(6, a.getReason());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;	
	}

	public ArrayList<Absence> selectList(Connection con, String studentNo) {
		ArrayList<Absence>  list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con .prepareStatement(sql);
			pstmt.setString(1, studentNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Absence>();
			
			while(rset.next()) {
				Absence a = new Absence();
				
				a.setStudentno(rset.getString(1));
				a.setStartdate(rset.getDate(2));
				a.setEnddate(rset.getDate(3));
				a.setAbstype(rset.getString(4));
				a.setSubdate(rset.getDate(5));
				a.setReason(rset.getString(6));
				a.setState(rset.getString(7));
				
				list.add(a);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
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

}
