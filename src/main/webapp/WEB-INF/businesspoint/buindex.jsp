<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>网点信息</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css"
	media="all">
<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
<style type="text/css">
.layui-form-checkbox i {
	top:9px;
}
.layui-table-cell{
	height:35px;
	line-height:35px;
}
</style>
</head>
<body style="padding: 0 15px; box-sizing: border-box;">
	<table id="demo" class="layui-hide" lay-filter="bu"></table>
	<script src="/airsys/assets/layui/layui.js"></script>
	<script type="text/html" id="toolbarDemo">
		<div class="layui-inline" lay-event="add">
			<i class="layui-icon layui-icon-add-1"></i>
		</div>
		<div class="layui-inline" lay-event="delete">
			<i class="layui-icon layui-icon-delete"></i>
		</div>
	</script>
	<script type="text/html" id="barDemo">
	  <a class="layui-btn layui-btn-primary layui-btn-sm" lay-event="detail">查看</a>
	  <a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
	  <a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">删除</a>
	</script>
	<script src="/airsys/assets/js/buindex.js"></script>
</body>
</html>