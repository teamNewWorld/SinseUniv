package com.kh.semiProject.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semiProject.board.model.dao.BoardDAO;
import com.kh.semiProject.board.model.vo.Board;

import static com.kh.semiProject.common.JDBCTemplate.*;

public class BoardService {
			private Connection con;
			private BoardDAO bDAO = new BoardDAO();
			
		public int getListCount() {
				con = getConnection();
				
				int result = bDAO.getListCount(con);
				
				
				
				close(con);

				return result;
		}

		public ArrayList<Board> selectList(int currentPage, int limit) {
			con = getConnection();
			
			ArrayList<Board> blist = bDAO.selectList(con, currentPage, limit);
			
			close(con);

			return blist;
		}

		public int insertBoard(Board b) {
			con = getConnection();
			int result = bDAO.insertBoard(con, b);
			
			if(result > 0) commit(con);
			else rollback(con);
			
			close(con);
			
			return result;
		}

		public Board selectOne(int bno) {
			con = getConnection();
			Board b = bDAO.selectOne(con, bno);
			
			
			close(con);
			return b;
		}

		public Board updateView(int bno) {
			con = getConnection();
			
			Board b = bDAO.selectOne(con, bno);
			
			close(con);
			
			return b;
		}

		public int updateBoard(Board b) {
			
			con = getConnection();
			
			int result = bDAO.updateNotice(con, b);
			
			if(result > 0) commit(con);
			else rollback(con);
			
			close(con);
			
			return result;
		
		}

		public int deleteBoard(int bno) {
			con = getConnection();
			
			int result = bDAO.deleteBoard(con, bno);
			
			if(result > 0) commit(con);
			else rollback(con);
			
			close(con);
			
			return result;
			}

		public ArrayList<Board> selectTop5() {
			con = getConnection();
			
			ArrayList<Board> blist = bDAO.selectTop5(con);
			
			close(con);
			
			return blist;
		}
}
