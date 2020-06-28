<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.kh.semiProject.Student.model.vo.*"%>
<%
	Sugang su = (Sugang)session.getAttribute("sugang");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>강의계획서</title>
<style>
	#clsPlnTable tr td {
		border : 1px solid black;
	}
	
	.textarea {
		 border-style: none;
        border-color: Transparent;
        overflow: auto;
        outline: none;
        resize : none;
	}
</style>
</head>
<body>
<table id="clsPlnTable" style="width: 598px; height: 1049px; margin: auto;">
<tbody>
<tr style="height: 73px;">
<td style="width: 553px; height: 73px; text-align: center;" colspan="7">
<h1><strong>강의계획서</strong></h1>
</td>
</tr>
<tr style="height: 18px;">
<td style="width: 100px;height: 18px; text-align: center; " colspan="2">개설학과</td>
<td style="height: 18px; text-align: center; " colspan="2"><%= su.getDeptName() %></td>
<td style="height: 18px; text-align: center; ">교과목명</td>
<td style=" width: 200px; height: 18px; " colspan="2">
<%= su.getCls_name() %>
</td>
</tr>
<tr style="height: 1px;">
<td style="width: 60px; height: 7.60417px; text-align: center;" rowspan="3">담당자</td>
<td style="width: 70px; height: 1px; text-align: center;">성명</td>
<td style=" height: 1px;" colspan="2"><%= su.getProfessorName()%>&nbsp;</td>
<td style=" height: 1px; text-align: center;">이수구분</td>
<td style=" height: 1px;" colspan="2"><%= su.getCls_type() %></td>
</tr>
<tr style="height: 18px;">
<td style="width: 70px; height: 18px; text-align: center;">전화번호</td>
<td style=" height: 18px;" colspan="2"><%= su.getProPhone() %></td>
<td style=" height: 18px; text-align: center;"><span style="display: inline !important; float: none; background-color: #ffffff; color: #000000; cursor: text; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-width: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;">E-Mail</span></td>
<td style=" height: 18px;" colspan="2"><%= su.getProEmail() %></td>
</tr>
<tr style="height: 18px;">
<td style="width: 70px; height: 18px; text-align: center;">강의실</td>
<td style=" height: 18px;" colspan="5">추후 공지</td>
</tr>
<tr style="height: 24px;">
<td style="width: 100px; height: 24px; text-align: center;" colspan="2">1. 수업목표</td>
<td style=" height: 24px;" colspan="5">

<input name="goal" value="<%= su.getGoal() %>" style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 400px;" type="text" required />

</td>
</tr>
<tr style="height: 18px;">
<td style="width: 100px; height: 18px;" colspan="2">
<div style="text-align: center;">2. 교재 및&nbsp;</div>
<div style="text-align: center;">참고 문헌</div>
</td>
<td style=" height: 18px;" colspan="5">

<input name="book" value="<%= su.getBook() %>" style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 400px;" type="text" required />

</td>
</tr>
<tr style="height: 18px;">
<td style="width: 100px; height: 57px; text-align: center;" colspan="2" rowspan="3">3. 평가방법</td>
<td style=" height: 36px;" rowspan="2">
<p style="text-align: center;">%</p>
</td>

<% String[] pgradeArr = su.getpGrade().split(","); %>
<td style=" height: 18px; text-align: center;">시험</td>
<td style="width:100px; height: 18px;">
<input name="test" value="<%= pgradeArr[0] %>" style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 50px;" type="text" required />

</td>
<td style=" height: 18px; text-align: center;">과제</td>
<td style="width:100px; height: 18px;">
<input name="hw" value="<%= pgradeArr[1] %>" style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 50px;" type="text" required />

</td>
</tr>
<tr style="height: 18px;">
<td style=" height: 18px; text-align: center;">출석</td>
<td style="width:100px; height: 18px;">
<input name="attendance" value="<%= pgradeArr[2] %>" style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 50px;" type="text" required />

</td>
<td style=" height: 18px; text-align: center;">기타</td>
<td style="width:100px; height: 18px;">
<input name="else" value="<%= pgradeArr[3] %>" style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 50px;" type="text" required />

</td>
</tr>
<tr style="height: 21px;">
<td style=" height: 21px;" colspan="5"><input name="pGrade2" value="<%= su.getpGrade2() %>" style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" required /></td>
</tr>

<tr style="height: 21px;">
<td style="width: 100px; height: 310px; text-align: center;" colspan="2" rowspan="2"><span style="display: inline !important; float: none; background-color: #ffffff; color: #000000; cursor: text; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-width: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;">4. 강의계획서</span></td>
<td style=" height: 21px; text-align: center;" colspan="5"><span style="display: inline !important; float: none; background-color: #ffffff; color: #000000; cursor: text; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-width: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;">강 의 내 용</span></td>
</tr>
<tr style="height: 292px;">
<td style=" height: 292px; text-align: center;" colspan="5">

 <textarea name="plan" class="textarea" style="width:420px; height:300px;"><%= su.getpPlan() %></textarea> 

</td>
</tr>
<tr style="height: 21px;">
<td style="width: 100px; height: 18px; text-align: center;" colspan="2">

<p style="text-align: center;">5. 수강생<br> 참고사항</p>

</td>
<td style=" height: 25px;" colspan="5">

<input name="etc" value="<%= su.getEtc() %>" style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 400px;" type="text" required />


</td>
</tr>
<tr style="height: 75px;">
<td style="width: 100px; height: 75px;" colspan="2">
<div style="text-align: center;">&nbsp;</div>
<div style="text-align: center;">&nbsp;</div>
<div style="text-align: center;">6. 부정행위자에</div>
<div style="text-align: center;">대한 처리</div>
<div style="text-align: center;">&nbsp;</div>
<div style="text-align: center;">&nbsp;</div>
</td>
<td style="width: 404.404px; height: 75px;" colspan="5">
 
<textarea name="cheat" class="textarea" style="width:400px; height:400px;"><%= su.getCheat() %></textarea>

</td>
</tr>
</tbody>
</table>

</body>
</html>