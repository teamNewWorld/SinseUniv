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

import jdk.nashorn.api.scripting.NashornException;

/**
 * Servlet implementation class PfsClassListServlet
 */
@WebServlet("/pfclslist.do")
public class PfsClassListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfsClassListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Achievement> list = new ArrayList<Achievement>();
		String page = null;
		String pf_no = request.getParameter("pno");
		
		ProfessorService pfs = new ProfessorService();
		
		try {
		list = pfs.selectList(pf_no);
		request.setAttribute("list", list);
		page = "views/professor/professorClass.jsp";
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
