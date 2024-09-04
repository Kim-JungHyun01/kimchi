<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<div>
		<h3>계약정보 상세보기</h3>
		<table border="1">
			<tr>
				<td>계약코드</td>
				<td>${con.contracts_no }</td>
			</tr>
			<tr>
				<td>계약물품코드</td>
				<td>${con.item_no}</td>
				<td>계약물품명</td>
				<td>${item.item_name}</td>
			</tr>
			<tr>
				<td>계약수량</td>
				<td>${con.contracts_quantity }</td>
			</tr>
			<tr>
				<td>계약가격</td>
				<td>${con.contracts_price }</td>
			</tr>
			<tr>
				<td>계약납기일</td>
				<td>${con.contracts_deliveryDate }</td>
			</tr>
		</table>
		<hr>
		<h3>생산계획 상세정보</h3>
		<table border="1">
			<tr>
				<td>생산계획코드</td>
				<td>${pro.production_no}</td>
			</tr>
			<tr>
				<td>생산수량</td>
				<td>${pro.production_quantity}</td>
			</tr>
			<tr>
				<td>생산납기일</td>
				<td>${pro.production_deliveryDate}</td>
			</tr>
			<tr>
				<td>생산계획 상태</td>
				<td>${pro.production_status}</td>
			</tr>
			<tr>
				<td>생산계획 등록일</td>
				<td>${pro.production_registrationDate}</td>
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
		<c:if test="${pro.production_status eq '생산계획확인중'}">
		<a href="${contextPath}/production/productionUpdateForm?production_no=${pro.production_no}">생산계획 수정</a>
			<form action="productionCheck" method="post" id="checkForm"
				name="checkForm">
				<input type="hidden" name="production_no" id="production_no"
					value="${pro.production_no}"> <input type="hidden"
					name="production_status" id="production_status" value="">
				<button type="button" onclick="submitCheck('생산계획확인완료')">생산계획승인</button>
				<button type="button" onclick="submitCheck('생산계획취소')">생산계획취소</button>
			</form>
		</c:if>
		<a
			href="${contextPath}/contracts/contractsSelect?contracts_no=${pro.contracts_no}">계약상세보기</a>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script>
	function submitCheck(production_status) {
		document.getElementById("production_status").value = production_status;
		document.getElementById("checkForm").submit();
	}//end
</script>
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>