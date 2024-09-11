<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">

	<style>
.pagination {
	display: flex;
	justify-content: center;
	margin: 20px 0;
}

.pagination a, .pagination strong {
	margin: 0 5px; /* 각 페이지 링크 간격 */
	text-decoration: none; /* 링크 스타일 제거 */
	color: #07020d; /* 링크 색상 */
	padding: 10px 15px; /* 패딩 추가 */
	border-radius: 5px; /* 둥근 모서리 */
	transition: background-color 0.3s, color 0.3s; /* 부드러운 전환 효과 */
}

.pagination a {
	background-color: #f0f0f0; /* 기본 배경색 */
	border: 1px solid #ddd; /* 테두리 추가 */
}

.pagination a:hover {
	background-color: #007bff; /* 호버 시 배경색 */
	color: white; /* 호버 시 글자색 */
	text-decoration: underline; /* 마우스 오버 시 밑줄 */
}

.pagination strong {
	background-color: #007bff; /* 현재 페이지 강조 색상 */
	color: white; /* 현재 페이지 글자색 */
	padding: 10px 15px; /* 패딩 추가 */
	border-radius: 5px; /* 둥근 모서리 */
}

/* 검색창 */
.search-form {
	display: flex;
	justify-content: flex-end; /* 오른쪽 정렬 */
	align-items: center;
	margin: 20px;
}

.search-input {
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	width: 600px; /* 원하는 너비로 조절 */
	transition: border 0.3s;
}

.search-input:focus {
	border-color: #007bff; /* 포커스 시 테두리 색상 변경 */
	outline: none; /* 기본 아웃라인 제거 */
}

.search-button {
	padding: 10px 15px;
	margin-left: 10px;
	border: none;
	border-radius: 5px;
	background-color: #5892d1; /* 버튼 배경색 */
	color: white; /* 글자색 */
	cursor: pointer;
	transition: background-color 0.3s;
}

.search-button:hover {
	background-color: #0056b3; /* 호버 시 색상 변경 */
}

.table th, .table td {
	text-align: center; /* 가운데 정렬 */
}
</style>

	<form action="?pageNum=1" method="get" class="search-form">
		<input type="text" name="partner_companyname" placeholder="협력 회사명 검색"
			value="${param.partner_companyname}" class="search-input" />
		<button type="submit" class="search-button">검색</button>
	</form>

	<div style="margin-left: 20px;">
		<h3>협력회사 목록</h3>

		<table class="table">
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
					<td><a
						href="${contextPath}/partner/partnerSelect?partner_taxid=${partnerlist.partner_taxid }">${partnerlist.partner_taxid }</a></td>
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
				<a href="?pageNum=${currentPage - 1}">이전</a>
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
				<a href="?pageNum=${currentPage + 1}">다음</a>
			</c:if>
		</div>

	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
