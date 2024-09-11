<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>kimchi</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="${contextPath}/resources/images/favicon.png">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

	<style>
.pagination {
    display: flex;
    justify-content: center;
    margin: 20px 0;
}

.pagination a, .pagination strong {
    margin: 0 5px; /* 각 페이지 링크 간격 */
    text-decoration: none; /* 링크 스타일 제거 */
    color: #07020d; /* 링크 색상 */
    padding: 10px 15px; /* 패딩 추가 */
    border-radius: 5px; /* 둥근 모서리 */
    transition: background-color 0.3s, color 0.3s; /* 부드러운 전환 효과 */
}

.pagination a {
    background-color: #f0f0f0; /* 기본 배경색 */
    border: 1px solid #ddd; /* 테두리 추가 */
}

.pagination a:hover {
    background-color: #007bff; /* 호버 시 배경색 */
    color: white; /* 호버 시 글자색 */
    text-decoration: underline; /* 마우스 오버 시 밑줄 */
}

.pagination strong {
    background-color: #007bff; /* 현재 페이지 강조 색상 */
    color: white; /* 현재 페이지 글자색 */
    padding: 10px 15px; /* 패딩 추가 */
    border-radius: 5px; /* 둥근 모서리 */
}

/* 검색창 */
.search-form {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px;
}

.search-input {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 600px; /* 원하는 너비로 조절 */
    transition: border 0.3s;
}

.search-input:focus {
    border-color: #007bff; /* 포커스 시 테두리 색상 변경 */
    outline: none; /* 기본 아웃라인 제거 */
}

.search-button {
    padding: 10px 15px;
    margin-left: 10px;
    border: none;
    border-radius: 5px;
    background-color: #5892d1; /* 버튼 배경색 */
    color: white; /* 글자색 */
    cursor: pointer;
    transition: background-color 0.3s;
}

.search-button:hover {
    background-color: #0056b3; /* 호버 시 색상 변경 */
}

/* 버튼들 모양 */
.link-container { /* 오른쪽 정렬 */
    display: flex; /* 플렉스 박스 설정 */
    justify-content: flex-end; 
    margin-bottom: 10px; /* 아래쪽 여백 */
}

.link-left{ /*버튼 왼쪽 정렬시*/
    text-align: left; 
    margin-bottom: 10px; /* 아래쪽 여백 */
}

.link-button {
    display: inline-block; 
    padding: 7px 7px; 
    margin-left: 10px; /* 좌측 마진 추가 */
    margin-right: 15px; /* 우측 마진 추가 */
    border: none; 
    border-radius: 5px; 
    background-color: #5892d1; /* 버튼 배경색 */
    color: white; /* 글자색 */
    cursor: pointer;
    transition: background-color 0.3s; /* 배경색 전환 효과 */
}

.link-button:hover {
    background-color: #0056b3; /* 호버 시 배경색 변경 */
    color: white; /* 글자색을 흰색으로 유지 */
}

.link-button:active {
    transform: scale(0.95); 
    outline: none; /* 기본 아웃라인 제거 */
}

.table th, .table td {
    text-align: center; /* 가운데 정렬 */
}
</style>

</head>



<body>
	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader">
		<div class="sk-three-bounce">
			<div class="sk-child sk-bounce1"></div>
			<div class="sk-child sk-bounce2"></div>
			<div class="sk-child sk-bounce3"></div>
		</div>
	</div>
	<!--*******************
        Preloader end
    ********************-->


	<!--**********************************
        Main wrapper start
    ***********************************-->
	<div id="main-wrapper">

		<!--**********************************
            Nav header start
        ***********************************-->
		<div class="nav-header">
			<a href="#" class="brand-logo"> <img class="logo-abbr"
				src="${contextPath}/resources/images/logo.png" alt=""> <img
				class="logo-compact"
				src="${contextPath}/resources/images/logo-text.png" alt=""> <!-- 이미지 조정-->
				<img class="brand-title"
				src="${contextPath}/resources/images/thekimchi.jpg">
			</a>
			<div class="nav-control">
				<div class="hamburger">
					<span class="line"></span><span class="line"></span><span
						class="line"></span>
				</div>
			</div>
		</div>
		<!--**********************************
            Nav header end
        ***********************************-->

		<!--**********************************
            Header start
        ***********************************-->
		<div class="header">
			<div class="header-content">
				<nav class="navbar navbar-expand">
					<div class="collapse navbar-collapse justify-content-between">
						<div class="header-left">
							<!-- 검색기능삭제 -->
						</div>
						<ul class="navbar-nav header-right">
							<li class="nav-item dropdown header-profile">
							<a href="${contextPath}/login/logout" class="dropdown-item"> <i
									class="icon-key"></i> <span class="ml-2">Logout </span>
							</a>
								<div class="dropdown-menu dropdown-menu-right"></div></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<!--**********************************
            Header end ti-comment-alt
        ***********************************-->

		<!--**********************************
            Sidebar start
        ***********************************-->
	
		<!--**********************************
            Sidebar end
        ***********************************-->

		<!--**********************************
            Content body start
        ***********************************-->
		<!-- 내용넣는 곳 -->