<!--**********************************
            Content body end
        ***********************************-->

		<!--**********************************
            Footer start
        ***********************************-->

	<div class="footer">
		<div class="copyright">
			<p>
				Copyright © Designed &amp; Developed by <a href="#" target="_blank">Quixkit</a>
				2019
			</p>
		</div>
	</div>
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
	<script type="text/javascript">
		$(document).ready(function(){
			$("ul#menu a").on('click',function(){
				$("ul#menu a").removeClass("mm-active");
				$(this).addClass("mm-active");
			})
		})
	</script>
</body>
	
</html>