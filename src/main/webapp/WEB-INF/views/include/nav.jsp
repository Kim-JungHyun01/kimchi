<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<div class="quixnav">
	<div class="quixnav-scroll">
		<ul class="metismenu" id="menu">
			<c:if
				test="${userlogin.user_department eq '개발부서' || userlogin.user_department eq '관리자'}">
				<!-- 물품관리 -->
				<li><a class="has-arrow" href="javascript:void()"
					aria-expanded="false"> <i></i> <span class="nav-text">물품관리</span></a>
					<ul aria-expanded="true">
						<li><a href="${contextPath}/item/itemAll">물품리스트</a></li>
						<li><a href="${contextPath}/item/itemInsertForm">물품등록</a></li>
					</ul></li>
			</c:if>

			<c:if
				test="${userlogin.user_department eq '자재부서' || userlogin.user_department eq '구매부서' || userlogin.user_department eq '관리자'}">
				<!-- 자재관리 -->
				<li><a class="has-arrow" href="javascript:void()"
					aria-expanded="false"> <i></i><span class="nav-text">자재관리</span></a>
					<ul aria-expanded="false">
						<li><a href="${contextPath}/material/maList">자재리스트</a></li>
						<li><a href="${contextPath}/material/maAdd">자재등록</a></li>
					</ul></li>
			</c:if>

			<c:if
				test="${userlogin.user_department eq '생산부서' || userlogin.user_department eq '관리자'}">
				<!-- 제품계약관리 -->
				<li><a class="has-arrow" href="javascript:void()"
					aria-expanded="false"> <i></i> <span class="nav-text">제품계약관리</span></a>
					<ul aria-expanded="false">
						<li><a href="${contextPath}/contracts/contractsAll">제품계약
								목록</a></li>
						<li><a href="${contextPath}/contracts/contractsInsertForm">제품계약등록</a></li>
					</ul></li>
				<!-- 생산계획 관리 -->
				<li><a class="has-arrow" href="javascript:void()"
					aria-expanded="false"> <i></i> <span class="nav-text">생산계획
							관리</span></a>
					<ul aria-expanded="false">
						<li><a href="${contextPath}/production/productionAll">제품생산
								목록</a></li>
						<li><a href="${contextPath}/production/productionInsertForm">제품생산
								등록</a></li>
					</ul></li>
			</c:if>
			
			<!-- 조달계획 관리 (모든 부서에서 한 번씩만 출력) -->
			<c:if test="${userlogin.user_department eq '관리자' || userlogin.user_department eq '자재부서' || userlogin.user_department eq '구매부서' || userlogin.user_department eq '생산부서'}">
				<li><a class="has-arrow" href="javascript:void()"
					aria-expanded="false"> <i
						class="simple-line-icons icon-social-dropbox"></i> <span
						class="nav-text">조달계획 관리</span></a>
					<ul aria-expanded="false">
						<li><a href="${contextPath}/obtain/obtainAll">조달계획 목록</a></li>
					</ul></li>
			</c:if>
			
			<!-- 발주검수관리 -->
			<c:if test="${partlogin != null || userlogin.user_department eq '관리자'}">
				<li><a class="has-arrow" href="javascript:void()"
					aria-expanded="false"> <i></i> <span class="nav-text">발주검수관리</span></a>
					<ul aria-expanded="false">
						<li><a href="${contextPath}/pcsp">발주검수관리</a></li>
					</ul></li>
			</c:if>

			<!-- 게시판 -->
			<li><a class="has-arrow" href="javascript:void()"
				aria-expanded="false"><i></i><span class="nav-text">게시판</span></a>
				<ul aria-expanded="false">
					<li><a href="${contextPath}/sboard/list">게시판목록</a></li>
				</ul></li>

			<c:if test="${userlogin.user_department eq '관리자'}">
				<!-- 승인관리 -->
				<li><a class="has-arrow" href="javascript:void()"
					aria-expanded="false"> <i class="simple-line-icons icon-people"></i>
						<span class="nav-text">관리자전용</span></a>
					<ul aria-expanded="true">
						<li><a href="${contextPath}/user/userAll">직원목록</a></li>
						<li><a href="${contextPath}/partner/partnerAll">협력사목록</a></li>
					</ul></li>
			</c:if>

		</ul>
	</div>
</div>