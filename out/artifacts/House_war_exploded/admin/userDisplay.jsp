<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/1
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>user administration</title>

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
    </style>
</head>
<body>

    <div class="middle ">
        <table>
            <tr>
                <th>用户ID</th>
                <th>手机号</th>
                <th>密码</th>
            </tr>
        <s:iterator value="#session.users" var="user">
            <tr style="border-bottom: 1px solid rgb(224,232,242);">
                <td>${user[0]}</td>
                <td>${user[1]}</td>
                <td>${user[2]}</td>
            </tr>
        </s:iterator>


        </table>
    </div>
    <!--<table id="usertable" class="table table-hover"></table>-->
    <script type="text/javascript">
        console.log("${users}")
    </script>
</body>
</html>
