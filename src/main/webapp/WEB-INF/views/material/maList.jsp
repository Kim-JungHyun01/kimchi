<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@include file="../include/header.jsp"%>

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
.link-container { /* 오른쪽 정렬 */
    display: flex; /* 플렉스 박스 설정 */
    justify-content: flex-end; 
    margin-bottom: 10px; /* 아래쪽 여백 */
}

.link-left{ /*버튼 왼쪽 정렬시*/
    text-align: left; 
    margin-bottom: 10px; /* 아래쪽 여백 */
}

.link-button {
    display: inline-block; 
    padding: 7px 7px; 
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

<div class="content-body">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12"> <!-- 자간 -->
                <div class="card"> <!-- 흰박스 -->
                    <div class="card-header"> <!-- 흰박스 헤더 -->
                        <h2>전체 자재 조회</h2>
                        <form action="${contextPath}/material/maList" method="get" class="search-form">
                            <input type="text" name="ma_name" placeholder="재료명 검색" value="${param.ma_name}" class="search-input" />
                            <button type="submit" class="search-button">검색</button>
                        </form>
                        <div class="link-container" style="margin-right: 10px;">
                            <a href="${contextPath}/material/maReport" class="link-button">금액현황조회</a>
                            <a href="${contextPath}/out/outList" class="link-button">출고현황조회</a>
                        </div>
                    </div>

                    <div class="col-12">
                        <table class="table">
                            <tr>
                                <th>품목코드</th>
                                <th>분류명</th>
                                <th>재료명</th>
                                <th>원산지</th>
                                <th>재고수량</th>
                                <th>무게</th>
                                <th>단위</th>
                                <th>포장규격</th>
                                <th>단가액</th>
                                <th>총금액</th>
                                <th>첨부파일번호</th>
                            </tr>

                            <c:forEach var="ma" items="${list}">
                                <tr>
                                    <td>${ma.ma_id}</td>
                                    <td>${ma.ma_category}</td>
                                    <td><a href="maView?ma_id=${ma.ma_id}">${ma.ma_name}</a></td>
                                    <td>${ma.ma_origin}</td>
                                    <td class="ma_stockQuantity">${ma.ma_stockQuantity}</td>
                                    <td class="ma_weight">${ma.ma_weight}</td>
                                    <td>${ma.ma_unit}</td>
                                    <td>${ma.ma_specifications}</td>
                                    <td class="price">${ma.ma_price}</td>
                                    <td class="stockValue">${ma.ma_stockValue}</td>
                                    <td>${ma.attachment_no}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        
                        <div class="link-left">
						    <a href="${contextPath}/material/maAdd" class="link-button">자재추가</a>
						</div>
                    </div>
                </div>
            </div>
        </div>

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

        <%@include file="../include/footer.jsp"%>

        <script>
            $(document).ready(function() {
                // 천 단위 구분 및 원 기호 추가
                function formatCurrency(value) {
                    if ($.isNumeric(value)) {
                        return '₩ ' + Number(value).toLocaleString();
                    }
                    return value;
                }

                // 각 셀에 대해 적용
                $('.price, .stockValue').each(function() {
                    let text = $(this).text();
                    $(this).text(formatCurrency(text));
                });

                // 무게 적용
                $('.ma_weight, .ma_stockQuantity').each(function() {
                    let text = $(this).text();
                    if ($.isNumeric(text)) {
                        $(this).text(Number(text).toLocaleString()); 
                    }
                });
            });
        </script>
    </div>
</div>
</body>
</html>
