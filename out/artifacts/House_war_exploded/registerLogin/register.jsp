<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/26
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>register</title>
    <link rel="stylesheet" href="../css/regLogin.css" type="text/css">


</head>
<body>
<form id="registerForm" action="register.action" method="post">
    <h1>注册</h1>
    <!--autocomplete="off"当用户提交过一次表单后，再次访问,手机号不会提示曾经输入的值-->
    <label>&nbsp;手&nbsp;机&nbsp;号&nbsp;：</label>
    <input name="telephone" class="input_1" id="telephone" maxlength="11" placeholder="11位手机号" required="required" autocomplete="off"
     autofocus >
    <span class="mobile_hint"></span>
    <br>

    <label>输入密码：</label>
    <input name="password1" class="input_1" id="password1" type="password" minlength="6" maxlength="15" required="required" placeholder="6-15位字母、数字或_组成">
    <span class="password_hint"></span>
    <br>

    <label>确认密码：</label>
    <input name="password2" class="input_1" id="password2" type="password" minlength="6" maxlength="15" required="required" placeholder="">
    <span class="confirm_hint" style="border-right: 20px;vertical-align: center"></span>
    <br>

    <br><br>
    <input class="input_3" name="submit" type="submit" value="注册" id="regSubmit">
    <input class="input_3" name="reset" type="reset" value="重置" ><br><br>
    <a href="login.jsp">已有账号，点我登录</a>
</form>

<script src="../js/jquery-1.8.2.min.js"></script>
<script src="../js/register.js"></script>
</body>
<s:fielderror>
    <s:param>telephone</s:param>
    <s:param>password1</s:param>
    <s:param>password2</s:param>
</s:fielderror>
</html>
