<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<%@include file="include/header.jsp" %>

<%@include file="include/nav.jsp" %>
       
   <div class="content-body">
	<table>
		<tr>
			<th>번호</th>	
			<th>일자</th>
			<th>거래처명</th>
			<th>품목명</th>
			<th>금액</th>
			<th>발주자</th>
			<th>일치여부</th>
			<th>검수계획수립</th>
			<th>비고</th>
		</tr>
		<c:forEach var="paList" items="${paPageList.povoList}">
			<tr>
				<td>${paList.pa_no}</td>
				<td><fmt:formatDate value="${paList.pa_issueDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${paList.obtainVo.productionVO.contractsVO.partnerVO.partner_companyname}</td>
				<td>${paList.obtainVo.productionVO.contractsVO.itemVO.item_name}</td>
				<td>${paList.obtainVo.productionVO.contractsVO.contracts_price}</td>
				<td>세션값확인 후 연결</td>
				<td>0</td>
				<td>${paList.pa_checkStatus}</td>
				<td>${paList.pa_notes}</td>
			</tr>
		</c:forEach>
		
			
	</table>      
   </div>

<%@include file="include/footer.jsp" %>

    </div>
    
    <!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
    <!-- Circle progress -->

</body>
<script>
	var actionForm = $("#actionForm");
	
	$(".paginate_button a").on("click",function(e){
		e.preventDefault();
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
		
	
		
</script>

</html>