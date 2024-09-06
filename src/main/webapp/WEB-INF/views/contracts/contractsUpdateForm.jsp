<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<form action="contractsUpdate" method="post" name="contractsUpdateForm"
		id="contractsUpdateForm">
		<div>
			<h3>계약 수정화면</h3>
		</div>
		<div>
			<p>계약코드</p>
			<input name="contracts_no" id="contracts_no" type="number"
				value="${con.contracts_no}" readonly>
		</div>

		<div>
			<p>계약물품코드</p>
			<input name="item_no" id="item_no" type="number"
				value="${con.item_no}" readonly><br> <input
				name="item_category" id="item_category" type="text"
				value="${item.item_category}" readonly><br> <input
				name="item_name" id="item_name" type="text"
				value="${item.item_name}" readonly><br> <input
				name="item_price" id="item_price" type="number"
				value="${item.item_price}" readonly>
		</div>
		<div>
			<p>계약수량</p>
			<input name="contracts_quantity" id="contracts_quantity"
				type="number" value="${con.contracts_quantity}">
		</div>
		<div>
			<p>계약가격</p>
			<input name="contracts_price" id="contracts_price" type="number"
				value="${con.contracts_price}" readonly>
		</div>
		<div>
			<p>계약납기일</p>
			<input name="contracts_deliveryDate" id = "contracts_deliveryDate"
				type="date" value="${con.contracts_deliveryDate}" >
		</div>
		<div>
			<p>계약상세</p>
			<textarea id="contracts_details" rows="8" name="contracts_details">${con.contracts_details}</textarea>
		</div>
		<div>
			<p>계약협력회사 상세정보</p>
			협력회사 사업자번호 : <input name="partner_taxid" id="partner_taxid"
				type="text" value="${con.partner_taxid}" readonly><br>
			협력회사명<input name="partner_companyname" id="partner_companyname"
				type="text" value="${partner.partner_companyname }" readonly><br>
			협력회사 대표자명<input name="partner_ownername" id="partner_ownername"
				type="text" value="${partner.partner_ownername }" readonly><br>
			협력회사 전화번호<input name="partner_number" id="partner_number" type="text"
				value="${partner.partner_number }" readonly><br> 협력회사
			이메일<input name="partner_email" id="partner_email" type="text"
				value="${partner.partner_email }" readonly>
		</div>
		<div>
			<p>계약담당자</p>
			담당자명 : <input name="user_name" id="user_name" type="text"
				value="${user.user_email}" readonly><br> 담당자 이메일 : <input
				name="user_email" id="user_email" type="text"
				value="${user.user_name}" readonly><br> 담당자 전화번호 : <input
				name="user_number" id=user_number type="text"
				value="${user.user_number}" readonly> <input name="user_id"
				id="user_id" type="text" value="${con.user_id}" readonly>
		</div>
		<div>
			<button type="submit">계약수정</button>
			<button type="reset">초기화</button>
		</div>
	</form>
</div>
<%@include file="../include/footer.jsp"%>