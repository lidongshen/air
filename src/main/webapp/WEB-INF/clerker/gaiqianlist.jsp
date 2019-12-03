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
					<td >${b.uId}</td>
					<td>${b.cId}</td>
					<td >${b.fId}</td>
					<td>${b.bDate}</td>
					<c:if test="${b.bIspay==1}">
					<td>已支付</td>
					</c:if>
				</tr>
	
		</table>
	</div>	
	<h3 align="center">改签航班信息</h3>
	<hr color="red">
	<center>
	<div class="container">
		<table  class="table table-bordered" border="1px" cellspacing="0" cellpadding="0">
			<tr>
				<th>航班ID</th>
				<th>航班名字</th>
				<th>起始地</th>
				<th>目的地</th>
				<th>余票</th>
				<th>出发时间</th>
				<th>抵达时间</th>
				<th>操作</th>
			</tr>
			
			<c:forEach items="${f}" var="f">
				<tr>
					<td >${f.fId}</td>
					<td>${f.fName}</td>
					<td>${f.fFromcity}</td>
					<td>${f.fTocity}+${time}</td>
					<td>${f.fSeatnum}</td>
					<td>
						${f.fStarttime}
					</td>
					<td>${f.fEndtime}</td>
					<td>
						<a href="/airsys/cbookinglist1?uId=${b.uId}&fId1=${b.fId}&fId2=${f.fId}" >修改订单</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
		</c:forEach>
	</center>
	
	<!-- <script type="text/javascript" src = "/airsys/assets/js/clerkerLookFlight.js"></script> -->
</body>

</html>