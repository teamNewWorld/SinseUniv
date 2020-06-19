package com.kh.semiProject.counsel.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.counsel.model.service.CounselService;
import com.kh.semiProject.counsel.model.vo.Counsel;


@WebServlet("/cInsert.co")
public class CounselInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CounselInsertServlet() {    super();     }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctitle = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content").replace("\n", "<br>");
		String counselCategory = request.getParameter("counselCategory");
		String email=request.getParameter("email");
		String studentProNo = request.getParameter("studentProNo");
		String studentNo = request.getParameter("userId");
		String date = request.getParameter("date");
		String onOff = request.getParameter("onoff");
		
		System.out.println("날짜 값 확인 : " + date);
		Date writeDate = new Date(new GregorianCalendar().getTimeInMillis());
		
		if(date != null && ! date.equals("")) {
			// 2020-05-26 --> 2020, 05, 26
			String[] dateArr = date.split("-");
			int[] intArr = new int[dateArr.length];
			
			for(int i = 0 ; i < dateArr.length ; i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
			}
			
			// writeDate = new Date(intArr[0], intArr[1] -1, intArr[2]);
			writeDate = new Date(new GregorianCalendar(
									intArr[0], intArr[1] - 1, intArr[2]
						).getTimeInMillis());
		}
		
		Counsel c = new Counsel();
		
		c.setCtitle(ctitle);
		c.setCwriter(writer);
		c.setCcontent(content);
		c.setCtype(counselCategory);
		c.setCdate(writeDate);
		c.setCemail(email);
		c.setStudentNo(studentNo);
		c.setProfessorNo(studentProNo);
		c.setOnOff(onOff);

		CounselService cs = new CounselService();
		
		
		try {
			 cs.insertCounsel(c);
			response.sendRedirect("selectList.co"); // 다른 서블릿으로 보냄
		
		} catch(IOException e) {
			
			request.setAttribute("error-msg", "상담 등록 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp")
					.forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
