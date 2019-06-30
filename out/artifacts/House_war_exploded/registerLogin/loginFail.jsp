<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/30
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login failure</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="../css/regLoginFail.css" type="text/css" />
</head>
<body>
    <div class="panel panel-warning">
        <div class="panel-heading">
            <h3 class="panel-title" style="font-size: 25px">登录失败信息</h3>
        </div>
        <div class="panel-body">
            <label style="margin-top: 40px">${loginMessage}，</label>
            <a href="login.jsp">请重新登录</a>
        </div>
    </div>

</body>
</html>
