<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
        color: #07020d; /* 링크 색상 (선택적) */
    }

    .pagination a:hover {
        text-decoration: underline; /* 마우스 오버 시 밑줄 */
    }
    </style>
    
    <div>
        <h2>전체 자재 조회</h2>
        <br>
		<a href="${contextPath}maReport">--금액현황조회--</a>
		<br><br>
		<a href="${contextPath}/out/outList">--출고현활조회--</a>
    </div>

    <table class="table"> <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <tr>
            <th>품목코드</th>
            <th>분류명</th>
            <th>재료명</th>
            <th>원산지</th>
            <th>재고수량</th>
            <th>단위</th>
            <th>무게</th>
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
                <td>${ma.ma_stockQuantity}</td>                
                <td>${ma.ma_unit}</td>
                <td>${ma.ma_weight}</td>
                <td>${ma.ma_specifications}</td>                                        
                <td class="price">${ma.ma_price}</td>
                <td class="stockValue">${ma.ma_stockValue}</td>
                <td>${ma.attachment_no}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan=11><a href="${contextPath}maAdd">자재추가</a></td>
        </tr>
    </table>
<!--  </div> <!--  얘 유무   -->

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

<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>

<script>
    var actionForm = $("#actionForm");

    $(".paginate_button a").on("click", function(e) {
        e.preventDefault();
        actionForm.find("input[name='pageNum']").val($(this).attr("href"));
        actionForm.submit();
    });

    // 금액 포멧팅 + 숫자구분
    $(document).ready(function() {
        $('.price, .stockValue').each(function() { // 가격 및 재고 값 포맷팅
            let text = $(this).text();
            if ($.isNumeric(text)) { // 숫자에 천 단위 구분기호 추가
            	 $(this).text('₩ ' + Number(text).toLocaleString());
            }
        });
    });
</script>

</body>
</html>
