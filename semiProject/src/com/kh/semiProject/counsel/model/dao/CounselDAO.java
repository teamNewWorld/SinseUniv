package com.kh.semiProject.counsel.model.dao;



import static com.kh.semiProject.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semiProject.counsel.model.vo.Counsel;

public class CounselDAO {
	private Properties prop;
	
	public CounselDAO() {
		prop = new Properties();
		
		String filePath = CounselDAO.class
							.getResource("/config/counsel.properties")
							.getPath();
		// NoticeDAO.class: NoticeDAO 클래스가 있는 위치에서 다음 문장을 실행하라는 뜻
		
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public ArrayList<Counsel> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Counsel> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			// 1. 마지막 행의 번호
			// 2. 첫 행의 번호
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
						
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Counsel>();
			
			while(rset.next()) {
				Counsel c = new Counsel();
				
				c.setCno(rset.getInt("cno"));
				c.setCwriter(rset.getString("cwriter"));
				c.setCtitle(rset.getString("ctitle"));
				c.setCtype(rset.getString("ctype"));
				c.setCdate(rset.getDate("cdate"));
				c.setCcontent(rset.getString("ccontent"));
				c.setCemail(rset.getString("cemail"));
				c.setStudentNo(rset.getString("student_no"));
				c.setProfessorNo(rset.getString("professor_no"));
				c.setOnOff(rset.getString("ONOFF"));
				c.setStatus(rset.getString("STATUS"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;	
		}

	public int insertCounsel(Connection con, Counsel c) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCounsel");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, c.getCwriter());
			pstmt.setString(2, c.getCtitle());
			pstmt.setString(3, c.getCtype());
			pstmt.setString(4, c.getCemail());
			pstmt.setDate(5, c.getCdate());
			pstmt.setString(6, c.getCcontent());
			pstmt.setString(7, c.getStudentNo());
			pstmt.setString(8, c.getProfessorNo());
			pstmt.setString(9, c.getOnOff());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Counsel selectOne(Connection con, int cno) {
		Counsel c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				c = new Counsel();
				
				c.setCno(rset.getInt("cno"));
				c.setCwriter(rset.getString("cwriter"));
				c.setCtitle(rset.getString("ctitle"));
				c.setCtype(rset.getString("ctype"));
				c.setCdate(rset.getDate("cdate"));
				c.setCcontent(rset.getString("ccontent"));
				c.setCemail(rset.getString("cemail"));
				c.setStatus(rset.getString("STATUS"));
				c.setProfessorNo(rset.getString("PROFESSOR_NO"));
				c.setStudentNo(rset.getString("student_no"));
				c.setOnOff(rset.getString("ONOFF"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}

	public int deleteCounsel(Connection con, int cno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteCounsel");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateCounsel(Connection con, int cno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateCounsel");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}	
		
		return result;
	}

	public int getListCount(Connection con) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	
	}


