<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<div>
		<h3>협력회사 등록</h3>
		<form action="partnerInsert" method="post" id="partnerInsertForm"
			name="partnerInsertForm">
			<div>
				<label>협력회사 사업자번호</label> <input name="partner_taxid"
					id="partner_taxid" type="text">
				<button>사업자번호 중복확인</button>
			</div>
			<div>
				<label>협력회사 id</label> <input name="partner_id" id="partner_id"
					type="text">
				<button>id 중복확인</button>
			</div>
			<div>
				<label>협력회사 pw</label> <input name="partner_pw" id="partner_pw"
					type="password"> <label>협력회사 pw 재입력</label> <input
					name="partner_pwcheck" id="partner_pwcheck" type="password">
				<button>비밀번호 확인</button>
			</div>
			<div>
				<label>협력회사명</label> <input name="partner_companyname"
					id="partner_companyname" type="text">
			</div>
			<div>
				<label>협력회사 전화번호</label> <input name="partner_number"
					id="partner_number" type="text">
			</div>
			<div>
				<label>협력회사 대표자명</label> <input name="partner_ownername"
					id="partner_ownername" type="text">
			</div>
			<div>
				<label>협력회사 fax</label> <input name="partner_fax" id="partner_fax"
					type="text">
			</div>
			<div>
				<label>협력회사 email</label> <input name="partner_email"
					id="partner_email" type="text">
			</div>
			<div>
				<label>협력회사 사업장주소</label> <input name="partner_add" id="partner_add"
					type="text">
			</div>
			<div>
				<button type="submit">협력회사 등록</button>
				<button type="reset">초기화</button>
			</div>
		</form>
	</div>
</div>
<%@include file="../include/footer.jsp"%>