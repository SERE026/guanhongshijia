<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>首页</title>
  <link href="../css/index.css" rel="stylesheet" />
    <script src="/js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
    var servicePath="${rc.contextPath}";
    </script>
    <style>
        .Add-art{
            border:none !important;
        }
    </style>
</head>
<body>
<div style="background-color: #f0ecec;">
    <div class="head-top">
        <div>
            <!--<a class="positioning" href="javascript:void(0);"></a>--><label class="head-welcome inline-block">欢迎光临观红世家</label>
            <a class="head-login inline-block" href="${rc.contextPath}/login.html">请登录</a>
            <a class="inline-block" href="${rc.contextPath}/register.html" style="margin-left: 1em;">免费注册</a>
            <ul class="head-ul">
                <li><a href="${rc.contextPath}/login.html">我的信息</a></li>
                <li><a href="javascript:void(0)">移动客户端</a></li>
                <li><a href="javascript:void(0)">关注观红世家</a></li>
                <li><a href="javascript:void(0)">客服中心</a></li>
                <li><a href="javascript:void(0)">全国热线&nbsp;4006487818</a></li>
            </ul>
        </div>
    </div>

</div>
<div class="head">
    <div class="head-logo">
        <div class="logo">
            <img src="../img/logo.jpg" />
        </div>
        <div class="head-city">
            <div class="city">
                <label class="color-red city-name">全国站</label><label class="Switch-city">切换城市<!--<i></i>--></label>
                <div id="JS_header_city_bar_box" class="hide_city_group">
                    <div class="hideMap">
                        <div class="showPanel f-cb">
                            <div class="mycity">
                                <div style="display: block;">
                                    当前城市: <strong id="JS_city_current_city">全国</strong>
                                </div>
                            </div>
                            <a class="near" target="_blank" href="${rc.contextPath}/shopMap.html">附近的体验馆</a>
                        </div>
                        <div class="showPanel showPanel2 f-cb">
                            <div class="hot_city" id="JS_header_city_hot">
                                <a href="javascript:void(0);" class="site_all Left" cityid="ALL" onclick="changeCity(this)">全国站</a>
                                <a href="javascript:void(0);" provincecode="110000" class="for_search" cityid="110000" onclick="changeCity(this)">北京市</a>
                                <a href="javascript:void(0);" provincecode="120000" class="for_search" cityid="120000" onclick="changeCity(this)">天津市</a>
                                <a href="javascript:void(0);" provincecode="500000" class="for_search" cityid="500000" onclick="changeCity(this)">重庆市</a>
                                <a href="javascript:void(0);" provincecode="440300" class="for_search" cityid="440300" onclick="changeCity(this)">深圳市</a>
                            </div>
    <!--                        <div class="mt10">
                                <div id="JS_search_city_tip_header" class="search_city_tip">对不起，没搜索到这个城市。</div>
                                <input id="JS_search_city_input_header" class="search_city_input" placeholder="城市名称"><input type="button" id="JS_search_city_submit_header" class="search_city_submit" value="搜索">
                            </div>-->
                            <div class="city_words mt10" id="JS_header_city_char"><a href="javascript:void(0)" anchorname="charA">A</a><a href="javascript:void(0)" anchorname="charB">B</a><a href="javascript:void(0)" anchorname="charC">C</a><a href="javascript:void(0)" anchorname="charD">D</a><a href="javascript:void(0)" anchorname="charE">E</a><a href="javascript:void(0)" anchorname="charF">F</a><a href="javascript:void(0)" anchorname="charG">G</a><a href="javascript:void(0)" anchorname="charH">H</a><a href="javascript:void(0)" anchorname="charI">I</a><a href="javascript:void(0)" anchorname="charJ">J</a><a href="javascript:void(0)" anchorname="charK">K</a><a href="javascript:void(0)" anchorname="charL">L</a><a href="javascript:void(0)" anchorname="charM">M</a><a href="javascript:void(0)" anchorname="charN">N</a><a href="javascript:void(0)" anchorname="charP">P</a><a href="javascript:void(0)" anchorname="charQ">Q</a><a href="javascript:void(0)" anchorname="charR">R</a><a href="javascript:void(0)" anchorname="charS">S</a><a href="javascript:void(0)" anchorname="charT">T</a><a href="javascript:void(0)" anchorname="charW">W</a><a href="javascript:void(0)" anchorname="charX">X</a><a href="javascript:void(0)" anchorname="charY">Y</a><a href="javascript:void(0)" anchorname="charZ">Z</a></div>
                        </div>
                        <div class="scrollBody">
                            <div class="cityMap clearfix">
                                <div id="JS_header_city_list" class="city_list">
                                    <div class="icity_names_wrap" id="charB">
                                        <a class="icity_firstword" href="javascript:void(0);">B</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="110000">北京市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="130600">保定市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="371600">滨州市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="511900">巴中市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charC">
                                        <a class="icity_firstword" href="javascript:void(0);">C</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="130900">沧州市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="430100">长沙市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="430700">常德市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="431000">郴州市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="500000">重庆市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="510100">成都市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charD">
                                        <a class="icity_firstword" href="javascript:void(0);">D</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="370500">东营市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="371400">德州市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="510600">德阳市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="511700">达州市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charG">
                                        <a class="icity_firstword" href="javascript:void(0);">G</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="510800">广元市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charH">
                                        <a class="icity_firstword" href="javascript:void(0);">H</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="130400">邯郸市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="131100">衡水市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="430400">衡阳市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="431200">怀化市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charJ">
                                        <a class="icity_firstword" href="javascript:void(0);">J</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="370100">济南市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="370800">济宁市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charL">
                                        <a class="icity_firstword" href="javascript:void(0);">L</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="131000">廊坊市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="371200">莱芜市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="371300">临沂市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="371500">聊城市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="431300">娄底市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="510500">泸州市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="511100">乐山市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="513400">凉山彝族自治州</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charM">
                                        <a class="icity_firstword" href="javascript:void(0);">M</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="510700">绵阳市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="511400">眉山市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charN">
                                        <a class="icity_firstword" href="javascript:void(0);">N</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="511000">内江市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="511300">南充市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charQ">
                                        <a class="icity_firstword" href="javascript:void(0);">Q</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="130300">秦皇岛市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="370200">青岛市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charR">
                                        <a class="icity_firstword" href="javascript:void(0);">R</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="371100">日照市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charS">
                                        <a class="icity_firstword" href="javascript:void(0);">S</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="130100">石家庄市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="430500">邵阳市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="440300">深圳市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="510900">遂宁市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charT">
                                        <a class="icity_firstword" href="javascript:void(0);">T</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="120000">天津市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="130200">唐山市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="370900">泰安市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charW">
                                        <a class="icity_firstword" href="javascript:void(0);">W</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="370700">潍坊市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="371000">威海市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charX">
                                        <a class="icity_firstword" href="javascript:void(0);">X</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="130500">邢台市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="430300">湘潭市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charY">
                                        <a class="icity_firstword" href="javascript:void(0);">Y</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="321000">扬州市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="370600">烟台市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="430600">岳阳市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="430900">益阳市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="431100">永州市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="511500">宜宾市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="511800">雅安市</a>
                                        </div>
                                    </div>
                                    <div class="icity_names_wrap" id="charZ">
                                        <a class="icity_firstword" href="javascript:void(0);">Z</a>
                                        <div class="icity_names">
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="130700">张家口市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="370300">淄博市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="370400">枣庄市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="430200">株洲市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="430800">张家界市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="510300">自贡市</a>
                                            <a class="icity_names_a for_search" href="javascript:void(0);" onclick="changeCity(this)" cityid="512000">资阳市</a>
                                        </div>
                                    </div>

                                </div>

                            </div>
                            <div class="scrollBar"><span id="JS_header_city_bar" style="margin-top: 18px;"></span></div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- <h4>观红赏灯O2O商城</h4>
            <h4>首家音视频多媒体平台</h4>-->

        </div>
        <div class="search-criteria">
            <div>
                <div class="Search-categories">
                    <label>商品</label><i></i>
                    <ul style="display: none;">
                        <li>店铺</li>
                    </ul>
                </div>
                <input class="Search-Text" type="text" placeholder="输入您想要搜索的关键字" value=""/>
                    <span class="search">
                        <i></i>
                        <label>搜索</label></span>
                <a class="My-mall font14" href="${rc.contextPath}/login.html">我的商城</a>
                <a class="settlement font14" href="${rc.contextPath}/cars.html">购物车结算</a>
            </div>
            <div>
                <ul class="hot-search font14">
                    <li>热门搜索：&nbsp;&nbsp;</li>
                    <li><a href="javascript:void(0)">卧室</a></li>
                    <li><a href="javascript:void(0)">衣柜</a></li>
                    <li><a href="javascript:void(0)">衣帽间</a></li>
                    <li><a href="javascript:void(0)">书柜</a></li>
                    <li><a href="javascript:void(0)">酒柜</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="nav">
    <div class="navigation">
        <div class="nav-ul">
            <ul>
                <li><a class="Classification-goods" href="javascript:void(0)">所有商品分类</a>
                    <ul>

                       <#list goodsSortList as p>
                           <#if p_index lt 4>
                        <li><a href="javascript:void(0)">
                            <img src="${rc.contextPath}${p.imagesrc?if_exists}" />${p.name?if_exists}</a>
                        </li>
                           <#if p.extendshow==1>
                               <li>
                                   <div class="classical furniture">
                                       <ul>
                                           <#list p.children as c>
                                                   <li class="prompt" id="pro${c.goodsSort_id}"><a href="javascript:void(0)">${c.name?if_exists}</a></li>
                                               <#if p_index==5><#break></#if>
                                           </#list>
                                       </ul>
                                   </div>
                               </li>
                           </#if>
                           </#if>

                        </#list>
                    </ul>
                </li>
                <li><a href="javascript:void(0)">云导购</a></li>
                <li><a href="javascript:void(0)">品牌汇</a></li>
                <li><a href="javascript:void(0)">全国体验馆</a></li>
                <li><a href="javascript:void(0)">艺术品</a></li>
                <li><a href="javascript:void(0)">团购</a></li>
                <li><a href="javascript:void(0)">招商加盟</a></li>
                <li><a href="javascript:void(0)">全屋高端定制</a></li>
            </ul>

   <!--       <div class="three-level">
                <h4><span>卧室家具</span>&nbsp;>></h4>
                <span>卧室1279件商品>></span>
                <ul>
                    <li><a href="javascript:void(0)">床</a></li>
                    <li><a href="javascript:void(0)">床垫</a></li>
                    <li><a href="javascript:void(0)">衣柜</a></li>
                    <li><a href="javascript:void(0)">美规床</a></li>
                    <li><a href="javascript:void(0)">美国进口床垫</a></li>
                    <li><a href="javascript:void(0)">床</a></li>
                    <li><a href="javascript:void(0)">床</a></li>
                    <li><a href="javascript:void(0)">床</a></li>
                    <li><a href="javascript:void(0)">床</a></li>
                    <li><a href="javascript:void(0)">床垫</a></li>
                    <li><a href="javascript:void(0)">衣柜</a></li>
                    <li><a href="javascript:void(0)">床</a></li>
                </ul>
                <div>
                    <img width="370" height="160" src="../img/10.png" />
                </div>
            </div>-->
        </div>
    </div>
</div>
<div class="advertising">
    <div class="focus" id="focus001">
        <ul>

            <#list advwzList.adv as p>
            <li>
                <a href="#" target="_blank">
                <img src="../img/20.png" /><!--adv_flie-->
                </a>
            </li>
                <#if p_index==2><#break></#if>
            </#list>

 <!--           <li><a href="javascript:void(0)" target="_blank">
                <img src="../img/20.png" /></a></li>
            <li><a href="javascript:void(0)" target="_blank">
                <img src="../img/20.png" /></a></li>-->
        </ul>
    </div>
    <div class="advertising-back">
        <!--<div class="LiBtn">
            <div>
          <ul>
            <li title="1" tag="../img/20.png"></li>
            <li title="2" tag="../img/21.png"></li>
            <li title="3" tag="../img/22.png"></li>
        </ul>
            </div>
        </div>-->
        <div class="experience">
            <div>

                <p>高端定制尽在老东方</p>
                <p>观红世家夜市O2O云平台</p>
                <img src="" />
                <p class="thisHome" id="area">
                    <b>深圳市<label>1</label>家</b>
                </p>
                <p class="national">全国19家体验馆</p>
                <p><a class="findHome" href="${rc.contextPath}/shopMap.html">查找身边的体验馆</a></p>
                <p>网站浏览&nbsp;实体店购买一站式服务！</p>
            </div>
        </div>
    </div>
</div>
<div class="browse">

    <div class="hot-small">
        <ul>
            <li><a href="javascript:void(0)" data-tag="n1">热卖商品</a> </li>
            <li><a href="javascript:void(0)" data-tag="n2">疯狂抢购</a> </li>
            <li><a href="javascript:void(0)" data-tag="n3">热评商品</a> </li>
            <li><a href="javascript:void(0)" data-tag="n4">新品上架</a> </li>
            <li><a href="javascript:void(0)" data-tag="n5">限时抢购</a> </li>
        </ul>
    </div>
    <div class="Showcase">
        <!--展示区-->
        <ul class="borderHover n1 block_red">
            <#list reMai.goodsList as p>
                <li>
                    <dl class="Item-introduction">
                        <dt><a href="${rc.contextPath}/item-${p.goods.goods_id}.html">
                            <img src="${p.goods.defaultImage}"/></a></dt>
                        <dd class="dd-Item-name"><a href="${rc.contextPath}/item-${p.goods.goods_id}.html">${p.goods.name}</a></dd>
                        <dd class="price"><b>￥${p.goods.salesMoney}</b><a class="Add-art" href="javascript:void(0)"><#--<img src="../img/icon-cart-add.png" />--></a><a class="More" href="${rc.contextPath}/item-${p.goods.goods_id}.html">MORE</a></dd>
                    </dl>
                </li>
                <#if p_index==4><#break></#if>
            </#list>
        </ul>

        <ul class="borderHover n2">
            <#list qiangGou.goodsList as p>
            <li>
                <dl class="Item-introduction">
                    <dt><a href="${rc.contextPath}/item-${p.goods.goods_id}.html">
                        <img src="${p.goods.defaultImage}" /></a></dt>
                    <dd class="dd-Item-name"><a href="${rc.contextPath}/item-${p.goods.goods_id}.html">
                        ${p.goods.name}</a></dd>
                    <dd class="price"><b>￥${p.goods.salesMoney}</b><a class="Add-art" href="javascript:void(0)"><#--<img src="../img/icon-cart-add.png" />--></a>
                        <a class="More" href="${rc.contextPath}/item-${p.goods.goods_id}.html">MORE</a></dd>
                </dl>
            </li>
                <#if p_index==4><#break></#if>
            </#list>

        </ul>

        <ul class="borderHover n3">
            <#list rePin.goodsList as p>
            <li>
                <dl class="Item-introduction">
                    <dt><a href="${rc.contextPath}/item-${p.goods.goods_id}.html">
                        <img src="../img/03.jpg" /></a></dt>
                    <dd class="dd-Item-name"><a href="${rc.contextPath}/item-${p.goods.goods_id}.html">
                        ${p.goods.name}</a></dd>
                    <dd class="price"><b>￥${p.goods.salesMoney}</b><a class="Add-art" href="javascript:void(0)"><#--<img src="../img/icon-cart-add.png" />--></a>
                        <a class="More" href="${rc.contextPath}/item-${p.goods.goods_id}.html">MORE</a></dd>
                </dl>
            </li>
                <#if p_index==4><#break></#if>
            </#list>

        </ul>

        <ul class="borderHover n4">
            <#list new.goodsList as p>
            <li>
                <dl class="Item-introduction">
                    <dt><a href="${rc.contextPath}/item-${p.goods.goods_id}.html">
                        <img src="../img/03.jpg" /></a></dt>
                    <dd class="dd-Item-name"><a href="${rc.contextPath}/item-${p.goods.goods_id}.html">
                        ${p.goods.name}</a></dd>
                    <dd class="price"><b>￥${p.goods.salesMoney}</b><a class="Add-art" href="javascript:void(0)"><#--<img src="../img/icon-cart-add.png" />--></a>
                        <a class="More" href="${rc.contextPath}/item-${p.goods.goods_id}.html">MORE</a></dd>
                </dl>
            </li>
                <#if p_index==4><#break></#if>
            </#list>

        </ul>

        <ul class="borderHover n5">
            <#list xianShi.goodsList as p>
            <li>
                <dl class="Item-introduction">
                    <dt><a href="${rc.contextPath}/item-${p.goods.goods_id}.html">
                        <img src="../img/03.jpg" /></a></dt>
                    <dd class="dd-Item-name"><a href="${rc.contextPath}/item-${p.goods.goods_id}.html">
                        ${p.goods.name}</a></dd>
                    <dd class="price"><b>￥${p.goods.salesMoney}</b><a class="Add-art" href="javascript:void(0)"><#--<img src="../img/icon-cart-add.png" />--></a>
                        <a class="More" href="${rc.contextPath}/item-${p.goods.goods_id}.html">MORE</a></dd>
                </dl>
            </li>
                <#if p_index==4><#break></#if>
            </#list>
        </ul>
    </div>
    <div class="Time-limit">
        <p class="Time-limit-nav"><b class="PitchOn" name="Time-limit-area">限时抢购</b><b name="custom-area">家居定制</b></p>
        <div class="area Time-limit-area">
            <div class="area-img">
                <img src="../img/04.jpg" />
            </div>
            <ul class="borderHover">

            <#list activeList as p>
                <li>
                    <dl class="">
                        <dt><a href="javascript:void(0)">
                            <img src="../img/03.jpg" /></a></dt>
                        <dd class="ItemTitle"><b>老东方罗汉沙发</b></dd>
                        <dd class="ItemName"><a href="javascript:void(0)">${p.name?if_exists}</a></dd>
                        <dd class="ItemPrice"><b>￥${p.salesMoney}</b></dd>
                        <dd><a class="Add-art" href="javascript:void(0)">
                            <#--<img src="../img/icon-cart-add.png" />--></a><a class="More" href="javascript:void(0)">MORE</a></dd>
                    </dl>
                </li>
                <#if p_index==3><#break></#if>
            </#list>

            </ul>
        </div>
        <div class="area custom-area">
            家具定制
        </div>
    </div>

    <br />
    <div id="FloorOne" class="Floor FloorOne">
        <div class="FloorHead">
            <div class="FloorID">
                <img src="../img/house.png" />
                <b>1F</b><span>${goodsSortList1.name}</span>
            </div>
            <div class="FloorBack">
                <span class="backLeft">SANITARY WARE</span>
                <span class="backRight">查看更多 MORE</span>
            </div>
        </div>
        <div class="FloorImg">
            <h1>${goodsSortList1.name}</h1>
            <div class="tag">
                <p>${goodsSortList1.engname?if_exists}</p>
                <div class="font6"><p>${goodsSortList1.engdesc?if_exists}</p></div>
            </div>
            <ul>
                <#list goodsSortList1.children as d>
                    <li><a href="javascript:void(0);">${d.name?if_exists}</a></li>
                </#list>
            </ul>
            <img src="../img/08.png" />
        </div>
        <div class="floor-banner">
            <div>
                <ul class="borderHover">
                    <#list goodsList1 as d>
                        <#if d_index lt 6 >
                            <li>
                                <dl class="">
                                    <dt><a href="javascript:void(0)">
                                        <img src="../img/03.jpg" /></a></dt>
                                    <dd class=""><a class="Introduction" href="javascript:void(0)">
                                        ${d.name?if_exists}</a></dd>
                                    <dd class="price"><b class="Item-price">￥${d.salesMoney}</b></dd>
                                </dl>
                            </li>
                        </#if>
                    </#list>
                </ul>
            </div>
            <div class="floor-banner-img">
                <#list goodsList1 as d>
                    <#if d_index == 7>
                        <img src="../img/07.png" /><br />
                    </#if>
                    <#if d_index == 8>
                        <img src="../img/07.png" /><br />
                    </#if>
                </#list>
            </div>
        </div>
        <div class="Floor-bottom">
            <br />
            <ul class="borderHover">
                <#list goodsList1 as d>
                    <#if d_index gt 8 && d_index lt 12 >
                        <li>
                            <dl class="Item-introduction">
                                <dt><a href="javascript:void(0)">
                                    <img src="../img/03.jpg" /></a></dt>
                                <dd class="dd-Item-name"><a class="Introduction" href="javascript:void(0)">
                                    ${d.name?if_exists}</a></dd>
                                <dd class="hot-cakes">（热销${d.num}件）</dd>
                                <dd class="Item-price"><b>￥${d.salesMoney}</b></dd>
                                <dd><a class="Add-art" href="javascript:void(0)">
                                    <#--<img src="../img/icon-cart-add.png" />--></a><a class="More" href="javascript:void(0)">MORE</a></dd>
                            </dl>
                        </li>
                    </#if>
                </#list>
            </ul>
        </div>
    </div>
    <div id="FloorTwo" class="Floor FloorTwo">
        <div class="FloorHead">
            <div class="FloorID">
                <img src="../img/house.png" />
                <b>2F</b><span>${goodsSortList2.name}</span>
            </div>
            <div class="FloorBack">
                <span class="backLeft">SANITARY WARE</span>
                <span class="backRight">查看更多 MORE</span>
            </div>
        </div>
        <div class="FloorImg">
            <h1>${goodsSortList2.name}</h1>
            <div class="tag">
                <p>${goodsSortList2.engname?if_exists}</p>
                <div class="font6"><p>${goodsSortList2.engdesc?if_exists}</p></div>
            </div>
            <ul>
                <#list goodsSortList2.children as d>
                    <li><a href="javascript:void(0);">${d.name?if_exists}</a></li>
                </#list>
            </ul>
            <img src="../img/08.png" />
        </div>
        <div class="floor-banner">
            <div>
                <ul class="borderHover">
                    <#list goodsList2 as d>
                        <#if d_index lt 6 >
                            <li>
                                <dl class="">
                                    <dt><a href="javascript:void(0)">
                                        <img src="../img/03.jpg" /></a></dt>
                                    <dd class=""><a class="Introduction" href="javascript:void(0)">
                                        ${d.name?if_exists}</a></dd>
                                    <dd class="price"><b class="Item-price">￥${d.salesMoney}</b></dd>
                                </dl>
                            </li>
                        </#if>
                    </#list>
                </ul>
            </div>
            <div class="floor-banner-img">
                <#list goodsList2 as d>
                    <#if d_index == 7>
                        <img src="../img/07.png" /><br />
                    </#if>
                    <#if d_index == 8>
                        <img src="../img/07.png" /><br />
                    </#if>
                </#list>
            </div>
        </div>
        <div class="Floor-bottom">
            <br />
            <ul class="borderHover">
                <#list goodsList2 as d>
                    <#if d_index gt 8 && d_index lt 12 >
                        <li>
                            <dl class="Item-introduction">
                                <dt><a href="javascript:void(0)">
                                    <img src="../img/03.jpg" /></a></dt>
                                <dd class="dd-Item-name"><a class="Introduction" href="javascript:void(0)">
                                    ${d.name?if_exists}</a></dd>
                                <dd class="hot-cakes">（热销${d.num}件）</dd>
                                <dd class="Item-price"><b>￥${d.salesMoney}</b></dd>
                                <dd><a class="Add-art" href="javascript:void(0)">
                                    <#--<img src="../img/icon-cart-add.png" />--></a><a class="More" href="javascript:void(0)">MORE</a></dd>
                            </dl>
                        </li>
                    </#if>
                </#list>
            </ul>
        </div>
    </div>
    <div id="FloorThree" class="Floor FloorThree">
        <div class="FloorHead">
            <div class="FloorID">
                <img src="../img/house.png" />
                <b>3F</b><span>${goodsSortList3.name}</span>
            </div>
            <div class="FloorBack">
                <span class="backLeft">SANITARY WARE</span>
                <span class="backRight">查看更多 MORE</span>
            </div>
        </div>
        <div class="FloorImg">
            <h1>${goodsSortList3.name}</h1>
            <div class="tag">
                <p>${goodsSortList3.engname?if_exists}</p>
                <div class="font6"><p>${goodsSortList3.engdesc?if_exists}</p></div>
            </div>
            <ul>
                <#list goodsSortList3.children as d>
                    <li><a href="javascript:void(0);">${d.name?if_exists}</a></li>
                </#list>
            </ul>
            <img src="../img/08.png" />
        </div>
        <div class="floor-banner">
            <div>
                <ul class="borderHover">
                    <#list goodsList3 as d>
                        <#if d_index lt 6 >
                            <li>
                                <dl class="">
                                    <dt><a href="javascript:void(0)">
                                        <img src="../img/03.jpg" /></a></dt>
                                    <dd class=""><a class="Introduction" href="javascript:void(0)">
                                        ${d.name?if_exists}</a></dd>
                                    <dd class="price"><b class="Item-price">￥${d.salesMoney}</b></dd>
                                </dl>
                            </li>
                        </#if>
                    </#list>
                </ul>
            </div>
            <div class="floor-banner-img">
                <#list goodsList3 as d>
                    <#if d_index == 7>
                        <img src="../img/07.png" /><br />
                    </#if>
                    <#if d_index == 8>
                        <img src="../img/07.png" /><br />
                    </#if>
                </#list>
            </div>
        </div>
        <div class="Floor-bottom">
            <br />
            <ul class="borderHover">
                <#list goodsList3 as d>
                    <#if d_index gt 8 && d_index lt 12 >
                        <li>
                            <dl class="Item-introduction">
                                <dt><a href="javascript:void(0)">
                                    <img src="../img/03.jpg" /></a></dt>
                                <dd class="dd-Item-name"><a class="Introduction" href="javascript:void(0)">
                                    ${d.name?if_exists}</a></dd>
                                <dd class="hot-cakes">（热销${d.num}件）</dd>
                                <dd class="Item-price"><b>￥${d.salesMoney}</b></dd>
                                <dd><a class="Add-art" href="javascript:void(0)">
                                    <#--<img src="../img/icon-cart-add.png" />--></a><a class="More" href="javascript:void(0)">MORE</a></dd>
                            </dl>
                        </li>
                    </#if>
                </#list>
            </ul>
        </div>
    </div>

    <div id="FloorFour" class="Floor FloorFour">
        <div class="FloorHead">
            <div class="FloorID">
                <img src="../img/house.png" />
                <b>4F</b><span>${goodsSortList4.name}</span>
            </div>
            <div class="FloorBack">
                <span class="backLeft">SANITARY WARE</span>
                <span class="backRight">查看更多 MORE</span>
            </div>
        </div>
        <div class="FloorImg">
            <h1>${goodsSortList4.name}</h1>
            <div class="tag">
                <p>${goodsSortList4.engname?if_exists}</p>
                <div class="font6"><p>${goodsSortList4.engdesc?if_exists}</p></div>
            </div>
            <ul>
                <#list goodsSortList4.children as d>
                    <li><a href="javascript:void(0);">${d.name?if_exists}</a></li>
                </#list>
            </ul>
                <img src="../img/08.png" />
        </div>
        <div class="floor-banner">
            <div>
                <ul class="borderHover">
                    <#list goodsList4 as d>
                        <#if d_index lt 6 >
                        <li>
                        <dl class="">
                            <dt><a href="javascript:void(0)">
                                <img src="../img/03.jpg" /></a></dt>
                            <dd class=""><a class="Introduction" href="javascript:void(0)">
                                ${d.name?if_exists}</a></dd>
                            <dd class="price"><b class="Item-price">￥${d.salesMoney}</b></dd>
                        </dl>
                     </li>
                        </#if>
                    </#list>
                </ul>
            </div>
            <div class="floor-banner-img">
                <#list goodsList4 as d>
                    <#if d_index == 7>
                        <img src="../img/07.png" /><br />
                    </#if>
                    <#if d_index == 8>
                        <img src="../img/07.png" /><br />
                    </#if>
                </#list>
            </div>
        </div>
        <div class="Floor-bottom">
            <br />
            <ul class="borderHover">
                <#list goodsList4 as d>
                    <#if d_index gt 8 && d_index lt 12 >
                <li>
                    <dl class="Item-introduction">
                        <dt><a href="javascript:void(0)">
                            <img src="../img/03.jpg" /></a></dt>
                        <dd class="dd-Item-name"><a class="Introduction" href="javascript:void(0)">
                            ${d.name?if_exists}</a></dd>
                        <dd class="hot-cakes">（热销${d.num}件）</dd>
                        <dd class="Item-price"><b>￥${d.salesMoney}</b></dd>
                        <dd><a class="Add-art" href="javascript:void(0)">
                            <#--<img src="../img/icon-cart-add.png" />--></a><a class="More" href="javascript:void(0)">MORE</a></dd>
                    </dl>
                </li>
                    </#if>
                </#list>
            </ul>
        </div>
    </div>


    <!--第五楼-->
<!--    <div id="FloorFive" class="Floor FloorFive">

        <div class="FloorHead">
            <div class="FloorID">
                <img src="../img/house.png" />
                <b>5F</b><span>综合系列</span>
            </div>
            <div class="FloorBack">
                <span class="backLeft">SANITARY WARE</span>
                <span class="backRight">查看更多 MORE</span>
            </div>
        </div>-->

    <div id="FloorFive" class="Floor FloorFive">
        <div class="FloorHead">
            <div class="FloorID">
                <img src="../img/house.png" />
                <b>5F</b><span>综合系列</span>
                <ul class="FiveNav">
                    <#list goodsSortList5 as p>
                        <#if p_index == 0>
                        <li class="FH_current">${p.name?if_exists}</li>
                        </#if>
                        <#if p_index != 0>
                            <li>${p.name?if_exists}</li>
                        </#if>
                        <#if p_index==7><#break></#if>
                    </#list>
<#--                    <li>办公系列</li>
                    <li>家具灯饰</li>
                    <li>建材软装</li>
                    <li>字画</li>
                    <li>文房四宝</li>
                    <li>红酒古茶</li>-->

                </ul>
            </div>
            <div class="FloorBack">
                <span class="backLeft">SANITARY WARE</span>
                <span class="backRight">查看更多 MORE</span>
            </div>
        </div>

<#list lists as s>
    <#if s_index==0>
        <div class="FiveContent">
            <div class="FloorImg">
                <h1>综合系列00000</h1>
                <div class="tag">
                    <p>CERAMICS</p>
                    <p>FOR DALY USE</p>
                    <div class="font6"><p>asdafb asd asdjba sd asdasdsdasjcvakbckjabcahcwjk</p><p>afdiasnvvs aisdhoai s</p></div>
                </div>
                <img src="../img/08.png" style="margin-top:40px;" />
                <ul>
               <#list brandList as p>
                    <li><a href="javascript:void(0);"><img src="${rc.contextPath}${p.logo}"/></a></li>
                    <#if p_index==3><#break></#if>
                </#list>
                </ul>
            </div>



            <div class="floor-banner">
                <div>
                    <ul class="borderHover">

                        <#list s as a>
                            <#if a_index lt 6>
                                <li>
                                    <dl class="">
                                        <dt><a href="javascript:void(0)">
                                            <img src="../img/03.jpg" /></a></dt>
                                        <dd class=""><a class="Introduction" href="javascript:void(0)">${a.name?if_exists}</a></dd>
                                        <dd class="price"><b class="Item-price">￥${a.salesMoney}</b></dd>
                                    </dl>
                                </li>
                            </#if>
                        </#list>

                    </ul>
                </div>
                <div class="floor-banner-img">

                   <#list s as a>
                        <#if a_index == 6>
                            <img src="../img/07.png" /><br />
                        </#if>
                        <#if a_index == 7>
                            <img src="../img/07.png" /><br />
                        </#if>
                    </#list>
                </div>
            </div>
            <div class="Floor-bottom">
                <br />
                <ul class="borderHover">
                    <#list s as a>
                        <#if a_index gt 7 && a_index lt 11>
                    <li>
                        <dl class="Item-introduction">
                            <dt><a href="javascript:void(0)">
                                <img src="../img/03.jpg" /></a></dt>
                            <dd class="dd-Item-name"><a class="Introduction" href="javascript:void(0)">${a.name?if_exists}</a></dd>
                            <dd class="hot-cakes">（热销${a.num}件）</dd>
                            <dd class="Item-price"><b>￥${a.salesMoney}</b></dd>
                            <dd><a class="Add-art" href="javascript:void(0)">
                                <#--<img src="../img/icon-cart-add.png" />--></a><a class="More" href="javascript:void(0)">MORE</a></dd>
                        </dl>
                    </li>
                        </#if>
                    </#list>
                </ul>
            </div>
        </div>
    </#if>
    <#if s_index!=0>
        <div class="FiveContent none">
            <div class="FloorImg">
                <h1>综合系列</h1>
                <div class="tag">
                    <p>CERAMICS</p>
                    <p>FOR DALY USE</p>
                    <div class="font6"><p>asdafb asd asdjba sd asdasdsdasjcvakbckjabcahcwjk</p><p>afdiasnvvs aisdhoai s</p></div>
                </div>
                <img src="../img/08.png" style="margin-top:40px;" />
                <ul>
                    <#list brandList as p>
                        <li><a href="javascript:void(0);"><img src="${rc.contextPath}${p.logo}"/></a></li>
                        <#if p_index==3><#break></#if>
                    </#list>
                </ul>
            </div>



            <div class="floor-banner">
                <div>
                    <ul class="borderHover">
                        <#list s as a>
                            <#if a_index lt 6>
                                <li>
                                    <dl class="">
                                        <dt><a href="javascript:void(0)">
                                            <img src="../img/03.jpg" /></a></dt>
                                        <dd class=""><a class="Introduction" href="javascript:void(0)">${a.name?if_exists}</a></dd>
                                        <dd class="price"><b class="Item-price">￥${a.salesMoney}</b></dd>
                                    </dl>
                                </li>
                            </#if>
                        </#list>

                    </ul>
                </div>
                <div class="floor-banner-img">
                    <#list s as a>
                        <#if a_index == 6>
                            <img src="../img/07.png" /><br />
                        </#if>
                        <#if a_index == 7>
                            <img src="../img/07.png" /><br />
                        </#if>
                    </#list>
                </div>
            </div>
            <div class="Floor-bottom">
                <br />
                <ul class="borderHover">
                    <#list s as a>
                        <#if a_index gt 7 && a_index lt 11>
                            <li>
                                <dl class="Item-introduction">
                                    <dt><a href="javascript:void(0)">
                                        <img src="../img/03.jpg" /></a></dt>
                                    <dd class="dd-Item-name"><a class="Introduction" href="javascript:void(0)">${a.name?if_exists}</a></dd>
                                    <dd class="hot-cakes">（热销${a.num}件）</dd>
                                    <dd class="Item-price"><b>￥${a.salesMoney}</b></dd>
                                    <dd><a class="Add-art" href="javascript:void(0)">
                                    <#--<img src="../img/icon-cart-add.png" />--></a><a class="More" href="javascript:void(0)">MORE</a></dd>
                                </dl>
                            </li>
                        </#if>
                    </#list>

                </ul>
            </div>
        </div>
    </#if>
</#list>

<#--        <div class="FiveContent none">2</div>
        <div class="FiveContent none">3</div>
        <div class="FiveContent none">4</div>
        <div class="FiveContent none">5</div>
        <div class="FiveContent none">6</div>
        <div class="FiveContent none">7</div>
        <div class="FiveContent none">8</div>-->






    </div>
    <!--底部includ-->
<#include 'common/buttom.html' />

    <!--菜单栏展示第三级目录-->
    <#list goodsSortList as p>
        <#if p_index lt 4>
        <#if p.extendshow==1>
            <#list p.children as c>
                    <div id="pr${c.goodsSort_id}">
                        <div class="three-level">
                            <h4><span>${c.name?if_exists}</span>&nbsp;>></h4>
                            <span>${c.name?if_exists}${c.goodscount}件商品>></span>
                            <ul>
                                <#list c.children as d>
                                <li><a href="javascript:void(0)">${d.name?if_exists}</a></li>
                                </#list>
                            </ul>
                            <div>
                                <img width="370" height="160" src="../img/10.png" />
                            </div>
                        </div>
                    </div>
            </#list>
        </#if>

        <#if p.extendshow==0>
            <div id="pr${p.goodsSort_id}"  >
                <div class="three-level">
                    <h4><span>${p.name?if_exists}</span>&nbsp;>></h4>
                    <span>${p.name?if_exists}${p.goodscount}件商品>></span>
                    <ul>
                        <#list p.children as cc>
                        <li><a href="javascript:void(0)">${cc.name?if_exists}</a></li>
                        </#list>
                    </ul>
                    <div>
                        <img width="370" height="160" src="../img/10.png" />
                    </div>
                </div>
            </div>
        </#if>
        </#if>
    </#list>

</div>
<script src="../js/jquery-1.8.2.js"></script>
<script src="../js/index2.js"></script>
<script src="../js/sl2.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $.focus("#focus001");
    });

    //切换城市 更改体验馆数据
    function changeCity(obj){
        var cityId=$(obj).attr("cityid");
        $.ajax({
            type: "post",
            url: "${rc.contextPath}/getCity.htm",
            data:{"id":cityId},
            dataType: "json",
            success: function(result) {
                var area=result;
                if(area!=null){
                    $("#area").empty();
                    var _html = ['<b id=>'+area.name+'<label>'+area.num+'</label>家</b>'];
                    $("#area").append(_html.join(''));
                }else{
                    $("#area").empty();
                }
            },
            error: function (a,b,c,d) {
                alert("数据错误");
            }
        });
    }



    // 搜索按钮
    $(".search").click(function () {
        var date=$(".Search-Text").val();
        if(date==''||date==null){
            alert("请输入搜索的宝贝！");
        }
        var html = "<form id=\"searchFrom\" action=\"" + servicePath + "/goodSearch.html\" method=\"post\">";
        html += "<input type=\"hidden\" name=\"key\" value=\"" + $(".Search-Text").val() + "\">";
        html += "</form>";
        if($(".Search-Text").val().length>0){
            $(window.document.body).append(html);
            $("#searchFrom").submit();
        }
    });

</script>
</body>
</html>
