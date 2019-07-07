<%--
  Created by IntelliJ IDEA.
  User: fuxiaohang
  Date: 2019-07-03
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <title>订单展示</title>
    <meta charset="UTF-8">
    <style>
        table {
            width: 100%;
            border: 0;
            margin: 0;
            border-collapse: collapse;
            text-align: center;
            position: relative;
        }

        table {
            border: 1.3px solid rgb(86, 132, 190);
        }


        table th {
            height: 45px;
            font-size: 18px;
            background: rgb(86, 132, 190);
            color: #fff;
        }

        table td {
            height: 56px;
            font-size: 16px;
            color: rgb(86, 132, 190);
        }
        .seek{
            position: relative;
            width: 100%;
            text-align: center;
            margin-bottom: 30px;
            padding-top: 15px;
        }
        .seek input{
            padding-left: 20px;
            width: 400px;
            height: 45px;
            outline: none;
        }
        .seek img{
            position: relative;
            top: 6px;
            left: -35px;
        }
        .seek select{
            height: 45px;
            outline: none;
            width: 110px;
        }

        .seek .date{
            position: relative;
            right: 13px;
            width: 120px;
        }

        .seek .btn{
            width: 150px;
            height: 40px;
            background-color: rgb(86, 132, 190);
            border: none;
            padding: 0;
            text-align: center;
            border-radius: 5px;
            color: white;
            font-size: 16px;
        }
        .footer{
            padding-top: 30px;
            text-align: center;
        }
        .footer form{
            display: inline-block;
        }
    </style>
</head>
<body>
<div class="seek">
    <select>
        <option value="" selected="true" class="item">订单ID</option>
        <option value="" class="item">中介ID或用户名</option>
        <option value="" class="item">租户ID和用户名</option>
    </select>
    <input type="text" placeholder="订单搜索" id="searchContent">
    <img src="../images/seek.png" onclick="search()">
    <input type="text" id="dateChoose1" value="起始日期" class="date">
    <input type="text" id="dateChoose2" value="结束日期" class="date">
    <input type="submit" value="按日期查询订单" onclick="searchByDateRange()" class="btn">
</div>
<div class="middle ">
    <table>
        <tr>
            <th>订单号</th>
            <th>起始时间</th>
            <th>结束时间</th>
            <th>订单状态</th>
            <th>房源号</th>
            <th>中介人</th>
            <th>租户</th>
            <th>删除</th>
            <th>查看详细信息</th>
        </tr>
        <s:iterator value="#session.orders" var="order">
            <tr style="border-bottom: 1px solid rgb(224,232,242);">
                <td>${order.orderId }</td>
                <td>${order.orderStime }</td>
                <td>${order.orderEtime }</td>
                <td>${order.orderStatus}</td>
                <td>${order.houseId}</td>
                <td>${order.agentId}</td>
                <td>${order.applyerId}</td>
                <td>
                    <form action="deleteOrder.action" method="post">
                        <input type="hidden" value='${order.orderId}' name="orderID">
                        <input type="submit" value="删除" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                    </form>
                </td>
                <td>
                    <form action="getOrderDetail.action" method="post">
                        <input type="hidden" value="${order.orderId}" name="orderID">
                        <input type="submit" value="详细信息" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                    </form>
                </td>
            </tr>
        </s:iterator>
    </table>
</div>
<div class="footer">
    <!--
    <form action="getAllOrder.action" method="post">
        <input type="hidden" value="${last}", name="start">
        <input type="hidden" value="${count}" name="count">
        <input type="submit" value="上一页">
    </form>
    <form action="getAllOrder.action" method="post">
        <input type="hidden" value="${start}", name="start">
        <input type="hidden" value="${count}" name="count">
        <input type="submit" value="下一页">
    </form>
    -->
</div>
<script src="../js/layDate-v5.0.9/laydate/laydate.js"></script> <!-- 改成你的路径 -->
<script type="text/javascript">
    window.onload = function(){
        let footer = document.getElementsByClassName("footer")[0];
        footer.innerHTML = "";
        if("${status}" == "all"){
            footer.innerHTML += ` <form action="getAllOrder.action" method="post">
        <input type="hidden" value="${last}", name="start">
        <input type="hidden" value="${count}" name="count">
        <input type="submit" value="上一页">
    </form>
    <form action="getAllOrder.action" method="post">
        <input type="hidden" value="${start}", name="start">
        <input type="hidden" value="${count}" name="count">
        <input type="submit" value="下一页">`
        }

    else if("${status}" == "date"){
        footer.innerHTML +=
        ` <form action="getOrderByDateRange.action" method="post">
         <input type="hidden" value="${stime}", name="stime">
        <input type="hidden" value="${etime}" name="etime">
        <input type="hidden" value="${last}", name="start">
        <input type="hidden" value="${count}" name="count">
        <input type="submit" value="上一页">
    </form>
    <form action="getOrderByDateRange.action" method="post">
    <input type="hidden" value="${stime}", name="stime">
        <input type="hidden" value="${etime}" name="etime">
        <input type="hidden" value="${start}", name="start">
        <input type="hidden" value="${count}" name="count">
        <input type="submit" value="下一页">`
    }

    }
    function search(){
        select_elements = document.getElementsByClassName("item");
        if(select_elements[0].selected == true){
            searchByOrderID();
        }
        if(select_elements[1].selected == true){
            searchByAgentInfo();
        }
        if(select_elements[2].selected == true)
            searchByUserInfo();
    }
    function searchByOrderID(){
        let orderID = document.getElementById("searchContent").value;
        orderID = Number(orderID);
        const form1 = document.createElement("form");
        form1.action="getOrderByOrderID?orderID="+orderID;
        form1.method = "post";
        form1.style.display = "none";
        document.body.appendChild(form1);
        form1.submit();
        return form1;
    }
    function searchByAgentInfo() {
        const agentInfo = document.getElementById("searchContent").value;
        const form2 = document.createElement("form");
        form2.action="searchAgent?agentInfo="+agentInfo;
        form2.method = "post";
        form2.style.display = "none";
        document.body.appendChild(form2);
        form2.submit();
        return form2;
    }
    function searchByUserInfo(){
        const userInfo = document.getElementById("searchContent").value;
        const form3 = document.createElement("form");
        form3.action = "searchOrderByUserInfo?userInfo="+userInfo;
        form3.method = "post";
        form3.style.display = "none";
        document.body.appendChild(form3);
        form3.submit();
        return form3;
    }
    laydate.render({
        elem: '#dateChoose1'
        ,format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#dateChoose2'
        ,format: 'yyyy-MM-dd'
    });
    function searchByDateRange(){
        const stime = document.getElementById("dateChoose1").value;
        const etime = document.getElementById("dateChoose2").value;
        const stime_replace = stime.replace(/-/g,'/');
        const etime_replace = etime.replace(/-/g,'/');
        const sdate = new Date(stime_replace);
        const edate = new Date(etime_replace);
        if(sdate == 'Invalid Date' || edate == 'Invalid Date'){
            alert("请输入有效日期");
        }
        else if(edate<sdate){
            alert("结束日期不能早于开始日期");
        }
        else {
            const form4 = document.createElement("form");
            form4.action = "getOrderByDateRange?stime=" + stime + "&etime=" + etime + "&start=0&count=1" ;
            form4.method = "post";
            form4.style.display = "none";
            document.body.appendChild(form4);
            form4.submit();
            return form4;
        }
    }
</script>
</body>
</html>
