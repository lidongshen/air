$(function() {
	$("#commit").on('click',function(){
		var data="fId="+$("#fId").val();
		$.ajax({
			url:"corder",
			data:data,
			type:'post',
			success:function(e){
				if(e=='ok'){
					alert(1);
				}else{
					alert("用户名或者密码错误")
					window.location.href="clogin";
				}
			}
		})
	})
})