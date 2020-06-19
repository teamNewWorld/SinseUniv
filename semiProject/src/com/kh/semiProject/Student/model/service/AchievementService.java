package com.kh.semiProject.Student.model.service;

import static com.kh.semiProject.common.JDBCTemplate.close;
import static com.kh.semiProject.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semiProject.Student.model.dao.AchvmentDAO;
import com.kh.semiProject.Student.model.vo.Achievement;
import com.kh.semiProject.Student.model.vo.Sugang;


public class AchievementService {

	private AchvmentDAO achvDAO = new AchvmentDAO();
	private Connection con;
	
	public ArrayList<Achievement> selectList(String stu_no){
		con = getConnection();
		
		ArrayList<Achievement> list = achvDAO.selectList(con, stu_no);
		
		close(con);
		
		return list;		
	}
	
	public ArrayList<Achievement> selectSemester(String stu_no, int year, int smt){
		con = getConnection();
		
		ArrayList<Achievement> list = achvDAO.selectSmt(con, stu_no, year, smt);
		
		close(con);
		
		return list;		
	}

	public int checkRating(String stuno, String clsno) {
		con = getConnection();
		int result = achvDAO.checkRat(con, stuno, clsno);
		close(con);
		
		return result;
	}

	public int checkClaim(String stuno, String clsno) {
		con = getConnection();
		int result = achvDAO.checkclm(con, stuno, clsno);
		close(con);
		
		return result;
	}
}
