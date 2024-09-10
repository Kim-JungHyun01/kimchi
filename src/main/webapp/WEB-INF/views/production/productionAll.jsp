<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<h3>생산계획 목록</h3>	
	<table>
		<tr>
			<td>생산계획코드</td>
			<td>생산수량</td>
			<td>생산납기일</td>
			<td>생산계획 상태</td>
		</tr>
		<c:forEach var="prolist" items="${prolist}">
			<tr onclick="location.href='${contextPath}/production/productionSelect?production_no=${prolist.production_no}'" style="cursor: pointer;">
				<td>${prolist.production_no}</td>
				<td>${prolist.production_quantity}</td>
				<td>${prolist.production_deliveryDate}</td>
				<td>${prolist.production_status}</td>
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