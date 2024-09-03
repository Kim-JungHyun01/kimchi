<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<style>
/* 모달창 스타일 */
#itemModal {
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
	width: 20%; /* 모달 너비를 50%로 설정 */
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
	function openitemModal() {
		document.getElementById("itemModal").style.display = "flex";
	}//end
	function closeitemModal() {
		document.getElementById("itemModal").style.display = "none";
	}//end
	//물품 정보 가져오기
	function selectItem(no, category, name, price) {
		document.getElementById("item_no").value = no;
		document.getElementById("item_category").value = category;
		document.getElementById("item_name").value = name;
		document.getElementById("item_price").value = price;
		closeitemModal(); // 모달 닫기
	}//end
</script>
<div id="itemModal">
	<div class="modal-content">
		<h3>물품 목록</h3>
		<table>
			<tr>
				<td>물품 코드</td>
				<td>물룸 분류</td>
				<td>물품명</td>
				<td>물품 단가</td>
			</tr>
			<c:forEach var="itemlist" items="${itemlist}">
				<tr
					onclick="selectItem('${itemlist.item_no}', '${itemlist.item_category}', '${itemlist.item_name}', '${itemlist.item_price}')">
					<td>${itemlist.item_no}</td>
					<td>${itemlist.item_category}</td>
					<td>${itemlist.item_name}</td>
					<td>${itemlist.item_price}</td>
				</tr>
			</c:forEach>
		</table>
		<button onclick="closeitemModal()">닫기</button>
	</div>
</div>