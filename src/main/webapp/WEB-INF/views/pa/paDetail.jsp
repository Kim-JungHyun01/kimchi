<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<%@include file="../include/header.jsp" %>

<%@include file="../include/nav.jsp" %>
       
  <div class="content-body">
  		<h2>발주상세</h2>
	   <table>
		   <tr>
			   	<th>목록</th>
			   	<th>내용</th>
		   </tr>
		   <tr>
			   <td>발주번호</td>
			   <td>${paVO.codeVo.code_name}</td>
		   </tr>
		   <tr>
			   <td>발주자</td> 
			   <td>${paVO.userVO.user_name }</td>
		   </tr>
		   <tr>
		   		<td>발주일자</td>
		  		<td><fmt:formatDate value="${paVO.pa_issueDate}" pattern="yyyy-MM-dd" /></td>
		   </tr> 
		   <tr>
		   		<td>납기일</td>
		  		<td><fmt:formatDate value="${paVO.obtainVo.obtain_deliveryDate}" pattern="yyyy-MM-dd" /></td>
		   </tr> 
		    <tr>
			   <td>공급업체</td> 
			   <td>${paVO.obtainVo.productionVO.contractsVO.partnerVO.partner_companyname}</td>
		   </tr>
		    <tr>
			   <td>품명</td> 
			   <td>${paVO.obtainVo.materialVO.ma_name}</td>
		   </tr>
		    <tr>
			   <td>원산지</td> 
			   <td>${paVO.obtainVo.materialVO.ma_origin}</td>
		   </tr>
		    <tr>
			   <td>수량</td> 
			   <td>${paVO.obtainVo.obtain_quantity}</td>
		   </tr>
		    <tr>
			   <td>단위</td> 
			   <td>${paVO.obtainVo.materialVO.ma_unit}</td>
		   </tr>
		    <tr>
			   <td>규격 및 사양</td> 
			   <td>${paVO.obtainVo.materialVO.ma_specifications}</td>
		   </tr>
		    <tr>
			   <td>단가</td> 
			   <td><fmt:formatNumber value="${paVO.obtainVo.materialVO.ma_price}" pattern="###,###,###,###" />원</td>
		   </tr>
		    <tr>
			   <td>합계</td> 
			   <td><fmt:formatNumber value="${paVO.obtainVo.materialVO.ma_price * paVO.obtainVo.obtain_quantity}" pattern="###,###,###,###" />원</td>
		   </tr>
	   </table>   	
	  	
	<h2>진척계획</h2>
	<table>
	<c:forEach var="prpList" items="${prpList}">
		<tr>
			<td>검수일자</td>
			<td>${prpList.prp_issueDate }</td>
			<td><button data-prp_no=${prpList.prp_no } onclick="prpPop(this)">검수결과</button>
		</tr>
		<tr>
			<td>검수자</td>
			<td>${prpList.user_id }</td>
		</tr>
		<tr>
			<td>검수진척도</td>
			<td>${prpList.prp_progress }</td>
		</tr>
		<tr>
			<td>비고</td>
			<td>${prpList.prp_notes }</td>
		</tr>
	</c:forEach>
	</table> 
  </div>
	<input type="hidden" id="pa_no" value="${paVO.pa_no }">
	
	<!-- db갱신 -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
    function receiveData(prp_no, prp_revisionDate, prp_progress, prp_notes, pa_no) {
        $.ajax({
            type: 'POST',
            url: 'prpUpdate',
            data: {
                prp_no: prp_no,
                prp_revisionDate: prp_revisionDate,
                prp_progress: prp_progress,
                prp_notes: prp_notes,
                pa_no: pa_no
            },
            success: function(response) {
                // 페이지 새로고침
                location.reload();
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error("서버 오류:", textStatus, errorThrown);
            }
        });
    }
    </script>


<%@include file="../include/footer.jsp" %>
    </div>
    
    <!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
    <!-- Circle progress -->

</body>
<script type="text/javascript">
function prpPop(button){
	var prp_no = button.getAttribute("data-prp_no");
	var url = "prpDetailPop";

	var pa_no = document.getElementById("pa_no").value;
	
	var form = document.createElement("form");
	form.action= url;
	form.method="get";
	form.target="prpDetailPop";
	
	var input = document.createElement("input");
	input.type = "hidden";
	input.name = "prp_no";
	input.value = prp_no;
	form.appendChild(input);
	
	var inputPa_no = document.createElement("input");
	inputPa_no.type = "hidden";
	inputPa_no.name = "pa_no";
	inputPa_no.value = pa_no;
	form.appendChild(inputPa_no);
	
	window.open('', 'prpDetailPop', 'width=1000,height=800,left=440,top=125');
	
	document.body.appendChild(form);
	form.submit();
}

</script>


</html>