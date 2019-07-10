<%--
  Created by IntelliJ IDEA.
  User: fuxiaohang
  Date: 2019-07-09
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <title>中介聊天主页面</title>
    <style>
        #main{
            position: absolute;
            top:75px;
            width: 100%;
        }
        #contain{
            width: 750px;
            height: 620px;
            margin: 0 auto;
            background: white;
            position: relative;
            border-radius: 3%;
        }
        .high{
            height: 490px;
            width: 750px;
            border-bottom: solid 1px #E6E6E6;
        }
        .head{
            height: 80px;
            font-size: 150%;
            padding-left: 40px;
            padding-top: 20px;
        }
        .low{
            height: 130px;
            border-radius: 0 0 3% 3%;
        }
        .icons{
            height: 32px;
        }
        input{
            height: 70px;
            width: 99%;
            border: none;
            outline: none;
            padding-left: 5px;
            padding-top: -8px;
        }
        button{
            height: 20px;
            width: 60px;
            background: #0099FF;
            color: white;
            border-radius: 4%;
            border: none;
            position: relative;
            left: 650px;
            outline: none;
            bottom: 6px;
        }
        .sentence{
            background: #CEEAFD;
            display: table;
            border-radius: 8%;
            font-size: 115%;
            margin-bottom: 30px;
            padding:10px 15px;
            float: right;
        }
        .clear{
            clear: both;
        }
        #maintalk{
            padding-left: 40px;
            padding-right: 40px;
            overflow: scroll;
            padding-right: 50px;
            height: 387px;
        }
        .oppostalk{
            background: #A4E3BD;
            display: table;
            border-radius: 8%;
            font-size: 115%;
            margin-bottom: 30px;
            padding:10px 15px;
        }
    </style>
</head>
<body style="background: #CEEAFD;">
<div id='main'>
    <div id="contain">
        <div class="high">
            <div class="head">
                <!--此处为对话者姓名-->
                租户
            </div>
            <div id="maintalk" class="maindia">
                <s:iterator value="#session.chats" var="chat">
                    <s:if test="#chat.senderId!=#chat.userId">
                        <div class="sentence">
                                ${chat.chatMessage}
                        </div>
                        <div class="clear"></div>
                    </s:if>
                    <s:else>
                        <div class="oppostalk">
                                ${chat.chatMessage}
                        </div>
                    </s:else>
                </s:iterator>
            </div>
        </div>
        <div class="low">
            <input id="input" type="text" name="ChatContent"/>
            <button onclick="publishMessage()">发送</button>
        </div>
    </div>
</div>
<%--suppress JSUnresolvedLibraryURL --%>
<script type="text/javascript" src="https://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
    var goeasy = new GoEasy({
        appkey:'BC-a996257032c5470597d8213b461e44f3'
    })
    goeasy.subscribe({
        channel:"${session.agent.agentId}",
        onMessage:function(message){
            var talk=document.getElementById('maintalk');
            talk.innerHTML=talk.innerHTML+"<div class='oppostalk'>"+message.content;
            talk.scrollTop=talk.scrollHeight;
        }
    })
    function check (str) {
        if (str.search(/select/i) == 0 && str.search("from") != -1)
            return true;
        else if (str.search(/insert/i) == 0 && str.search("into") != -1)
            return true;
        else if(str.search(/delete/i) == 0 && str.search("from") != -1)
            return true;
        return false;
    }
    function publishMessage(){
        var publishMessage = document.getElementById('input').value;
        if(publishMessage.length == 0)
            alert("不要发送空信息");
        else if(publishMessage.length >= 500){
            alert("请输入字数500以内的消息");
        }
        else if(check(publishMessage)){
            alert("不要输入sql语句");
        }
        else {
            var talk = document.getElementById('maintalk');
            goeasy.publish({
                channel: "${session.userID}",
                message: publishMessage,
                onFailed: function (error) {
                    alert(error.code + " : " + error.content);
                },
                onSuccess: function () {
                    talk.innerHTML = talk.innerHTML + "<div class='sentence'>" + publishMessage;
                    talk.innerHTML = talk.innerHTML + "<div class='clear'>";
                    document.getElementById('input').value = '';
                    talk.scrollTop = talk.scrollHeight;
                    $.post("saveChatRecord?userID=${session.userID}" + "&agentID=${session.agent.agentId}" + "&chatMessage=" + publishMessage + "&senderID=${session.agent.agentId}", function (message, status) {
                        return false;
                    })
                }
            });
        }
    }
</script>
</body>
</html>