<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.semiProject.professor.model.vo.*"%>
<%@ include file="../common/header.jsp"%>
<% ArrayList<ProfessorClass> list = (ArrayList<ProfessorClass>)request.getAttribute("list"); %>
<!-- ============================================================== -->
<!-- Start Page Content -->
<!-- ============================================================== -->
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
				%>
				<h4 id="myName">
					<%= p.getDeptName() %> /
					<%=p.getProfessorName()%></h4>
			</div>
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
								<th>인원</th>
								<th>수업일</th>
								<th>강의계획서</th>
								<th>수강생관리</th>
							</tr>
						</thead>
						<tbody>
						<% for(ProfessorClass pfc : list){ %>
							<tr>
								<td>
								<input type="hidden" id="pfcYear" name="pfcYear" value="<%= pfc.getYear()%>">
								<%= pfc.getYear()%>
								</td>
								<td>
								<input type="hidden" id="pfcSemester" name="pfcSemester" value="<%= pfc.getSemester() %>">
								<%= pfc.getSemester() %>
								</td>
								<td>
								<input type="hidden" id="pfcClsNo" name="pfcClsNo" value="<%= pfc.getCls_no()%>">
								<%= pfc.getCls_no() %>
								</td>
								<td>
								<input type="hidden" id="pfcClsName" name="pfcClsName" value="<%= pfc.getCls_name() %>">
								<%= pfc.getCls_name() %>
								</td>
								<td>
								<input type="hidden" id="pfcCapacity" name="pfcCapacity" value="<%= pfc.getCapacity() %>">
								<%= pfc.getCapacity() %>
								</td>
								<td>
								<input type="hidden" id="pfcDays" name="pfcDays" value="<%= pfc.getDays() %>">
								<%= pfc.getDays() %>
								</td>
								<td><input type="button" class="btn btn-primary"
									value="계획수정"></td>
								<td><input type="button" class="btn btn-danger" id="setGrade"
									value="성적부과"></td>
							</tr>
							<% } %>
						</tbody>
					</table>
						<% } else { %>
						 <div class="table table-bordered">
                                	<p align = "center">해당 학기에 이수한 내역이 없습니다.</p>
                                </div>
                     <% } %>
					<div class="clearfix"></div>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ============================================================== -->
<!-- End PAge Content -->
<!-- ============================================================== -->
<script>
	function showGrade(e) {
		$($(this).val()).style.display = "block";
	}
	 $(function(){
		 
		 $('#ysearch').click(function(){
			 var yy = $('#year').val();
			 var smt = $('#semester').val();
			 
			 location.href="<%=request.getContextPath()%>/pfssmt.do?pno=<%=p.getProfessorNo()%>&year="+yy+"&smt="+smt;
		 });
		 
		 $('.btn-danger').click(function(){
			 var pfcYear = $(this).parent().siblings().eq(0).children().val();
			 var pfcSemester = $(this).parent().siblings().eq(1).children().val();
			 var pfcClsNo = $(this).parent().siblings().eq(2).children().val();
			location.href="/semiProject/pStuManage.do?pfcYear="+pfcYear+"&pfcSemester="+pfcSemester+"&pfcClsNo="+pfcClsNo;

		 });
		 
		 $('.btn-primary').click(function(){
			 var pfcYear = $(this).parent().siblings().eq(0).children().val();
			 var pfcSemester = $(this).parent().siblings().eq(1).children().val();
			 var pfcClsNo = $(this).parent().siblings().eq(2).children().val();
			location.href="/semiProject/pClsPlan.do?pfcYear="+pfcYear+"&pfcSemester="+pfcSemester+"&pfcClsNo="+pfcClsNo;

		 });
		 
	 });

</script>
<%@ include file="../common/footer.jsp" %>


