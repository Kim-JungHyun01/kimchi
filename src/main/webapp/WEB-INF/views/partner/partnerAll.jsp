<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<link href="<c:url value="${contextPath}/resources/css/mystyle.css"/>" rel='stylesheet' />
<script>
function checkApproval(partner_approval, partner_taxid) {
    $.ajax({
        type: 'POST',
        url: 'partnerApproval', // 요청할 URL
        data: {
        	partner_taxid: partner_taxid,
        	partner_approval: partner_approval
        },
        success: function(response) {
            // 페이지 새로고침
            location.reload();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("서버 오류:", textStatus, errorThrown);//콘솔에 오류
        }
    });
}
</script>
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<form action="?pageNum=1" method="get" class="search-form">
		<input type="text" name="partner_companyname" placeholder="협력 회사명 검색"
			value="${param.partner_companyname}" class="search-input" />
		<button type="submit" class="search-button">검색</button>
	</form>

	<div style="margin-left: 20px;">
		<h3>협력회사 목록</h3>

		<table class="table">
			<tr>
				<td>협력회사 사업자번호</td>
				<td>협력회사 명칭</td>
				<td>협력회사 전화번호</td>
				<td>협력회사 대표자명</td>
				<td>협력회사 fax</td>
				<td>협력회사 email</td>
				<td>협력회사 승인여부</td>
				<td>수정이동</td>
			</tr>
			<c:forEach var="partnerlist" items="${partnerlist}">
				<tr
					onclick="location.href='${contextPath}/partner/partnerSelect?partner_taxid=${partnerlist.partner_taxid}'"
					style="cursor: pointer;">
					<td>${partnerlist.partner_taxid }</td>
					<td>${partnerlist.partner_companyname }</td>
					<td>${partnerlist.partner_number }</td>
					<td>${partnerlist.partner_ownername }</td>
					<td>${partnerlist.partner_fax }</td>
					<td>${partnerlist.partner_email }</td>

					<c:if test="${partnerlist.partner_approval eq 0 }">
						<td><button type="button"
								onclick="checkApproval(${partnerlist.partner_approval}, '${partnerlist.partner_taxid }')">승인부여</button></td>
					</c:if>
					<c:if test="${partnerlist.partner_approval eq 1 }">
						<td><button type="button"
								onclick="checkApproval(${partnerlist.partner_approval}, '${partnerlist.partner_taxid }')">승인부여해제</button></td>
					</c:if>
					<td><a href="${contextPath}/partner/partnerUpdateForm?partner_taxid=${partnerlist.partner_taxid }">수정</a></td>
				</tr>
			</c:forEach>
		</table>
		<!-- Pagination -->
		<%@include file = "../include/paging.jsp" %>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
