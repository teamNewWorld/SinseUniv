<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.sql.*,com.kh.semiProject.member.model.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 찾기</title>

<style>
*{
  margin:0; padding:0;
  font-size:15px; 
  line-height:1.3;
}
ul{list-style:none;}

.tabmenu{ 
  max-width:500px; 
   position:relative; 
      margin : 20px;
}
.tabmenu ul li{
  display:  inline-block;
  width:25%; 
  float:left;  
  text-align:center; 
  background :white;
}
.tabmenu ul li a{
  display:block;
  height:25px;
  top : 10px;
  text-decoration:none; 
  color : black;
  vertical-align: middle;
}
.card{
  display:none; 
  text-align:left; 
  width : 500px;
  left : 0;
   padding: 3px 10px 20px 30px;

  position:absolute; 
     border: 1px gray solid;
    background-color: white;
}
.btnCon:target  {
  background : lightgray;
}
.btnCon:target .card{
  display: block;
}

.tmenu{
padding: 10px 0 0 0;
}

.card-title {
   text-align: center; font-size : 1.5rem;
   margin : 20px;
   font-weight: bold;
   font-size: 1.5rem;
}

td>div {
   padding: 0 0 0 15px;
}
#tb{
margin : 25px;
}
.tabmenu {
text-align : center;
}

header {
   background-color: #1f83e1;
   
   height: 50px;
}

header img {
   padding: 0px;
}

.tap>button {
   width: 20%;
   font-size : 85%;
   border: 0;
   padding: 10px;
   color: black;
   background: white;
}

</style>
<script src="/semiProject/resources/js/jquery-3.5.1.min.js"></script>
</head>
<body>
   <header>
      <img src="/semiProject/resources/images/LOGO_white.png" width="150" 
         alt="logo" style = " left : 15px; "/>
   </header>
   
   <br />
   
   <div class = "tabmenu">
	<form action="/semiProject/pwdSet.do" method="post">
		<table style="border:none">
			<tr>
				<td>비밀번호 :</td>
				<td colspan =3>
				<input type="password" name="pwd" id="pwd" />
				</td>
			</tr>
			<tr>
				<td>비밀번호 확인 : </td>
				<td colspan=3>
				<input type="password" name="chkPwd" id="chkPwd" />
				</td>
			</tr>
		</table>
		<br />
		<button type="button" onclick="checkPwd();">비밀번호 변경하기</button>
	</form>
   </div>
   	
   <script>
		function checkPwd(){
			
			if($('#pwd').val() != $('#chkPwd').val()){
				alert('비밀번호를 확인해주세요');
			} else {
				$.ajax({
					url: '/semiProject/pwdSet.do',
					data : {
						pwd : $('#pwd').val(),
						chkPwd : $('#chkPwd').val(), 
						userId : '<%= (String)request.getAttribute("userId")%>',
						type : '<%= (String)request.getAttribute("type")%>'
					}, success : function(data){
						console.log(data);
						if(data == 1){
							alert('비밀번호 수정이 완료되었습니다.');
							window.close();
						} else {
							alert('서버오류, 이동규 사원에게 문의하세요!');
						}
					}
					
				});
			}
		}
		
   </script>
   

</body>
</html>








