<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<div>
		<h3>협력회사 상세보기</h3>
		<table border="1">
			<tr>
				<td>협력회사 사업자번호</td>
				<td>${part.partner_taxid }</td>
			</tr>
			<tr>
				<td>협력회사 id</td>
				<td>${part.partner_id }</td>
			</tr>
			<tr>
				<td>협력회사 pw</td>
				<td>${part.partner_pw }</td>
			</tr>
			<tr>
				<td>협력회사명</td>
				<td>${part.partner_companyname }</td>
			</tr>
			<tr>
				<td>협력회사 전화번호</td>
				<td>${part.partner_number }</td>
			</tr>
			<tr>
				<td>협력회사 대표자명</td>
				<td>${part.partner_ownername }</td>
			</tr>
			<tr>
				<td>협력회사 fax</td>
				<td>${part.partner_fax }</td>
			</tr>
			<tr>
				<td>협력회사 email</td>
				<td>${part.partner_email }</td>
			</tr>
			<tr>
				<td>협력회사 사업장주소</td>
				<td>${part.partner_add }</td>
			</tr>
			<tr>
				<td>협력회사 승인여부</td>
				<td>${part.partner_approval }</td>
			</tr>
		</table>
		<form action="partnerApproval" method="post" name="partnerApprovalForm"
			id="partnerApprovalForm">
			<input type="hidden" name="partner_taxid" id="partner_taxid"
				value="${part.partner_taxid }"> <input type="hidden"
				name="partner_approval" id="partner_approval" value="">
			<c:if test="${part.partner_approval eq 0 }">
				<div>
					<button type="button" onclick="checkApproval(1)">협력회사 승인부여</button>
				</div>
			</c:if>
			<c:if test="${part.partner_approval eq 1 }">
				<div>
					<button type="button" onclick="checkApproval(0)">협력회사 승인해제</button>
				</div>
			</c:if>
		</form>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script>
	function checkApproval(partner_approval) {
		document.getElementById("partner_approval").value = partner_approval;
		document.getElementById("partnerApprovalForm").submit();
	}//end
</script>