<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/10
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add city failure</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="../css/regLoginFail.css" />
</head>
<body>
<div class="panel panel-warning">
    <div class="panel-heading">
        <h3 class="panel-title" style="font-size: 25px">新增城市失败信息</h3>
    </div>
    <div class="panel-body">
        <label style="margin-top: 40px">${sessionScope.adminMessage}，</label>
        <a href="cityDisplay.jsp">请返回城市管理页面重新操作</a>
    </div>
</div>
</body>
</html>
