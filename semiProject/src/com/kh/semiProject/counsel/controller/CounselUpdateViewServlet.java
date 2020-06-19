package com.kh.semiProject.counsel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.counsel.model.service.CounselService;
import com.kh.semiProject.counsel.model.vo.Counsel;


@WebServlet("/cUpView.co")
public class CounselUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CounselUpdateViewServlet() {   super();    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		Counsel c = new CounselService().updateView(cno);
		
		System.out.println(c);
		
		String page ="";
		
		if(c != null) {
			request.setAttribute("counsel", c);
			page = "views/counsel/counselUpdate.jsp";
		} else {
			
			request.setAttribute("error-msg", "상담 수정 페이지 이동 실패");
			page = "views/common/errorPage.jsp";
			
		}
		
			request.getRequestDispatcher(page).forward(request, response);
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
