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

    <!-- 配置dtree -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui_ext/dtree/font/dtreefont.css">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <!-- 搜索条件 -->
        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">角色名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="roleName" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
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

        <!-- 表格工具栏 -->
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"><i
                        class="layui-icon layui-icon-add-1"></i>添加
                </button>
            </div>
        </script>

        <!-- 数据表格 -->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <!-- 行工具栏 -->
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="edit"><i
                    class="layui-icon layui-icon-edit"></i>编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete"><i
                    class="layui-icon layui-icon-close"></i>删除</a>
            <a class="layui-btn layui-btn-xs data-count-edit" lay-event="grantMenu"><i
                    class="layui-icon layui-icon-edit"></i>分配菜单</a>
        </script>

        <!-- 添加和修改窗口 -->
        <div style="display: none;padding: 5px" id="addOrUpdateWindow">
            <form class="layui-form" style="width:90%;" id="dataFrm" lay-filter="dataFrm">
                <div class="layui-form-item">
                    <label class="layui-form-label">角色名称</label>
                    <div class="layui-input-block">
                        <!-- 角色编号 -->
                        <input type="hidden" name="id">
                        <input type="text" name="roleName" lay-verify="required" autocomplete="off"
                               placeholder="请输入角色名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">角色备注</label>
                    <div class="layui-input-block">
                        <textarea class="layui-textarea" name="roleDesc" id="roleDesc"></textarea>
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

        <!-- 分配菜单的弹出层 开始 -->
        <div style="display: none;" id="selectRoleMenuDiv">
            <ul id="roleTree" class="dtree" data-id="0"></ul>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>

    layui.extend({
        dtree: '${pageContext.request.contextPath}/statics/layui_ext/dtree/dtree',//dtree.js（脚本）路径
    }).use(['form', 'table', 'laydate', 'jquery', 'layer', 'dtree'], function () {
        var $ = layui.jquery,
            form = layui.form,
            laydate = layui.laydate,
            dtree = layui.dtree,
            layer = layui.layer,
            table = layui.table;

        //渲染表格组件
        var tableIns = table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/admin/role/list',
            toolbar: '#toolbarDemo',
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 100, title: '角色编号', align: "center"},
                {field: 'roleName', minWidth: 150, title: '角色名称', align: "center"},
                {field: 'roleDesc', minWidth: 200, title: '角色描述', align: "center"},
                {title: '操作', minWidth: 120, toolbar: '#currentTableBar', align: "center"}
            ]],
            page: true,
            //判断当前页码是否大于1
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

        //toolbar监听头部事件（添加）
        table.on('toolbar(currentTableFilter)', function (obj) {
            switch (obj.event) {
                case "add":
                    openAddWindow();
                    break;
            }
        });

        //监听工具栏（修改、删除、分配菜单）
        table.on('tool(currentTableFilter)', function (obj) {
            switch (obj.event) {
                case 'edit':
                    openUpdateWindow(obj.data);
                    break;
                case "delete":
                    deleteById(obj.data);
                    break;
                case 'grantMenu':
                    openGrantMenuWindow(obj.data);
                    break;
            };
        });

        var url;//提交地址
        var mainIndex;//打开窗口

        //添加完后到controller验证
        function openAddWindow() {
            mainIndex = layer.open({
                type: 1,
                title: "添加角色",
                area: ['800px', '400px'],//宽高
                content: $("#addOrUpdateWindow"),//内容
                success: function () {
                    //表单清空
                    $("#dataFrm")[0].reset();
                    url = "/admin/role/addRole";
                }
            })
        }

        //编辑（修改）
        function openUpdateWindow(data) {
            mainIndex = layer.open({
                type: 1,
                title: "修改角色",
                area: ['800px', '400px'],//宽高
                content: $("#addOrUpdateWindow"),//内容
                success: function () {
                    //数据回显
                    form.val("dataFrm", data);
                    url = "/admin/role/updateRole";
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

        //监听删除角色
        function deleteById(data) {
            $.get("/admin/role/checkRoleHasEmployee", {"id": data.id}, function (result) {
                //存在员工
                if (result.exist) {
                    //提示不能删
                    layer.msg(result.message);
                } else {
                    layer.confirm('您确定要删除【' + data.roleName + '】吗?', {icon: 3, title: '提示'}, function (index) {
                        //do something
                        $.post("/admin/role/deleteById", {"id": data.id}, function (result) {
                            //删除完成后要刷新页面，最后提示
                            if (result.success) {
                                //刷新数据
                                tableIns.reload();
                            }
                            //提示
                            layer.msg(result.message);
                        }, 'json')
                        layer.close(index);
                    });
                }
            }, 'json')
        }

        //分配菜单
        function openGrantMenuWindow(data) {
            mainIndex = layer.open({
                type: 1,//打开类型
                area: ["400px", "550px"],
                title: "分配[<font color='red'>" + data.roleName + "</font>]的菜单",
                content: $("#selectRoleMenuDiv"),//引用的内容窗口
                btn: ['确定', '取消']
                , yes: function (index, layero) {
                    //按钮【按钮一】的回调
                    //获取复选框菜单id的值
                    var params = dtree.getCheckbarNodesParam("roleTree");
                    //判断是否有值
                    if (params.length>0){
                        //定义数组，保存数据
                        var idArr=[];
                        for (var i = 0; i < params.length; i++) {
                            idArr.push(params[i].nodeId)
                        }
                        //将数据转换成字符串
                        var ids=idArr.join(",");
                        //发送ajax请求，给后台处理
                        $.post("/admin/role/saveRoleMenu",{"ids":ids,"roleId":data.id},function (result) {
                            layer.msg(result.message);
                        },"json")
                    }else {
                        layer.msg("请您选择分配的菜单哈");
                    }

                }
                , btn2: function (index, layero) {
                    //按钮【按钮二】的回调
                    //return false 开启该代码可禁止点击该按钮关闭
                },
                success: function () {
                    //渲染dtree组件
                    dtree.render({
                        elem: "#roleTree",//绑定ul标签的ID属性值
                        url: "/admin/role/initMenuTree?roleId=" + data.id, //请求地址
                        dataStyle: "layuiStyle", //使用layui风格的数据格式
                        dataFormat: "list", //配置data的风格为list
                        response: {message: "msg", statusCode: 0}, //修改response中返回数据的定义
                        //复选框状态
                        checkbar: true,
                        checkbarType: "all" // 默认就是all，其他的值为： no-all p-casc self  only
                    });
                }
            });
        }
    });
</script>

</body>
</html>
