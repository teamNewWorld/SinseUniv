package com.kh.semiProject.counselComment.model.dao;


import static com.kh.semiProject.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semiProject.counselComment.model.service.CounselCommentService;
import com.kh.semiProject.counselComment.model.vo.CounselComment;

public class CounselCommentDAO {
	private Properties prop;

	public CounselCommentDAO() {
		prop = new Properties();

		String filePath = CounselCommentService.class.getResource("/config/counselcomment.properties").getPath();

		try {

			prop.load(new FileReader(filePath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public int insertCounselComment(Connection con, CounselComment cco) {
		int result  = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCounselComment");
		

		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cco.getCno());
			pstmt.setString(2, cco.getCccontent());
			pstmt.setString(3, cco.getCcwriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result;
		
	}
	public ArrayList<CounselComment> selectList(Connection con, int cno) {
		ArrayList<CounselComment> cclist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			rset = pstmt.executeQuery();
			
			cclist = new ArrayList<CounselComment>();
			
			while(rset.next()) {
				CounselComment cco = new CounselComment();
				
				cco.setCno(rset.getInt("cno"));
				cco.setCcno(rset.getInt("ccno"));
				cco.setCccontent(rset.getString("CCCONTENT"));
				cco.setCcwriter(rset.getString("CCWRITER"));
				cco.setCcdate(rset.getDate("CCDATE"));
				
				cclist.add(cco);				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return cclist;
	}

}
