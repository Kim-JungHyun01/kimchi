<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<%@include file="../include/header.jsp" %>
<%@include file="../include/nav.jsp" %>

<div class="content-body">
    <div>
        <h2>추가</h2>
    </div>
    
    <form id="materialForm" action="${contextPath}/material/maAdd" method="post"> 
        품목코드: <input type="number" name="ma_id" required><br> 
        분류명: <input type="text" name="ma_category" required><br>
        재료명: <input type="text" name="ma_name" required><br>
        원산지: <input type="text" name="ma_origin"><br>
        유통기한: <input type="date" name="ma_expiryDate"><br>        
        재고수량: <input type="number" name="ma_stockQuantity" min="0" required><br>
        단위: <input type="text" name="ma_unit"><br>
        무게: <input type="text" name="ma_weight"><br> 
        포장규격: <input type="text" name="ma_specifications"><br>
        가용재고량: <input type="number" name="ma_availableStock"><br>  
        기본재고량: <input type="number" name="ma_basicStock"><br> 
        단가액: <input type="number" name="ma_price" step="0.01" min="0" required><br>  
        총금액: <input type="number" name="ma_stockValue" readonly><br> 
        보관위치: <input type="text" name="ma_storage"><br>
        수정일: <input type="date" name="ma_date"><br>  
        첨부파일번호: <input type="number" name="attachment_no"><br>  
        
        <input type="submit" value="추가완료">
    </form>
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

<script>
	// 재고 총액 계산
	function calStockValue() {
	    var quantity = parseFloat(document.querySelector('input[name="ma_stockQuantity"]').value) || 0; // 재고 수량 값 없으면 0
	    var price = parseFloat(document.querySelector('input[name="ma_price"]').value) || 0; // 가격 값 없으면 0
	    document.querySelector('input[name="ma_stockValue"]').value = quantity * price; // 총액
	}
	
	// 재고 수량 입력 필드 입력 -> 총액 갱신
	document.querySelector('input[name="ma_stockQuantity"]').addEventListener('input', calStockValue);
	// 가격 입력 필드 입력 -> 총액 갱신
	document.querySelector('input[name="ma_price"]').addEventListener('input', calStockValue);

</script>
</html>
