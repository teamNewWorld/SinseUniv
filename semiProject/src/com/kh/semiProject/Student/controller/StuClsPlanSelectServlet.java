package com.kh.semiProject.Student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiProject.Student.model.service.SugangService;
import com.kh.semiProject.Student.model.vo.Sugang;

/**
 * Servlet implementation class StuClsPlanSelectServlet
 */
@WebServlet("/stClsPlan.do")
public class StuClsPlanSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuClsPlanSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clsNo = request.getParameter("clsNo");
		int year = Integer.parseInt(request.getParameter("year"));

		SugangService sgs = new SugangService();
		
		Sugang su = sgs.selectClsPlan(clsNo, year);
		
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		if(su != null) {
			session.setAttribute("sugang", su);
			out.println("<script language='javascript'>window.open('/semiProject/views/student/stClassPlan.jsp','강의계획서','width=650,height=700,scrollbars=yes');history.go(-1);</script>");
			//out.print("<script language='javascript'>history.go(-1);</script>" );
			System.out.println("servlet su : " + su);
		} else {
			out.print("<script language='javascript'>alert('등록된 강의계획서가 없습니다.');history.go(-1);</script>" );

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
