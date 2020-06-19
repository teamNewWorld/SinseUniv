package com.kh.semiProject.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiProject.board.model.service.BoardService;
import com.kh.semiProject.board.model.vo.Board;
import com.kh.semiProject.board.model.vo.PageInfo;
import com.kh.semiProject.member.model.vo.Student;
import com.kh.semiProject.notice.model.service.NoticeService;
import com.kh.semiProject.notice.model.vo.Notice;

import jdk.nashorn.api.scripting.NashornException;




@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public MainServlet() {   super();  }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항 글 여러 개를 DB에서 조회하여
			// 목록 형태로 (ArrayList) 데이터를 전달하는 서블릿
			ArrayList<Notice> list = new ArrayList<Notice>();
			ArrayList<Board> blist = new ArrayList<Board>();
			
			NoticeService ns = new NoticeService();
			BoardService bs = new BoardService();
			

			int startPage;
			int endPage;
			int maxPage;
			int currentPage;
			int limit;
			currentPage = 1;
			limit = 10;
			
			if(request.getParameter("currentPage") != null) {
				currentPage =
						Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int blistCount = bs.getListCount();

			maxPage = (int)((double)blistCount / limit + 0.9);
			startPage = ((int)((double)currentPage / limit +0.9) -1) * limit +1 ;
			endPage = startPage + limit -1;
			if( endPage > maxPage) {
				endPage = maxPage;
			}
			
			PageInfo pi = new PageInfo(currentPage, blistCount, limit,
					maxPage, startPage, endPage);
			
			String page = "";
			
			try {
				list = ns.selectList();
				blist = bs.selectList(currentPage, limit);
				request.setAttribute("list", list);
				request.setAttribute("blist",blist);
				request.setAttribute("pi", pi);
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
