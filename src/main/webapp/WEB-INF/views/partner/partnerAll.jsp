<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<div>
		<h3>협력회사 목록</h3>
		<table border="1">
			<tr>
				<td>협력회사 사업자번호</td>
				<td>협력회사 id</td>
				<td>협력회사 pw</td>
				<td>협력회사명</td>
				<td>협력회사 전화번호</td>
				<td>협력회사 대표자명</td>
				<td>협력회사 fax</td>
				<td>협력회사 email</td>
				<td>협력회사 사업장주소</td>
				<td>협력회사 승인여부</td>
			</tr>
			<c:forEach var="partnerlist" items="${partnerlist}">
				<tr>
					<td><a href="${contextPath}/partner/partnerSelect?partner_taxid=${partnerlist.partner_taxid }">${partnerlist.partner_taxid }</a></td>
					<td>${partnerlist.partner_id }</td>
					<td>${partnerlist.partner_pw }</td>
					<td>${partnerlist.partner_companyname }</td>
					<td>${partnerlist.partner_number }</td>
					<td>${partnerlist.partner_ownername }</td>
					<td>${partnerlist.partner_fax }</td>
					<td>${partnerlist.partner_email }</td>
					<td>${partnerlist.partner_add }</td>
					<td>${partnerlist.partner_approval }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
