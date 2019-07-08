<%--
  Created by IntelliJ IDEA.
  User: fuxiaohang
  Date: 2019-07-03
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>订单详情</title>
</head>
<body style="background-color: rgb(82,182,239);">
<div style="margin-bottom: 20px;font-size: 25px;width: 100%;text-align: center;color: white;">订单详情</div>
<div style="background-color: white;width: 500px;margin: 0 auto;padding: 30px 50px;border-radius: 10px;">
    <p>订单号：${order.orderId}</p>
    <p>订单开始时间：${order.orderStime}</p>
    <p>订单结束时间：${order.orderEtime}</p>
    <p>订单状态：
        <s:if test="#session.order.orderStatus==0">
            未支付
        </s:if>
        <s:else>
            已支付
        </s:else>
    </p>
    <p>房屋ID：${order.houseId}</p>
    <p>房屋地址：${house.address}</p>
    <p>房屋状态：
        <s:if test="#session.house.satus==0">
            不再出租
        </s:if>
        <s:else>
            出租中
        </s:else>
    </p>
    <p>房屋类型：${house.houseType}</p>
    <p>房屋面积：${house.area}</p>
    <p>房屋楼层：${house.floor}</p>
    <p>房屋描述：${house.houseDescription}</p>
    <p>房屋发布时间：${house.releaseTime}</p>
    <p>房东ID：${landlord.userId}</p>
    <p>房东电话：${landlord.telephone}</p>
    <p>房东用户名：${landlord.username}</p>
    <p>房东姓名：${landlord.name}</p>
    <p>租户ID：${applyer.userId}</p>
    <p>租户用户名：${applyer.username}</p>
    <p>租户姓名：${applyer.name}</p>
</div>
</body>
</html>