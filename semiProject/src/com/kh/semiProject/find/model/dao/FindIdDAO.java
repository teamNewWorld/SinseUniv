package com.kh.semiProject.find.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.semiProject.find.model.vo.FindId;

import static com.kh.semiProject.common.JDBCTemplate.*;

public class FindIdDAO {
	private Properties prop;

	public FindIdDAO() {
		prop = new Properties();

		String filePath = FindIdDAO.class.getResource("/config/findId.properties").getPath();

		try {
			prop.load(new FileReader(filePath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public String findStuId(Connection con, String name, String ssn1, String ssn2) {
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectStuId");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, ssn1);
			pstmt.setString(3, ssn2);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
		
	}
	
	public String findProId(Connection con, String name, String ssn1, String ssn2) {
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProId");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, ssn1);
			pstmt.setString(3, ssn2);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
		
	}

	public int setStuPwd(Connection con, String stuId, String pwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("setStuPwd");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, pwd);
			pstmt.setString(2, stuId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int setProPwd(Connection con, String proId, String pwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("setProPwd");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, pwd);
			pstmt.setString(2, proId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
}
