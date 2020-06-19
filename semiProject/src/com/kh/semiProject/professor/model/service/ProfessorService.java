package com.kh.semiProject.professor.model.service;

import static com.kh.semiProject.common.JDBCTemplate.close;
import static com.kh.semiProject.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semiProject.professor.model.dao.ProfessorDAO;
import com.kh.semiProject.professor.model.vo.Achievement;
import com.kh.semiProject.professor.model.vo.ProfessorClass;

public class ProfessorService {

	private ProfessorDAO pfDAO = new ProfessorDAO();
	private Connection con;
	
	public ArrayList<Achievement> selectList(String prf_no){
		con = getConnection();
		
		ArrayList<Achievement> list = pfDAO .selectList(con, prf_no);
		
		close(con);
		
		return list;		
	}

	public ArrayList<Achievement> selectSemester(String pf_no, int year, int smt) {
		con = getConnection();
		
		ArrayList<Achievement> list = pfDAO .selectSmt(con, pf_no,year,smt);
		
		close(con);
		
		return list;		
	}

	public ArrayList<Achievement> stuManage(String classNo, int year, int semester) {
		con = getConnection();
		
		ArrayList<Achievement> list = pfDAO.stuManage(con, classNo, year, semester);
		
		close(con);
		
		return list;
	}

	public int stuCount(String classNo, int year, int semester) {
		con = getConnection();
		
		int result = pfDAO.stuCount(con, classNo, year, semester);
		
		close(con);
		
		return result;
	}

	public Achievement selectClass(String classNo, int year, int semester) {
		con = getConnection();
		
		Achievement result = pfDAO.selectClass(con, classNo, year, semester);
		
		close(con);
		
		return result;
	}
}
