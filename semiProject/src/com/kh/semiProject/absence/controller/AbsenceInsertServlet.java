package com.kh.semiProject.absence.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.absence.model.service.AbsenceService;
import com.kh.semiProject.absence.model.vo.Absence;


@WebServlet("/aInsert.ao")
public class AbsenceInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AbsenceInsertServlet() {    super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // 휴학타입, 휴학내용, 휴학날짜, 복학날짜
		String sno = request.getParameter("studentno");
		String abstype = request.getParameter("abstype");
		String absreason = request.getParameter("absreason");
		
		
		// 신청일자
		String subdate = request.getParameter("subdate");
		System.out.println("날짜 값 확인 : " + subdate );
		Date writesubDate = new Date(new GregorianCalendar().getTimeInMillis());;
		
		if(subdate != null && !subdate.equals("")) {
		String[] dateArr1 = subdate.split("-");
		int[] intArr1 = new int[dateArr1.length];
		
		for(int i = 0 ; i < dateArr1.length ; i++) {
			intArr1[i] = Integer.parseInt(dateArr1[i]); 
		}
		
		writesubDate = new Date(new GregorianCalendar(
						intArr1[0], intArr1[1] -1, intArr1[2] -1).getTimeInMillis());
	}
		
		// 휴학시작일자
		String startdate = request.getParameter("startdate");
		System.out.println("날짜 값 확인 : " + startdate );
		Date writestartDate = new Date(new GregorianCalendar().getTimeInMillis());;
		
		if(startdate != null && !startdate.equals("")) {
		String[] dateArr2 = startdate.split("-");
		int[] intArr2 = new int[dateArr2.length];
		
		for(int i = 0 ; i < dateArr2.length ; i++) {
			intArr2[i] = Integer.parseInt(dateArr2[i]); 
		}
		
		writestartDate = new Date(new GregorianCalendar(
						intArr2[0], intArr2[1] -1, intArr2[2] -1).getTimeInMillis());
	}
		
		// 휴학의끝
		String enddate = request.getParameter("enddate");
		System.out.println("날짜 값 확인 : " + startdate );
		Date writeendDate = new Date(new GregorianCalendar().getTimeInMillis());;
				
		if(enddate != null && !enddate.equals("")) {
	    String[] dateArr3 = enddate.split("-");
		int[] intArr3 = new int[dateArr3.length];
				
		for(int i = 0 ; i < dateArr3.length ; i++) {
		intArr3[i] = Integer.parseInt(dateArr3[i]); 
		}
				
		writeendDate = new Date(new GregorianCalendar(
		intArr3[0], intArr3[1] -1, intArr3[2] -1).getTimeInMillis());
	}
		
	 Absence a = new Absence();
	
	a.setStudentno(sno);
	a.setAbstype(abstype);
	a.setSubdate(writesubDate);
	a.setStartdate(writestartDate);
	a.setEnddate(writeendDate);
	a.setReason(absreason);
	
	AbsenceService as = new AbsenceService();
		
	try {
				as.insertAbsence(a);
				response.sendRedirect("selectList.ao");
		   }   catch(Exception e) {
			   request.setAttribute("error-msg", "공지사항 등록 실패!");
			   request.getRequestDispatcher("views/common/errorPage.jsp")
						.forward(request, response);;
	     }
	}
	

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
