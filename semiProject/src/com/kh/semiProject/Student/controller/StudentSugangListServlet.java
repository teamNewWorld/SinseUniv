package com.kh.semiProject.Student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.Student.model.service.SugangService;
import com.kh.semiProject.Student.model.vo.Sugang;

import jdk.nashorn.api.scripting.NashornException;

/**
 * Servlet implementation class StudentSugangListServlet
 */
@WebServlet("/ssglist.do")
public class StudentSugangListServlet extends HttpServlet {
	private static final long serialVersionUID = 1032L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSugangListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Sugang> list = new ArrayList<Sugang>();
		String page = null;
		String stu_no = request.getParameter("sno");
		
		SugangService sgs = new SugangService();
		
		try {
		list = sgs.selectList(stu_no);
		request.setAttribute("list", list);
		page = "views/student/studentClass.jsp";
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
