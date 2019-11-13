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
    
    
    
    
    
    layui.use('element', function(){
    	  var $ = layui.jquery
    	  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
    	  
    	  //触发事件
    	  var active = {
    	    tabAdd: function(){
    	      //新增一个Tab项
    	      element.tabAdd('demo', {
    	        title: '新选项'+ (Math.random()*1000|0) //用于演示
    	        ,content: '内容'+ (Math.random()*1000|0)
    	        ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
    	      })
    	    }
    	    ,tabDelete: function(othis){
    	      //删除指定Tab项
    	      element.tabDelete('demo', '44'); //删除：“商品管理”
    	      
    	      
    	      othis.addClass('layui-btn-disabled');
    	    }
    	    ,tabChange: function(){
    	      //切换到指定Tab项
    	      element.tabChange('demo', '22'); //切换到：用户管理
    	    }
    	  };
    	  
    	  $('.site-demo-active').on('click', function(){
    	    var othis = $(this), type = othis.data('type');
    	    active[type] ? active[type].call(this, othis) : '';
    	  });
    	  
    	  //Hash地址的定位
    	  var layid = location.hash.replace(/^#test=/, '');
    	  element.tabChange('test', layid);
    	  
    	  element.on('tab(test)', function(elem){
    	    location.hash = 'test='+ $(this).attr('lay-id');
    	  });
    	  
    	});
    
    
}