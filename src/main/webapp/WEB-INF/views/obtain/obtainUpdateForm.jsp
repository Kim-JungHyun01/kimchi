<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<div>
		<h3>조달계획 수정화면</h3>
		<form action="obtainUpdate" method="post" id="obtainUpdateForm"
			name="obtainUpdateForm">
			<div>
				<h4>생산계획 상세</h4>
				<label>생산계획코드</label> <input name="production_no" id="production_no"
					type="number" value="${obtain.production_no}" readonly><br>
				<label>생산량</label> <input name="production_quantity"
					id="production_quantity" type="number"
					value="${pro.production_quantity }" readonly><br> <label>생산납기일</label>
				<input name="production_deliveryDate" id="production_deliveryDate"
					type="date" value="${pro.production_deliveryDate }" readonly>
			</div>
			<div>
				<h4>조달자재 상세</h4>
				<label>자재코드</label> <input name="ma_id" id="ma_id" type="number" value = "${ma.ma_id }" readonly><br>
				<label>자재분류</label> <input name="ma_category" id="ma_category"
					type="text" value = "${ma.ma_category }" readonly><br> <label>자재명</label> <input
					name="ma_name" id="ma_name" type="text" value = "${ma.ma_name}" readonly><br> <label>자재원산지</label>
				<input name="ma_origin" id="ma_origin" type="text" value = "${ma.ma_origin}" readonly><br>
				<label>자재단가</label> <input name="ma_price" id="ma_price"
					type="number" value = "${ma.ma_price }" readonly>
			</div>
			<div>
				<h4>조달계획 상세</h4>
				<label>조달계획코드</label> <input name="obtain_no"
					id="obtain_no" type="number"
					value="${obtain.obtain_no}"><br>
				<label>자재조달량</label> <input name="obtain_quantity"
					id="obtain_quantity" type="number"
					value="${obtain.obtain_quantity}"><br> <label>조달계획가격</label><input
					name="obtain_price" id="obtain_price" type="number"
					value="${obtain.obtain_price}" readonly><br> <label>조달계획납기일</label>
				<input name="obtain_deliveryDate" id="obtain_deliveryDate"
					type="date" value="${obtain.obtain_deliveryDate}">
			</div>
			<div>
				<h4>조달계획 협력회사 상세정보</h4>
				<label>협력회사 사업자번호</label> <input name="partner_taxid"
					id="partner_taxid" type="text" value="${obtain.partner_taxid }"
					readonly><br> <label>협력회사 회사명</label> <input
					name="partner_companyname" id="partner_companyname" type="text"
					value="${partner.partner_companyname }" readonly><br>
				<label>협력회사 대표자명</label> <input name="partner_ownername"
					id="partner_ownername" type="text"
					value="${partner.partner_ownername }" readonly><br> <label>협력회사
					전화번호</label> <input name="partner_number" id="partner_number" type="text"
					value="${partner.partner_number }" readonly><br> <label>협력회사
					이메일</label> <input name="partner_email" id="partner_email" type="text"
					value="${partner.partner_email }" readonly>
			</div>
			<div>
				<h4>계약담당자</h4>
				<input name="user_id" id="user_id" type="hidden">
				<label>담당자명</label>
				<input name="user_name" id="user_name" type="text"
					value="${user.user_name }" readonly><br> <label>담당자
					이메일</label> <input name="user_email" id="user_email" type="text"
					value="${user.user_email }" readonly><br> <label>담당자
					전화번호</label> <input name="user_number" id=user_number type="text"
					value="${user.user_number }" readonly><br> <label>담당자
					부서</label> <input name="user_department" id=user_department type="text"
					value="${user.user_department }" readonly>
			</div>
			<div>
				<button type="submit">조달계획수정</button>
				<button type="reset">초기화</button>
			</div>
		</form>
	</div>
</div>
<%@include file="../include/footer.jsp"%>