$(function(){
	$(document).queue([function(){
	$.ajax({
		url:'buall',
		success:function(e){
			var jsondata=eval("("+e+")");
			var select="<option value=''>请选择站点</option>";
			for(var i in jsondata){
				select+="<option value="+jsondata[i].bId+">"+jsondata[i].bName+"</option>"
			}
			$("#bId").html(select)
		},complete:function(){
			$(document).dequeue();
		}
	})},function(){
	layui.use(['table','form','layer','jquery'], function(){
		  var form = layui.form;
		  var layer = layui.layer
          var $=layui.jquery;
		 
		  
		  form.on('submit(mcmessage)', function(data){
			$.ajax({
				url:'addmclerker',
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
		  
	});}])
	$(":reset").click(function(){
		$(":input").val("")
	})

	 
	  
		 

})
