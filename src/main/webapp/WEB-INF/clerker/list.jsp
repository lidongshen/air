<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,util.*"%>

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
	<h3 align="center">航班信息</h3>
	<hr color="red">
	<center>
	<div class="container">
		<table  class="table table-bordered" border="1px" cellspacing="0" cellpadding="0">
			<tr>
				<th>航班名字</th>
				<th>起始地</th>
				<th>目的地</th>
				<th>机票价格</th>
				<th>余票</th>
				<th>出发时间</th>
				<th>抵达时间</th>
				<th>操作</th>
			</tr>
			
			<c:forEach items="${f}" var="f">
				<tr>
					<td>${f.fName}</td>
					<td>${f.fFromcity}</td>
					<td>${f.fTocity}</td>
					<td>${f.fMoney}</td>
					<td>${f.fSeatnum}</td>
					<td>
						${f.fStarttime}
					</td>
					<td>${f.fEndtime}</td>
					<td>
						<a href="flightinfo/${f.fId}" >填写订单</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</center>
	<!-- <script type="text/javascript" src = "/airsys/assets/js/clerkerLookFlight.js"></script> -->
</body>

</html>