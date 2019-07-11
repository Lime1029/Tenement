<%--
  Created by IntelliJ IDEA.
  User: KeepGoing
  Date: 2019/7/7
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>agent订单管理</title>
    <!--bootstrap及bootstrap-table的引用-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.2/dist/bootstrap-table.min.css">
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
    <ul class="nav navbar-nav navbar-right" >
        <li>
            <a href="logout.action" style="float: right; color:whitesmoke; margin-right: 50px;margin-top: 10px">退出</a>
        </li>
    </ul>
</div>

<!--Middle页面主体-->
<div>
    <div class="row" style="height: 100%">
        <!--页面左部导航栏，跳转部分-->
        <div class="col-md-3">
            <nav class="navbar" style="background-color: aliceblue">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="../agent/agent_ShowInfo.jsp" style="color: black">个人信息</a>
                        <a class="nav-link" href="agentChat.action?agentID=${agent.agentId}" style="color: black">我的消息</a>
                        <a class="nav-link" href="../agent/agent_AddOrder.jsp" style="color: black">添加订单</a>
                        <a class="nav-link" href="getMyOrder.action?agentId=${agent.agentId}" style="color: black">我管理的订单</a>
                        <a class="nav-link" href="houseShow.action" style="color: black">确认房源</a>
                        <a class="nav-link" href="getMyHouse.action" style="color: black">我管理的房源</a>
                        <a class="nav-link" href="contractShow.action" style="color: black">我管理的合同</a>
                        <a class="nav-link" href="getLandlordApply.action" style="color: black">房东发布房源的申请</a>
                    </li>
                </ul>
            </nav>
        </div>
        <!--导航栏End-->

        <!--页面主体：新建、填写并上传订单，表单形式-->
        <div class="col-md-9">
            <br>
            <form action="addOrder.action" method="post" onsubmit="return checkAddOrder()">
                <!--订单id自增的，订单状态是默认的、-->
                <div class="form-group">
                    <label>房源id：</label>
                    <input type="text" name="order.houseId" placeholder="请在消息页面查看" id="houseId" maxlength="10"><!--用于js验证的id=houseId-->
                    <!--房源id是自增的，目前假设最多达到10位数的编号，如果更多后期再改-->
                </div>
                <div class="form-group">
                    <label>租房时间：</label>
                    <input type="date" name="order.orderStime" id="Stime" value="" min="">-<!--用于js验证的id=Stime-->
                    <input type="date" name="order.orderEtime" id="Etime" value="" min=""><!--用于js验证的id=Etime-->
                </div>
                <div class="form-group">
                    <label>租房金额：</label>
                    <input type="text" name="order.orderRent" id="rent" placeholder="整数，单位：元" maxlength="10"><!--用于js验证的id=rent-->
                </div>

                <div class="form-group">
                    <label>租客：</label>
                    <input type="text" name="applyerName" id="applyerName" placeholder="姓名 2-10位汉字"><!--用于js验证的id=applyerName-->
                </div>
                <div class="form-group">
                    <label>租客联系方式：</label>
                    <input type="text" name="applyerTel" id="applyerTel" placeholder="请输入有效手机号"><!--用于js验证的id=applyerTel-->
                </div>


                <button type="submit" class="btn btn-secondary">上传</button>
            </form>
        </div>
    </div>

</div>
<!--页面内容End-->
<script src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">

    //开始时间选择限制：不小于当前日期
    $("#Stime").click(function(){
        var date_today=new Date();

        //today-对应年份
        var year=date_today.getFullYear();
        //today-对应月份
        var month=date_today.getMonth()+1<10?"0"+(date_today.getMonth()+1):(date_today.getMonth()+1);
        //today-对应日期
        var date=date_today.getDate()< 10 ? "0"+date_today.getDate() : date_today.getDate();

        $("#Stime").attr("min",year+"-"+month+"-"+date);
    });
    //结束时间选择限制：不小于开始日期
    $("#Etime").click(function(){
        var date_Emin=new Date();
        date_Emin=$("#Stime").val();
        $("#Etime").attr("min",date_Emin);
    });

    var add_tel_check= false;//租客手机号码验证
    //手机号码验证方法
    $('#applyerTel').blur(function () {
        if ((/^1[34578]\d{9}$/).test($("#applyerTel").val())){
            add_tel_check = true;
        }else {
            add_tel_check = false;
        }
    })

    var add_name_check=false;//租客姓名验证
    //姓名验证方法
    $('#applyerName').blur(function () {
        if (( /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,10}$/).test($("#applyerName").val())){
            add_name_check = true;
        }else {
            add_name_check = false;
        }
    })


    var add_rent_check=false; //租金纯数字+位数验证
    //租金验证方法
    $('#rent').blur(function (){
        if((/^\d{1,10}$/).test($("#rent").val())){
            add_rent_check=true;
        }else{
            add_rent_check=false;
        }
    })

    var houseid_check=false;//房源id纯数字+位数验证
    //房源id验证方法
    $('#houseId').blur(function (){
        if((/^\d{1,10}$/).test($("#houseId").val())){
            houseid_check=true;
        }else{
            houseid_check=false;
        }
    })

    //主方法：比较并返回
    function checkAddOrder() {
        if (houseid_check!==true) {
            //验证房源id纯数字
            alert("请正确填写房源编号")
            document.getElementById('houseId').value="";
            return false;
        }else if(add_rent_check!==true){
            //验证租金纯数字
            alert("请正确填写租金");
            document.getElementById('rent').value="";
            return false;
        }else if(add_name_check!==true){
            //验证租客姓名
            alert("请按正确格式填写 租客姓名 ");
            document.getElementById('applyerName').value = "";
            return false;
        } else if(add_tel_check !== true){
            //验证房源id纯数字
            //验证租客手机号码
            alert("请按正确格式填写 租客手机号码 ");
            document.getElementById('applyerTel').value = "";
            return false;
        } else {
            return true;
        }
    }

</script>

<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-table@1.15.2/dist/bootstrap-table.min.js"></script>
</body>
</html>
