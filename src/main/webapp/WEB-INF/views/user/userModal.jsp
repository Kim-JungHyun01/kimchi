<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<style>
/* 모달창 스타일 */
#userModal {
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
	function openuserModal() {
		document.getElementById("userModal").style.display = "flex";
	}//end
	function closeuserModal() {
		document.getElementById("userModal").style.display = "none";
	}//end
	//협력회사 정보가져오기
	function selectUser(id, name, number, email, department) {
		document.getElementById("user_id").value = id;
		document.getElementById("user_name").value = name;
		document.getElementById("user_number").value = number;
		document.getElementById("user_email").value = email;
		document.getElementById("user_department").value = department;
		closeuserModal(); // 모달 닫기
	}//end
</script>
<div id="userModal">
	<div class="modal-content">
		<h3>담당자 목록</h3>
		<table>
			<tr>
				<td>담당자 명</td>
				<td>담당자 전화번호</td>
				<td>담당자 이메일</td>
				<td>담당자 부서</td>
			</tr>
			<c:forEach var="userlist" items="${userlist}">
				<c:if test="${userlist.user_approval eq 1 }">
					<!-- 승인된 사람만 -->
					<tr
						onclick="selectUser('${userlist.user_id}','${userlist.user_name }' ,'${userlist.user_number }','${userlist.user_email }','${userlist.user_department }')">
						<td>${userlist.user_name }</td>
						<td>${userlist.user_number }</td>
						<td>${userlist.user_email }</td>
						<td>${userlist.user_department }</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	<button onclick="closeuserModal()">닫기</button>
	</div>
</div>