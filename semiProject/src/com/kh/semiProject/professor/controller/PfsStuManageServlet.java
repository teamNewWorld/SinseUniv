package com.kh.semiProject.professor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.professor.model.service.ProfessorService;
import com.kh.semiProject.professor.model.vo.Achievement;
import com.kh.semiProject.professor.model.vo.ProfessorClass;

import jdk.nashorn.api.scripting.NashornException;

/**
 * Servlet implementation class PfsStuManageService
 */
@WebServlet("/pStuManage.do")
public class PfsStuManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfsStuManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Achievement> list = new ArrayList<Achievement>();
		Achievement a = new Achievement();
		String page = "";
		
		int year = Integer.parseInt(request.getParameter("pfcYear"));
		int semester = Integer.parseInt(request.getParameter("pfcSemester"));
		String classNo = request.getParameter("pfcClsNo");
		// String className = request.getParameter("pfcClsName");
		// int capacity = Integer.parseInt(request.getParameter("pfcCapacity"));
		// int days = Integer.parseInt(request.getParameter("pfcDays"));
		
		ProfessorService pfs = new ProfessorService();
		
		System.out.println(year + classNo);
		
		list=pfs.stuManage(classNo, year, semester);
		request.setAttribute("list", list);
		
		int cnt = pfs.stuCount(classNo, year, semester);
		request.setAttribute("cnt", cnt);
		
		a = pfs.selectClass(classNo, year, semester);
		request.setAttribute("Achievement", a);
		
		page = "views/professor/stuGradeCheck.jsp";
		
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
