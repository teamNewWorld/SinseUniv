package com.kh.semiProject.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.semiProject.board.model.service.BoardService;
import com.kh.semiProject.notice.model.service.NoticeService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/bDelete.bo")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardDeleteServlet() {    super();   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int bno = Integer.parseInt(request.getParameter("bno"));
				
				BoardService bs = new BoardService();
				
				int result = bs.deleteBoard(bno);
				
				if(result > 0) {
					response.sendRedirect("main.do");
				} else {
					request.setAttribute("error-msg", "게시글 삭제 실패");
					request.getRequestDispatcher("views/common/errorPage.jsp")
					       .forward(request, response);
				}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	}

}
