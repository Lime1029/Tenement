<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/26
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="../css/regLogin.css" type="text/css" /><!--link标签结尾要么和/隔一个空格，要么不加/-->


</head>
<body>
    <form name="login" action="login.action" method="post">
        <h1>登录</h1>
        <label>&nbsp;手&nbsp;机&nbsp;号&nbsp;：</label>
        <input name="telephone" class="input_1" id="telephone" type="text" maxlength="11" placeholder="请正确填写手机号">
        <span class="mobile_hint"></span>
        <br><br>

        <label>输入密码：</label>
        <input name="password" class="input_1" id="password" type="text" minlength="6" maxlength="15" placeholder="6-15位数字、字母或_组成">
        <span class="password_hint"></span>
        <br><br>

        <span class="radio_box">
               <input name="role" id="radio_1" type="radio" checked="" value="user">
               <label for="radio_1"></label>
              普通用户
            </span>
        <span class="radio_box">
               <input name="role" id="radio_2" type="radio" value="agent">
               <label for="radio_2"></label>
               经理人
            </span>
        <span class="radio_box">
               <input name="role" id="radio_3" type="radio" value="administrator">
               <label for="radio_3"></label>
               管理员
            </span>
        <br>
        <input class="input_3" style="color: rgb(35, 39, 31); background-color: rgb(255, 255, 255);"  type="submit" value="登录">
        <input class="input_3"  type="reset" value="重置"><br><br>
        <a href="register.jsp">还没有账号？点我注册</a>
    </form>

    <script src="../js/jquery-1.8.2.min.js"></script>
    <script src="../js/login.js"></script>

</body>
</html>
