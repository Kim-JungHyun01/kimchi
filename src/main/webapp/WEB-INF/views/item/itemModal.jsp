<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<link href="<c:url value="${contextPath}/resources/css/mystyle.css"/>"
	rel='stylesheet' />
<script>
	function openitemModal() {
		document.getElementById("itemModal").style.display = "flex";
	}//end
	function closeitemModal() {
		document.getElementById("itemModal").style.display = "none";
	}//end
	//물품 정보 가져오기
	function selectItem(no, category, name, price, schedule) {
		document.getElementById("item_no").value = no;
		document.getElementById("item_category").value = category;
		document.getElementById("item_name").value = name;
		document.getElementById("item_price").value = price;
		document.getElementById("bom_schedule").value = schedule;
		closeitemModal(); // 모달 닫기
	}//end
</script>
<div id="itemModal" class="modal-long">
	<div class="modal-content">
		<div class="modal-header">
			<h3>물품 목록</h3>
		</div>
		<div class="modal-body">
			<table class="modal-table">
				<tr>
					<td>물품 코드</td>
					<td>물룸 분류</td>
					<td>물품명</td>
					<td>물품 단가</td>
					<td>제조소요일</td>
				</tr>
				<c:forEach var="itemlist" items="${itemlist}">
					<c:if test="${itemlist.item_bomRegistered eq 1}">
						<tr
							onclick="selectItem('${itemlist.item_no}', '${itemlist.item_category}', '${itemlist.item_name}', '${itemlist.item_price}', '${itemlist.bomVO.bom_schedule}')">
							<td>${itemlist.item_no}</td>
							<td>${itemlist.item_category}</td>
							<td>${itemlist.item_name}</td>
							<td>${itemlist.item_price}</td>
							<td>${itemlist.bomVO.bom_schedule}일</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<div class="modal-footer">
				<button type="button" class="filter-button"
					onclick="closeitemModal()">닫기</button>
			</div>
		</div>
	</div>
</div>
