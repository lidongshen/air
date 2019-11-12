$(function() {
	$("form").validate({
		rules : {
			rname : {
				required : true,
				rangelength : [ 2, 10 ]
			},
			rpwd : {
				required : true,
				minlength : 6
			}
		},
		messages : {
			rname : {
				required : "请输入用户名",
				rangelength : "用户名不能小于2个字符，不能大于10个字符"
			},
			rpwd : {
				required : "请输入密码",
				minlength : "密码最少位6位"
			}
		}
	})
})