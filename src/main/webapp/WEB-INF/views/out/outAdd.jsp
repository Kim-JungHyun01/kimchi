<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/nav.jsp" %>

<div class="content-body">
    <div>
        <h2>출고 등록</h2>
    </div>
    
    <form id="outForm" action="${contextPath}/out/outAdd" method="post">
        조달계획번호: <input type="number" name="obtain_no" required><br>
        자재번호: <input type="number" id="ma_id" name="ma_id" required><br>
        자재명: <input type="text" id="ma_name" name="ma_name" required ><br>
        수량: <input type="number" name="io_quantity" required min="1"><br>
        출고일: <input type="date" name="io_date" required><br>
        상세내역: <input type="text" name="io_information"><br>
        거래명세서 발행여부: <input type="text" name="invoice_issuance_status" required><br>
        출고처리: <input type="text" name="io_status" value="출고" ReadOnly><br>
        
        <input type="submit" value="출고처리">    
    </form>
</div>

<%@ include file="../include/footer.jsp" %>

<!-- 필수 벤더 스크립트 -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>

</html>
