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
</style>
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
											<input type="text" class="form-control" name="partner_taxid" id="partner_taxid" placeholder="협력회사">
											<button type="button" class="check-button btn btn-secondary" onclick="">사업자번호 중복확인</button>
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
										<label><strong>협력회사 Password 재입력</strong></label>
										<input type="password" name="partner_pwcheck" id="partner_pwcheck"  class="form-control" placeholder="협력회사 Password 재입력">
									</div>
									<div class="form-group">
										<label><strong>협력회사명</strong></label>
										<input type="text" name="partner_companyname" id="partner_companyname" class="form-control" placeholder="협력회사명">
									</div>
									<div class="form-group">
										<label><strong>협력회사 전화번호</strong></label>
										<input type="text" name="partner_number" id="partner_number" class="form-control" placeholder="협력회사 전화번호">
									</div>
									<div class="form-group">
										<label><strong>협력회사 대표자명</strong></label>
										<input type="text" name="partner_ownername" id="partner_ownername"  class="form-control" placeholder="협력회사 대표자명">
									</div>
									<div class="form-group">
										<label><strong>협력회사 fax</strong></label>
										<input type="text" name="partner_fax" id="partner_fax" class="form-control" placeholder="협력회사 fax">
									</div>
									<div class="form-group">
										<label><strong>협력회사 email</strong></label>
										<input type="email" name="partner_email" id="partner_email" class="form-control" placeholder="협력회사 email">
									</div>
									<div class="form-group">
										<label><strong>협력회사 사업장주소</strong></label>
										<input type="text" name="partner_add" id="partner_add" class="form-control" placeholder="협력회사 사업장주소">
									</div>
									<div class="text-center mt-4">
										<button type="submit" class="btn btn-primary btn-block">등록신청</button>
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
