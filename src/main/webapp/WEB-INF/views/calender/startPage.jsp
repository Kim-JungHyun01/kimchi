<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@page import="java.util.List"%>
<%@page import="com.kr.kimchi.vo.CalenderVO"%>

  <%@include file="../include/header.jsp" %>
  
  
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->
        
        
  <%@include file="../include/nav.jsp" %>
        
        <!--**********************************
            Sidebar end
        ***********************************-->

        <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">
        
        	
        	<div id='calendar'></div>

        </div>
        <!--**********************************
            Content body end
        ***********************************-->


        <!--**********************************
            Footer start
        ***********************************-->
     
       <%@include file="../include/footer.jsp" %>
     
        <!--**********************************
            Footer end
        ***********************************-->

        <!--**********************************
           Support ticket button start
        ***********************************-->

        <!--**********************************
           Support ticket button end
        ***********************************-->


    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    <!--**********************************
        Scripts
    ***********************************-->
    <!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
    <!-- Circle progress -->

</body>
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
        navLinks: true, // can click day/week names to navigate views
        editable: true,
        dayMaxEvents: true, // allow "more" link when too many events
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



</html>