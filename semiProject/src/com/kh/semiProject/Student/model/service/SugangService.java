package com.kh.semiProject.Student.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semiProject.Student.model.dao.SugangDAO;
import com.kh.semiProject.Student.model.vo.Achievement;
import com.kh.semiProject.Student.model.vo.Sugang;
import static com.kh.semiProject.common.JDBCTemplate.*;


public class SugangService {

	private SugangDAO sgDAO = new SugangDAO();
	private Connection con;
	
	public ArrayList<Sugang> selectList(String stu_no){
		con = getConnection();
		
		ArrayList<Sugang> list = sgDAO.selectList(con, stu_no);
		
		close(con);
		
		return list;		
	}
	public ArrayList<Sugang> selectSemester(String stu_no, int year, int smt){
		con = getConnection();
		
		ArrayList<Sugang> list =  sgDAO.selectSmt(con, stu_no, year, smt);
		
		close(con);
		
		return list;		
	}
	public Sugang selectClsPlan(String clsNo, int year) {
		con = getConnection();
		Sugang s = sgDAO.selectClsPlan(con, clsNo, year);
		
		close(con);

		return s;
	}
}
