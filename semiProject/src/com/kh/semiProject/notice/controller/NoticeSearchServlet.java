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


@WebServlet("/searchNotice.no")
public class NoticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 2222L;
       

    public NoticeSearchServlet() {    super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 검색 카테고리
		String condition = request.getParameter("con");
		// 검색 키워드
		String keyword = request.getParameter("keyword");
		
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		NoticeService ns = new NoticeService();
		
		String page = "";
		
		try {
			// 조회 성공!
			list = ns.searchNotice(condition, keyword);
			request.setAttribute("list", list);
			page = "views/main.jsp";
			
		} catch(NashornException e) {
			
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공지사항 검색 실패!");
			page = "views/common/errorPage.jsp";
			
		} finally {
			request.getRequestDispatcher(page).forward(request, response);			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
