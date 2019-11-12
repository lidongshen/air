<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>航班信息</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css" media="all">
<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
<script src="/airsys/assets/layui/layui.js"></script>
<script src="/airsys/assets/js/fedit.js"></script>
<style>
	from{
		width:660px;
		height:300px;
		padding-left:15px;
		box-sizing:border-box;
		position: absolute;
		left:0;right:0;bottom: 0;top: 0;
		margin: auto;
	}
</style>
</head>
<body>
	<from class="layui-form layui-form-pane">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">航班号</label>
				<div class="layui-input-inline">
					<input type="text" disabled="disabled" name="fId" lay-verify="required|number" placeholder="请输入航班号" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">航班名称</label>
				<div class="layui-input-inline">
					<input type="text" name="fName" lay-verify="required" placeholder="请输入航班名称" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">价格</label>
				<div class="layui-input-inline">
					<input type="text" name="fMoney" lay-verify="required|number" placeholder="请输入价格" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">座位数</label>
				<div class="layui-input-inline">
					<input type="text" name="fSeatnum" lay-verify="required|number" placeholder="请输入座位数" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">始发地</label>
				<div class="layui-input-inline">
					<input type="text" name="fFromcity" lay-verify="required" placeholder="请输入始发地" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">目的地</label>
				<div class="layui-input-inline">
					<input type="text" name="fTocity" lay-verify="required" placeholder="请输入目的地" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">起飞时间</label>
				<div class="layui-input-inline">
					<input type="text" name="fStarttime" id="fStarttime" lay-verify="required" placeholder="请输入起飞时间" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">到达时间</label>
				<div class="layui-input-inline">
					<input type="text" name="fEndtime" id="fEndtime" lay-verify="required" placeholder="请输入到达时间" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>

		<div class="layui-form-item" >
			<div class="layui-input-block">
				<button type="submit" class="layui-btn" style="width:80%;" lay-submit="" lay-filter="flightmessage">确认修改</button>
			</div>
		</div>
	</from>
	
	
</body>
</html>