package com.kh.semiProject.counsel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiProject.boardComment.model.service.BoardCommentService;
import com.kh.semiProject.boardComment.model.vo.BoardComment;
import com.kh.semiProject.counsel.model.service.CounselService;
import com.kh.semiProject.counsel.model.vo.Counsel;
import com.kh.semiProject.counselComment.model.service.CounselCommentService;
import com.kh.semiProject.counselComment.model.vo.CounselComment;
import com.kh.semiProject.notice.model.service.NoticeService;
import com.kh.semiProject.notice.model.vo.Notice;

import jdk.nashorn.api.scripting.NashornException;


@WebServlet("/selectOne.co")
public class CounselSelectOneServlet extends HttpServlet {
   private static final long serialVersionUID = 4L;
       

    public CounselSelectOneServlet() {    super();  }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 공지사항의 글 번호를 받아
      // 해당 게시글을 상세 보기하는 화면으로
      // 이동하는 서블릿
            
            int cno = Integer.parseInt(request.getParameter("cno"));
            
            Counsel c = new CounselService().selectOne(cno);
            
            ArrayList<CounselComment> cclist = new CounselCommentService().selectList(cno);
            
            String page = null;
            
            if(c!=null) {
               
               request.setAttribute("counsel", c);
               request.setAttribute("cclist", cclist);
               page = "views/counsel/counselDetail.jsp";
               
            } else {

               request.setAttribute("error-msg", "상담 상세보기 실패");
               page = "/views/common/errorPage.jsp";
               
            } 
               request.getRequestDispatcher(page).forward(request, response);         
            
         
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGet(request, response);
   }

}