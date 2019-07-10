<%--
  Created by IntelliJ IDEA.
  User: fuxiaohang
  Date: 2019-07-10
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单成功删除</title>
</head>
<body>
订单删除成功！
<form action="getAllOrder.action" method="post">
    <input type="hidden" value="0" name="start">
    <input type="hidden" value="1" name="count">
    <input type="submit" value="点击返回订单主页面">
</form>
</body>
</html>