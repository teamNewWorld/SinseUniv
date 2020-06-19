package com.kh.semiProject.counselComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.counselComment.model.service.CounselCommentService;
import com.kh.semiProject.counselComment.model.vo.CounselComment;

/**
 * Servlet implementation class CounselCommentInsertServlet
 */
@WebServlet("/ccInsert.co")
public class CounselCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounselCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		String ccwriter = request.getParameter("ccwriter");
		String cccontent = request.getParameter("cccontent");
		
		CounselComment cco = new CounselComment(cno, cccontent, ccwriter);
		
		int result = new CounselCommentService().insertCounselComment(cco);
		
		if( result > 0) {
			response.sendRedirect("selectOne.co?cno="+ cno);
		} else {
			request.setAttribute("error-msg", "댓글 추가 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
