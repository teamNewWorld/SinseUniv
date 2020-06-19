package com.kh.semiProject.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.board.model.service.BoardService;
import com.kh.semiProject.board.model.vo.Board;
import com.kh.semiProject.board.model.vo.PageInfo;


@WebServlet("/selectList.bo")
public class BoardSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardSelectListServlet() {   super();  }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 1. 게시판 목록 처리 서블릿
    			ArrayList<Board> blist = new ArrayList<Board>();
    			BoardService bs = new BoardService();
    			
    			// 페이징 처리에 필요한 변수들
    			int startPage;
    			
    			// 한 번에 처리할 페이지들 중
    			// 가장 마지막 페이지
    			int endPage;
    			
    			// 전체 페이지들 중 가장 끝 페이지
    			int maxPage;
    			
    			// 현재 사용자가 보고 있는 페이지
    			int currentPage;
    			
    			// 한 페이지 당 보여줄 게시글 수
    			int limit;
    			
    			// 처음 접속한 사용자가 볼 페이지 초기화하기
    			currentPage = 1;
    			
    			// 최대 게시글 10개씩
    			limit = 10;
    			
    			// 만약에 사용자가 현재 페이지 정보를
    			// 가지고 있다면 currentPage 정보 변경하기
    			if(request.getParameter("currentPage") != null) {
    				currentPage =
    						Integer.parseInt(request.getParameter("currentPage"));
    			}
    			
    			// 총 게시글 개수 가져오기
    			int blistCount = bs.getListCount();
    			
    			System.out.println("총 게시글 수 : " + blistCount );
    			
    			// 총 게시글 300개!
    			// 30 페이지
    			// 만약 전체 기시글 수가 13개라면 페이지수는 2
    			// ** 짜투리 게시글도 하나의 페이지를 만들어야한다.
    			// 게시글수 13 → 1.3 (올림) → 페이지 수 2 
    			// 게시글수 19 → 1.9 (올림) → 페이지 수 2
    			maxPage = (int)((double)blistCount / limit + 0.9);
    			
    			// 한번에 보일 시작 페이지와 끝 페이지 계산하기
    			// 1 ~ 10 : 1
    			// 11 ~ 20 : 11
    			startPage = ((int)((double)currentPage / limit +0.9) -1) * limit +1 ;
    			
    			// 끝 페이지
    			// 1 ~ 10 : 10
    			// 11 ~ 20 : 20
    			endPage = startPage + limit -1;
    			
    			// 만약 마지막 페이지가 전체 기준 페이지 보다
    			// 크다면, 즉 총 13개 페이지밖에 안나오는데 20까지 잡았다면
    			if( endPage > maxPage) {
    				endPage = maxPage;
    			}
    			
    			// -------페이지 처리는 끝
    			
    			blist = bs.selectList(currentPage, limit);
    			
    			String page = "";
    			
    			if( blist != null ) {
    				
    				PageInfo pi = new PageInfo(currentPage, blistCount, limit,
    															maxPage, startPage, endPage);
    				request.setAttribute("blist", blist);
    				request.setAttribute("pi", pi);
    				page = "views/main.jsp";
	
    			} else {
    				request.setAttribute("error-msg", "게시글 목록 조회 실패!");
    				page = "views/common/errorPage.jsp";
    			}
    			
    			request.getRequestDispatcher(page).forward(request, response);
 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
