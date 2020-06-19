package com.kh.semiProject.find.model.service;

import static com.kh.semiProject.common.JDBCTemplate.close;
import static com.kh.semiProject.common.JDBCTemplate.commit;
import static com.kh.semiProject.common.JDBCTemplate.getConnection;
import static com.kh.semiProject.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.ResultSet;

import com.kh.semiProject.find.model.dao.FindIdDAO;
import com.kh.semiProject.find.model.vo.FindId;

public class FindIdService {
	private FindIdDAO fDAO = new FindIdDAO();
	private Connection con;
	
	public String findStuId(String name, String ssn1, String ssn2)  {
		con = getConnection();
		
		String result = fDAO.findStuId(con, name, ssn1, ssn2);
		
		close(con);
		
		return result;
	}

	public String findProId(String name, String ssn1, String ssn2) {
		con = getConnection();
		
		String result = fDAO.findProId(con,  name, ssn1, ssn2);
		
		close(con);
		
		return result;
		
	}

	public int setStuPwd(String stuId, String pwd) {
		con = getConnection();
		
		int result = fDAO.setStuPwd(con, stuId, pwd);
		
		if(result > 0 )commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int setProPwd(String proId, String pwd) {
		con = getConnection();
		
		int result = fDAO.setProPwd(con, proId, pwd);
		
		if(result > 0 )commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

}
