$(function(){
	console.log(parent.formdata.bId)
	layui.use(['form','layer','jquery'], function(){
		  var form = layui.form;
		  var layer = layui.layer;
          var $=layui.jquery;
          
	      form.val('bu', { 
				"bId":parent.formdata.bId,
				"bName":parent.formdata.bName,
				"bProvince":parent.formdata.bProvince,
				"bCity":parent.formdata.bCity,
				"bPhone":parent.formdata.bPhone
	      })
		    
		  form.on('submit(bumessage)', function(data){
			$.ajax({
				url:'editbusinesspoint',
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
