<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<div>
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
		<a href="${contextPath}/user/userAll">목록</a>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
