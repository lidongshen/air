layui.use(['table','form','util'],function() {
		var table = layui.table;
		var form = layui.form;
		var util = layui.util;
		table.render({
				elem : '#demo',
				height : 500,
				url : 'mcseach',
				page : true,
				cellMinWidth : 80,
				method : 'post',
				cols : [ [ // 表头
						{
							type : 'numbers'
						},
						{
							field : 'uId',
							title : 'ID',
							sort : true,
							unresize : true,
						},
						{
							field : 'uName',
							title : '姓名',
							unresize : true,
						},
						{
							field : 'uNum',
							title : '身份证号',
							unresize : true,
						},
						{
							field : 'uPhone',
							title : '电话',
							unresize : true,
						},
						{
							field : 'uAge',
							title : '年龄',
							sort : true,
							unresize : true,
						},
						{
							field : 'uSex',
							title : '性别',
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
		
	table.on('tool(mu)', function(obj) {
		var data = obj.data; // 获得当前行数据
		formdata=data;
		var layEvent = obj.event; // 获得 lay-event 对应的值（也可以是表头的event 参数对应的值）
		var tr = obj.tr; // 获得当前行 tr 的 DOM 对象（如果有的话）
		if (layEvent === 'detail') { // 查看
			layer.open({
				  type: 2,
				  title:'用户信息',
				  content: 'lookmu',
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
				    body.find("input[name=uId]").val(data.uId);
				    body.find("input[name=uName]").val(data.uName);
				    body.find("input[name=uNum]").val(data.uNum);
				    body.find("input[name=uPhone]").val(data.uPhone);
				    body.find("input[name=uAge]").val(data.uAge);
				    body.find("input[name=uSex]").val(data.uSex);
				  }
			});  
		}
	});
});



