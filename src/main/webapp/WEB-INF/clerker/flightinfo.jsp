<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta content="text/html;charset=utf-8">
<title>航班详细信息</title>
<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
<script
	src="/airsys/assets/jquery-validation/dist/jquery.validate.min.js"></script>
<script
	src="/airsys/assets/jquery-validation/dist/localization/messages_zh.js"></script>
<link rel="stylesheet" href="/airsys/assets/css/bootstrap.css">
<style>
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<h3 align="center">航班信息</h3>
	<hr color="red">
	<center>
		
		<div class="container">
			<table class="table table-bordered">
				<tr>
					<th>航班ID</th>
					<th>航班名字</th>
					<th>起始地</th>
					<th>目的地</th>
					<th>机票价格</th>
					<th>剩余票数</th>
					<th>出发时间</th>
					<th>抵达时间</th>
				</tr>
				<c:forEach items="${f}" var="f">
					<tr>
						<td>${f.fId}</td>
						<td>${f.fName}</td>
						<td>${f.fFromcity}</td>
						<td>${f.fTocity}</td>
						<td>${f.fMoney}</td>
						<td>${f.fSeatnum}</td>
						<td>${f.fStarttime}</td>
						<td>${f.fEndtime}</td>
					</tr>
				</table>
				<h3 align="center">用户信息</h3>
				<hr color="red">
				<form class="form-inline" method="post" id="form1" action="search" >
				 <div class="form-group">
   				 <label for="uId">用户ID</label>
    			<input type="text"  class="form-control"  id="uId"  placeholder="请输入用户ID"  name="uId" >
  				</div><br>
  				 <div class="form-group">
   				 <label for="uname">用户姓名</label>
    			<input type="uname" class="form-control" id="uname" placeholder="请输入用户姓名" name="uname" >
  				</div>
  				</form>
					<button type="button" fid=${f.fId} id="commit"  onclick=clerkerOrderTicket(${f.fId})>生成订单</button>
				</c:forEach>
		</div>
	</center>
	<script type="text/javascript"
		src="/airsys/assets/js/clerkerOrderTicket.js"></script>
</body>

</html>
