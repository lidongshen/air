$(function(){
	layui.use(['table','form','layer','jquery'], function(){
		  var form = layui.form;
		  var layer = layui.layer
          var $=layui.jquery;
		 
		  
		  form.on('submit(bumessage)', function(data){
			$.ajax({
				url:'addbusinesspoint',
				data:data.field,
				type:'post',
				success:function(e){
					if(e=='ok'){
						layer.msg('添加成功', {
							  icon: 1,
							  shadeClose:true,
							  time: 1000 // 1秒关闭（如果不配置，默认是3秒）
							},function(){
								//parent.location.reload();
								$(":input").val("")
								parent.tableload();
							});
					}else{
						layer.msg('添加失败', {
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
	$(":reset").click(function(){
		$(":input").val("")
	})

	 
	  
		 

})
