$(function () {
    /*后台布局界面*/
    layui.use('element',
        // 	function() {
        // 	var element = layui.element;
        // });
        //
        // $(document).queue([function(){
        // 	// 检查session
        // 	$.ajax({
        // 		url : "checksession",
        // 		success : function(e) {
        // 			if (e == "no") {
        // 				window.location.href = "rlogin"
        // 			}
        // 		},
        // 		complete:function(){
        // 			$(document).dequeue();
        // 		}
        // 	})
        // },
        function () {
            //得到uname
            $.ajax({
                url: "getrname",
                success: function (e) {
                    $(".user").html(e)
                },
                complete: function () {
                    $(document).dequeue();
                }
            })
        }, function () {
            // 退出询问框
            $(".exitbtn").on("click", function () {
                layui.use('layer', function () {
                    var layer = layui.layer;
                    layer.confirm('确认退出?', {
                        icon: 3,
                        title: '提示',
                        offset: '200px',
                        resize: false,
                        move: false,
                        yes: function (index, layero) {
                            $.ajax({
                                url: "exitsession",
                                success: function (e) {
                                    if (e == "ok") {
                                        window.location.href = "rlogin"
                                    }
                                }
                            }),
                                layer.close(index);
                        }
                        // 取消按钮
                        , btn2: function (index, layero) {
                            layer.close(index);
                        }
                    });
                });
            })
        })


})