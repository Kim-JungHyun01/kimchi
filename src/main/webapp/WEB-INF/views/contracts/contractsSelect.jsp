<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<div>
		<h3>계약 상세정보</h3>
		<table border="1">
			<tr>
				<td>계약코드</td>
				<td>${con.contracts_no}</td>
			</tr>
			<tr>
				<td>계약물품코드</td>
				<td>게약물품분류</td>
				<td>게약물품명</td>
				<td>게약물품단가</td>
			</tr>
			<tr>
				<td>${con.item_no}</td>
				<td>${item.item_category}</td>
				<td>${item.item_name}</td>
				<td>${item.item_price}</td>
			</tr>
			<tr>
				<td>계약수량</td>
				<td>${con.contracts_quantity}</td>
			</tr>
			<tr>
				<td>계약가격</td>
				<td>${con.contracts_price}</td>
			</tr>
			<tr>
				<td>계약납기일</td>
				<td>${con.contracts_deliveryDate}</td>
			</tr>
			<tr>
				<td>계약상태</td>
				<td>${con.contracts_status}</td>
			</tr>
			<tr>
				<td>계약상세</td>
				<td>${con.contracts_details}</td>
			</tr>
			<tr>
				<td>계약등록일</td>
				<td>${con.contracts_registrationDate}</td>
			</tr>
			<tr>
				<td>계약서류발행여부</td>
				<td>${con.contracts_document}</td>
			</tr>
		</table>
	</div>
	<hr>
	<div>
		<h3>계약협력회사 상세정보</h3>
		<table border="1">
			<tr>
				<td>혁력회사 사업자번호</td>
				<td>${con.partner_taxid}</td>
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
		<h3>계약담당 상세정보</h3>
		<table border="1">
			<tr>
				<td>계약담당자 명</td>
				<td>${user.user_name}</td>
			</tr>
			<tr>
				<td>계약담당자 이메일</td>
				<td>${user.user_email}</td>
			</tr>
			<tr>
				<td>계약담당자 전화번호</td>
				<td>${user.user_number}</td>
			</tr>
		</table>
	</div>
	<div>
		<!-- contracts_status : 계약확인중, 계약승인, 계약취소 -->
		<c:choose>
			<c:when test="${con.contracts_status eq '계약확인중'}">
				<a type="button"
					href="${contextPath}/contracts/contractsUpdateForm?contracts_no=${con.contracts_no}">계약수정</a>
				<button type="button">계약승인</button>
				<button type="button">계약취소</button>
			</c:when>
			<c:otherwise>
				<button type="button">계약서확인</button>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>

<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>