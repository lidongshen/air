var tableload;
var pageNo;
var total;
var datalength;
layui.use(['table','util'],function() {
		var table = layui.table;
		var util = layui.util;
		tableload=function(){
			table.reload("demo", {
				  page: {
					    curr: pageNo
					  }
					});
		}
		table.render({
				elem : '#demo',
				height : 500,
				url : 'fseach',
				page : true,
				toolbar : '#toolbarDemo',
				cellMinWidth : 80,
				method : 'post',
				cols : [ [ // 表头
						{
							type : 'numbers'
						},
						{
							type : 'checkbox'
						},
						{
							field : 'fId',
							title : 'ID',
							sort : true,
							unresize : true,
						},
						{
							field : 'fName',
							title : '飞机名称',
							unresize : true,
							width:140
						},
						{
							field : 'fFromcity',
							title : '始发地',
						},
						{
							field : 'fTocity',
							title : '目的地',
							unresize : true,
						},
						{
							field : 'fMoney',
							title : '价钱',
							sort : true,
							unresize : true,
						},
						{
							field : 'fSeatnum',
							title : '座位数',
							unresize : true,
						},
						{
							field : 'fStarttime',
							title : '起飞时间',
							sort : true,
							unresize : true,
							width:160,
							templet : '<div>{{ layui.util.toDateString(d.fStarttime,"yyyy-MM-dd HH:mm:ss") }}</div>'
						},
						{
							field : 'fEndtime',
							title : '到达时间',
							sort : true,
							unresize : true,
							width:160,
							templet : '<div>{{ layui.util.toDateString(d.fEndtime,"yyyy-MM-dd HH:mm:ss") }}</div>'
						}, {
							title : '操作',
							fixed:'right',
							toolbar : '#barDemo',
							unresize : true,
							width : 200,
							
						} ] ],
				parseData : function(res) { // res 即为原始返回的数据
					total=res.total;
					return {
						"code" : 0, // 解析接口状态
						"msg" : "", // 解析提示文本
						"count" : res.total, // 解析数据长度
						"data" : res.data
					// 解析数据列表
					};
				},done: function(res, curr, count){
					pageNo=curr;
					datalength=res.data.length
				}
			});
		
	table.on('tool(flight)', function(obj) {
		var data = obj.data; // 获得当前行数据
		var layEvent = obj.event; // 获得 lay-event 对应的值（也可以是表头的event 参数对应的值）
		var tr = obj.tr; // 获得当前行 tr 的 DOM 对象（如果有的话）
		if (layEvent === 'del') { // 删除
			layer.confirm('您确认删除本次航班吗？', {shade: [0.8, '#393D49'], shadeClose:true,},function(index) {
				// 向服务端发送删除指令
				$.ajax({
					url:'delf',
					data:{'fId' : data.fId},
					type:'post',
					success:function(e){
						if(e=='ok'){
							layer.msg('删除成功', {
								  icon: 1,
								  shadeClose:true,
								  time: 1000 // 1秒关闭（如果不配置，默认是3秒）
								},function(){
									obj.del();
									if(datalength==1 && pageNo>1){
										pageNo = pageNo-1
									}
									table.reload("demo",{page:{curr:pageNo}});
									layer.close(index);
							});
						}else{
							layer.msg('删除失败', {
								  icon: 2,
								  titl:false,
								  time: 1000 // 1秒关闭（如果不配置，默认是3秒）
							}); 
						}
					}
				})
				
			});
		} else if (layEvent === 'detail') { // 查看
			layer.open({
				  type: 2,
				  title:'航班信息',
				  content: 'lookflight',
				  shade: [0.8, '#393D49'],
				  shadeClose:true,
				  move:false,
				  anim:2,
				  area: ['690px','350px'],
				  resize:false,
				  zIndex: layer.zIndex, //重点1
				  success: function(layero,index){
				    layer.setTop(layero); //重点2
				    var body = layer.getChildFrame('body', index);
				    var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				    body.find("input[name=fId]").val(data.fId);
				    body.find("input[name=fId]").val(data.fId);
				    body.find("input[name=fName]").val(data.fName);
				    body.find("input[name=fMoney]").val(data.fMoney);
				    body.find("input[name=fSeatnum]").val(data.fSeatnum);
				    body.find("input[name=fFromcity]").val(data.fFromcity);
				    body.find("input[name=fTocity]").val(data.fTocity);
				    body.find("input[name=fStarttime]").val(util.toDateString(data.fStarttime, "yyyy-MM-dd HH:mm:ss"));
				    body.find("input[name=fEndtime]").val(util.toDateString(data.fEndtime, "yyyy-MM-dd HH:mm:ss"));
				     
				  }
			});  
		}else if(layEvent === 'edit'){
			layer.open({
				  type: 2,
				  title:'修改航班',
				  content: 'editflight',
				  shade: [0.8, '#393D49'],
				  shadeClose:true,
				  move:false,
				  anim:2,
				  area: ['690px','350px'],
				  resize:false,
				  zIndex: layer.zIndex, //重点1
				  success: function(layero,index){
				    layer.setTop(layero); //重点2
				    var body = layer.getChildFrame('body', index);
				    body.find("input[name=fId]").val(data.fId);
				    body.find("input[name=fId]").val(data.fId);
				    body.find("input[name=fName]").val(data.fName);
				    body.find("input[name=fMoney]").val(data.fMoney);
				    body.find("input[name=fSeatnum]").val(data.fSeatnum);
				    body.find("input[name=fFromcity]").val(data.fFromcity);
				    body.find("input[name=fTocity]").val(data.fTocity);
				    body.find("input[name=fStarttime]").val(util.toDateString(data.fStarttime, "yyyy-MM-dd HH:mm:ss"));
				    body.find("input[name=fEndtime]").val(util.toDateString(data.fEndtime, "yyyy-MM-dd HH:mm:ss"));
				 }
			})
		}
	});
	table.on('toolbar(flight)', function(obj){
		  var checkStatus = table.checkStatus(obj.config.id);
		  var data = checkStatus.data;
		  switch(obj.event){
		    case 'add':
		    	layer.open({
					  type: 2,
					  title:'添加航班信息',
					  content: 'addflight',
					  shade: [0.8, '#393D49'],
					  shadeClose:true,
					  move:false,
					  anim:2,
					  area: ['850px','400px'],
					  resize:false,
					  zIndex: layer.zIndex, //重点1
					  success: function(layero){
					    layer.setTop(layero); //重点2
				  } 
				});  
		    break;
		    case 'delete':
		    	 if(data.length === 0){
			          layer.msg('请选择一行');
			        } else {
			        	var checkdata=[];
			        	for(i = 0;i<data.length;i++){
			        		checkdata.push(data[i].fId);
			        	}
			         $.ajax({
			        	  url:'delfAll',
			        	  data:{'data':checkdata},
			        	  type:'post',
			        	  traditional:true, 
			        	  success:function(e){
			        		  console.log(e)
								if(e=='ok'){
									layer.msg('删除成功', {
										  icon: 1,
										  shadeClose:true,
										  time: 1000 // 1秒关闭（如果不配置，默认是3秒）
										},function(){
											if(checkStatus.isAll){
												pageNo = pageNo-1
											}
											table.reload("demo", {
													  page: {
													    curr: pageNo
													  }
													});
									});
								}else{
									layer.msg('删除失败', {
										  icon: 2,
										  titl:false,
										  time: 1000 // 1秒关闭（如果不配置，默认是3秒）
									}); 
								}
							
			        	  }
			        	  
			          })
			        }
		    break;
		  };
	});
	
	
	
});

	  

