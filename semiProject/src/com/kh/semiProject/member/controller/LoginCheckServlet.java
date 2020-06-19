package com.kh.semiProject.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.member.exception.MemberException;
import com.kh.semiProject.member.model.service.MemberService;
import com.kh.semiProject.member.model.vo.Professor;
import com.kh.semiProject.member.model.vo.Student;


@WebServlet("/loginCheck.do")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginCheckServlet() {    super();    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginType = request.getParameter("loginType");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		MemberService ms = new MemberService();
		int result = 0;
		try {
			if(loginType.equals("stu")) {
				// 학생일 때
				Student s = new Student();
				s.setStudentNo(userId);
				
				s = ms.checkStuMember(s);
				if(s == null) {
					// 해당 학생 없음 
					result = 0;
				} else if(!s.getStudentPwd().equals(userPwd)) {
					// 비밀번호 틀림
					result = 1;
				} else {
					result = 2;
				}
			} else {
				// 교수일 때
				Professor p = new Professor();
				p.setProfessorNo(userId);
				
				p = ms.checkProMember(p);
				if(p == null) {
					// 해당 교수 없음 
					result = 0;
				} else if(!p.getProfessorPwd().equals(userPwd)) {
					// 비밀번호 틀림
					result = 1;
				} else {
					result = 2;
				}
			}
		} catch (MemberException e) {
			result = -1;
			e.printStackTrace();
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(result);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
