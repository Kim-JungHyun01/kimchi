<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="content-body">
	<div>
		<h3>사용자 회원가입</h3>
		<form action="userInsert" method=post id="userInsertForm"
			name="userInsertForm">
			<div>
				<label>사용자 id</label> <input id=user_id name="user_id" type="text">
				<button>중복확인</button>
			</div>
			<div>
				<label>사용자 pw</label> <input name="user_pw" id="user_pw"
					type="password"> <label>사용자 pw 재입력</label> <input
					name="user_pwcheck" id="user_pwcheck" type="password">
				<button>비밀번호 확인</button>
			</div>
			<div>
				<label>사용자 email</label> <input name="user_email" id="user_email"
					type="text">
			</div>
			<div>
				<label>사용자명</label> <input name="user_name" id="user_name"
					type="text">
			</div>
			<div>
				<label>사용자 전화번호</label> <input name="user_number" id="user_number"
					type="text">
			</div>
			<div>
				<label>사용자 부서</label> <input name="user_department"
					id="user_department" type="text"> <select
					name="user_department" id="user_department" required>
					<option>부서 선택</option>
					<option value="자재부서">자재부서</option>
					<option value="개발부서">개발부서</option>
					<option value="발주부서">발주부서</option>
					<option value="생산부서">생산부서</option>
				</select>
			</div>
			<div>
				<button type="submit">회원가입</button>
				<button type="reset">초기화</button>
			</div>
		</form>
	</div>
</div>
