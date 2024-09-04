<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<style>
/* 모달창 스타일 */
#attSelectModal {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	justify-content: center;
	align-items: center;
}

#attInsertModal {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	justify-content: center;
	align-items: center;
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
	function openModal() {
		document.getElementById("attSelectModal").style.display = "flex";
	}//end

	function closeModal() {
		document.getElementById("attSelectModal").style.display = "none";
	}//end

	// 	첨부파일 코드와 첨부파일 명 가져오기
	function selectAttachmentCode(no, name) {
		document.getElementById("attachment_no").value = no;
		document.getElementById("attachment_name").value = name;
		closeModal(); // 모달 닫기
	}//end
	function openAttInsertForm() {
		document.getElementById("attSelectModal").style.display = "none";
		document.getElementById("attInsertModal").style.display = "flex";
	}//end

	function closeAttInsertForm() {
		document.getElementById("attInsertModal").style.display = "none";
	}//end
	//첨부파일 메세지
	window.onload = function() {
		const urlParams = new URLSearchParams(window.location.search);
		const message = urlParams.get('message');
		if (message) {
			alert(message);
		}
	};
	//첨부파일 insert한 후에 itemInsertForm 유지되게 하는 것
</script>
<!-- attSelectModal_첨부파일 선택모달 -->
<div id="attSelectModal">
	<div class="modal-content">
		<h3>물품 목록</h3>
		<table>
			<tr>
				<td>첨부파일 코드</td>
				<td>첨부파일 명</td>
			</tr>
			<c:forEach var="attlist" items="${attlist}">
				<tr
					onclick="selectAttachmentCode('${attlist.attachment_no}', '${attlist.attachment_name}')">
					<td>${attlist.attachment_no}</td>
					<td>${attlist.attachment_name}</td>
				</tr>
			</c:forEach>
		</table>
		<button type="button" onclick="openAttInsertForm()">파일 추가</button>
		<button type="button" onclick="closeModal()">닫기</button>
	</div>
</div>
<!-- attInsertModal_첨부파일 추가 모달 -->
<div id="attInsertModal">
	<div class="modal-content">
		<form action="/fileInsert" method="post" enctype="multipart/form-data">
			<div>
				<h3>첨부파일추가</h3>
			</div>
			<div>
				<input type="file" name="file" required>
			</div>
			<div>
				<button type="button" onclick="uploadFile()">첨부파일 추가</button>
				<button type="button" onclick="closeAttInsertForm()">닫기</button>
			</div>
		</form>
	</div>
</div>