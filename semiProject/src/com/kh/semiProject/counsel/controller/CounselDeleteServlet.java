package com.kh.semiProject.counsel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.counsel.model.service.CounselService;


@WebServlet("/cDelete.co")
public class CounselDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CounselDeleteServlet() {    super();  }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		CounselService cs = new CounselService();
		
		try {
			cs.deleteCounsel(cno);
			response.sendRedirect("selectList.co");
		
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공지사항 삭제 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		}
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
