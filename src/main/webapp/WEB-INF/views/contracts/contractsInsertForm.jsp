<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
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

#partnerModal {
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
	//물품 모달창
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

	//협력회사 모달창
	function openpartnerModal() {
		document.getElementById("partnerModal").style.display = "flex";
	}//end
	function closepartnerModal() {
		document.getElementById("partnerModal").style.display = "none";
	}//end
	//협력회사 정보가져오기
	function selectPartner(taxid, companyname, ownername, number, email) {
		document.getElementById("partner_taxid").value = taxid;
		document.getElementById("partner_companyname").value = companyname;
		document.getElementById("partner_ownername").value = ownername;
		document.getElementById("partner_number").value = number;
		document.getElementById("partner_email").value = email;
		closepartnerModal(); // 모달 닫기
	}//end
</script>
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<form action="contractsInsert" method="post" name="contractsInsertForm"
		id="contractsInsertForm">
		<div>
			<h3>계약 등록</h3>
		</div>
		<div>
			<p>계약물품코드</p>
			<input name="item_no" id="item_no" type="number" placeholder="물품선택" onclick="openitemModal()"><br> 
			<input name="item_category" id="item_category" type="text" placeholder="물품선택" onclick="openitemModal()"><br> 
			<input name="item_name" id="item_name" type="text" placeholder="물품선택" onclick="openitemModal()"><br> 
			<input name="item_price" id="item_price" type="number" placeholder="물품선택" onclick="openitemModal()">
		</div>
		<div>
			<p>계약수량</p>
			<input name="contracts_quantity" id="contracts_quantity"
				type="number">
		</div>
		<div>
			<p>계약가격</p>
			<input name="contracts_price" id="contracts_price" type="number">
		</div>
		<div>
			<p>계약납기일</p>
			<input name="contracts_deliveryDate" id="contracts_deliveryDate"
				type="date">
		</div>
		<div>
			<p>계약상세</p>
			<textarea id="contracts_details" rows="8" name="contracts_details"
				placeholder="계약상세내용"></textarea>
		</div>
		<div>
			<p>계약협력회사</p>
			<input name="partner_taxid" id="partner_taxid" type="text">
			<!-- <input name="partner_taxid" id="partner_taxid" type="text"
				placeholder="협력회사선택" onclick="openpartnerModal()"> <input
				name="partner_companyname" id="partner_companyname" type="text"
				placeholder="협력회사선택" onclick="openpartnerModal()"> <input
				name="partner_ownername" id="partner_ownername" type="text"
				placeholder="협력회사선택" onclick="openpartnerModal()"> <input
				name="partner_number" id="partner_number" type="text"
				placeholder="협력회사선택" onclick="openpartnerModal()"> <input
				name="partner_email" id="partner_email" type="text"
				placeholder="협력회사선택" onclick="openpartnerModal()">-->
		</div> 
		<div>
			<p>계약담당자</p>
			<input name="user_id" id="user_id" type="text"> <!-- <input
				name="user_email" id="user_email" type="text"> <input
				name="user_name" id="user_name" type="text"> <input
				name="user_number" id=user_number type="text"> -->
		</div>
		<div>
			<button type="submit">계약등록</button>
			<button type="reset">초기화</button>
		</div>
	</form>
</div>
<%@include file="../include/footer.jsp"%>
<!-- 아이템 모달창 -->
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
	</div>
	<button onclick="closeitemModal()">닫기</button>
</div>
<!-- 협력회사 모달창 -->
<div id="partnerModal">
	<div class="modal-content">
		<h3>협력회사 목록</h3>
		<table>
			<tr>
				<td>혁력회사 사업자번호</td>
				<td>혁력회사 명</td>
				<td>협력회사 대표자명</td>
				<td>협력회사 전화번호</td>
				<td>협력회사 이메일</td>
			</tr>
			<c:forEach var="partnerlist" items="${partnerlist}">
				<tr>
					<td>${partnerlist.partner_taxid }</td>
					<td>${partnerlist.partner_companyname }</td>
					<td>${partnerlist.partner_ownername }</td>
					<td>${partnerlist.partner_number }</td>
					<td>${partnerlist.partner_email }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<button onclick="closepartnerModal()">닫기</button>
</div>
<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>