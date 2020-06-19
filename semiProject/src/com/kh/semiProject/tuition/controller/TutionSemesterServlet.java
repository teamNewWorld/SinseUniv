package com.kh.semiProject.tuition.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiProject.tuition.model.service.TutionService;
import com.kh.semiProject.tuition.model.vo.TutionPrint;

/**
 * Servlet implementation class TutionSemesterServlet
 */
@WebServlet("/tSemester.do")
public class TutionSemesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutionSemesterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TutionPrint> list = new ArrayList<TutionPrint>();
		
		TutionService ts = new TutionService();
		
		HttpSession session = request.getSession();
		
		String sno = (String) session.getAttribute("studentNo");
		int year = Integer.parseInt((request.getParameter("year")));
		int smt = Integer.parseInt((request.getParameter("smt")));
		
		list = ts.semesterList(sno, year, smt);
		
		String page = null;
		
		if(list != null) {
			request.setAttribute("list", list);
			page = "views/print/billPrint.jsp";
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
