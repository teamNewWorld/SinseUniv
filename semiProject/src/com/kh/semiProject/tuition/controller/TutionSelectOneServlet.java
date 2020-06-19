package com.kh.semiProject.tuition.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiProject.tuition.model.service.TutionService;
import com.kh.semiProject.tuition.model.vo.Tution;
import com.kh.semiProject.tuition.model.vo.TutionPrint;


@WebServlet("/selectOne.to")
public class TutionSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 9998L;
       

    public TutionSelectOneServlet() {   super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("enrolldate");
		
		System.out.println("날짜 값 확인 : " + date);
		
		Date EnrollDate = new Date(new GregorianCalendar().getTimeInMillis());
	
		if(date != null && ! date.equals("")) {
		// 2020-05-26 --> 2020, 05, 26
		String[] dateArr = date.split("-");
		int[] intArr = new int[dateArr.length];
		
		for(int i = 0 ; i < dateArr.length ; i++) {
			intArr[i] = Integer.parseInt(dateArr[i]);
		}
		
		// writeDate = new Date(intArr[0], intArr[1] -1, intArr[2]);
		EnrollDate = new Date(new GregorianCalendar(
								intArr[0], intArr[1] - 1, intArr[2]
					).getTimeInMillis());
	
		}
		
		HttpSession session = request.getSession();
		
		String Stu = (String) session.getAttribute("studentNo");
		
		TutionService ts = new TutionService();
		
		String page = null;
		
		System.out.println(EnrollDate);
		System.out.println(Stu);
		
		try {
			TutionPrint tp = ts.seletOne(EnrollDate, Stu);
			request.setAttribute("tutionprint", tp);
			page="views/print/billimg.jsp";
			
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공지사항 상세보기 실패");
			page = "views/common/errorPage.jsp";

			} finally {
				
				request.getRequestDispatcher(page).forward(request, response);
				
			}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
