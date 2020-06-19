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
				
				sg.setStu_no(rset.getString("STUNO"));
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
				
				sg.setStu_no(rset.getString("STUNO"));
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
	
	
}
