<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/3
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>My House</title>

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
                            <li>
                                <a href="../home/user.jsp">首页</a>
                            </li>
                            <li>
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
                                <a href="logout.action">&nbsp;&nbsp;退出</a>
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
                    <li class="active"><a href="searchMyHouse.action?userId=${user.userId}">我的房源</a></li>
                    <li><a href="getMyOrders.action?userId=${user.userId}">我的订单</a></li>

                </ul>
            </div>

            <div class="col-md-10 column">

                <!-- 选项卡菜单-->
                <ul id="myTab" class="nav nav-tabs" role="tablist" style="height: 42px;">
                    <li class="active"><a href="#houseInMyName" role="tab" id="myHouseTab" data-toggle="tab">我名下房源</a></li>
                    <li><a href="#rentalHouse" role="tab" id="myRentalHouseTab" data-toggle="tab">租赁的房屋</a></li>

                </ul>
                <!-- 选项卡面板 -->
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="houseInMyName">
                        <c:choose>
                            <c:when test="${sessionScope.myHouses.size() == 0}">
                                共找到0条记录
                            </c:when>
                            <c:otherwise>
                                <table>
                                    <tr>
                                        <th>区域</th>
                                        <th>小区</th>
                                        <th>地址</th>
                                        <th>经纪人</th>
                                        <th>租金</th>
                                        <th>房屋状态</th>
                                        <th>户型</th>
                                        <th>楼层</th>
                                        <th>面积</th>
                                        <th>上架时间</th>
                                        <th>操作</th>
                                    </tr>

                                    <s:iterator value="#session.myHouses" var="myHouse">
                                        <tr style="border-bottom: 1px solid rgb(224,232,242);">
                                            <td>${myHouse.districtName}</td>
                                            <td>${myHouse.plotName}</td>
                                            <td>${myHouse.address}</td>
                                            <td class="agent" title="经纪人手机号:${myHouse.agentTel}">${myHouse.agentName}</td>
                                            <td>${adminHouse.rent}元/月</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${myHouse.state == 0}">
                                                        不再出租
                                                    </c:when>
                                                    <c:otherwise>
                                                        出租中
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${myHouse.houseType}</td>
                                            <td>${myHouse.floor}</td>
                                            <td>${myHouse.area}</td>
                                            <td>${myHouse.releaseTime}</td>
                                            <td>
                                                <form action="houseInfo.action" method="post">
                                                    <input type="hidden" value=${myHouse.houseId} name="houseId">
                                                    <input type="submit" value="更多" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                                                </form>
                                                <form action="getContract.action" method="post">
                                                    <input type="hidden" value=${myHouse.houseId} name="houseId">
                                                    <input type="submit" value="合同" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                                                </form>
                                            </td>
                                        </tr>
                                    </s:iterator>


                                </table>
                            </c:otherwise>
                        </c:choose>

                    </div>
                    <div class="tab-pane " id="rentalHouse">
                        <c:choose>
                            <c:when test="${sessionScope.myRental.size() == 0}">
                                共找到0条记录
                            </c:when>
                            <c:otherwise>
                                <table>
                                    <tr>
                                        <th>区域</th>
                                        <th>小区</th>
                                        <th>地址</th>
                                        <th>经纪人</th>
                                        <th>租金</th>
                                        <th>房屋状态</th>
                                        <th>户型</th>
                                        <th>楼层</th>
                                        <th>面积</th>
                                        <th>是否在租</th>
                                        <th>操作</th>
                                    </tr>

                                    <s:iterator value="#session.myRental" var="rHouse">
                                        <tr style="border-bottom: 1px solid rgb(224,232,242);">
                                            <td>${rHouse.districtName}</td>
                                            <td>${rHouse.plotName}</td>
                                            <td>${rHouse.address}</td>
                                            <td title="经纪人手机号:${rHouse.agentTel}">${rHouse.agentName}</td>
                                            <td>${rHouse.rent}元/月</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rHouse.state == 0}">
                                                        不再出租
                                                    </c:when>
                                                    <c:otherwise>
                                                        出租中
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${rHouse.houseType}</td>
                                            <td>${rHouse.floor}</td>
                                            <td>${rHouse.area}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${rHouse.isSellOn == 0}">
                                                        已结束租赁
                                                    </c:when>
                                                    <c:otherwise>
                                                        租赁中
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <form action="houseInfo.action" method="post">
                                                    <input type="hidden" value=${rHouse.houseId} name="houseId">
                                                    <input type="submit" value="更多" style="color: #fff;width: 80px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                                                </form>
                                                <form action="getContractAsTenant.action" method="post">
                                                    <input type="hidden" value=${rHouse.houseId} name="houseId">
                                                    <input type="hidden" value="${user.userId}" name="userId">
                                                    <input type="submit" value="合同" style="color: #fff;width: 80px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                                                </form>
                                            </td>
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
