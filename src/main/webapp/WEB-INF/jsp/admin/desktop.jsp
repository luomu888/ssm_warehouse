<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>ECharts</title>
    <!-- 引入刚刚下载的 ECharts 文件 -->
    <script src="${pageContext.request.contextPath}/statics/layui/echarts.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/statics/layui/jquery-1.8.3.min.js" charset="utf-8"></script>

</head>
<body>
    <!-- 为 ECharts 准备一个定义了宽高的 DOM -->
    <div id="main" style="width: 1700px;height:800px;"></div>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                "url":"/admin/good/getGoodBarVO",
                "types":"POST",
                "success":function (data) {
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('main'));

                    // 指定图表的配置项和数据
                    var option = {
                        title: {
                            text: '库存图表'
                        },
                        tooltip: {},
                        legend: {
                            data: ['库存']
                        },
                        xAxis: {
                            data: data.names
                        },
                        yAxis: {},
                        series: [
                            {
                                name: '库存',
                                type: 'bar',
                                data: data.values
                            }
                        ]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                }
            });
        })

    </script>
</body>
</html>