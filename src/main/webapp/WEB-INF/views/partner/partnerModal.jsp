<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<script>
	function openpartnerModal() {
		document.getElementById("partnerModal").style.display = "flex";
	}//end
	function closepartnerModal() {
		document.getElementById("partnerModal").style.display = "none";
	}//end
	//협력회사 정보가져오기
	function selectPartner(taxid, companyname, ownername, number, email) {
		document.getElementById("partner_taxid").value = taxid;
		document.getElementById("partner_companyname").value = companyname;
		document.getElementById("partner_ownername").value = ownername;
		document.getElementById("partner_number").value = number;
		document.getElementById("partner_email").value = email;
		closepartnerModal(); // 모달 닫기
	}//end
</script>
<div id="partnerModal" class="modal-long">
	<div class="modal-content">
		<div class="modal-header">
			<h3>협력회사 목록</h3>
		</div>
		<div class="modal-body">
			<table class="modal-table">
				<tr>
					<td>혁력회사 사업자번호</td>
					<td>혁력회사 명</td>
					<td>협력회사 대표자명</td>
					<td>협력회사 전화번호</td>
					<td>협력회사 이메일</td>
				</tr>
				<c:forEach var="partnerlist" items="${partnerlist}">
					<c:if test="${partnerlist.partner_approval eq 1}">
						<tr
							onclick="selectPartner('${partnerlist.partner_taxid }','${partnerlist.partner_companyname }', '${partnerlist.partner_ownername }', '${partnerlist.partner_number }', '${partnerlist.partner_email }' )">
							<td>${partnerlist.partner_taxid }</td>
							<td>${partnerlist.partner_companyname }</td>
							<td>${partnerlist.partner_ownername }</td>
							<td>${partnerlist.partner_number }</td>
							<td>${partnerlist.partner_email }</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<div class="modal-footer">
				<button type="button" class="filter-button" onclick="closepartnerModal()">닫기</button>
			</div>
		</div>
	</div>
</div>