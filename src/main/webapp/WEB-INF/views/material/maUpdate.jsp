<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<%@include file="../include/header.jsp" %>
<%@include file="../include/nav.jsp" %>

<div class="content-body">
    <div>
        <h2>수정</h2>
    </div>
    <form action="${contextPath}/material/maUpdate" method="post"> 

        <input type="hidden" name="ma_id" id="ma_id" value="${ma.ma_id}"><br> 
        분류명: <input type="text" name="ma_category" value="${ma.ma_category}"><br>
        재료명: <input type="text" name="ma_name" value="${ma.ma_name}" ><br>
        원산지: <input type="text" name="ma_origin" value="${ma.ma_origin}" readOnly><br>
        유통기한: <input type="date" name="ma_expiryDate" value="${ma.ma_expiryDate}" readOnly><br>        
        재고수량: <input type="number" name="ma_stockQuantity" value="${ma.ma_stockQuantity}" id="ma_stockQuantity"><br>  
        단위: <input type="text" name="ma_unit" value="${ma.ma_unit}" readOnly><br>
        무게: <input type="text" name="ma_weight" value="${ma.ma_weight}"><br> 
        포장규격: <input type="text" name="ma_specifications" value="${ma.ma_specifications}" readOnly><br>
        가용재고량: <input type="number" name="ma_availableStock" value="${ma.ma_availableStock}" readOnly><br>  
        기본재고량: <input type="number" name="ma_basicStock" value="${ma.ma_basicStock}" readOnly><br> 
        단가액: <input type="number" name="ma_price" value="${ma.ma_price}" id="ma_price"><br> 
        총금액: <input type="number" name="ma_stockValue" value="${ma.ma_stockValue}" readOnly id="ma_stockValue"><br> 
        보관위치: <input type="text" name="ma_storage" value="${ma.ma_storage}"><br> 
        수정일: <input type="date" name="ma_date" value="${ma.ma_date}"><br>  
        첨부파일번호: <input type="number" name="attachment_no" value="${ma.attachment_no}"><br>     
        
        <input type="submit" value="수정완료">
    </form>
</div>

<%@include file="../include/footer.jsp"%>

<!-- 필수 벤더 스크립트 -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>

</html>
