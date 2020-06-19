package com.kh.semiProject.absence.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiProject.absence.model.service.AbsenceService;
import com.kh.semiProject.absence.model.vo.Absence;

import jdk.nashorn.api.scripting.NashornException;


@WebServlet("/selectList.ao")
public class AbsenceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AbsenceListServlet() {    super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 공지사항 글 여러 개를 DB에서 조회하여
				// 목록 형태로 (ArrayList) 데이터를 전달하는 서블릿
				
				ArrayList<Absence> list = new ArrayList<Absence>();
				
				AbsenceService as = new AbsenceService();
				
				HttpSession session = request.getSession();
				
				String sno = (String) session.getAttribute("studentNo");
				
				String page = null;
				
				list = as.selectList(sno);
				
				System.out.println("되나?"  + list);
				try {
					request.setAttribute("list", list);
					page = "views/student/registerChange.jsp";
					
				} catch(NashornException e) {
					
					request.setAttribute("exception", e);
					request.setAttribute("error-msg", "공지사항 목록 조회 실패");
					page = "views/common/errorPage.jsp";
					
				} finally {
					request.getRequestDispatcher(page).forward(request, response);			
				}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
