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
     <script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
    
</head>
<body>

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
        <button><a href="/airsys/success/${fId}/${cId}/${uId}" >确定</a></button>
        <form method="post" id="form1" action="/airsys/cflightlist" >
         <input class="submit" type="submit" value="返回主页面">
   	</form>
    </div>
</body>
</html>