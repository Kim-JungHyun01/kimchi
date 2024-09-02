<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@include file="../include/header.jsp"%>
<%@include file="../include/nav.jsp"%>

<div class="content-body">

		<div>
			<h2>전체 자재 조회</h2>
		</div>

	<table>
		<tr>
			<th>품목코드</th>
			<th>분류명</th>
			<th>재료명</th>
			<th>원산지</th>
			<th>재고수량</th>
			<th>단위</th>
			<th>무게</th>
			<th>포장규격</th>
			<th>단가액</th>
			<th>총금액</th>
			<th>첨부파일번호</th>
		</tr>
		
		<c:forEach var="ma" items="${list}">
			<tr>
				<td>${ma.ma_id}</td>
				<td>${ma.ma_category}</td>
				<td><a href="maView?ma_id=${ma.ma_id}">${ma.ma_name}</a></td>
				<td>${ma.ma_origin}</td>	
				<td>${ma.ma_stockQuantity}</td>				
				<td>${ma.ma_unit}</td>
				<td>${ma.ma_weight}</td>
				<td>${ma.ma_specifications}</td>										
				<td>${ma.ma_price}</td>
				<td>${ma.ma_stockValue}</td>
				<td>${ma.attachment_no}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><a href="${contextPath}maAdd">자재추가</a></td>
		</tr>
	</table>
</div>

<%@include file="../include/footer.jsp"%>

<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>

<script>
	var actionForm = $("#actionForm");

	$(".paginate_button a").on("click", function(e) {
		e.preventDefault();
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
</script>

</body>
</html>
