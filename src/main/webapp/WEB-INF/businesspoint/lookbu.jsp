<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>网点信息</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css" media="all">
<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
<script src="/airsys/assets/layui/layui.js"></script>
<style>
	from{
		width:660px;
		height:200px;
		padding:10px 0 0 15px;
		box-sizing:border-box;
		position: absolute;
		left:0;right:0;bottom: 0;top: 0;
		margin: auto;
	}
</style>
</head>
<body>
	<from class="layui-form layui-form-pane" lay-filter="bu">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">网点编号</label>
				<div class="layui-input-inline">
					<input type="text" disabled="disabled" name="bId" lay-verify="required" placeholder="请输入网点编号" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">网点名称</label>
				<div class="layui-input-inline">
					<input type="text" disabled="disabled" name="bName" lay-verify="required" placeholder="请输入网点名称" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">省份</label>
				<div class="layui-input-inline">
					<input type="text" disabled="disabled" name="bProvince" lay-verify="required" placeholder="请输入省份" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">城市</label>
				<div class="layui-input-inline">
					<input type="text" disabled="disabled" name="bCity" lay-verify="required" placeholder="请输入城市" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">电话</label>
				<div class="layui-input-inline">
					<input type="text" disabled="disabled" name="bPhone" lay-verify="required|phone" placeholder="请输入电话" autocomplete="off" class="layui-input">
				</div>
			</div>
			
		</div>
		
		
	</from>
	
	
</body>
</html>