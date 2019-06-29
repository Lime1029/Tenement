<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/26
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link rel="stylesheet" href="../css/regLogin.css" type="text/css">
</head>
<body>
<form name="register" action="register.action" method="post">
    <h1>注册</h1>
    <input name="telephone" class="input_1" id="telephone" size="11" placeholder="电话号码"><br>
    <input name="password1" class="input_1" id="password1" type="password" size="15" placeholder="密码"><br>
    <input name="password2" class="input_1" id="password2" type="password" size="15" placeholder="确认密码"><br>

    <br><br>
    <input class="input_3" style="color: rgb(35, 39, 31); background-color: rgb(255, 255, 255);" name="submit" type="submit" value="注册">
    <input class="input_3" name="reset" type="reset" value="重置"><br><br>
    <a href="login.jsp">已有账号，点我登录</a>
</form>
</body>
</html>
