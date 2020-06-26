package com.kh.semiProject.professor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.professor.model.service.ProfessorService;
import com.kh.semiProject.professor.model.vo.ClsPlan;

/**
 * Servlet implementation class PfsClsPlanInsertServlet
 */
@WebServlet("/cpInsert.do")
public class PfsClsPlanInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfsClsPlanInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goal = request.getParameter("goal");
		String book = request.getParameter("book");
		String pGrade = request.getParameter("test") +","
						+request.getParameter("hw") +","
						+request.getParameter("attendance") +","
						+request.getParameter("else");
		String pGrade2 = request.getParameter("pGrade2");
		String plan = request.getParameter("plan");
		String etc = request.getParameter("etc");
		String cheat = request.getParameter("cheat");
		String clsNo = request.getParameter("clsNo");
		int year = Integer.parseInt(request.getParameter("year"));
		
		String pno = request.getParameter("pno");
		
		ProfessorService pfs = new ProfessorService();
		
		ClsPlan cp = new ClsPlan();
		
		cp.setGoal(goal);
		cp.setBook(book);
		cp.setpGrade(pGrade);
		cp.setpGrade2(pGrade2);
		cp.setpPlan(plan);
		cp.setEtc(etc);
		cp.setCheat(cheat);
		cp.setCls_no(clsNo);
		cp.setYear(year);
		
		try {
			int result = pfs.insertClsPlan(cp);
			
			response.sendRedirect("pfclslist.do?pno="+pno);
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("msg", "강의계획서 추가 실패!!");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			.forward(request, response);
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
