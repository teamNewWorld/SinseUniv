package com.kh.semiProject.professor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.professor.model.service.ProfessorService;
import com.kh.semiProject.professor.model.vo.Achievement;
import com.kh.semiProject.professor.model.vo.ClsPlan;

/**
 * Servlet implementation class PfsClassPlanServlet
 */
@WebServlet("/pClsPlan.do")
public class PfsClassPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfsClassPlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Achievement a = new Achievement();
		ClsPlan cp = new ClsPlan();
		String page = "";
		
		int year = Integer.parseInt(request.getParameter("pfcYear"));
		int semester = Integer.parseInt(request.getParameter("pfcSemester"));
		String classNo = request.getParameter("pfcClsNo");
		
		ProfessorService pfs = new ProfessorService();
		
		cp = pfs.selectOneClass(classNo, year);
		request.setAttribute("ClsPlan", cp);
		
		a = pfs.selectClass(classNo, year, semester);
		request.setAttribute("Achievement", a);
		
		page = "views/professor/classPlan.jsp";
		
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
