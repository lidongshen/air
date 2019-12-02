<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册</title>
    <link rel="stylesheet" href="/airsys/assets/css/bootstrap.css">
    <script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
	<script src="/airsys/assets/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="/airsys/assets/jquery-validation/dist/localization/messages_zh.js"></script>
	<script src="/airsys/assets/js/userregister.js"></script>
	 <link rel="stylesheet" href="/airsys/assets/css/userregister.css">
</head>
<body>
    <form action="/airsys/user/register" method="POST" class="zong" >
        <p class="p1" style="width:100%;height:32px;font-weight: 600;font-size: 22px;margin:15px 0 10px;">用户注册</p>
          <div class="form-group">
            <label for="username">手机号</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
          </div>
          <div class="form-group">
            <label for="upwd">密码</label>
            <input type="password" class="form-control" id="upwd" name="upwd"  placeholder="请输入密码">
          </div>
          <div class="form-group">
            <label for="urepwd">确认密码</label>
            <input type="password" class="form-control" id="urepwd" name="urepwd"  placeholder="请再次输入密码">
          </div>
          <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" id="name" name="name"  placeholder="请输入姓名">
          </div>
          <div class="form-group">
            <label for="idnum">身份证号</label>
            <input type="text" class="form-control" id="idnum" name="idnum"  placeholder="请输入身份证号">
          </div>
          <div class="form-group">
            <label for="age">年龄</label>
            <input type="text" class="form-control" id="age" name="age"  placeholder="请输入年龄">
          </div>
          <div class="form-group">
            <label for="sex">性别</label>
            <label><input type="radio" name="sex" value="1">男</label>
            <label><input type="radio" name="sex" value="0">女</label>
          </div>
          <div class="regi">已有账号？点击<a href="/airsys/user/login">这里</a>登录账号</div>	
        <button type="submit" class="btn btn-success" style="margin-left:10%;width:80%;margin-bottom:20px;" >注册</button>
    </form>
</body>
</html>