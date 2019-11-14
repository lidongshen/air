<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>首页</title>
<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<script src="/airsys/assets/layui/layui.js"></script>
<script src="/airsys/assets/js/rindex.js"></script>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">您的工号为&nbsp;<span class="user"></span></div>
			 
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item">
				<img src="/airsys/assets/image/houtai.jpg" class="layui-nav-img"> 
				<span class="user"></span>
				</li>
				
				<li class="layui-nav-item exitbtn"><a href="javascript:;">退出登录</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item">
						<a class="" href="javascript:;">信息管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="findex" target="HK">航班管理</a>
							</dd>
							<dd>
								<a href="mcindex" target="HK">营业员管理</a>
							</dd>
							<dd>
								<a href="buindex" target="HK">营业网点管理</a>
							</dd>
							<dd>
								<a href="javascript:;" target="HK">统计信息与报表</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">用户管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="muindex" target="HK">查看用户信息</a>
							</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<iframe src="welcome" frameborder="0" name="HK" id="demoAdmin" style="width: 100%; height: 100%;"></iframe>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			Air and space ticketing system
		</div>
	</div>
</body>

</html>
