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
<%@include file="../include/header.jsp"%>




<div class="content-body">
	start Page! <input value="${partlogin.partner_approval }" type="hidden"
		id="login_partner_approval" name="login_partner_approval"> <input
		value="${userlogin.user_approval }" type="hidden"
		id="login_user_approval" name="login_user_approval">
</div>


<%@include file="../include/footer.jsp"%>

