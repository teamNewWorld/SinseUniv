package com.kh.semiProject.board.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.kh.semiProject.board.model.service.BoardService;
import com.kh.semiProject.board.model.vo.Board;


@WebServlet("/bUpdate.bo")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardUpdateServlet() {    super();   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content").replace("\n", "<br>");
		
	
		BoardService bs = new BoardService();
		
		Board b = bs.selectOne(bno);
		
		b.setBcontent(content);
		b.setBtitle(title);
	
		System.out.println(bno);
		
		int result = new BoardService().updateBoard(b);
		
		if (result > 0) {
			
			response.sendRedirect("main.do");
			
		} else {
			
			request.setAttribute("msg", "공지사항 수정 실패!!");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			.forward(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
