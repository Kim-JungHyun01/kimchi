<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>
<div class="content-body">
	<form action="userUpdate" method = post id = "userUpdateForm" name = "userUpdateForm">
		<h3>사용자 수정목록</h3>
		<div>
			<label>사용자 id</label> <input type="text" id=user_id name="user_id"
				value="${user.user_id }" readonly>
		</div>
		<div>
			<label>사용자 pw</label> <input value="${user.user_pw }" readonly>
		</div>
		<div>
			<label>사용자 email</label> <input value="${user.user_email }">
		</div>
		<div>
			<label>사용자명</label> <input value="${user.user_name }">
		</div>
		<div>
			<label>사용자 전화번호</label> <input value="${user.user_number }">
		</div>
		<div>
			<label>사용자 부서</label> <input value="${user.user_department }"
				readonly>
		</div>
		<div>
			<button type = "submit">정보 수정</button>
		</div>
	</form>
</div>
<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script>
	function checkApproval(user_approval) {

	}//end
</script>
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
