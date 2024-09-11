<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<<style>
/*모달스타일 */
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

.modal-content h5{
display: inline-block; font-size: 1.5em; vertical-align: middle;
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
	var partcheck;
	function openuserModal(part) {
		partcheck = part;
		document.getElementById("userModal").style.display = "flex";
	}

	function closeuserModal() {
		document.getElementById("userModal").style.display = "none";
	}

	function selectUser(id, name, number, email, department) {
		if (department != partcheck) {
			alert(partcheck + "가 아닙니다. 다시 선택해주세요.");
			return;
		}
		document.getElementById("user_id").value = id;
		document.getElementById("user_name").value = name;
		document.getElementById("user_number").value = number;
		document.getElementById("user_email").value = email;
		document.getElementById("user_department").value = department;
		closeuserModal();
	}
	
	function filterDepartment(department) {
		const rows = document.querySelectorAll('.user-row');
		rows.forEach(row => {
			if (department === '전체' || row.getAttribute('data-department') === department) {
				row.style.display = ''; // 보이게 함
			} else {
				row.style.display = 'none'; // 숨김
			}
		});
	}
	
</script>
<div id="userModal" class="modal-long">
	<div class="modal-content">
		<div class="modal-header">
			<h3>담당자 목록</h3>
			<button onclick="filterDepartment('전체')" class="filter-button">전체</button>
			<button onclick="filterDepartment('개발부서')" class="filter-button">개발부서</button>
			<button onclick="filterDepartment('생산부서')" class="filter-button">생산부서</button>
			<button onclick="filterDepartment('구매부서')" class="filter-button">구매부서</button>
			<button onclick="filterDepartment('자재부서')" class="filter-button">자재부서</button>
		</div>
		<div class="modal-body">
			<table class="modal-table">
				<tr>
					<th>담당자 명</th>
					<th>담당자 전화번호</th>
					<th>담당자 이메일</th>
					<th>담당자 부서</th>
				</tr>
				<c:forEach var="userlist" items="${userlist}">
					<c:if
						test="${userlist.user_approval == 1 and userlist.user_department ne '관리자'}">
						<tr class="user-row" data-department="${userlist.user_department}"
							onclick="selectUser('${userlist.user_id}', '${userlist.user_name}', '${userlist.user_number}', '${userlist.user_email}', '${userlist.user_department}')">
							<td>${userlist.user_name}</td>
							<td>${userlist.user_number}</td>
							<td>${userlist.user_email}</td>
							<td>${userlist.user_department}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<div class="modal-footer">
				<button type="button" class="filter-button" onclick="closeuserModal()">닫기</button>
			</div>
		</div>
	</div>
</div>