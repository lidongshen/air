$(function () {
    $("form").validate({
        rules: {
            bname: {required: true, rangelength: [2, 10]},
            bpwd: {required: true, minlength: 6}
        },
        messages: {
            bname: {
                required: "请输入用户名",
                rangelength: "用户名不能小于2个字符，不能大于10个字符"
            },
            bpwd: {
                required: "请输入密码",
                minlength: "密码最少位6位"
            }
        }
    })

    $("#commit").on('click', function () {
        var data = "bname=" + $("#bname").val() + "&bpwd=" + $("#bpwd").val();
        $.ajax({
            url: "bosslogin",
            data: data,
            type: 'post',
            success: function (e) {
                if (e == 'ok') {
                    window.location.href = "boss";
                } else {
                    alert("账号密码错误，请从新输入");

                }
            }
        })
    })
})