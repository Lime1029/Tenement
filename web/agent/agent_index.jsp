<%--
  Created by IntelliJ IDEA.
  User: KeepGoing
  Date: 2019/7/1
  Time: 21:50
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
            </li>
          </ul>
        </nav>
      </div>
      <!--导航栏End-->


      <!--页面主体：欢迎页pic-->
      <div class="col-md-9">
        <!--可替换部分-->
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