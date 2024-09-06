<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ include file="../include/header.jsp" %>

<style>
    .content-body form input, 
    .content-body form select {
        margin-bottom: 4px; /* 입력 필드 간의 간격 조정 */
        padding: 8px; /* 패딩 추가 */
        width: 90%; 
        margin: 0 auto; /* 수평 가운데 정렬 */
        display: block; /* 블록 요소로 설정 */
        box-sizing: border-box; /* 패딩과 테두리를 포함한 너비 조정 */
    }

    .table {
        border-collapse: collapse; /* 경계가 겹치지 않도록 설정 */
    }

    .table, .table td {
        border: none; /* 테이블과 셀의 경계를 없앰 */
    }

    .table td {
        text-align: center; /* 가운데 정렬 */
    }
</style>

<html>
<div class="content-body">
    <div>
        <h2><center>[  추가  ]</center></h2>
    </div>
    
    <form id="materialForm" action="${contextPath}/material/maAdd" method="post"> 
        <table class="table">
            <tr>
                <td>품목코드</td>
                <td><input type="number" name="ma_id" placeholder="상품코드를 입력하시오" required></td>
            </tr>
            
            <tr>
                <td>분류명</td>
                 <td> <select name="ma_category" required>
                	 <option value="">분류를 선택해주세요</option>
                     <option value="주재료">주재료</option>
                     <option value="부재료">부재료</option>
                     <option value="향신료">향신료</option>
                     <option value="조미료">조미료</option>
                     <option value="부자재">부자재</option>
               </td>

            <tr>
                <td>재료명</td>
                <td><input type="text" name="ma_name" required></td>              
            </tr>
            
            <tr>
                <td>원산지</td>
                <td><input type="text" name="ma_origin" placeholder=""></td>
            </tr>
            
            <tr>
                <td>유통기한</td>
                <td><input type="date" name="ma_expiryDate" required></td>
            </tr>
            
            <tr>
                <td>자재수량</td>
                <td><input type="number" name="ma_stockQuantity" min="0" placeholder="자재의 수량을 숫자로만 입력하시오" required></td>
            </tr>
            
            <tr>
                <td>단위</td>               
                 <td> <select name="ma_unit" required>
                	 <option value="">단위를 선택해주세요</option>
                     <option value="kg">kg</option>
                     <option value="L">L</option>
                     <option value="톤">톤</option>
               </td>

            <tr>
                <td>무게</td>
                <td><input type="text" name="ma_weight" placeholder="숫자만 입력하시오"></td>
            </tr>
            
            <tr>
                <td>포장규격</td>
                <td><input type="text" name="ma_specifications" placeholder="???"></td>
            </tr>
            
            <tr>
                <td>가용재고량</td>
                <td><input type="number" name="ma_availableStock" placeholder="예약 및 출고대기 제외량을 입력하시오"></td>
            </tr>
            
            <tr>
                <td>기본재고량 </td>
                <td><input type="number" name="ma_basicStock" placeholder="최소 유지 수량을 입력하시오"></td>
            </tr>
            
            <tr>
                <td>단가액</td>
                <td><input type="number" name="ma_price" step="0.01" min="0" required></td>
            </tr>
            
            <tr>
                <td>총금액</td>
                <td><input type="number" name="ma_stockValue" readonly></td>
            </tr>
            
            <tr>
                <td>보관위치</td>
                <td> <select name="ma_storage" required>
                	 <option value="">보관위치를 선택해주세요</option>
                     <option value="냉장창고">냉장창고</option>
                     <option value="냉동창고">냉동창고</option>
                     <option value="물류창고">물류창고</option>
               </td>
            </tr>
            
            <tr>
                <td>수정일</td>
                <td><input type="date" name="ma_date"></td>
            </tr>
            
            <tr>
                <td>첨부파일번호</td>
                <td><input type="number" name="attachment_no"></td>
            </tr>            
        </table>
        
        <input type="submit" value="추가완료">
    </form>
</div>

<%@ include file="../include/footer.jsp" %>

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
