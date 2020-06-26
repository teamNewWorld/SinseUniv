package com.kh.semiProject.Student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Sugang s = sgs.selectClsPlan(clsNo, year);
		
		String page = " ";
		
		if(s != null) {
			request.setAttribute("sugang", s);
			page = "views/student/stClassPlan.jsp";
		} else {
			request.setAttribute("error-msg", "게시글 상세보기 실패!");
			page = "views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
