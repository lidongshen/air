window.onload = function () {
	layui.use('carousel', function(){
	  var carousel = layui.carousel;
	  //建造实例
	  carousel.render({
	    elem: '#test1'
	    ,width: '100%' //设置容器宽度
	    ,arrow: 'always' //始终显示箭头
	    //,anim: 'updown' //切换动画方式
	  });
	});
    layui.use('element', function(){
    	  var $ = layui.jquery
    	  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
    	  
    	  //触发事件
    	  var active = {
    	    tabAdd: function(){
    	      //新增一个Tab项
    	      element.tabAdd('demo', {
    	        title: '新选项'+ (Math.random()*1000|0) //用于演示
    	        ,content: '内容'+ (Math.random()*1000|0)
    	        ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
    	      })
    	    }
    	    ,tabDelete: function(othis){
    	      //删除指定Tab项
    	      element.tabDelete('demo', '44'); //删除：“商品管理”
    	      
    	      
    	      othis.addClass('layui-btn-disabled');
    	    }
    	    ,tabChange: function(){
    	      //切换到指定Tab项
    	      element.tabChange('demo', '22'); //切换到：用户管理
    	    }
    	  };
    	  
    	  $('.site-demo-active').on('click', function(){
    	    var othis = $(this), type = othis.data('type');
    	    active[type] ? active[type].call(this, othis) : '';
    	  });
    	  
    	  //Hash地址的定位
    	  var layid = location.hash.replace(/^#test=/, '');
    	  element.tabChange('test', layid);
    	  
    	  element.on('tab(test)', function(elem){
    	    location.hash = 'test='+ $(this).attr('lay-id');
    	  });
    	  
    	});
    
    
    $(".exitbtn").on("click",function(){
		if(confirm("是否确定退出系统？")){
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
	$(".loginbtn").on("click",function(){
		if(confirm("是否登录系统？")){
			window.location.href="/airsys/user/login";
		}
	})
	
	$.ajax({
		url:"/airsys/user/triplist",
		success:function(e){
			var result=e.replace(/\s/g, "");
			var jsonData=eval("("+result+")")
			console.log(jsonData)
			for(var i in jsonData){
			$(".mytablee").append("<tr class='fId"+jsonData[i].fId+"'>" +
					"<td>"+jsonData[i].uName+"</td>" +
					"<td>"+jsonData[i].fStarttime+"</br>"+jsonData[i].fFromcity+"</td>"+
					"<td>"+jsonData[i].fEndtime+"</br>"+jsonData[i].fTocity+"</td>"+
					"<td>"+jsonData[i].uIspay+"</td>"+
					"<td><input class='outticket' type='button' value='退票' onclick='refundticket("+jsonData[i].bookId+")'>"
						+"<input class='refundticket' type='button' value='改签' onclick='endorsepage("+jsonData[i].bookId+")'></td>"
					+"</tr>")
			}
		}
	})
	
	
    $.ajax({
    	url:"/airsys/user/userlist",
    	success:function(e){
			var result=e.replace(/\s/g, "");
			
			var jsonData=eval("("+result+")")
			
				$(".mytableee").append("<tr>" +
						"<td>"+jsonData.uName+"</td>" +
						"<td>"+jsonData.uAge+"</td>"+
						"<td>"+jsonData.uSex+"</td>"+
						"<td>"+jsonData.uPhone+"</td>"+
						"<td>"+jsonData.uPassword+"</td>"+
						"<td>"+jsonData.uNum+"</td>"+
						"</tr>")
			
    	}
    })
    
    $(".userhistory").on("click",function(){
    	$.ajax({
    		url:"/airsys/user/checksession",
    		success:function(e){
    			var result=e.replace(/\s/g, "");
    			if(!(result=="ok")){
    				window.location.href="/airsys/user/login";
    			}
    		}
    	})
    })
    $(".usermessage").on("click",function(){
    	$.ajax({
    		url:"/airsys/user/checksession",
    		success:function(e){
    			var result=e.replace(/\s/g, "");
    			if(!(result=="ok")){
    				window.location.href="/airsys/user/login";
    			}
    		}
    	})
    })
    $(".userchange").on("click",function(){
    	$.ajax({
    		url:"/airsys/user/checksession",
    		success:function(e){
    			var result=e.replace(/\s/g, "");
    			if(!(result=="ok")){
    				window.location.href="/airsys/user/login";
    			}
    		}
    	})
    })
    
    $(".realChange").on("click",function(){
    	if(confirm("确认修改？")){
    		$.ajax({
    			url:"changeMessage",
    			data:{
    				age:$(".age").val(),
    				sex:$(".sex").val(),
    				telephone:$(".telephone").val(),
    				password:$(".password").val()
    			},
    			success:function(e){
    				var result=e.replace(/\s/g, "");
    				console.log(result);
    			}
    		})
    	}
    })
}
function refundticket(bookId){
	window.location.href="/airsys/user/refundTicket/"+bookId;
}
function endorsepage(bookId){
	window.location.href="/airsys/user/endorsePage/"+bookId;
}
