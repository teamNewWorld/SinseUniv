<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kh.semiProject.board.model.vo.*,
								java.util.*,
								com.kh.semiProject.boardComment.model.vo.*"%>
	<%@ include file="../common/header.jsp" %>
<%
	Board b = (Board)request.getAttribute("board");
	ArrayList<BoardComment> bclist
	       = (ArrayList<BoardComment>)request.getAttribute("clist");
%>

	<% if(s != null ) { %>
<div class="row">
	<div class="col-lg-12">
		<div class="card">
			<div class="outer">
				<div class="card-block">
					<div class="table-responsive">
						<hr />
						<p class="outset"><b><%= b.getBtitle() %></b></p>
						<table class="table">
					<tr>
						<td colspan="3"></td>
						<td>작성자 :</td>
						<td>익명</td>
						<input type="hidden" name="bwriter" value="<%= b.getBwriter() %>" />
						<td>작성일 : </td>
						<td><%= b.getBdate() %></td>
					</tr>		
					<tr>
						<td colspan="8">
							<%= b.getBcontent() %>
						</td>
					</tr>
		
				</tbody>
		
				</table>

		<div align="right">
			<button class="btn btn-secondary" onclick="location.href='<%= request.getContextPath() %>/main.do'">메뉴로 돌아가기</button>
			<% if(s != null && s.getName().equals(b.getBwriter())){ %>
			<button class="btn btn-primary" onclick="location.href='<%= request.getContextPath() %>/bUpView.bo?bno='+<%=b.getBno()%>">수정하기</button>
			<% } %>
		</div>
	
		<hr />	
		<div class="replyArea" >
			<div class="replyWriteArea">
				<form action="/semiProject/insertComment.bo" method="post">
					<input type="hidden" name="writer" value="<%=s.getStudentNo()%>"/>
					<input type="hidden" name="bno" value="<%=b.getBno() %>" />
					<input type="hidden" name="refbcno" value="0" />
					<input type="hidden" name="bclevel" value="1" />
					
					<table id="comment" align="center">
						<tr>
							
							<td><textArea rows="3" cols="80" id="replyContent" name="replyContent"
										placeholder="댓글좀 써봤니?"></textArea></td>
							<td><button class="btn btn-primary" type="submit" id="addReply">댓글 등록</button></td>
						</tr>
					</table>
				</form>
			</div>
			<br>
			<div>
			<!-- 게시글의 댓글 목록 구현부 -->
			
			<% if(bclist !=  null) {%>
				<% for(BoardComment bco : bclist) { %>
				<%-- 댓글 목록이 있다면 --%>
				
				
				<table
	      	 style="margin-left : <%= (bco.getBclevel()-1) * 15 %>px;
	      	 		width : <%= 500 - ((bco.getBclevel()-1) * 15)%>px;"
	      	 class="replyList<%=bco.getBclevel()%>">
		
		  			<tr>
					<td><b>익명</b>
					<input type="hidden" value="<%= bco.getBcdate() %>" />
					</td>
					<td><%= bco.getBcdate() %></td>
					<td align="right">
 					<%if(s.getStudentNo().equals(bco.getStudentno())) { %>
						<input type="hidden" name="cno" value="<%=bco.getBcno()%>"/>
							  
						<button type="button" class="updateBtn" 
							onclick="updateReply(this);">수정하기</button>
							
						<button type="button" class="updateConfirm"
							onclick="updateConfirm(this);"
							style="display:none;" >수정완료</button> &nbsp;&nbsp;
							
						<button type="button" class="deleteBtn"
							onclick="deleteReply(this);">삭제하기</button>
							
					<% } else if( bco.getBclevel() < 3) { %>
						<input type="hidden" name="writer" value="<%=s.getStudentNo()%>"/>
						<input type="hidden" name="refbcno" value="<%= bco.getBcno() %>" />
						<input type="hidden" name="bclevel" value="<%=bco.getBclevel() %>" />
						<button type="button" class="insertBtn" 
							 onclick="reComment(this);">댓글 달기</button>&nbsp;&nbsp;
							 
						<button type="button" class="insertConfirm"
							onclick="reConfirm(this);"
							style="display:none;" >댓글 추가 완료</button> 
							
					<% } else {%>
						<span> 마지막 레벨입니다.</span>
					<% } %>
					</td>
				</tr>
				<tr class="comment replyList<%=bco.getBclevel()%>">
					<td colspan="3" style="background : none;">
					<textarea cols="100"
					 readonly="readonly"><%= bco.getBccontent() %></textarea>
					</td>
				</tr>
			</table>
			
				
			<% } } else { %>
				<%-- 댓글 목록이 없다면 --%>
				
				<p>
					현재 등록된 댓글의 내용이 없습니다. <br>
					첫 댓글의 주인공이 되어 보세요!
				</p>
			<% } %>				
			</div>
		</div>

	</div>
	</div>
	</div>
	</div>
	</div>
		</div>
	<script>
	function updateReply(obj) {
		// 현재 위치와 가장 근접한 textarea 접근하기
		$(obj).parent().parent().next().find('textarea')
		.removeAttr('readonly');
		
		// 수정 완료 버튼을 화면 보이게 하기
		$(obj).siblings('.updateConfirm').css('display','inline');
		
		// 수정하기 버튼 숨기기
		$(obj).css('display', 'none');
	}
	
	function updateConfirm(obj) {
		// 댓글의 내용 가져오기
		var content
		  = $(obj).parent().parent().next().find('textarea').val();
		
		// 댓글의 번호 가져오기
		var bcno = $(obj).siblings('input').val();
		
		// 게시글 번호 가져오기
		var bno = '<%=b.getBno()%>';
		
		location.href="/semiProject/updateComment.bo?"
				 +"bcno="+bcno+"&bno="+bno+"&content="+content;
	}
	
	function deleteReply(obj) {
		// 댓글의 번호 가져오기
		var bcno = $(obj).siblings('input').val();
		
		// 게시글 번호 가져오기
		var bno = '<%=b.getBno()%>';
		
		location.href="/semiProject/deleteComment.bo"
		+"?bcno="+bcno+"&bno="+bno;
	}
	
	function reComment(obj){
		// 추가 완료 버튼을 화면 보이게 하기
		$(obj).siblings('.insertConfirm').css('display','inline');
		
		// 클릭한 버튼 숨기기
		$(obj).css('display', 'none');
		
		// 내용 입력 공간 만들기
		var htmlForm = 
			'<tr class="comment"><td></td>'
				+'<td colspan="3" style="background : transparent;">'
					+ '<textarea class="reply-content" style="background : ivory;" cols="105" rows="3"></textarea>'
				+ '</td>'
			+ '</tr>';
		
		$(obj).parents('table').append(htmlForm);
		
	}
	
	function reConfirm(obj) {
		// 댓글의 내용 가져오기
		
		// 참조할 댓글의 번호 가져오기
		var refcno = $(obj).siblings('input[name="refcno"]').val();
		var level = Number($(obj).siblings('input[name="clevel"]').val()) + 1;
		
		// console.log(refcno + " : " + level);
		
		// 게시글 번호 가져오기
		var bno = '<%=b.getBno()%>';
		
		var parent = $(obj).parent();
		var grandparent = parent.parent();
		var siblingsTR = grandparent.siblings().last();
		
		var content = siblingsTR.find('textarea').val();
		
		// console.log(parent.html());
		// console.log(grandparent.html());
		// console.log(siblingsTR.html());
		
		// console.log(content);

		// writer, replyContent
		// bno, refcno, clevel
		
		location.href='/semiProject/insertComment.bo'
		           + '?writer=<%= s.getStudentNo() %>' 
		           + '&replyContent=' + content
		           + '&bno=' + bno
		           + '&refcno=' + refcno
		           + '&clevel=' + level;
	}
	
	</script>
	
	<% } else {
		request.setAttribute("msg", "학생만 가능한 서비스 입니다.");
		request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
	}
	%>
	<%@ include file="../common/footer.jsp" %>
\