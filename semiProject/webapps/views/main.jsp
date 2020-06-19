<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*, com.kh.semiProject.notice.model.vo.*,
    													 com.kh.semiProject.board.model.vo.*"%>
<%@ include file = "common/header.jsp" %>

<% ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	  ArrayList<Board> blist = (ArrayList<Board>)request.getAttribute("blist"); 
	  PageInfo pi = (PageInfo)request.getAttribute("pi");
	  int blistCount = pi.getListCount();
	  int currentPage = pi.getCurrentPage();
	  int maxPage = pi.getMaxPage();
	  int startPage = pi.getStartPage();
      int endPage = pi.getEndPage();
%>
 <!-- ============================================================== -->
 <!-- Start Page Content -->
 <!-- ============================================================== -->
<div class="row">
   <div class="col-lg-9 col-md-8">
      <div class="card">
         <div class="card-block">   
            <div class="container theme-showcase">
            <br>
                 <h1>학사일정</h1>
                <div id="calendar" class="row" ></div>
            </div>
         </div>
      </div>
   </div>
   
   <!-- 캘린더의 끝 -->
   
   
    
    
    <!-- 프로필 UI -->
             <!-- Column -->
                    <div class="col-lg-3 col-xlg-3 col-md-4">
                        <!-- Column -->
                        <div class="card">
                            <img class="card-img-top" src="/semiProject/resources/assets/images/background/university.png" alt="프로필배경">
                            <div class="card-block little-profile text-center">
                                <div class="pro-img"><img src="/semiProject/resources/images/1.png" alt="professor"/></div>
                                <h3 class="m-b-0">Y J H</h3>
                                <p>Web Designer &amp; Developer</p>
                                <button class="m-t-10 waves-effect waves-dark btn btn-primary btn-md btn-rounded"
                                   onclick="window.open('/semiProject/views/intro.jsp','교수소개','width=850,height=350,scrollbars=yes');">introduce</button>
                                <div class="row text-center m-t-20">
                                    <div class="col-lg-6 col-md-10 m-t-20">
                                        <h3 class="m-b-0 font-initial"></h3><small></small></div>
                                    <div class="col-lg-6 col-md-10 m-t-20">
                                    
                                        <h3 class="m-b-0 font-initial"></h3><small></small></div>
                                </div>
                            </div>
                        </div>
                      </div>
                     <!-- 프로필의 끝 -->
               
         </div>
      <br><br><br>
              
              
       <div class="row">
             <div class="col-lg-4 col-xlg-3 col-md-5">
                <!-- 상담이력 ui -->
                        <div class="card">
                            <div class="card-block bg-info">
                                <h3 class="text-white card-title">여기서해결해~</h3>
                                <h6 class="card-subtitle text-white m-b-0 op-5">바로가기페이지.</h6>
                            </div>
                            <div class="card-block">
                                <div class="message-box contact-box">
                                    <div class="message-widget contact-widget">
                                        
                                        <!-- 상담이력 목록 -->
                                        <a href="http://snuco.snu.ac.kr/ko/foodmenu">
                                            <div class="user-img"> <img src="/semiProject/resources/images/sikpan.JPG" alt="user" class="img-circle"> <span class="profile-status online pull-right"></span> </div>
                                            <div class="mail-contnet">
                                                <h4>오늘의 메뉴</h4> <span class="mail-desc" >맛없으면 먹지마~</span></div>
                                        </a>
                                        <a href="https://dorm.snu.ac.kr/dk_main/">
                                            <div class="user-img"> <img src="/semiProject/resources/images/hotel.JPG"  alt="user" class="img-circle"> <span class="profile-status busy pull-right"></span> </div>
                                            <div class="mail-contnet">
                                                <h4>신세대 기숙사</h4> <span class="mail-desc">자취방보다 좋아~</span></div>
                                        </a>
                                        <!-- Message -->
                                        <a href="http://snuco.snu.ac.kr/ko/board/suggest">
                                            <div class="user-img"> <span class="round">YES</span> <span class="profile-status away pull-right"></span> </div>
                                            <div class="mail-contnet">
                                                <h4>한마디 제안</h4> <span class="mail-desc">원하는거 있으면 말해~</span></div>
                                        </a>
                                        <a href="http://snuco.snu.ac.kr/ko/node/7">
                                            <div class="user-img"> <img src="/semiProject/resources/images/witch.JPG" alt="user" class="img-circle"> <span class="profile-status offline pull-right"></span> </div>
                                            <div class="mail-contnet">
                                                <h4>우리학교 위치</h4> <span class="mail-desc">오기도 편해~</span></div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                 

                    <div class="col-lg-8 col-xlg-9 col-md-7">
                        <div class="card">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs profile-tab" role="tablist"  >
                                 <li class="nav-item"> <a class="nav-link active" data-toggle="tab" href="#home" role="tab" style=color:black>공지사항</a> </li>
                                <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#profile" role="tab" style=color:black>신세대 대나무숲</a> </li>
                            </ul>
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane active" id="home" role="tabpanel">
                                    <div class="card-block">
                                       
        <!-- 공지사항 -->                               
       	<div class="outer">
         <br>
         <h2 align="center">공지사항</h2>
            <div class="tableArea">
               
               <table align="center" id="noticelistArea" style="border-radius:10px">
                  <tr>
                     <th width ="100px"  margin= auto;>글번호</th>
                     <th width="600px"  margin=auto;>글제목</th>
                     <th width="100px" margin= auto;>작성자</th>
                     <th width="100px"  margin= auto;>조회수</th>
               		 <th width="100px" margin= auto;>작성일</th>
            	</tr>
            	<hr />
            <% for(Notice n : list){ %>
         		<tr>
            		<td><%= n.getNno() %></td>
            		<td><%= n.getNtitle() %></td>
            		<td><%= n.getNwriter() %></td>
            		<td style="padding-left:15px; "><%= n.getNcount() %></td>
            		<td><%= n.getNdate() %></td>
         		</tr>
        	 <% } %> 
      	 </table>
      	 <hr />
      </div>
      
      <br><br>
            
            <div class="searchArea" align="center">
             
         
         
         
            <% if((s != null && s.getStudentNo().equals("admin")) || (p != null && p.getProfessorNo().equals("admins"))){ %>
               <button id="writeBtn" onclick="location.href='/semiProject/views/notice/noticeInsertForm.jsp'">작성하기</button>
            <% } %>
         </div>
   </div>
                                    </div>
                                </div>
                                
 <!-- 대나무숲의 시작-->
     <div class="tab-pane" id="profile" role="tabpanel">
         <div class="card-block">
           <div class="outer">
				<br>
		
		<h2 align="center">신세대 대나무숲</h2>
		<hr />
			<div class="tableArea">
				<table align="center" id="listArea">
					  <tr>
                     <th width ="100px" , margin= auto;>글번호</th>
                     <th width="600px" margin= auto;>글제목</th>
                     <th width="100px" margin= auto;>작성자</th>
                     <th width="100px"  margin= auto;>작성일</th>
               		 <th width="100px" margin= auto;>조회수</th>
            	</tr>
			<% for(Board b : blist){ %>
					<tr>
						<input type="hidden" value="<%= b.getBno() %>"/>
						<td><%= b.getBno() %></td>
						<td><%= b.getBtitle() %></td>
						<td>익명<input type="hidden" value="<%= b.getBwriter() %>"/></td>
						<td><%= b.getBdate() %></td>
						<td><%= b.getBcount() %></td>
					</tr>
			<% } %>
			</table>
			<hr />
		</div>
		
	<%-- 대나무숲 페이지 처리 --%>
		<div class="pagingArea" align="center">
			<button id="page" onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button id="page1" disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int bp = startPage; bp <= endPage; bp++){
					if(bp == currentPage){	
			%>
				<button id="pageBtn" disabled><%= bp %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%= bp %>'"><%= bp %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button id="page2"  disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button id="page3"  onclick="location.href='<%= request.getContextPath() %>/selectList.bo?currentPage=<%= maxPage %>'">>></button>
		</div>
	<!-- 페이지처리 끝 -->
		
			<% if(s != null){ %>
				<button id="writeBtn2" style="float:right;" onclick="location.href='views/board/boardInsertForm.jsp'">작성하기</button>
			<% } %>
			
				</div>
			</div>
      </div>
   </div>
<!-- 대나무숲 게시판의 끝 -->
                                    
                                    
                                </div>
                        </div>
                    </div>
                </div>
               
<!-- 캘린더 -->
        <script>
               $(function() {
                     var calendarEl = $('#calendar')[0];

                     var calendar = new FullCalendar.Calendar(calendarEl, {
                       plugins: [ 'interaction', 'dayGrid', 'timeGrid' ],
                       defaultView: 'dayGridMonth',
                       defaultDate: new Date(),
                       header: {
                         left: 'prev,next today',
                         center: 'title',
                         right: 'dayGridMonth,timeGridWeek,timeGridDay'
                       },
                       
                       events: [
                         
                       ]
                       
                     });

                     calendar.render();
                     
                     // 날짜 추가 시
                     calendar.addEvent( {'title':'체육대회', 'start':'2020-05-12', 'end':'2020-05-15'});
                     calendar.addEvent( {'title':'복수,부전공 신청', 'start':'2020-05-18', 'end':'2020-05-23'});
                      calendar.addEvent( {'title':'기말고사', 'start':'2020-06-15', 'end':'2020-06-20'});
                      calendar.addEvent( {'title':'종강', 'start':'2020-06-26', 'end':'2020-06-27'});
                      calendar.addEvent( {'title':'하계방학시작', 'start':'2020-06-29', 'end':'2020-06-30'});
                      calendar.addEvent( {'title':'계절학기시작', 'start':'2020-06-29', 'end':'2020-06-30'});
                      calendar.addEvent( {'title':'성적열람 및 정정', 'start':'2020-07-02', 'end':'2020-07-04'});
                      calendar.addEvent( {'title':'기말고사 성적 마감', 'start':'2020-07-06', 'end':'2020-07-09'});
                      calendar.addEvent( {'title':'2학기 복학,휴학 신청', 'start':'2020-07-27', 'end':'2020-08-01'});
                    
                   });
               // 캘린터 함수의 끝
               
               
               // 공지사항 기능의 시작
               $(function(){
          			
      				$("#noticelistArea td").mouseenter(function(){
      					$(this).parent().css({"background":"#5bc0de", "cursor":"pointer"});
      				
      				}).mouseout(function(){
      					
      					$(this).parent().css({"background":"white"});
      				
      				}).click(function(){
      					//console.log($(this).parent().children().eq(0).text());
      				
      					var nno = $(this).parent().children().eq(0).text();
      					
      					location.href="<%=request.getContextPath()%>/selectOne.no?nno=" + nno;
      				});
      			});
      		
      		function search(){
      			location.href="<%=request.getContextPath()%>/searchNotice.no?con="+$('#searchCondition').val()+"&keyword="+$('#keyword').val();
      		}
      	// 공지사항 스크립트의 끝
      	
      	
      	// 게시판 기능의 시작
      		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({ "background":"#5bc0de", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			}).click(function(){
				var bno = $(this).parent().find("input").val();
				location.href="<%=request.getContextPath()%>/selectOne.bo?bno=" + bno;
			});
		});
      	// 게시판 기능의 끝
      		
      		
                </script>
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
            <%@ include file = "common/footer.jsp" %>