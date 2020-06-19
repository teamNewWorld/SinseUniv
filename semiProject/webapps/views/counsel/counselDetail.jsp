<%@page import="com.sun.org.apache.xerces.internal.util.Status"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="java.util.*, com.kh.semiProject.counsel.model.vo.*, com.kh.semiProject.counselComment.model.vo.*"%>
<%@ include file="../common/header.jsp"%>

<%
   Counsel c = (Counsel) request.getAttribute("counsel");
   ArrayList<CounselComment> cclist
    = (ArrayList<CounselComment>)request.getAttribute("cclist");
%>
<div class="row">
   <div class="col-lg-12">
      <div class="card">
         <div class="outer">
            <form id="updateForm" method="post">
               <div class="card-block">
                  <div class="table-responsive">
                     <table class="table">
                        <tr>
                           <td>제목 </td>
                           <td colspan="3"><%=c.getCtitle()%></td>
                        </tr>
                        <tr>
                           <td>작성자 </td>
                           <td><%=c.getCwriter()%></td>
                        </tr>
                        <tr>
                           <td>이메일 </td>
                           <td><%=c.getCemail()%></td>
                        </tr>
                        <tr>
                           <%if(c.getOnOff().equals("on")) { %>
                           <td>작성일 </td>
                           <% } else { %>
                           <td> 상담 날짜 </td>
                           <%} %>
                           <td><%=c.getCdate() %></td>
                        </tr>
                        <tr>
                           <td>상태 </td>
                           <td><%=c.getStatus()%></td>
                           <input type="hidden" name="status" id="status" />
                        </tr>
                        <tr>
                           <td>상담종류 </td>
                           <td><%=c.getCtype()%></td>
                        </tr>
                        <tr>
                           <td>내용</td>
                           <td><span><%=c.getCcontent().charAt(0)%></span><%=c.getCcontent().substring(1)%>
                           </td>
                        </tr>
                     </table>
                     <br>

                     <div align="center">
                        <button type="button" class="btn btn-secondary"
                           onclick="location.href='/semiProject/selectList.co'">돌아가기</button>
                        <%
                           if (p != null) {
                        %>
                        <button type="button" id="statusBtn" class="btn btn-primary"
                           <%if (c.getStatus().equals("처리완료")) {%> <%="disabled"%>
                           <%}%>>처리완료</button>
                        <%
                           }
                        %>
                     </div>

                  </div>
               </div>
            </form>
         </div>

         <div class="replyArea">
            <div class="replyWriteArea">
               <form action="/semiProject/ccInsert.co" method="post">
                  <%
                     if (s != null) {
                  %>
                  <input type="hidden" name="ccwriter" value="<%=s.getName()%>" />
                  <%
                     } else {
                  %>
                  <input type="hidden" name="ccwriter"
                     value="<%=p.getProfessorName()%>" />
                  <%
                     }
                  %>
                  <input type="hidden" name="cno" value="<%=c.getCno()%>" />

                  <table align="center">
                     <tr>
                        <td>댓글 작성</td>
                        <td><textArea rows="3" cols="80" id="replyContent"
                              name="cccontent"></textArea></td>
                        <td><button type="submit" class="btn btn-primary" id="addReply">댓글 등록</button></td>
                     </tr>
                  </table>
                  
               </form>
            </div>
         </div>
      </div>
   </div>
         
</div>
      <div>
      
         <% if(cclist != null) {%>
            <% for(CounselComment cco : cclist) { %>
            <table>
               <tr>
                  <td><%= cco.getCcwriter() %> </td>
                  <td><input type="hidden" value="<%= cco.getCcdate() %>" /></td>
               </tr>
               <tr>
                  <td style="background : none;">
                     <textarea cols="150 rows="1"
                      readonly="readonly"><%= cco.getCccontent() %></textarea>
                  </td>
               </tr>
         </table>
         <% }}  %>
      </div>
<script>
   $('#statusBtn').on('click', function() {

      $.ajax({
         url : '/semiProject/cUpdate.co',
         data : {
            cno : <%=c.getCno()%> },
         success : function(data) {

            if (data == 0) {
               alert('오류가 발생하였습니다.');
            } else {
               alert('처리완료되었습니다.');
               location.href = '/semiProject/selectList.co';
            }
         }
      });
   });
</script>
<%@ include file="../common/footer.jsp"%>
