<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semiProject.notice.model.vo.*"%>
<%
	Notice n = (Notice) request.getAttribute("notice");
%>
<%@ include file="../common/header.jsp"%>
<%
	if ((s != null && s.getStudentNo().equals("admin")) || (p != null && p.getProfessorNo().equals("admins"))) {
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
									<td colspan="3"><input type="text" size="50" name="title"
										value="<%=n.getNtitle().replace("\"", "&#34;")%>"> <input
										type="hidden" name="nno" value="<%=n.getNno()%>"></td>
								</tr>
								<tr>
									<td>작성자</td>
									<td><input type="text" value="<%=n.getNwriter()%>"
										name="writer" readonly></td>
									<td>작성일</td>
									<td><input type="date" name="date"
										value="<%=n.getNdate()%>"></td>
								</tr>
								<tr>
									<td>내용</td>
									<td colspan="4"><textarea name="content" cols="60"
											rows="15" style="resize: none;"><%=n.getNcontent()%></textarea>
									</td>
								</tr>
							</table>
						</div>
						<br>
						<div align="center">
							<button class="btn btn-primary" onclick="complete();">작성완료</button>
							<button class="btn btn-secondary" onclick="deleteNotice();">삭제하기</button>
						</div>
						<script>
					function complete(){
						$("#updateForm").attr("action","<%=request.getContextPath()%>/nUpdate.no");
						
					}
					
					function deleteNotice(){
						// delete 는 예약어 이므로 deleteNotice 로 ...!
						$("#updateForm").attr("action","<%=request.getContextPath()%>/nDelete.no");
						}
						</script>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>
<%
	} else {
		request.setAttribute("msg", "관계자 외에 접근이 불가능한 페이지입니다.");
		request.getRequestDispatcher("view/common/errorPage.jsp").forward(request, response);
	}
%>
<%@ include file="../common/footer.jsp"%>