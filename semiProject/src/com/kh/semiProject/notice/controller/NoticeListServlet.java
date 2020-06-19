package com.kh.semiProject.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.semiProject.notice.model.service.NoticeService;
import com.kh.semiProject.notice.model.vo.Notice;

import jdk.nashorn.api.scripting.NashornException;


@WebServlet("/selectList.no")
	public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1112L;
       
   
    public NoticeListServlet() {   super();    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항 글 여러 개를 DB에서 조회하여
		// 목록 형태로 (ArrayList) 데이터를 전달하는 서블릿
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		NoticeService ns = new NoticeService();
		
		String page = null;
		
		try {
			list = ns.selectList();
			request.setAttribute("list", list);
			page = "views/main.jsp";
			
		} catch(NashornException e) {
			
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공지사항 목록 조회 실패");
			page = "views/common/errorPage.jsp";
			
		} finally {
			request.getRequestDispatcher(page).forward(request, response);			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
