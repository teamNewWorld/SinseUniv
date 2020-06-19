package com.kh.semiProject.absence.model.service;

import java.sql.Connection;
import java.util.ArrayList;


import static com.kh.semiProject.common.JDBCTemplate.*;


import com.kh.semiProject.absence.model.dao.AbsenceDAO;
import com.kh.semiProject.absence.model.vo.Absence;

public class AbsenceService {
	private AbsenceDAO aDAO = new AbsenceDAO();
	private Connection con;
	
	public ArrayList<Absence> selectList(String studentNo) {
		con = getConnection();
		
		ArrayList<Absence> list = aDAO.selectList(con,studentNo);
		
		close(con);
			
		return list;
	}
	
	public int insertAbsence(Absence a) {
		con = getConnection();
		
		int result = aDAO.insertAbsence(con, a);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	public String selectStuList(String s3) {
		 con =getConnection();
		 String result = aDAO.selectStuList(con, s3);

		 close(con);
		 
		 return result;
		 
	}



}
