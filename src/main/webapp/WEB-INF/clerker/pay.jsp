<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="util.*"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>订单</title>
    <link rel="stylesheet" href="/airsys/assets/css/bootstrap.css">
    <link rel="stylesheet" href="/airsys/assets/css/userpay.css">
    <script type="text/javascript" src="/airsys/assets/js/clerkerSleep.js"></script>
    
</head>
<body>
    <form method="post" id="form1" action="/airsys/cflightlist" >
         <input class="submit" type="submit" value="返回主页面">
   	</form>
   	
   	<div class="container">
        <div class="twocode">
            二维码
        </div>
        <select class="paytype">
            <option value="0">请选择支付方式</option>
            <option value="0">支付宝</option>
            <option value="0">微信</option>
            <option value="0">网银</option>
        </select>
        <div>正在进行支付，请稍后……</div>
        <input type="button" value="退出" class="exitbtn">
    </div>
</body>
</html>