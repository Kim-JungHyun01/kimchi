<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>


<!DOCTYPE html>
<html lang="ko"> 
<head>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.1/chart.min.js"></script>
    
    <style>
        #myChart {
            width: 100%;
            height: 400px;
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <h1>자재 차트</h1>
    <form id="chartForm">
        <input type="date" id="startDate" name="startDate">
        <input type="date" id="endDate" name="endDate">
        <button type="button" id="loadChart">차트 업데이트</button>
    </form>
    <canvas id="myChart"></canvas>

    <script>
    let myChart; // 전역 변수로 차트 인스턴스 유지

    function fetchData(startDate, endDate) {
    	console.log("1");
        $.ajax({
            url: '/calender/chart',
            data: { startDate: startDate, endDate: endDate },
            
            success: function(chartData) {
                console.log(chartData); // 데이터 확인
                
                if (chartData.length === 0) {
                    alert("No data available for the selected dates.");
                    return;
                }

                const labels = chartData.map(data => data.date); // 날짜 필드 사용
                const totalQuantity = chartData.map(data => data.totalQuantity);
                const totalValue = chartData.map(data => data.totalValue);

                console.log(labels);
                const data = {
                    labels: labels,
                    datasets: [
                        {
                            label: '총 재고 수량',
                            data: totalQuantity,
                            borderColor: 'rgba(75, 192, 192, 1)',
                            backgroundColor: 'rgba(75, 192, 192, 0.2)',
                            borderWidth: 1,
                            yAxisID: 'y1'
                        },
                        {
                            label: '총 재고 금액',
                            data: totalValue,
                            borderColor: 'rgba(255, 99, 132, 1)',
                            backgroundColor: 'rgba(255, 99, 132, 0.2)',
                            borderWidth: 1,
                            yAxisID: 'y2'
                        }
                    ]
                };

                const options = {
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'top',
                        },
                        tooltip: {
                            callbacks: {
                                label: function(tooltipItem) {
                                    const datasetLabel = tooltipItem.dataset.label || '';
                                    const value = tooltipItem.raw;
                                    return `${datasetLabel}: ${value}`;
                                }
                            }
                        }
                    },
                    scales: {
                        x: {
                            type: 'time',
                            time: {
                                unit: 'day'
                            },
                            title: {
                                display: true,
                                text: '날짜'
                            }
                        },
                        y1: {
                            beginAtZero: true,
                            title: {
                                display: true,
                                text: '총 재고 수량'
                            },
                            position: 'left'
                        },
                        y2: {
                            beginAtZero: true,
                            title: {
                                display: true,
                                text: '총 재고 금액'
                            },
                            position: 'right'
                        }
                    }
                };

                const ctx = document.getElementById('myChart').getContext('2d');
                
                if (myChart) {
                    myChart.destroy();
                }

                myChart = new Chart(ctx, {
                    type: 'line',
                    data: data,
                    options: options
                });
            },
            error: function(xhr, status, error) {
                console.error("AJAX 요청 오류:", status, error);
                alert("데이터를 가져오는 데 문제가 발생했습니다.");
            }
        });
    }

    $(document).ready(function() {
        const today = new Date().toISOString().split('T')[0]; // 오늘 날짜를 YYYY-MM-DD 형식으로
        $('#startDate').val(today); // 시작일에 오늘 날짜 설정
        $('#endDate').val(today); // 종료일에 오늘 날짜 설정
        fetchData(today, today); // 오늘 날짜로 불러옴

        // 차트 업데이트 버튼 클릭 이벤트
        $('#loadChart').click(function() {
            const startDate = $('#startDate').val();
            const endDate = $('#endDate').val();
            fetchData(startDate, endDate);
        });
    });
   
    </script>
        <!-- 필요한 스크립트 파일들 -->
    <script src="${contextPath}/resources/vendor/global/global.min.js"></script>
    <script src="${contextPath}/resources/js/quixnav-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="${contextPath}/resources/js/custom.min.js"></script>
    
</body>
</html>
