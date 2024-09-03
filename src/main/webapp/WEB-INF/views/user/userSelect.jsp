<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<h3>사용자 상세목록</h3>
	<table border="1">
		<tr>
			<td>사용자 id</td>
			<td>${user.user_id }</td>
		</tr>
		<tr>
			<td>사용자 pw</td>
			<td>${user.user_pw }</td>
		</tr>
		<tr>
			<td>사용자 email</td>
			<td>${user.user_email }</td>
		</tr>
		<tr>
			<td>사용자명</td>
			<td>${user.user_name }</td>
		</tr>
		<tr>
			<td>사용자 전화번호</td>
			<td>${user.user_number }</td>
		</tr>
		<tr>
			<td>사용자 부서</td>
			<td>${user.user_department }</td>
		</tr>
		<tr>
			<td>사용자 승인여부</td>
			<td>${user.user_approval }</td>
		</tr>
	</table>
	<form action="userApproval" method="post" name="userApprovalForm"
		id="userApprovalForm">
		<input type="hidden" name="user_id" id="user_id"
			value="${user.user_id }"> <input type="hidden"
			name="user_approval" id="user_approval"
			value="">
		<c:if test="${user.user_approval eq 0 }">
			<div>
				<button type="button" onclick="">사용자 승인부여</button>
			</div>
		</c:if>
		<c:if test="${user.user_approval eq 1 }">
			<div>
				<button type="button" onclick="">사용자 승인부여해제</button>
			</div>
		</c:if>
	</form>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script>
	function checkApproval(user_approval) {
		
	}//end
</script>
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
