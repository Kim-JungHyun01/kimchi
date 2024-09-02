<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<h3>생산계획 추가</h3>
	<div class = "modal">
		<p>계약상세정보</p>
	</div>
	<div>
		<p>생산수량</p>
		<input name="production_quantity" type="number">
	</div>
	<div>
		<p>생산납기일</p>
		<input name="production_deliveryDate" type="date">
	</div>
	<div>
		<p></p>
	</div>
</div>
<div class="content-body">
	<h3>담당자정보</h3>
	<div></div>
</div>
<%@include file="../include/footer.jsp"%>


<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>