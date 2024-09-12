<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <div style="width: 900px; height: 900px;">
        <canvas id="myChart"></canvas>
    </div>

    <script>
    let myChart; // 전역 변수로 차트 인스턴스 유지

    function fetchData() {
        // 하드코딩된 데이터
        const labels = ['2024-09-08', '2024-09-09', '2024-09-10', '2024-09-11', '2024-09-12', '2024-09-13'];
        const totalQuantity = [50, 500, 500, 400, 300, 600];
        const totalValue = [100, 1000, 1000, 850, 750, 1500];

        const data = {
            labels: labels,
            datasets: [
                {
                    type: 'bar',
                    label: '총 재고 수량',
                    data: totalQuantity,
                    borderColor: 'rgba(75, 192, 192, 1)',
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderWidth: 1,
                    yAxisID: 'y1'
                },
                {
                    type: 'line',
                    label: '총 재고 금액',
                    data: totalValue,
                    borderColor: 'rgba(255, 99, 132, 1)',
                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
                    borderWidth: 2,
                    yAxisID: 'y2'
                }
            ]
        };

        const options = {
            responsive: true,
            scales: {
                x: {
                    type: 'category',
                    title: {
                        display: true,
                        text: '날짜'
                    }
                },
                y: {
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
            }
        };

        const ctx = document.getElementById('myChart').getContext('2d');
        
        if (myChart) {
            myChart.destroy();
        }

        myChart = new Chart(ctx, {
            type: 'bar', 
            data: data,
            options: options
        });
    }

    $(document).ready(function() {
        fetchData();
    });
    </script>
</body>
</html>
