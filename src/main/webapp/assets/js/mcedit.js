$(function(){
	$(document).queue([function(){
		$.ajax({
			url:'buall',
			success:function(e){
				var jsondata=eval("("+e+")");
				var select="<option value=''>请选择站点</option>";
				for(var i in jsondata){
					if(jsondata[i].bId==parent.formdata.bId){
						select+="<option selected='selected'  value="+jsondata[i].bId+">"+jsondata[i].bName+"</option>"
					}else{
						select+="<option value="+jsondata[i].bId+">"+jsondata[i].bName+"</option>"
					}
				}
				$("#bId").html(select)
			},complete:function(){
				$(document).dequeue();
			}
		})
	},function(){
		layui.use(['form','layer','jquery'], function(){
			  var form = layui.form;
			  var layer = layui.layer;
	          var $=layui.jquery;
	      	
		      form.val('mc', { 
					"cId":parent.formdata.cId,
					"cNumber":parent.formdata.cNumber,
					"cName":parent.formdata.cName,
					"cPassword":parent.formdata.cPassword,
					"bCity":parent.formdata.bCity,
					//"bId":parent.formdata.bCity
		      })
			    
			  form.on('submit(mcmessage)', function(data){
				$.ajax({
					url:'editclerker',
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
		
	}])
	
	

	 
	  
		 

})
