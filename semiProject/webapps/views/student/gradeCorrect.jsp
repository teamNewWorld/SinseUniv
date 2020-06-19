<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semiProject.member.model.vo.*"%>
<%
	Student s = (Student) session.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적정정 신청서</title>
<script src="/semiProject/resources/js/jquery-3.5.1.min.js"></script>
<link
	href="/semiProject/resources/assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/semiProject/resources/css/stuInfo.css" rel="stylesheet">
</head>
<style>
#button {
	text-align: center;
}
</style>
<body>

	<div id="stuInfo">
		<%
			if (s.getImage() != null) {
		%>
		<img
			src="<%=request.getContextPath()%>/resources/memberImageFiles/<%=s.getImage()%>"
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
			<%= s.getDeptName() %> /
			<%=s.getName()%></h4>
	</div>



	<div class="table-responsive">
		<table id="Correcttable" class="table table-bordered">
			<thead>
				<tr>
					<th>과목명</th>
					<th>담당교수</th>
					<th>성적</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>데이터베이스</td>
					<td>유정훈</td>
					<td>B+</td>
				</tr>
				<tr>
					<td colspan="3">정정 신청사유</td>
				</tr>
				<tr>
					<td colspan="3"><textarea id="CorrectReason" cols="70"
							rows="20" placeholder="여기에 사유를 적어주세요"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
	<br>

	<div id="button">
		<button class="btn btn-primary" id="gradeSubmit"
			onclick="return gradesubmit();">정정신청</button>
		&nbsp;
		<button class="btn btn-secondary" id="gradeCancel" onclick="cancel();">작성내용
			취소</button>
	</div>

	<script>
		function cancel() {
			var check = window.confirm('정말 종료하시겠습니까? 작성 내용은 저장되지 않습니다.');
			if (check) {
				window.close();
			}
		}

		function gradesubmit() {
			var check = window.confirm('이대로 제출하시겠습니까? 제출 후 수정은 불가능합니다.');
			if (check) {
				window.close();
				;
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>











