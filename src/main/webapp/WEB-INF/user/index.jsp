<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Main File</title>
    <link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
	<script src="/airsys/assets/layui/layui.js"></script>
    <link rel="stylesheet" href="/airsys/assets/css/bootstrap.css">
    <script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
    <script src="/airsys/assets/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="/airsys/assets/jquery-validation/dist/localization/messages_zh.js"></script>
    <script src="/airsys/assets/js/userindex.js"></script>
    
    <link rel="stylesheet" href="/airsys/assets/css/userindex.css">
</head>
<body>
    <div class = "zong">
        <div class="layui-carousel" id="test1">
		  <div carousel-item>
		    <div><img src="https://dimg04.c-ctrip.com/images/zg05180000013qpkdF836.jpg"></div>
		    <div><img src="https://dimg04.c-ctrip.com/images/zg0q1800000147ai7A062.jpg"></div>
		    <div><img src="https://dimg04.c-ctrip.com/images/zg09180000014fecy5501.jpg"></div>
		    <div><img src="https://dimg04.c-ctrip.com/images/zg0h180000013gofdEE0B.jpg"></div>
		  </div>
		</div>
    </div>
    <div class="layui-tab">
  <ul class="layui-tab-title">
    <li class="layui-this">搜索页面<>
    <li>历史订单<>
    <li>用户信息<>
    <li class = "exitbtn">退出登录<>
    <li class = "loginbtn"  style="display:none">登录<>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
    
    <div class="userindexbottom">  
	    <div class="findTicket">
	        <form method="post" id="form1" action="search" >
	            <fieldset class = "uib-top">
	                <legend class="chaxun">查询</legend>
	                <p class="from">
	                    <label for="from">出发地</label>
	                    <input id="from" type="text" name="from" required>
	                </p>
	                <p class = "to">
	                    <label for="to">目的地</label>
	                    <input id="to" type="text" maxlength="12" name="to" required>
	                </p>
	                <p class="time">
	                    <label for="time">出发日期</label>
	                    <input id="time" type="date" name="time" required>
	                </p>
	                <p class = "submit">
	                    <input class="submit" type="submit" value="立即搜索">
	                </p>
	            </fieldset>
	        </form>
	    </div>
    </div>
    
    
    </div>
    <div class="layui-tab-item">内容2</div>
    <div class="layui-tab-item">内容3</div>
    
  </div>
</div>
</body>
</html>
