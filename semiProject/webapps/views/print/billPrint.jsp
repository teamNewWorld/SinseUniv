<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semiProject.tuition.model.vo.*"%>

<%@ include file = "../common/header.jsp" %>

<% ArrayList<TutionPrint> list = (ArrayList<TutionPrint>)request.getAttribute("list"); %>

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
        				<option value="2020" onclick="showGrade(this);">2020년</option>
        				<option value="2019" onclick="showGrade(this);">2019년</option>
        				<option value="2018" onclick="showGrade(this);">2018년</option>
        				<option value="2017" onclick="showGrade(this);">2017년</option>
        				<option value="2016" onclick="showGrade(this);">2016년</option>
        				<option value="2015" onclick="showGrade(this);">2015년</option>
        				<option value="2014" onclick="showGrade(this);">2014년</option>
        				<option value="2013" onclick="showGrade(this);">2013년</option>
        				<option value="2012" onclick="showGrade(this);">2012년</option>
        			</select>
        			<select name="semester" id="semester">
        				<option value="01" onclick="showGrade(this);">1학기</option>
        				<option value="02" onclick="showGrade(this);">2학기</option>
        			</select>
					<button id="ysearch" onclick="billsearch"><img src="/semiProject/resources/images/search.png" alt="검색" /></button>
			
				</div>
			    <div class="card-block">
				<hr />
                	<div class="table-responsive">
                    	<table class="table" id="mytable">
                        	<thead id="tableHead">
                            	<tr>
                        	 		<th>구분</th>
                         			<th>등록금</th>
                         			<th>장학내역</th>
                         			<th>실지불액</th>
                         			<th>등록여부</th>
                         			<th>납부고지서 출력</th>
                         		</tr>
                            </thead>
								<% if(list.size() != 0) {%>
                            <tbody>
                            	<% for(TutionPrint tp : list) { %>                            	
								<tr>
			                        <td><%=tp.getEnrolldate() %></td>
			                        <td><%=tp.getEnrollmoney() %></td>
			                        <td><%=tp.getPrice() %></td>
			                        <td><%=tp.getScholarshipprice() %></td>
			                        <td><%=tp.getEnrollyn() %></td>
			                        <td><button type="button" class="btn btn-primary"
			                        onclick="window.open('/semiProject/selectOne.to?enrolldate=<%=tp.getEnrolldate()%>&studentNo=<%=s.getStudentNo()%>'
			                        		,'등록금고지서','width=500,height=700,scrollbars=yes');return false">출 력</button></td>
                     			</tr>
								<% } %>
                         	 </tbody>
                     			<% } else { %>
					                      	<tr>
					                      		<td colspan=6>
					                      			<p> 등록금 내역이없습니다. 행정부로 연락해주세요</p>
					                      		</td>
					                      	</tr>
					             <% } %>
                       </table>
                       <div class="clearfix"></div>
               		   <ul class="pagination pull-right">
                 			<button type="button" class="btn btn-primary"  onclick="window.open('http://certpia.com/')">증명서 발급 바로가기</button>
                 	   </ul>
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
		$('#billsearch').on('click', function(){
			
	});
		 $('#ysearch').click(function(){
			 var yy = $('#year').val();
			 var smt = $('#semester').val();
			 
			 location.href="<%=request.getContextPath()%>/tSemester.do?sno=<%=s.getStudentNo()%>&year="+yy+"&smt="+smt;
		 });
		 
	});

</script>
<%@ include file = "../common/footer.jsp" %>

