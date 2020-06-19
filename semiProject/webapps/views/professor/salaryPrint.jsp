<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semiProject.salary.model.vo.*"%>
<%@ include file = "../common/header.jsp" %>
<% ArrayList<Salary> list = (ArrayList<Salary>)request.getAttribute("list"); %>
<!-- ============================================================== -->
<!-- Start Page Content -->
<!-- ============================================================== -->
   <div class="row">
       <!-- column -->
          <div class="col-lg-12">
           <div class="card"> 

              <div id = "stuInfo">
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
                 <h4 id="myName"><%= p.getDeptName() %> / <%= p.getProfessorName() %></h4>
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
               <button id="ysearch" onclick="billsearch">
               <img src="/semiProject/resources/images/search.png" alt="검색" /></button>
         
            </div>
              
                 <div class="card-block">
                     <hr />
                                <div class="table-responsive">
                                    <table class="table" id="mytable">
                                        <thead id="tableHead">
                                            <tr>
                                                <th>수령년월</th>
                                          <th>구분</th>
                                          <th>총금액</th>
                                          <th>세금</th>
                                          <th>실수령액</th>
                                          <th>납부고지서 출력</th>
                                            </tr>
                                        </thead>
                                            <% if(list.size() > 0) { %>
                                        <tbody>

	                                        <% for(Salary sa : list) { %>
	                                            <tr>
						                         <td><%= sa.getAmountDate() %></td>
						                         <td>월급</td>
						                         <td><%= sa.getTotalAmount() %></td>
						                         <td><%= sa.getTax() %></td>
						                         <td><%= sa.getTotalAmount() - sa.getTax() %></td>
						                         <td><button type="button" class="btn btn-primary" align="center"
						                         onclick="window.open('/semiProject/selectOne.so?amountdate=<%= sa.getAmountDate() %>&professorNo=<%=p.getProfessorNo() %>',
						                         '월급명세표','width=550,height=740,scrollbars=yes');return false">출 력</button></td>
						                      </tr>
						                      <% } %>
                                        </tbody>
					                      <% } else { %>
					                      	<tr>
					                      		<td colspan=6>
					                      			<p> 아직 월급 산정이 되지 않았습니다. 행정부로 연락해주세요</p>
					                      		</td>
					                      	</tr>
					                      <% } %>
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
	      $('#billsearch').on('click', function(){
	         
	      });
	      $('#ysearch').click(function(){
				 var yy = $('#year').val();
				 var smt = $('#semester').val();
				 
				 location.href="<%=request.getContextPath()%>/sSemester.do?pno=<%=p.getProfessorNo()%>&year="+yy+"&smt="+smt;
			 });
	   });
   </script>
   
<%@ include file = "../common/footer.jsp" %>