package com.kh.semiProject.salary.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.salary.model.service.SalaryService;
import com.kh.semiProject.salary.model.vo.Salary;


@WebServlet("/selectOne.so")
public class SalarySelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SalarySelectOneServlet() {   super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String date = request.getParameter("amountdate");
		
			System.out.println("날짜 값 확인 : " + date);
			
			Date SalaryDate = new Date(new GregorianCalendar().getTimeInMillis());
		
			if(date != null && ! date.equals("")) {
			// 2020-05-26 --> 2020, 05, 26
			String[] dateArr = date.split("-");
			int[] intArr = new int[dateArr.length];
			
			for(int i = 0 ; i < dateArr.length ; i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
			}
			
			// writeDate = new Date(intArr[0], intArr[1] -1, intArr[2]);
			SalaryDate = new Date(new GregorianCalendar(
									intArr[0], intArr[1] - 1, intArr[2]
						).getTimeInMillis());
		
			}
			

			
			SalaryService ss = new SalaryService();
			
			String page = null;
			
			System.out.println(SalaryDate);
			
			try {
				Salary s = ss.selectOne(SalaryDate);
				request.setAttribute("salary", s);
				page= "views/professor/salarybillPrint.jsp";
				
				
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
