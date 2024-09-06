<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<script>
	//날짜 나타내는 함수
	//나타내지 않으면 오류 일어남
</script>
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<form method="post" action="itemUpdate" name="itemUpdateForm"
		id="itemUpdateForm">
		<table border="1">
			<tr>
				<td>물품 코드</td>
				<td><input name="item_no" type="number"
					value="${item.item_no }" readonly></td>
			</tr>
			<tr>
				<td>물룸 분류</td>
				<td><select name="item_category" id="item_category"
					title="물품 분류">
						<option value="반제품"
							${item.item_category == '반제품' ? 'selected' : ''}>반제품</option>
						<option value="완제품"
							${item.item_category == '완제품' ? 'selected' : ''}>완제품</option>
				</select></td>
			</tr>
			<tr>
				<td>물품명</td>
				<td><input name="item_name" type="text"
					value="${item.item_name}"></td>
			</tr>
			<tr>
				<td>물품 단가</td>
				<td><input name="item_price" type="number"
					value="${item.item_price}"></td>
			</tr>
			<tr>
				<td>물품 단위</td>
				<td><select name="item_unit" id="item_unit" title="물품 단위">
						<option value="mg" ${item.item_unit == 'mg' ? 'selected' : ''}>mg</option>
						<option value="g" ${item.item_unit == 'g' ? 'selected' : ''}>g</option>
						<option value="kg" ${item.item_unit == 'kg' ? 'selected' : ''}>kg</option>
						<option value="ton" ${item.item_unit == 'ton' ? 'selected' : ''}>ton</option>
						<option value="cc" ${item.item_unit == 'cc' ? 'selected' : ''}>cc</option>
						<option value="ml" ${item.item_unit == 'ml' ? 'selected' : ''}>mL</option>
						<option value="dl" ${item.item_unit == 'dl' ? 'selected' : ''}>dl</option>
						<option value="L" ${item.item_unit == 'L' ? 'selected' : ''}>L</option>
				</select></td>
			</tr>
			<tr>
				<td>물품 무게</td>
				<td><input name="item_weight" type="number"
					value="${item.item_weight}"></td>
			</tr>
			<tr>
				<td>물품 규격</td>
				<td><input name="item_specifications" type="text"
					value="${item.item_specifications}"></td>
			</tr>
			<tr>
				<td>물품 기본재고</td>
				<td><input name="item_basicstock" type="number"
					value="${item.item_basicstock}"></td>
			</tr>
			<tr>
				<td>물품 저장고</td>
				<td><select name="item_storage" id="item_storage"
					title="물품 저장고">
						<option value="냉동창고"
							${item.item_storage == '냉동창고' ? 'selected' : ''}>냉동창고</option>
						<option value="냉장창고"
							${item.item_storage == '냉장창고' ? 'selected' : ''}>냉장창고</option>
						<option value="물류창고"
							${item.item_storage == '물류창고' ? 'selected' : ''}>물류창고</option>
				</select></td>
			</tr>
			<tr>
				<td>물품 생산일</td>
				<td><input name="item_productionDate" type="date"
					value="${item.item_productionDate}" readonly></td>
			</tr>
			<tr>
				<td>물품 첨부파일</td>
				<td><input name="attachment_no" type="text"
					value="${item.attachment_no}" onclick="openModal()"></td>
			</tr>
		</table>
		<div>
			<button onclick="submint">물품수정</button>
			<button onclick="reset">초기화</button>
		</div>
	</form>
</div>
<%@include file="../include/footer.jsp"%>
<!-- 첨부파일 모달창 -->
<jsp:include page="../attachment/attachmentModal.jsp" />