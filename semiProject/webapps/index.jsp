<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학사정보페이지 로그인</title>
    <script src="/semiProject/resources/js/jquery-3.5.1.min.js"></script>
<link rel = "stylesheet" href = "resources/assets/plugins/bootstrap/css/bootstrap.min.css"> 
<link rel = "stylesheet" href = "resources/css/login.css">
<style>
body {
  background-image : url('resources/images/campus2.png');
 background-repeat : no-repeat;
  
}
</style>
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">로그인</h5>
           
            <form class="form-signin" id="loginForm" action="/semiProject/login.do" method = "post">
              <div class="form-label-group">
                	<select name="loginType" id="loginType" class="form-control" autofocus>
                		<option value="stu">학생</option>
                		<option value="pro">교수</option>
                	</select>
              </div>
              <div class="form-label-group">
                <input type="text" name="userId" id="userId" class="form-control" placeholder="아이디(학번)" required autofocus>
              </div>

              <div class="form-label-group">
                <input type="password" name="userPwd" id="userPwd" class="form-control" placeholder="비밀번호" required>
          
              </div>

              <div class="loginCheckbox">
                <label class="loginCheck"  id="loginCheck" for="loginCheck"></label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">로그인</button>
              <hr class="my-4">
              <div class = "find">
              <a href = 'views/findLogin.jsp' 
              onclick = "window.open(this.href, '개인정보 찾기','width = 580, height = 330');return false">아이디 / 패스워드 찾기</a>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
	<script>
	$('#loginForm').submit(function(event){
		$.ajax({
			url : '/semiProject/loginCheck.do',
			async : false,
			data : {
				loginType : $('#loginType').val(),
				userId : $('#userId').val(),
				userPwd : $('#userPwd').val()
			}, success : function(data){
				if(data == -1) {
					$("#loginCheck").html("<p style='color:red'>해당하는 사용자가 없습니다.</p>").fadeIn(500);
					$("#loginCheck").delay(2000);
					$("#loginCheck").fadeOut(500);
					
					event.preventDefault();
				} else if(data == 1){
					$("#loginCheck").html("<p style='color:red'>비밀번호가 잘못 입력되었습니다.</p>").fadeIn(500);
					$("#loginCheck").delay(2000);
					$("#loginCheck").fadeOut(500);
					
					event.preventDefault();
				}
			}
		});
		
	});
	
	</script>
</body>
</html>