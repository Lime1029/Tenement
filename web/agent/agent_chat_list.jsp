<%--
  Created by IntelliJ IDEA.
  User: fuxiaohang
  Date: 2019-07-09
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <title>消息记录</title>
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
<div class="middle ">
    <table>
        <tr>
            <th>租户id</th>
            <th>租户名</th>
            <th>最后发送消息时间</th>
            <th>进入聊天</th>
        </tr>
        <s:iterator value="#session.users_chats" var="user_chat" status="cur">
            <tr style="border-bottom: 1px solid rgb(224,232,242);">
                <td>${user_chat[0].userId}</td>
                <td>${user_names[cur.getIndex()]}</td>
                <td>${user_chat[user_chat.size()-1].sendTime}</td>
                <td>
                    <form action="loadAgentChatRecord.action" method="post">
                        <input type="hidden" value="${session.agent.agentId}" name="agentID">
                        <input type="hidden" value="${user_chat[0].userId}" name="userID">
                        <input type="hidden" value="agent" name="type">
                        <input type="submit" value="进入聊天" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                    </form>
                </td>
            </tr>
        </s:iterator>
    </table>
</div>