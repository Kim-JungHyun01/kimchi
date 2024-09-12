<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<link href="<c:url value="${contextPath}/resources/css/mystyle.css"/>" rel='stylesheet' />
<style>
.content-body {
	border-radius: 8px;
	padding: 20px;
	margin: auto;
}

.content-body h2 {
	margin: 0 20%;
}

.input-container{
	margin: 0 20%; /* 왼쪽 간격 */
}
.input-field {
    width: 50%; /* 입력 필드의 너비를 100%로 설정 */
    padding: 10px; /* 패딩 추가 */
    border: 1px solid #ccc; /* 테두리 스타일 */
    border-radius: 4px; /* 모서리 둥글게 */
    box-sizing: border-box; /* 패딩과 테두리를 포함한 너비 계산 */
}


select.input-field {
    appearance: none; /* 기본 선택 상자 스타일 제거 */
    background: white; /* 배경색 설정 */
    /* 추가 스타일 필요 시 여기에 작성 */
    margin-left: 40px;
    text-align: center;
}
</style>
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<h2>제품등록</h2>
	<hr>
	<div class="input-container">
	<form method="post" action="itemInsert" name="itemInsertForm" id="itemInsertForm">
		<div class="item-group">
			<label>물품 분류</label>
			<select name="item_category" id="item_category" class="input-field">
				<option value="물품분류선택">물품분류선택</option>
				<option value="반제품" ${item_category == '반제품' ? 'selected' : ''}>반제품</option>
				<option value="완제품" ${item_category =='완제품' ? 'selected' : ''}>완제품</option>
			</select>
		</div>
		<div class="item-group">
			<label>물품명</label>
			<input name="item_name" id = "item_name" type="text" value="${item_name}"required="required">
		</div>
		<div class="item-group">
			<label>물품 단가</label>
			<input name="item_price" id = "item_price" type="number" value="${item_price}" required="required">
		</div>
		<div class="item-group">
			<label>물품 단위</label>
			<select name="item_unit" id="item_unit" required="required" class="input-field">
				<option value="물품단위선택">물품단위선택</option>
				<option value="kg" ${item_unit == 'kg' ? 'selected' : ''}>kg</option>
				<option value="ton" ${item_unit == 'ton' ? 'selected' : ''}>ton</option>
				<option value="L" ${item_unit == 'L' ? 'selected' : ''}>L</option>
			</select>
		</div>
		<div class="item-group">
			<label>물품 무게</label>
			<input name="item_weight" id = "item_weight" type="number" value="${item_weight}" required="required">
		</div>
		<div class="item-group">
			<label>물품 규격</label>
			<select name="item_specifications" id="item_specifications" required class="input-field">
                	 <option value="규격선택" disabled selected>규격선택</option>
                     <option value="박스" ${item.item_specifications=='박스' ? 'selected' : ''}>박스</option>
                     <option value="포대" ${item.item_specifications=='포대' ? 'selected' : ''}>포대</option>
                     <option value="비닐 봉투" ${item.item_specifications=='비닐 봉투' ? 'selected' : ''}>비닐 봉투</option>
                     <option value="알류미늄 포장" ${item.item_specifications=='알류미늄 포장' ? 'selected' : ''}>알류미늄 포장</option>
                     <option value="진공 포장지" ${item.item_specifications=='진공 포장지' ? 'selected' : ''}>진공 포장지</option>
                     <option value="플라스틱 용기" ${item.item_specifications=='플라스틱 용기' ? 'selected' : ''}>플라스틱 용기</option>
                     <option value="유리병" ${item.item_specifications=='유리병' ? 'selected' : ''}>유리병</option> </select>
		</div>
		<div class="item-group">
			<label>물품 기본재고</label>
			<input name="item_basicstock" id = "item_basicstock" type="number" value="${item_basicstock}" required="required">
		</div>
		<div class="item-group">
			<label>물품 저장고</label>
			<select name="item_storage" id="item_storage" required="required" class="input-field">
				<option value="물품저장창고선택">물품저장창고선택</option>
				<option value="냉동창고" ${item_storage == '냉동창고' ? 'selected' : ''}>냉동창고</option>
				<option value="냉장창고" ${item_storage == '냉장창고' ? 'selected' : ''}>냉장창고</option>
				<option value="물류창고" ${item_storage == '물류창고' ? 'selected' : ''}>물류창고</option>
			</select>
		</div>
		<div class="item-group">
			<label>물품 생산일</label>
			<input name="item_productionDate" id ="item_productionDate" type="date" value="${item_productionDate}" required="required">
		</div>
		<div class="item-group">
			<label>물품 첨부파일</label>
			<input name="attachment_no" id="attachment_no" type="hidden" placeholder="첨부파일선택" onclick="openModal()">
			<input name="attachment_name" id="attachment_name" type="text" placeholder="첨부파일선택" onclick="openModal()">
			<button class="addbutton" type = "button" onclick="btnattreset()">첨부파일초기화</button>
		</div>
		<div style="text-align: right;">
			<button class="addbutton" type="button" onclick="btnsumbit()">물품추가</button>
			<button class="addbutton" type="reset">초기화</button>
		</div>
	</form>
	</div>
</div>
<%@include file="../include/footer.jsp"%>
<!-- 첨부파일 모달창 -->
<jsp:include page="../attachment/attachmentModal.jsp" />
<script>
	function alertprint(message, element){
		alert( message+"을 입력해주세요.");
		document.getElementById(element).focus();
	}//end
	
	/*첨부파일 초기화  */
	function btnattreset(){
		 document.getElementById("attachment_no").value ="";
		 document.getElementById("attachment_name").value ="";
		 alert("첨부파일 초기화");
	}//end
	
	
	function btnsumbit() {
		var item_category = document.getElementById("item_category").value;
		if (item_category === "물품분류선택") {
			alertprint("물품분류","item_category");
			return;
		}//end
		
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
		if (item_specifications === "규격선택" || item_specifications == null) {
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