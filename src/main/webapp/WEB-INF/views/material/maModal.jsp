<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<style>
/* 모달창 스타일 */
#maModal {
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
	function openmaModal() {
		document.getElementById("maModal").style.display = "flex";
	}//end
	function closecmaModal() {
		document.getElementById("maModal").style.display = "none";
	}//end
	function selectMaterial(id, category, name, origin, unit, weight, stockQuantity, price, specifications) {
	    document.getElementById("ma_id").value = id;
	    document.getElementById("ma_category").value = category; // category를 추가
	    document.getElementById("ma_name").value = name;
	    document.getElementById("ma_origin").value = origin;
	    document.getElementById("ma_unit").value = unit;
	    document.getElementById("ma_weight").value = weight;
	    document.getElementById("ma_stockQuantity").value = stockQuantity;
	    document.getElementById("ma_price").value = price;
	    document.getElementById("ma_specifications").value = specifications;
	    closemaModal(); // 모달 닫기
	}
</script>
<div id="maModal">
	<div class="modal-content">
		<h3>자재 조회</h3>
		<table>
			<tr>
				<th>자재코드</th>
				<th>분류</th>
				<th>자재명</th>
				<th>원산지</th>
				<td>자재단위</td>
				<td>자재무게</td>
				<th>재고수량</th>
				<th>자재단가</th>
				<td>자재규격</td>
			</tr>
			<c:forEach var="malist" items="${malist }">
				<tr onclick="selectMaterial('${malist.ma_id}', '${malist.ma_category}', '${malist.ma_name}', '${malist.ma_origin}', '${malist.ma_unit }', '${malist.ma_weight }', '${malist.ma_stockQuantity}', '${malist.ma_price}', '${malist.ma_specifications }')">
					<td>${malist.ma_id}</td>
					<td>${malist.ma_category}</td>
					<td>${malist.ma_name}</td>
					<td>${malist.ma_origin}</td>
					<td>${malist.ma_unit }</td>
					<td>${malist.ma_weight }</td>
					<td>${malist.ma_stockQuantity}</td>
					<td>${malist.ma_price}</td>
					<td>${malist.ma_specifications }</td>
				</tr>
			</c:forEach>
		</table>
		<button onclick="closecmaModal()">닫기</button>
	</div>
</div>
<div id = >

</div>
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>