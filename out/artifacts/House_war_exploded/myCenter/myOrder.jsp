<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/4
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Order</title>

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
        table {
            width: 100%;
            border: 0;
            margin: 0;
            border-collapse: collapse;
            text-align: center;
            position: relative;
        }

        table {
            border: 1.3px solid rgb(86, 132, 190);
            margin-top: 10px;
        }


        table th {
            height: 45px;
            font-size: 18px;
            /*background: rgb(86, 132, 190);*/
            color: rgb(86, 132, 190);
            text-align: center;
            border: 1.3px solid rgb(86, 132, 190);
        }

        table td {
            height: 56px;
            font-size: 16px;
            color: rgb(86, 132, 190);
            border: 1.3px solid rgb(86, 132, 190);
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
                    <li><a href="../myCenter/userInfo.jsp">个人信息</a></li>
                    <li><a href="searchMyHouse.action?userId=${user.userId}">我的房源</a></li>
                    <li class="active"><a href="getMyOrders.action?userId=${user.userId}">我的订单</a></li>

                </ul>
            </div>

            <div class="col-md-10 column">

                <!-- 选项卡菜单-->
                <ul id="myTab" class="nav nav-tabs" role="tablist" style="height: 42px;">
                    <li class="active"><a href="#myOutstandingOrder" role="tab" data-toggle="tab">未支付</a></li>
                    <li><a href="#myPrepaidOrder" role="tab" data-toggle="tab">已支付</a></li>

                </ul>
                <!-- 选项卡面板 -->
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="myOutstandingOrder">
                        <c:choose>
                            <c:when test="${sessionScope.myOutstandingOrders.size() == 0}">
                                共找到0条记录
                            </c:when>
                            <c:otherwise>
                                <table>
                                    <tr>
                                        <th>房东</th>
                                        <th>经纪人</th>
                                        <th>租房开始时间</th>
                                        <th>租房结束时间</th>
                                        <th>租金</th>
                                        <th>操作</th>
                                    </tr>

                                    <s:iterator value="#session.myOutstandingOrders" var="order">
                                        <tr style="border-bottom: 1px solid rgb(224,232,242);">
                                            <td>${order[0]}</td>
                                            <td title="${order[2]}">${order[1]}</td>
                                            <td>${order[3]}</td>
                                            <td >${order[4]}</td>
                                            <td>${order[5]}元/月</td>
                                            <td>
                                                <form action="modifyOrderStatus.action" method="post">
                                                    <input type="hidden" value=${order[6]} name="orderId">
                                                    <input type="hidden" value="${user.userId}" name="userId">
                                                    <input type="submit" value="支付" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                                                </form>
                                            </td>
                                        </tr>
                                    </s:iterator>


                                </table>
                            </c:otherwise>
                        </c:choose>

                    </div>
                    <div class="tab-pane " id="myPrepaidOrder">
                        <c:choose>
                            <c:when test="${sessionScope.myPrepaidOrders.size() == 0}">
                                共找到0条记录
                            </c:when>
                            <c:otherwise>
                                <table>
                                    <tr>
                                        <th>房东</th>
                                        <th>经纪人</th>
                                        <th>租房开始时间</th>
                                        <th>租房结束时间</th>
                                        <th>租金</th>
                                    </tr>

                                    <s:iterator value="#session.myPrepaidOrders" var="order">
                                        <tr style="border-bottom: 1px solid rgb(224,232,242);">
                                            <td>${order[0]}</td>
                                            <td title="${order[2]}">${order[1]}</td>
                                            <td>${order[3]}</td>
                                            <td >${order[4]}</td>
                                            <td>${order[5]}元/月</td>
                                        </tr>
                                    </s:iterator>


                                </table>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>


        </div>

    </div>


</body>
</html>
