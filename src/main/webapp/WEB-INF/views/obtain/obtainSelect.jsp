<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<div>
		<h3>조달계획 상세보기</h3>
		<table>
			<tr>
				<td>조달계획코드</td>
				<td>${oblist.obtain_no}</td>
			</tr>
			<tr>
				<td>조달계획 물품</td>
				<td>${oblist.ma_id}</td>
			</tr>
			<tr>
				<td>조달량</td>
				<td>${oblist.obtain_quantity}</td>
			</tr>
			<tr>
				<td>조달계획납기일</td>
				<td>${oblist.obtain_deliveryDate}</td>
			</tr>
			<tr>
				<td>조달계획상태</td>
				<td>${oblist.obtain_status}</td>
			</tr>
			<tr>
				<td>조달계획등록일</td>
				<td>${oblist.obtain_registrationDate}</td>
			</tr>
			<tr>
				<td>조달계획서류발행여부</td>
				<td>${oblist.obtain_document}</td>
			</tr>

			<tr>
				<td>생산계획코드</td>
				<td>${oblist.production_no}</td>
			</tr>
		</table>
	</div>
	<div>
		<h3>협력회사정보</h3>
		<table>
			<tr>
				<td>협력회사 사업자번호</td>
				<td>${oblist.partner_taxid}</td>
			</tr>
		</table>
	</div>
	<div>
		<h3>담당자정보</h3>
		<table>
			<tr>
				<td>담당자 id</td>
				<td>${oblist.user_id}</td>
			</tr>
		</table>
	</div>
	<div>
		<a>조달계획수정</a>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
 <!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>