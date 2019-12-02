<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta content="text/html;charset=utf-8">
	<title>列出账号</title>
	<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
	<script src="/airsys/assets/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="/airsys/assets/jquery-validation/dist/localization/messages_zh.js"></script>
	<link rel="stylesheet" href="/airsys/assets/css/bootstrap.css">
	<style>
		a{
			text-decoration: none;
		}
	</style>
</head>
<body>
	<h3 align="center">历史订单信息</h3>
	<hr color="red">
	<center>
	<div class="container">
		<table  class="table table-bordered"  border="1px" cellspacing="0" cellpadding="0">
			<tr>
				<th>订单ID</th>
				<th>用户ID</th>
				<th>营业员ID</th>
				<th>航班ID</th>
				<th>订票时间</th>
				<th>支付情况</th>
			</tr>
			
			<c:forEach items="${b}" var="b">
				<tr>
					<td>${b.bookId}</td>
					<td>${b.uId}</td>
					<td>${b.cId}</td>
					<td>${b.fId}</td>
					<td>${b.bDate}</td>
					<td>${b.bIspay}</td>
				</tr>
		</table>
	</div>	
	<h3 align="center">选择改签航班</h3>
	<hr color="red">
	<form class="form-inline" method="post" id="form1" action="/airsys/gaiqianlist/${b.bookId}">
	</c:forEach>
  <div class="form-group">
    <label for="from" >出发地</label>
	 <input id="from" type="text" name="from" class="form-control" >
  </div><br>
  <div class="form-group">
    <label for="to"  >目的地</label>
	  <input id="to" type="text" name="to"  class="form-control">
  </div><br>
  <div class="form-group">
    <label for="time">出发日期</label>
	 <input id="time" type="date" name="time" class="form-control">
  </div><br>
    <input class="submit" type="submit" value="立即搜索">
</form>
</center>
</body>

</html>