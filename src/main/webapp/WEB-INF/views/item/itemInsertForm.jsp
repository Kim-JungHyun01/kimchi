<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<script>
	function alertprint(message, element){
		alert( message+"을 입력해주세요.");
		document.getElementById(element).focus();
	}//end

	function btnsumbit() {
		var item_name = document.getElementById("item_name").value;
		if (item_name === "" || item_name == null) {
			alertprint("물품명","item_name");
			return;
		}//end
		
		var item_price = document.getElementById("item_price").value;
		if (item_price === "" || item_price == null) {
			alertprint("물품 단가","item_price");
			return;
		}//end
		
		var item_unit = document.getElementById("item_unit").value;
		if (item_unit === "물품단위선택") {
			alertprint("물품 단위","item_unit");
			return;
		}//end
		
		var item_weight = document.getElementById("item_weight").value;
		if (item_weight === "" || item_weight == null) {
			alertprint("물품 무게","item_weight");
			return;
		}//end
		
		var item_specifications = document.getElementById("item_specifications").value;
		if (item_specifications === "" || item_specifications == null) {
			alertprint("물품 규격","item_specifications");
			return;
		}//end
		
		var item_basicstock = document.getElementById("item_basicstock").value;
		if (item_basicstock === "" || item_basicstock == null) {
			alertprint("물품 기본재고","item_basicstock");
			return;
		}//end
		
		var item_storage = document.getElementById("item_storage").value;
		if (item_unit === "물품저장창고선택") {
			alertprint("물품 저장창고","item_storage");
			return;
		}//end
		
		var item_productionDate = document.getElementById("item_productionDate").value;
		if (item_productionDate === "" || item_productionDate == null) {
			alertprint("물품 제작일","item_productionDate");
			return;
		}//end
		
		if (!confirm('상품을 등록하시겠습니까?')) {
	        alert("상품등록이 취소되었습니다.");
	        location.href = "/item/itemAll";
	    } else {
	        document.getElementById("itemInsertForm").submit();
	        alert("상품등록이 완료되었습니다.");
	    }//end
	}//btnsumbit
</script>
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<form method="post" action="itemInsert" name="itemInsertForm" id="itemInsertForm">
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
				<option value="물품단위선택">물품단위선택</option>
				<option value="kg" ${item_unit == 'kg' ? 'selected' : ''}>kg</option>
				<option value="ton" ${item_unit == 'ton' ? 'selected' : ''}>ton</option>
				<option value="L" ${item_unit == 'L' ? 'selected' : ''}>L</option>
			</select>
		</div>
		<div>
			<p>물품 무게</p>
			<input name="item_weight" id = "item_weight" type="number" value="${item_weight}" required="required">
		</div>
		<div>
			<p>물품 규격</p>
			<input name="item_specifications"  id = "item_specifications" type="text" value="${item_specifications}" required="required">
		</div>
		<div>
			<p>물품 기본재고</p>
			<input name="item_basicstock" id = "item_basicstock" type="number" value="${item_basicstock}" required="required">
		</div>
		<div>
			<p>물품 저장고</p>
			<select name="item_storage" id="item_storage" required="required">
				<option value="물품저장창고선택">물품저장창고선택</option>
				<option value="냉동창고" ${item_storage == '냉동창고' ? 'selected' : ''}>냉동창고</option>
				<option value="냉장창고" ${item_storage == '냉장창고' ? 'selected' : ''}>냉장창고</option>
				<option value="물류창고" ${item_storage == '물류창고' ? 'selected' : ''}>물류창고</option>
			</select>
		</div>
		<div>
			<p>물품 생산일</p>
			<input name="item_productionDate" id ="item_productionDate" type="date" value="${item_productionDate}" required="required">
		</div>
		<div>
			<p>물품 첨부파일</p>
			<input name="attachment_no" id="attachment_no" type="number" placeholder="첨부파일선택" onclick="openModal()">
			<input name="attachment_name" id="attachment_name" type="text" placeholder="첨부파일선택" onclick="openModal()">
		</div>
		<div>
			<button type="button" onclick="btnsumbit()">물품추가</button>
			<button type="reset">초기화</button>
		</div>
	</form>
</div>
<%@include file="../include/footer.jsp"%>
<!-- 첨부파일 모달창 -->
<jsp:include page="../attachment/attachmentModal.jsp" />