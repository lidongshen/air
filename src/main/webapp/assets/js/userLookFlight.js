function userLookFlight(fId){
	$.ajax({
		url:"/airsys/user/checksession",
		success:function(e){
			var result=e.replace(/\s/g, "");
			console.log(result);
			if(!(result=="ok")){
				window.location.href="/airsys/user/login";
			}else{
				window.location.href="/airsys/user/userLookFlight/"+fId;
			}
		}
	})
}
function endorseTickets(fId,bookId){
	if(confirm("确认改签？")){
		window.location.href="/airsys/user/endorseOneTicket/"+fId+"/"+bookId;
	}
}