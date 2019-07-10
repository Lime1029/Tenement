<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/29
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <title>agent home</title>
</head>
<body>
<form action="agentChat.action" id="form1" method="post">
    <input type="hidden" value="${session.agent.agentId}" name="agentID">
</form>
<form action="agentChat.action" method="post">
    <input type="hidden" value="${session.agent.agentId}" name="agentID">
    <input type="submit" value="查看消息记录">
</form>
<%--suppress JSUnresolvedLibraryURL --%>
<script type="text/javascript" src="https://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
    var goeasy = new GoEasy({
        appkey:'BC-a996257032c5470597d8213b461e44f3'
    })
    goeasy.subscribe({
        channel:'agent_alert',
        onMessage:function(message){
            var reply = window.confirm(message.content+"\n"+"单击确认跳转到消息页面");
            if(reply){
                document.getElementById("form1").submit();
            }
        }
    })

</script>
</body>
</html>
