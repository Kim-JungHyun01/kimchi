<<<<<<< HEAD
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.kr.kimchi.vo.CalenderVO"%>
=======
>>>>>>> origin/so
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<<<<<<< HEAD
<%@include file="../include/header.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
=======

<%@page import="java.util.List"%>
<%@page import="com.kr.kimchi.vo.CalenderVO"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ include file="../include/header.jsp"%>

<style>
/* 차트 */
.container {
    display: flex;
    margin: 0; /* 부모 요소의 마진을 제거 */
}

.charts {
    display: flex;
    flex-direction: column; /* 세로 정렬 */
    flex: 1; /* 차트가 캘린더의 왼쪽에 위치 */
    margin-top: 120px; /* 차트의 위쪽 여백 */
    margin-left: 270px; /* 차트의 왼쪽 여백 */
}

.calendar {
    flex: 0 0 auto; /* 캘린더의 크기 조정 */
}

/* 차트 크기 조정 */
#product-stock-chart, 
#overall-stock-chart {
    width: 100%; /* 차트 폭을 부모 요소에 맞춤 */
    height: 400px; /* 차트 높이 */
    margin-bottom: 10px; /* 차트 간격 */
}

canvas {
    max-width: 440px; 
    height: auto; 
}

/* 캘린더 높이 조정 */
.content-body {
    height: 900px; /* 캘린더와 차트의 높이를 동일하게 설정 */
    display: flex;
    align-items: stretch; /* 자식 요소의 높이를 동일하게 설정 */
}

</style>

<!-- 캘린더 -->
<script src='${contextPath}/resources/calender/index.global.js'></script>
<script> 
>>>>>>> origin/so
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

<<<<<<< HEAD
<style>
  body {
    margin: 0;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  .container {
    display: flex;
    flex-direction: column;
    align-items: center; /* 수평 중앙 정렬 */
    justify-content: center; /* 수직 중앙 정렬 */
    min-height: 100vh; /* 전체 화면 높이 */
  }

  #carouselExample {
    width: 100%;
    max-width: 900px;
  }

  .carousel-item img { /* 슬라이드 이미지 크기 설정 */
    height: 300px; /* 원하는 높이로 설정 */
    object-fit: contain; /* 비율을 유지하면서 이미지가 작아지도록 설정 */
    width: 100%; /* 너비는 100%로 설정 */
    display: block; /* 이미지의 아래 여백 제거 */
  }

  #calendar {
    max-width: 900px;
    width: 100%; /* 부모 요소에 맞게 너비 설정 */
    padding: 20px; /* 선택 사항: 캘린더 주변 여백 */
    background-color: #f8f9fa; /* 선택 사항: 캘린더 배경 색상 */
    border-radius: 8px; /* 선택 사항: 캘린더 모서리 둥글게 */
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 선택 사항: 그림자 효과 */
    margin-top: 20px; /* 슬라이드와의 간격 설정 */
  }

  .fc-event-time {
    display: none !important;
  }

  .fc-event-title {
    color: #343a40;
  }

  .fc-daygrid-more-link {
    color: #343a40;
  }
</style>

=======

<!-- 캘린더 및 차트 div-->
<div class="container">
    <div class="charts">
        <!-- 품목별 재고 및 총액 차트 -->
        <canvas id="product-stock-chart"></canvas>
        <!-- 날짜별 전체 재고 총액 차트 -->
        <canvas id="overall-stock-chart"></canvas>
    </div>

    <div class="calendar" style=" margin-left: 10px;">
        <div class="content-body">
            <div id='calendar'></div>
        </div>
    </div>
</div>

<!-- 차트 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
>>>>>>> origin/so
<script>
        // JSON 데이터는 문자열로 그대로 삽입합니다.
        const productChartData = JSON.parse('${chartData}');
        const overallStockData = JSON.parse('${totalStock}');

        console.log('chartData:', productChartData);
        console.log('totalStock:', overallStockData);

        // 품목별 재고 및 총액 차트 데이터
        const productNames = productChartData.map(item => item.ma_name); // 상품명 추출
        const stockQuantities = productChartData.map(item => item.totalQuantity); // 재고량 추출
        const stockValues = productChartData.map(item => item.totalValue); // 총액 추출

        const ctx1 = document.getElementById('product-stock-chart').getContext('2d');
        
        const data1 = {
            labels: productNames, // 상품명
            datasets: [
                {
                    type: 'bar',
                    label: '각 상품별 재고량',
                    data: stockQuantities, // 각 상품의 재고량
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                },
                {
                    type: 'bar',
                    label: '각 상품별 총액',
                    data: stockValues, // 총액
                    backgroundColor: 'rgba(255, 159, 64, 0.2)',
                    borderColor: 'rgba(255, 159, 64, 1)',
                    borderWidth: 1
                }
            ]
        };

        const options1 = {
            scales: {
                y: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: '재고량 및 총액'
                    }
                },
                x: {
                    title: {
                        display: true,
                        text: '상품명'
                    }
                }
            }
        };

        new Chart(ctx1, {
            type: 'bar',
            data: data1,
            options: options1
        });

        // 날짜별 전체 재고 총액 차트
        const ctx2 = document.getElementById('overall-stock-chart').getContext('2d');

        // 날짜 레이블과 총액 데이터를 분리
        const dateLabels = overallStockData.map(item => {
            const date = new Date(item.date);
            return date.toISOString().split('T')[0]; // Format to YYYY-MM-DD
        });
        const stockValuesData = overallStockData.map(item => item.totalValue);

        const data2 = {
            labels: dateLabels, // 날짜 레이블
            datasets: [
                {
                    type: 'line',
                    label: '전체 재고 총액',
                    data: stockValuesData, // 전체 재고의 총액
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 2,
                    fill: false,
                    tension: 0.1
                }
            ]
        };

        const options2 = {
            scales: {
                y: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: '총액'
                    }
                },
                x: {
                    title: {
                        display: true,
                        text: '날짜'
                    }
                }
            }
        };

<<<<<<< HEAD
        requestAnimationFrame(animate);
    }

    // 슬라이드 전환 시 애니메이션 적용
    $('#carouselExample').on('slid.bs.carousel', function (e) {
        const currentElement = $(e.target).find('.active img')[0];
    });
</script>
<!-- 로그인용 스인여부 확인용 -->
<div>
<input value="${partlogin.partner_approval }" type="hidden" id="login_partner_approval" name="login_partner_approval"> 
<input value="${userlogin.user_approval }" type="hidden" id="login_user_approval" name="login_user_approval">
</div>
<div class="container">
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
            <img src="${contextPath}/resources/images/kimchi/factory/김치공장6.jpg" class="d-block w-100" alt="Slide 4">
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

  <!-- 캘린더 -->
  <div id='calendar'></div>
</div>

<%@include file="../include/footer.jsp" %>
=======
        new Chart(ctx2, {
            type: 'line',
            data: data2,
            options: options2
        });
</script>

<!-- login script -->
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

<!-- 캘린더 -->
<!-- <div class="content-body">
	<div id='calendar'></div>
</div> -->

<!-- login input -->
<input value="${partlogin.partner_approval }" type="hidden"
	id="login_partner_approval" name="login_partner_approval">
<input value="${userlogin.user_approval }" type="hidden"
	id="login_user_approval" name="login_user_approval">


<%@ include file="../include/footer.jsp"%>
</html>
>>>>>>> origin/so
