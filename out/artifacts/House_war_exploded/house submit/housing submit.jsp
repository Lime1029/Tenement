<%--
    Document   : Housing issue
    Created on : 2019-5-23, 12:39:09
    Author     : hp
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="jquery-1.10.2.min.js"></script>
    <meta name="viewport"  content="width=device-width;minimum-scale=1.0;initial-scale=1.0; maximum-scale=2.0; charset=UTF-8">
    <!--上一行是对移动端设备友好-->
    <title>房源发布</title>
</head>
<style type="text/css">
    .panel
    {




    }









    .first_pop_logo{

        padding-top: 0px;
        max-width: 500px;

    }
    .first_pop_logo img{
        width: 50%;
    }
    .first_pop{

        background: url(hua.png) repeat left top;
        border: solid 1px #f2a685;
        box-shadow: 4px 4px 4px rgba(0,0,0,0.2);

    }
    .first_pop_text02{
        font-size: 1.6rem;
        color: #565858;
        line-height: 1.5;



    }
    .first_pop_btn{
        text-align: center;
        font-size: 0;


    }
    .first_pop_btn li{
        display: inline-block;

    }
    .first_pop_btn li a{
        width: 237px;

        display: inline-block;

        height: 40px;
        line-height: 40px;
        font-weight: bold;
        font-size: 2.4rem;
        text-decoration: none;


    }


    html,body{
        background:url(shan.png)  no-repeat center center;
        background-size:cover;
        background-attachment:fixed;


    }





    @media (min-width:1200px) {
        .container {width: auto
        }
    }



</style>
<body>
<div >

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
                            <li class="active">
                                <a href="#">首页</a>
                            </li>
                            <li>
                                <a href="">租房</a>
                            </li>
                            <li>
                                <a href="../house submit/housing submit.jsp">发布房源</a>
                            </li>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="../myCenter/userInfo.jsp"><span class="glyphicon glyphicon-user"></span>个人中心</a>
                            </li>
                            <li>
                                <a href="">&nbsp;&nbsp;退出</a>
                            </li>
                        </ul>
                    </div>
                </nav>



    <div class="panel panel-default" style="margin-bottom:200px;padding-bottom: 0px;height: 90px">
        <div class="panel-heading"style="color:#f5f5f6" >
            <br>
            <br>
            <br>


            <h2  class="text-center" style="color:black;font-family:微软雅黑;font-size: 3.5rem;height: 90px;font-weight:bold;margin-top: 20px;padding-top: 10px">发布出租房源</h2>
            <h3 class="text-center" style="color:#878787;font-family: 微软雅黑;font-size:1.5rem;margin-top: -20px">8000+全国爱家门店·10万+全国经纪人·爱家倾情服务15年+</h3>

        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-5 col-lg-5 col-sm-5">
                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -20px">小区所在城市</h2>
                <br>
                <br>





                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">房屋地址</h2>
                <br>
                <br>


                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">期望租金</h2>
                <br>
                <br>


                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">称呼</h2>
                <br>
                <br>


                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">手机号码</h2>


            </div>

            <div class="col-md-5 col-lg-5 col-sm-5">
                <h2 style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -20px;margin-left: 40px">北京</h2>
                <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -6px;width: 400px;">
                <br>
                <form id = "houseSubmit" action="houseSubmit.action" method="post" >

                    <input type="text" id="address" name="address" placeholder="请输入具体地址" minlength="1" maxlength="30" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px">
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">
                    <br>

                    <input type="text" id="money" name="price" placeholder="请输入您的期望租金" minlength="1" maxlength="10" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px">
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">
                    <br>

                    <input type="text" id="name" name="appellation" placeholder="我们该如何称呼您" minlength="1" maxlength="10" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px">
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">
                    <br>

                    <input type="text" id="phone" name="phone" placeholder="您的常用联系方式" minlength="10" maxlength="11" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px">
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">
                    <br>
                    <input hidden name="applyer_id" value="${user.userId}">
                    <select class="form-control" name="plot_id">
                        <s:iterator value="#session.userplot" var="plot_num">
                            <option value="${plot_num.plotId}" id="plot_id">${plot_num.plotName}</option>
                        </s:iterator>
                    </select>

            </div>
        </div>
    </div>
    <br>
    <br>

    <button    type="submit"  class="btn btn-primary btn-lg "style="margin-left: 40%">提交申请</button>
    </form>


</div>
</body>
</html>
.