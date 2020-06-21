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
<div id="printarea">
<table border="1" class="editorDemoTable" style="width: 520px; height: 500px; margin:auto; background-color: white;">
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

</div>

<p style="text-align:center;">
<input type="button" value="인쇄하기" OnClick="goPrint();" >
</p>



<script>

function goPrint(){
    var sw=screen.width;
    var sh=screen.height;
    var w=800;//팝업창 가로길이
    var h=600;//세로길이
    var xpos=(sw-w)/2; //화면에 띄울 위치
    var ypos=(sh-h)/2; //중앙에 띄웁니다.

    var pHeader="<html><head><link rel='stylesheet' type='text/css' href='/Exp_admin/css/print.css'><title>명세서 출력</title></head><body>";
    var pgetContent=document.getElementById("printarea").innerHTML + "<br>";
    //innerHTML을 이용하여 Div로 묶어준 부분을 가져옵니다.
    var pFooter="</body></html>";
    pContent=pHeader + pgetContent + pFooter; 
     
    pWin=window.open("","print","width=" + w +",height="+ h +",top=" + ypos + ",left="+ xpos +",status=yes,scrollbars=yes"); //동적인 새창을 띄웁니다.
    pWin.document.open(); //팝업창 오픈
    pWin.document.write(pContent); //새롭게 만든 html소스를 씁니다.
    pWin.document.close(); //클로즈
    pWin.print(); //윈도우 인쇄 창 띄우고
    pWin.close(); //인쇄가 되던가 취소가 되면 팝업창을 닫습니다.
   }


</script>


</body>
</html>