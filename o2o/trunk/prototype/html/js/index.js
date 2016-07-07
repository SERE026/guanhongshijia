$(function () {
    //suspension();
    Timelimit();
    //PlacedTop(); //置顶
})

function suspension() {
    $(".nav-ul>ul>li:eq(0)").mouseover(function () { $(".nav-ul>ul>li>ul").css("display","block") })
    $(".nav-ul>ul>li:eq(0)").mouseout(function () { $(".nav-ul>ul>li>ul").css("display","none") })
}

function Timelimit() {
    $(".Time-limit-nav>b").click(function () {
        var NavCls = $(this).attr("name");
        $(this).addClass("PitchOn").siblings().removeClass();
        if (NavCls == "Time-limit-area") {
            $(".Time-limit-area").show(); $(".custom-area").hide();
        } else { $(".Time-limit-area").hide(); $(".custom-area").show(); }
    })
}

function PlacedTop() {
    $(".PlacedTop-Btn").click(function () {
        window.top.location = window.self.location;
    })
}

// 获取置顶对象

var obj = document.getElementById('scroll');

var scrollTop = null;

// 置顶对象点击事件

obj.onclick = function () {

    var timer = setInterval(function () {

        window.scrollBy(0, -100);

        if (scrollTop == 0)

            clearInterval(timer);

    }, 2);

}

// 窗口滚动检测

window.onscroll = function () {

    scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;

    obj.parentNode.parentNode.style.display = (scrollTop >= 600) ? "block" : "none";

}