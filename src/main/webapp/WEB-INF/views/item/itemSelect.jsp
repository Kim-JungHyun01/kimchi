<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>

<%@include file="../include/nav.jsp"%>

<div class="content-body">
	<div>
		<h3>물품상세보기</h3>
		<table border="1">
			<tr>
				<td>물품 코드</td>
				<td>${item.item_no}</td>
			</tr>
			<tr>
				<td>물룸 분류</td>
				<td>${item.item_category}</td>
			</tr>
			<tr>
				<td>물품명</td>
				<td>${item.item_name}</td>
			</tr>
			<tr>
				<td>물품 단가</td>
				<td>${item.item_price}</td>
			</tr>
			<tr>
				<td>물품 단위</td>
				<td>${item.item_unit}</td>
			</tr>
			<tr>
				<td>물품 무게</td>
				<td>${item.item_weight}</td>
			</tr>
			<tr>
				<td>물품 규격</td>
				<td>${item.item_specifications}</td>
			</tr>
			<tr>
				<td>물품 bom등록여부</td>
				<td>${item.item_bomRegistered}</td>
			</tr>
			<tr>
				<td>물품 재고수량</td>
				<td>${item.item_stockquantity}</td>
			</tr>
			<tr>
				<td>물품 가용재고</td>
				<td>${item.item_availablestock}</td>
			</tr>
			<tr>
				<td>물품 기본재고</td>
				<td>${item.item_basicstock}</td>
			</tr>
			<tr>
				<td>물품 저장고</td>
				<td>${item.item_storage}</td>
			</tr>
			<tr>
				<td>물품 생산일</td>
				<td>${item.item_productionDate}</td>
			</tr>
			<tr>
				<td>물품 첨부파일</td>
				<td>${item.attachment_no}</td>
			</tr>
		</table>
	</div>
	<hr>
	<c:choose>
		<c:when test="${item.item_bomRegistered == 1}">
			<div>
				<h3>bom 스케줄정보</h3>
				<table border="1">
					<tr>
						<td>제품생산 소요시간</td>
						<td>${bom.bom_schedule}일</td>
					</tr>
					<tr>
						<td>제품생산 기타내용</td>
						<td>${bom.bom_other}</td>
					</tr>
				</table>
			</div>
			<hr>
			<div>
				<h3>bom 상세정보</h3>
				<table border="1">
					<tr>
						<td>자재코드</td>
						<td>분류</td>
						<td>자재명</td>
						<td>자재단위</td>
						<td>자재무게</td>
						<td>소요자재량</td>
						<td>생산과정</td>
					</tr>
					<c:forEach var="bom_malist" items="${bom_malist}">
						<tr>
							<td>${bom_malist.ma_id}</td>
							<c:forEach var="malist" items="${maList}">
								<c:if test="${malist.ma_id == bom_malist.ma_id}">
									<td>${malist.ma_category}</td>
									<td>${malist.ma_name}</td>
									<td>${malist.ma_unit}</td>
									<td>${malist.ma_weight}</td>
								</c:if>
							</c:forEach>
							<td>${bom_malist.bom_ma_amount}</td>
							<td>${bom_malist.bom_ma_process}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div>
				<button
					onclick="${contextPath}/bom/bomUpdateForm?item_no=${item.item_no}">bom수정</button>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<p>bom정보가 존재하지 않습니다.</p>
			</div>
			<div>
				<button type = "button" onclick="${contextPath}/bom/bomInsertForm?item_no=${item.item_no}">bom추가</button>
			</div>
		</c:otherwise>
	</c:choose>
	<div>
		<a href="${contextPath}/item/itemUpdateForm?item_no=${item.item_no}">수정_a</a>
	</div>
</div>

<%@include file="../include/footer.jsp"%>
<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script
	src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>