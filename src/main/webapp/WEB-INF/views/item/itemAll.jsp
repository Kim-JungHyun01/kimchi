<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<div>
	<h3>물품 리스트</h3>
		<table border="1">
			<tr>
				<td>물품 코드</td>
				<td>물룸 분류</td>
				<td>물품명</td>
				<td>물품 단가</td>
				<td>물품 단위</td>
				<td>물품 무게</td>
				<td>물품 규격</td>
				<td>물품 bom등록여부</td>
				<td>물품 재고수량</td>
				<td>물품 가용재고</td>
				<td>물품 기본재고</td>
				<td>물품 저장고</td>
				<td>물품 생산일</td>
				<td>물품 첨부파일</td>
			</tr>
			<c:forEach var="itemlist" items="${itemlist}">
				<tr>
					<td><a
						href="${contextPath}/item/itemSelect?item_no=${itemlist.item_no}">${itemlist.item_no}</a></td>
					<td>${itemlist.item_category}</td>
					<td>${itemlist.item_name}</td>
					<td>${itemlist.item_price}</td>
					<td>${itemlist.item_unit}</td>
					<td>${itemlist.item_weight}</td>
					<td>${itemlist.item_specifications}</td>
					<td>${itemlist.item_bomRegistered}</td>
					<td>${itemlist.item_stockquantity}</td>
					<td>${itemlist.item_availablestock}</td>
					<td>${itemlist.item_basicstock}</td>
					<td>${itemlist.item_storage}</td>
					<td>${itemlist.item_productionDate}</td>
					<td>${itemlist.attachment_no}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<%@include file="../include/footer.jsp"%>