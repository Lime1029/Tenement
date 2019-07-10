<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2019/7/3
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>search for </title>
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询(media queries)功能 -->
    <!-- 警告：通过 file:// 协议(就是直接将 html 页面拖拽到浏览器中)访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        .panel{
            width: 50%;
            height: 250px;
            text-align: center;
            margin-left: 300px;
            margin-top: 100px;
            font-size: 20px;
        }
        .panel ul li {
            text-align: left;
            padding-left: 50px;
        }

        #search input {
            display: inline;
            width: 900px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-16 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">爱家</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="../home/user.jsp">首页</a>
                        </li>
                        <li class="active">
                            <a href="../search/search.jsp">租房</a>
                        </li>
                        <li>
                            <a href="plotGet.action">发布房源</a>
                        </li>
                        <li>
                            <a href="messageShow.action">讨论版</a>
                        </li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="../myCenter/userInfo.jsp"><span class="glyphicon glyphicon-user"></span>个人中心</a>
                        </li>
                        <li>
                            <a href="logout.action">&nbsp;&nbsp;退出</a>
                        </li>
                    </ul>
                </div>
            </nav>

        </div>
    </div>

    <div class="filter">
        <form role="form" id="search" action="searchHouseByKeyword.action">
            <input type="search" maxlength="15" placeholder="请输入区域或小区名搜索" class="form-control" name="condition">
            <span><button class="btn btn-primary" type="submit">开始找房</button></span>
        </form>
        <script type="text/javascript">
            function choosebe(clickanswer) {
            }
        </script>
        <hr class="filter__wrapper w1150" id="filter">
        <ul class="filter__item--noaside">
            <li class="filter__item--level1 down strong" data-tab="1" data-el="area" data-antitarget="station"><a href="/zufang/" onclick="return false;">按区域</a></li>
        </ul>

        <form role="form" id="search2" action="conditionSearch.action" >
            <ul data-target="search.housing_plot" class="">
                <div >
                    <li class="filter__item--level4 filter__item--aside"><a href="javascript:;">地区</a></li>
                    <div class="col-sm-4 radios">
                        <input type="radio" name="housing_district" value="东城"/>东城
                    </div>
                    <div class="col-sm-4 radios">
                        <input type="radio" name="housing_district" value="西城"/>西城
                    </div>
                    <div class="col-sm-4 radios">
                        <input type="radio" name="housing_district" value="朝阳"/>朝阳
                    </div>
                    <div class="col-sm-4 radios">
                        <input type="radio" name="housing_district" value="海淀"/>海淀
                    </div>
                </div>

            </ul>
            <hr>
            <ul class="filter__ul" data-el="rentType">
                <li class="filter__item--level4 filter__item--aside"><a href="javascript:;">热门小区</a></li>
                <div class="col-sm-4 radios">
                    <input type="radio" name="housing_plot" value="0"/>天通苑
                </div>
                <div class="col-sm-4 radios">
                    <input type="radio" name="housing_plot" value="1"/>北邮
                </div>
                <div class="col-sm-4 radios">
                    <input type="radio" name="housing_plot" value="2"/>北师
                </div>
                <div class="col-sm-4 radios">
                    <input type="radio" name="housing_plot" value="3"/>北大
                </div>
            </ul>
            <hr/>
            <input type="search" placeholder="最高承受租金" class="form-control" name="housing_maxrent">
            <br>
            <input type="search" placeholder="最低承受租金" class="form-control" name="housing_leastrent">
            <br>
            <hr/>
            <ul class="filter__ul" data-el="housing_type">
                <li class="filter__item--level5 filter__item--aside"><a href="javascript:;">户型</a></li>
                <div class="col-sm-4 radios">
                    <input type="radio" name="housing_type" value="三室两厅一卫"/>三室两厅一卫
                </div>
                <div class="col-sm-4 radios">
                    <input type="radio" name="housing_type" value="三室一厅一卫"/>三室一厅一卫
                </div>
                <div class="col-sm-4 radios">
                    <input type="radio" name="housing_type" value=null/>无要求
                </div>
            </ul>


    <button      class="btn btn-primary btn-lg "style="margin-left: 40%" type="submit">搜索</button>  </form>
</div>

</div>
</body>
</html>