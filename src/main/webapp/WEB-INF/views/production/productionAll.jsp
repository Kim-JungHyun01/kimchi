<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<h3>생산계획 목록</h3>	
	<table>
		<tr>
			<td>생산계획코드</td>
			<td>생산수량</td>
			<td>생산납기일</td>
			<td>생산계획 상태</td>
			<td>등록일</td>
			<td>담당자</td>
			<td>계약코드</td>
		</tr>
		<c:forEach var="prolist" items="${prolist}">
			<tr>
				<td><a href="${contextPath}/productionSelect?production_no=${prolist.production_no}">${prolist.production_no}</a></td>
				<td>${prolist.production_quantity}</td>
				<td>${prolist.production_deliveryDate}</td>
				<td>${prolist.production_status}</td>
				<td>${prolist.production_registrationDate}</td>
				<td>${prolist.user_id}</td>
				<td>${prolist.contracts_no}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>>