<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/30
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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

    <style>
        .modal-content {
            position: relative;
        .box-shadow(0 3px 9px rgba(0,0,0,.5));
            background-clip: border-box;
            outline: 0;
        }
    </style>
</head>
<body>
    <div class="container" >
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
                            <li class="active">
                                <a href="../home/user.jsp">首页</a>
                            </li>

                        </ul>
                    </div>

                </nav>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-2 column">
                <ul class="nav nav-pills nav-stacked" style="background:#eee;border-radius: 10px">
                    <li class="active"><a href="#">个人信息</a></li>
                    <li><a href="searchMyHouse.action?userId=${user.userId}">我的房源</a></li>
                    <li><a href="getMyOrders.action?userId=${user.userId}">我的订单</a></li>

                </ul>
            </div>

            <div class="col-md-offset-4 column">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title" style="font-size: 25px">我的账户信息</h3>
                    </div>
                    <div class="panel-body">
                        <h4>Welcome! <c:choose>
                            <c:when test="${sessionScope.user.username != null}">
                                ${user.username}
                            </c:when>
                            <c:otherwise>
                                ${user.telephone}
                            </c:otherwise>
                        </c:choose>
                        </h4>
                        <ul class="list-group" >
                            <li class="list-group-item">联系方式：&nbsp;&nbsp;${sessionScope.user.telephone}</li>
                            <li class="list-group-item">
                                用户名：&nbsp;&nbsp;<c:choose>
                                <c:when test="${user.username != null}">
                                    ${user.username}
                                </c:when>
                                <c:otherwise>
                                    还未设置
                                </c:otherwise>
                            </c:choose></li>
                            <li class="list-group-item">
                                真实姓名：&nbsp;&nbsp;<c:choose>
                                <c:when test="${user.name != null}">
                                    ${user.name}
                                </c:when>
                                <c:otherwise>
                                    还未填写
                                </c:otherwise>
                            </c:choose></li>
                            <li class="list-group-item">密码：&nbsp;&nbsp;${sessionScope.user.password}</li>
                        </ul>
                        <a class="btn btn-primary" style="float: right;" data-toggle="modal" data-target="#updateUser" href="">修改信息</a>
                    </div>

                </div>
            </div>


        </div>

    </div>

    <div id="updateUser" class="modal fade" tabindex="-1" data-keyboard=”static”>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">修改账户信息</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="modifyUser.action" method="post">

                        <div class="form-group">
                            <label>真实姓名</label>
                            <input class="form-control" type="text" placeholder="" name="user.name" value="${user.name}">
                        </div>
                        <div class="form-group">
                            <label>用户名</label>
                            <input class="form-control" type="text" placeholder="" name="user.username" value="${user.username}">
                        </div>
                        <div class="form-group">
                            <label>手机号</label>
                            <input class="form-control" type="text" placeholder="输入正确格式" name="user.telephone" value="${user.telephone}">
                        </div>
                        <div class="form-group">
                            <label>修改密码</label>
                            <input class="form-control" type="password" placeholder="6-15位字母、数字或_" name="user.password" value="${user.password}">
                        </div>
                        <input name="user.userId" value="${user.userId}" hidden>
                        <div class="text-right">
                            <button class="btn btn-primary" type="submit">提交</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
