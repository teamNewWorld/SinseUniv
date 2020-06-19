package com.kh.semiProject.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.board.model.service.BoardService;
import com.kh.semiProject.board.model.vo.Board;
import com.kh.semiProject.notice.model.service.NoticeService;
import com.kh.semiProject.notice.model.vo.Notice;


@WebServlet("/bUpView.bo")
public class BoardUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardUpdateViewServlet() {   super();    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		Board b = new BoardService().updateView(bno);
		
		String page = null;
		
		if(b != null) {
					request.setAttribute("board", b);
					page = "views/board/boardUpdate.jsp";
		} else {
				 	request.setAttribute("error-msg", "게시판 수정페이지 이동 실패!");
				 	page = "views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
