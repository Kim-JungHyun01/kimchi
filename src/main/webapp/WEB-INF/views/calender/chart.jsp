<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
            background-color: #f4f4f4;
        }
        
        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }
        
        #startDate, #endDate {
            padding: 8px;
            margin-right: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        #loadChart {
            padding: 8px 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        #loadChart:hover {
            background-color: #0056b3;
        }
        
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
    <input type="date" id="startDate" name="startDate">
    <input type="date" id="endDate" name="endDate">
    <button id="loadChart">차트 업데이트</button>
    <canvas id="myChart"></canvas>

    <script>
    let myChart; // 전역 변수로 차트 인스턴스 유지

    function fetchData(startDate, endDate) {
        $.ajax({
            url: '/calender/chart',
            data: { startDate: startDate, endDate: endDate },
            success: function(chartData) {
                console.log(chartData); // 데이터 확인
                
                // 데이터 매핑
                const labels = chartData.map(c => c.ma_date);
                const totalQuantity = chartData.map(c => c.totalQuantity);
                const totalValue = chartData.map(c => c.totalValue);

                // 데이터 설정
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

                // 차트 옵션 설정
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
                            type: 'time', // 날짜를 위한 time scale 설정
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

                // 차트 생성
                const ctx = document.getElementById('myChart').getContext('2d');

                // 차트를 새로 생성하기 전에 기존 차트가 있는지 확인하고 제거합니다.
                if (myChart) {
                    myChart.destroy();
                }

                myChart = new Chart(ctx, {
                    type: 'line', // 차트 유형 설정
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

    // 초기 데이터 로드
    $(document).ready(function() {
        fetchData(null, null); // 초기값으로 전체 데이터 로드
    });

    // 차트 업데이트 버튼 클릭 이벤트
    $('#loadChart').click(function() {
        const startDate = $('#startDate').val();
        const endDate = $('#endDate').val();
        fetchData(startDate, endDate);
    });
    </script>
</body>
</html>
