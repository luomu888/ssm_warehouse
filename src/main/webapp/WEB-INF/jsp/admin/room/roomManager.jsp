<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/css/layui.css"
          media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/public.css" media="all">
    <style>
        .thumbBox {
            height: 200px;
            overflow: hidden;
            border: 1px solid #e6e6e6;
            border-radius: 2px;
            cursor: pointer;
            position: relative;
            text-align: center;
            line-height: 200px;
            width: 210px;
        }

        .thumbImg {
            max-width: 100%;
            max-height: 100%;
            border: none;
        }

        .thumbBox:after {
            position: absolute;
            width: 100%;
            height: 100%;
            line-height: 200px;
            z-index: -1;
            text-align: center;
            font-size: 20px;
            content: "缩略图";
            left: 0;
            top: 0;
            color: #9F9F9F;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <%-- 搜索条件 --%>
        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">库房编号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="roomNum" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">库房名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="roomName" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">所属楼层</label>
                            <div class="layui-input-inline">
                                <select name="floorId" id="s_floorId" autocomplete="off" class="layui-input">
                                    <option value="">全部</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">库房商品</label>
                            <div class="layui-input-inline">
                                <select name="goodId" id="s_status" autocomplete="off" class="layui-input">
                                    <option value="">全部</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block" style="text-align: center">
                            <button type="submit" class="layui-btn" lay-submit lay-filter="data-search-btn"><i
                                    class="layui-icon layui-icon-search"></i>搜索
                            </button>
                            <button type="reset" class="layui-btn layui-btn-warm"><i
                                    class="layui-icon layui-icon-refresh-1"></i>重置
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <%-- 表格工具栏 --%>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"><i
                        class="layui-icon layui-icon-add-1"></i>添加
                </button>
            </div>
        </script>

        <%-- 数据表格 --%>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <%-- 行工具栏 --%>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit"><i
                    class="layui-icon layui-icon-edit"></i>编辑</a>
        </script>

        <%-- 添加和修改窗口 --%>
        <div style="display: none;padding: 5px" id="addOrUpdateWindow">
            <form class="layui-form" style="width:90%;" id="dataFrm" lay-filter="dataFrm">
                <!-- 隐藏域，保存库房id -->
                <input type="hidden" name="id">
                <div class="layui-col-md12 layui-col-xs12">
                    <div class="layui-row layui-col-space10">
                        <div class="layui-col-md9 layui-col-xs7">
                            <div class="layui-form-item magt3" style="margin-top: 8px;">
                                <label class="layui-form-label">库房编号</label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input" name="roomNum" lay-verify="required"
                                           placeholder="请输入库房编号">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">库房名称</label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input" name="roomName" lay-verify="required"
                                           placeholder="请输入库房名称">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item magb0">
                        <div class="layui-inline">
                            <label class="layui-form-label">所属楼层</label>
                            <div class="layui-input-inline">
                                <select name="floorId" id="floorId" lay-verify="required">
                                    <option value="">请选择楼层</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">库房商品</label>
                            <div class="layui-input-inline">
                                <select name="goodId" id="goodId" lay-verify="required">
                                    <option value="">请选择库房商品</option>
                                </select>
                            </div>
                        </div>

                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block" style="text-align: center;">
                            <button type="button" class="layui-btn" lay-submit lay-filter="doSubmit" id="doSubmit"><span
                                    class="layui-icon layui-icon-add-1"></span>提交
                            </button>
                            <button type="reset" class="layui-btn layui-btn-warm"><span
                                    class="layui-icon layui-icon-refresh-1"></span>重置
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table', 'laydate', 'jquery', 'layer', 'upload', 'layedit'], function () {
        var $ = layui.jquery,
            form = layui.form,
            laydate = layui.laydate,
            upload = layui.upload,
            layedit = layui.layedit,
            layer = layui.layer,
            table = layui.table;

        //渲染表格组件
        var tableIns = table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/admin/room/list',
            toolbar: '#toolbarDemo',
            cols: [[
                {field: 'id', width: 60, title: '编号', align: "center"},
                {field: 'roomNum', minWidth: 120, title: '库房编号', align: "center"},
                {field: 'roomName', minWidth: 100, title: '库房名称', align: "center"},
                {field: 'floorName', minWidth: 100, title: '所属楼层', align: "center",},
                {field: 'goodName', minWidth: 100, title: '库房商品', align: "center"},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            page: true,
            done: function (res, curr, count) {
                //判断当前页码是否是大于1并且当前页的数据量为0
                if (curr > 1 && res.data.length == 0) {
                    var pageValue = curr - 1;
                    //刷新数据表格的数据
                    tableIns.reload({
                        page: {curr: pageValue}
                    });
                }
            }
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            tableIns.reload({
                where: data.field,
                page: {
                    curr: 1
                }
            });
            return false;
        });

        //发送ajax请求查询库房商品下拉列表
        $.post("/admin/good/findAll", function (result) {
            var html = "";
            //循环遍历
            for (var i = 0; i < result.length; i++) {
                html += "<option value='" + result[i].id + "'>" + result[i].goodName + "</option>";
            }
            //追加给select
            $("[name='goodId']").append(html);
            //刷新数据（就是渲染）
            form.render("select");
        }, 'json')

        //发送ajax请求查询楼层下拉列表
        $.post("/admin/floor/findAll", function (result) {
            var html = "";
            //循环遍历
            for (var i = 0; i < result.length; i++) {
                html += "<option value='" + result[i].id + "'>" + result[i].name + "</option>";
            }
            //追加给select
            $("[name='floorId']").append(html);
            //刷新数据（就是渲染）
            form.render("select");
        }, 'json')

        //toolbar监听头部事件（添加）
        table.on('toolbar(currentTableFilter)', function (obj) {
            switch (obj.event) {
                case "add":
                    openAddWindow();
                    break;
            }
        });

        //监听行工具栏的编辑
        table.on('tool(currentTableFilter)', function (obj) {
            switch (obj.event) {
                case "edit":
                    openUpdateWindow(obj.data);
                    break;
                case "delete":
                    deleteById(obj.data);
                    break;
            }
        });

        var url;//提交地址
        var mainIndex;//打开窗口

        //添加完后到controller验证
        function openAddWindow() {
            mainIndex = layer.open({
                type: 1,
                title: "添加库房",
                area: ['800px', '400px'],//宽高
                content: $("#addOrUpdateWindow"),//内容
                success: function () {
                    //表单清空
                    $("#dataFrm")[0].reset();
                    url = "/admin/room/addRoom";
                }
            })
        }

        //编辑页面
        function openUpdateWindow(data) {
            mainIndex = layer.open({
                type: 1,
                title: "修改库房",
                area: ['800px', '400px'],//宽高
                content: $("#addOrUpdateWindow"),//内容
                success: function () {
                    //数据回显
                    form.val("dataFrm", data);
                    url = "/admin/room/updateRoom";
                }
            })
        }

        //监听提交（此时Controller已验证完）
        form.on('submit(doSubmit)', function (obj) {
            $.post(url, obj.field, function (result) {
                if (result.success) {
                    //刷新数据
                    tableIns.reload();
                    //回到之前的页面（退出添加）
                    layer.close(mainIndex);
                }
                //提示
                layer.msg(result.message);
            }, 'json');
            //禁止页面刷新
            return false;
        });

    });
</script>

</body>
</html>
