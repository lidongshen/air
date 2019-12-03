<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Boss页面</title>
    <link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
    <script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>

</head>
<body class="layui-layout-body">


<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">Boss管理页面</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    Boss
                </a>

            </li>
            <li class="layui-nav-item"><a href="javascript:;" class="quit">安全退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">销售业绩</a>
                    <dl class="layui-nav-child">
                        <dd><a href="bossindex" target="ck">统计图表</a></dd>
                        <dd><a href="bostable" target="ck">销售总量</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">账户操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="xg" target="ck">修改密码</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe src="http://s9.rr.itc.cn/r/wapChange/20173_30_0/a7tcml39016969953405.jpg" frameborder="0" name="ck"
                id="demoAdmin" style="width: 100%; height: 100%;"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © - airsys项目 -
    </div>
</div>
<script>

    <%
        if (session.getAttribute("bossId")==null){
            response.sendRedirect("bslogin");
    }

%>

    // 退出询问框
    $(".quit").on("click", function () {
        layui.use('layer', function () {


            var layer = layui.layer;
            layer.confirm('确认退出?', {

                icon: 3,
                title: '提示',
                offset: '200px',
                resize: false,
                move: false,
                yes: function (index, layero) {
                    $.ajax({
                        url: "exitsession",
                        success: function (e) {
                            if (e == "ok") {
                                window.location.href = "bslogin"
                            }
                        }
                    }),
                        layer.close(index);
                }
                // 取消按钮
                , btn2: function (index, layero) {
                    layer.close(index);
                }
            });
        });
    })


</script>
<script src="/airsys/assets/layui/layui.js"></script>

<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>