package com.kh.semiProject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.semiProject.notice.model.service.NoticeService;


@WebServlet("/nDelete.no")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 10002L;
       

    public NoticeDeleteServlet() {  super();   }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		NoticeService ns = new NoticeService();
		
		try {
			ns.deleteNotice(nno);
			response.sendRedirect("main.do");
		} catch (IOException e) {
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
