<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<div>
		<h3>생산계획 상세정보</h3>
		<table border="1">
			<tr>
				<td>생산계획코드</td>
				<td>${pro.production_no}</td>
			</tr>
			<tr>
				<td>생산수량</td>
				<td>${pro.production_quantity}</td>
			</tr>
			<tr>
				<td>생산납기일</td>
				<td>${pro.production_deliveryDate}</td>
			</tr>
			<tr>
				<td>생산계획 상태</td>
				<td>${pro.production_status}</td>
			</tr>
			<tr>
				<td>생산계획 등록일</td>
				<td>${pro.production_registrationDate}</td>
			</tr>
		</table>
	</div>
	<div>
		<h3>담당자정보</h3>
		<table border="1">
			<tr>
				<td>담당자id</td>
				<td>${pro.user_id}</td>
			</tr>
		</table>
	</div>
	<div>
		<a href="${contextPath}/contract/contractsSelect?contracts_no=${pro.contracts_no}">계약상세보기</a>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
 <!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>