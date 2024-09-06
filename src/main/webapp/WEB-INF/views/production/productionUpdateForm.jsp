<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<div>
		<h3>생산계획 수정</h3>
		<form action="productionUpdate" method="post"
			name="productionUpdateForm" id="productionUpdateForm">
			<div>
				<h4>계약 상세내역</h4>
				<label>계약코드</label> <input name="contracts_no" id="contracts_no"
					type="number" value="${con.contracts_no }" readonly> 
				<label>계약물품코드</label>
				<input name="item_no" id="item_no" type="number" value = "${con.item_no}" readonly> 
				<label>계약물품명</label>
				<input name="item_name" id="item_name" type="text" value = "${item.item_name}" readonly> 
				<label>계약수량</label>
				<input name="contracts_quantity" id="contracts_quantity"
					type="number" value ="${con.contracts_quantity }" readonly> 
				<label>계약가격</label> <input
					name="contracts_price" id="contracts_price" type="number" value ="${con.contracts_price }" readonly>
				<label>계약납기일</label> <input name="contracts_deliveryDate"
					id="contracts_deliveryDate" type="date" value = "${con.contracts_deliveryDate }" readonly>
			</div>
			<div>
				<h4>생산계획 상세정보</h4>
				<label>생산계획코드</label>
				<input name = "production_no" id = "production_no" type ="number" value ="${pro.production_no}" readonly>
				<label>생산수량</label> <input name="production_quantity"
					id="production_quantity" type="number" value ="${pro.production_quantity}"> 
				<label>생산납기일</label>
				<input name="production_deliveryDate" id="production_deliveryDate"
					type="date" value ="${pro.production_deliveryDate}">
			</div>
			<div>
				<h4>생산계획 담당자</h4>
				<input name="user_id" id="user_id" type="hidden" value ="${user.user_id}" readonly>
				<label>담당자명</label>
				<input name="user_name" id="user_name" type="text" value ="${user.user_name}" readonly><br>
				<label>담당자 이메일</label>
				 <input name="user_email" id="user_email" type="text" value ="${user.user_email}" readonly><br> 
				<label>담당자 전화번호</label>
				 <input name="user_number" id=user_number type="text" value ="${user.user_number}" readonly><br> 
				<label>담당자 부서</label>
				 <input name="user_department" id=user_department type="text" value ="${user.user_department}" readonly>
			</div>
			<button type="submit">생산계획수정</button>
			<button type="reset">초기화</button>
		</form>
	</div>
</div>
<%@include file="../include/footer.jsp"%>