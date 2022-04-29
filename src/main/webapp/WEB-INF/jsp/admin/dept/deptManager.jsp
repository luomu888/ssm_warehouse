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
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <%--搜索条件区域--%>
        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">部门名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="deptName" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn" lay-submit lay-filter="data-search-btn"><i
                                    class="layui-icon layui-icon-search"></i> 搜索
                            </button>
                            <button type="reset" class="layui-btn layui-btn-warm"><i
                                    class="layui-icon layui-icon-refresh-1"></i>重置
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <%--头部工具栏区域--%>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"><i
                        class="layui-icon layui-icon-add-1"></i>添加
                </button>
            </div>
        </script>

        <%--表格区域--%>
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <%--行工具栏区域--%>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit"><i
                    class="layui-icon layui-icon-edit"></i>编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete"><i
                    class="layui-icon layui-icon-delete"></i>删除</a>
        </script>

        <%-- 添加和修改窗口 --%>
        <div style="display: none;padding: 5px" id="addOrUpdateWindow">
            <form class="layui-form" style="width:90%;" id="dataFrm" lay-filter="dataFrm">
                <div class="layui-form-item">
                    <label class="layui-form-label">部门名称</label>
                    <div class="layui-input-block">
                        <%-- 隐藏域，知道修改和删除的id --%>
                        <input type="hidden" name="id">
                        <input type="text" name="deptName" lay-verify="required" autocomplete="off"
                               placeholder="请输入部门名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">部门地址</label>
                    <div class="layui-input-block">
                        <input type="text" name="address" lay-verify="required" autocomplete="off" placeholder="请输入部门地址"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">部门备注</label>
                    <div class="layui-input-block">
                        <textarea class="layui-textarea" name="remark" id="content"></textarea>
                    </div>
                </div>
                <div class="layui-form-item layui-row layui-col-xs12">
                    <div class="layui-input-block" style="text-align: center;">
                        <button type="button" class="layui-btn" lay-submit lay-filter="doSubmit"><span
                                class="layui-icon layui-icon-add-1"></span>提交
                        </button>
                        <button type="reset" class="layui-btn layui-btn-warm"><span
                                class="layui-icon layui-icon-refresh-1"></span>重置
                        </button>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table', 'layer'], function () {
        var $ = layui.jquery,
            form = layui.form,
            layer = layui.layer,
            table = layui.table;

        var tableIns = table.render({
            //表格区域的id
            elem: '#currentTableId',
            //异步接口
            url: '${pageContext.request.contextPath}/admin/dept/list',
            //工具栏id
            //若需要“列显示隐藏”、“导出”、“打印”等功能，则必须开启该参数
            toolbar: '#toolbarDemo',
            //设置表头
            cols: [[
                {field: 'id', width: 120, title: "部门编号", align: 'center'},
                {field: 'deptName', minWidth: 120, title: '部门名称', align: 'center'},
                {field: 'address', minWidth: 150, title: '部门地址', align: 'center'},
                {field: 'createDate', minWidth: 120, title: '创建时间', align: 'center'},
                {field: 'remark', minWidth: 120, title: '备注', align: 'center'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            //设置是否分页
            page: true,
            //加入此段代码，当最后一页的数据被删完后，自动返回到上一页
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
            //重新加载
            tableIns.reload({ //设定异步数据接口的额外参数，任意设
                where: data.field,
                page: {
                    curr: 1  //重新从第 1 页开始
                }
            });
            return false;
        });

        /**
         * toolbar监听头部事件（添加）
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            switch (obj.event) {
                case "add":
                    openAddWindow();
                    break;
            }
        });

        /**
         * 监听行工具栏的编辑和删除
         */
        table.on('tool(currentTableFilter)', function (obj) {
            console.log(obj)
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
                title: "添加部门",
                area: ['800px', '400px'],//宽高
                content: $("#addOrUpdateWindow"),//内容
                success: function () {
                    //表单清空
                    $("#dataFrm")[0].reset();
                    url = "/admin/dept/addDept";
                }
            })
        }

        //编辑页面
        function openUpdateWindow(data) {
            mainIndex = layer.open({
                type: 1,
                title: "添加部门",
                area: ['800px', '400px'],//宽高
                content: $("#addOrUpdateWindow"),//内容
                success: function () {
                    //数据回显
                    form.val("dataFrm", data);
                    url = "/admin/dept/updateDept";
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

        //删除部门
        function deleteById(data) {
            $.get("/admin/dept/checkDeptHasEmployee", {"id": data.id}, function (result) {
                //存在员工
                if (result.exist) {
                    //提示不能删
                    layer.msg(result.message);
                } else {
                    layer.confirm('你确定删除【' + data.deptName + '】吗', {icon: 3, title: '提示'}, function (index) {
                        //do something
                        $.post("/admin/dept/deleteById", {"id": data.id}, function (result) {
                            if (result.success) {
                                //刷新数据
                                tableIns.reload();
                            }
                            //提示
                            layer.msg(result.message);
                        }, 'json');
                        layer.close(index);
                    });
                }
            }, 'json');
        }

    });
</script>

</body>
</html>
