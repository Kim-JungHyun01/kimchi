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
		var user_id = document.getElementById("user_id").value;
		//공백
		const spaceCheck = /\s/.test(user_id);
		//특수문자
		const specialCheck = /[!@#$%^&*]/.test(user_id);
		
		if (!user_id) {
	        showAlert("사용자 ID를 입력해 주세요.", "user_id");
	        return;
	    }
		
		if(specialCheck){
	    	alert("특수문자가 포함되어 있습니다.")
	    	document.getElementById("user_id").focus();
	    	return;
	    }
		
		if(spaceCheck){
			alert("공백이 포함되어 있습니다.")
	    	document.getElementById("user_id").focus();
	    	return;
		}
		
		 $.ajax({
		        url: 'user/userIdCheck', // 요청할 URL
		        type: 'GET', // HTTP 메서드
		        data: { user_id: user_id }, // 서버에 보낼 데이터
		        success: function(result) {
		            if (result === 1) {
		                alert("이미 존재하는 사용자 ID입니다.");
		                document.getElementById("user_id").readOnly = false; // 사용 가능할 경우 읽기 전용 해제
		                document.getElementById("btncheckId").disabled = false;//버튼 활성화
		                document.getElementById("user_id").value = "";
		            } else {
		                alert("사용할 수 있는 사용자 ID입니다.");
		                document.getElementById("user_id").readOnly = true; 
		                document.getElementById("btncheckId").disabled = true; //버튼활성화
		            }
		        },
		        error: function() {
		            alert("오류가 발생했습니다.");
		        }
		    });
	}//checkId

	function checkPw() {
		var user_pw = document.getElementById("user_pw").value;
		var user_pwcheck = document.getElementById("user_pwcheck").value;

		const lengthCheck = user_pw.length >= 10; // 길이 체크
	    const engCheck = /(?=.*[a-z])/.test(user_pw); // 소문자 체크
	    const numCheck = /(?=.*\d)/.test(user_pw); // 숫자 체크
	    const specialCheck = /[!@#$%^&*]/.test(user_pw); // 특수문자 체크
	    const spaceCheck = !/\s/.test(user_pw); // 공백 체크
		 
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
		if (user_pw == user_pwcheck) {
			document.getElementById("pwcheckWord").style.display = "none";
		}
	}//checkPw

	function checkNumber(InputNumber) {
		var telNumber = InputNumber.value;
		var length = telNumber.length;
		if (length >= 8) {
			let numbers = telNumber.replace(/[^0-9]/g, "").replace(
					/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
			InputNumber.value = numbers;
		}
	}//end checkNumber
	
	//중복하는 함수 줄이기
	function showAlert(message, InputElement){
		alert(message);
		document.getElementById(InputElement).focus();
        document.getElementById(InputElement).value = "";
	}//end

	//회원가입시 최종확인
	function submitCheck() {
	    var btncheckId = document.getElementById("btncheckId").disabled;
	    var user_pw = document.getElementById("user_pw").value;
	    var pwPattern = /^(?=.*[a-z])(?=.*\d)[a-z0-9]{10,}$/;   // 정규 표현식 수정
	    var user_pwcheck = document.getElementById("user_pwcheck").value;
	    var user_email = document.getElementById("user_email").value;
	    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	    var user_name = document.getElementById("user_name").value;
	    var namePattern = /^[가-힣A-Za-z]+$/;
	    var user_number = document.getElementById("user_number").value;
	    var numberPattern1 = /^\d{3}-\d{3,4}-\d{4}$/; // 정규 표현식 수정
	    var numberPattern2 = /^\d{2,3}-\d{3,4}-\d{4}$/; // 정규 표현식 수정
	    var user_department = document.getElementById("user_department").value;
	    

	    if (btncheckId) {
	        showAlert("ID 중복검사를 실시해주세요.", "user_id");
	        return;
	    }

	    if (!pwPattern.test(user_pw)) {
	        showAlert("10자 이상, 영소문자, 숫자만 사용해주세요.", "user_pw");
	        document.getElementById("user_pwcheck").value = "";
	        return;
	    }

	    if (user_pw !== user_pwcheck) {
	        showAlert("비밀번호가 다릅니다. 재입력해주세요.", "user_pwcheck");
	        return;
	    }

	    if (!emailPattern.test(user_email)) {
	        showAlert("올바르지 않은 이메일 형식입니다.", "user_email");
	        return;
	    }

	    if (!namePattern.test(user_name)) {
	        showAlert("올바르지 않는 이름 형식입니다.", "user_name");
	        return;
	    }

	    if (!numberPattern1.test(user_number) || !numberPattern2.test(user_number)) {
	        showAlert("올바르지 않는 휴대전화 형식입니다.", "user_number");
	        return;
	    }

	    if (user_department === '부서선택') {
	        showAlert("부서를 선택해주세요.", "user_department");
	        return;
	    }

	    if (!confirm('회원가입 하시겠습니까?')) {
	        alert("회원가입이 취소되었습니다.");
	        location.href = "/login/loginForm";
	    } else {
	        document.getElementById("userInsertForm").submit();
	        alert("회원가입이 완료되었습니다. 승인 여부를 확인해주세요.");
	    }
	}//end
	
</script>
<div class="authincation h-100">
	<div class="container-fluid h-100">
		<div class="row justify-content-center h-100 align-items-center">
			<div class="col-md-6">
				<div class="authincation-content">
					<div class="row no-gutters">
						<div class="col-xl-12">
							<div class="auth-form">
								<h4 class="text-center mb-4">사용자 회원가입</h4>
								<form action="userInsert" method=post id="userInsertForm"
									name="userInsertForm">
									<div class="form-group">
										<label><strong>사용자 ID</strong></label>
										<div class="input-group">
											<input type="text" class="form-control text-1" id="user_id"
												name="user_id" placeholder="사용자 ID">
											<button id ="btncheckId" type="button" class="check-button btn btn-secondary"
												onclick="checkId()">ID중복확인</button>
										</div>
									</div>
									<div class="form-group">
										<label><strong>사용자 Password</strong></label> <input
											type="password" class="form-control" name="user_pw"
											id="user_pw" placeholder="사용자 Password">
									</div>
									<div class="form-group">
										<label id="pwWordLenght" class="unvalid">10자리이상,&nbsp;</label>
										<label id="pwWordEng" class="unvalid">영소문자,&nbsp;</label>
										<label id="pwWordNum" class="unvalid">숫자포함&nbsp;&nbsp;|&nbsp;</label>
										<label id="pwWordSpe" class="valid">특수문자,&nbsp;</label>
										<label id="pwWordSpace" class="valid">공백제외</label>
									</div>
									<div class="form-group">
										<label><strong>사용자 Password 확인</strong></label> <input
											type="password" class="form-control" name="user_pwcheck"
											id="user_pwcheck" placeholder="사용자 Password 재입력"
											onkeyup="checkPw()">
									</div>
									<div class="form-group">
										<label id="pwcheckWord" style="color: red;"
											style="display: flex;">비밀번호가 일치하지 않습니다.</label>
									</div>
									<div class="form-group">
										<label><strong>사용자 email</strong></label> <input type="email"
											class="form-control" name="user_email" id="user_email"
											placeholder="사용자 email">
									</div>
									<div class="form-group">
										<label><strong>사용자 이름</strong></label> <input type="text"
											class="form-control" name="user_name" id="user_name"
											placeholder="사용자 이름">
									</div>
									<div class="form-group">
										<label><strong>사용자 전화번호</strong></label> <input type="text"
											name="user_number" id="user_number" class="form-control"
											placeholder="사용자 전화번호" onkeyup="checkNumber(this)"
											maxlength="13">
									</div>
									<div class="form-group">
										<label><strong>사용자 부서</strong></label> <select
											name="user_department" id="user_department" required>
											<option value="부서선택">부서선택</option>
											<option value="자재부서">자재부서</option>
											<option value="개발부서">개발부서</option>
											<option value="발주부서">발주부서</option>
											<option value="생산부서">생산부서</option>
										</select>
									</div>
									<div class="text-center mt-4">
										<button type="button" onclick="sumbitCheck();"
											class="btn btn-primary btn-block">회원가입</button>
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