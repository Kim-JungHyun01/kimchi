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
	function openobtain_maModal() {
		document.getElementById("obtain_maModal").style.display = "flex";
	}//end
	function closeobtain_maModal() {
		document.getElementById("obtain_maModal").style.display = "none";
	}//end
	//계약 정보가져오기
	function selectMaterial(id, category, name, origin,price,amount) {
		document.getElementById("ma_id").value = id;
		document.getElementById("ma_category").value = category;
		document.getElementById("ma_name").value = name;
		document.getElementById("ma_origin").value = origin;
		document.getElementById("ma_price").value = price;
		document.getElementById("bom_ma_amount").value = amount;
		calnum();
		closeobtain_maModal(); // 모달 닫기
	}//end
</script>
<div id="obtain_maModal">
	<div class="modal-content">
		<h3>자재 조회</h3>
		<table>
			<tr>
				<td>자재코드</td>
				<td>분류</td>
				<td>자재명</td>
				<td>원산지</td>
				<td>단가</td>
			</tr>
			<c:forEach var="malist" items="${malist}">
				<c:forEach var="bom_malist" items="${bom_malist}">
					<c:if test="${bom_malist.ma_id == malist.ma_id}">
						<tr
							onclick="selectMaterial('${malist.ma_id}', '${malist.ma_category}', '${malist.ma_name}', '${malist.ma_origin}','${malist.ma_price}','${bom_malist.bom_ma_amount}')">
							<td>${malist.ma_id}</td>
							<td>${malist.ma_category}</td>
							<td>${malist.ma_name}</td>
							<td>${malist.ma_origin}</td>
							<td>${malist.ma_price}</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:forEach>
		</table>
		<button onclick="closeobtain_maModal()">닫기</button>
	</div>
</div>