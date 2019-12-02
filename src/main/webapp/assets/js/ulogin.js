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
			}
		},
		messages : {
			username : {
				required : "请输入用户名",
				rangelength : "用户名不能小于2个字符，不能大于10个字符"
			},
			upwd : {
				required : "请输入密码",
				minlength : "密码最少位5位"
			}
		}
	})
})