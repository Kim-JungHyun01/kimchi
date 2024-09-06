<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<div>
		<h3>생산계획 등록</h3>
		<form action="productionInsert" method="post"
			name="productionInsertForm" id="productionInsertForm">
			<div>
				<h4>계약 상세내역</h4>
				<label>계약코드</label> <input name="contracts_no" id="contracts_no"
					type="number" placeholder="계약선택" onclick="opencontractsModal()"><br>
				<label>계약물품코드</label> <input name="item_no" id="item_no"
					type="number" placeholder="계약선택" onclick="opencontractsModal()"><br>
				<label>계약물품명</label> <input name="item_name" id="item_name"
					type="text" placeholder="계약선택" onclick="opencontractsModal()"><br>
				<label>계약수량</label> <input name="contracts_quantity"
					id="contracts_quantity" type="number" placeholder="계약선택"
					onclick="opencontractsModal()"><br> <label>계약가격</label> <input
					name="contracts_price" id="contracts_price" type="number"
					placeholder="계약선택" onclick="opencontractsModal()"><br> <label>계약납기일</label>
				<input name="contracts_deliveryDate" id="contracts_deliveryDate"
					type="date" placeholder="계약선택" onclick="opencontractsModal()" readonly>
			</div>
			<div>
				<h4>생산계획 상세정보</h4>
				<label>생산수량</label> <input name="production_quantity"
					id="production_quantity" type="number"><br> <label>생산납기일</label>
				<input name="production_deliveryDate" id="production_deliveryDate"
					type="date">
			</div>
			<div>
				<h4>생산계획 담당자</h4>
			<input name="user_id" id="user_id" type="hidden"> 
			<label>담당자명</label>
			<input name="user_name" id="user_name" type="text"
				placeholder="담당자선택" onclick="openuserModal()"><br> 
			<label>담당자 이메일</label> <input name="user_email" id="user_email" type="text"
				placeholder="담당자선택" onclick="openuserModal()"><br> <label>담당자
				전화번호</label> <input name="user_number" id=user_number type="text"
				placeholder="담당자선택" onclick="openuserModal()"><br>
				<label>담당자 부서</label> <input name="user_department" id=user_department type="text"
				placeholder="담당자선택" onclick="openuserModal()">
			</div>
			<button type="submit">생산계획등록</button>
			<button type="reset">초기화</button>
		</form>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- 계약 모달창 -->
<jsp:include page="../contracts/contractsModal.jsp" />
<!-- 담당자 모달창 -->
<jsp:include page="../user/userModal.jsp" />