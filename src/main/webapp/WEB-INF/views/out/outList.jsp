<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@include file="../include/header.jsp"%>

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
    justify-content: center;
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

/* 버튼들 모양 */
.link-container {
    display: flex; /* 플렉스 박스 설정 */
    justify-content: flex-end; /* 오른쪽 정렬 */
    margin-bottom: 20px; /* 아래쪽 여백 */
}

.link-button {
    display: inline-block; 
    padding: 10px 15px; 
    margin-left: 10px; /* 좌측 마진 추가 */
    margin-right: 15px; /* 우측 마진 추가 */
    border: none; 
    border-radius: 5px; 
    background-color: #5892d1; /* 버튼 배경색 */
    color: white; /* 글자색 */
    cursor: pointer;
    transition: background-color 0.3s; /* 배경색 전환 효과 */
}

.link-button:hover {
    background-color: #0056b3; /* 호버 시 배경색 변경 */
    color: white; /* 글자색을 흰색으로 유지 */
}

.link-button:active {
    transform: scale(0.95); 
    outline: none; /* 기본 아웃라인 제거 */
}

.table th, .table td {
    text-align: center; /* 가운데 정렬 */
}
</style>


	<div style="margin-left: 20px;">
		<h2>출고 품목 조회</h2>

		<form action="${contextPath}/out/outList" method="get" class="search-form">
			<input type="text" name="io_id" placeholder="조회하실 출고코드를 입력하시오" value="${param.io_id}" class="search-input" />
			<button type="submit" class="search-button">검색</button>
		</form>
		
	</div>

	<c:if test="${empty list}">
		<p>출고된 자재가 없습니다.</p>
		<table>
			<tr>
				<td colspan="5" style="text-align: left; padding-left: 20px;">
					<a href="${contextPath}/out/outAdd" class="link-button">출고등록</a>
				</td>
			</tr>
		</table>
	</c:if>

	<c:if test="${not empty list}">
		<table class="table">
			<tr>
				<th>출고 코드</th>
				<th>자재명</th>
				<th>출고 수량</th>
				<th>출고일</th>
				<th>거래명세서 발행여부</th>
			</tr>

			<c:forEach var="out" items="${list}">
				<tr>
					<td>${out.io_id}</td>
					<td><a href="outView?io_id=${out.io_id}">${out.ma_name}</a></td>
					<td class="ma_stockQuantity">${out.io_quantity}</td>
					<td>${out.io_date}</td>
					<td>${out.invoice_issuance_status}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" style="text-align: left; padding-left: 20px;">
					<a href="${contextPath}/out/outAdd" class="link-button">출고등록</a>
				</td>
			</tr>
		</table>
	</c:if>

	<!-- Pagination -->
	<div class="pagination">
		<c:if test="${currentPage > 1}">
			<a href="?pageNum=${currentPage - 1}&ma_name=${param.ma_name}">이전</a>
		</c:if>

		<c:forEach var="page" begin="1" end="${totalPages}">
			<c:choose>
				<c:when test="${page == currentPage}">
					<strong>${page}</strong>
				</c:when>
				<c:otherwise>
					<a href="?pageNum=${page}&ma_name=${param.ma_name}">${page}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${currentPage < totalPages}">
			<a href="?pageNum=${currentPage + 1}&ma_name=${param.ma_name}">다음</a>
		</c:if>
	</div>
</div>

<script>
    $(document).ready(function() {
        // 천 단위 구분 적용
        $('.ma_stockQuantity').each(function() {
            let text = $(this).text();
            if ($.isNumeric(text)) {
                $(this).text(Number(text).toLocaleString()); 
            }
        });
    });
</script>

<%@include file="../include/footer.jsp"%>
