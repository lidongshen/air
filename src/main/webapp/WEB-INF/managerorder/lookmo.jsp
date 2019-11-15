<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>余票信息</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css" media="all">
<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
<script src="/airsys/assets/layui/layui.js"></script>
<style>
	from{
		width:660px;
		height:230px;
		padding:0px 0 0 15px;
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
	                <label class="layui-form-label">飞机编号</label>
	                <div class="layui-input-inline">
	                    <input type="text" disabled="disabled" name="fId" lay-verify="required" placeholder="请输入飞机编号" autocomplete="off" class="layui-input">
	                </div>
	            </div>
                <div class="layui-inline">
                <label class="layui-form-label">航班名称</label>
                <div class="layui-input-inline">
                    <input type="text" disabled="disabled" name="fName" lay-verify="required" placeholder="请输入航班" autocomplete="off" class="layui-input">
                </div>
            </div>
            
        </div>
       <div class="layui-form-item">
           <div class="layui-inline">
                <label class="layui-form-label">出发地</label>
                <div class="layui-input-inline">
                    <input type="text" disabled="disabled" name="fFromcity" lay-verify="required" placeholder="请输入出发地" autocomplete="off" class="layui-input">
                </div>
            </div>
           <div class="layui-inline">
               <label class="layui-form-label">目的地</label>
               <div class="layui-input-inline">
                   <input type="text" disabled="disabled" name="fTocity" lay-verify="required" placeholder="请输入目的地" autocomplete="off" class="layui-input">
               </div>
           </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">已购座位数</label>
                <div class="layui-input-inline">
                    <input type="text" disabled="disabled" name="seatnum" lay-verify="required" placeholder="请输入已购座位数" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">剩余座位数</label>
                <div class="layui-input-inline">
                    <input type="text" disabled="disabled" name="reseatnum" lay-verify="required" placeholder="请输入剩余座位数" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">起飞时间</label>
                <div class="layui-input-inline">
                    <input type="text" disabled="disabled" name="fStarttime" lay-verify="required" placeholder="请输入起飞时间" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">到达时间</label>
                <div class="layui-input-inline">
                    <input type="text" disabled="disabled" name="fEndtime" lay-verify="required" placeholder="请输入到达时间" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
	</from>

	
</body>
</html>