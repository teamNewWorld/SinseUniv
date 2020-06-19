package com.kh.semiProject.salary.model.service;

import static com.kh.semiProject.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.kh.semiProject.member.model.vo.Professor;
import com.kh.semiProject.salary.model.dao.SalaryDAO;
import com.kh.semiProject.salary.model.vo.Salary;

public class SalaryService {

	private SalaryDAO sDAO = new SalaryDAO();
	private Connection con;
	
	public ArrayList<Salary> selectList(String professorNo) {
		con = getConnection();
		
		ArrayList<Salary> list = sDAO.selectList(con, professorNo);
		
		close(con);
		
		return list;
	}
	
	public String selectProList(String p3) {
		con = getConnection();
		String result = sDAO.selectProList(con, p3);
		
		close(con);
		
		return result;
	}

	public Salary selectOne(Date SalaryDate) {
		con = getConnection();
		
		Salary s = sDAO.selectOne(con, SalaryDate);
		
		close(con);
		
		return s;
		
	}

	public ArrayList<Salary> selectSemester(String pno, int year, int smt) {
con = getConnection();
		
		ArrayList<Salary> list = sDAO.selectSemester(con, pno, year, smt);
		
		close(con);
		
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
