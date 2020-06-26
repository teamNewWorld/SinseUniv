package com.kh.semiProject.professor.model.dao;

import static com.kh.semiProject.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semiProject.professor.model.vo.Achievement;
import com.kh.semiProject.professor.model.vo.ClsPlan;
import com.kh.semiProject.professor.model.vo.ProfessorClass;

public class ProfessorDAO {
	private Properties prop;
	
	public ProfessorDAO() {
		prop = new Properties();

		String filePath =ProfessorDAO.class
				.getResource("/config/professor.properties")
				.getPath();
		try {

			prop.load(new FileReader(filePath));

		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Achievement> selectList(Connection con, String prf_no) {
		ArrayList<Achievement> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllclass");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, prf_no);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Achievement>();
			
			while(rset.next()) {
				Achievement ac = new Achievement();
				
				ac.setYear(rset.getInt("YEAR"));
				ac.setSemester(rset.getInt("SEMESTER"));
				ac.setCls_no(rset.getString("CLASS_NO"));
				ac.setCls_name(rset.getString("CLASS_NAME"));
				ac.setCapacity(rset.getInt("MEM_NUM"));
				ac.setAverage(rset.getInt("AVERAGE"));
				
				
				list.add(ac);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Achievement> selectSmt(Connection con, String prf_no, int year, int smt) {
		ArrayList<Achievement> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSemester");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, prf_no);
			pstmt.setInt(2, year);
			pstmt.setInt(3, smt);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Achievement>();
			
			while(rset.next()) {
				Achievement ac = new Achievement();
				
				ac.setYear(rset.getInt("YEAR"));
				ac.setSemester(rset.getInt("SEMESTER"));
				ac.setCls_no(rset.getString("CLASS_NO"));
				ac.setCls_name(rset.getString("CLASS_NAME"));
				ac.setCapacity(rset.getInt("MEM_NUM"));
				ac.setAverage(rset.getInt("AVERAGE"));
				
				
				list.add(ac);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Achievement> stuManage(Connection con, String classNo, int year, int semester) {
		ArrayList<Achievement> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectStudent");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, classNo);
			pstmt.setInt(2, year);
			pstmt.setInt(3, semester);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Achievement>();
			
			while(rset.next()) {
			
				Achievement am = new Achievement();
				
				am.setStudentNo(rset.getString("STUDENT_NO"));
				am.setName(rset.getString("NAME"));
				am.setDeptName(rset.getString("DEPT_NAME"));
				am.setPhone(rset.getString("PHONE"));
				am.setEmail(rset.getString("EMAIL"));
				am.setPoint(rset.getDouble("POINT"));
				am.setYear(year);
				am.setCls_name(rset.getString("class_name"));
				am.setCls_type(rset.getString("class_type"));
				am.setCls_no(classNo);
				am.setSemester(semester);
				am.setAverage(rset.getInt("average"));

			
				list.add(am);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int stuCount(Connection con, String classNo, int year, int semester) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("countStudent");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, classNo);
			pstmt.setInt(2, year);
			pstmt.setInt(3, semester);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public Achievement selectClass(Connection con, String classNo, int year, int semester) {
		Achievement result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectClass");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, classNo);
			pstmt.setInt(2, year);
			pstmt.setInt(3, semester);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = new Achievement();
			result.setCls_no(rset.getString("class_no"));
			result.setCls_name(rset.getString("class_name"));
			result.setDeptName(rset.getString("dept_name"));
			result.setCls_type(rset.getString("class_type"));
			result.setAverage(rset.getInt("average"));
			result.setYear(year);
			result.setSemester(semester);
			
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public ClsPlan selectOneClass(Connection con, String classNo, int year) {
		ClsPlan result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOneClass");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, classNo);
			pstmt.setInt(2, year);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = new ClsPlan();
			result.setCls_no(rset.getString("cls_no"));
			result.setCls_name(rset.getString("class_name"));
			result.setCls_type(rset.getString("class_type"));
			result.setGoal(rset.getString("goal"));
			result.setBook(rset.getString("book"));
			result.setpGrade(rset.getString("p_grade"));
			result.setpGrade2(rset.getString("p_grade2"));
			result.setpPlan(rset.getString("p_plan"));
			result.setEtc(rset.getString("etc"));
			result.setCheat(rset.getString("cheat"));
			result.setYear(year);
			
			
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateClsPlan(Connection con, ClsPlan cp) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateClsPlan");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cp.getGoal());
			pstmt.setString(2, cp.getBook());
			pstmt.setString(3, cp.getpGrade());
			pstmt.setString(4, cp.getpGrade2());
			pstmt.setString(5, cp.getpPlan());
			pstmt.setString(6, cp.getEtc());
			pstmt.setString(7, cp.getCheat());
			pstmt.setString(8, cp.getCls_no());
			pstmt.setInt(9, cp.getYear());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	public int insertClsPlan(Connection con, ClsPlan cp) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertClsPlan");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cp.getCls_no());
			pstmt.setInt(2, cp.getYear());
			pstmt.setString(3, cp.getGoal());
			pstmt.setString(4, cp.getBook());
			pstmt.setString(5, cp.getpGrade());
			pstmt.setString(6, cp.getpGrade2());
			pstmt.setString(7, cp.getpPlan());
			pstmt.setString(8, cp.getEtc());
			pstmt.setString(9, cp.getCheat());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			close(pstmt);
			
		}

		
		return result;
	}

}








