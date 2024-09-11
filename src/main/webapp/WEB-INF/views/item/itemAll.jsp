<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
 <link href="<c:url value="${contextPath}/resources/css/mystyle.css"/>" rel='stylesheet' />
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="../include/header.jsp"%>
<div class="content-body">
	<form action="?pageNum=1" method="get" class="search-form">
		<input type="text" name="item_name" placeholder="물품명 검색" value="${param.item_name}" class="search-input" />
		<button type="submit" class="search-button">검색</button>
	</form>
	<div style="margin-left: 20px;"> 
	<h3>물품 리스트</h3>
		<table class="table">
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
			</tr>
			<c:forEach var="itemlist" items="${itemlist}">
				<tr onclick="location.href='${contextPath}/item/itemSelect?item_no=${itemlist.item_no}'" style="cursor: pointer;">
					<td>${itemlist.item_no}</td>
					<td>${itemlist.item_category}</td>
					<td>${itemlist.item_name}</td>
					<td>${itemlist.item_price}</td>
					<td>${itemlist.item_unit}</td>
					<td>${itemlist.item_weight}</td>
					<td>${itemlist.item_specifications}</td>
					<td><c:choose>
							<c:when test="${itemlist.item_bomRegistered == 0}">
      							  X
   							 </c:when>
							<c:when test="${itemlist.item_bomRegistered == 1}">
						        O
						    </c:when>
						</c:choose></td>
					<td>${itemlist.item_stockquantity}</td>
					<td>${itemlist.item_availablestock}</td>
					<td>${itemlist.item_basicstock}</td>
					<td>${itemlist.item_storage}</td>
					<td>${itemlist.item_productionDate}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- Pagination -->
		<div class="pagination">
			<c:if test="${currentPage > 1}">
				<a href="?pageNum=${currentPage - 1}">이전</a>
			</c:if>

			<c:forEach var="page" begin="1" end="${totalPages}">
				<c:choose>
					<c:when test="${page == currentPage}">
						<strong>${page}</strong>
					</c:when>
					<c:otherwise>
						<a href="?pageNum=${page}">${page}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${currentPage < totalPages}">
				<a href="?pageNum=${currentPage + 1}">다음</a>
			</c:if>
		</div>
	</div>
</div>
<%@include file="../include/footer.jsp"%>