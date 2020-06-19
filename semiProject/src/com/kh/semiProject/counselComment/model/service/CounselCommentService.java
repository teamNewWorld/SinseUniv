package com.kh.semiProject.counselComment.model.service;

import com.kh.semiProject.boardComment.model.vo.BoardComment;
import com.kh.semiProject.counselComment.model.dao.CounselCommentDAO;
import com.kh.semiProject.counselComment.model.vo.CounselComment;
import static com.kh.semiProject.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;


public class CounselCommentService {
	
	private Connection con;
	private CounselCommentDAO ccoDAO = new CounselCommentDAO();
	
	public int insertCounselComment(CounselComment cco) {
		
		con = getConnection();
		
		int result = ccoDAO.insertCounselComment(con, cco);
		
		if( result >  0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	public ArrayList<CounselComment> selectList(int cno) {
		con = getConnection();
		
		ArrayList<CounselComment> cclist = ccoDAO.selectList(con, cno);
		
		close(con);
		
		return cclist;
	}
}
