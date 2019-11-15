$("#commit").on('click',function(){
		var fId=$("#commit").attr("fid")
		$.ajax({
			url:'/airsys/corder',
			data:{"fId":fId},
			success:function(e){
				if(e=="ok"){
					alert(1)
				}else{
					alert(2)
				}
			}
		})
})

/*function clerkerOrderTicket(fId){
	window.location.href="corderTicket/{fId}";
}*/