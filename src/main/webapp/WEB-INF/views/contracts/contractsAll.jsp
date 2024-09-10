<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
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
			<!-- Pagination -->
	<div class="pagination">
		<c:if test="${currentPage > 1}">
			<a href="?pageNum=${currentPage - 1}">이전|</a>
		</c:if>

		<c:forEach var="page" begin="1" end="${totalPages}">
			<c:choose>
				<c:when test="${page == currentPage}">
					<strong>${page}</strong>
				</c:when>
				<c:otherwise>
					<a href="?pageNum=${page}">${page}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${currentPage < totalPages}">
			<a href="?pageNum=${currentPage + 1}">|다음</a>
		</c:if>
	</div>
</div>
<%@include file="../include/footer.jsp"%>