package com.kh.semiProject.member.model.service;

import static com.kh.semiProject.common.JDBCTemplate.*;
import static com.kh.semiProject.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.semiProject.member.exception.MemberException;
import com.kh.semiProject.member.model.dao.MemberDAO;
import com.kh.semiProject.member.model.vo.Professor;
import com.kh.semiProject.member.model.vo.Student;

public class MemberService {
	
	private Connection con;
	private MemberDAO mDAO = new MemberDAO();
	
	public Student selectStuMember(Student s) throws MemberException {
		con = getConnection();
		
		Student result = mDAO.selectStuMember(con, s);
		
		close(con);
		
		if(result == null) throw new MemberException("[Service 에러] : " + "로그인 실패");
		
		return result;
	}

	public Professor selectProMember(Professor p) throws MemberException {
		con = getConnection();
		
		Professor result = mDAO.selectProMember(con, p);
		
		close(con);
		
		if(result == null) throw new MemberException("[Service 에러] : " + "로그인 실패");
		
		return result;
	}

	public Student checkStuMember(Student s) throws MemberException {
		con = getConnection();
		
		Student result = mDAO.checkStuMember(con, s);
		
		close(con);
		
		if(result == null) throw new MemberException("[Service 에러] : " + "로그인 실패");
		
		return result;
	}

	public Professor checkProMember(Professor p) throws MemberException {
		con = getConnection();
		
		Professor result = mDAO.checkProMember(con, p);
		
		close(con);
		
		if(result == null) throw new MemberException("[Service 에러] : " + "로그인 실패");
		
		return result;
	}

	public int updateStudent(Student s) throws MemberException {
		con = getConnection();
		
		int result = mDAO.updateStudent(con, s);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int updateProfessor(Professor p) throws MemberException {
		con = getConnection();
		
		int result = mDAO.updateProfessor(con, p);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	

}
