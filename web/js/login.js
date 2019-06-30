var mobile_Bean = false;
var password_Bean = false;

$('#telephone').blur(function () {
    if ((/^1[34578]\d{9}$/).test($("#telephone").val())){
        $('.mobile_hint').html("✔").css("color","green");
        mobile_Boolean = true;
    }else {
        $('.mobile_hint').html("✘").css("color","red");
        mobile_Boolean = false;
    }

})

$('#password').blur(function(){
    if ((/^[a-z0-9_-]{6,15}$/).test($("#password").val())){
        $('.password_hint').html("✔").css("color","green");
        password_Boolean = true;
    }else {
        $('.password_hint').html("✘").css("color","red");
        password_Boolean = false;
    }
});

// click, 要用===和!==，而不是==和!=
/*$('#loginSubmit').click(function(){
    if((password_Boolean && mobile_Boolean) !== true){
        alert("请完善信息");
    }
});*/