<%--
  Created by IntelliJ IDEA.
  User: dqyy
  Date: 2019/11/8
  Time: 11:49 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理者页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <script src="/airsys/assets/js/echarts.js"></script>
    <script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>


</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" class="main" style="height:400px;"></div>

<div id="year" style="height:400px;"></div>


<script>


    var i = '2017';
    var t = '2018';
    var x = '2019';
    datasum = []
    data19 = []
    data18 = []
    data17 = []


    <!--2019-->
    $.ajax({
        url: "businesspointsumdata",
        dataType: 'json',
        data: {year: x},
        success: function (msg) {
            data19 = msg
            tubiao(datasum, data19, data18, data17)

        }
    });

    <!--2018-->

    $.ajax({
        url: "businesspointsumdata",
        dataType: 'json',
        data: {year: t},
        success: function (msg) {
            data18 = msg
            tubiao(datasum, data19, data18, data17)

        }
    });

    <!--2017-->
    $.ajax({
        url: "businesspointsumdata",
        dataType: 'json',
        data: {year: i},
        success: function (msg) {
            data17 = msg
            tubiao(datasum, data19, data18, data17)

        }
    });


    $.ajax({
        url: "businesspointsumname",
        dataType: 'json',
        data: {year: x},
        success: function (msg) {
            datasum = msg
            tubiao(datasum, data19, data18, data17)

        }
    });
    // //定义data变量
    // data = [];
    // datasum = [];
    // //获取营业点信息
    // $.ajax({
    //     url: "boss/businesspoint",
    //     dataType: "json",
    //     success: function (msg) {
    //         $.each(msg, function (index, value) {
    //             data.push(value.bName);
    //         });
    //         //调用图表函数
    //         tubiao(data,datasum);
    //     }
    //
    //
    // });
    //
    // $.ajax({
    //     url: "boss/businesspointsum",
    //     dataType: "json",
    //     success: function (msg) {
    //
    //         $.each(msg, function (index, value) {
    //             datasum.push(value.piao);
    //         });
    //         //调用图表函数
    //         tubiao(data,datasum);
    //
    //     }
    // });
    //营业点图表函数
    function tubiao(datasum, data19, data18, data17) {

        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据

        var option = {
            title: {
                text: '各个渠道销售量',
                subtext: '数据来自各个渠道售票点'
            },
            tooltip: {},

            legend: {

                data: []
            },

            xAxis: {
                data: datasum

            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: data19
            }]

        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        var myChart = echarts.init(document.getElementById('year'));

        var option = {
            title: {
                text: '年销量总量',
                subtext: '数据来自各个渠道售票点'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {
                data: [i, t, x]
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: {
                type: 'value',
                boundaryGap: [0, 0.01]
            },
            yAxis: {
                type: 'category',
                data: datasum
            },
            series: [
                {
                    name: i,
                    type: 'bar',
                    data: data17
                },
                {
                    name: t,
                    type: 'bar',
                    data: data18
                },
                {
                    name: x,
                    type: 'bar',
                    data: data19
                }
            ]
        };
        myChart.setOption(option);

    }


</script>


</body>
</html>
