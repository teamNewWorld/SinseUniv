package com.kh.semiProject.find.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.find.model.service.FindIdService;
import com.kh.semiProject.member.model.vo.Professor;
import com.kh.semiProject.member.model.vo.Student;

import jdk.nashorn.api.scripting.NashornException;

/**
 * Servlet implementation class SetPwdServlet
 */
@WebServlet("/pwdSet.do")
public class SetPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String type = request.getParameter("type");
		String pwd = request.getParameter("pwd");
		
		Student s = new Student();
		Professor p = new Professor();
		
		if(type.equals("stu")) s.setStudentNo(userId);
		else p.setProfessorNo(userId);
		
		String page = null;
		
		FindIdService fis = new FindIdService();
		int result = 0;
		try {
			
			if(type.equals("stu")) {
				result = fis.setStuPwd(userId, pwd);
			} else {
				result =fis.setProPwd(userId, pwd);
			}
			
			response.getWriter().print(result);
		} catch (NashornException e) {
			request.setAttribute("exception", e);
			request.setAttribute("msg", "아이디 찾기 실패!!");
			page = "views/common/errorPage.jsp";
			
			request.getRequestDispatcher(page)
			.forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
