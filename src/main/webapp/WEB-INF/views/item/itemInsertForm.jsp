<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<form method="post" action="itemInsert" name="itemInsertForm"
		id="itemInsertForm">
		<div>
			<p>물룸 분류</p>
			<select name="item_category" id="item_category">
				<option value="반제품" ${item_category == '반제품' ? 'selected' : ''}>반제품</option>
				<option value="완제품" ${item_category =='완제품' ? 'selected' : ''}>완제품</option>
			</select>
		</div>
		<div>
			<p>물품명</p>
			<input name="item_name" id = "item_name" type="text" value="${item_name}"required="required">
		</div>
		<div>
			<p>물품 단가</p>
			<input name="item_price" id = "item_price" type="number" value="${item_price}" required="required">
		</div>
		<div>
			<p>물품 단위</p>
			<select name="item_unit" id="item_unit" required="required">
				<option value="kg" ${item_unit == 'kg' ? 'selected' : ''}>kg</option>
				<option value="ton" ${item_unit == 'ton' ? 'selected' : ''}>ton</option>
				<option value="L" ${item_unit == 'L' ? 'selected' : ''}>L</option>
			</select>
		</div>
		<div>
			<p>물품 무게</p>
			<input name="item_weight" id = "item_weight" type="number" value="${item_weight}" required="required">
		</div>
		<div>
			<p>물품 규격</p>
			<input name="item_specifications"  id = "item_specifications" type="text"
				value="${item_specifications}" required="required">
		</div>
		<div>
			<p>물품 기본재고</p>
			<input name="item_basicstock" id = "item_basicstock" type="number"
				value="${item_basicstock}" required="required">
		</div>
		<div>
			<p>물품 저장고</p>
			<select name="item_storage" id="item_storage" required="required">
				<option value="냉동창고" ${item_storage == '냉동창고' ? 'selected' : ''}>냉동창고</option>
				<option value="냉장창고" ${item_storage == '냉장창고' ? 'selected' : ''}>냉장창고</option>
				<option value="물류창고" ${item_storage == '물류창고' ? 'selected' : ''}>물류창고</option>
			</select>
		</div>
		<div>
			<p>물품 생산일</p>
			<input name="item_productionDate" id ="item_productionDate" type="date"
				value="${item_productionDate}" required="required">
		</div>
		<div>
			<p>물품 첨부파일</p>
			<input name="attachment_no" id="attachment_no" type="number"
				placeholder="첨부파일선택" onclick="openModal()"> <input
				name="attachment_name" id="attachment_name" type="text"
				placeholder="첨부파일선택" onclick="openModal()">
		</div>
		<div>
			<button type="submit">물품추가</button>
			<button type="reset">초기화</button>
		</div>
	</form>
</div>
<%@include file="../include/footer.jsp"%>
<!-- 첨부파일 모달창 -->
<jsp:include page="../attachment/attachmentModal.jsp" />