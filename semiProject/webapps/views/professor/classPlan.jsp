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
<table style="width: 598px; height: 1049px; margin: auto;">
<tbody>
<tr style="height: 73px;">
<td style="width: 553px; height: 73px; text-align: center;" colspan="7">
<h1><strong>강의계획서</strong></h1>
</td>
</tr>
<tr style="height: 18px;">
<td style="height: 18px; text-align: center; width: 148.596px;" colspan="2">개설학과</td>
<td style="height: 18px; text-align: center; width: 146.404px;" colspan="2"><%= p.getDeptName() %></td>
<td style="height: 18px; text-align: center; width: 81px;">교과목명</td>
<td style="height: 18px; width: 177px;" colspan="2"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none;" type="text" /></td>
</tr>
<tr style="height: 1px;">
<td style="width: 64px; height: 7.60417px; text-align: center;" rowspan="3">담당자</td>
<td style="width: 84.5964px; height: 1px; text-align: center;">성명</td>
<td style="width: 146.404px; height: 1px;" colspan="2"><%= p.getProfessorName()%>&nbsp;</td>
<td style="width: 81px; height: 1px; text-align: center;">이수구분</td>
<td style="width: 177px; height: 1px;" colspan="2"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none;" type="text" /></td>
</tr>
<tr style="height: 18px;">
<td style="width: 84.5964px; height: 18px; text-align: center;">전화번호</td>
<td style="width: 146.404px; height: 18px;" colspan="2"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none;" type="text" /></td>
<td style="width: 81px; height: 18px; text-align: center;"><span style="display: inline !important; float: none; background-color: #ffffff; color: #000000; cursor: text; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;">E-Mail</span></td>
<td style="width: 177px; height: 18px;" colspan="2"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none;" type="text" /></td>
</tr>
<tr style="height: 18px;">
<td style="width: 84.5964px; height: 18px; text-align: center;">강의실</td>
<td style="width: 404.404px; height: 18px;" colspan="5"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none;" type="text" /></td>
</tr>
<tr style="height: 24px;">
<td style="width: 148.596px; height: 24px; text-align: center;" colspan="2">1.수업목표</td>
<td style="width: 404.404px; height: 24px;" colspan="5"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 400px;" type="text" /></td>
</tr>
<tr style="height: 18px;">
<td style="width: 148.596px; height: 18px;" colspan="2">
<div style="text-align: center;">2.교재 및&nbsp;</div>
<div style="text-align: center;">참고 문헌</div>
</td>
<td style="width: 404.404px; height: 18px;" colspan="5"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 400px;" type="text" /></td>
</tr>
<tr style="height: 18px;">
<td style="width: 148.596px; height: 57px; text-align: center;" colspan="2" rowspan="3">3. 평가방법</td>
<td style="width: 12.4036px; height: 36px;" rowspan="2">
<p style="text-align: center;">%</p>
</td>
<td style="width: 134px; height: 18px; text-align: center;">시험</td>
<td style="width: 81px; height: 18px;"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 50px;" type="text" /></td>
<td style="width: 77px; height: 18px; text-align: center;">과제</td>
<td style="width: 100px; height: 18px;"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 50px;" type="text" /></td>
</tr>
<tr style="height: 18px;">
<td style="width: 134px; height: 18px; text-align: center;">출석</td>
<td style="width: 81px; height: 18px;"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 50px;" type="text" /></td>
<td style="width: 77px; height: 18px; text-align: center;">기타</td>
<td style="width: 100px; height: 18px;"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 50px;" type="text" /></td>
</tr>
<tr style="height: 21px;">
<td style="width: 404.404px; height: 21px;" colspan="5"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /></td>
</tr>
<tr style="height: 21px;">
<td style="width: 148.596px; height: 310px; text-align: center;" colspan="2" rowspan="2"><span style="display: inline !important; float: none; background-color: #ffffff; color: #000000; cursor: text; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;">4. 강의계획서</span></td>
<td style="width: 404.404px; height: 21px; text-align: center;" colspan="5"><span style="display: inline !important; float: none; background-color: #ffffff; color: #000000; cursor: text; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;">강 의 내 용</span></td>
</tr>
<tr style="height: 292px;">
<td style="width: 404.404px; height: 292px; text-align: center;" colspan="5"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 420px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 420px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 420px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 420px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 420px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 420px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 420px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 420px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 420px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 420px;" type="text" /></td>
</tr>
<tr style="height: 21px;">
<td style="width: 148.596px; height: 18px; text-align: center;" colspan="2">
<div style="text-align: center;">
<p>5.수강생 참고사항</p>
</div>
</td>
<td style="width: 404.404px; height: 18px;" colspan="5"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" />&nbsp;</td>
</tr>
<tr style="height: 75px;">
<td style="width: 148.596px; height: 75px;" colspan="2">
<div style="text-align: center;">&nbsp;</div>
<div style="text-align: center;">&nbsp;</div>
<div style="text-align: center;">6.부정행위자에</div>
<div style="text-align: center;">대한 처리</div>
<div style="text-align: center;">&nbsp;</div>
<div style="text-align: center;">&nbsp;</div>
</td>
<td style="width: 404.404px; height: 75px;" colspan="5"><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" /><input style="border-style: none; border-color: Transparent; overflow: auto; outline: none; width: 380px;" type="text" />&nbsp;</td>
</tr>
</tbody>
</table>
<p style="text-align: center;"><input type="submit" value="제출하기" /></p>
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