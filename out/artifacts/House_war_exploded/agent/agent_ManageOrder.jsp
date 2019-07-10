<%--
  Created by IntelliJ IDEA.
  User: KeepGoing
  Date: 2019/7/7
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>agent订单管理</title>
    <!--bootstrap及bootstrap-table的引用-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.2/dist/bootstrap-table.min.css">
    <style>
        .top{
            background-color: #4169E1;
            height: 50px;
        }
    </style>
</head>
<body>
<!--假装有的装饰性TOP部分-->
<div class="top">
    <div class="row">
        <div class="col-md-2">
            &nbsp;
        </div>
    </div>
</div>

<!--Middle页面主体-->
<div>
    <div class="row" style="height: 100%">
        <!--页面左部导航栏，跳转部分-->
        <div class="col-md-3">
            <nav class="navbar" style="background-color: aliceblue">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="../agent/agent_ShowInfo.jsp" style="color: black">个人信息</a>
                        <a class="nav-link" href="agentChat.action?agentID=${agent.agentId}" style="color: black">我的消息</a>
                        <a class="nav-link" href="../agent/agent_AddOrder.jsp" style="color: black">添加订单</a>
                        <a class="nav-link" href="getMyOrder.action?agentId=${agent.agentId}" style="color: black">我管理的订单</a>
                        <a class="nav-link" href="houseShow.action" style="color: black">确认房源</a>
                        <a class="nav-link" href="getMyHouse.action" style="color: black">我管理的房源</a>
                        <a class="nav-link" href="contractShow.action" style="color: black">我管理的合同</a>
                        <a class="nav-link" href="getLandlordApply.action" style="color: black">房东发布房源的申请</a>
                    </li>
                </ul>
            </nav>
        </div>
        <!--导航栏End-->

        <!--页面主体：查看当前经纪人管理的订单，并进行操作，表格部分查询及删除-->
        <div class="col-md-9">
            <table class="table table-condensed">
                <thead>
                <!--表格top栏-->
                <tr>
                    <th>订单编号</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>订单状态</th>
                    <th>租金</th>
                    <th>租客编号</th>
                    <th>房源编号</th>
                </tr>
                </thead>
                <tbody>
                <!--显示数据库中订单数据-->
                <s:iterator value="#session.orders" var="order">
                    <tr>
                        <td>${order[0]}</td><!--订单id-->
                        <td>${order[1]}</td><!--开始时间-->
                        <td>${order[4]}</td><!--结束时间-->
                        <td>
                            <c:choose>
                                <c:when test="${order[3] == 0}">
                                    未支付
                                </c:when>
                                <c:otherwise>
                                    已支付
                                </c:otherwise>
                            </c:choose></td><!--订单状态-->
                        <td>${order[2]}</td><!--租金-->
                        <td>${order[5]}</td><!--租客id-->
                        <td>${order[6]}</td><!--房源id-->
                        <td>
                            <!--因为action所以要用表单提交submit-->
                            <form action="deleteAgentOrder.action" method="post">
                                <input type="hidden" value='${order[0]}' name="orderId">
                                <input hidden name="agentId"value="${agent.agentId}">
                                <input type="submit" value="删除" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                            </form>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>

    </div>

</div>
<!--页面内容End-->


<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-table@1.15.2/dist/bootstrap-table.min.js"></script>
</body>
</html>