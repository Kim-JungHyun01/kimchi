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
		<table border="1">
			<tr>
				<td>조달계획코드</td>
				<td>${obtain.obtain_no}</td>
			</tr>
			<tr>
				<td>조달계획 자재코드</td>
				<td>조달계획 자재명</td>
				<td>조달계획 자재단가</td>
			</tr>
			<tr>
				<td>${obtain.ma_id}</td>
				<td>${ma.ma_name}</td>
				<td>${ma.ma_price}</td>
			</tr>
			<tr>
				<td>조달계획 자재조달량</td>
				<td>${obtain.obtain_quantity}</td>
			</tr>
			<tr>
				<td>조달계획가격</td>
				<td>${obtain.obtain_price}</td>
			</tr>
			<tr>
				<td>조달계획납기일</td>
				<td>${obtain.obtain_deliveryDate}</td>
			</tr>
			<tr>
				<td>조달계획상태</td>
				<td>${obtain.obtain_status}</td>
			</tr>
			<tr>
				<td>조달계획등록일</td>
				<td>${obtain.obtain_registrationDate}</td>
			</tr>
			<tr>
				<td>조달계획서류발행여부</td>
				<td>${obtain.obtain_document}</td>
			</tr>

			<tr>
				<td>생산계획코드</td>
				<td>생산량</td>
				<td>생산납기일</td>
			</tr>
			<tr>
				<td>${obtain.production_no}</td>
				<td>${pro.production_quantity}</td>
				<td>${pro.production_deliveryDate}</td>
			</tr>
		</table>
	</div>
	<hr>
	<div>
		<h3>조달계획 협력회사 상세정보</h3>
		<table border="1">
			<tr>
				<td>혁력회사 사업자번호</td>
				<td>${obtain.partner_taxid}</td>
			</tr>
			<tr>
				<td>혁력회사 명</td>
				<td>${partner.partner_companyname }</td>
			</tr>
			<tr>
				<td>협력회사 대표자명</td>
				<td>${partner.partner_ownername }</td>
			</tr>
			<tr>
				<td>협력회사 전화번호</td>
				<td>${partner.partner_number }</td>
			</tr>
			<tr>
				<td>협력회사 이메일</td>
				<td>${partner.partner_email }</td>
			</tr>
		</table>
	</div>
	<hr>
	<div>
		<h3>담당자정보</h3>
		<table border="1">
			<tr>
				<td>담당자명</td>
				<td>담당자email</td>
				<td>담당자전화번호</td>
				<td>담당자부서</td>
			</tr>
			<tr>
				<td>${user.user_name}</td>
				<td>${user.user_email}</td>
				<td>${user.user_number}</td>
				<td>${user.user_department}</td>
			</tr>
		</table>
	</div>
	<div>
		<c:if test="${obtain.obtain_status eq '조달계획확인중'}">
		<a href="${contextPath}/obtain/obtainUpdateForm?obtain_no=${obtain.obtain_no}">조달계획 수정</a>
			<form action="obtainCheck" method="post" id="checkForm" name="checkForm">
				<input type="hidden" name="obtain_no" id="obtain_no" value="${obtain.obtain_no}"> 
				<input type="hidden" name="obtain_status" id="obtain_status" value="">
				<button type="button" onclick="submitCheck('조달계획확인완료')">조달계획승인</button>
				<button type="button" onclick="submitCheck('조달계획취소')">조달계획취소</button>
			</form>
		</c:if>
		<a href="${contextPath}/production/productionSelect?production_no=${obtain.production_no}">생산계획보기</a>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script>
//조달계획확인 & 취소
	function submitCheck(obtain_status) {
		document.getElementById("obtain_status").value = obtain_status;
		document.getElementById("checkForm").submit();
	}//end
</script>
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>