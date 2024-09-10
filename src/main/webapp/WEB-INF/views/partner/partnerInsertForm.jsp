<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<style>
.input-group {
	display: flex;
	align-items: center; /* 세로 정렬을 중앙으로 맞춤 */
}

.input-group .form-control {
	flex: 1; /* 입력 필드가 가능한 공간을 모두 차지하도록 설정 */
	margin-right: 10px; /* 입력 필드와 버튼 사이의 간격 */
}
.valid {
	color: grean; /* 유효한 경우 초록색 */
}

.unvalid {
	color: red; /* 유효하지 않은 경우 빨간색 */
}
</style>
<script>
function checkId(){
	var partner_taxid = document.getElementById("partner_taxid").value;
	//공백
	const Check = /([0-9]{3})-?([0-9]{2})-?([0-9]{5})/.test(partner_taxid);
	//특수문자
	const specialCheck = /[!@#$%^&*]/.test(partner_taxid);
	///^\d{10}$/
	if (!partner_taxid) {
        showAlert("사업자번호를 입력해 주세요.", "partner_taxid");
        return;
    }
	
	if(spaceCheck){
		alert("공백이 포함되어 있습니다.")
    	document.getElementById("partner_taxid").focus();
    	return;
	}
	
	 $.ajax({
	        url: 'partner/partnertaxIdCheck', // 요청할 URL
	        type: 'GET', // HTTP 메서드
	        data: { partner_taxid: partner_taxid }, // 서버에 보낼 데이터
	        success: function(result) {
	            if (result === 1) {
	                alert("이미 존재하는 사업자번호입니다.");
	                document.getElementById("partner_taxid").readOnly = false; // 사용 가능할 경우 읽기 전용 해제
	                document.getElementById("btncheckId").disabled = false;//버튼 활성화
	                document.getElementById("partner_taxid").value = "";
	            } else {
	                alert("사럽자번호 확인이 완료되었습니다.");
	                document.getElementById("partner_taxid").readOnly = true; 
	                document.getElementById("btncheckId").disabled = true; //버튼활성화
	            }
	        },
	        error: function() {
	            alert("오류가 발생했습니다.");
	        }
	    });
}//checkId

function checkPw() {
	var partner_pw = document.getElementById("partner_pw").value;
	var partner_pwcheck = document.getElementById("partner_pwcheck").value;

	const lengthCheck = partner_pw.length >= 10; // 길이 체크
    const engCheck = /(?=.*[a-z])/.test(partner_pw); // 소문자 체크
    const numCheck = /(?=.*\d)/.test(partner_pw); // 숫자 체크
    const specialCheck = /[!@#$%^&*]/.test(partner_pw); // 특수문자 체크
    const spaceCheck = !/\s/.test(partner_pw); // 공백 체크
	 
	//길이체크
	document.getElementById("pwWordLenght").className = lengthCheck ? "valid" : "unvalid";
	//소문자
	document.getElementById("pwWordEng").className = engCheck ? "valid" : "unvalid";
	//숫자
	document.getElementById("pwWordNum").className = numCheck ? "valid" : "unvalid";
	//특수문자 제외
	document.getElementById("pwWordSpe").className = specialCheck ? "unvalid" : "valid";
	// 공백 체크
	document.getElementById("pwWordSpace").className = spaceCheck ? "unvalid" : "valid";
	
	//비밀번호 제확인
	if (partner_pw == partner_pwcheck) {
		document.getElementById("pwcheckWord").style.display = "none";
	}
}//checkPw

function checktaxId(InputNumber) {
    var telNumber = InputNumber.value;
    var length = telNumber.length;
    if (length >= 8) {
        // 숫자만 남기고 제거
        let numbers = telNumber.replace(/[^0-9]/g, "");
        
        // 정규식을 사용하여 형식화
        let formattedNumber = numbers.replace(/([0-9]{3})-?([0-9]{2})-?([0-9]{5})/, `$1-$2-$3`);
        
        InputNumber.value = formattedNumber;
    }
} // end checktaxId

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
    const partnerPw = document.getElementById("partner_pw").value;
    const partnerTaxId = document.getElementById("partner_taxid").value;
    const partnerId = document.getElementById("partner_id").value;
    const partnerCompanyName = document.getElementById("partner_companyname").value;
    const partnerNumber = document.getElementById("partner_number").value;
    const partnerOwnerName = document.getElementById("partner_ownername").value;
    const partnerFax = document.getElementById("partner_fax").value;
    const partnerEmail = document.getElementById("partner_email").value;
    const partnerAdd = document.getElementById("partner_add").value;

    const pwRegex = /^(?=.*[a-z])(?=.*\d)[a-z\d]{10,}$/;
    const taxIdRegex = /([0-9]{3})-?([0-9]{2})-?([0-9]{5})/;
    const idRegex = /^[a-zA-Z0-9_]{5,20}$/;
    const companyNameRegex = /^[가-힣a-zA-Z0-9\s]{1,50}$/;
    const numberRegex = /^\d{2,3}-\d{3,4}-\d{4}$/;
    const ownerNameRegex = /^[가-힣a-zA-Z\s]{1,30}$/;
    const faxRegex = /^\d{2,3}-\d{3,4}-\d{4}$/;
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const addRegex = /^[가-힣a-zA-Z0-9\s]{1,100}$/;

    if (!taxIdRegex.test(partnerTaxId)) {
    	showAlert("사업자번호 형식이 올바르지 않습니다.", "partner_taxid");
        return;
    }
    if (!idRegex.test(partnerId)) {
    	showAlert("ID는 5~20자리의 영문자, 숫자, 언더스코어(_)로 구성되어야 합니다.", "partner_id");
        return;
    }
    if (!pwRegex.test(partnerPw)) {
    	showAlert("비밀번호는 10자리 이상, 영문 소문자와 숫자만 포함해야 합니다.", "partner_pw");
        return;
    }
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
    
    if (!confirm('협력회사등록을 하시겠습니까?')) {
        alert("협력회사등록이 취소되었습니다.");
        location.href = "/login/loginForm";
        return;
    }
        document.getElementById("partnerInsertForm").submit();
        alert("협력회사등록이 완료되었습니다. 승인 여부를 확인해주세요.");

}//btnsumbit
</script>
<div class="authincation h-100">
	<div class="container-fluid h-100">
		<div class="row justify-content-center h-100 align-items-center">
			<div class="col-md-6">
				<div class="authincation-content">
					<div class="row no-gutters">
						<div class="col-xl-12">
							<div class="auth-form">
								<h4 class="text-center mb-4">협력회사 등록신청</h4>
								<form action="partnerInsert" method="post" id="partnerInsertForm" name="partnerInsertForm">
									<div class="form-group">
										<label><strong>협력회사 사업자번호</strong></label>
										<div class="input-group">
											<input type="text" class="form-control" name="partner_taxid" id="partner_taxid" placeholder="협력회사" onkeyup="checktaxId(this)">
											<button type="button" id="btncheckid" class="check-button btn btn-secondary" onclick="checkId()">사업자번호 중복확인</button>
										</div>
									</div>
									<div class="form-group">
										<label><strong>협력회사 ID</strong></label>
										<input type="text" name="partner_id" id="partner_id" class="form-control" placeholder="협력회사 ID">
									</div>
									<div class="form-group">
										<label><strong>협력회사 Password</strong></label>
										<input type="password" name="partner_pw" id="partner_pw" class="form-control" placeholder="협력회사 Password">
									</div>
									<div class="form-group">
										<label id="pwWordLenght" class="unvalid">10자리이상,&nbsp;</label>
										<label id="pwWordEng" class="unvalid">영소문자,&nbsp;</label>
										<label id="pwWordNum" class="unvalid">숫자포함&nbsp;&nbsp;|&nbsp;</label>
										<label id="pwWordSpe" class="valid">특수문자,&nbsp;</label>
										<label id="pwWordSpace" class="valid">공백제외</label>
									</div>
									<div class="form-group">
										<label><strong>협력회사 Password 재입력</strong></label>
										<input type="password" name="partner_pwcheck" id="partner_pwcheck"  class="form-control" placeholder="협력회사 Password 재입력" onkeyup="checkPw()">
									</div>
									<div class="form-group">
										<label id="pwcheckWord" style="color: red;"
											style="display: flex;">비밀번호가 일치하지 않습니다.</label>
									</div>
									
									<div class="form-group">
										<label><strong>협력회사명</strong></label>
										<input type="text" name="partner_companyname" id="partner_companyname" class="form-control" placeholder="협력회사명">
									</div>
									<div class="form-group">
										<label><strong>협력회사 전화번호</strong></label>
										<input type="text" name="partner_number" id="partner_number" class="form-control" placeholder="협력회사 전화번호" onkeyup="checkNumber(this)">
									</div>
									<div class="form-group">
										<label><strong>협력회사 대표자명</strong></label>
										<input type="text" name="partner_ownername" id="partner_ownername"  class="form-control" placeholder="협력회사 대표자명">
									</div>
									<div class="form-group">
										<label><strong>협력회사 fax</strong></label>
										<input type="text" name="partner_fax" id="partner_fax" class="form-control" placeholder="협력회사 fax" onkeyup="checkNumber(this)">
									</div>
									<div class="form-group">
										<label><strong>협력회사 email</strong></label>
										<input type="email" name="partner_email" id="partner_email" class="form-control" placeholder="협력회사 email">
									</div>
									<div class="form-group">
										<label><strong>협력회사 사업장주소</strong></label>
										<textarea name="partner_add" id="partner_add" class="form-control" placeholder="협력회사 사업장주소"></textarea>
									</div>
									<div class="text-center mt-4">
										<button type="button" onclick="btnsumbit()" class="btn btn-primary btn-block">등록신청</button>
										<button type="reset" class="btn btn-primary btn-block">초기화</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
