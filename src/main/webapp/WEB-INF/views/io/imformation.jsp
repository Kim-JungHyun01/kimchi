<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

  <%@include file="../include/header.jsp" %>
  
  
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->
        
        
  <%@include file="../include/nav.jsp" %>
        
        <!--**********************************
            Sidebar end
        ***********************************-->

        <!--**********************************
            Content body start
        ***********************************-->
       
        <div class="content-body">
      	
      			
      			
      				<div  class="card-body" style="float:right;">
      					<button type="button" class="btn  btn-square btn-dark">검색하기</button>
                        <button type="button" class="btn btn-square btn-outline-success" id="insert-btn">추가하기</button>
                        <button type="button" class="btn btn-square btn-outline-danger" id="modal-btn">발주조회</button>
      				</div>
      				<div style="height:520px;">영역1
      					<div style="height:120px; ">
      					<form action="">
      						<table>
      							<tr>
      								<th scope="row" style="color:black;">담당자 : <input type="text"> </th>
      								<th scope="row" style="color:black;">협력회사 : <input type="text"> </th>
      							</tr>
      						
      						</table>
      					</form>
      					</div>
      					<div>
                              	<table id="List" class="display" style="min-width: 845px; color:black;">
                                        <thead>
                                                <tr>
                                                <th>입출고 코드</th>
                                                <th>입출고 상태</th>
                                                <th>수량</th>
                                                <th>입고일</th>
                                                <th>상세정보</th>
                                                <th>반품일</th>
                                                <th>거래명세서여부</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Tiger Nixon</td>
                                                <td>System Architect</td>
                                                <td>Edinburgh</td>
                                                <td>61</td>
                                                <td>2011/04/25</td>
                                                <td>$320,800</td>
                                            </tr>
                                        </tbody>
                              </table>
      					</div>
                        <div id="modal" class="dialog">
  							<div class="tb">
    							<div class="inner" style="max-width:800px;">
      								<div class="top">
	      								<div class="title">
											조달중인 material 상세리스트 조회						
	      								</div>
        						<a  class="p_close" id="close">닫기</a>
      						</div>
 							<button type="button" onclick="getlist()">선택</button>  						
      						<div class="ct">
      							<table id="example" class="display" style="min-width: 845px; color:black;">
                                        <thead>
                                            <tr>
                                                <th>조달번호</th>
                                                <th>자재명</th>
                                                <th>규격</th>
                                                <th>조달량</th>
                                                <th>단위</th>
                                                <th>납기일</th>
                                                <th>담당자</th>
                                            </tr>
                                        </thead>
                                        
                                        <c:forEach items="${list}" var="list">
                                        <tbody >
                                      
                                            <tr>
                                            	<td>
   													 <input type="radio" name="obtain" id="obtain_no${list.obtain_no}"  
       	 												value='{
            													"obtain_no":"${list.obtain_no}",
            													 "user_id":"${list.user_id}",
            													"quantity":"${list.obtain_quantity}",
            													"deliveryDate":"${list.obtain_deliveryDate}",
            													 "status":"${list.obtain_status}",
            													"production":"${list.production_no}",
            													 "ma_id":"${list.ma_id}",
            													 "name":"${list.materialVO.ma_name}",
            													 "price":"${list.materialVO.ma_price}",
            													 "unit":"${list.materialVO.ma_unit}",
            													"specifications":"${list.materialVO.ma_specifications}"
        												}'>${list.obtain_no}
												</td>
                                                <td>${list.materialVO.ma_name}</td>
                                                <td>${list.materialVO.ma_specifications}</td>
                                                <td>${list.obtain_quantity}</td>
                                                <td>${list.materialVO.ma_unit}</td>
                                                <td>${list.obtain_deliveryDate}</td>
                                                <td>${list.user_id}</td>
                                            </tr>
                                        </tbody>
                                       </c:forEach>
                              </table>
                              <form action="">
									<input type="hidden" id="num">                              
                              </form>
      						</div>
    					</div>
  					 </div>
				</div>

      		</div>
      		<div style="height:500px;"> 입출고 추가
      			<form action="">
      					<table id="t1" class="display" style="min-width: 845px; color:black;">
                                        <thead>
                                            <tr>
                                                <th id="h">입출고 코드</th>
                                                <th id="h">입출고 상태</th>
                                                <th id="h">수량</th>
                                                <th id="h">입고일</th>
                                                <th id="h">상세정보</th>
                                                <th id="h">거래명세서여부</th>
                                            </tr>
                                        </thead>
                                    
                                     
                                        <tbody >

                                            <tr>
                                                <td id="d"><input type="text" id="inp-1" name="io_id"></td>
                                                <td id="d"><input type="text" id="io_status" name="io_status"></td>
                                                <td id="d"><input type="text" id="io_quantity" name="io_quantity"></td>
                                                <td id="d"><input type="date" name="io_date"></td>
                                                <td id="d"><input type="text" id="io_information" name="io_information" ></td>
                                                <td id="d"><input type="text" id="invoice_issuance_status" name="invoice_issuance_status" value="NO"></td>
                                                <!--보이지 않는 table-->
                                                <td id="d" style="display:none;"><input type="hidden" id="ma_id" name="ma_id" ></td>
                                                <td id="d" style="display:none;"><input type="hidden" id="obtain_no" name="obtain_no"></td>
                                                <td id="d" style="display:none;"><input type="hidden" id="ma_name" name="ma_name" ></td>
                                                <td id="d" style="display:none;"><input type="hidden" id="ma_price" name="ma_price" ></td>
                                                <td id="d" style="display:none;"><input type="hidden" id="production_no" name="production_no" ></td>
                                            </tr>
                                        </tbody>
                                       	                       
                              </table>
                          </form>
      				</div>
      		
      	
        </div>
        <!--**********************************
            Content body end
        ***********************************-->


        <!--**********************************
            Footer start
        ***********************************-->   
     
       <%@include file="../include/footer.jsp" %>
     
        <!--**********************************
            Footer end
        ***********************************-->

        <!--**********************************
           Support ticket button start
        ***********************************-->

        <!--**********************************
           Support ticket button end
        ***********************************-->


    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    <!--**********************************
        Scripts
    ***********************************-->
    <!-- Required vendors -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>

    <script src="${contextPath}/resources/vendor/highlightjs/highlight.pack.min.js"></script>
    <!-- Circle progress -->
    <style>
		.dialog {
  display:none;
  position: fixed;
  left: 0;
  top: 0;
  z-index: 10;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.4);
}

.dialog>.tb {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
}

.dialog>.tb .inner {
  width: 100%;
  padding: 20px;
  background: #fff;
  border-radius: 16px;
}

.dialog .top {
  display: flex;
  align-item: center;
  border-bottom: 1px solid #ddd;
  justify-content: space-between;
  padding-bottom: 15px;
  margin-bottom: 15px;
}

.dialog .title {
  font-weight: bold;
  height: 90px;
}

.dialog .ct {
  max-height: 60vh;
  height: 60vh;
  overflow-y: auto;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  background-color: #fff;
 }
 
  
 #t1,#d,#h {
  border: 1px solid black;
  border-collapse: collapse;
}
 	#d {
  background-color: #96D4D4;
}

	
	</style>
	<script type="text/javascript">
	const modal = document.querySelector("#modal");
	const btn = document.querySelector("#modal-btn");
	const close = document.getElementById("close");
	const input = document.getElementById("inp-1");
	const f_btn = document.getElementById("insert-btn");
	
	
	//포커스
	f_btn.onclick = function() {
		input.focus();	
	}
	
	// 모달창 열기
	btn.onclick = function() {
	  modal.style.display = "block";
	  
	}

	// 모달창 닫기
	close.onclick = function() {
	  modal.style.display = "none";
	}
	
	function getlist() {
		
		var selectedRadio = document.querySelector('input[name="obtain"]:checked');
		console.log("----" + selectedRadio.value)
		console.log(document.querySelector('input[name="obtain"]:checked').value);
			
		if(selectedRadio){
			 
			var selectedValue = JSON.parse(selectedRadio.value);
			
			
			try{
				
		
			 document.getElementById('inp-1').value = "io-"+selectedValue.obtain_no;
			 document.getElementById('io_status').value = selectedValue.status;
		     document.getElementById('io_quantity').value = selectedValue.quantity;
		     
		     document.getElementById('ma_name').value = selectedValue.name;
		     document.getElementById('ma_id').value = selectedValue.ma_id;
		     document.getElementById('ma_price').value = selectedValue.price;
		     document.getElementById('obtain_no').value = selectedValue.obtain_no;
		     document.getElementById('production_no').value = selectedValue.production;
			} catch(e){
				
				console.error("JSON 파싱 오류:", e);
			}
	
		}else{
			console.log("선택된 항목이 없습니다.");
		}  
		 
		}
	

	
	
</script>

</body>

</html>