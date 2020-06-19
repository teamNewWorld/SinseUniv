package com.kh.semiProject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.notice.model.service.NoticeService;
import com.kh.semiProject.notice.model.vo.Notice;


@WebServlet("/nUpdate.no")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 2020L;
       
  
    public NoticeUpdateServlet() {    super();    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content").replace("\n", "<br>");
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		Notice n = new Notice();
		
		n.setNno(nno);
		n.setNcontent(content);
		n.setNtitle(title);
		
		try {
			new NoticeService().updateNotice(n);
			response.sendRedirect("main.do");
		} catch (IOException e) {
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
