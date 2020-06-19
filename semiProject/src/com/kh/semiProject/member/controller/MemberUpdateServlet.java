package com.kh.semiProject.member.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.semiProject.member.exception.MemberException;
import com.kh.semiProject.member.model.service.MemberService;
import com.kh.semiProject.member.model.vo.Professor;
import com.kh.semiProject.member.model.vo.Student;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int maxSize = 1024 * 1024 * 10; // 10MB;

		if(! ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("error-msg", 
					             "multipart로 전송되지 않았습니다.");
			
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		}
		
		String root = request.getServletContext().getRealPath("/");
		String savePath = root + "resources/memberImageFiles";
		
		MultipartRequest mre = new MultipartRequest(
				request, // 속성 변경을 위한 원본 객체
				savePath, // 저장할 파일 경로
				maxSize, // 저장할 파일 최대 크기
				"UTF-8", // 저장할 문자셋
				new DefaultFileRenamePolicy()
		);
		
		String userId = mre.getParameter("userId");
		String userPwd = getSHA512(mre.getParameter("userPwd"));
		String email = mre.getParameter("email");

		String phone = mre.getParameter("tel1") 
				 + mre.getParameter("tel2") 
				 + mre.getParameter("tel3");
		
		String address = mre.getParameter("zipCode") + ", "
			     + mre.getParameter("address1") + ", "
			     + mre.getParameter("address2");
		
		String fileName = mre.getFilesystemName("userImg");
		
		HttpSession session = request.getSession(false);
		
		MemberService ms = new MemberService();
		
		Student s = (Student)session.getAttribute("student");
		Professor p = (Professor)session.getAttribute("professor");
		
			
		try {
			if(s != null) {
				
				s.setStudentNo(userId);
				s.setStudentPwd(userPwd);
				s.setAddress(address);
				s.setPhone(phone);
				s.setEmail(email);
				
				if(fileName != null && fileName.length() > 0) {

					if(s.getImage() != null) {
						// 만약 이전 파일이 있었다면 삭제
						File originFile = new File(savePath+"/"+s.getImage());
						System.out.println("파일 삭제 확인 : " + originFile.delete());
					}
					
					s.setImage(fileName);
				}
				System.out.println("변경한 회원 정보 확인 : " + s);
			
				ms.updateStudent(s);
				
				System.out.println("학생 정보 변경 성공!");
			
			} else if (p!=null) {
				p.setProfessorNo(userId);
				p.setProfessorPwd(userPwd);
				p.setProAddress(address);
				p.setProPhone(phone);
				p.setProEmail(email);
				
				if(fileName != null && fileName.length() > 0) {

					if(p.getProImage() != null) {
						// 만약 이전 파일이 있었다면 삭제
						File originFile = new File(savePath+"/"+p.getProImage());
						System.out.println("파일 삭제 확인 : " + originFile.delete());
					}
					
					p.setProImage(fileName);
				}
				
				System.out.println("변경한 회원 정보 확인 : " + p);
				
				ms.updateProfessor(p);
				
				System.out.println("교수 정보 변경 성공!");
				
			}
			
			
			response.sendRedirect("main.do");
		
		} catch(MemberException e) {

			request.setAttribute("error-msg", "회원정보변경실패");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// 암호화를 위한 SHA512 메소드 작성
	private static String getSHA512(String pwd) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			
			return Base64.getEncoder().encodeToString(md.digest());
			
		} catch (NoSuchAlgorithmException e) {
			
			System.out.println("암호화 에러 발생!");
			e.printStackTrace();
			
			return null;
		}
	}

}
