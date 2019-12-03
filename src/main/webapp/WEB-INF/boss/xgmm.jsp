<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
    <script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>

    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>修改用户名密码</legend>
</fieldset>

<form class="layui-form" action="xgmm" lay-filter="example" id="bg">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" readonly lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   id="name" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" name="password" lay-verify="password" placeholder="请输入密码" autocomplete="off"
                   class="layui-input" id="pd">
        </div>
    </div>


    <%--    <div class="layui-form-item">--%>
    <%--        <label class="layui-form-label">开关</label>--%>
    <%--        <div class="layui-input-block">--%>
    <%--            <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <%--    <div class="layui-form-item">--%>
    <%--        <label class="layui-form-label">单选框</label>--%>
    <%--        <div class="layui-input-block">--%>
    <%--            <input type="radio" name="sex" value="男" title="男" checked="">--%>
    <%--            <input type="radio" name="sex" value="女" title="女">--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--    <div class="layui-form-item layui-form-text">--%>
    <%--        <label class="layui-form-label">文本域</label>--%>
    <%--        <div class="layui-input-block">--%>
    <%--            <textarea placeholder="请输入内容" class="layui-textarea" name="desc"></textarea>--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <div class="layui-form-item">
        <div class="layui-input-block">

            <button type="submit" id="tijiao" class="layui-btn" lay-submit="" lay-filter="demo1">
                立即提交
            </button>
        </div>
    </div>
</form>

<script src="/airsys/assets/layui/layui.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit'], function () {
        var form = layui.form, layedit = layui.layedit

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 4) {
                    return '用户名至少5位';
                }
            }
            , password: function (value) {
                if (value.length < 6) {
                    return '密码最少6位，且不能出现空格';
                }
            }

        });
       

        //监听提交
        form.on('submit(demo1)', function (data) {

            $.ajax({

                url: "mmxx",
                data: data.field,
                type: 'POST',
                success: function (msg) {

                    if (msg == "ok") {
                        layer.msg("恭喜您，密码修改成功")
                    } else {
                        layer.msg("密码修改失败，请重试")
                    }
                }

            });
            return false;

        })


    });


    window.onload = function (ev) {
        var name;
        var pd;
        $.ajax({
            url: "seeboss",
            dataType: 'json',
            success: function (msg) {
                $.each(msg, function (index, value) {
                    name = value.boNumber;
                    // pd = value.boPassword;
                })

                $("#name").val(name)
                $("#pd").val(pd)

            }
        });

    }

    // $("#tijiao").click(function () {
    //     var un = $("#name").val()
    //     var pd = $("#pd").val()
    //     $.ajax({
    //
    //         url: "mmxx",
    //         data: {username:un,password:pd},
    //         type: 'POST',
    //         async: false,
    //         success: function (msg) {
    //             layer.msg(msg)
    //         }
    //
    //     })
    // })
</script>


</body>
</html>