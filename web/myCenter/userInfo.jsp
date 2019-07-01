<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/30
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>personal information</title>

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询(media queries)功能 -->
    <!-- 警告：通过 file:// 协议(就是直接将 html 页面拖拽到浏览器中)访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container" >
        <div class="row clearfix">
            <div class="col-md-20 column">
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
                                <a href="../home/user.jsp">首页</a>
                            </li>

                        </ul>
                    </div>


            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-2 column">
                <ul class="nav nav-pills nav-stacked" style="background:#eee;border-radius: 10px">
                    <li class="active"><a href="#">个人信息</a></li>
                    <li><a href="#">&nbsp;&nbsp;</a></li>
                    <li><a href="#">&nbsp;&nbsp;</a></li>

                </ul>
            </div>

            <div class="col-md-4 col-md-offset-2  column">

                <div class="list-group">
                    <li class="list-group-item">用户名：&nbsp;&nbsp;${sessionScope.user.telephone}</li>
                    <li class="list-group-item">密码：&nbsp;&nbsp;${sessionScope.user.password}</li>
                    <li class="list-group-item">id：&nbsp;&nbsp;${sessionScope.user.userId}</li>
                    <br/>
                    <!--<a class="btn btn-primary" style="" href="modify_info.jsp">修改信息</a>-->
                </div>
            </div>
        </div>

    </div>
</body>
</html>
