<%--
    Document   : Housing issue
    Created on : 2019-5-23, 12:39:09
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="jquery-1.10.2.min.js"></script>
    <meta name="viewport"  content="width=device-width;minimum-scale=1.0;initial-scale=1.0; maximum-scale=2.0; charset=UTF-8">
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="jquery-1.10.2.min.js"></script>
    <meta name="viewport"  content="width=device-width;minimum-scale=1.0;initial-scale=1.0; maximum-scale=2.0; charset=UTF-8">

<body>
<div class="background">


    <div class="panel panel-default" style="margin-bottom:200px;padding-bottom: 0px;height: 90px">
        <div class="panel-heading"style="color:#f5f5f6" >
            <br>
            <br>
            <br>


            <h2  class="text-center" style="color:black;font-family:微软雅黑;font-size: 3.5rem;height: 90px;font-weight:bold;margin-top: 20px;padding-top: 10px">房源信息确认</h2>
            <h3 class="text-center" style="color:#878787;font-family: 微软雅黑;font-size:1.5rem;margin-top: -20px">8000+全国爱家门店·10万+全国经纪人·爱家倾情服务15年+</h3>

        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-5 col-lg-5 col-sm-5">
                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">房屋地址</h2>
                <br>
                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">实际租金</h2>
                <br>
                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">房屋状态</h2>
                <br>
                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">房东手机号</h2>
                <br>
                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">房东姓名</h2>
                <br>
                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">房屋类型</h2>
                <br>
                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">房屋楼层</h2>
                <br>
                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">房屋面积</h2>

                <br>
                <h2 style="color:#333;font-weight:bold;margin-left: 85%;font-size:1.5rem;margin-top: -3px">房源描述</h2>


            </div>

            <div class="col-md-5 col-lg-5 col-sm-5">
                <form action="houseConfirm.action" id="houseConfirm" method="post" onsubmit="return check()">

                    <input class="text" id="address" name="house_address" placeholder="请输入具体地址" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -45px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px">
                    <span class="address_hint"></span>
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -30px;margin-top: -0px;width: 400px">


                    <input class="text" id="rent" name="house_rent" placeholder="请输入实际租金" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px">
                    <span class="price_hint"></span>
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">

                    <div>
                        <div class="col-sm-4 radios">
                            <input type="radio" name="house_state" value="1"/>未出租
                        </div>
                        <div class="col-sm-4 radios">
                            <input type="radio" name="house_state" value="0"/>已出租
                        </div>

                    </div>
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">
                    <input class="text" id="phone" name="user_phone" placeholder="请输入房东电话" maxlength="11" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px" required>
                    <span class="phone_hint"></span>
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">
                    <input class="text" id="name" name="user_name" placeholder="请输入房东姓名" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px" required maxlength="10">
                    <span class="name_hint"></span>
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">

                    <input class="text" id="type" name="house_type" placeholder="请输入户型，如三室一厅一卫" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px" maxlength="15">
                    <span class="type_hint"></span>
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">
                    <input class="text" id="floor" name="house_floor" placeholder="请输入房屋楼层，如4楼/共15层" required style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px" maxlength="15">
                    <span class="floor_hint"></span>
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">
                    <input class="text" id="area" name="house_area" placeholder="请输入房屋面积" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px" maxlength="10" required>
                    <span class="area_hint"></span>
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">

                    <input class="text" id="description" name="house_description" placeholder="请输入房屋描述" style="color:#66CDAA;font-weight:bold;margin-left: 0%;font-size:1.5rem;margin-top: -30px;border-bottom: black 0px solid;    border-top-style: none;    border-right-style: none;    border-left-style: none;    background-color: transparent;width: 300px;margin-left: 40px" maxlength="50" required>
                    <span class="description_hint"></span>
                    <hr style="margin-right: 50%;font-weight: bold;padding-top: -20px;margin-top: -0px;width: 400px">



                    <select class="form-control" name="plot_id">
                        <s:iterator value="#session.plot" var="plot_num">
                            <option value="${plot_num.plotId}" id="plot_id">${plot_num.plotName}</option>
                        </s:iterator>
                    </select>
                    <button    type="submit"  class="btn btn-primary btn-lg "style="margin-left: 40%">提交申请</button>

                </form>


            </div>

        </div>
    </div>
    <br>
    <br>

</div>



<script>

    var phone_Boolean = false;
    var rent_Boolean = false;
    var address_Boolean = false;
    var name_Boolean = false;
    var area_Boolean = false;
    var floor_Boolean = false;
    var type_Boolean = false;
    var description_Boolean = false;
    /*$('.reg_user').blur(function(){
        if ((/^[a-z0-9_-]{4,8}$/).test($(".reg_user").val())){
            $('.user_hint').html("✔").css("color","green");
            user_Boolean = true;
        }else {
            $('.user_hint').html("×").css("color","red");
            user_Boolean = false;
        }
    });*/
    $('#rent').blur(function () {
        if((/^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/).test($("#rent").val()))
        {
            $('.price_hint').html("✔").css("color","green");
            rent_Boolean = true;
        }else {
            $('.price_hint').html("✘").css("color","red");
            rent_Boolean = false;
        }


    })

    $('#area').blur(function () {
        if((/^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/).test($("#area").val()))
        {
            $('.area_hint').html("✔").css("color","green");
            area_Boolean = true;
        }else {
            $('.area_hint').html("✘").css("color","red");
            area_Boolean = false;
        }


    })

    // Mobile
    $('#phone').blur(function(){
        if ((/^1[34578]\d{9}$/).test($("#phone").val())){
            $('.phone_hint').html("✔").css("color","green");
            phone_Boolean = true;
        }else {
            $('.phone_hint').html("✘").css("color","red");
            phone_Boolean = false;
        }
    });

    $('#address').blur(function(){
        if ((/^[\u4e00-\u9fa5]{1,20}$/).test($("#address").val())){
            $('.address_hint').html("✔").css("color","green");
            address_Boolean = true;
        }else {
            $('.address_hint').html("✘").css("color","red");
            address_Boolean = false;
        }
    });

    $('#name').blur(function(){
        if ((/^[\u4e00-\u9fa5]{1,5}$/).test($("#name").val())){
            $('.name_hint').html("✔").css("color","green");
            name_Boolean = true;
        }else {
            $('.name_hint').html("✘").css("color","red");
            name_Boolean = false;
        }
    });

    $('#floor').blur(function(){
        if ((/^[\u4e00-\u9fa5-0-9-\/]{1,5}$/).test($("#floor").val())){
            $('.floor_hint').html("✔").css("color","green");
            floor_Boolean = true;
        }else {
            $('.floor_hint').html("✘").css("color","red");
            floor_Boolean = false;
        }
    });

    $('#type').blur(function(){
        if ((/^[\u4e00-\u9fa5]{1,10}$/).test($("#type").val())){
            $('.type_hint').html("✔").css("color","green");
            type_Boolean = true;
        }else {
            $('.type_hint').html("✘").css("color","red");
            type_Boolean = false;
        }
    });

    $('#description').blur(function(){
        if ((/^[\u4e00-\u9fa5-0-9-\u3002\uff1b\uff0c\uff1a\u201c\u201d\uff08\uff09\u3001\uff1f\u300a\u300b]{1,50}$/).test($("#description").val())){
            $('.description_hint').html("✔").css("color","green");
            description_Boolean = true;
        }else {
            $('.description_hint').html("✘").css("color","red");
            description_Boolean = false;
        }
    });


    function check() {
        if((rent_Boolean && phone_Boolean && address_Boolean && name_Boolean && type_Boolean && floor_Boolean && area_Boolean && description_Boolean) !== true){
            alert("请按格式要求填写信息");
            document.getElementById('price').value = "";
            document.getElementById('phone').value = "";
            document.getElementById('address').value = "";
            document.getElementById('name').value = "";
            document.getElementById('type').value = "";
            document.getElementById('floor').value = "";
            document.getElementById('area').value = "";
            document.getElementById('description').value = "";
            $('.phone_hint').html("");
            $('.price_hint').html("");
            $('.address_hint').html("");
            $('.name_hint').html("");
            $('.phone_hint').html("");
            $('.type_hint').html("");
            $('.floor_hint').html("");
            $('.area_hint').html("");
            $('.description_hint').html("");
            return false;
        }
        else {
            return true;
        }

    }
</script>
</body>
</html>