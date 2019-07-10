<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/10
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>landlord apply list</title>
    <!--bootstrap及bootstrap-table的引用-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.2/dist/bootstrap-table.min.css">
    <!--CSS样式设置-->
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
        <div class="col-md-2"></div>
    </div>
</div>

<!--Middle-->
<div>
    <div class="row" style="height: 100%">

        <!--页面左部导航栏，暂时只有一个订单管理功能-->
        <div class="col-md-3">
            <nav class="navbar" style="background-color: aliceblue">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="agent_ShowInfo.jsp" style="color: black">个人信息</a>
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
        <form action="agentChat.action" id="form1" method="post">
            <input type="hidden" value="${session.agent.agentId}" name="agentID">
        </form>

        <!--页面主体-->
        <div class="col-md-9">
            <table data-toggle="table">
                <thead>
                <!--表格top栏-->
                <tr>
                    <th>申请id</th>
                    <th>申请人</th>
                    <th>申请人手机号</th>
                    <th>期望租金</th>
                    <th>房屋所在小区编号</th>
                    <th>房屋地址</th>
                    <th>确认申请</th>
                </tr>
                </thead>
                <tbody>
                <!--显示数据库中订单数据-->
                <s:iterator value="#session.landlordApply" var="apply">
                    <tr>
                        <td>${apply.applyId}</td>
                        <td>${apply.applyerAppellation}</td>
                        <td>${apply.applyerPhone}</td>
                        <td>${apply.expectPrice}</td>
                        <td>${apply.plotId}</td>
                        <td>${apply.address}</td>
                        <td>
                            <a class="btn btn-primary" href="deleteApply.action?applyId=${apply.applyId}">同意</a>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
    <!--页面主题End-->
</div>




<!--bootstrap及bootstrap-table引用-->
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-table@1.15.2/dist/bootstrap-table.min.js"></script>


</body>
</body>
</html>