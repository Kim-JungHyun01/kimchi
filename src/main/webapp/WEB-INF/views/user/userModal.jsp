<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

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