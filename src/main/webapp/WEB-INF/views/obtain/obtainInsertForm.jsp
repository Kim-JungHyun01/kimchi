<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<div>
		<h3>조달계획 등록</h3>
		<form action="obtainInsert" method="post" id="obtainInsertForm"
			name="obtainInsertForm">
			<div>
				<h4>생산계획 상세</h4>
				<label>생산계획코드</label> <input name="production_no" id="production_no"
					type="number" placeholder="생산계획선택" onclick="openproductionModal()"><br>
				<label>생산량</label> <input name="production_quantity"
					id="production_quantity" type="number" placeholder="생산계획선택"
					onclick="openproductionModal()"><br> <label>생산납기일</label>
				<input name="production_deliveryDate" id="production_deliveryDate"
					type="date" placeholder="생산계획선택" onclick="openproductionModal()"
					readonly>
			</div>
			<div>
				<h4>조달자재 상세</h4>
				<label>자재코드</label> <input name="ma_id" id="ma_id" type="number"
					placeholder="자재선택" onclick="openmaModal()"><br> <label>자재분류</label>
				<input name="ma_category" id="ma_category" type="text"
					placeholder="자재선택" onclick="openmaModal()"><br> <label>자재명</label>
				<input name="ma_name" id="ma_name" type="text" placeholder="자재선택"
					onclick="openmaModal()"><br> <label>자재원산지</label> <input
					name="ma_origin" id="ma_origin" type="text" placeholder="자재선택"
					onclick="openmaModal()"><br> <label>자재단가</label> <input
					name="ma_price" id="ma_price" type="number" placeholder="자재선택"
					onclick="openmaModal()">
					<input id = "ma_unit" name = "ma_unit" type = "hidden">
					<input id = "ma_weight" name = "ma_weight" type = "hidden">
					<input id = "ma_stockQuantity" name = "ma_stockQuantity" type = "hidden">
					<input id = "ma_specifications" name = "ma_specifications" type = "hidden">
			</div>
			<div>
				<h4>조달게획 상세</h4>
				<label>자재조달량</label> <input name="obtain_quantity"
					id="obtain_quantity" type="number"><br> <label>조달계획가격</label>
				<input name="obtain_price" id="obtain_price" type="number"><br>
				<label>조달계획납기일</label> <input name="obtain_deliveryDate"
					id="obtain_deliveryDate" type="date">
			</div>
			<div>
				<h4>조달계획 협력회사 상세정보</h4>
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
				<button type="submit">조달계획등록</button>
				<button type="reset">초기화</button>
			</div>
		</form>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- 자재모달창 -->
<jsp:include page="../material/maModal.jsp" />
<!-- 생산계획모달창 -->
<jsp:include page="../production/productionModal.jsp" />
<!-- 협력회사 모달창 -->
<jsp:include page="../partner/partnerModal.jsp" />
<!-- 담당자 모달창 -->
<jsp:include page="../user/userModal.jsp" />
<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>