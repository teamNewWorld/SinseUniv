package com.kh.semiProject.boardComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.boardComment.model.service.BoardCommentService;
import com.kh.semiProject.boardComment.model.vo.BoardComment;


@WebServlet("/updateComment.bo")
public class BoardCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardCommentUpdateServlet() {   super();  }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bcno = Integer.parseInt(request.getParameter("bcno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		String content = request.getParameter("content");
		
		BoardComment bco = new BoardComment();
		
		bco.setBcno(bcno);
		bco.setBccontent(content);
		
		int result = new BoardCommentService().updateComment(bco);
		
		if( result > 0) {
			response.sendRedirect("selectOne.bo?bno="+ bno);
		} else {
			request.setAttribute("error-msg", "댓글 추가 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		}
	
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
