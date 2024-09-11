<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<script>
	function alertprint(message, element) {
		alert(message + "을 입력해주세요.");
		document.getElementById(element).focus();
	}//end
	
	function btnattreset(){
		
		 document.getElementById("attachment_no").value ="";
		 document.getElementById("attachment_name").value ="";
		 alert("첨부파일 초기화");
		 
	}//end
	
	function btnsumbit() {
	    // 입력 필드의 값을 함수 내에서 다시 읽어옵니다.
	    var item_name = document.getElementById("item_name").value;
	    var item_price = document.getElementById("item_price").value;
	    var item_unit = document.getElementById("item_unit").value;
	    var item_weight = document.getElementById("item_weight").value;
	    var item_specifications = document.getElementById("item_specifications").value;
	    var item_basicstock = document.getElementById("item_basicstock").value;
	    var item_storage = document.getElementById("item_storage").value;

	    if (item_name === "") {
	        alertprint("물품명", "item_name");
	        return;
	    }

	    if (item_price === "") {
	        alertprint("물품 단가", "item_price");
	        return;
	    }

	    if (item_unit === "물품단위선택") {
	        alertprint("물품 단위", "item_unit");
	        return;
	    }

	    if (item_weight === "") {
	        alertprint("물품 무게", "item_weight");
	        return;
	    }

	    if (item_specifications === "") {
	        alertprint("물품 규격", "item_specifications");
	        return;
	    }

	    if (item_basicstock === "") {
	        alertprint("물품 기본재고", "item_basicstock");
	        return;
	    }

	    if (item_storage === "물품저장창고선택") {
	        alertprint("물품 저장창고", "item_storage");
	        return;
	    }

	    if (!confirm('상품을 수정하시겠습니까?')) {
	        alert("상품수정을 취소하였습니다.");
	        location.href = "/item/itemSelect?item_no=" + ${item.item_no };
	        return;
	    }

	    document.getElementById("itemUpdateForm").submit();
	    alert("상품정보수정이 완료되었습니다.");
	}
</script>
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<form method="post" action="itemUpdate" name="itemUpdateForm" id="itemUpdateForm">
			<div>
				<label>물품 코드</label>
				<input name="item_no" id = "item_no" type="number" value="${item.item_no }" readonly>
			</div>
			<div>
				<label>물룸 분류</label>
				<select name="item_category" id="item_category" title="물품 분류">
						<option value="반제품" ${item.item_category == '반제품' ? 'selected' : ''}>반제품</option>
						<option value="완제품" ${item.item_category == '완제품' ? 'selected' : ''}>완제품</option>
				</select>
			</div>
			<div>
				<label>물품명</label>
				<input name="item_name" id = "item_name" type="text" value="${item.item_name}">
			</div>
			<div>
				<label>물품 단가</label>
				<input name="item_price" id = "item_price" type="number" value="${item.item_price}">
			</div>
			<div>
				<label>물품 단위</label>
				<select name="item_unit" id="item_unit" title="물품 단위">
						<option value="물품단위선택">물품단위선택</option>
						<option value="kg" ${item.item_unit == 'kg' ? 'selected' : ''}>kg</option>
						<option value="ton" ${item.item_unit == 'ton' ? 'selected' : ''}>ton</option>
						<option value="L" ${item.item_unit == 'L' ? 'selected' : ''}>L</option>
				</select>
			</div>
			<div>
				<label>물품 무게</label>
				<input name="item_weight" id="item_weight" type="number" value="${item.item_weight}">
			</div>
			<div>
				<label>물품 규격</label>
				<select name="item_specifications" id="item_specifications" required>
                	 <option value="규격 선택" disabled selected>포장 선택</option>
                     <option value="박스" ${item.item_specifications=='박스' ? 'selected' : ''}>박스</option>
                     <option value="포대" ${item.item_specifications=='포대' ? 'selected' : ''}>포대</option>
                     <option value="비닐 봉투" ${item.item_specifications=='비닐 봉투' ? 'selected' : ''}>비닐 봉투</option>
                     <option value="알류미늄 포장" ${item.item_specifications=='알류미늄 포장' ? 'selected' : ''}>알류미늄 포장</option>
                     <option value="진공 포장지" ${item.item_specifications=='진공 포장지' ? 'selected' : ''}>진공 포장지</option>
                     <option value="플라스틱 용기" ${item.item_specifications=='플라스틱 용기' ? 'selected' : ''}>플라스틱 용기</option>
                     <option value="유리병" ${item.item_specifications=='유리병' ? 'selected' : ''}>유리병</option> </select>
			</div>
			<div>
				<label>물품 기본재고</label>
				<input name="item_basicstock" id="item_basicstock" type="number" value="${item.item_basicstock}">
			</div>
			<div>
				<label>물품 저장고</label>
				<select name="item_storage" id="item_storage" title="물품 저장고">
					<option value="물품저장창고선택">물품저장창고선택</option>
					<option value="냉동창고" ${item.item_storage == '냉동창고' ? 'selected' : ''}>냉동창고</option>
					<option value="냉장창고" ${item.item_storage == '냉장창고' ? 'selected' : ''}>냉장창고</option>
					<option value="물류창고" ${item.item_storage == '물류창고' ? 'selected' : ''}>물류창고</option>
				</select>
			</div>
			<div>
				<label>물품 생산일</label>
				<input name="item_productionDate"id="item_productionDate"  type="date" value="${item.item_productionDate}" readonly>
			</div>
			<div>			
				<label>물품 첨부파일</label>
				<input name="attachment_no" id="attachment_no" type="hidden" value="${item.attachment_no}" onclick="openModal()">
				<input name="attachment_name" id="attachment_name" type="text" value = "${att.attachment_name }" onclick="openModal()">
				<button type = "button" onclick="btnattreset()">첨부파일초기화</button>
			</div>
		<div>
			<button type="button" onclick="btnsumbit()">물품수정</button>
			<button onclick="reset">초기화</button>
		</div>
	</form>
</div>
<%@include file="../include/footer.jsp"%>
<!-- 첨부파일 모달창 -->
<jsp:include page="../attachment/attachmentModal.jsp" />