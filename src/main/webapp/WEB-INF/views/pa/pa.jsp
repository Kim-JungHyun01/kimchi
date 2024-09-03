<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<%@include file="../include/header.jsp" %>

<%@include file="../include/nav.jsp" %>
       
   <div class="content-body">
   <h3>구매발주</h3>
   <button onclick="checkStatus(99)">전체</button>
   <button onclick="checkStatus(0)">미수립</button>
   <button onclick="checkStatus(1)">진행중</button>
   <button onclick="checkStatus(2)">완료</button>
	<table>
		<tr>
			<th>번호</th>	
			<th>발주번호</th>	
			<th>발주일자</th>
			<th>납기일자</th>
			<th>거래처명</th>
			<th>품목명</th>
			<th>금액</th>
			<th>발주자</th>
			<th>검수계획수립</th>
			<th>비고</th>
			<th>인쇄</th>
			<th>진척검수</th>
		</tr>
		<c:forEach var="paList" items="${paPageList.povoList}" varStatus="status">
			<tr>
				<td>${status.count + (paPageList.pageVO.pageNum-1) * paPageList.pageVO.listcnt }</td>
				<td><a href="#" onclick="submitForm(${paList.pa_no})">${paList.codeVo.code_name}</a></td>
				<td><fmt:formatDate value="${paList.pa_issueDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${paList.obtainVo.obtain_deliveryDate}" pattern="yyyy년 MM월 dd일 " /></td>
				<td>${paList.obtainVo.productionVO.contractsVO.partnerVO.partner_companyname}</td>
				<td>${paList.obtainVo.materialVO.ma_name}</td>
				<td><fmt:formatNumber value="${paList.obtainVo.materialVO.ma_price * paList.obtainVo.obtain_quantity}" pattern="###,###,###,###" />원</td>				
				<td>${paList.userVO.user_name }</td>
				<td>
					<c:choose>
						<c:when test="${paList.pa_checkStatus == 0}">
							미수립
						</c:when>
						<c:when test="${paList.pa_checkStatus == 1}">
							진행중
						</c:when>
						<c:when test="${paList.pa_checkStatus == 2}">
							완료
						</c:when>		
						<c:otherwise>
							잘못된 정보입니다.
						</c:otherwise>		
					</c:choose>
				</td>
				<td>${paList.pa_notes}</td>
				<td><button data-pa-no="${paList.pa_no}" id="pop" onclick=" paPop(this)">인쇄</button></td>
				<td><button data-pa_no = "${paList.pa_no}" onclick="showModal(this)">계획수립</button></td>
				
			</tr>
		</c:forEach>
	</table>  
	
	<!-- modal 진척검수계획 작성 -->
	<div class ="modal">
		<div class="modal-content">
			<span class = "close">&times;</span>
			
			<form action="/pa" method="post">
				<h2>진척검수</h2>
				납기 일자 : <input type="date" name="prp_issueDate" id="date" min=""> 
				<p>검수자</p>
				<input type="hidden" name ="pa_no" id="pa_no"> 
				<input type="text" name ="user_id" value="abcd" readonly> 
				<!-- sessin 값 확인 필요 
				<input type="hidden" name ="user_id" value="session.getAttribute()" readonly> 
				-->
				<p>검수 진행도</p>
				<input type = "text" name = "prp_progress" value = "0"  readonly>
				<input type="range" name="range_val" value="0" min="0" max="100"  oninput="showSliderValue(this)" >
				<p>비고</p>
				<input type="text" name="prp_notes">
				<button onclick="modalForm()">저장</button>
		</div>
	</div>
	
	<!-- 페이징 작업 -->
	<ul>
		<c:if test="${paPageList.pageVO.prev}">
			<li class="paginate_button"><a href="1">START</a></li>
		</c:if>
		<c:if test="${paPageList.pageVO.pageNum != 1}">
			<li class="paginate_button"><a href="${paPageList.pageVO.pageNum -1}">&lt;</a></li>
		</c:if>
		
		
		<c:forEach var="num" begin="${paPageList.pageVO.startPage}" end="${paPageList.pageVO.endPage}">
			<li class="paginate_button ${paPageList.pageVO.pageNum == num ? 'active' : '' }"><a href="${num}">${num}</a></li>
		</c:forEach>
		
		<c:if test="${paPageList.pageVO.pageNum != paPageList.pageVO.total}">
			<li class="paginate_button"><a href="${paPageList.pageVO.pageNum +1}"> &gt;</a></li>
		</c:if>
		<c:if test="${paPageList.pageVO.next}">
			<li class="paginate_button"><a href="${paPageList.pageVO.total}">END</a></li>
		</c:if>
		
	</ul>
	    
	<form id="actionForm" action="/pa" method="get">
		<input type="hidden" name="pageNum" value="${poPageList.pageVO.pageNum }">
		<!-- 필요하면 생성
		<input type="hidden" name="total" value="${poPageList.pageVO.total }">
		  -->
	</form>	    
   </div>


<%@include file="../include/footer.jsp" %>
    </div>
    
    <!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
    <!-- Circle progress -->

</body>
<script>
$(document).ready(function(){
	$(".paginate_button a").on("click",function(e){
		e.preventDefault();
		var actionForm = $('#actionForm');
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
});

function paPop(button) {
    var paNo = button.getAttribute('data-pa-no');

    // POST 요청을 보낼 URL
    var url = 'paPop';

    // 새 폼 요소 생성
    var form = document.createElement('form');
    form.method = 'POST';
    form.action = url;
    form.target = '구매발주'; // 새 창의 이름

    // 숨겨진 input 요소 생성
    var input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'pa_no';
    input.value = paNo;

    // 폼에 input 추가
    form.appendChild(input);

    // 새 창 열기
    var popup = window.open('', '구매발주', 'width=1000,height=800,left=440,top=125,scrollbars=yes');

    // 폼을 문서에 추가하고 제출
    document.body.appendChild(form);
    form.submit();
}

function showModal(button) {
	var modal = document.querySelector(".modal");
	modal.style.display ="block";
	
	var close = document.querySelector(".close");
	close.addEventListener("click", function(){
		modal.style.display ="none";
	});
	
	var pa_no = button.getAttribute("data-pa_no");
	document.getElementById("pa_no").value = pa_no;
}

function showSliderValue(slider) {
    var value = slider.value;
    document.querySelector('input[name="prp_progress"]').value = value;
}


// paDetail로 이동
function submitForm(pa_no) {
    // POST 요청을 보낼 URL
    var url = '/paDetail';

    // 새 폼 요소 생성
    var form = document.createElement('form');
    form.method = 'POST';
    form.action = url;

    // 숨겨진 input 요소 생성
    var input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'pa_no'; // 서버에서 사용할 파라미터 이름
    input.value = pa_no;

    // 폼에 input 추가
    form.appendChild(input);

    // 폼을 문서에 추가하고 제출
    document.body.appendChild(form);
    form.submit();
}

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){today();});
	function today() {
		var now = new Date();
	 	var year = now.getFullYear();
	 	var month = now.getMonth() + 1;
	 	var day = now.getDate();
	 	
	 	if (month < 10) month = '0' + month;
        if (day < 10) day = '0' + day;
	 	
	 	var formatToday = year + "-" + month + "-" + day;
	 	console.log(formatToday);
		document.getElementById("date").setAttribute("min",formatToday);
	}
</script>
<style>
display : inline;


.modal {
 display: none;
 width: 100%;
 height: 100%;
 left: 0;
 top: 0;
 background-color: rgba(0, 0, 0, 0.4); /* 반투명 배경 */
 
 
}

.modal-content {
	width: 50%;
	height: 50%;
	position: relative;
    top: 25%;
    left: 25%;
}

</style>	
	
	


</html>