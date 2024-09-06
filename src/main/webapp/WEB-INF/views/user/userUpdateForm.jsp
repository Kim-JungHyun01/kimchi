<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<form action="userUpdate" method = post id = "userUpdateForm" name = "userUpdateForm">
		<h3>사용자 수정목록</h3>
		<div>
			<label>사용자 id</label> <input id=user_id name="user_id" type="text" value="${user.user_id }" readonly>
		</div>
		<div>
			<label>사용자 pw</label> <input name ="user_pw" id="user_pw" type="password" value="${user.user_pw }" readonly>
		</div>
		<div>
			<label>사용자 email</label> <input name ="user_email" id ="user_email" type="text" value="${user.user_email }">
		</div>
		<div>
			<label>사용자명</label> <input name ="user_name" id ="user_name" type="text" value="${user.user_name }">
		</div>
		<div>
			<label>사용자 전화번호</label> <input name ="user_number" id ="user_number" type="text" value="${user.user_number }">
		</div>
		<div>
			<label>사용자 부서</label> <input name ="user_department" id ="user_department" type="text" value="${user.user_department }" readonly>
		</div>
		<div>
			<button type = "submit">정보 수정</button>
			<button type ="reset">초기화</button>
		</div>
	</form>
</div>
<%@include file="../include/footer.jsp"%>
<script>
	function checkApproval(user_approval) {

	}//end
</script>