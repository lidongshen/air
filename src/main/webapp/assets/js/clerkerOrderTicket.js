$(function() {
	$("#commit").on('click',function(){
		alert(1);
		$.ajax({
			url:"corder",
			type:'post',
			success:function(e){
				if(e=='ok'){
					alert(2);
				}else{
					alert(3)
				}
			}
		})
		})
})
/*function clerkerOrderTicket(fId){
	window.location.href="corderTicket/{fId}";
}*/