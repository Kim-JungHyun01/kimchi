<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<div>
		<h3>계약 등록</h3>
		<form action="contractsInsert" method="post"
			name="contractsInsertForm" id="contractsInsertForm">
			<div>
				<h4>물품 상세</h4>
				<label>계약물품코드</label> <input name="item_no" id="item_no"
					type="number" placeholder="물품선택" onclick="openitemModal()"><br>
				<label>계약물품분류</label> <input name="item_category" id="item_category"
					type="text" placeholder="물품선택" onclick="openitemModal()"><br>
				<label>계약물품명</label> <input name="item_name" id="item_name"
					type="text" placeholder="물품선택" onclick="openitemModal()"><br>
				<label>계약물품단가</label> <input name="item_price" id="item_price"
					type="number" placeholder="물품선택" onclick="openitemModal()">
			</div>
			<div>
				<label>계약수량</label> <input name="contracts_quantity"
					id="contracts_quantity" type="number">
			</div>
			<div>
				<label>계약가격</label> <input name="contracts_price"
					id="contracts_price" type="number">
			</div>
			<div>
				<label>계약납기일</label> <input name="contracts_deliveryDate"
					id="contracts_deliveryDate" type="date">
			</div>
			<div>
				<label>계약상세</label>
				<textarea id="contracts_details" rows="8" name="contracts_details"
					placeholder="계약상세내용"></textarea>
			</div>
			<div>
				<h4>계약협력회사 상세정보</h4>
				<label>협력회사 사업자번호</label> <input name="partner_taxid"
					id="partner_taxid" type="text" placeholder="협력회사선택"
					onclick="openpartnerModal()"><br> <label>협력회사
					회사명</label> <input name="partner_companyname" id="partner_companyname"
					type="text" placeholder="협력회사선택" onclick="openpartnerModal()"><br>
				<label>협력회사 대표자명</label> <input name="partner_ownername"
					id="partner_ownername" type="text" placeholder="협력회사선택"
					onclick="openpartnerModal()"><br> <label>협력회사
					전화번호</label> <input name="partner_number" id="partner_number" type="text"
					placeholder="협력회사선택" onclick="openpartnerModal()"><br>
				<label>협력회사 이메일</label> <input name="partner_email"
					id="partner_email" type="text" placeholder="협력회사선택"
					onclick="openpartnerModal()">
			</div>
			<div>
				<h4>계약담당자</h4>
				<input name="user_id" id="user_id" type="hidden"> <label>담당자명</label>
				<input name="user_name" id="user_name" type="text"
					placeholder="담당자선택" onclick="openuserModal()"><br> <label>담당자
					이메일</label> <input name="user_email" id="user_email" type="text"
					placeholder="담당자선택" onclick="openuserModal()"><br> <label>담당자
					전화번호</label> <input name="user_number" id=user_number type="text"
					placeholder="담당자선택" onclick="openuserModal()"><br> <label>담당자
					부서</label> <input name="user_department" id=user_department type="text"
					placeholder="담당자선택" onclick="openuserModal()">
			</div>
			<div>
				<button type="submit">계약등록</button>
				<button type="reset">초기화</button>
			</div>
		</form>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- 물품 모달창 -->
<jsp:include page="../item/itemModal.jsp" />
<!-- 협력회사 모달창 -->
<jsp:include page="../partner/partnerModal.jsp" />
<!-- 담당자 모달창 -->
<jsp:include page="../user/userModal.jsp" />
<!-- Required vendors -->
<script>
	
</script>
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>