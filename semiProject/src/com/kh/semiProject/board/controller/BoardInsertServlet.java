package com.kh.semiProject.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.semiProject.board.model.service.BoardService;
import com.kh.semiProject.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/bInsert.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardInsertServlet() {    super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String title = request.getParameter("title");
			String content = request.getParameter("content").replace("\n", "<br>");
			String writer = request.getParameter("userId");
			
			Board b = new Board(title, content, writer);
			
			int result = new BoardService().insertBoard(b);
			
			if ( result > 0) {
				response.sendRedirect("main.do");
			} else {
				request.setAttribute("error-msg", "게시글 작성 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsg")
							.forward(request, response);
			}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
