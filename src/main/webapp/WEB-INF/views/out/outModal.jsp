<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<style>
/* 모달창 스타일 */
#outModal {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    justify-content: center;
    align-items: center; /* 수직 중앙 정렬 */
}

.modal-content {
    background-color: white;
    padding: 20px;
    width: 80%; /* 모달 너비를 70%로 설정 */
    max-height: 70%; /* 최대 높이 조정 */
    overflow-y: auto;
    border-radius: 8px;
    margin-left: 10%; /* 왼쪽 여백 조정 */
    margin-right: 10%; /* 오른쪽 여백 추가 */
}

table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    padding: 10px;
    border: 1px solid #ccc;
}

button {
    margin-top: 40px;
}
</style>
<script>
    function openoutModal() {
        document.getElementById("outModal").style.display = "flex";
    }
    
    function closecoutModal() {
        document.getElementById("outModal").style.display = "none";
    }
    
    // 계약 정보 가져오기
    function selectMaterial(id, name) {
        document.getElementById("ma_id").value = id;
        document.getElementById("ma_name").value = name;
        closecoutModal(); // 모달 닫기
    }
</script>
<div id="outModal">
    <div class="modal-content">
        <h3>자재 조회</h3>
        <table>
            <tr>
                <th>자재코드</th>
                <th>분류</th>
                <th>자재명</th>
                <th>원산지</th>
                <th>자재단위</th>
                <th>자재무게</th>
                <th>재고수량</th>
                <th>자재단가</th>
                <th>자재규격</th>
            </tr>
            <c:forEach var="ma" items="${malist}">
                <tr onclick="selectMaterial('${ma.ma_id}', '${ma.ma_name}')">
                    <td>${ma.ma_id}</td>
                    <td>${ma.ma_category}</td>
                    <td>${ma.ma_name}</td>
                    <td>${ma.ma_origin}</td>
                    <td>${ma.ma_unit}</td>
                    <td>${ma.ma_weight}</td>
                    <td>${ma.ma_stockQuantity}</td>
                    <td>${ma.ma_price}</td>
                    <td>${ma.ma_specifications}</td>
                </tr>
            </c:forEach>
        </table>
        <button onclick="closecoutModal()">닫기</button>
    </div>
</div>
<div id= ></div> 
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>
<script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
