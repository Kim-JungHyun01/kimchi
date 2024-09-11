<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<%@include file="../include/header.jsp" %>

<%@include file="../include/nav.jsp" %>
       
   <div class="content-body">
		<h2>진척검수</h2>
		납기 일자 : <input type="date" id="date" min=""> 
		<script type="text/javascript">
		$(document).ready(function(){today();});
			function today() {
				var now = new Date();
			 	var year = now.getFullYear();
			 	var month = now.getMonth() + 1;
			 	var day = now.getDate();
			 	
			 	if (month < 10) month = '0' + month;
		        if (day < 10) day = '0' + day;
			 	
			 	var formatToday = year + "-" + month + "-" + day;
			 	console.log(formatToday);
				document.getElementById("date").setAttribute("min",formatToday);
			}
			
		</script> 
   </div>


<%@include file="../include/footer.jsp" %>
    </div>
    
    <!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
    <!-- Circle progress -->

</body>

</html>