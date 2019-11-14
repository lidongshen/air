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
	<from class="layui-form layui-form-pane" lay-filter="mu">
	       <div class="layui-form-item">
		       <div class="layui-inline">
	                <label class="layui-form-label">用户编号</label>
	                <div class="layui-input-inline">
	                    <input type="text" disabled="disabled" name="uId" lay-verify="required" placeholder="请输入用户编号" autocomplete="off" class="layui-input">
	                </div>
	            </div>
                <div class="layui-inline">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" disabled="disabled" name="uName" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                </div>
            </div>
            
        </div>
       <div class="layui-form-item">
           <div class="layui-inline">
                <label class="layui-form-label">身份证号</label>
                <div class="layui-input-inline">
                    <input type="text" disabled="disabled" name="uNum" lay-verify="required" placeholder="请输入身份证号" autocomplete="off" class="layui-input">
                </div>
            </div>
           <div class="layui-inline">
               <label class="layui-form-label">电话</label>
               <div class="layui-input-inline">
                   <input type="text" disabled="disabled" name="uPhone" lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
               </div>
           </div>
                
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-inline">
                    <input type="text" disabled="disabled" name="uAge" lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-inline">
                    <input type="text" disabled="disabled" name="uSex" lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
	</from>
	
	
</body>
</html>