<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  import="java.util.*, com.kh.semiProject.absence.model.vo.*"%>

<%@ include file="../common/header.jsp"%>

<% ArrayList<Absence> list = (ArrayList<Absence>)request.getAttribute("list");

%>



<!-- ============================================================== -->
<!-- Start Page Content -->
<!-- ============================================================== -->
    <script src="/semiProject/resources/js/jquery-ui.min.js"></script>
<div class="row">
	<div class="col-md-12">
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
					<%= s.getDeptName() %> / <%=s.getName()%></h4>
			</div>
			<br />
			<div id="searchDateArea">
				<span>
					<button type="button" class="btn btn-secondary leaveBtn"
						id="leaveBtn" style="width: 100px;" onclick="showForm1();">휴학신청</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-secondary" id="returnBtn"
						style="width: 100px;" onclick="showForm2()">연장신청</button>
				</span>
			</div>
			<div id="leaveDiv" class="regChanges1">
			
					<div>

					<form id="absinsertForm"  action="<%= request.getContextPath() %>/aInsert.ao">
						<table id="mytable" class=" table table-bordered">
							<thead>
								<th colspan=2>이름</th>
								<th colspan=2>
									<input type="text" value="<%= s.getName()%>"  name="writer" readonly>
							<input type="hidden" value="<%= s.getStudentNo()%>" name="studentno">
								</th>
								<th colspan=2>신청일자</th>
								<td colspan=2><label id="subdateText"  name="subdateText"></label>
									<input type="hidden" name="subdate" />
								</td>
								<th colspan=2>학적변동사유</th>
								<th colspan=2><select name="abstype" id="abstype">
										<option value="일반휴학">일반휴학</option>
										<option value="군입대휴학">군입대휴학</option>
								</select>

								<tr>
									<th colspan=3>시작일자</th>
									<td colspan=3><input type="text"  id="startdate" name="startdate"/></td>
									<th colspan=3>복학예정일자</th>
									<td colspan=3><input type="text"  id="enddate" name="enddate"/></td>
								</tr>
								<tr>
								</th>
									<th>휴학사유</th>
									<td colspan=10><input type="text" name="absreason"
										id="absreason" style="width: 95%;"
										placeholder="내용을 입력해주세요."  required /></td>
								</tr>
							</thead>
						</table>
						<button type="submit" class="btn btn-primary regBtn">신청</button>
					</div>
				</form>
						
				<br /> <br /> <br />

						<div id="documentInfo">
							<img id="userPicture"
								src="/semiProject/resources/images/document.jpg" alt="신청내역">
							<h5 id="check">신청/승인 내역</h5>
						</div>
					
						<table id="mytable2" class="table table-bordered">
							<thead>
								<tr>
									<th>학번</th>
									<th>휴학종류</th>
									<th>신청일자</th>
									<th>휴학시작일자</th>
									<th>복학예정일자</th>
									<th>휴학사유</th>
									<th>처리상태</th>
								</tr>
							</thead>
							<tbody>
					<% if(list.size() != 0) { %>
								<%for (Absence a : list) { %>

								<tr>
									<td><%= a.getStudentno() %></td>
									<td><%= a.getAbstype() %></td>
									<td><%=a.getSubdate() %></td>
									<td><%=a.getStartdate() %></td>
									<td><%=a.getEnddate() %></td>
									<td><%=a.getReason() %></td>
									<td><%=a.getState() %></td>
								</tr>
								<% } %>
							<% } else { %>
							<tr>
								<td colspan=7>
                                	<p>아직 휴학한 이력이 없습니다.</p>
                                </td>
                             </tr>
                             <% } %>
							</tbody>
						</table>

			</div>
								

			
			<!-- 연장폼 -->
			<div id="returnDiv" class="regChanges2">
				<form method="post" id="returnform">
					<div>

						<table id="mytable" class="table table-bordered">
							<thead>
								<th>연장구분</th>
								<th>
									<select name="extensiontype" id="extensiontype">
											<option value="일반">일반휴학</option>
											<option value="군입대">군입대휴학</option>
									</select>
								</th>
								<th>신청일자</th>
								<td><label id="extensiondateText"  name="extensiondateText"></label>
									<input type="hidden" name="extensiondate"  id="extensiondate"/></td>
								<th>휴학연장일자</th>
								<td><input type="text"  id="endDate" name="endDate"/></td>
								<tr>
									<th>연장사유</th>
									<td colspan=5><input type="text" name="extensionreason"
										id="returnreason" style="width: 80%;"
										placeholder="내용을 입력해주세요." required /></td>
								</tr>
							</thead>

						</table>
						<button type="submit" class="btn btn-primary regBtn"tyle="float: right;">
						신청</button>
					</div>
				</form>
					<br /> <br /> <br />
					<div>
						<div id="documentInfo">
							<img id="userPicture"
								src="/semiProject/resources/images/document.jpg" alt="신청내역">
							<h5 id="check">신청/승인 내역</h5>
						</div>

						<table id="mytable2" class="table table-bordered">
							<thead>
								<th>학번</th>
								<th>휴학종류</th>
								<th>신청일자</th>
								<th>휴학연장일자</th>
								<th>연장사유</th>
							</thead>
							<tbody>
								<tr >
									<td>
                                		아직 휴학한 이력이 없습니다.
                               		<td>
								</tr>
							</tbody>
						</table>
					</div>



			</div>
		</div>
	</div>
</div>


<!-- ============================================================== -->
<!-- End PAge Content -->
<!-- ============================================================== -->
<script>
	// $('#subdate').text(new Date().toLocaleDateString('yy-mm-dd'));
	$(function(){
		$('#subdateText').text(new Date().format("yyyy-MM-dd"));
		
		$('#subdate').val(new Date().format("yyyy-MM-dd"));
		
	});
	

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
	
	var endDate = $( "#enddate" ).datepicker({ 
		dateFormat: 'yy-mm-dd'
	});
	

	
	
	$('#mytable2 tbody tr').hover(function() {
		$(this).addClass("selected");
		$(this).siblings().removeClass("selected");
	});


	function showForm1() {

		$('#returnDiv').addClass("regChanges2");
		$('#leaveDiv').removeClass("regChanges2");
		$('#leaveBtn').addClass("leaveBtn");
		$('#returnBtn').removeClass("leaveBtn");

	}

	function showForm2() {

		$('#leaveDiv').addClass("regChanges2");
		$('#returnDiv').removeClass("regChanges2");
		$('#returnBtn').addClass("leaveBtn");
		$('#leaveBtn').removeClass("leaveBtn");
	}
	
	$(function(){
		$('#extensiondateText').text(new Date().format("yyyy-MM-dd"));
		
		$('#extensiondate').val(new Date().format("yyyy-MM-dd"));
		
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
