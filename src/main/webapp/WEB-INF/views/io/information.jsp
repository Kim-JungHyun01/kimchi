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
      		<div class="container-fluid">
      			<div class="row page-titles mx-0">
                    <div class="col-sm-6 p-md-0">
                        <div class="welcome-text">
                            <h4>입출고 정보 Page</h4>
                            <span class="ml-1">입고/출고</span>
                        </div>
                    </div>
                    <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">홈</a></li>
                            <li class="breadcrumb-item active"><a href="javascript:void(0)">입출고정보</a></li>
                        </ol>
                    </div>
                </div>
                
                <div class="row">
                	<div class="card-body" style="float: right;">
                        <button type="button" class="btn btn-square btn-outline-success"  style="min-width: 80px;" id="insert-btn">추가하기</button>
                        <button type="button" class="btn btn-square btn-outline-danger" style="min-width: 80px;" id="modal-btn">발주조회</button>
                        <button type="button" class="btn btn-outline-warning" style="min-width: 80px;" id="io-check-btn">검수완료</button>
                        <button type="button" class="btn btn-outline-primary" style="min-width: 80px;" id="transaction-btn">거래명세서</button>
                	</div>
                	
                	<div class="col-lg-12">
                        <div id="informationCard" class="card">
                            <div class="card-header">
                                <h4 class="card-title">입고</h4>
                            </div>
                            <div id="informBody" class="card-body">
                                <div class="table-responsive">
                                <form id="insert_in" action="insert_io" method="post">
                                 <table class="table table-bordered verticle-middle table-responsive-sm">
    							    <tr>
            							<td style="width:300px">입출고코드</td>
            							<td><label for="inp-1">io-</label><input type="int" id="inp-1" name="io_id"></td>
           	 							<td style="width:300px">입출고 상태</td>
            							<td><input type="text" id="io_status" name="io_status"></td>
            							<td style="width:300px">입고일</td>
            							<td><input type="date" name="io_date" id="in_date"></td>
        							</tr>
        							<tr>
            							<td>제품명</td>
            							<td><input type="text" id="ma_name" name="ma_name" ></td>
            							<td>수량</td>
            							<td><input type="text" id="io_quantity" name="io_quantity"></td>
            							<td>단가(원)</td>
            							<td><input type="text" id="ma_price" name="ma_price" ></td>
        							</tr>
        							<tr>
            							<td>거래명세서여부</td>
            							<td><input type="text" id="invoice_issuance_status" name="invoice_issuance_status"></td>
            							<td>상세정보</td>
            							<td colspan="3" align="center">
                						<textarea rows="2" cols="50px" style="resize: none;" id="io_information" name="io_information"></textarea>
            							</td>
            							<td  style="display:none;"><input type="int" id="ma_id" name="ma_id" ></td>
            							<td  style="display:none;"><input type="int" id="production_no" name="production_no" ></td>
            							<td  style="display:none;"><input type="int" id="obtain_no" name="obtain_no"></td>
        							</tr>
    							</table>
								</form>
                                </div>
                            </div>
                        </div>
                    </div>
                	
                	<div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">list</h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                	<form action="io_status_ch" method="post" id="io_check_status">
                                    <table id="example" class="display" style="min-width: 845px">
                                        <thead>
                                            <tr>
                                            	<th>선택</th>
                                                <th>입고 코드</th>
                                                <th>회사</th>
                                                <th>상세정보</th>
                                                <th>수량</th>
                                                <th>입고일</th>
                                                <th>반품일</th>
                                                <th>상태</th>
                                                <th>거래명세서여부</th>
                                            </tr>
                                        </thead>
                                        <c:forEach items="${in}" var="in">
                                        <tbody>
                                               <tr>
                                            	<td><input type="checkbox" name="iocheck" value="${in.io_id},${in.obtain_no},${in.io_status},${in.io_quantity},${in.ma_id}"></td>
                                                <td>io-${in.io_id}</td>
                                                <td>${in.partner_companyname}</td>
                                                <td>${in.io_information}</td>
                                                <td>${in.io_quantity}</td>
                                                <td>${in.io_date}</td>
                                                <td>${empty in.io_retrun_date ? '-': in.io_retrun_date}</td>
                                                <td>${in.io_status}</td>
                                                <td>${in.invoice_issuance_status}</td>
                                            </tr>
                                            
                                        </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                            	<th>선택</th>
												<th>입고 코드</th>
                                                <th>회사</th>
                                                <th>상세정보</th>
                                                <th>수량</th>
                                                <th>입고일</th>
                                                <th>반품일</th>
                                                <th>상태</th>
                                                <th>거래명세서여부</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
<!--modal page-->
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
                                            	<th align="center"> ◎ </th>
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
        												}'>
												</td>
												<td>${list.obtain_no}</td>
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
      							</div>
    						</div>
  					 	</div>
					</div>
                	
                	
                </div>
      			
      		
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
 
  
 .t1 {
  border: 1px solid black;
  border-collapse: collapse;
  
}

/* 테이블 전체 스타일 */
        .table {
            width: 100%; /* 테이블 너비를 100%로 설정 */
        }
        /* td의 너비 조정 */
        td {
            padding: 8px;
        }
        /* input 및 textarea의 너비 조정 */
        input[type="text"], input[type="date"], textarea {
            width: 100%; /* td에 맞춰서 너비를 100%로 설정 */
            box-sizing: border-box; /* 패딩과 테두리를 포함한 너비 계산 */
        }

	
	</style>
	<script type="text/javascript">
    const modal = document.querySelector("#modal");
    const btn = document.querySelector("#modal-btn");
    const close = document.getElementById("close");
    const f_btn = document.getElementById("insert-btn");
    const io_btn = document.getElementById("io-check-btn");
    const billing_btn = document.getElementById("transaction-btn");

    billing_btn.onclick = function() {
        var checkboxes = document.querySelectorAll('input[name="iocheck"]:checked');

        if (checkboxes.length > 0) {
            var list = [];
            // 모든 체크박스의 상태를 리스트에 추가합니다.
            checkboxes.forEach(function(checkbox) {
                var pop = checkbox.value.split(",");
                if (pop.length === 5) {
                    list.push({
                        io_status: pop[2]
                    });
                }
            });

            // 리스트의 모든 항목이 '입고중'인지 확인합니다.
            var check = list.every(function(item) {
                return item.io_status === '입고완료';
            });

            if (check) {
                // 선택된 체크박스의 값을 배열로 수집합니다.
                checkboxes.forEach(function(checkbox) {
                    var pop = checkbox.value.split(",");
                    if (pop.length === 5) {
                        var obtain_no = pop[1];
                        var io_status = pop[2];

                        // 각각의 팝업창을 띄웁니다.
                        var queryString = 'obtain_no=' + encodeURIComponent(obtain_no);
                        const options = 'width=900, height=850, top=100, left=600, scrollbars=yes';
                        // 각 체크박스에 대해 개별 팝업창 열기
                        window.open('transaction?' + queryString, '_blank', options);
                       console.log(checkbox);
                    }
                });
            } else {
                alert("선택 중 거래명세서가 없는 값이 포함되어 있습니다.");
            }
        } else {
            alert("선택된 값이 없습니다.");
        }
    };

    //검수완료, 거래명세서, 구매발주서 활성화 
    io_btn.onclick = function() {
        var checkboxes = document.querySelectorAll('input[name="iocheck"]:checked');
        
        // 선택된 체크박스의 값을 배열로 수집합니다.
        var selectedData = [];
        checkboxes.forEach(function(checkbox) {
            var values = checkbox.value.split(",");
            if (values.length === 5) {
                selectedData.push({
                    io_id: values[0],
                    obtain_no: values[1],
                    io_status: values[2],
                    io_quantity: values[3],
                    ma_id: values[4]
                });
            }
        });

        if (selectedData.length > 0) {
            var itemcheck = selectedData.every(function(item) {
                return item.io_status === '입고중';
            });

            if (itemcheck) {
                document.getElementById("io_check_status").submit();
            } else {
                alert("이미 처리된 데이터가 존재합니다.");
            }
        } else {
            alert("선택된 값이 없습니다.");
        }
    }

    // 포커스
    f_btn.onclick = function() {
        const imformation = document.getElementById("io_information");
        const date = document.getElementById("in_date");
        const input = document.getElementById("inp-1");

        if (imformation.value.trim() === '' || date.value.trim() === '' || input.value.trim() === '') {
            if (input.value.trim() === '') {
                input.focus();
            } else if (date.value.trim() === '') {
                date.focus();
            } else {
                imformation.focus();
            }
            alert("빈 값을 채워주세요.");
        } else {
            document.getElementById("insert_in").submit();
        }
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
        if (selectedRadio) {
            var selectedValue = JSON.parse(selectedRadio.value);

            document.getElementById('inp-1').value = selectedValue.obtain_no;
            document.getElementById('io_status').value = selectedValue.status;
            document.getElementById('io_quantity').value = selectedValue.quantity;
            document.getElementById('invoice_issuance_status').value = '미발행';
            document.getElementById('ma_name').value = selectedValue.name;
            document.getElementById('ma_id').value = selectedValue.ma_id;
            document.getElementById('ma_price').value = selectedValue.price;
            document.getElementById('obtain_no').value = selectedValue.obtain_no;
            document.getElementById('production_no').value = selectedValue.production;

            modal.style.display = "none";
        } else {
            console.log("선택된 항목이 없습니다.");
        }
    }

    var result = '${msg}'; // 이 부분은 서버에서 JSP로 전달된 변수를 가져오는 것 같습니다.
    
    if (result === 'success') {
        alert("입고처리 되었습니다. 리스트 목록을 확인해주세요");
    } else if (result === 'plus') {
        alert("입고완료");
    }
</script>

</body>

</html>