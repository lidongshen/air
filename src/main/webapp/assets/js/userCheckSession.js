window.onload=function(){
	$.ajax({
		url:"/airsys/user/checksession",
		success:function(e){
			var result=e.replace(/\s/g, "");
			if(result=="ok"){
				window.location.href="login.jsp";
			}
		}
	})
}