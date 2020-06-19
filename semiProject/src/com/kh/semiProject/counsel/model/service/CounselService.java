package com.kh.semiProject.counsel.model.service;


import static com.kh.semiProject.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;


import com.kh.semiProject.counsel.model.dao.CounselDAO;
import com.kh.semiProject.counsel.model.vo.Counsel;
import com.kh.semiProject.notice.model.vo.Notice;

public class CounselService {
	private Connection con;
	private CounselDAO cDAO = new CounselDAO();
	
	public ArrayList<Counsel> selectList(int currentPage, int limit) {
		con = getConnection();
		
		ArrayList<Counsel> list = cDAO.selectList(con, currentPage, limit);
		
		close(con);
		
		return list;	
		
	}

	public int insertCounsel(Counsel c) {
		con = getConnection();
		
		int result = cDAO.insertCounsel(con, c);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public Counsel selectOne(int cno) {
		con = getConnection();
		Counsel c = cDAO.selectOne(con, cno);
		
		close(con);
		
		return c;
	}
	
	public int deleteCounsel (int cno) {
		con = getConnection();
		
		int result = cDAO.deleteCounsel(con, cno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public Counsel updateView(int cno) {
		con = getConnection();
		
		Counsel c = cDAO.selectOne(con, cno);
		
		close(con);
		
		return c;
	}
	
	
	public int updateCounsel(int cno) {
		con = getConnection();
		
		int result = cDAO.updateCounsel(con, cno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int getListCount() {
		con = getConnection();
		
		int result = cDAO.getListCount(con);
		
		
		
		close(con);

		return result;
	}




}
