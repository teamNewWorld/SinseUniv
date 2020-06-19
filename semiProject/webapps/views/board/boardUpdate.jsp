<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semiProject.board.model.vo.*"%>
<%@ include file="../common/header.jsp"%>
<%
	Board b = (Board) request.getAttribute("board");
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
									<td>제목</td>
									<td colspan="3"><input type="text" size="65" name="title"
										value="<%=b.getBtitle()%>"> <input type="hidden"
										name="bno" value="<%=b.getBno()%>"></td>
								</tr>
								<tr>
									<td>작성자</td>
									<td colspan="3"><%=b.getBwriter()%></td>
								</tr>
								<tr>
									<td>내용</td>
									<td colspan="3"><textarea name="content" cols="67"
											rows="15" style="resize: none;"><%=b.getBcontent()%></textarea>
									</td>
								</tr>
							</table>
							<br>
							<div align="center">
								<button class="btn btn-primary" onclick="complete();">수정완료</button>
								<button class="btn btn-secondary" onclick="deleteBoard();">삭제하기</button>
							</div>
							<script>
					function complete(){
						$("#updateForm").attr("action","<%=request.getContextPath()%>/bUpdate.bo");
					}
					
					function deleteBoard(){
						$("#updateForm").attr("action","<%=request.getContextPath()%>/bDelete.bo"); 
						}
							</script>
			</div>
				</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="../common/footer.jsp"%>
