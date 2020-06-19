<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.*,
    												com.kh.semiProject.member.model.vo.*,
    												com.kh.semiProject.salary.model.vo.*"%>
<%
	Professor p = (Professor)session.getAttribute("professor");
	Salary s = (Salary)request.getAttribute("salary");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>월급 명세서</title>
</head>
<style>
   td, tr {
   
   border : 1px solid black;
   
   } 
</style>


<body>

<table class="editorDemoTable" style="width: 520px; height: 500px; margin:auto; background-color: white; border: 1px solid;">
<tbody>
<tr>
<td style="width: 486px; height: 100px; text-align: center;" colspan="4">
<h2><span style="background-color: #ffffff;"><strong>근로 소득 지급 명세서</strong></span></h2>
</td>
</tr>
<tr>
<td style="width: 114.724px; text-align: center;"><span style="background-color: #ffffff;">소 속</span></td>
<td style="width: 371.276px; text-align: center;" colspan="3"><%=p.getDeptName() %></td>
</tr>
<tr>
<td style="width: 114.724px; text-align: center;"><span style="background-color: #ffffff;">직 종</span></td>
<td style="width: 371.276px; text-align: center;" colspan="3">교 수</td>
</tr>
<tr>
<td style="width: 114.724px; text-align: center;"><span style="background-color: #ffffff;">성 명</span></td>
<td style="width: 371.276px; text-align: center;" colspan="3"><%= p.getProfessorName() %></td>
</tr>
<tr>
<td style="width: 114.724px; text-align: center;"><span style="background-color: #ffffff;">주민등록번호</span></td>
<td style="width: 121.276px; text-align: center;"><%= p.getProfessorSsn() %></td>
<td style="width: 118px; text-align: center;">총 금액</td>
<td style="width: 132px; text-align: center;"><%= s.getTotalAmount() %></td>
</tr>
<tr>
<td style="width: 114.724px; text-align: center;"><span style="background-color: #ffffff;">은행명</span></td>
<td style="width: 121.276px; text-align: center;"><%= s.getBankName() %></td>
<td style="width: 118px; text-align: center;">세금</td>
<td style="width: 132px; text-align: center;"><%= s.getTax() %></td>
</tr>
<tr>
<td style="width: 114.724px; text-align: center;"><span style="background-color: #ffffff;">계좌번호</span></td>
<td style="width: 121.276px; text-align: center;"><%= s.getBankNo() %></td>
<td style="width: 118px; text-align: center;">실 수령액</td>
<td style="width: 132px; text-align: center;"><%= s.getTotalAmount() - s.getTax() %></td>
</tr>
<tr>
<td style="height: 350px; text-align: center; width: 486px;" colspan="4">
<p style="text-align: center;"><span style="background-color: #ffffff;">위와 같이 급여(강의료)를 지불합니다.</span></p>
<p>&nbsp;</p>
<p style="text-align: center;"><%= s.getAmountDate() %></p>
<p>&nbsp;</p>
<p style="text-align: right;">&nbsp;</p>
</td>
</tr>
<tr>
<td style="height: 150px; text-align: center; width: 486px;" colspan="4">
<h1><span style="background-color: #ffffff;"><strong>신세대학교 총장 귀하</strong> <img style="float: center; width: 80px; height: 60px;" src="/semiProject/resources/images/dojang.jpg" /> </span></h1>
</td>
</tr>
</tbody>
</table>



</body>
</html>