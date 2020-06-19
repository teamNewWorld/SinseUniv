<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<%@ include file="../common/header.jsp" %>
	<% if((s != null && s.getStudentNo().equals("admin")) || (p != null && p.getProfessorNo().equals("admins"))){ %>
<div class="row">
	<div class="col-lg-12">
		<div class="card">
			<div class="outer">
			<form action="<%= request.getContextPath() %>/nInsert.no" method="post">
					<div class="card-block">
						<div class="table-responsive">
							<table class="table">
					<tr>
						<td>제목 </td>
						<td colspan="3"><input type="text" size="50" name="title"></td>
					</tr>
					<tr>
						<td>작성자 </td>
						<td>
							<input type="text" value="<%= s != null ? s.getName() : p.getProfessorName() %>"  name="writer" readonly>
							<input type="hidden" value="<%= s != null ? s.getStudentNo() : p.getProfessorNo()%>" name="userId">  
						</td>
						<td>작성일</td>
						<td><input type="date" name="date"></td>
					</tr>
					<tr>
						<td>내용 </td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content" cols="60" rows="15" style="resize:none;"></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button class="btn btn-primary" type="submit">등록하기</button>
					<button class="btn btn-seconary" type="reset">취소하기</button>
				</div>
				</div>
				</div>
			</form>
		</div>
	</div>
	</div>
	</div>
	<% } else {
		request.setAttribute("msg", "관계자 외에 접근이 불가능한 페이지입니다.");
		request.getRequestDispatcher("view/common/errorPage.jsp").forward(request, response);
	} %>
	
	<%@ include file="../common/footer.jsp" %>