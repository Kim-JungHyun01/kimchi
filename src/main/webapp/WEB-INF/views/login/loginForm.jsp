<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<form method="post" id="loginForm" name="loginForm">
		<input type="checkbox" value="사용자" id="user" name="user" checked
			onclick="checkLoginForm('user')"> <label for="user">사용자</label>
		<input type="checkbox" value="협력회사" id="partner" name="partner"
			onclick="checkLoginForm('partner')"> <label for="partner">협력회사</label>

		<div id="userLoginForm">
			<input id="user_id" name="user_id" type="text" placeholder="사용자 ID"><br>
			<input id="user_pw" name="user_pw" type="password"
				placeholder="사용자 비밀번호">
			<div>
				<button type="button" onclick="checkSubmit('user')">사용자 로그인</button>
			</div>
		</div>

		<div id="partnerLoginForm" style="display: none;">
			<input id="partner_id" name="partner_id" type="text"
				placeholder="협력회사 ID"><br> <input id="partner_pw"
				name="partner_pw" type="password" placeholder="협력회사 비밀번호">
			<div>
				<button type="button" onclick="checkSubmit('partner')">협력회사
					로그인</button>
			</div>
		</div>
	</form>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script>
	function checkLoginForm(selected) {
		const userLoginForm = document.getElementById('userLoginForm');
		const partnerLoginForm = document.getElementById('partnerLoginForm');

		if (selected === 'user') {
			userLoginForm.style.display = 'block';
			partnerLoginForm.style.display = 'none';
			document.getElementById('partner').checked = false; // 협력회사 체크 해제
		} else {
			userLoginForm.style.display = 'none';
			partnerLoginForm.style.display = 'block';
			document.getElementById('user').checked = false; // 사용자 체크 해제
		}
	}//end

	function checkSubmit(selected) {
		const form = document.getElementById('loginForm');
		if (selected === 'user') {
			const userId = document.getElementById('user_id').value;
			const userPw = document.getElementById('user_pw').value;

			// Validate user input (optional)
			if (!userId || !userPw) {
				alert('사용자 ID와 비밀번호를 입력하세요.');
				return;
			}

			// Set form action for user login
			form.action = 'userLogin'; // Change this to your user login endpoint
			form.method = 'post';
			form.submit();
		} else {
			const partnerId = document.getElementById('partner_id').value;
			const partnerPw = document.getElementById('partner_pw').value;

			// Validate partner input (optional)
			if (!partnerId || !partnerPw) {
				alert('협력회사 ID와 비밀번호를 입력하세요.');
				return;
			}

			// Set form action for partner login
			form.action = 'partnerLogin'; // Change this to your partner login endpoint
			form.method = 'post';
			form.submit();
		}
	}//end
</script>
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
