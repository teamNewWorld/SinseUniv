<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
.searchbtn {
   font-size: 100%;
   border: 0;
   border-radius: 1rem;
   letter-spacing: .1rem;
   font-weight: bold;
   padding: 1rem;
   color: black;
   weight: 200px;
   height: 55px;
   background: lightgray;
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
</head>
<body>
   <header>
      <img src="/semiProject/resources/images/LOGO_white.png" width="150"
         alt="logo" style = " left : 15px; "/>
   </header>
   
   <br />
   
   <div class = "tabmenu">
   <ul>
      <li id = "tab1" class = "btnCon">
         <div class="card">
         <h3 class="card-title">아이디 찾기</h3>
         <form action="/semiProject/FindId.do" class="findid" method="post">
         <div id ="tb">
            <table>
               <tr>
                  <td>구 분</td>
                     <td>
                     <div class="form-label-group">
                        <select name="type" id="type">
                           <option value="stu">학생</option>
                           <option value="pro">교수</option>
                        </select>
                     </div></td>
               </tr>
               <tr>
                  <td>이름</td>
                  <td><div class="form-label-group">
                        <input type="text" id="userName" name="userName" class="userInfo"
                           placeholder="성명" required autofocus>
                     </div></td>
                  <td rowspan="2">
                     <div>
                        <button class="searchbtn" type="submit"
                           onclick="return check();">찾기</button>
                     </div>
                  </td>
               </tr>
               <tr>
                  <td>주민등록번호</td>
                  <td>
                     <div class="form-label-group">
                        <input type="text" id="userNum1" name="userNum1" class="userInfo" size=7
                           required> - <input type="password" id="userNum2" name="userNum2" size=7
                           class="userInfo" required>
                     </div>
                  </td>
               </tr>
            </table></div>
         </form>
      </div>
      </li>
   </ul>
   
   </div>
   <script>
   location.href = "#tab1";
   
   function check(){
      if($('#userName').val() == null){
         alert('이름을 입력해주세요');
         return false;
      } else if ($('#userNum1').val() == null || $('#userNum2').val() == null ) {
         alert('주민등록번호를 입력해주세요');
         return false;
      }
   }
   </script>
   

</body>
</html>







