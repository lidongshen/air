<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>营业员信息</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css" media="all">
<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
<script src="/airsys/assets/layui/layui.js"></script>
<script src="/airsys/assets/js/mcedit.js"></script>
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
	<from class="layui-form layui-form-pane" lay-filter="mc">
		<div class="layui-form-item">
		        <div class="layui-inline">
                    <label class="layui-form-label">营业员编号</label>
                    <div class="layui-input-inline">
                        <input type="text" disabled="disabled" name="cId" lay-verify="required" placeholder="请输入营业员编号" autocomplete="off" class="layui-input">
                    </div>
                </div>
			<div class="layui-inline">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-inline">
					<input type="text"  name="cName" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
				</div>
			</div>
			
		</div>
	   <div class="layui-form-item">
	       <div class="layui-inline">
                <label class="layui-form-label">工号</label>
                <div class="layui-input-inline">
                    <input type="text"  name="cNumber" lay-verify="required" placeholder="请输入工号" autocomplete="off" class="layui-input">
                </div>
            </div>
           <div class="layui-inline">
               <label class="layui-form-label">密码</label>
               <div class="layui-input-inline">
                   <input type="text"  name="cPassword" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
               </div>
           </div>
	            
	    </div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">站点</label>
				<div class="layui-input-inline">
			      <select name="bId" id="bId">
			        
			      </select>
			    </div>
			</div>
		</div>

		<div class="layui-form-item" >
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" style="width:80%;" lay-submit="" lay-filter="mcmessage">确认修改</button>
            </div>
        </div>
	</from>
	
	
</body>
</html>