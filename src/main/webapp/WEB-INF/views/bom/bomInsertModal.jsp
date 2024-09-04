<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<style>
/* 모달창 스타일 */
#bomInsertModal {
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
	width: 70%; /* 모달 너비를 50%로 설정 */
	max-height: 100%; /* 최대 높이 조정 */
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
	function openbomInsertModal() {
		document.getElementById("bomInsertModal").style.display = "flex";
	}//end
	function closebomInsertModal() {
		document.getElementById("bomInsertModal").style.display = "none";
	}//end
	
	function addRow(){
		//테이블 찾기
		const table = document.getElementById('bomInsertTable');
		//테이블 행추가
		const newRow = table.insertRow();
		//테이블 cell추가
		
		for(let i=0; i<8; i++){
			const newSell = newRow.insertCell(i);
			const input = document.createElement();
		}
		
	}//end
	
	
</script>
<div id=bomInsertModal>
	<div class="modal-content">
		<div>
			<h3>bom 추가화면</h3>
			<form action="bomInsert" method="post" id="bomInsertFrom"
				name="bomInsertFrom">
				<div>
					<label>물품코드</label> <input id="item_no" name="item_no"
						type="number" value="${item.item_no}" readonly>
				</div>
				<div>
					<h4>bom 상세 스케줄</h4>
					<label>제작 소요일자</label><input id="bom_schedule" name="bom_schedule"type="number">
					<p>제작 상세내용</p>
					<textarea rows="8" cols="10" id="bom_other" name="bom_other" placeholder="제작상세내용 입력"></textarea>
				</div>
			</form>
			<hr>
			<div>
				<h3>bom 자재 추가화면</h3>
				<form action="bom_maInsert" method="post" id = "bom_maInsertForm" name = "bom_maInsertForm">
					<table id = "bomInsertTable">
						<tr>
							<th>자재코드</th>
							<th>분류</th>
							<th>자재명</th>
							<th>원산지</th>
							<td>자재단위</td>
							<td>자재무게</td>
							<td>자재규격</td>
							<td>소요자재량</td>
							<td>소요공정</td>
						</tr>
						<tr>
							<td><input name="ma_id" id="ma_id" onclick="openmaModal()"
								placeholder="자재선택"></td>
							<td><input name="ma_category" id="ma_category"
								onclick="openmaModal()" placeholder="자재선택"></td>
							<td><input name="ma_name" id="ma_name"
								onclick="openmaModal()" placeholder="자재선택"></td>
							<td><input name="ma_origin" id="ma_origin"
								onclick="openmaModal()" placeholder="자재선택"></td>
							<td><input name="ma_unit" id="ma_unit"
								onclick="openmaModal()" placeholder="자재선택"></td>
							<td><input name="ma_weight" id="ma_weight"
								onclick="openmaModal()" placeholder="자재선택"></td>
							<td><input name="ma_specifications" id="ma_specifications"
								onclick="openmaModal()" placeholder="자재선택"></td>
							<td><input id="bom_ma_amount" name="bom_ma_amount"
								type="number"></td>
							<td><select id="bom_ma_process" name="bom_ma_process"
								required>
									<option value="0">제조공정선택</option>
									<option value="1">조제</option>
									<option value="2">절임</option>
									<option value="3">소제작</option>
									<option value="4">포장</option>
									<option value="5">숙성</option>
									<option value="6">기타</option>
							</select></td>
						</tr>
					</table>
					<input type="button" onclick="addRow()" value = "자재리스트추가">
				</form>
			</div>
		</div>
		<button onclick="closebomInsertModal()">닫기</button>
	</div>
</div>