package com.kh.semiProject.find.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiProject.find.model.service.FindIdService;
import com.kh.semiProject.find.model.vo.FindId;
import com.kh.semiProject.member.model.vo.Student;

import jdk.nashorn.api.scripting.NashornException;

/**
 * Servlet implementation class FindStuIdServlet
 */
@WebServlet("/FindId.do")
public class FindStuIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindStuIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		String type = request.getParameter("type");
		String ssn1 = request.getParameter("userNum1");
		String ssn2 = request.getParameter("userNum2");
		
		FindId f = new FindId();
		
		f.setName(name);
		f.setSsn1(ssn1);
		f.setSsn2(ssn2);
		
		String page = null;
		
		FindIdService fis = new FindIdService();
		
		try {
			
			if(type.equals("stu")) {
				String f1=fis.findStuId(name, ssn1, ssn2);
				request.setAttribute("findStuId", f1);
				page = "views/findId.jsp";
				
				
			} else {
				String f2=fis.findProId(name, ssn1, ssn2);
				request.setAttribute("findProId", f2);
				page = "views/findId.jsp";

			}
			
			
		} catch (NashornException e) {
			request.setAttribute("exception", e);
			request.setAttribute("msg", "아이디 찾기 실패!!");
			page = "views/common/errorPage.jsp";
		} finally {
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
