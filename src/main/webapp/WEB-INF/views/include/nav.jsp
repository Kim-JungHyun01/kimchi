<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<div class="quixnav">
            <div class="quixnav-scroll">
                <ul class="metismenu" id="menu">
                    <li class="nav-label first">Main Menu</li>
                    <!-- <li><a href="index.html"><i class="icon icon-single-04"></i><span class="nav-text">Dashboard</span></a>
                    </li> -->
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-single-04"></i><span class="nav-text">Dashboard</span></a>
                        <ul aria-expanded="false">
                            <li><a href="${contextPath}/start">Dashboard 1</a></li>
                            <li><a href="${contextPath}/resources/index2.html">Dashboard 2</a></li>
                        </ul>
                    </li>

                    <li class="nav-label">입고</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-app-store"></i><span class="nav-text">입고</span></a>
                        <ul aria-expanded="false">
                            <li><a class="has-arrow" href="${contextPath}/resources/app-profile.html">자재재고</a></li>
                            <li><a class="has-arrow" href="imformation" >입출고정보</a>
                            </li>
                            <li><a class="has-arrow" href="${contextPath}/resources/app-calender.html">자재입고관리</a></li>
                        </ul>
                    </li>
                    
            </div>
        </div>