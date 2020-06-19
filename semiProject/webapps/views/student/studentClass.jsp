<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.semiProject.Student.model.vo.*"%>

<%@ include file="../common/header.jsp"%>

<% ArrayList<Sugang> list = (ArrayList<Sugang>)request.getAttribute("list"); %>

<!-- ============================================================== -->
<!-- Start Page Content -->
<!-- ============================================================== -->
<div class="row">
	<!-- column -->
	<div class="col-lg-12">
		<div class="card">

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

			<div id="searchDateArea">
				<select name="year" id="year">
					<option value="2020"  id= "syear" >2020년</option>
					<option value="2019"  id = "syear" >2019년</option>
					<option value="2018"  id = "syear">2018년</option>
					<option value="2017"  id= "syear">2017년</option>
					<option value="2016"  id= "syear" >2016년</option>
					<option value="2015"  id = "syear" >2015년</option>
					<option value="2014"  id = "syear" >2014년</option>
					<option value="2013"  id = "syear" >2013년</option>
					<option value="2012"  id= "syear" >2012년</option>
				</select> <select name="semester" id="semester">
					<option value="01" id ="smt" >1학기</option>
					<option value="02" id ="smt" >2학기</option>
				</select>
				<button id="ysearch" >
					<img src="/semiProject/resources/images/search.png" alt="검색" />
				</button>

			</div>
			<div class="card-block">
				<hr />
				<div class="table-responsive">
				<% if(list.size()>0) { %>
					<table class="table" id="mytable">
						<thead id="tableHead">
							<tr>
								<th>이수년도</th>
								<th>학기</th>
								<th>학수번호</th>
								<th>과목명</th>
								<th>등급</th>
								<th>평점</th>
								<th>재수강</th>
							</tr>
						</thead>
						<tbody>
							<% for(Sugang sg : list){ %>
							<tr>
								<td><%= sg.getYear()%></td>
								<td><%= sg.getSemester() %></td>
								<td><%= sg.getCls_no() %></td>
								<td><%= sg.getCls_name() %></td>
								<td><%= sg.getGrade() %></td>
								<td><%= sg.getScore() %></td>
								<td><%= sg.getRetake() %></td>
							</tr>
							<% } %>
						</tbody>
					</table>
					<% } else { %>
					     <div class="table table-bordered">
                                	<p align = "center">해당 학기에 이수한 내역이 없습니다.</p>
                                </div>
                     <% } %>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- ============================================================== -->
<!-- End PAge Content -->
<!-- ============================================================== -->
<script>

 $(function(){
	 
	 $('#ysearch').click(function(){
		 var yy = $('#year').val();
		 var smt = $('#semester').val();
		 
		 location.href="<%=request.getContextPath()%>/sgsmt.do?sno=<%=s.getStudentNo()%>&year="+yy+"&smt="+smt;
	 });
	 
 });
</script>
<%@ include file="../common/footer.jsp"%>