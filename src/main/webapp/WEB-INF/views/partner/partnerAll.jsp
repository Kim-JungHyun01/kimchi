<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<style>
.pagination {
	display: flex;
	justify-content: center;
	margin: 20px 0;
}

.pagination a, .pagination strong {
	margin: 0 5px; /* 각 페이지 링크 간격 */
	text-decoration: none; /* 링크 스타일 제거 */
	color: #07020d; /* 링크 색상 (선택적) */
}

.pagination a:hover {
	text-decoration: underline; /* 마우스 오버 시 밑줄 */
}
</style>
<div class="content-body">
	<div>
		<h3>협력회사 목록</h3>
		<table border="1">
			<tr>
				<td>협력회사 사업자번호</td>
				<td>협력회사 id</td>
				<td>협력회사 pw</td>
				<td>협력회사명</td>
				<td>협력회사 전화번호</td>
				<td>협력회사 대표자명</td>
				<td>협력회사 fax</td>
				<td>협력회사 email</td>
				<td>협력회사 사업장주소</td>
				<td>협력회사 승인여부</td>
			</tr>
			<c:forEach var="partnerlist" items="${partnerlist}">
				<tr>
					<td><a href="${contextPath}/partner/partnerSelect?partner_taxid=${partnerlist.partner_taxid }">${partnerlist.partner_taxid }</a></td>
					<td>${partnerlist.partner_id }</td>
					<td>${partnerlist.partner_pw }</td>
					<td>${partnerlist.partner_companyname }</td>
					<td>${partnerlist.partner_number }</td>
					<td>${partnerlist.partner_ownername }</td>
					<td>${partnerlist.partner_fax }</td>
					<td>${partnerlist.partner_email }</td>
					<td>${partnerlist.partner_add }</td>
					<td>${partnerlist.partner_approval }</td>
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
</div>
<%@include file="../include/footer.jsp"%>
