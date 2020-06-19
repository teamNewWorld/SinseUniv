package com.kh.semiProject.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.semiProject.common.JDBCTemplate.*;

import com.kh.semiProject.member.exception.MemberException;
import com.kh.semiProject.member.model.dao.MemberDAO;
import com.kh.semiProject.member.model.vo.Professor;
import com.kh.semiProject.member.model.vo.Student;

public class MemberDAO {

	// SQL을 별도로 보관하는 Properties 객체 생성하기
	private Properties prop;

	public MemberDAO() {
		prop = new Properties();

		String filePath = MemberDAO.class.getResource("/config/member.properties").getPath();

		try {
			prop.load(new FileReader(filePath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public Student selectStuMember(Connection con, Student s) throws MemberException {

		// 1. 사용할 변수 선언

		Student result = null; // 결과를 담을 객체
		PreparedStatement pstmt = null; // 쿼리 실행할 객체
		ResultSet rset = null; // Select 결과를 받아 올 객체

		// 프로퍼티 수정해야합니다
		// DB에 설정한 값으로
		String sql = prop.getProperty("selectStudent");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, s.getStudentNo());
			pstmt.setString(2, s.getStudentPwd());

			rset = pstmt.executeQuery();

			System.out.println("result 조회 전 : " + result);

			if (rset.next()) {
				result = new Student();

				result.setStudentNo(s.getStudentNo());
				result.setProfessorNo(rset.getString("PROFESSOR_NO"));
				result.setDeptNo(rset.getString("DEPT_NO"));
				result.setName(rset.getString("NAME"));
				result.setGender(rset.getString("GENDER"));
				result.setStudentSsn(rset.getString("STUDENT_SSN"));
				result.setPhone(rset.getString("phone"));
				result.setEmail(rset.getString("email"));
				result.setAddress(rset.getString("address"));
				result.setGraduateYn(rset.getString("graduate_yn"));
				result.setAbsenceYn(rset.getString("ABSENCE_YN"));
				result.setReturnYn(rset.getString("return_yn"));
				result.setTotalPoint(rset.getInt("totalpoint"));
				result.setCurrentPoint(rset.getInt("currentpoint"));
				result.setStudentPwd(s.getStudentPwd());
				result.setImage(rset.getString("image"));
				result.setDeptName(rset.getString("dept_name"));
				result.setCategory(rset.getString("category"));
				result.setOpenYn(rset.getString("open_yn"));
				result.setMemNum(rset.getInt("mem_num"));
				result.setProfessorName(rset.getString("PRO_NAME"));
				result.setProfessorSsn(rset.getString("PROFESSOR_SSN"));
				result.setProAddress(rset.getString("PRO_ADDRESS"));
				result.setProfessorPwd(rset.getString("PROFESSOR_PWD"));
				result.setProPhone(rset.getString("PRO_PHONE"));
				result.setProEmail(rset.getString("PRO_EMAIL"));
				result.setProImage(rset.getString("PRO_IMAGE"));
			}

			System.out.println("result 조회 후 : " + result);

		} catch (SQLException e) {

			e.printStackTrace();

			throw new MemberException(" [DAO 에러 발생] : " + e.getMessage());

		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public Professor selectProMember(Connection con, Professor p) throws MemberException {
		// 1. 사용할 변수 선언

		Professor result = null; // 결과를 담을 객체
		PreparedStatement pstmt = null; // 쿼리 실행할 객체
		ResultSet rset = null; // Select 결과를 받아 올 객체

		// 프로퍼티 수정해야합니다
		// DB에 설정한 값으로
		String sql = prop.getProperty("selectProfessor");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, p.getProfessorNo());
			pstmt.setString(2, p.getProfessorPwd());

			rset = pstmt.executeQuery();

			System.out.println("result 조회 전 : " + result);

			if (rset.next()) {

				result = new Professor();

				result.setProfessorNo(p.getProfessorNo());
				result.setProfessorPwd(p.getProfessorPwd());
				result.setProfessorName(rset.getString("pro_name"));
				result.setProfessorSsn(rset.getString("professor_ssn"));
				result.setProAddress(rset.getString("pro_address"));
				result.setDeptNo(rset.getString("dept_no"));
				result.setProEmail(rset.getString("pro_email"));
				result.setProPhone(rset.getString("pro_phone"));
				result.setProImage(rset.getString("pro_image"));
				result.setDeptName(rset.getString("dept_name"));
				result.setCategory(rset.getString("category"));
				result.setOpenYn(rset.getString("open_yn"));
				result.setMemNum(rset.getInt("mem_num"));
			}

			System.out.println("result 조회 후 : " + result);

		} catch (SQLException e) {

			e.printStackTrace();

			throw new MemberException(" [DAO 에러 발생] : " + e.getMessage());

		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public Student checkStuMember(Connection con, Student s) throws MemberException {

		// 1. 사용할 변수 선언

		Student result = null; // 결과를 담을 객체
		PreparedStatement pstmt = null; // 쿼리 실행할 객체
		ResultSet rset = null; // Select 결과를 받아 올 객체

		// 프로퍼티 수정해야합니다
		// DB에 설정한 값으로
		String sql = prop.getProperty("checkStudent");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, s.getStudentNo());

			rset = pstmt.executeQuery();

			System.out.println("result 조회 전 : " + result);

			if (rset.next()) {
				result = new Student();

				result.setStudentNo(s.getStudentNo());
				result.setStudentPwd(rset.getString("STUDENT_PWD"));
				result.setProfessorNo(rset.getString("PROFESSOR_NO"));
				result.setDeptNo(rset.getString("DEPT_NO"));
				result.setName(rset.getString("NAME"));
				result.setGender(rset.getString("GENDER"));
				result.setStudentSsn(rset.getString("STUDENT_SSN"));
				result.setEmail(rset.getString("email"));
				result.setPhone(rset.getString("phone"));
				result.setAddress(rset.getString("address"));
				result.setTotalPoint(rset.getInt("totalpoint"));
				result.setCurrentPoint(rset.getInt("currentpoint"));

			}

			System.out.println("result 조회 후 : " + result);

		} catch (SQLException e) {

			e.printStackTrace();

			throw new MemberException(" [DAO 에러 발생] : " + e.getMessage());

		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public Professor checkProMember(Connection con, Professor p) throws MemberException {
		// 1. 사용할 변수 선언

		Professor result = null; // 결과를 담을 객체
		PreparedStatement pstmt = null; // 쿼리 실행할 객체
		ResultSet rset = null; // Select 결과를 받아 올 객체

		// 프로퍼티 수정해야합니다
		// DB에 설정한 값으로
		String sql = prop.getProperty("checkProfessor");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, p.getProfessorNo());

			rset = pstmt.executeQuery();

			System.out.println("result 조회 전 : " + result);

			if (rset.next()) {

				result = new Professor();

				result.setProfessorNo(p.getProfessorNo());
				result.setProfessorPwd(rset.getString("PROFESSOR_PWD"));
				result.setProfessorName(rset.getString("pro_name"));
				result.setProfessorSsn(rset.getString("professor_ssn"));
				result.setProAddress(rset.getString("pro_address"));
				result.setDeptNo(rset.getString("dept_no"));
				result.setProEmail(rset.getString("pro_email"));
				result.setProPhone(rset.getString("pro_phone"));
			}

			System.out.println("result 조회 후 : " + result);

		} catch (SQLException e) {

			e.printStackTrace();

			throw new MemberException(" [DAO 에러 발생] : " + e.getMessage());

		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int updateStudent(Connection con, Student s) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateStudent");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, s.getStudentPwd());
			pstmt.setString(2, s.getPhone());
			pstmt.setString(3, s.getEmail());
			pstmt.setString(4, s.getAddress());
			pstmt.setString(5, s.getImage());
			pstmt.setString(6, s.getStudentNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			throw new MemberException("[DAO 에러 발생] : " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateProfessor(Connection con, Professor p) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateProfessor");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, p.getProfessorPwd());
			pstmt.setString(2, p.getProPhone());
			pstmt.setString(3, p.getProEmail());
			pstmt.setString(4, p.getProAddress());
			pstmt.setString(5, p.getProImage());
			pstmt.setString(6, p.getProfessorNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			throw new MemberException("[DAO 에러 발생] : " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return result;
	}
}
