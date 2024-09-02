<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
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
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<form method="post" action="itemInsert" name="itemInsertForm"
		id="itemInsertForm">
		<div>
			<p>물룸 분류</p>
			<select name="item_category" id="item_category">
				<option value="반제품" ${item_category == '반제품' ? 'selected' : ''}>반제품</option>
				<option value="완제품" ${item_category =='완제품' ? 'selected' : ''}>완제품</option>
			</select>
		</div>
		<div>
			<p>물품명</p>
			<input name="item_name" id = "item_name" type="text" value="${item_name}"required="required">
		</div>
		<div>
			<p>물품 단가</p>
			<input name="item_price" id = "item_price" type="number" value="${item_price}" required="required">
		</div>
		<div>
			<p>물품 단위</p>
			<select name="item_unit" id="item_unit" required="required">
				<option value="mg" ${item_unit == 'mg' ? 'selected' : ''}>mg</option>
				<option value="g" ${item_unit == 'g' ? 'selected' : ''}>g</option>
				<option value="kg" ${item_unit == 'kg' ? 'selected' : ''}>kg</option>
				<option value="ton" ${item_unit == 'ton' ? 'selected' : ''}>ton</option>
				<option value="cc" ${item_unit == 'cc' ? 'selected' : ''}>cc</option>
				<option value="ml" ${item_unit == 'ml' ? 'selected' : ''}>mL</option>
				<option value="dl" ${item_unit == 'dl' ? 'selected' : ''}>dl</option>
				<option value="L" ${item_unit == 'L' ? 'selected' : ''}>L</option>
			</select>
		</div>
		<div>
			<p>물품 무게</p>
			<input name="item_weight" id = "item_weight" type="number" value="${item_weight}" required="required">
		</div>
		<div>
			<p>물품 규격</p>
			<input name="item_specifications"  id = "item_specifications" type="text"
				value="${item_specifications}" required="required">
		</div>
		<div>
			<p>물품 기본재고</p>
			<input name="item_basicstock" id = "item_basicstock" type="number"
				value="${item_basicstock}" required="required">
		</div>
		<div>
			<p>물품 저장고</p>
			<select name="item_storage" id="item_storage" required="required">
				<option value="냉동창고" ${item_storage == '냉동창고' ? 'selected' : ''}>냉동창고</option>
				<option value="냉장창고" ${item_storage == '냉장창고' ? 'selected' : ''}>냉장창고</option>
				<option value="물류창고" ${item_storage == '물류창고' ? 'selected' : ''}>물류창고</option>
			</select>
		</div>
		<div>
			<p>물품 생산일</p>
			<input name="item_productionDate" id ="item_productionDate" type="date"
				value="${item_productionDate}" required="required">
		</div>
		<div>
			<p>물품 첨부파일</p>
			<input name="attachment_no" id="attachment_no" type="number"
				placeholder="첨부파일선택" onclick="openModal()"> <input
				name="attachment_name" id="attachment_name" type="text"
				placeholder="첨부파일선택" onclick="openModal()">
		</div>
		<div>
			<button type="submit">물품추가</button>
			<button type="reset">초기화</button>
		</div>
	</form>
</div>
<!-- 첨부파일 모달창 -->
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

<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>