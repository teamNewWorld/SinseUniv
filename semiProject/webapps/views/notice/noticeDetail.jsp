<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semiProject.notice.model.vo.*"%>
<%
	Notice n = (Notice) request.getAttribute("notice");
%>

<%@ include file="../common/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="card">
			<div class="outer">
				<div class="card-block">
					<div class="table-responsive">
						<hr />
						<p class="outset"><b><%=n.getNtitle()%></b></p>
						<table class="table">
							<tr>
								<td>작성자 :</td>
								<td><%=n.getNwriter()%></td>
								<td>작성일 :</td>
								<td><%=n.getNdate()%></td>
							</tr>
							<tr>
								<hr />
								<td colspan="4"><%=n.getNcontent().charAt(0)%><%=n.getNcontent().substring(1)%></td>
							</tr>
						</table>
						<br>
						<div align="right">
							<hr />
							<button class="btn btn-secondary"
								onclick="location.href='<%=request.getContextPath()%>/main.do'">메뉴로
								돌아가기</button>

							<%
								if ((s != null && s.getStudentNo().equals("admin")) || (p != null && p.getProfessorNo().equals("admins"))) {
							%>
							<button class="btn btn-primary" style="cursor: pointer;"
								onclick="location.href='nUpView.no?nno=<%=n.getNno()%>'">수정하기</button>
							<%
								}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../common/footer.jsp"%>