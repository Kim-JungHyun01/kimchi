<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="content-body">
	
		<input type="hidden" name="prp_no" id="prp_no" value="${prpVO.prp_no}">
		<input type="hidden" name="pa_no" id="pa_no" value="${prpVO.pa_no}">

		<h2>진척검수결과</h2>
		계획 검수 일자 : <input type="text" readonly id ="prp_issueDate" value="${prpVO.prp_issueDate }"><br/> 
		결과 작성 일자 : <input type="text" name="prp_revisionDate" id="now" readonly value=""> 
		<p>검수자</p>
		<input type="text" name ="user_id" value="abcd" readonly> 
		<!-- sessin 값 확인 필요 
		<input type="hidden" name ="user_id" value="session.getAttribute()" readonly> 
		-->
		<p>검수 진행도</p>
		<input type = "text" name = "prp_progress" id="prp_progress" value = "0" >
		<input type="range" name="range_val" value="0" min="0" max="100"  oninput="showSliderValue(this)" >
		<p>비고</p>
		<input type="text" id="prp_notes" name="prp_notes" value="${prpVO.prp_notes}">
		
		<button onclick="sendData()">저장</button>
</div>

    </div>
    
    <!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
    <!-- Circle progress -->

</body>
 <script>
 // dateTime의 시간 제거
document.addEventListener("DOMContentLoaded", function() {
    var dateTimeValue = document.getElementById('prp_issueDate').value;
    var dateOnly = dateTimeValue.split(' ')[0];
    document.getElementById('prp_issueDate').value = dateOnly;
    

    function formatDate(date) {
           const year = date.getFullYear();
           const month = String(date.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 +1
           const day = String(date.getDate()).padStart(2, '0');
           return year +"-" + month + "-" +day;
       }
    
    var now = new Date();
    document.getElementById("now").value = formatDate(now);
});

function showSliderValue(slider) {
    var value = slider.value;
    document.querySelector('input[name="prp_progress"]').value = value;
}

//부모창으로 데이터 전송
function sendData() {
    const prp_no = document.getElementById("prp_no").value;
   
    const prp_revisionDate = document.getElementById("now").value;
    
    const prp_progress = document.getElementById("prp_progress").value;

    const prp_notes = document.getElementById("prp_notes").value;

    const pa_no = document.getElementById("pa_no").value;
    
    window.opener.receiveData(prp_no, prp_revisionDate, prp_progress, prp_notes, pa_no);
    
    window.close();
}
 
</script>
 

</html>