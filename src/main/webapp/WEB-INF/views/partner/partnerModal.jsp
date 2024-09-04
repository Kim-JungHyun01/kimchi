<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<style>
/* 모달창 스타일 */
#partnerModal {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	justify-content: center;
	align-items: center; /* 수직 중앙 정렬 */
}

.modal-content {
	background-color: white;
	padding: 20px;
	width: 80%; /* 모달 너비를 50%로 설정 */
	max-height: 70%; /* 최대 높이 조정 */
	overflow-y: auto;
	border-radius: 8px;
	margin-left: 10%;
	margin-right: 0%; /* 오른쪽 여백 추가 */
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	border: 1px solid #ccc;
}

button {
	margin-top: 40px;
}
</style>
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
<div id="partnerModal">
	<div class="modal-content">
		<h3>협력회사 목록</h3>
		<table>
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
		<button onclick="closepartnerModal()">닫기</button>
	</div>
</div>