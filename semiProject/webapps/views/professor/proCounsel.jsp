<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상담 신청</title>
</head>
<body>
	<div class="row">
		<!-- column -->
		<div class="col-lg-12">
			<div class="card">

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
					<img id="userPicture"
						src="/semiProject/resources/images/usericon.png" alt="사용자사진">
					<%
						}
					%>용자사진">
					<h4 id="myName">컴퓨터공학과 / 유정훈</h4>
				</div>
				<div class="card-block">
					<hr />
					<div class="table-responsive">
						<table class="table" id="mytable">
							<thead id="tableHead">
								<tr>
									<th>No.</th>
									<th>StuNo</th>
									<th>Name</th>
									<th style="width: 200px;">Title</th>
									<th>Date</th>
									<th>State</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>20001123</td>
									<td>김개똥</td>
									<td>상담 신청합니다.</td>
									<td>2020/06/08</td>
									<td><button type="button" class="btn btn-primary"
											id="counselState" align="center" onclick="changeBtn">처리완료</button></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		function changeBtn() {
			$(this).attr('disabled', true);
		}
	</script>

</body>
</html>
<%@ include file="../common/footer.jsp"%>