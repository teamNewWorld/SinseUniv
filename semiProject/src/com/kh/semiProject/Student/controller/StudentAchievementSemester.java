package com.kh.semiProject.Student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.Student.model.service.AchievementService;
import com.kh.semiProject.Student.model.vo.Achievement;

import jdk.nashorn.api.scripting.NashornException;

/**
 * Servlet implementation class StudentAchievementSemester
 */
@WebServlet("/achsmt.do")
public class StudentAchievementSemester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAchievementSemester() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Achievement> list = new ArrayList<Achievement>();
		String page = null;
		String stu_no = request.getParameter("sno");
		int year = Integer.parseInt((request.getParameter("year")));
		int smt = Integer.parseInt((request.getParameter("smt")));
		
		AchievementService achs = new AchievementService();
		
		try {
		list = achs.selectSemester(stu_no, year, smt);
		request.setAttribute("list", list);
		page = "views/student/studentGrade.jsp";
		}
		catch(NashornException e) {
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "수강내역 조회 실패");
			page = "views/common/errorPage.jsp";
		}finally {
			request.getRequestDispatcher(page).forward(request, response);			
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
