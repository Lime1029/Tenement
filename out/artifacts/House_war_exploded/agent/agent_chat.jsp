<%--
  Created by IntelliJ IDEA.
  User: fuxiaohang
  Date: 2019-07-02
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>agent_chat</title>
    <%--suppress JSUnresolvedLibraryURL --%>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <meta charset="UTF-8">
    <style>
        #main{
            position: absolute;
            top:75px;
            width: 100%;
        }
        #contain{
            width: 950px;
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
        .maindia{
            padding-left: 40px;
            padding-right: 40px;
            padding-right: 50px;
            height: 387px;
            overflow-y: auto;
        }
        .oppostalk{
            background: #A4E3BD;
            display: table;
            border-radius: 8%;
            font-size: 115%;
            margin-bottom: 30px;
            padding:10px 15px;
        }
        .left{
            width: 200px;
            height: 100%;
            float: left;
            border-right: solid 1px #E6E6E6;
        }
        .right{
            width: 750px;
            margin-left: 200px;
        }
        .dialogue{
            width: 200px;
            height: 60px;
            border:none;
        }
        .dialogue img{
            width: 50px;
            height: 50px;
            border-radius: 50%;
            margin-top: 5px;
            margin-left: 8px;
        }
        .dialogue span{
            font-size: 100%;
            position: relative;
            bottom: 20px;
            left: 10px;
        }
        .dialogue:hover{
            background: #E6E6E6;
        }
    </style>
</head>
<body style="background: #CEEAFD;">
<div id='main'>
    <div id="contain">
        <div class="left">
            <center style="margin:15px auto 0 auto;border-bottom: solid 1px #E6E6E6;padding-bottom: 10px;">会话列表</center>
            <div class="conversation">
                <s:iterator value="#session.users_chats" var="user_chat" status="cur">
                    <div id="${user_chat[0].userId}" class="dialogue" onclick="chooseDia('${user_chat}')">
                        租户${user_names[cur.getIndex()]}
                    </div>
                </s:iterator>

            </div>
        </div>
        <div class="right" id="talk_win">
            <div class="high">
                <div class="head">
                </div>
                <div id="maintalk" class="maindia">
                </div>
            </div>
            <div class="low">

                <input id="input" type="textare" />
                <div id="send">

                </div>

            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="https://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
    var goeasy = new GoEasy({
        appkey:'BC-a996257032c5470597d8213b461e44f3'
    })
    goeasy.subscribe({
        channel:''+${agent.agentId},
        onMessage:function(message){
            var talk=document.getElementById('maintalk');
            talk.innerHTML=talk.innerHTML+"<div class='oppostalk'>"+message.content;
            talk.scrollTop=talk.scrollHeight;
        }
    })
    function publishMessage(userID){
        var publishMessage = document.getElementById('input').value;
        var talk=document.getElementById('maintalk');
        goeasy.publish({
            channel: ''+userID,
            message: publishMessage,
            onFailed: function (error) {
                alert(error.code+" : "+error.content);
            },
            onSuccess: function(){
                talk.innerHTML=talk.innerHTML+"<div class='sentence'>"+publishMessage;
                talk.innerHTML=talk.innerHTML+"<div class='clear'>";
                document.getElementById('input').value='';
                talk.scrollTop=talk.scrollHeight;
                $.post("saveChatRecord?agentID=${agent.agentId}"+"&userID="+userID+"&chatMessage="+publishMessage+"&senderID=${agent.agentId}", function(message, status) {
                    return false;
                })
            }
        });
    }
    function chooseDia(user_chat) {
        var talk_win = document.getElementById('talk_win');
        document.getElementsByClassName('head')[0].innerText = '房客'+ '${user_chat[0].userId}';
        var send_btn = document.getElementById('send');
        send_btn.innerHTML = "";
        send_btn.innerHTML +=  '<button onclick="publishMessage('+ '${user_chat[0].userId}' +')">发送</button>';
        var talk=document.getElementById('maintalk');
        talk.innerHTML ="";
        talk.innerHTML +=`<s:iterator value="#user_chat" var="chat">
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
                    </s:iterator>`;
    }
</script>
</body>
</html>