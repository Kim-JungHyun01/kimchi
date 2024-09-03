<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<style>
/* 모달창 스타일 */
#contractsModal {
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
	margin-left: 20%;
	margin-right: 10%; /* 오른쪽 여백 추가 */
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
	function opencontractsModal() {
		document.getElementById("contractsModal").style.display = "flex";
	}//end
	function closecontractsModal() {
		document.getElementById("contractsModal").style.display = "none";
	}//end
	//계약 정보가져오기
	function selectContracts(cno, ino, name, quantity, price, deliveryDate) {
		document.getElementById("contracts_no").value = cno;
		document.getElementById("item_no").value = ino;
		document.getElementById("item_name").value = name;
		document.getElementById("contracts_quantity").value = quantity;
		document.getElementById("contracts_price").value = price;
		document.getElementById("contracts_deliveryDate").value = deliveryDate;
		closecontractsModal(); // 모달 닫기
	}//end
</script>
<div id="contractsModal">
	<div class="modal-content">
		<h3>계약 목록</h3>
		<table>
			<tr>
				<td>계약코드</td>
				<td>계약물품코드</td>
				<td>게약물품명</td>
				<td>계약수량</td>
				<td>계약가격</td>
				<td>계약납기일</td>
			</tr>
			<c:forEach var="conlist" items="${conlist}">
				<c:if test="${conlist.contracts_status eq '계약승인'}">
					<c:forEach var="itemlist" items="${itemlist}">
						<c:if test="${conlist.item_no == itemlist.item_no}">
							<tr
								onclick="selectContracts('${conlist.contracts_no}','${conlist.item_no}','${itemlist.item_name}', '${conlist.contracts_quantity}', '${conlist.contracts_price}', '${conlist.contracts_deliveryDate}' )">
								<td>${conlist.contracts_no}</td>
								<td>${conlist.item_no}</td>
								<td>${itemlist.item_name}</td>
								<td>${conlist.contracts_quantity}</td>
								<td>${conlist.contracts_price}</td>
								<td>${conlist.contracts_deliveryDate}</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</table>
		<button onclick="closecontractsModal()">닫기</button>
	</div>
</div>