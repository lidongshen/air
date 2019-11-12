$(function(){
	
	layui.use(['laydate','form','layer','jquery'], function(){
		  var form = layui.form;
		  var laydate = layui.laydate;
		  var layer = layui.layer;
          var $=layui.jquery;
         console.log( $("#bProvince").find("option[value='北京']"))
       
		  laydate.render({
			  elem:'#fEndtime',
			  type:'datetime',
			  format:'yyyy-MM-dd HH:mm:ss',
			  trigger: 'click',
			  theme:'molv'
		  });
		  laydate.render({
			  elem:'#fStarttime',
			  type:'datetime',
			  format:'yyyy-MM-dd HH:mm:ss',
			  trigger: 'click',
			  theme:'molv',
		  });
		  
		  form.on('submit(flightmessage)', function(data){
			$.ajax({
				url:'editf',
				data:data.field,
				type:'post',
				success:function(e){
					if(e=='ok'){
						layer.msg('修改成功', {
							  icon: 1,
							  shadeClose:true,
							  time: 1000 // 1秒关闭（如果不配置，默认是3秒）
							},function(){
								//parent.location.reload();
								parent.tableload();
								var index = parent.layer.getFrameIndex(window.name);
	                            parent.layer.close(index);
							});
					}else{
						layer.msg('修改失败', {
							  icon: 2,
							  titl:false,
							  time: 1000 // 1秒关闭（如果不配置，默认是3秒）
						}); 
					}
				}
			})
			  return false; 
		});
		  
	});
	

	 
	  
		 

})
