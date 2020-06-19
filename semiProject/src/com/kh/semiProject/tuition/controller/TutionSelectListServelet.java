package com.kh.semiProject.tuition.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiProject.member.model.vo.Professor;
import com.kh.semiProject.member.model.vo.Student;
import com.kh.semiProject.salary.model.service.SalaryService;
import com.kh.semiProject.salary.model.vo.Salary;
import com.kh.semiProject.tuition.model.service.TutionService;
import com.kh.semiProject.tuition.model.vo.Tution;
import com.kh.semiProject.tuition.model.vo.TutionPrint;


@WebServlet("/tSelect.do")
public class TutionSelectListServelet extends HttpServlet {
	private static final long serialVersionUID = 12222222L;
       

    public TutionSelectListServelet() {    super();   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			ArrayList<TutionPrint> list = new ArrayList<TutionPrint>();
			
			TutionService ts = new TutionService();
			
			HttpSession session = request.getSession();
			
			String sno = (String) session.getAttribute("studentNo");
			
			list = ts.selectList(sno);
			
			String page = null;
			
			if(list != null) {
				request.setAttribute("list", list);
				page = "views/print/billPrint.jsp";
			} else {
				request.setAttribute("error-msg", "공지사항 목록 조회 실패");
				page = "views/common/errorPage.jsp";
			}
			
			request.getRequestDispatcher(page).forward(request, response);

		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
