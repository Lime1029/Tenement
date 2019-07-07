<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/29
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user home</title>

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询(media queries)功能 -->
    <!-- 警告：通过 file:// 协议(就是直接将 html 页面拖拽到浏览器中)访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">

        <div class="row clearfix">
            <div class="col-md-16 column">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="navbar-header">
                        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">爱家</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active">
                                <a href="#">首页</a>
                            </li>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="../myCenter/userInfo.jsp"><span class="glyphicon glyphicon-user"></span>个人中心</a>
                            </li>
                            <li>
                                <a href="">&nbsp;&nbsp;退出</a>
                            </li>
                        </ul>
                    </div>
                </nav>

            </div>
        </div>

        <div class="row clearfix">

        </div>

    </div>
    <form id="form1" action="loadAgentChatRecord.action" method="post">
        <input type="hidden" name="agentID" value="1000">
        <input type="hidden" name="userID" value="1">
    </form>
    <button onclick="send()">我想订房</button>
    <%--suppress JSUnresolvedLibraryURL --%>
    <script type="text/javascript" src="https://cdn-hangzhou.goeasy.io/goeasy.js"></script>
    <script type="text/javascript">
        var goeasy = new GoEasy({
            appkey:'BC-a996257032c5470597d8213b461e44f3'
        })
        function send() {
            goeasy.publish({
                channel: 'agent_alert',
                message: "用户1想看1号房",
                onFailed: function (error) {
                    alert(error.code+" : "+error.content);
                },
                onSuccess: function(){
                   var reply = window.confirm("预约成功\n点击确认进入交流页面")
                    if(reply){
                        document.getElementById("form1").submit();
                    }
                }
            });
        }
    </script>
</body>
</html>
