package com.kh.semiProject.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiProject.member.exception.MemberException;
import com.kh.semiProject.member.model.service.MemberService;
import com.kh.semiProject.member.model.vo.Professor;
import com.kh.semiProject.member.model.vo.Student;
import com.kh.semiProject.salary.model.service.SalaryService;
import com.kh.semiProject.tuition.model.service.TutionService;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {   super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 정보 받아오기
		String userNo = request.getParameter("userId");
		String loginType = request.getParameter("loginType");
		String userPwd = request.getParameter("userPwd");
		String originPwd = (String)request.getAttribute("originPwd");
		
		System.out.println("원본 비밀번호 : " + originPwd);
		System.out.println("암호화 비밀번호 : " + userPwd);
		
		// 3. 회원 정보를 담아 데이터베이스와 비교하기
		MemberService ms = new MemberService();
		SalaryService sas = new SalaryService();
		TutionService ts = new TutionService();
		
		HttpSession session = request.getSession();
		
		String errorMsg = "";
		try {
			if(loginType.equals("stu")) {
				// 학생일 때
				errorMsg = "학생 로그인 실패했쇼";
				
				System.out.println("학생 로그인 확인");
				Student s = new Student(userNo, userPwd);				
				String s3 = userNo;
				
				s = ms.selectStuMember(s);
				session.setAttribute("student", s);
				
				s3 = ts.selectStuList(s3);
				session.setAttribute("studentNo", s3);
				
			
				
			} else {
				// 교수일 때
				errorMsg = "교수 로그인 실패했쇼";
				
				System.out.println("교수 로그인 확인");
				Professor p = new Professor(userNo, userPwd);
				String p3 = userNo;
				p = ms.selectProMember(p);
				session.setAttribute("professor", p);
				
				p3 = sas.selectProList(p3);
				session.setAttribute("professorNo", p3);
			}
		
			response.sendRedirect("main.do");
			
		} catch(MemberException e) {
			
			// 학생용 로그인 실패!
			
			request.setAttribute("error-msg", errorMsg);
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
