var tableload;
var pageNo;
var total;
var datalength;
var formdata;

	$.ajax({
		url:'buall',
		success:function(e){
			var jsondata=eval("("+e+")");
			var select="<option value='0'>全部</option>";
			for(var i in jsondata){
				select+="<option value="+jsondata[i].bId+">"+jsondata[i].bName+"</option>"
			}
			$("#bId").html(select)
		}})

	
	layui.use(['table','form','util'],function() {
			var table = layui.table;
			var form = layui.form;
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
					height : 445,
					url : 'mcseach',
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
								field : 'cId',
								title : 'ID',
								sort : true,
								unresize : true,
							},
							{
								field : 'cNumber',
								title : '员工号',
							},
							{
								field : 'cName',
								title : '姓名',
								unresize : true,
							},
							{
								field : 'cPassword',
								title : '密码',
								unresize : true,
							},
							{
								field : 'bName',
								title : '营业点名称',
								unresize : true,
							},
							{
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
			
		table.on('tool(mc)', function(obj) {
			var data = obj.data; // 获得当前行数据
			formdata=data;
			var layEvent = obj.event; // 获得 lay-event 对应的值（也可以是表头的event 参数对应的值）
			var tr = obj.tr; // 获得当前行 tr 的 DOM 对象（如果有的话）
			if (layEvent === 'del') { // 删除
				layer.confirm('您确认删除该营业员吗？', {shade: [0.8, '#393D49'], shadeClose:true,},function(index) {
					// 向服务端发送删除指令
					$.ajax({
						url:'delmc',
						data:{'cId' : data.cId},
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
					  title:'营业员信息',
					  content: 'lookmc',
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
					    body.find("input[name=cId]").val(data.cId);
					    body.find("input[name=cName]").val(data.cName);
					    body.find("input[name=cNumber]").val(data.cNumber);
					    body.find("input[name=cPassword]").val(data.cPassword);
					    body.find("input[name=bName]").val(data.bName);
					  }
				});  
			}else if(layEvent === 'edit'){
			
				layer.open({
					  type: 2,
					  title:'修改营业员信息',
					  content: 'editmc',
					  shade: [0.8, '#393D49'],
					  shadeClose:true,
					  move:false,
					  anim:2,
					  area: ['690px','350px'],
					  resize:false,
					  zIndex: layer.zIndex, //重点1
					  success: function(layero){
					    layer.setTop(layero); //重点2
					    
					  }
				})
			}
		});
		table.on('toolbar(mc)', function(obj){
			  var checkStatus = table.checkStatus(obj.config.id);
			  var data = checkStatus.data;
			  switch(obj.event){
			    case 'add':
			    	layer.open({
						  type: 2,
						  title:'添加营业员信息',
						  content: 'addmc',
						  shade: [0.8, '#393D49'],
						  shadeClose:true,
						  move:false,
						  anim:2,
						  area: ['700px','400px'],
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
				        		checkdata.push(data[i].cId);
				        	}
				         $.ajax({
				        	  url:'delmcAll',
				        	  data:{'data':checkdata},
				        	  type:'post',
				        	  traditional:true, 
				        	  success:function(e){
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
		
		form.on('select(bId)', function(data){
			  table.reload('demo', {
				 url:"buselect",
				 where:{"bId":data.value}
				});
			});
		
	});



