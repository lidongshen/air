<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
    <link rel="stylesheet" href="/airsys/assets/css/bootstrap.css">
    <script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
	<script src="/airsys/assets/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="/airsys/assets/jquery-validation/dist/localization/messages_zh.js"></script>
	<script src="/airsys/assets/js/rlogin.js"></script>
	 <link rel="stylesheet" href="/airsys/assets/css/rlogin.css">
</head>
<body>
    <form  class="zong">
        <p class="p1" style="width:100%;height:32px;font-weight: 600;font-size: 22px;margin:15px 0 10px;">管理员登录</p>
        <div class="form-group">
            <label for="rname">用户名</label>
            <input type="text" class="form-control" id="rname" name="rname" placeholder="请输入用户名">
          </div>
          <div class="form-group">
            <label for="rpwd">密码</label>
            <input type="password" class="form-control" id="rpwd" name="rpwd"  placeholder="请输入密码">
        </div>
        <input class="btn btn-success" id="commit" type="button" style="margin-left:10%;width:80%;margin-bottom:20px;"  value="登录">
    </form>
</body>
</html>