package com.kh.semiProject.boardComment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semiProject.boardComment.model.vo.BoardComment;
import static com.kh.semiProject.common.JDBCTemplate.*;

public class BoardCommentDAO {
		private Properties prop;
		
		public BoardCommentDAO() {
			prop = new Properties();
			
			String filePath = BoardCommentDAO.class
									   .getResource("/config/comment.properties")
									   .getPath();
			
			try {
				prop.load(new FileReader(filePath));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		public int insertComment(Connection con, BoardComment bco) {
			int result = 0;
			
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("insertComment");
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, bco.getBno());
				pstmt.setString(2, bco.getBccontent());
				pstmt.setString(3, bco.getBcwriter());
				
				// 첫 댓글은 참조하는 댓글 없다.
				// 따라서 refcno가 0으로 온다.
				// pstmt.setInt(4, bco.getRefcno());
				
				if(bco.getRefbcno() > 0 ) {
						pstmt.setInt(4, bco.getRefbcno());
				} else {
					pstmt.setNull(4, java.sql.Types.NULL);
				}
				pstmt.setInt(5, bco.getBclevel());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}

		public ArrayList<BoardComment> selectList(Connection con, int bno) {
			ArrayList<BoardComment> clist = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectList");
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, bno);
				
				rset = pstmt.executeQuery();
				
				clist = new ArrayList<BoardComment>();
				
				while(rset.next()) {
					BoardComment bco = new BoardComment();
					
					bco.setBcno(rset.getInt("bcno"));
					bco.setBno(rset.getInt("bno"));
					bco.setBccontent(rset.getString("bccontent"));
					bco.setBcwriter(rset.getString("name"));
					bco.setStudentno(rset.getString("bcwriter"));
					bco.setBcdate(rset.getDate("bcdate"));
					bco.setRefbcno(rset.getInt("ref_bcno"));
					bco.setBclevel(rset.getInt("bclevel"));
					
					clist.add(bco);
				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			
			return clist;
		}

		public int updateComment(Connection con, BoardComment bco) {
			int result  = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("updateComment");
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, bco.getBccontent());
				pstmt.setInt(2, bco.getBcno());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e ) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}		
			
			return result;
		}

		public int deleteComment(Connection con, int cno) {
			int result  = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("deleteComment");
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, cno);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e ) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}		
			
			return result;
		}
}
