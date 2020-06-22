<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semiProject.member.model.vo.*"%>
<%
	Professor p = (Professor)session.getAttribute("professor");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의계획서</title>
</head>
<style>
	
	
	
	table, tr, td {
		border : 1px solid black;
	}
	
	.textarea {
		 border-style: none;
        border-color: Transparent;
        overflow: auto;
        outline: none;
        height : 50px;
        resize : none;
	}
</style>

<body>
<form>
<table style="width: 599px; height: 849px; margin: auto;">
<tbody>
<tr style="height: 73px;">
<td style="width: 540px; height: 73px; text-align: center;" colspan="8">
<h1><strong>강의계획서</strong></h1>
</td>
</tr>
<tr style="height: 18px;">
<td style="height: 18px; text-align: center;"colspan="2">개설학과</td>
<td style="weight: 200px; height: 18px; text-align:center;" colspan="3">
<%= p.getDeptName() %>
</td>
<td style="weight:50px; height: 18px; text-align: center;">교과목명</td>
<td style="height: 18px;" colspan="2"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none;" type="text" /></td>
</tr>
<tr style="height: 18px;">
<td style="width: 200px; height: 54px; text-align: center;" rowspan="3">담당자</td>
<td style="width: 200px; height: 18px; text-align: center;">성명</td>
<td style="width: 80px; height: 18px;" colspan="3"><%= p.getProfessorName() %></td>
<td style="width: 150px; height: 18px; text-align: center;">홈페이지</td>
<td style="width: 208px; height: 18px;" colspan="2"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none;" type="text" /></td>
</tr>
<tr style="height: 18px;">
<td style="width: 200px; height: 18px; text-align: center;">전화번호</td>
<td style="width: 101px; height: 18px;" colspan="3"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none;" type="text" /></td>
<td style="width: 101px; height: 18px; text-align: center;"><span style="display: inline !important; float: none; background-color: #ffffff; color: #000000; cursor: text; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;">E-Mail</span></td>
<td style="width: 208px; height: 18px;" colspan="2"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none;" type="text" /></td>
</tr>
<tr style="height: 18px;">
<td style="width: 200px; height: 18px; text-align: center;">강의실</td>
<td style="width: 422px; height: 18px;" colspan="6"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none;" type="text" /></td>
</tr>
<tr style="height: 24.06px;">
<td style="width: 161px; height: 24.06px; text-align: center;" colspan="2">1.수업목표</td>
<td style="width: 422px; height: 24.06px;" colspan="6"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width:400px" type="text" /></td>
</tr>
<tr style="height: 18px;">
<td style="width: 161px; height: 18px;" colspan="2">
<div style="text-align: center;">2.교재 및&nbsp;</div>
<div style="text-align: center;">참고 문헌</div>
</td>
<td style="width: 422px; height: 18px;" colspan="6">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 400px;"> 
  </td>
</tr>
<tr style="height: 18px;">
<td style="width: 161px; height: 18px; text-align: center;" colspan="2" rowspan="3">3. 평가방법</td>
<td style="width: 28px; height: 18px;" colspan="2" rowspan="2">
<p style="text-align: center;">%</p>
</td>
<td style="width: 67px; height: 18px; text-align: center;">시험</td>
<td style="width: 101px; height: 18px;">
  <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width:50px">
  </td>
<td style="width: 89px; height: 18px; text-align: center;">과제</td>
<td style="width: 113px; height: 18px;">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width:50px">
  </td>
</tr>
<tr style="height: 18px;">
<td style="width: 67px; height: 18px; text-align: center;">출석</td>
<td style="width: 101px; height: 18px;">
  <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width:50px;">
  </td>
<td style="width: 89px; height: 18px; text-align: center;">기타</td>
<td style="width: 113px; height: 18px;">
  <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width:50px;">
  </td>
</tr>
<tr style="height: 18px;">
<td style="width: 422px; height: 18px;" colspan="6">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;">
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 161px; height: 18px; text-align: center;" colspan="2" rowspan="11"><span style="display: inline !important; float: none; background-color: #ffffff; color: #000000; cursor: text; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;">4. 강의계획서</span></td>
<td style="width: 17.8px; height: 18px;">&nbsp;</td>
<td style="width: 398.2px; height: 18px; text-align: center;" colspan="5"><span style="display: inline !important; float: none; background-color: #ffffff; color: #000000; cursor: text; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;">강 의 내 용</span></td>
</tr>
<tr style="height: 18px;">
<td style="width: 17.8px; height: 18px; text-align: center;">1</td>
<td style="width: 398.2px; height: 18px;" colspan="5">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;"> 
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 17.8px; height: 18px; text-align: center;">2</td>
<td style="width: 398.2px; height: 18px;" colspan="5">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;">
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 17.8px; height: 18px; text-align: center;">3</td>
<td style="width: 398.2px; height: 18px;" colspan="5">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;">
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 17.8px; height: 18px; text-align: center;">4</td>
<td style="width: 398.2px; height: 18px;" colspan="5">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;">
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 17.8px; height: 18px; text-align: center;">5</td>
<td style="width: 398.2px; height: 18px;" colspan="5">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;">
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 17.8px; height: 18px; text-align: center;">6</td>
<td style="width: 398.2px; height: 18px;" colspan="5">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;">
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 17.8px; height: 18px; text-align: center;">7</td>
<td style="width: 398.2px; height: 18px;" colspan="5">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;">
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 17.8px; height: 18px; text-align: center;">8</td>
<td style="width: 398.2px; height: 18px;" colspan="5">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;">
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 17.8px; height: 18px; text-align: center;">9</td>
<td style="width: 398.2px; height: 18px;" colspan="5">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;">
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 17.8px; height: 18px; text-align: center;">10</td>
<td style="width: 398.2px; height: 18px;" colspan="5">
 <input type="text" style="border-style: none;border-color: Transparent; overflow: auto; outline: none; width: 380px;">
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 161px; height: 18px; text-align: center;" colspan="2">
<div style="text-align: center;">
<p>5.수강생 참고사항</p>
</div>
</td>
<td style="width: 422px; height: 18px;" colspan="6">
<textarea class="textarea" style="width:380px; resize:none;"></textarea>
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 161px; height: 18px;" colspan="2">
<div style="text-align: center;">&nbsp;</div>
<div style="text-align: center;">6.부정행위자에</div>
<div style="text-align: center;">대한 처리</div>
<div style="text-align: center;">&nbsp;</div>
</td>
<td style="width: 422px; height: 18px;" colspan="6">
<textarea class="textarea" style="width:380px; height:66px; resize:none;"></textarea>
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 161px; height: 18px; text-align: center;" colspan="2">
<div>&nbsp;</div>
<div>7.기타주의사항</div>
<div>&nbsp;</div>
</td>
<td style="width: 422px; height: 18px;" colspan="6">
<textarea class="textarea" style="width:380px; resize:none;"></textarea>
</td>
</tr>
</tbody>
</table>
<p style="text-align:center;">
<input type="submit" value="제출하기" onclick="return planSubmit();">
</p>
</form>
<script>

function planSubmit(){
	var confirm = window.confirm("강의계획서를 이대로 제출하시겠습니까?");
	if(confirm){
		window.close();
		return true;
	}else {
		return false;
	}
}

</script>


</body>
</html>