package com.kh.semiProject.Student.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semiProject.Student.model.vo.Sugang;
import static com.kh.semiProject.common.JDBCTemplate.*;

public class SugangDAO {
	private Properties prop;

	public SugangDAO() {
		prop = new Properties();

		String filePath =SugangDAO.class
				.getResource("/config/student.properties")
				.getPath();
		try {

			prop.load(new FileReader(filePath));

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Sugang> selectList(Connection con, String stu_no){
		ArrayList<Sugang> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllsugang");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_no);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Sugang>();
			
			while(rset.next()) {
				Sugang sg = new Sugang();
				
				sg.setStudentNo(rset.getString("STUNO"));
				sg.setCls_no(rset.getString("CLSNO"));
				sg.setYear(rset.getInt("YEAR"));
				sg.setSemester(rset.getInt("SEMESTER"));
				sg.setCls_name(rset.getString("CLSNAME"));
				sg.setScore(rset.getDouble("POINT"));
				sg.setRetake(rset.getString("RETAKE"));
				
				list.add(sg);
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

	public ArrayList<Sugang> selectSmt(Connection con, String stu_no, int year, int smt) {
		ArrayList<Sugang> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSmtSugang");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_no);
			pstmt.setInt(2, year);
			pstmt.setInt(3, smt);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Sugang>();
			
			while(rset.next()) {
				Sugang sg = new Sugang();
				
				sg.setStudentNo(rset.getString("STUNO"));
				sg.setCls_no(rset.getString("CLSNO"));
				sg.setYear(rset.getInt("YEAR"));
				sg.setSemester(rset.getInt("SEMESTER"));
				sg.setCls_name(rset.getString("CLSNAME"));
				sg.setScore(rset.getDouble("POINT"));
				sg.setRetake(rset.getString("RETAKE"));
				
				list.add(sg);
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

	public Sugang selectClsPlan(Connection con, String clsNo, int year) {
		Sugang s = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectClsPlan");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, clsNo);
			pstmt.setInt(2, year);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				s = new Sugang();
				
				s.setCls_no(rset.getString("cls_no"));
				s.setYear(rset.getInt("year"));
				s.setGoal(rset.getString("goal"));
				s.setBook(rset.getString("book"));
				s.setpGrade(rset.getString("p_grade"));
				s.setpGrade2(rset.getString("p_grade2"));
				s.setpPlan(rset.getString("p_plan"));
				s.setEtc(rset.getString("etc"));
				s.setCheat(rset.getString("cheat"));
				s.setDeptName(rset.getString("dept_name"));
				s.setProfessorName(rset.getString("pro_name"));
				s.setProPhone(rset.getString("pro_phone"));
				s.setProEmail(rset.getString("pro_email"));
				s.setCls_type(rset.getString("class_type"));
				s.setCls_name(rset.getString("class_name"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return s;
	}
	
	
}
