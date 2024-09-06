<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        color: #07020d; /* 링크 색상 (선택적) */
    }

    .pagination a:hover {
        text-decoration: underline; /* 마우스 오버 시 밑줄 */
    }
    </style>
    
    <div>
        <h2>출고 품목 조회</h2>
    </div>
    
    <c:if test="${empty list}">
        <p>출고된 자재가 없습니다.</p>
        <br>
        <tr>
            <td colspan="5"><a href="${contextPath}/outUpdate">출고처리</a></td> 
        </tr>
    </c:if>

	 <c:if test="${not empty list}">
    <table class="table"> <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
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
                <td>${out.io_quantity}</td>    
                <td>${out.io_date}</td>                
                <td>${out.invoice_issuance_status}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5"><a href="${contextPath}/out/outAdd">출고등록</a></td> 
        </tr>
    </table>
  </c:if>
<!-- </div>  --><!--  얘 유무 -->
    

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

<%@include file="../include/footer.jsp"%>

</body>
</html>
