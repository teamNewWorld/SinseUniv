<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,
    												com.kh.semiProject.member.model.vo.*,
    												com.kh.semiProject.tuition.model.vo.*"%>
    												
<%
	Student s = (Student)session.getAttribute("student");
	TutionPrint tp = (TutionPrint)request.getAttribute("tutionprint");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>이수과목조회</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.css">
    <script src="../../resources/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="../../resources/js/bootstrap.js"></script>
</head>
<body>
<div id="printarea">
<table border="1" style="width: 442.27px; height: 403px; margin:auto;">
<tbody>
<tr style="height: 73px;">
<td style="width: 776.54px; height: 73px; text-align: center;" colspan="7">
<h1><strong>등 록 금 고 지 서</strong></h1>
</td>
</tr>
<tr style="height: 54px; text-align: center;">
<td style="width: 111px; height: 54px; text-align: center;" colspan="2">학교명</td>
<td style="width: 665.54px; height: 54px;" colspan="5">
<h3>신세대학교</h3>
</td>
</tr>
<tr style="height: 18px; text-align: center;">
<td style="width: 111px; height: 18px; text-align: center;" colspan="2">학과</td>
<td style="width: 100px; height: 18px;"><%=s.getDeptName() %></td>
<td style="width: 127px; height: 18px;" colspan="2">주민등록번호</td>
<td style="width: 438.54px; height: 18px;" colspan="2"><%=s.getStudentSsn() %></td>
</tr>
<tr style="height: 18px; text-align: center;">
<td style="width: 58px; height: 36px;" rowspan="2">대상자</td>
<td style="width: 53px; height: 18px;">성명</td>
<td style="width: 100px; height: 18px;"><%=s.getName() %></td>
<td style="width: 117px; height: 18px;">전화번호</td>
<td style="width: 448.54px; height: 18px;" colspan="3"><%=s.getPhone() %></td>
</tr>
<tr style="height: 18px; text-align: center;">
<td style="width: 53px; height: 18px;">주소</td>
<td style="width: 665.54px; height: 18px;" colspan="5"><%=s.getAddress() %></td>
</tr>
<tr style="height: 54px; text-align: center;">
<td style="width: 776.54px; height: 54px;" colspan="7">
<h3>등 록 금 부 담 내 역</h3>
</td>
</tr>
</tr>
<tr style="height: 27.4662px; text-align: center;">
<td style="width: 110.208px; height: 27.4662px;" colspan="2">구분</td>
<td style="width: 93.5417px; height: 27.4662px;">
<div style="text-align: center; color: #000000; text-transform: none; text-indent: 0px; letter-spacing: normal; font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; text-decoration: none; word-spacing: 0px; white-space: normal; orphans: 2; -webkit-text-stroke-width: 0px;">수업료</div>
</td>
<td style="width: 118.042px; height: 27.4662px;" colspan="3">
<div>장학금수혜 금액</div>
</td>
<td style="width: 96.0417px; height: 27.4662px;">
<div>실 납부금액</div>
</td>
</tr>
<tr style="height: 18px; text-align: center;">
<td style="width: 110.208px; height: 18px;" colspan="2"><%=tp.getEnrolldate() %></td>
<td style="width: 93.5417px; height: 18px;"><%=tp.getEnrollmoney() %></td>
<td style="width: 116.042px; height: 18px;" colspan="3"><%=tp.getPrice() %></td>
<td style="width: 96.0417px; height: 18px;"><%=tp.getScholarshipprice()%></td>
</tr>
<tr style="height: 18px;">
<td style="width: 776.54px; height: 18px; text-align: center;" colspan="7">위 금액(실 납부금액)을 납부하시기 바랍니다.&nbsp;</td>
</tr>
<tr style="height: 72px;">
<td style="width: 776.54px; height: 72px; text-align: center;" colspan="7">
<!-- <div>납부기간 : 2020. 02.07 ~ 02.16 16시까지</div>-->
<div>납부장소 : 농협은행 전지점</div>
<div>가상계좌 : 279802-04-118923</div>
<div>문의처 : 입학관리과(02-2564-1541), 장학팀(02-2564-1555)</div>
</td>
</tr>
<tr style="height: 164.49px;">
<td style="width: 776.54px; height: 164.49px; text-align: center;" colspan="7">
<h1 style="text-align: left;">&nbsp;</h1>
<img src="/semiProject/resources/images/dojang.jpg"  style="float: right; width:80px; height:60px;" alt="등록금고지서" />
<h1 style="text-align: left;">신 세 대 학 교 총 장&nbsp;</h1>
<div>&nbsp;</div>
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

    var pHeader="<html><head><link rel='stylesheet' type='text/css' href='/Exp_admin/css/print.css'><title>고지서 출력</title></head><body>";
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