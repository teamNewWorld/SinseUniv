package com.kh.semiProject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.notice.model.service.NoticeService;
import com.kh.semiProject.notice.model.vo.Notice;


@WebServlet("/nUpView.no")
public class NoticeUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1919L;
       

    public NoticeUpdateViewServlet() {   super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		Notice n = new NoticeService().updateView(nno);
		
		String page = "";
		
		if(n != null) {
			request.setAttribute("notice", n);
			page = "views/notice/noticeUpdate.jsp";
		} else {
			request.setAttribute("error-msg", "게시글 수정 페이지 이동 실패");
			page = "views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
