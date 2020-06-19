package com.kh.semiProject.Student.model.dao;

import static com.kh.semiProject.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semiProject.Student.model.vo.Achievement;
import com.kh.semiProject.Student.model.vo.Sugang;

public class AchvmentDAO {

	private Properties prop;

	public AchvmentDAO() {
		prop = new Properties();

		String filePath =AchvmentDAO.class
				.getResource("/config/student.properties")
				.getPath();
		try {

			prop.load(new FileReader(filePath));

		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Achievement> selectList(Connection con, String stu_no){
		ArrayList<Achievement> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllachievement");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_no);

			rset = pstmt.executeQuery();

			list = new ArrayList<Achievement>();

			while(rset.next()) {
				Achievement ach = new Achievement();

				ach.setStu_no(rset.getString("STUDENT_NO"));
				ach.setProfs_no(rset.getString("PROFESSOR_NO"));
				ach.setCls_no(rset.getString("CLASS_NO"));
				ach.setYear(rset.getInt("YEAR"));
				ach.setSemester(rset.getInt("SMT"));
				ach.setCls_name(rset.getString("CLASS_NAME"));
				ach.setPoint(rset.getDouble("POINT"));


				list.add(ach);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Achievement> selectSmt(Connection con, String stu_no, int year, int smt) {
		ArrayList<Achievement> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSmtAchievement");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_no);
			pstmt.setInt(2, year);
			pstmt.setInt(3, smt);

			rset = pstmt.executeQuery();

			list = new ArrayList<Achievement>();

			while(rset.next()) {
				Achievement ach = new Achievement();

				ach.setStu_no(rset.getString("STUDENT_NO"));
				ach.setProfs_no(rset.getString("PROFESSOR_NO"));
				ach.setCls_no(rset.getString("CLASS_NO"));
				ach.setYear(rset.getInt("YEAR"));
				ach.setSemester(rset.getInt("SMT"));
				ach.setCls_name(rset.getString("CLASS_NAME"));
				ach.setPoint(rset.getDouble("POINT"));


				list.add(ach);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int checkRat(Connection con, String stuno, String clsno) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		sql = prop.getProperty("checkRating");

		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, stuno);
			pstmt.setString(2, clsno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) result = 1;
			else result = 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}

	public int checkclm(Connection con, String stuno, String clsno) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		sql = prop.getProperty("checkClaim");

		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, stuno);
			pstmt.setString(2, clsno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) result = 1;
			else result = 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
}


