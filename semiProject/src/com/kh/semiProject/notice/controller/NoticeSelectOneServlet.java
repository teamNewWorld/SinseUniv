package com.kh.semiProject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.notice.model.service.NoticeService;
import com.kh.semiProject.notice.model.vo.Notice;

import jdk.nashorn.api.scripting.NashornException;


@WebServlet("/selectOne.no")
public class NoticeSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 2121L;
       

    public NoticeSelectOneServlet() {   super();  }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항의 글 번호를 받아
		// 해당 게시글을 상세 보기하는 화면으로
		// 이동하는 서블릿
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		NoticeService ns = new NoticeService();
		
		String page = null;
		
		try {
			Notice n = ns.selectOne(nno);
			request.setAttribute("notice", n);
			page = "views/notice/noticeDetail.jsp";
			
		} catch(NashornException e) {
			
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공지사항 상세보기 실패");
			page = "/views/common/errorPage.jsp";
			
		} finally {
			request.getRequestDispatcher(page).forward(request, response);			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
