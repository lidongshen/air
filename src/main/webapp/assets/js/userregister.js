$(function() {
	$("form").validate({
		rules : {
			username : {
				required : true,
				rangelength : [ 2, 10 ]
			},
			upwd : {
				required : true,
				minlength : 5
			},
			urepwd : {
				required : true,
				minlength : 5,
				equalTo: "#upwd"
			},
			name:{
				required : true,
			},
			idnum:{
				required : true,
				minlength : 8,
				maxlength : 8
			},
			age:{
				required : true,
			},
			sex:{
				required : true,
			},
		},
		messages : {
			username : {
				required : "请输入用户名",
				rangelength : "用户名不能小于2个字符，不能大于10个字符"
			},
			upwd : {
				required : "请输入密码",
				minlength : "密码最少位5位"
			},
			urepwd : {
				required : "请再次输入密码",
				minlength : "密码最少位5位",
				equalTo: "两次密码必须保持一致"
			},
			name:{
				required : "请输入姓名",
			},
			idnum:{
				required : "请输入身份证号",
				minlength : "请输入正确的身份证号",
				maxlength : "请输入正确的身份证号"
			},
			age:{
				required : "请输入年龄",
			},
			sex:{
				required : "请输入性别",
			},
		}
	})
})