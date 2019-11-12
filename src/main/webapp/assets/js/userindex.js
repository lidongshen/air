window.onload = function () {
    var zong = document.querySelector(".zong")
    var boxlist = document.querySelectorAll(".box>a")
    var box = document.querySelector(".box")

    var btn1 = document.querySelectorAll(".btn1>div")
    var clientwidth = document.documentElement.clientWidth
    var num = 0
    function move() {
        num++
        if (num >3) {
            animate2(box, { left: -num * clientwidth },function(){
                box.style.left=0
            })
            num=0
        }else{
            animate2(box, { left: -num * clientwidth })
        }
        for (var i = 0; i < btn1.length; i++) {
            btn1[i].style.background = ""
        }
        btn1[num].style.background = "red"
    }
    var t = setInterval(move, 2000);
    zong.onmouseover = function () {
        clearInterval(t)
    }
    zong.onmouseout = function () {
        t = setInterval(move, 2000)
    }
    for (var i = 0; i < btn1.length; i++) {
        (function (i) {
            btn1[i].onclick = function () {
                num = i
                animate(box, { left: -num * clientwidth })
                for (var j = 0; j < btn1.length; j++) {
                    btn1[j].style.background = ""
                }
                btn1[num].style.background = "red"
            }
        })(i)
    }
}