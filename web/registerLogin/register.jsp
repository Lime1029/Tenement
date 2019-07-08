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
<form id="registerForm" action="register.action" method="post" onsubmit="return check()">
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
<!--<script src="../js/register.js"></script>-->
<script>
    var password_Boolean = false;
    var confirm_Boolean = false;
    var mobile_Boolean = false;
    /*$('.reg_user').blur(function(){
        if ((/^[a-z0-9_-]{4,8}$/).test($(".reg_user").val())){
            $('.user_hint').html("✔").css("color","green");
            user_Boolean = true;
        }else {
            $('.user_hint').html("×").css("color","red");
            user_Boolean = false;
        }
    });*/

    // password
    $('#password1').blur(function(){
        if ((/^[a-z0-9_-]{6,15}$/).test($("#password1").val())){
            $('.password_hint').html("✔").css("color","green");
            password_Boolean = true;
        }else {
            $('.password_hint').html("✘").css("color","red");
            password_Boolean = false;
        }
    });


    // password_confirm
    $('#password2').blur(function(){
        if (($("#password1").val())==($("#password2").val())){
            $('.confirm_hint').html("✔").css("color","green");
            confirm_Boolean = true;
        }
        else {
            $('.confirm_hint').html("✘").css("color","red");
            confirm_Boolean = false;
        }
        if ((/^[a-z0-9-_]{6,15}$/).test($("#password2").val())){
            $('.confirm_hint').html("✔").css("color", "green");
            confirm_Boolean = true;
        }
        else {
            $('.confirm_hint').html("✘").css("color","red");
            confirm_Boolean = false;
        }
    });


    // Email
    /*$('.reg_email').blur(function(){
        if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/).test($(".reg_email").val())){
            $('.email_hint').html("✔").css("color","green");
            emaile_Boolean = true;
        }else {
            $('.email_hint').html("×").css("color","red");
            emaile_Boolean = false;
        }
    });*/


    // Mobile
    $('#telephone').blur(function(){
        if ((/^1[34578]\d{9}$/).test($("#telephone").val())){
            $('.mobile_hint').html("✔").css("color","green");
            mobile_Boolean = true;
        }else {
            $('.mobile_hint').html("✘").css("color","red");
            mobile_Boolean = false;
        }
    });


    function check() {
        if((password_Boolean && confirm_Boolean && mobile_Boolean) !== true){
            alert("请按格式要求填写信息");
            document.getElementById('telephone').value = "";
            document.getElementById('password1').value = "";
            document.getElementById('password2').value = "";
            $('.mobile_hint').html("");
            $('.password_hint').html("");
            $('.confirm_hint').html("");
            return false;
        }
        else {
            return true;
        }

    }
</script>
</body>

</html>
