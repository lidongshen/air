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
	<h3 align="center">用户信息</h3>
	<hr color="red">
	<center>
	<div class="container">
		<table  class="table table-bordered"  border="1px" cellspacing="0" cellpadding="0">
			<tr>
				<th>用户ID</th>
				<th>用户姓名</th>
				<th>用户电话</th>
				<th>用户年龄</th>
				<th>用户性别</th>
			</tr>
			
			<c:forEach items="${u}" var="u">
				<tr>
					<td>${u.uId}</td>
					<td>${u.uName}</td>
					<td>${u.uPhone}</td>
					<td>${u.uAge}</td>
					<td>${u.uSex}</td>
				</tr>
			</c:forEach>
		</table>
	</div>	
	</center>
	<script type="text/javascript" src = "/airsys/assets/js/clerkerLookFlight.js"></script>
</body>

</html>