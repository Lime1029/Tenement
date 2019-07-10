<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/29
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>agent home</title>
    <!--经纪人端的登陆成功欢迎页面，没有什么功能所以也没有什么功能性代码，提供跳转-->
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
        <form action="agentChat.action" id="form1" method="post">
            <input type="hidden" value="${session.agent.agentId}" name="agentID">
        </form>

        <!--页面主体：订单管理部分：添加订单并上传、显示并删除订单的表格-->
        <div class="col-md-9">
            <img src="../images/agent端欢迎.jpg" width="100%" height="100%">
        </div>
    </div>
    <!--页面主题End-->
</div>




<!--bootstrap及bootstrap-table引用-->
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-table@1.15.2/dist/bootstrap-table.min.js"></script>


<%--suppress JSUnresolvedLibraryURL --%>
<script type="text/javascript" src="https://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
    var goeasy = new GoEasy({
        appkey:'BC-a996257032c5470597d8213b461e44f3'
    })
    goeasy.subscribe({
        channel:'${agent.agentId}',
        onMessage:function(message){
            alert(message.content);
        }
    })
</script>
</body>
</body>
</html>