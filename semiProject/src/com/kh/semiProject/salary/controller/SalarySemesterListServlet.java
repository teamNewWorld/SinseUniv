package com.kh.semiProject.salary.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiProject.salary.model.service.SalaryService;
import com.kh.semiProject.salary.model.vo.Salary;

/**
 * Servlet implementation class SalarySemesterListServlet
 */
@WebServlet("/sSemester.do")
public class SalarySemesterListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalarySemesterListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ArrayList<Salary> list = new ArrayList<Salary>();
		
		SalaryService ss = new SalaryService();
		
		HttpSession session = request.getSession();
		
		String pno = (String) session.getAttribute("professorNo");
		int year = Integer.parseInt((request.getParameter("year")));
		int smt = Integer.parseInt((request.getParameter("smt")));
		
		list = ss.selectSemester(pno,year,smt);
		
		String page = null;
		
		if(list != null) {
			request.setAttribute("list", list);
			page = "views/professor/salaryPrint.jsp";
		} else {
			request.setAttribute("error-msg", "공지사항 목록 조회 실패");
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
