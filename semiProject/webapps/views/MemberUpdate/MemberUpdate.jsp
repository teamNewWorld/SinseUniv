<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.Date"%>
<%@ include file="../common/header.jsp"%>
<%@ page import="java.util.*"%>
<%
	Calendar ca = Calendar.getInstance(); //객체생성
%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- ============================================================== -->
<!-- Start Page Content -->
<!-- ============================================================== -->
<div class="col-lg-12">
	<div class="card">
		<div class="card-block" style="text-align: center;">
			<div class="updateBase">
				<h2 align="center">회원 정보 수정</h2>
				<br></br>
				<form id="updateForm" action="/semiProject/mUpdate.do" method="post"
					enctype="multipart/form-data">
					<table id="testTable6">
						<tr>
							<td>
								<div class="userpicture" id="imgArea">
								<%
									if (s!=null) {
											
								%>
										<%if(s.getImage() != null ) { %>
											<img src="<%=request.getContextPath()%>/resources/memberImageFiles/
											<%=s.getImage()%>" id="sampleImg" class="rounded-circle">
										
										<% } else { %>
											<img src="/semiProject/resources/images/usericon.png"
											 id="sampleImg" class="rounded-circle"><br>
										<% } %>
								<%
									} else if (p!=null) {
								%>
										<%if(p.getProImage() != null ) { %>
											<img src="<%=request.getContextPath()%>/resources/memberImageFiles/
											<%=p.getProImage()%>" id="sampleImg" class="rounded-circle">
										
										<% } else { %>
											<img src="/semiProject/resources/images/usericon.png"
											 id="sampleImg" class="rounded-circle"><br>
										<% } %>
								<%
										}
								%>
								<button type="button" id="mimgBtn">사진 첨부</button>
								</div> <input type="file" name="userImg" id="profileImgBtn" style="display: none;"
								onchange="loadImg(this);" />
							</td>

							<!-- 여기까지가 사진삽입부 -->
							<td>
								<div class="mouter">


									<br />

									<div class="form-group row">

										<label for="userNumber" class="col-sm-3 col-form-label">ID</label>

										<div class="col" style="text-align: left;">
											<input type="text" readonly class="form-control-plaintext"
												id="userNumber" name="userId" <%if (s != null) {%>
												value="<%=s.getStudentNo()%>" <%} else {%>
												value="<%=p.getProfessorNo()%>" <%}%>>
										</div>
									</div>
									<!-- 번호자리에 m.getUserNumber -->

									<div class="form-group row">
										<label for="userPwd" class="col-sm-3 col-form-label">비밀번호</label>
										<div class="col-sm-9">
											<input type="password" class="form-control" id="userPwd"
												name="userPwd" placeholder="영대소문자/숫자 포함 6~18자리 이내로 입력하세요." required />
										</div>
									</div>
									<div class="form-group row">
										<label for="userPwd2" class="col-sm-3 col-form-label">비밀번호
											확인</label>
										<div class="col-sm-9">
											<input type="password" class="form-control" id="userPwd2"
												name="userPwd2" required /> <label id="pwdResult"></label>
												<label id="pwdResult2"></label>
										</div>
									</div>


									<!-- 이름 자리에 m.getUserName -->
									<div class="form-group row">
										<label for="userName" class="col-sm-3 col-form-label">이름</label>
										<div class="col-sm-9" style="text-align: left;">
											<input type="text" readonly class="form-control-plaintext"
												id="userName" <%if (s != null) {%> value="<%=s.getName()%>"
												<%} else {%> value="<%=p.getProfessorName()%>" <%}%> >
										</div>
									</div>

									<!-- input 안에 value값 m.getAge -->
									<div class="form-group row">
										<label for="userAge" class="col-sm-3 col-form-label">나이</label>
										<div class="col-sm-9" style="text-align: left;">
											<input type="text" readonly class="form-control-plaintext"
												id="userAge" <%if (s != null) {%>
												value="<%=(ca.get(Calendar.YEAR) - (1900 + Integer.parseInt(s.getStudentSsn().substring(0, 2)))) + 1%>"
												<%} else {%>
												value="<%=(ca.get(Calendar.YEAR) - (1900 + Integer.parseInt(p.getProfessorSsn().substring(0, 2)))) + 1%>"
												<%}%>>
										</div>
									</div>


									<div class="form-group row">
										<label for="userTel" class="col-sm-3 col-form-label">연락처</label>
										<div class="col">
											<input type="text" class="form-control" name="tel1"
												id="userTel1" required>
										</div>
										_
										<div class="col">
											<input type="text" class="form-control" name="tel2"
												id="userTel2" required>
										</div>
										_
										<div class="col">
											<input type="text" class="form-control" name="tel3"
												id="userTel3" required> <br>
										</div>
									</div>
										<label id="userTelResult" style="color:red;"></label>

									<div class="form-group row">
										<label for="userEmail" class="col-sm-3 col-form-label">이메일</label>
										<div class="col-sm-9">
											<input type="email" name="email" class="form-control"
												id="userEmail" 
												<%if (s != null) {%>
												value="<%=s.getEmail()%>" 
												<% } else { %>
												value="<%= p.getProEmail() %>"
												<%}  %> required>

										</div>
									</div>


									<!-- input 안에 value값 m.getEmail -->


									<div class="form-group row">
										<label for="zipCode" class="col-sm-3 col-form-label">우편번호</label>
										<div class="col">
											<input type="text" class="form-control" id="zipCode"
												name="zipCode" required>
										</div>
										<div class="col">
											<button type="button" class="btn btn-primary mb-2" onclick="addrSearch();">검색</button>
										</div>
									</div>

									<div class="form-group row">
										<label for="address1" class="col-sm-3 col-form-label">주소</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="address1"
												name="address1" required>
										</div>
									</div>

									<div class="form-group row">
										<label for="address2" class="col-sm-3 col-form-label">상세주소</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="address2"
												name="address2">
										</div>
									</div>

									<br>
									<div class="btns" align="center">
										<button class="btn btn-primary mb-2" onclick="goMain();">메인으로</button>
										&nbsp;
										<button class="btn btn-primary mb-2"
											onclick="updateMember();">정보수정</button>
											
										&nbsp;&nbsp; <input class="btn btn-primary mb-2" type="reset"
											value="초기화">
									</div>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- ============================================================== -->
<!-- End PAge Content -->
<!-- ============================================================== -->

<script>

	function updateMember() {
		 var confirm = window.confirm("이대로 수정하시겠습니까?");
		 
		if($('.fail').length == 0 && confirm){
			$("#updateForm").submit();
        } else {
            alert('비밀번호 양식에 맞지 않습니다.');
            event.preventDefault();
      
        }

	};
	

	
	$(function() {
		$('#userPwd').change(function() {
			
			var reg1 = /^[A-Za-z0-9_-]{6,18}$/;
			
			if (!reg1.test($('#userPwd').val())) {
				$('#pwdResult').addClass('fail').removeClass('success');
			} else {
				$('#pwdResult').addClass('success').removeClass('fail');
			}
		});
		//비밀번호 일치여부
		$('#userPwd2').change(
				function() {
					
					if ($('#userPwd').val() == $('#userPwd2').val()) {
						$('#pwdResult').html("비밀번호 확인 값이 일치합니다.").css('color', 'blue');
					} else {
						$('#pwdResult').html("비밀번호와 일치하지 않아용구리").addClass('fail').removeClass('success').css('color', 'red');
						$('#userPwd2').val('');
					}
				});

		// 전화번호 숫자 일치여부
		
//		var reg2 = /^[0-9]$/g;
//		$('#userTel1').keyup(
//				function() {
//					if (!reg2.test($('#userTel1').val())) {
//						$('#userTelResult').html("숫자만 입력하세요.");
//						$('#userTel1').focus();
//					} 
//				});
//		$('#userTel2').keyup(
//				function() {
//					if (!reg2.test($('#userTel2').val())) {
//						$('#userTelResult').html("숫자만 입력하세요.");
//						$('#userTel2').focus();
//					} 
//				});
//		$('#userTel3').keyup(
//				function() {
//					if (!reg2.test($('#userTel3').val())) {
//						$('#userTelResult').html("숫자만 입력하세요.");
//						$('#userTel3').focus();
//					}
//				});

		// 사용자 핸드폰 번호 가져오기
		<%if(s!=null) {%>
			var phone1 ='<%=s.getPhone()%>'.substring(0,3);
			var phone2 ='<%=s.getPhone()%>'.substring(3,7);
			var phone3 ='<%=s.getPhone()%>'.substring(7, 11);
		<% } else { %>
			var phone1 ='<%=p.getProPhone()%>'.substring(0,3);
			var phone2 ='<%=p.getProPhone()%>'.substring(3,7);
			var phone3 ='<%=p.getProPhone()%>'.substring(7, 11);
		<% } %>
		
		// 사용자 핸드폰 input에 value 추가
		$('#userTel1').val(phone1);
		$('#userTel2').val(phone2);
		$('#userTel3').val(phone3);

		// 사용자 주소 가져오기
		<% if(s!=null) { %>
			var addressArr='<%=s.getAddress()%>'.split(',');
		<% } else { %>
			var addressArr='<%=p.getProAddress()%>'.split(',');
		<% } %> 
		
		// 사용자 주소 input에 value 추가
		$('#zipCode').val(addressArr[0]);
		$('#address1').val(addressArr[1]);
		$('#address2').val(addressArr[2]);

	});

	// 메인으로 버튼 클릭시 메인이동
	function goMain() {
		location.href = '/semiProject/main.do';
	};

	// 사진첨부 버튼 클릭시
	$('#imgArea').on('click', function() {
		$('#profileImgBtn').click();
	});

	function loadImg(value) {

		if (value.files && value.files[0]) {

			var reader = new FileReader();

			reader.onload = function(e) {
				$('#sampleImg').attr('src', e.target.result);
			}

			reader.readAsDataURL(value.files[0]);
		}
	};
	// 사진첨부의 끝
	
	
	
	// 참조 API : http://postcode.map.daum.net/guide
	function addrSearch() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						$('#zipCode').val(data.zonecode); //5자리 새우편번호 사용

						$('#address1').val(fullAddr);

						// 커서를 상세주소 필드로 이동한다.
						$('#address2').focus();
					}
				}).open();
	};



</script>
<%@ include file="../common/footer.jsp"%>