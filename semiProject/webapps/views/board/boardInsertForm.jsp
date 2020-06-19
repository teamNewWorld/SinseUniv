<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<script src="/semiProject/resources/js/jquery-ui.min.js"></script>

	<% if (s != null) { %>
<div class="row">
	<div class="col-lg-12">
		<div class="card">
			<div class="outer">
			<form action="<%= request.getContextPath() %>/bInsert.bo" 
			      method="post" >
					<div class="card-block">
						<div class="table-responsive">
							<table class="table">

					<tr>
						<td>제목 </td>
						<td colspan="3"><input type="text" size="51" name="title"></td>
					</tr>
					<tr>
						<td>작성자 </td>
						<td>
							<input type="text" value="<%= s != null ? s.getName() : p.getProfessorName() %>"  name="writer" readonly>
							<input type="hidden" value="<%= s != null ? s.getStudentNo() : p.getProfessorNo()%>" name="userId">
						</td>
						<td>작성일</td>
						<td><label id="date"  name="date"></label>
								<input type="hidden"  id="date" name="date" /></td>
					</tr>
					<tr>
						<td>내용 </td>
						<td colspan="3">
							<textarea name="content" cols="52" rows="15" style="resize:none;"></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button class="btn btn-secondary" type="reset">취소하기</button>
					<button class="btn btn-primary" type="submit">등록하기</button>
				</div>
				</div>
				</div>
			</form>
		</div>
	</div>
	</div>
	</div>
	<% } else { 
		request.setAttribute("msg", "학생만 열람 가능합니다.");
		request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
	 } %>
	
	 <script>
	 $(function(){
		$('#date').text(new Date().format("yyyy-MM-dd"));
		
		$('#date').val(new Date().format("yyyy-MM-dd"));
		
	});
	 
	 Date.prototype.format = function(f) {
		    if (!this.valueOf()) return " ";
		 
		    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
		    var d = this;
		     
		    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
		        switch ($1) {
		            case "yyyy": return d.getFullYear();
		            case "yy": return (d.getFullYear() % 1000).zf(2);
		            case "MM": return (d.getMonth() + 1).zf(2);
		            case "dd": return d.getDate().zf(2);
		            case "E": return weekName[d.getDay()];
		            case "HH": return d.getHours().zf(2);
		            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
		            case "mm": return d.getMinutes().zf(2);
		            case "ss": return d.getSeconds().zf(2);
		            case "a/p": return d.getHours() < 12 ? "오전" : "오후";
		            default: return $1;
		        }
		    });
		};
		 
		String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
		String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
		Number.prototype.zf = function(len){return this.toString().zf(len);};
	
	</script>

	<%@ include file="../common/footer.jsp" %>