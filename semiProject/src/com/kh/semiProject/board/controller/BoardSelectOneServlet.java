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
import com.kh.semiProject.boardComment.model.service.BoardCommentService;
import com.kh.semiProject.boardComment.model.vo.BoardComment;


@WebServlet("/selectOne.bo")
public class BoardSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardSelectOneServlet() {    super();    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int bno = Integer.parseInt(request.getParameter("bno"));
				
				Board b = new BoardService().selectOne(bno);
				ArrayList<BoardComment> clist = new BoardCommentService().selectList(bno);
				
				String page = " ";
				
				if(b != null) {
					request.setAttribute("board", b);
					request.setAttribute("clist", clist);
					page = "views/board/boardDetail.jsp";
				} else {
					request.setAttribute("error-msg", "게시글 상세보기 실패!");
					page = "views/common/errorPage.jsp";
				}
				
				request.getRequestDispatcher(page).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);	}

}
