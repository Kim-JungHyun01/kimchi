<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<style>
/* 모달창 스타일 */
#productionModal {
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
	function openproductionModal() {
		document.getElementById("productionModal").style.display = "flex";
	}//end
	function closeproductionModal() {
		document.getElementById("productionModal").style.display = "none";
	}//end
	//계약 정보가져오기
	function selectProduction(no, quantity, deliveryDate, contracts_no) {
		document.getElementById("production_no").value = no;
		document.getElementById("production_quantity").value = quantity;
		document.getElementById("production_deliveryDate").value = deliveryDate;
		document.getElementById("contracts_no").value = contracts_no;
		closeproductionModal(); // 모달 닫기
	}//end
</script>
<div id="productionModal">
	<div class="modal-content">
		<h3>생산계획 상세정보</h3>
		<table border="1">
			<tr>
				<td>생산계획코드</td>
				<td>생산수량</td>
				<td>생산납기일</td>
			</tr>
			<c:forEach var="prolist" items="${prolist}">
				<c:if test="${prolist.production_status eq '생산계획확인완료'}">
					<tr
						onclick="selectProduction('${prolist.production_no}', '${prolist.production_quantity}', '${prolist.production_deliveryDate}', '${prolist.contracts_no}')">
						<td>${prolist.production_no}</td>
						<td>${prolist.production_quantity}</td>
						<td>${prolist.production_deliveryDate}</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<button onclick="closeproductionModal()">닫기</button>
	</div>
</div>
<%@include file="../include/footer.jsp"%>