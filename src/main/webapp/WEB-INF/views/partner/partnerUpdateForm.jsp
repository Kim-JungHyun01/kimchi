<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<div>
		<h3>협력회사 등록</h3>
		<form action="partnerUpdate" method="post" id="partnerUpdateForm"
			name="partnerUpdateForm">
			<div>
				<label>협력회사 사업자번호</label> <input name="partner_taxid"
					id="partner_taxid" type="text" value="${part.partner_taxid }" readonly>
			</div>
			<div>
				<label>협력회사 id</label> <input name="partner_id" id="partner_id"
					type="text"value="${part.partner_id}" readonly>
			</div>
			<div>
				<label>협력회사 pw</label> <input name="partner_pw" id="partner_pw"
					type="password" value="${part.partner_pw }"readonly>
			</div>
			<div>
				<label>협력회사명</label> <input name="partner_companyname"
					id="partner_companyname" type="text"value="${part.partner_companyname }">
			</div>
			<div>
				<label>협력회사 전화번호</label> <input name="partner_number"
					id="partner_number" type="text"value="${part.partner_number }">
			</div>
			<div>
				<label>협력회사 대표자명</label> <input name="partner_ownername"
					id="partner_ownername" type="text"value="${part.partner_ownername }">
			</div>
			<div>
				<label>협력회사 fax</label> <input name="partner_fax" id="partner_fax"
					type="text"value="${part.partner_fax}">
			</div>
			<div>
				<label>협력회사 email</label> <input name="partner_email"
					id="partner_email" type="text"value="${part.partner_email }">
			</div>
			<div>
				<label>협력회사 사업장주소</label> <input name="partner_add" id="partner_add"
					type="text"value="${part.partner_add }">
			</div>
			<div>
				<button type="submit">협력회사 등록</button>
				<button type="reset">초기화</button>
			</div>
		</form>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
