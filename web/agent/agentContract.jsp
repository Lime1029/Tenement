<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2019/7/4
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>经纪人端</title>
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
        <div class="col-md-2">
            <!--h1 style="color: white">Hello,Agent!</h1-->
        </div>
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
                        <a class="nav-link" href="agent_information.jsp" style="color: black">个人中心</a>
                        <a class="nav-link" href="#" style="color: black">我的消息</a>
                        <a class="nav-link" href="agent_upload_order.jsp" style="color: black">添加订单</a>
                        <a class="nav-link" href="agent_manage_order.jsp" style="color: black">我管理的订单</a>
                        <a class="nav-link" href="agentinfo.jsp" style="color: black">我管理的房源</a>
                        <a class="nav-link" href="agentContract.jsp" style="color: black">我管理的订单</a>
                    </li>
                </ul>
            </nav>
        </div>
        <!--导航栏End-->

        <!--页面主体：欢迎页pic-->
        <div class="col-md-9">
            <!--可替换部分-->
            <s:iterator value="pageBean.list">
            <s:property value="title"/>
          <!--  <a href="contractShow.action?id=<s:property value="id"/>">modify</a>
            <a href="deleteArticle.action?id=<s:property value="id"/>" onclick="return askDel()"/>delete</a><br/>
          !-->
                待定加入
            </s:iterator>
            共<s:property value="pageBean.allRow"/> 条记录
            共<s:property value="pageBean.totalPage"/> 页
            当前第<s:property value="pageBean.currentPage"/>页<br/>
            <div class="table-responsive">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th style="text-align: center;">订单编号</th>
                        <th style="text-align: center;">开始时间</th>
                        <th style="text-align: center;">结束时间</th>
                        <th style="text-align: center;">所属经纪人</th>
                        <th style="text-align: center;">租客姓名</th>
                        <th style="text-align: center;">房东姓名</th>
                        <th style="text-align: center;">房源id</th>
                        <th style="text-align: center;">终止合同</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.aaaa}" var="contract">
                        <s:form action="Endcontract" name="contractID">
                        <tr class="text-center">
                            <td>${contract[0]}</td>
                            <td>${contract[1]}</td>
                            <td>${contract[2]}</td>
                            <td>${contract[3]}</td>
                            <td>${contract[4]}</td>
                            <td>${contract[5]}</td>
                            <td>${contract[6]}</td>
                            <td>
                                <a href="#" onclick="return edit(${contract[0]})" style="text-decoration: none;">
                                    <span class="fa fa-edit fa-fw"></span>
                                </a>
                            </td>
                        </tr>
                        </s:form>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <s:if test="%{pageBean.currentPage == 1}">
                第一页 上一页
            </s:if>
            <s:else>
                <a href="contractShow.action?page=1">第一页</a>
                <a href="contractShow.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
            </s:else>
            <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
                <a href="contractShow.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
                <a href="contractShow.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
            </s:if>
            <s:else>
                下一页 最后一页
            </s:else>


        </div>
    </div>

</div>
<!--页面内容End-->
<!--bootstrap及bootstrap-table引用-->
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-table@1.15.2/dist/bootstrap-table.min.js"></script>
</body>
</html>