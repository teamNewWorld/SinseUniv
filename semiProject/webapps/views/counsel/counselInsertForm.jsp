<%@page import="sun.security.util.math.intpoly.P256OrderField"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.semiProject.counsel.model.vo.*"%>
<%@ include file="../common/header.jsp"%>
<%	
	Calendar ca = Calendar.getInstance(); //객체생성
	Counsel c = (Counsel)request.getAttribute("counsel");
%>
 <script src="/semiProject/resources/js/jquery-ui.min.js"></script>
<div class="row">
	<div class="col-lg-12">
		<div class="card">

			<div id="stuInfo">
				<%
					if (s != null) {
				%>
				<%
					if (s.getImage() != null) {
				%>
				<img
					src="<%=request.getContextPath()%>/resources/memberImageFiles/
						<%=s.getImage()%>"
					class="profile-pic m-r-10 rounded-circle">

				<%
					} else {
				%>
				<img src="/semiProject/resources/images/usericon.png" alt="user"
					class="profile-pic m-r-10" />
				<%
					}
				%>
				<%
					} else if (p != null) {
				%>
				<%
					if (p.getProImage() != null) {
				%>
				<img
					src="<%=request.getContextPath()%>/resources/memberImageFiles/
						<%=p.getProImage()%>"
					class="profile-pic m-r-10 rounded-circle">

				<%
					} else {
				%>
				<img src="/semiProject/resources/images/usericon.png" alt="user"
					class="profile-pic m-r-10" />
				<%
					}
				%>
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
			<div id="onoffBtn">
				<button type="button" class="btn btn-secondary onlineBtn"
					id="onlineBtn" onclick="showForm1();">온라인상담</button>
				<button type="button" class="btn btn-secondary offlineBtn"
					id="offlineBtn" onclick="showForm2();">오프라인상담</button>	 
			</div>


			<div class="card-block" align="center">
				<div class="table-responsive">
				<form action="<%=request.getContextPath()%>/cInsert.co" method="post">

					<div id="onlineForm" class="change1">
							<table class="table">
								<tr>
									<td>제목</td>
									<td colspan="3"><input type="text" size="30" name="title"></td>
								</tr>
								<tr>
									<td>상담유형</td>
									<td>온라인 상담
									<input type="hidden" name="onoff" value="on" />
									</td>
								</tr>
								<tr>
									<td>작성일</td>
									<td colspan="3"><label id="subdateText"  name="date"><%=ca.get(Calendar.YEAR)%>-<%=ca.get(Calendar.MONTH)+1%>-<%=ca.get(Calendar.DATE)%></label>
									<input type="hidden" name="date" 
									value="<%=ca.get(Calendar.YEAR)%>-<%=ca.get(Calendar.MONTH)+1%>-<%=ca.get(Calendar.DATE)%>" /></td>
								</tr>
								<tr>
									<td>작성자</td>
									<td colspan="3"><input type="text"
										value="<%=s != null ? s.getName() : p.getProfessorName()%>"
										name="writer" readonly> <input type="hidden"
										value="<%=s != null ? s.getStudentNo() : p.getProfessorNo()%>"
										name="userId"></td>
								</tr>
								<tr>
									<td>이메일</td>
									<td colspan="3"><input type="text"
										value="<%=s != null ? s.getEmail() : p.getProEmail()%>"
										name="email" readonly></td>
								</tr>

								<%if(s!=null) { %>
									<tr>
										<td>담당 교수</td>
										<td colspan="3"><input type="text"
											value="<%= s.getProfessorName() %>"
											readonly>
										<input type="hidden" name="studentProNo" value="<%= s.getProfessorNo()%>" />
										</td>
									</tr>
									<% } %>
								
									
								<tr>
									<td>상담 유형 </td>
									<td><select id="CounselCategory" name="counselCategory">
											<option value="진로상담" name="counselCategory">진로상담</option>
											<option value="성적상담" name="counselCategory">성적상담</option>
											<option value="기타" name="counselCategory">기타</option>
									</select></td>
								</tr>
								<tr>
									<td>내용</td>
									<td colspan="3"><textarea name="content" cols="52"
											rows="15" style="resize: none;"
											placeholder="상담 유형이 기타일 경우 어떤 상담을 원하는지 여기에 적어주세요"></textarea>
									</td>
								</tr>
								
							</table>
							<br>
							<div align="center">
								<button class="btn btn-secondary" type="reset">취소하기</button>
								<button class="btn btn-primary" type="submit">등록하기</button>
							</div>
							
							</div>
							</form>
							
							
							<form action="<%=request.getContextPath()%>/cInsert.co" method="post">
							<div id="offlineForm" class="change2">
								<table class="table">
									<tr>
										<td>제목</td>
										<td colspan="3"><input type="text" size="30" name="title"></td>
									</tr>
									<tr>
										<td>상담유형</td>
										<td>오프라인 상담
										<input type="hidden" name="onoff" value="off" />
									</td>
								</tr>
									<tr>
										<td>날짜 선택</td>
										<td><input type="text" id="startdate" name="date"></td>
									</tr>
									<tr>
										<td>신청자</td>
										<td colspan="3"><input type="text"
											value="<%=s != null ? s.getName() : p.getProfessorName()%>"
											name="writer" readonly> <input type="hidden"
											value="<%=s != null ? s.getStudentNo() : p.getProfessorNo()%>"
											name="userId"></td>
									</tr>
									<tr>
										<td>이메일</td>
										<td colspan="3"><input type="text"
											value="<%=s != null ? s.getEmail() : p.getProEmail()%>"
											name="email" readonly></td>
									</tr>
									<%if(s!=null) { %>
									<tr>
										<td>담당 교수</td>
										<td colspan="3"><input type="text"
											value="<%= s.getProfessorName() %>" readonly></td>
											<input type="hidden" name="studentProNo" value="<%= s.getProfessorNo()%>" />
									</tr>
									<% } %>
									<tr>
										<td>상담 유형 :</td>
										<td><select id="CounselCategory" name="counselCategory">
												<option value="진로상담" name="counselCategory">진로상담</option>
												<option value="성적상담" name="counselCategory">성적상담</option>
												<option value="기타" name="counselCategory">기타</option>
										</select></td>
									</tr>
									<tr>
										<td>내용</td>
										<td colspan="3"><textarea name="content" cols="52"
												rows="15" style="resize: none;"
												placeholder="상담 유형이 기타일 경우 어떤 상담을 원하는지 여기에 적어주세요"></textarea>
										</td>
									</tr>
								</table>
								<br>
								<div align="center">
									<button class="btn btn-secondary" type="reset">취소하기</button>
									<button class="btn btn-primary" type="submit">등록하기</button>
								</div>
							</div>
					</form>
				</div>
			</div>
			
		</div>
	</div>
</div>

<script>
	function showForm1() {
	
		$('#offlineForm').addClass("change2");
		$('#onlineForm').removeClass("change2");
		$('#onlineBtn').addClass("onlineBtn");
		$('#offlineBtn').removeClass("onlineBtn");
	
	}

	function showForm2() {
	
		$('#onlineForm').addClass("change2");
		$('#offlineForm').removeClass("change2");
		$('#offlineBtn').addClass("onlineBtn");
		$('#onlineBtn').removeClass("onlineBtn");
	}
	
	$( "#startdate" ).datepicker({ 
		dateFormat: 'yy-mm-dd' , 
		minDate: new Date()
		
	});
	
	$('#startdate').on('change', function(){
		var year = $( "#startdate" ).val().split("-")[0];
		var mon = $( "#startdate" ).val().split("-")[1];
		var day = $( "#startdate" ).val().split("-")[2];

		var date = new Date(year, mon-1, 1);

		date.setMonth(date.getMonth() + 6);
		
		console.log(date);
		endDate.minDate = date;
		endDate.datepicker( "option", "minDate",date );
	
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


<%@ include file="../common/footer.jsp"%>