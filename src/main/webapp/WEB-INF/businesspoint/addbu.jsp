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
<script src="/airsys/assets/js/buadd.js"></script>
<style>
	from{
		width:660px;
		height:250px;
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
				<label class="layui-form-label">网点名称</label>
				<div class="layui-input-inline">
					<input type="text"  name="bName" lay-verify="required" placeholder="请输入网点名称" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">地区</label>
				<div class="layui-input-inline">
			      <select name="bProvince">
			        <option value="">请选择省</option>
			        <option value="北京">北京</option>
			        <option value="浙江">浙江</option>
			        <option value="江西">江西</option>
			        <option value="山西">山西</option>
			      </select>
			    </div>
			    <div class="layui-input-inline">
			      <select name="bCity">
			        <option value="">请选择市</option>
			        <option value="大兴">大兴</option>
			        <option value="杭州">杭州</option>
			        <option value="温州">温州</option>
			        <option value="台州">台州</option>
			        <option value="绍兴">绍兴</option>
			        <option value="太原">太原</option>
			      </select>
			    </div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">电话</label>
				<div class="layui-input-inline">
					<input type="text"  name="bPhone" lay-verify="required|phone" placeholder="请输入电话" autocomplete="off" class="layui-input">
				</div>
			</div>
			
		</div>

		<div class="layui-form-item" style="margin-left: 100px;">
			<div class="layui-input-block">
				<button type="submit" class="layui-btn" lay-submit="" lay-filter="bumessage">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</from>
	
	
</body>
</html>