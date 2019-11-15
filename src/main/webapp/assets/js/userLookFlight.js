function userLookFlight(fId){
	$.ajax({
		url:"/airsys/user/checksession",
		success:function(e){
			var result=e.replace(/\s/g, "");
			console.log(result);
			if(result=="ok"){
				window.location.href="/airsys/user/userLookFlight/"+fId;
			}else{
				window.location.href="/airsys/user/login";
			}
		}
	})
}