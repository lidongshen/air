window.onload=function(){
	
	$(".exitbtn").on("click",function(){
		if(confirm("是否确定退出系统")){
			$.ajax({
				url:"/airsys/user/exit",
				success:function(e){
					var result=e.replace(/\s/g, "");
					console.log(result);
					if(result=="ok"){
						window.location.href="/airsys/user/index";
					}
				}
			})
		}
	})
}