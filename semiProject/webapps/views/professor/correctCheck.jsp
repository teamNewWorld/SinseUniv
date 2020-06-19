<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semiProject.member.model.vo.*"%>
<%
	Professor p = (Professor) session.getAttribute("professor");
	String sname = (String)request.getParameter("stuName");
	String dept = (String)request.getParameter("dept");
	String point = (String)request.getParameter("point");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적정정 여부</title>
<script src="/semiProject/resources/js/jquery-3.5.1.min.js"></script>
<link
	href="/semiProject/resources/assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/semiProject/resources/css/stuInfo.css" rel="stylesheet">
<style>
#button {
	text-align: center;
}
</style>
</head>
<body>
	<div id="stuInfo">
		<%
			if (p.getProImage() != null) {
		%>
		<img
			src="<%=request.getContextPath()%>/resources/memberImageFiles/<%=p.getProImage()%>"
			id="userPicture" alt="사용자사진" class="rounded-circle">
		<%
			} else {
		%>
		<img id="userPicture" src="/semiProject/resources/images/usericon.png"
			alt="사용자사진">
		<%
			}
		%>
		<h4 id="myName">
			<%= p.getDeptName() %> /
			<%=p.getProfessorName()%></h4>
	</div>
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th>과목명</th>
					<th>학생명</th>
					<th>성적</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=dept%></td>
					<td><%=sname %></td>
					<td><%=point %></td>
				</tr>
				<tr>
					<td>성적 수정</td>
					<td colspan="2"><select>
							<option value="A+">A+</option>
							<option value="A">A</option>
							<option value="B+">B+</option>
							<option value="B">B</option>
							<option value="C+">C+</option>
							<option value="C">C</option>
							<option value="D+">D+</option>
							<option value="D">D</option>
							<option value="F">F</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="3">정정 선택이유</td>
				</tr>
				<tr>
					<td colspan="3"><textarea id="CorrectReason" cols="50"
							rows="20" placeholder="여기에 이유를 작성해주세요"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
	<br>
	<div id="button">
		<button class="btn btn-primary" id="correctSubmit"
			onclick="alert('지금은 성적 정정 기간이 아닙니다.');">수정하기</button>
		&nbsp;
		<button class="btn btn-secondary" id="correctCancel"
			onclick="cancel();">수정취소</button>
	</div>

</body>
</html>