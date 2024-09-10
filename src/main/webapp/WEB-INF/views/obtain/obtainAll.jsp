<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<h3>조달계획 목록</h3>
	<table>
		<tr>
			<td>조달계획코드</td>
			<td>조달계획물품</td>
			<td>조달량</td>
			<td>조달가격</td>
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
				<td>${oblist.obtain_price}</td>
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