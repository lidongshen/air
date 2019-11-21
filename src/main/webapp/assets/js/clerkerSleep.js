window.onload=function(){
		var num = 3;
		var t=setInterval(function() {
			num--;
			if(num==0){
				clearInterval(t);
				location.href="/airsys/user/success";
			}
		}, 1000);
}