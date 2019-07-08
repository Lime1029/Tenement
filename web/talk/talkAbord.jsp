<%@ page import="dao.UserDao" %><%--
    Document   : talk
    Created on : 2018-9-18, 16:51:12
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>讨论块</title>
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
        background:url(xingkong.png)  no-repeat center center;
        background-size:cover;
        background-attachment:fixed;


    }

    .navbar-nav > li > a{

        top: 40%;

        padding-bottom:0 ;

        height: 20px;

    }
    .navbar-header > li > a{
        top: 40%;

        padding-bottom:0 ;

        height: 20px;
    }


    .navbar {min-height:20px ;
        height: 55px;}
    @media (min-width:1200px) {
        .container {width: auto
        }
    }



</style>
<script type="text/javascript">

</script>
<body>
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
<div class="container" >
    <div class="row">
        <div class="col-md-3 col-lg-3 col-sm-3">

        </div>
        <div class="col-lg-1 col-md-1 col-sm-1"></div>
        <div class="col-md-8 col-lg-8 col-sm-8" style="border-radius: 5px;padding:20px; overflow-y:auto; height:900px;width: 800px">

            <form class="form-inline" role="form" style="overflow-y:auto" id = "messageSubmit" action="messageSubmit.action" method="post" >


                <div style="margin-top:25px">
                    <input rows="10" cols="102"  style="vertical-align:top;outline:none;" id="text" name="Message">
                    <input hidden name="author_id" value="${user.userId}">
                </div>
                <div style="float:right;" class="form-group" >
                    <button  type="submit" class="btn btn-success " style="margin-top:10px;overflow:auto;" >发送</button></div>
                <div id="block">
                </div>
            </form>
            <c:forEach items="${message}" var="Message">
                ${Message[1]}:${Message[2]}   : ${Message[0]}
                <br>

            </c:forEach>



        </div>
        <div class="col-md-2 col-lg-2 col-sm-2">
        </div>
    </div>
</div>


</body>
</html>