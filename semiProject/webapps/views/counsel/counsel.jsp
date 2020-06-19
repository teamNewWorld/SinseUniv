<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semiProject.counsel.model.vo.*"%>
<%@ include file = "../common/header.jsp" %>

<% ArrayList<Counsel> list = (ArrayList<Counsel>)request.getAttribute("list"); 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>

<div class="row">
       <!-- column -->
          <div class="col-lg-12">
           <div class="card"> 

              <div id = "stuInfo">
				<%
					if (s!=null) {
											
				%>
					<%if(s.getImage() != null ) { %>
						<img src="<%=request.getContextPath()%>/resources/memberImageFiles/
						<%=s.getImage()%>" class="profile-pic m-r-10 rounded-circle">
										
					<% } else { %>
						<img src="/semiProject/resources/images/usericon.png" alt="user" class="profile-pic m-r-10" />
					<% } %>
			<%
				} else if(p!=null) {
			%>
					<%if(p.getProImage() != null) { %>
						<img src="<%=request.getContextPath()%>/resources/memberImageFiles/
						<%=p.getProImage()%>" class="profile-pic m-r-10 rounded-circle">
					
					<% } else { %>
						<img src="/semiProject/resources/images/usericon.png" alt="user" class="profile-pic m-r-10" />
					<% } %>
			<%
					}
			%>
				<h4 id="myName">
					 <% if(s!=null){ %>
                 	<%= s.getDeptName() %> / <%= s.getName() %>
                 <% } else { %>
                 	<%= p.getDeptName() %> / <%= p.getProfessorName() %>
                 <% } %>
                 </h4>
			</div>
 
               <div class="card-block" align="center">
                     <hr />
                    
                                <div class="table-responsive">
                                    <table class="table" id="mytable">
                                        <thead id="tableHead">
                                            <tr>
                                                <th style="display : none">No.</th>
                                                <th>on/off</th>
                                          		<th>Title</th>
                                         		<th>Date</th>
                                          		<th>Type</th>
                                          		<th>Writer</th>
                                          		<th>Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
            
                                           <%for(Counsel c : list) {%>
	                                           <%if( s!=null) { %> 
	                                           	<% if(c.getStudentNo().equals(s.getStudentNo())){ %>
		                                           <tr>
		                                              <td style="display:none"><%=c.getCno()%></td>
		                                              <td><%=c.getOnOff() %></td>
		                                              <td><%=c.getCtitle()%></td>
		                                              <td><%=c.getCdate()%></td>
		                                              <td><%=c.getCtype()%></td>
		                                              <td><%=c.getCwriter()%></td>
		                                              <td style="color:red;"><%=c.getStatus() %></td>
		                                           </tr>
											<%} %>
											<%} else { %>
												<% if( p.getProfessorNo().equals(c.getProfessorNo())) { %>
												<tr>
		                                              <td style="display:none"><%=c.getCno()%></td>
		                                              <td><%=c.getOnOff() %></td>
		                                              <td><%=c.getCtitle()%></td>
		                                              <td><%=c.getCdate()%></td>
		                                              <td><%=c.getCtype()%></td>
		                                              <td><%=c.getCwriter()%></td>
		                                              <td style="color:red;"><%=c.getStatus() %> </td>
		                                           </tr>
		                                           <%} %>
                                           <%} }%>
                                        </tbody>
                                    </table>
                                </div>
                             
                                <br><br>
        
        <%-- 페이지 처리 --%>
		<div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/selectList.co?currentPage=1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectList.co?currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int f = startPage; f <= endPage; f++){
					if(f == currentPage){	
			%>
				<button disabled><%= f %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/selectList.co?currentPage=<%= f %>'"><%= f %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectList.co?currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectList.co?currentPage=<%= maxPage %>'">>></button>
             </div>            
             <br><br>
              <% if ( s != null ) { %>
                <button type="button" class="btn btn-primary" 
                  onclick="location.href='/semiProject/views/counsel/counselInsertForm.jsp'">신청</button>
                <% } %>
                    </div>
                </div>
              </div>
            </div>

                <script>
				$(function(){
          			
      				$("#mytable td").mouseenter(function(){
      					$(this).parent().css({"cursor":"pointer"});
      				
      				}).click(function(){
							var cno = $(this).parent().children().eq(0).text();
      					
      					location.href="<%=request.getContextPath()%>/selectOne.co?cno=" + cno;
      				});
      			});
				

			 </script>


</html>
<%@ include file = "../common/footer.jsp" %>