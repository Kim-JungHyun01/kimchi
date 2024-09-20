<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<link href="<c:url value="${contextPath}/resources/css/mystyle.css"/>"
	rel='stylesheet' />
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
<div id="attSelectModal" class="modal-long">
	<div class="modal-content">
			<div class="modal-header">
				<h3>첨부파일목록</h3>
			</div>
			<div class="modal-body">
				<table class="modal-table">
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
				<div class="modal-footer">
					<button type="button" class="filter-button"
						onclick="openAttInsertForm()">파일 추가</button>
					<button type="button" class="filter-button" onclick="closeModal()">닫기</button>
				</div>
			</div>
		</div>
</div>
<!-- attInsertModal_첨부파일 추가 모달 -->
<div id="attInsertModal" class="modal-long">
	<div class="modal-content">
		<div class="modal-header">
			<h3>첨부파일추가</h3>
		</div>
		<form action="/fileInsert" method="post" enctype="multipart/form-data">
			<div>
				<input type="file" name="file" required>
			</div>
			<div class="modal-footer">
				<button type="button" class="filter-button" onclick="uploadFile()">첨부파일 추가</button>
				<button type="button" class="filter-button" onclick="closeAttInsertForm()">닫기</button>
			</div>
		</form>
	</div>
</div>