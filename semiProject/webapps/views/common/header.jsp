<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semiProject.member.model.vo.*"%>
<!-- 로그인시 로그인정보 유지 -->
<%
	Student s = (Student)session.getAttribute("student");
	Professor p = (Professor)session.getAttribute("professor");
%>   
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="/semiProject/resources/images/favicon.png">
    <title>신세대학교 학사정보 시스템</title>
    <script src="/semiProject/resources/js/jquery-3.5.1.min.js"></script>
    <!-- Bootstrap Core CSS -->
    
    <link href="/semiProject/resources/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- chartist CSS -->
    <link href="/semiProject/resources/assets/plugins/chartist-js/dist/chartist.min.css" rel="stylesheet">
    <link href="/semiProject/resources/assets/plugins/chartist-js/dist/chartist-init.css" rel="stylesheet">
    <link href="/semiProject/resources/assets/plugins/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css" rel="stylesheet">
    <!--This page css - Morris CSS -->
    <link href="/semiProject/resources/assets/plugins/c3-master/c3.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/semiProject/resources/css/style.css" rel="stylesheet">
	<link href="/semiProject/resources/css/member.css" rel="stylesheet">
	<link href="/semiProject/resources/css/stuInfo.css" rel="stylesheet">
	<link href="/semiProject/resources/css/common.css" rel="stylesheet">
	<link href="/semiProject/resources/css/main.css" rel="stylesheet">
	<link href="/semiProject/resources/css/classPlan.css" rel="stylesheet">
	<link href="/semiProject/resources/css/board.css" rel="stylesheet">
    <link href="/semiProject/resources/css/regChange.css" rel="stylesheet" type="text/css">
    <!-- You can change the theme colors from here -->
    <link href="/semiProject/resources/css/colors/blue.css" id="theme" rel="stylesheet">
   <link href=" https://unpkg.com/@fullcalendar/core@4.4.2/main.min.css" rel="stylesheet" type="text/css">
    <link href="https://unpkg.com/@fullcalendar/daygrid@4.4.2/main.min.css" rel="stylesheet" type="text/css">
    <link href="https://unpkg.com/@fullcalendar/timegrid@4.4.2/main.min.css" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    
<![endif]-->
	<link rel="stylesheet"  href="/semiProject/resources/css/jquery-ui.min.css" />
</head>

<body class="fix-header fix-sidebar card-no-border">
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar" >
            <nav class="navbar top-navbar navbar-toggleable-sm navbar-light">
                <!-- ============================================================== -->
                <!-- Logo -->
                <!-- ============================================================== -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="/semiProject/main.do">
                        <!-- Logo icon --><b>
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            
                            <!-- Light Logo icon -->
                            <img src="/semiProject/resources/images/LOGO_white.png" id="homepageLogo" height="80px"alt="homepage" class="light-logo"/>
                        </b>
                        <!--End Logo icon -->
                        <!-- Logo text --><span>
                         
                         <!-- Light Logo text -->    
                         <!-- img src="/semiProject/resources/assets/images/logo-light-text.png" class="light-logo" alt="homepage" /></span>--> </a> 
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse" id="navbarTop">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav mr-auto mt-md-0">
                        <!-- This is  -->
                        <li class="nav-item1"> <a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="mdi mdi-menu"></i></a> </li>
                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        <li class="nav-item1 hidden-sm-down search-box"> <a class="nav-link hidden-sm-down text-muted waves-effect waves-dark" href="javascript:void(0)"></a>
                            <form class="app-search">
                                <input type="text" class="form-control" placeholder="Search & enter"> <a class="srh-btn"><i class="ti-close"></i></a> </form>
                        </li>
                    </ul>
                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav my-lg-0" id="userUl">
                        <!-- ============================================================== -->
                        <!-- Profile -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="#" id="userTitle" onclick="logout();"data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            
							<%
									if (s!=null) {
											
								%>
										<%if(s.getImage() != null ) { %>
											<img src="<%=request.getContextPath()%>/resources/memberImageFiles/
											<%=s.getImage()%>" class="profile-pic m-r-10 rounded-circle">
										
										<% } else { %>
											<img src="/semiProject/resources/images/usericon.png" alt="user" class="profile-pic m-r-10" />
										<% } %>
								<%
									} else if(p!=null) {
								%>
										<%if(p.getProImage() != null) { %>
											<img src="<%=request.getContextPath()%>/resources/memberImageFiles/
											<%=p.getProImage()%>" class="profile-pic m-r-10 rounded-circle">
										
										<% } else { %>
											<img src="/semiProject/resources/images/usericon.png" alt="user" class="profile-pic m-r-10" />
										<% } %>
								<%
										}
								%>


                            
                            <% if(s!=null) {%>
                             <%= s.getName() + "님, 환영합니다!" %>
							<% } else { %> 
							<%= p.getProfessorName() + "교수님, 환영합니다!"%> 
							<% } %> </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <script>
        	function logout() {
        		if(confirm("로그아웃하시겠습니까?")){
        			location.href="/semiProject/logout.do";	
        	        return true;
        	    } else {
        	        return false;
        	    }
        		
        	}
        </script>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar" >
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                   <% if(p != null) { %>
                    	<li> <a class="waves-effect waves-dark" href="/semiProject/main.do" aria-expanded="false"><i class="mdi mdi-gauge"></i><span class="hide-menu">메인화면</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="/semiProject/views/MemberUpdate/MemberUpdate.jsp" aria-expanded="false"><i class="mdi mdi-account-check"></i><span class="hide-menu">개인정보 수정</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="/semiProject/pfclslist.do?pno=<%=p.getProfessorNo()%>" aria-expanded="false"><i class="mdi mdi-book-open-variant"></i><span class="hide-menu">강사/강의 관리</span></a>
                        </li>
                    	<li><a class="waves-effect waves-dark" href="/semiProject/sSelect.do" aria-expanded="false"><i class="mdi mdi-table"></i><span class="hide-menu">강사/증명서 발급</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="/semiProject/selectList.co" aria-expanded="false"><i class="mdi mdi-emoticon"></i><span class="hide-menu">강사/온라인 상담</span></a>
                        </li>
                    <% } else { %>
                        <li> <a class="waves-effect waves-dark" href="/semiProject/main.do" aria-expanded="false"><i class="mdi mdi-gauge"></i><span class="hide-menu">메인화면</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="/semiProject/views/MemberUpdate/MemberUpdate.jsp" aria-expanded="false"><i class="mdi mdi-account-check"></i><span class="hide-menu">개인정보 수정</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="<%=request.getContextPath()%>/ssglist.do?sno=<%=s.getStudentNo()%>" aria-expanded="false"><i class="mdi mdi-book-open-variant"></i><span class="hide-menu">이수과목조회</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="<%=request.getContextPath()%>/sachlist.do?sno=<%=s.getStudentNo()%>" aria-expanded="false"><i class="mdi mdi-book-open-variant"></i><span class="hide-menu">성적 조회</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="/semiProject/tSelect.do" aria-expanded="false"><i class="mdi mdi-table"></i><span class="hide-menu">증명서 발급</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="/semiProject/selectList.co" aria-expanded="false"><i class="mdi mdi-emoticon"></i><span class="hide-menu">온라인 상담</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="/semiProject/selectList.ao" aria-expanded="false"><i class="mdi mdi-account-check"></i><span class="hide-menu">학적 변동 신청</span></a>
                        </li>
                        
                       <!--  <li> <a class="waves-effect waves-dark" href="table-basic.html" aria-expanded="false"><i class="mdi mdi-table"></i><span class="hide-menu">Basic Table</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="icon-material.html" aria-expanded="false"><i class="mdi mdi-emoticon"></i><span class="hide-menu">Icons</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="map-google.html" aria-expanded="false"><i class="mdi mdi-earth"></i><span class="hide-menu">Google Map</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="pages-blank.html" aria-expanded="false"><i class="mdi mdi-book-open-variant"></i><span class="hide-menu">Blank Page</span></a>
                        </li>
                        <li> <a class="waves-effect waves-dark" href="pages-error-404.html" aria-expanded="false"><i class="mdi mdi-help-circle"></i><span class="hide-menu">Error 404</span></a>
                        </li> -->
                    </ul>
                    <% } %>
                    
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
            <!-- Bottom points-->
            <div class="sidebar-footer">
                <!-- item--><a href="https://www.snu.ac.kr/academics/undergraduate/colleges"/ class="link" data-toggle="tooltip" title="major"><i class="mdi mdi-earth"></i></a>
                <!-- item--><a href="https://ko-kr.classting.com/" class="link" data-toggle="tooltip" title="Tip"><i class="mdi mdi-help-circle"></i></a>
                     <!-- item--><a href="/semiProject/logout.do" class="link" data-toggle="tooltip" title="Logout" ><i class="mdi mdi-power"></i></a> </div>
            <!-- End Bottom points-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->