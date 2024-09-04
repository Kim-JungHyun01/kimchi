<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<h3>계약 목록</h3>
	<table>
		<tr>
			<td>계약코드</td>
			<td>계약물품코드</td>
			<td>계약수량</td>
			<td>계약가격</td>
			<td>계약납기일</td>
			<td>계약상태</td>
			<td>계약상세</td>
			<td>계약등록일</td>
			<td>계약서류발행여부</td>
			<td>계약협력회사</td>
			<td>계약담당자</td>
		</tr>
		<c:forEach var="conlist" items="${conlist}">
			<tr>
				<td><a href="${contextPath}/contracts/contractsSelect?contracts_no=${conlist.contracts_no}">${conlist.contracts_no}</a></td>
				<td>${conlist.item_no}</td>
				<td>${conlist.contracts_quantity}</td>
				<td>${conlist.contracts_price}</td>
				<td>${conlist.contracts_deliveryDate}</td>
				<td>${conlist.contracts_status}</td>
				<td>${conlist.contracts_details}</td>
				<td>${conlist.contracts_registrationDate}</td>
				<td>${conlist.contracts_document}</td>
				<td>${conlist.partner_taxid}</td>
				<td>${conlist.user_id}</td>
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