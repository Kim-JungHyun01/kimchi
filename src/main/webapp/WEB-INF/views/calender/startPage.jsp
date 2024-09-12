<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<script>
	function checkapp() {
		var user_approval = document.getElementById('login_user_approval').value;
		var partner_approval = document.getElementById('login_partner_approval').value;

		if (user_approval == 0 && !partner_approval) {
			alert("승인되지 않은 ID입니다. 관리자에게 문의해주세요.");
			window.location.href = '${contextPath}/login/logout';
		}
		
		if(!user_approval && partner_approval==0){
			alert("승인되지 않은 ID입니다. 관리자에게 문의해주세요.");
			window.location.href = '${contextPath}/login/logout';
		}
	}

	window.onload = checkapp;
</script>
<script src='${contextPath}/resources/calender/index.global.js'></script>
<script>

document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var today = new Date();
    
    var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
            left: 'prevYear,prev,next,nextYear today',
            center: 'title',
            right: 'dayGridMonth,dayGridWeek,dayGridDay'
        },
        initialDate: today,
        navLinks: true, 
        editable: true,
        dayMaxEvents: true, 
        events: [
            <%-- JSP scriptlet을 사용하여 데이터를 JSON으로 변환 --%>
            <c:forEach var="vo" items="${list}" varStatus="status">
            {
                    title: '${vo.partner_companyname} 검수일',
                    start: '${vo.prp_issueDate}T00:00:00', 
                    // end: '${vo.prp_issueDate}T23:59:59',   
                    color: '#' + Math.round(Math.random() * 0xffffff).toString(16)
                }
                <c:if test="${!status.last}">,</c:if>
            </c:forEach>
        ]
    });
            console.log("he");   
    console.log(calendar.getEvents()); 
    calendar.render();
});
  
</script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 0 auto;
  }
  
  .fc-event-time {
    display: none !important;
}

.fc-event-title {
    color: #343a40;
}

.fc-daygrid-more-link fc-more-link{
	 color: #343a40;
}



</style>
<style>
    .carousel-item img { /* 슬라이드 이미지 크기 설정 */
        height: 300px; /* 원하는 높이로 설정 */
        object-fit: contain; /* 비율을 유지하면서 이미지가 작아지도록 설정 */
        width: 100%; /* 너비는 100%로 설정 */
        display: block; /* 이미지의 아래 여백 제거 */
    }
</style>
<script>
    function customFadeOut(element, duration) {
        let opacity = 1;
        const interval = 1000 / 60; // 60fps
        const increment = interval / duration;

        function animate() {
            opacity -= increment;
            if (opacity <= 0) {
                opacity = 0;
                element.style.display = 'none'; // 숨김 처리
            }
            element.style.opacity = opacity;
            if (opacity > 0) {
                requestAnimationFrame(animate);
            }
        }

        requestAnimationFrame(animate);
    }

    // 슬라이드 전환 시 애니메이션 적용
    $('#carouselExample').on('slid.bs.carousel', function (e) {
    const currentElement = $(e.target).find('.active img')[0];
	});
</script>
<%@page import="java.util.List"%>
<%@page import="com.kr.kimchi.vo.CalenderVO"%>
<%@include file="../include/header.jsp" %>

<div class="content-body">

   <!-- 사진 슬라이드 -->
<div id="carouselExample" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="${contextPath}/resources/images/kimchi/main/메인.jpg" class="d-block w-100" alt="Slide 1">
        </div>
        <div class="carousel-item">
            <img src="${contextPath}/resources/images/kimchi/main/메인2.jpg" class="d-block w-100" alt="Slide 2">
        </div>
        <div class="carousel-item">
            <img src="${contextPath}/resources/images/kimchi/factory/김치공장4.jpg" class="d-block w-100" alt="Slide 3">
        </div>
        <div class="carousel-item">
            <img src="${contextPath}/resources/images/kimchi/factory/김치공장6.jpg" class="d-block w-100" alt="Slide 3">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExample" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExample" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<div class="content-body">
	<input value="${partlogin.partner_approval }" type="hidden"
		id="login_partner_approval" name="login_partner_approval"> <input
		value="${userlogin.user_approval }" type="hidden"
		id="login_user_approval" name="login_user_approval">
		<div class="content-body">
        
        	
        	<div id='calendar'></div>

        </div>
</div>

        
        
     
       <%@include file="../include/footer.jsp" %>



    </div>

    
