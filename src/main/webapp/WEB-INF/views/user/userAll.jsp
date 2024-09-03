<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<h3>사용자 목록</h3>
	<table border="1">
		<tr>
			<td>사용자 id</td>
			<td>사용자 pw</td>
			<td>사용자 email</td>
			<td>사용자명</td>
			<td>사용자 전화번호</td>
			<td>사용자 부서</td>
			<td>사용자 승인여부</td>
		</tr>
		<c:forEach var="userlist" items="${userlist}">
			<tr>
				<td><a href="${contextPath}/user/userSelect?user_id=${userlist.user_id}">${userlist.user_id }</a></td>
				<td>${userlist.user_pw }</td>
				<td>${userlist.user_email }</td>
				<td>${userlist.user_name }</td>
				<td>${userlist.user_number }</td>
				<td>${userlist.user_department }</td>
				<td>${userlist.user_approval }</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
