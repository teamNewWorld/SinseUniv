package com.kh.semiProject.counsel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.counsel.model.service.CounselService;
import com.kh.semiProject.counsel.model.vo.Counsel;


@WebServlet("/cUpdate.co")
public class CounselUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CounselUpdateServlet() {    super();     }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		
		try {
			
			response.sendRedirect("selectList.co");
			
			int result = 0;
			
			result = new CounselService().updateCounsel(cno);
			
			response.setContentType("apllication/json; charset=utf-8"); 
			response.getWriter().print(result);
		
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("msg", "공지사항 수정 실패!!");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
