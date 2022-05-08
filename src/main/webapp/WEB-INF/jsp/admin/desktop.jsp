<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页三</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/public.css" media="all">
    <style>
        .top-panel {
            border: 1px solid #eceff9;
            border-radius: 5px;
            text-align: center;
        }
        .top-panel > .layui-card-body{
            height: 60px;
        }
        .top-panel-number{
            line-height:60px;
            font-size: 30px;
            border-right:1px solid #eceff9;
        }
        .top-panel-tips{
            line-height:30px;
            font-size: 12px
        }
    </style>
</head>
<body>
<!--<div class="layuimini-container">-->
<div class="layuimini-main">

    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-md3">

            <div class="layui-card top-panel">
                <div class="layui-card-header">批发零售营销</div>
                <div class="layui-card-body">
                    <div class="layui-row layui-col-space5">
                        <div class="layui-col-xs9 layui-col-md9 top-panel-number">
                            9,054,056
                        </div>
                        <div class="layui-col-xs3 layui-col-md3 top-panel-tips">
                            比昨天 <a style="color: #1aa094">▲0.12</a><br>
                            比七日 <a style="color: #bd3004">▼0.06</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="layui-col-xs12 layui-col-md3">

            <div class="layui-card top-panel">
                <div class="layui-card-header">固定商家购入</div>
                <div class="layui-card-body">
                    <div class="layui-row layui-col-space5">
                        <div class="layui-col-xs9 layui-col-md9 top-panel-number">
                            16,454,334
                        </div>
                        <div class="layui-col-xs3 layui-col-md3 top-panel-tips">
                            比昨天 <a style="color: #1aa094">▲0.22</a><br>
                            比七日 <a style="color: #bd3004">▼0.16</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="layui-col-xs12 layui-col-md3">

            <div class="layui-card top-panel">
                <div class="layui-card-header">直销分享售出</div>
                <div class="layui-card-body">
                    <div class="layui-row layui-col-space5">
                        <div class="layui-col-xs9 layui-col-md9 top-panel-number">
                            3,044,052
                        </div>
                        <div class="layui-col-xs3 layui-col-md3 top-panel-tips">
                            比昨天 <a style="color: #1aa094">▲0.53</a><br>
                            比七日 <a style="color: #bd3004">▼0.36</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="layui-col-xs12 layui-col-md3">

            <div class="layui-card top-panel">
                <div class="layui-card-header">微商及网络直播</div>
                <div class="layui-card-body">
                    <div class="layui-row layui-col-space5">
                        <div class="layui-col-xs9 layui-col-md9 top-panel-number">
                            1,344,052
                        </div>
                        <div class="layui-col-xs3 layui-col-md3 top-panel-tips">
                            比昨天 <a style="color: #1aa094">▲0.02</a><br>
                            比七日 <a style="color: #bd3004">▼0.66</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-md9">
            <div id="echarts-records" style="background-color:#ffffff;min-height:400px;padding: 10px"></div>
        </div>
        <div class="layui-col-xs12 layui-col-md3">
            <div id="echarts-pies" style="background-color:#ffffff;min-height:400px;padding: 10px"></div>
        </div>
    </div>


    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-md6">
            <div id="echarts-dataset" style="background-color:#ffffff;min-height:300px;padding: 10px"></div>
        </div>
        <div class="layui-col-xs12 layui-col-md6">
            <div id="echarts-map" style="background-color:#ffffff;min-height:300px;padding: 10px"></div>
        </div>
    </div>


</div>
<!--</div>-->
<script src="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/statics/layui/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['layer', 'echarts'], function () {
        var $ = layui.jquery,
            layer = layui.layer,
            echarts = layui.echarts;

        /**
         * 报表功能
         */
        var echartsRecords = echarts.init(document.getElementById('echarts-records'), 'walden');

        var optionRecords = {
            title: {
                text: '主要收入-报表图'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            legend: {
                data: ['批发零售', '商家购入', '直销分享', '微商直播', '访问流量']
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: false,
                    data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '批发零售',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: [120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name: '商家购入',
                    type: 'line',
                    areaStyle: {},
                    data: [220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name: '直销分享',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: [150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name: '微商直播',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {},
                    data: [320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name: '访问流量',
                    type: 'line',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'top'
                        }
                    },
                    areaStyle: {},
                    data: [820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        echartsRecords.setOption(optionRecords);


        /**
         * 玫瑰图表
         */
        var echartsPies = echarts.init(document.getElementById('echarts-pies'), 'walden');
        var optionPies = {
            title: {
                text: '流量访问-玫瑰图',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{a} <br/>{b} : {c} ({d}%)'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
            },
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    roseType: 'radius',
                    data: [
                        {value: 335, name: '直接访问'},
                        {value: 310, name: '邮件营销'},
                        {value: 234, name: '联盟广告'},
                        {value: 135, name: '视频广告'},
                        {value: 368, name: '搜索引擎'}
                    ],
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        echartsPies.setOption(optionPies);


        /**
         * 柱状图
         */
        var echartsDataset = echarts.init(document.getElementById('echarts-dataset'), 'walden');

        var optionDataset = {
            legend: {},
            tooltip: {},
            dataset: {
                dimensions: ['product', '2020', '2021', '2022'],
                source: [
                    {product: '品牌手机', '2020': 43.3, '2021': 85.8, '2022': 93.7},
                    {product: '平板电脑', '2020': 83.1, '2021': 73.4, '2022': 55.1},
                    {product: '硬件设备', '2020': 86.4, '2021': 65.2, '2022': 82.5},
                    {product: '外接产品', '2020': 72.4, '2021': 53.9, '2022': 39.1}
                ]
            },
            xAxis: {type: 'category'},
            yAxis: {},
            // Declare several bar series, each will be mapped
            // to a column of dataset.source by default.
            series: [
                {type: 'bar'},
                {type: 'bar'},
                {type: 'bar'}
            ]
        };

        echartsDataset.setOption(optionDataset);


        /**
         * 中国地图
         */
        var echartsMap = echarts.init(document.getElementById('echarts-map'), 'walden');


        var optionMap = {
            legend: {},
            tooltip: {
                trigger: 'axis',
                showContent: false
            },
            dataset: {
                source: [
                    ['product', '2017', '2018', '2019', '2020', '2021', '2022'],
                    ['品牌手机', 41.1, 30.4, 65.1, 53.3, 83.8, 98.7],
                    ['平板电脑', 86.5, 92.1, 85.7, 83.1, 73.4, 55.1],
                    ['硬件设备', 24.1, 67.2, 79.5, 86.4, 65.2, 82.5],
                    ['外接产品', 55.2, 67.1, 69.2, 72.4, 53.9, 39.1]
                ]
            },
            xAxis: {type: 'category'},
            yAxis: {gridIndex: 0},
            grid: {top: '55%'},
            series: [
                {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                {
                    type: 'pie',
                    id: 'pie',
                    radius: '30%',
                    center: ['50%', '25%'],
                    label: {
                        formatter: '{b}: {@2017} ({d}%)'
                    },
                    encode: {
                        itemName: 'product',
                        value: '2017',
                        tooltip: '2017'
                    }
                }
            ]
        };

        echartsMap.setOption(optionMap);


        // echarts 窗口缩放自适应
        window.onresize = function () {
            echartsRecords.resize();
        }

    });
</script>
</body>
</html>
