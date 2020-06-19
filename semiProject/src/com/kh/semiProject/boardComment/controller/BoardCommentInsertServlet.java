package com.kh.semiProject.boardComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.boardComment.model.service.BoardCommentService;
import com.kh.semiProject.boardComment.model.vo.BoardComment;


@WebServlet("/insertComment.bo")
public class BoardCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardCommentInsertServlet() {   super();  }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 작성자, 게시글 번호, 댓글 내용
				// 만약 대댓글일 경우 참조하는 댓글의 번호
				// 대댓글인 지 대대댓글인지 구분하는 댓글 레벨
				
				String writer = request.getParameter("writer");
				int bno =Integer.parseInt(request.getParameter("bno"));
				String content = request.getParameter("replyContent");
				int refcno = Integer.parseInt(request.getParameter("refbcno"));
				int clevel = Integer.parseInt(request.getParameter("bclevel"));
				
				BoardComment bco
					= new BoardComment(bno, content, writer, refcno, clevel);
				
				int result = new BoardCommentService().insertComment(bco);
	
				if( result > 0) {
					response.sendRedirect("selectOne.bo?bno="+ bno);
				} else {
					request.setAttribute("error-msg", "댓글 추가 실패!");
					request.getRequestDispatcher("views/common/errorPage.jsp")
								.forward(request, response);
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
