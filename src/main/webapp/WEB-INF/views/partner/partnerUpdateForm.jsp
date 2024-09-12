<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<script>
function checkNumber(InputNumber) {
	var telNumber = InputNumber.value;
	var length = telNumber.length;
	if (length >= 8) {
		let numbers = telNumber.replace(/[^0-9]/g, "").replace(
				/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
		InputNumber.value = numbers;
	}
}//end checkNumber

function showAlert(message, InputElement){
	alert(message);
	document.getElementById(InputElement).focus();
    document.getElementById(InputElement).value = "";
}//end

function btnsumbit() {
    const partnerTaxId = document.getElementById("partner_taxid").value;
    const partnerCompanyName = document.getElementById("partner_companyname").value;
    const partnerNumber = document.getElementById("partner_number").value;
    const partnerOwnerName = document.getElementById("partner_ownername").value;
    const partnerFax = document.getElementById("partner_fax").value;
    const partnerEmail = document.getElementById("partner_email").value;
    const partnerAdd = document.getElementById("partner_add").value;

    const taxIdRegex = /([0-9]{3})-?([0-9]{2})-?([0-9]{5})/;
    const companyNameRegex = /^[가-힣a-zA-Z0-9\s]{1,50}$/;
    const numberRegex = /^\d{2,3}-\d{3,4}-\d{4}$/;
    const ownerNameRegex = /^[가-힣a-zA-Z\s]{1,30}$/;
    const faxRegex = /^\d{2,3}-\d{3,4}-\d{4}$/;
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const addRegex = /^[가-힣a-zA-Z0-9\s]{1,100}$/;

    if (!companyNameRegex.test(partnerCompanyName)) {
    	showAlert("협력회사명은 1~50자리의 한글, 영문, 숫자, 공백으로 구성되어야 합니다.", "partner_companyname");
        return;
    }
    if (!numberRegex.test(partnerNumber)) {
    	showAlert("전화번호 형식이 올바르지 않습니다.", "partner_number");
        return;
    }
    if (!ownerNameRegex.test(partnerOwnerName)) {
    	showAlert("대표자명은 1~30자리의 한글, 영문, 공백으로 구성되어야 합니다.", "partner_ownername");
        return;
    }
    if (!faxRegex.test(partnerFax)) {
    	showAlert("FAX 형식이 올바르지 않습니다.", "partner_fax");
        return;
    }
    if (!emailRegex.test(partnerEmail)) {
    	showAlert("이메일 형식이 올바르지 않습니다.", "partner_email");
        return;
    }
    if (!addRegex.test(partnerAdd)) {
    	showAlert("사업장주소는 1~100자리의 한글, 영문, 숫자, 공백으로 구성되어야 합니다.", "partner_add");
        return;
    }
    
    if (!confirm('협력회사수정을 하시겠습니까?')) {
        alert("협력회사수정이 취소되었습니다.");
        location.href = "/partner/partnerSelect?partner_taxid="+${part.partner_taxid };
        return;
    }
        document.getElementById("partnerUpdateForm").submit();
        alert("협력회사수정이 완료되었습니다.);

}//btnsumbit

</script>
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<div>
		<h3>협력회사 수정화면</h3>
		<form action="partnerUpdate" method="post" id="partnerUpdateForm" name="partnerUpdateForm">
			<div>
				<label>협력회사 사업자번호</label> <input name="partner_taxid" id="partner_taxid" type="text" value="${part.partner_taxid }" readonly>
			</div>
			<div>
				<label>협력회사명</label> <input name="partner_companyname" id="partner_companyname" type="text"value="${part.partner_companyname }">
			</div>
			<div>
				<label>협력회사 전화번호</label> <input name="partner_number" id="partner_number" type="text"value="${part.partner_number }" onkeyup="checkNumber(this)">
			</div>
			<div>
				<label>협력회사 대표자명</label> <input name="partner_ownername" id="partner_ownername" type="text"value="${part.partner_ownername }">
			</div>
			<div>
				<label>협력회사 fax</label> <input name="partner_fax" id="partner_fax" type="text"value="${part.partner_fax}" onkeyup="checkNumber(this)">
			</div>
			<div>
				<label>협력회사 email</label> <input name="partner_email" id="partner_email" type="text"value="${part.partner_email }">
			</div>
			<div>
				<label>협력회사 사업장주소</label> <textarea name="partner_add" id="partner_add">${part.partner_add }</textarea>
			</div>
			<div>
				<button type="button" onclick="btnsumbit()">협력회사 수정</button>
				<button type="reset">초기화</button>
			</div>
		</form>
	</div>
</div>
<%@include file="../include/footer.jsp"%>