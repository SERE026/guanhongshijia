$(function () {
    head();
    //suspension();
    Timelimit();
    //PlacedTop(); //置顶
    prompt();

    Backswitch();

    cityList();

    FloorFive();// 5楼
})
function head() {
    $(".Search-categories").mouseover(function () { $(".Search-categories>ul").show(); $(this).find("i").addClass("icon-top").removeClass('icon-bottom'); })
    $(".Search-categories").mouseout(function () { $(".Search-categories>ul").hide();$(this).find("i").addClass("icon-bottom").removeClass('icon-top'); })
    $(".Search-categories ul li").click(function () {
        var name = $(this).text();
        $(".Search-categories>label>span").text(name); $(".Search-categories>ul").hide();
    })
    $(".FocusOn").mouseover(function () {
        $('.FocusOn').removeClass('block');
        $(this).addClass('block');
        $('.FocusOn').find('i').attr('class','top')
        $(this).find('i').attr('class','down');
        $(this).children('.mobile_list').removeClass('none')
    })
    $('.FocusOn').mouseout(function () {
        $('.FocusOn').removeClass('block');
        $('.FocusOn').find('i').attr('class','top')
        $(this).children('.mobile_list').addClass('none')
    })
    /*$("#mobile_list").bind("mouseout",function () {
        $("#mobile_list").hide();
    })*/
}

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

    //热卖商品
    $(".hot-small ul li a").mouseover(function () {
        $(this).addClass("hotBack").parent().siblings().children().removeClass("hotBack")
        var tag = $(this).attr("data-tag");
        $(".Showcase ." + tag).addClass("block_red").siblings().removeClass("block_red");
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

function prompt() {
    var top,text,id='',cls;
    $(".prompt").hover(function () {
        top = $(this).position().top;
        text = $(this).find("a").text();
        id=$(this).attr('data-id');
        // console.log(id)
    })
    $(document).mouseover(function (e) {
        var _con = $('.prompt,.three-level,.furniture ul');   // 设置目标区域
        if (!_con.is(e.target) && _con.has(e.target).length === 0) { // Mark 1
            $(".three-level").hide();
        } else {
            $(".three-level").css("top", top + 52);
            $(".three-level").hide();
            $("#"+id).show();
            $(".three-level h4 span").text(text);
        }
    });
}

function Backswitch() {
    $(".LiBtn ul li").click(function () {
        var tag = $(this).attr("title");
    })
    
}



function cityList() {
    $(document).mouseover(function (e) {
        var _con = $('.Switch-city,.hide_city_group');   // 设置目标区域
        if (!_con.is(e.target) && _con.has(e.target).length === 0) { // Mark 1
            $(".hide_city_group").hide();
        } else {
            $(".hide_city_group").show();
        }
    });

    ///点击字母跳到
    $("#JS_header_city_char a").bind("click", function () {
        var anchorname = $(this).attr("anchorname");
        var getchar = document.getElementById(anchorname);
        if (getchar) {
            getchar.scrollIntoView(false);
        }
    });

    $(".hot_city a,.city_list .icity_names a").bind("click", function () {
        var cityValue = $(this).text();
        $(".city-name").text(cityValue);
        $(".hide_city_group").hide();
    })
}

function FloorFive() {
    $(".FiveNav li").click(function () {
        var num = $(this).index();
        $(this).addClass("fiveNav").siblings().removeClass("fiveNav");
        $(".FiveContent:eq(" + num + ")").removeClass("none").siblings(".FiveContent").addClass("none");
    })
}