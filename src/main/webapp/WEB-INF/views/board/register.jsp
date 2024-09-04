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
      
        <!--**********************************
            Content body end
        ***********************************-->


   <div class="content-body">


      


<form role="form" method="post">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail">Title</label> <input type="text"
				name='board_title' class="from-control" placeholder="Enter Title">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="from-control" name="board_content" rows="3" placeholder=""Enter ..."></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Comment</label> <input type="text"
				name="board_comment" class="form-control" placeholder="Enter Writer">
		</div>
		
	
		
		</div>
		<!-- /.box-body -->
		
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">
				Submit
				</button>
		</div>
		
</form>

  
        
</div>

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

</body>

</html>