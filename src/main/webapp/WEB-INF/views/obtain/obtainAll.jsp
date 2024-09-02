<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<h3>조달계획 목록</h3>
	<table>
		<tr>
			<td>조달계획코드</td>
			<td>조달계획 물품</td>
			<td>조달량</td>
			<td>조달계획납기일</td>
			<td>조달계획상태</td>
			<td>조달계획등록일</td>
			<td>조달계획서류발행여부</td>
			<td>담당자</td>
			<td>생산계획코드</td>
			<td>조달계획협력회사</td>
		</tr>
		<c:forEach var="oblist" items="${oblist}">
			<tr>
				<td><a
					href="${contextPath}/obtain/obtainSelect?obtain_no=${oblist.obtain_no}">${oblist.obtain_no}</a></td>
				<td>${oblist.ma_id}</td>
				<td>${oblist.obtain_quantity}</td>
				<td>${oblist.obtain_deliveryDate}</td>
				<td>${oblist.obtain_status}</td>
				<td>${oblist.obtain_registrationDate}</td>
				<td>${oblist.obtain_document}</td>
				<td>${oblist.user_id}</td>
				<td>${oblist.production_no}</td>
				<td>${oblist.partner_taxid}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@include file="../include/footer.jsp"%>
 <!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>