<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<script>
	//모달 open
	function openuserModal(part) {
		partcheck = part;
		document.getElementById("userModal").style.display = "flex";
	}//end
	
	//모달 close
	function closeuserModal() {
		document.getElementById("userModal").style.display = "none";
	}//end
	
	//특정부서 선택
	var partcheck;
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
	}//end
	
	//사원명으로 검색
	function searchUser() {
    const input = document.getElementById('searchUserInput').value.toLowerCase();
    const rows = document.querySelectorAll('.modal-table tr');

	    rows.forEach((row, index) => {
	        if (index === 0) return; // 첫 번째 행(헤더)은 제외
	        const userName = row.cells[0].textContent.toLowerCase();
	        row.style.display = userName.includes(input) ? '' : 'none';
	    });
	}//end
	
	//user_department으로 특정 부서를 보여주는 것_button
	function filterDepartment(department) {
		const rows = document.querySelectorAll('.user-row');
		rows.forEach(row => {
			if (department === '전체' || row.getAttribute('data-department') === department) {
				row.style.display = ''; // 보이게 함
			} else {
				row.style.display = 'none'; // 숨김
			}
		});
	}//end
	
	//담담자 페이징 로드
	function loadUser(pageNum) {
	    $.ajax({
	        url: '<c:url value="/contracts/contractsInsertForm" />',
	        type: 'GET',
	        data: { pageNum: pageNum },
	        success: function(data) {
	            // 모달 내용 업데이트 // item의 내용을 가져오는 부분 수정
	            const userContent = $(data).find('#userModal .modal-body').html();
			    $('#userModal .modal-body').html(userContent);
	        },
	        error: function() {
	            alert('오류가 발생했습니다.');
	        }
	    });
	}//end
	
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
				<input type="text" id="searchUserInput" placeholder="물품명으로 검색" class="search-input">
   			 	<button onclick="searchUser()" class="search-button">검색</button>
   			 	<button onclick="resetSearch()" class="search-button">초기화</button>
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
			<!-- pagination -->
			<div class="pagination">
				<c:if test="${user_currentPage > 1}">
					<a href="javascript:void(0);" onclick="loadUser(${user_currentPage - 1})">이전</a>
				</c:if>
				
				<c:forEach var="page" begin="1" end="${user_totalPages}">
					<c:choose>
						<c:when test="${page == user_currentPage}">
							<strong>${page}</strong>
						</c:when>
						<c:otherwise>
							<a href="javascript:void(0);" onclick="loadUser(${page})">${page}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:if test="${user_currentPage < user_totalPages}">
					<a href="javascript:void(0);" onclick="loadUser(${user_currentPage + 1})">다음</a>
				</c:if>
			</div>
			<div class="modal-footer">
				<button type="button" class="filter-button" onclick="closeuserModal()">닫기</button>
			</div>
		</div>
	</div>
</div>