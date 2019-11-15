var va;
	$.ajax({
		url:'buall',
		success:function(e){
			var jsondata=eval("("+e+")");
			var select;
			va=jsondata[0].bId;
			for(var i in jsondata){
				select+="<option value="+jsondata[i].bId+">"+jsondata[i].bName+"</option>"
			}
			$("#bId").html(select)
		}
	})

	
	layui.use(['table','form','util'],function() {
			var table = layui.table;
			var form = layui.form;
			var util = layui.util;
		
			table.render({
					elem : '#demo',
					height : 445,
					url : 'moseach',
					where:{"bId":va},
					page : true,
					cellMinWidth : 80,
					method : 'post',
					cols : [ [ // 表头
							{
								type : 'numbers'
							},
							{
								field : 'fId',
								title : '飞机编号',
								unresize : true,
							},
							{
								field : 'fName',
								title : '航班名称',
								unresize : true,
							},
							{
								field : 'fFromcity',
								title : '出发地',
								unresize : true,
							},
							{
								field : 'fTocity',
								title : '目的地',
								unresize : true,
							},
							{
								field : 'seatnum',
								title : '购买座位数',
								width :100,
								unresize : true,
							},
							{
								field : 'reseatnum',
								title : '剩余座位数',
								width :100,
								unresize : true,
							},
							{
								field : 'fStarttime',
								title : '起飞时间',
								unresize : true,
								templet : '<div>{{ layui.util.toDateString(d.fStarttime,"yyyy-MM-dd HH:mm:ss") }}</div>'
							},
							{
								field : 'fEndtime',
								title : '到达时间',
								templet : '<div>{{ layui.util.toDateString(d.fEndtime,"yyyy-MM-dd HH:mm:ss") }}</div>',
								unresize : true,
							},
							{
								title : '操作',
								fixed:'right',
								toolbar : '#barDemo',
								unresize : true,
								
								
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
			if (layEvent === 'detail') { // 查看
				layer.open({
					  type: 2,
					  title:'余票信息',
					  content: 'lookmo',
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
					    body.find("input[name=bName]").val(data.bName);
					    body.find("input[name=fName]").val(data.fName);
					    body.find("input[name=fFromcity]").val(data.fFromcity);
					    body.find("input[name=fTocity]").val(data.fTocity);
					    body.find("input[name=reseatnum]").val(data.reseatnum);
					    body.find("input[name=fStarttime]").val(data.fStarttime);
					    body.find("input[name=fEndtime]").val(data.fEndtime);
					  }
				});  
			}
		});
		
		form.on('select(bId)', function(data){
			  table.reload('demo', {
				 url:"moseach",
				 where:{"bId":data.value}
			  });
		});
	});



