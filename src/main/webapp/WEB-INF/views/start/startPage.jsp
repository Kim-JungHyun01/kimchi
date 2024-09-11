<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<script>
	function checkapp() {
		var user_approval = document.getElementById('login_user_approval').value;
		var partner_approval = document.getElementById('login_partner_approval').value;

<%@include file="../include/header.jsp" %>

<style>
    .carousel-item img { /* 슬라이드 이미지 크기 설정 */
        height: 300px; /* 원하는 높이로 설정 */
        object-fit: contain; /* 비율을 유지하면서 이미지가 작아지도록 설정 */
        width: 100%; /* 너비는 100%로 설정 */
        display: block; /* 이미지의 아래 여백 제거 */
    }
</style>

<div class="content-body">

   <!-- 사진 슬라이드 -->
<div id="carouselExample" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="${contextPath}/resources/images/kimchi/main/메인.jpg" class="d-block w-100" alt="Slide 1">
        </div>
        <div class="carousel-item">
            <img src="${contextPath}/resources/images/kimchi/main/메인2.jpg" class="d-block w-100" alt="Slide 2">
        </div>
        <div class="carousel-item">
            <img src="${contextPath}/resources/images/kimchi/factory/김치공장4.jpg" class="d-block w-100" alt="Slide 3">
        </div>
        <div class="carousel-item">
            <img src="${contextPath}/resources/images/kimchi/factory/김치공장6.jpg" class="d-block w-100" alt="Slide 3">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExample" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExample" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<!-- 콘텐츠 사진 3개씩 2열 배치 -->
<!-- <div class="content-gallery" style="display: flex; flex-wrap: wrap; margin-top: 20px;">  -->

   <!--   <div style="flex: 1 0 30%; margin: 10px; text-align: center;">   
        <a href="링크1" style="display: block;">
		    <img src="${contextPath}/resources/images/content1.jpg" style="width: 100%;" alt="Content 1">
		    <p>설명 1</p>
		</a>
	</div>  -->



<%@include file="../include/footer.jsp" %>

<!-- Required vendors -->
<script src="${contextPath}/resources/vendor/global/global.min.js"></script>
<script src="${contextPath}/resources/js/quixnav-init.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> <!-- 전체 jQuery 버전 사용 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/custom.min.js"></script>

<script>
    function customFadeOut(element, duration) {
        let opacity = 1;
        const interval = 1000 / 60; // 60fps
        const increment = interval / duration;

        function animate() {
            opacity -= increment;
            if (opacity <= 0) {
                opacity = 0;
                element.style.display = 'none'; // 숨김 처리
            }
            element.style.opacity = opacity;
            if (opacity > 0) {
                requestAnimationFrame(animate);
            }
        }

        requestAnimationFrame(animate);
    }

    // 슬라이드 전환 시 애니메이션 적용
    $('#carouselExample').on('slid.bs.carousel', function (e) {
    const currentElement = $(e.target).find('.active img')[0];
	});
</script>

</body>
</html>
