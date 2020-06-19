<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="java.util.*, com.kh.semiProject.Student.model.vo.*"%>
<%@ include file="../common/header.jsp"%>
<% ArrayList<Achievement> list = (ArrayList<Achievement>)request.getAttribute("list"); %>
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
            </select> <select name="semester" id="semester">
               <option value="01" onclick="showGrade(this);">1학기</option>
               <option value="02" onclick="showGrade(this);">2학기</option>
            </select>
            <button id="ysearch">
               <img src="/semiProject/resources/images/search.png" alt="검색" />
            </button>

         </div>

         <div class="card-block">
            <hr />
            <div class="table-responsive">
               <table class="table" id="mytable">
                  <thead id="tableHead" style="text-align: center;">
                     <tr>
                        <th>이수년도</th>
                        <th>학기</th>
                        <th>학수번호</th>
                        <th>과목명</th>
                        <th>평점</th>
                        <th>등급</th>
                        <th>강의평가</th>
                        <th>성적 정정 신청</th>
                     </tr>
                  </thead>
                  <tbody>
                  <% int smt = 0;
                  if(Calendar.getInstance().get(Calendar.MONTH)<6) smt = 1;
                  else smt = 2;
                  for(Achievement ach : list){ %>
                     <tr>
                     
                        <td><%= ach.getYear()%></td>
                        <td><%= ach.getSemester() %></td>
                        <td><%= ach.getCls_no() %></td>
                        <td><%= ach.getCls_name() %></td>
                        <td class = "stupoint"><%= ach.getPoint() %></td>
                        <td class = "stugrade"><%= ach.getGrade() %></td>
                        <td><button type="button" class="btn btn-secondary" id = "clkResearch"
                        <% if(ach.getYear()!= Calendar.getInstance().get(Calendar.YEAR) || ach.getSemester()!=smt){%><%="disabled"%><%} %>
                             >강의평가</button></td>
                        
                        <td>
                        <button type="button" class="btn btn-primary" id = "clkClaim"
                              id="completeApply"
                              <% if(ach.getYear()!= Calendar.getInstance().get(Calendar.YEAR) || ach.getSemester()!=smt){%><%="disabled"%><%} %>
                              >
                              신청</button></td>
                     </tr>
                     <% } %>
                  <!--     <tr id="20201" class="grade">
                        <td>2020</td>
                        <td>1</td>
                        <td>MT101</td>
                        <td>자바프로그래밍</td>
                        <td>4.0</td>
                        <td>A</td>
                        <td><button type="button" class="btn btn-secondary"
                              onclick="window.open('/semiProject/views/student/classEvaluation.jsp','강의평가','width=900,height=800,scrollbars=yes');">강의평가</button></td>
                        <td><button type="button" class="btn btn-secondary"
                              disabled>신청</button></td>
                     </tr>
                     <tr id="20202" class="grade">
                        <td>2020</td>
                        <td>2</td>
                        <td>MT102</td>
                        <td>데이터베이스</td>
                        <td>3.0</td>
                        <td>B</td>
                        <td><button type="button" class="btn btn-secondary"
                              disabled>강의평가</button></td>
                        <td>
                           <button type="button" class="btn btn-primary"
                              id="completeApply"
                              onclick="window.open('/semiProject/views/student/gradeCorrect.jsp','성적정정신청란','width=600,height=800,scrollbars=yes');return false">신청</button>
                        </td>
                     </tr>-->

                  </tbody>
               </table>
            </div>
         </div>
      </div>
   </div>
</div><!-- ============================================================== -->
<!-- End PAge Content -->
<!-- ============================================================== -->
<script>
   function showGrade(e) {
      $($(this).val()).style.display = "block";
   }
</script>
<script>

$(function(){
  
    $('#ysearch').click(function(){
       var yy = $('#year').val();
       var smt = $('#semester').val();
       
       location.href="<%=request.getContextPath()%>/achsmt.do?sno=<%=s.getStudentNo()%>&year="+yy+"&smt="+smt;
    });
    
    $('.btn-secondary').click(function(){
    	$.ajax({
    		url : '/semiProject/ratingCheck.do',
    		data : {
    			stuno : <%=s.getStudentNo()%>,
    			clsno : $(this).parent().parent().children().eq(2).html()
    		},
    		success : function(data){
    			if(data == 1){
    				alert("이미 강의평가를 완료했습니다.")
    			}
    			else{
    				window.open('/semiProject/views/student/classEvaluation.jsp?sno=<%=s.getStudentNo()%>','강의평가','width=900,height=800,scrollbars=yes');
    				console.log(data);
    			}
    		}
    	});
    	
    	
    });
    
    $('.btn-primary').click(function(){
    	$.ajax({
    		url : '/semiProject/claimCheck.do',
    		data : {
    			stuno : <%=s.getStudentNo()%>,
    			clsno : $(this).parent().parent().children().eq(2).html()
    		},
    		success : function(data){
    			if(data == 1){
    				alert("신청한 정정 요청이 처리중입니다.")
    			}
    			else{
    				 window.open('/semiProject/views/student/gradeCorrect.jsp','성적정정신청란','width=600,height=800,scrollbars=yes');    	
    				console.log(data);
    			}
    		}
    	});
    	  
    });
});


</script>
<%@ include file="../common/footer.jsp"%>