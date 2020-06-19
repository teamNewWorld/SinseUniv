<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.sql.*,com.kh.semiProject.member.model.vo.*"%>
<%
	String r1 = (String)request.getAttribute("findStuId");
	String r2 = (String)request.getAttribute("findProId");
%> 
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
   <form action="/semiProject/goPwdSet.do">
   	<% if(r1 == null && r2 == null){ %>
		<p>해당하는 아이디가 없습니다</p>
		<button type="button" onclick="fn_back();">다시 찾기</button>
    <% } else if( r1 != null) { %>
    	<p>해당 학생의 아이디는 <%= r1 %> 입니다.</p><br />
    	<button type="button" onclick="fn_loginId('stu');">돌아가기</button>&nbsp;
    	<input type="hidden" name="userId" value="<%= r1 %>"/>
    	<input type="hidden" name="type" value="stu"/>
    	<button type="submit">비밀번호 재설정</button>
    <% } else { %>
    	<p>해당 교수의 아이디는 <%= r2 %> 입니다.</p>
    	<button type="button" onclick="fn_loginId('pro');">돌아가기</button>
    	<input type="hidden" name="userId" value="<%= r2 %>"/>
    	<input type="hidden" name="type" value="pro"/>
    	<button type="submit">비밀번호 재설정</button>
    <% } %>
    
    </form>
   </div>
   	
   <script>
   function fn_back(){
	   location.href = '/semiProject/views/findLogin.jsp';
   }
   
   function fn_loginId(type){
	   if(type == 'stu'){
		   opener.document.getElementById("loginType").options[0].selected = true;
		   opener.document.getElementById("userId").value = '<%= r1 %>';
		   window.close();
	   } else {
		   opener.document.getElementById("loginType").options[1].selected = true;
		   opener.document.getElementById("userId").value = '<%= r2 %>';
		   window.close();
	   }
   }
   </script>
   

</body>
</html>








