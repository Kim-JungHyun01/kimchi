<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<style>
/* 모달스타일 */
.modal-long {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.7); /* 배경을 더 어둡게 */
	justify-content: center;
	align-items: center; /* 수직 중앙 정렬 */
	z-index: 1000; /* 다른 요소 위에 표시 */
}
.modal-content{
	width: 80%;
}

.modal-table {
	width: 100%; /* 테이블 너비 100% */
	border-collapse: collapse; /* 테두리 겹치지 않게 */
}

.modal-table th, .modal-table td {
	padding: 10px; /* 셀 패딩 */
	border: 1px solid #000; /* 셀 테두리 색상 검정 */
	text-align: center; /* 텍스트 가운데 정렬 */
	color: #000; /* 글자 색상 검정 */
}

.filter-button {
	display: inline-block;
	padding: 10px 20px; /* 버튼 크기 증가 */
	margin-left: 10px;
	margin-right: 15px;
	border: none;
	border-radius: 5px;
	background-color: #5892d1;
	color: white;
	cursor: pointer;
	transition: background-color 0.3s;
	font-size: 1.2em; /* 글자 크기 증가 */
}

.filter-button:hover {
	background-color: #467aab; /* 호버 시 배경색 변화 */
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
	function selectContracts(cno, ino, name,schedule, quantity, price, deliveryDate) {
		document.getElementById("contracts_no").value = cno;
		document.getElementById("item_no").value = ino;
		document.getElementById("item_name").value = name;
		document.getElementById("bom_schedule").value = schedule;
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
				<td>게약물품 제조소요일(일)</td>
				<td>계약수량</td>
				<td>계약가격</td>
				<td>계약납기일</td>
			</tr>
			<c:forEach var="conlist" items="${conlist}">
				<c:if test="${conlist.contracts_status eq '계약승인'}">
					<c:forEach var="itemlist" items="${itemlist}">
						<c:if test="${conlist.item_no == itemlist.item_no}">
							<tr
								onclick="selectContracts('${conlist.contracts_no}','${conlist.item_no}','${itemlist.item_name}','${itemlist.bomVO.bom_schedule}', '${conlist.contracts_quantity}', '${conlist.contracts_price}', '${conlist.contracts_deliveryDate}' )">
								<td>${conlist.contracts_no}</td>
								<td>${conlist.item_no}</td>
								<td>${itemlist.item_name}</td>
								<td>${itemlist.bomVO.bom_schedule}일</td>
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