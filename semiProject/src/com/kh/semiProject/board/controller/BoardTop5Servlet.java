package com.kh.semiProject.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semiProject.board.model.service.BoardService;
import com.kh.semiProject.board.model.vo.Board;


@WebServlet("/top5.do")
public class BoardTop5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardTop5Servlet() {  super();  }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		BoardService bs = new BoardService();
		ArrayList<Board> list = bs.selectTop5();
		
		response.setContentType("application/json; charset=utf-8");
	
		new Gson().toJson(list, response.getWriter());
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
