<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="quixnav">
	<div class="quixnav-scroll">
		<ul class="metismenu" id="menu">
			<!--  <li class="nav-label first">Main Menu</li>
					<li><a href="index.html"><i class="icon icon-single-04"></i><span class="nav-text">Dashboard</span></a>
		                    </li> 
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-single-04"></i><span
							class="nav-text">Dashboard</span></a>
						<ul aria-expanded="false">
							<li><a href="${contextPath}/start">Dashboard 1</a></li>
							<li><a href="${contextPath}/resources/index2.html">Dashboard
									2</a></li>
						</ul></li> -->
			<!-- 물품관리 -->
			<li class="nav-label first">물류관리</li>
			<li><a class="has-arrow" href="javascript:void()"
				aria-expanded="false"><i class="icon icon-single-04"></i> <span
					class="nav-text">물품관리</span></a>
				<ul aria-expanded="true">
					<li><a href="${contextPath}/item/itemAll">물품리스트</a></li>
					<li><a href="${contextPath}/item/itemInsertForm">물품등록</a></li>
				</ul></li>
			<!-- 자재관리 -->
			<li><a class="has-arrow" href="javascript:void()"
				aria-expanded="false"><i></i> <span class="nav-text">제재관리</span></a>
				<ul aria-expanded="false">
					<li><a href="${contextPath}">자재리스트</a></li>
					<li><a href="${contextPath}">자재등록</a></li>
				</ul></li>
			<!-- 제품계약관리 -->
			<li><a class="has-arrow" href="javascript:void()"
				aria-expanded="false"><i></i> <span class="nav-text">제품계약관리</span></a>
				<ul aria-expanded="false">
					<li><a href="${contextPath}/contracts/contractsAll">제품계약 목록</a></li>
					<li><a href="${contextPath}/contracts/contractsInsertForm">제품계약 등록</a></li>
				</ul></li>
			<!-- -생산계획 관리 -->
			<li><a class="has-arrow" href="javascript:void()"
				aria-expanded="false"><i></i> <span class="nav-text">생산계획
						관리</span></a>
				<ul aria-expanded="false">
					<li><a href="${contextPath}/production/productionAll">제품생산 목록</a></li>
					<li><a href="${contextPath}/production/productionInsertForm">제품생산 등록</a></li>
				</ul></li>
			<!-- -조달계획관리 -->
			<li><a class="has-arrow" href="javascript:void()"
				aria-expanded="false"><i></i> <span class="nav-text">조달계획
						관리</span></a>
				<ul aria-expanded="false">
					<li><a href="${contextPath}/obtain/obtainAll">조달계획 목록</a></li>
					<li><a href="${contextPath}/obtain/obtainInsertForm">조달계획 등록</a></li>
				</ul></li>
			<!-- 발주관리 -->
			<li><a class="has-arrow" href="javascript:void()"
				aria-expanded="false"><i></i> <span class="nav-text">발주관리</span></a>
				<ul aria-expanded="false">
					<li><a href="${contextPath}">발주목록</a></li>
					<li><a href="${contextPath}">발주등록</a></li>
				</ul></li>
			<!-- 자재조달관리_입고  -->
			<li><a class="has-arrow" href="javascript:void()"
				aria-expanded="false"><i class="icon icon-app-store"></i><span
					class="nav-text">입고 및 출고관리</span></a>
				<ul aria-expanded="false">
					<li><a href="${contextPath}/material/maList">재고현황</a></li>
					<li><a href="imformation">입출고정보</a></li>
					<li><a href="${contextPath}/resources/app-calender.html">자재입고관리</a></li>
					<li><a href="${contextPath}/out/outList">출고목록</a></li>
					<li><a href="${contextPath}/material/maReport">금액현황</a></li>
				</ul></li>
			<!-- 관리자관리  -->

			<li class="nav-label first">관리자전용</li>
			<li><a class="has-arrow" href="javascript:void()"
				aria-expanded="false"> <i class="icon icon-single-04"></i> <span
					class="nav-text">승인관리</span></a>
				<ul aria-expanded="true">
					<li><a href="${contextPath}/user/userAll">직원목록</a></li>
					<li><a href="${contextPath}/partner/partnerAll">협력사목록</a></li>
				</ul>
			</li>
		</ul>
	</div>
</div>