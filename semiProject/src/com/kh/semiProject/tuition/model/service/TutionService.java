package com.kh.semiProject.tuition.model.service;

import static com.kh.semiProject.common.JDBCTemplate.*;
import static com.kh.semiProject.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;


import com.kh.semiProject.tuition.model.dao.TutionDAO;
import com.kh.semiProject.tuition.model.vo.Tution;
import com.kh.semiProject.tuition.model.vo.TutionPrint;

public class TutionService {

	private TutionDAO tDAO = new TutionDAO();
	private Connection con;
	
	public ArrayList<TutionPrint> selectList(String studentNo) {
		con = getConnection();
		
		ArrayList<TutionPrint> list = tDAO.selectList(con, studentNo);
		
		close(con);
		
		return list;
}
	public String selectStuList(String s3) {
		 con =getConnection();
		 String result = tDAO.selectStuList(con, s3);

		 close(con);
		 
		 return result;
		 
	}
	public TutionPrint seletOne(Date EnrollDate, String Stu) {
		con = getConnection();
		
		TutionPrint tp = tDAO.selectOne(con, EnrollDate, Stu);
		
		close(con);
		
		return tp;
	}
	public ArrayList<TutionPrint> semesterList(String sno, int year, int smt) {
		 con =getConnection();
		 ArrayList<TutionPrint> list = tDAO.semesterList(con, sno, year, smt);
			
			close(con);
			
			return list;
	}
}