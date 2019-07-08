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


// click, 要用===和!==，而不是==和!=
/*$('#regSubmit').click(function(){
    if((password_Boolean && confirm_Boolean && mobile_Boolean) !== true){
        document.getElementById("regSubmit").disabled = false;
        //alert("请完善信息");
        session.setAttribute("regMessage", "注册信息格式错误");
        window.location = "regFail.jsp";
    }
});
*/