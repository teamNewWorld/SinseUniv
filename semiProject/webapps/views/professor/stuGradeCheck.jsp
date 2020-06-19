<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.semiProject.professor.model.vo.*"%>
<%@ include file="../common/header.jsp"%>
<%
ArrayList<Achievement> list = (ArrayList<Achievement>)request.getAttribute("list");
Achievement a = (Achievement)request.getAttribute("Achievement");
int cnt = (int)request.getAttribute("cnt");

%>
<!-- ============================================================== -->
<!-- Start Page Content -->
<!-- ============================================================== -->
<div class="row">
	<!-- column -->
	<div class="col-lg-12">
		<div class="card">
			<br>
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
				%>
				<h4 id="myName">
					<%= p.getDeptName() %>
					/
					<%=p.getProfessorName()%></h4>
			</div>
			<br /> <br />

			<div id="searchDateArea">
				<select name="year" id="year">
					<option value="2020" onclick="showGrade(this);">2020년</option>
					<option value="2019" onclick="showGrade(this);">2019년</option>
					<option value="2018" onclick="showGrade(this);">2018년</option>
					<option value="2017" onclick="showGrade(this);">2017년</option>
					<option value="2016" onclick="showGrade(this);">2016년</option>
					<option value="2015" onclick="showGrade(this);">2015년</option>
					<option value="2014" onclick="showGrade(this);">2014년</option>
					<option value="2013" onclick="showGrade(this);">2013년</option>
					<option value="2012" onclick="showGrade(this);">2012년</option>
				</select> <select name="semester" id="semester">
					<option value="01" onclick="showGrade(this);">1학기</option>
					<option value="02" onclick="showGrade(this);">2학기</option>
				</select>
				<button id="ysearch" onclick="billsearch">
					<img src="/semiProject/resources/images/search.png" alt="검색" />
				</button>

			</div>



			<div class="card-block">
				<div id="stuInfo">
					<img id="userPicture"
						src="/semiProject/resources/images/checkicon.png" alt="사용자사진">
					<h4 id="myName">수강생 관리</h4>
				</div>
				<div class="table-responsive">

					<table class="table" id="mytable">
						<thead id="tableHead">
							<tr>
								<th>학수번호</th>
								<th>과목명</th>
								<th>교수명</th>
								<th>이수학점</th>
								<th>개설학과</th>
								<th>이수구분</th>
								<th>인원</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><%= a.getCls_no() %></td>
								<td><%= a.getCls_name() %></td>
								<td><%= p.getProfessorName() %></td>
								<td><%= a.getAverage() %></td>
								<td><%= a.getDeptName() %></td>
								<td><%= a.getCls_type() %></td>
								<td><%= cnt %></td>
							</tr>
						</tbody>
					</table>

				</div>
			</div>
			<br /> <br /> <br />

			<div class="card-block">
				<hr />
				<div class="table-responsive">
					<table class="table" id="mytable">
						<thead id="tableHead">
							<tr>
								<th>학번</th>
								<th>이름</th>
								<th>학과</th>
								<th>연락처</th>
								<th>이메일</th>
								<th>수강구분</th>
								<th>학점</th>
								<th>결과수정</th>
							</tr>
						</thead>
						<tbody>
							<% if(list.size() > 0) { %>
							<% for(Achievement ac : list) { %>
							<tr>
								<td><%=ac.getStudentNo() %></td>
								<td><%= ac.getName() %></td>
								<td><%= ac.getDeptName() %></td>
								<td><%= ac.getPhone() %></td>
								<td><%= ac.getEmail() %></td>
								<td>이수</td>
								<td><%= ac.getPoint() %></td>
								<td><button type="button" class="btn btn-primary">성적정정</button></td>
							</tr>
							<% } } else {%>
							<tr>
								<td colspan=8>
									<p>해당 과목을 이수한 학생이 없습니다.</p>
								</td>
							</tr>
							<% } %>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ============================================================== -->
<!-- End PAge Content -->
<!-- ============================================================== -->
<script>
	$(function() {
		
		$('.btn-primary').click(function(){
			var sname = $(this).parent().parent().children().eq(1).html();
		
			var point = $(this).parent().parent().children().eq(6).html();
			console.log(sname);
			
			console.log(point);
		
			
	window.open("/semiProject/views/professor/correctCheck.jsp?stuName="+sname+"&dept=<%= a.getCls_name() %>&point="+point,'성적정정신청란','width=425,height=665,scrollbars=yes');
	return false;
		});
		
	});
</script>

<%@ include file="../common/footer.jsp"%>