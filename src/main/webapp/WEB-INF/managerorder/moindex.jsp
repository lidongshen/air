<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>营业员信息</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">
<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
<style type="text/css">
.layui-form-checkbox i {
	top: 9px;
}

.layui-table-cell {
	height: 35px;
	line-height: 35px;
}
</style>
</head>
<body style="padding: 0 15px; box-sizing: border-box;">
	
	<div class="layui-form layui-form-item layui-form-pane" style="margin:15px 0 10px;">
        <label class="layui-form-label">选择营业点</label>
        <div class="layui-input-inline">
            <select name="city" id="bId" lay-filter="bId" lay-verify="">
            </select>
        </div>
    </div>
	<table id="demo" class="layui-hide" lay-filter="mo"></table>
	<script src="/airsys/assets/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
	  <a class="layui-btn layui-btn-primary layui-btn-sm layui-btn-radius layui-btn-fluid" lay-event="detail">查看</a>
	</script>
	<script src="/airsys/assets/js/moindex.js"></script>
</body>
</html>