<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/2
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>House Info</title>

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
                            <li>
                                <a href="../home/user.jsp">首页</a>
                            </li>
                            <li>
                                <a href="../search/search.jsp">租房</a>
                            </li>
                            <li>
                                <a href="plotGet.action">发布房源</a>
                            </li>
                            <li>
                                <a href="messageShow.action">讨论版</a>
                            </li>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="../myCenter/userInfo.jsp"><span class="glyphicon glyphicon-user"></span>个人中心</a>
                            </li>
                            <li>
                                <a href="logout.action">&nbsp;&nbsp;退出</a>
                            </li>
                        </ul>
                    </div>
                </nav>

            </div>
        </div>

        <div class="row clearfix">

            <h1>${houseInfo.address}</h1>
            <label style="color: #6c757d;">上架时间：${houseInfo.releaseTime}</label>

            <div class="panel panel-default">
                <div class="panel-heading">
                        <h3 class="panel-title" style="font-size: 25px;width: auto;display: inline;" >房屋信息</h3>

                </div>
                <div class="panel-body" style="color: #6c757d;">
                    <h4>小区：&nbsp;&nbsp;&nbsp;&nbsp;${houseInfo.districtName}${houseInfo.plotName}</h4>
                    <h4>租金：&nbsp;&nbsp;&nbsp;&nbsp;${houseInfo.rent}元/月</h4>
                    <h4>户型：&nbsp;&nbsp;&nbsp;&nbsp;${houseInfo.houseType}</h4>
                    <h4>楼层：&nbsp;&nbsp;&nbsp;&nbsp;${houseInfo.floor}</h4>
                    <h4>面积：&nbsp;&nbsp;&nbsp;&nbsp;${houseInfo.area}平米</h4>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" style="font-size: 25px;width: auto;display: inline;" >房源描述</h3>
                    <form style="float:right;" action="loadAgentChatRecord.action" method="post">
                        <input name="agentID" value="${houseInfo.agentId}" hidden="hidden">
                        <input name="userID" value="${user.userId}" hidden="hidden">
                        <input name="houseId" value="${houseInfo.houseId}" hidden="hidden">
                        <input type="hidden" name="type" value="user">
                        <h4 style="display: inline;">经纪人：${houseInfo.agentName}&nbsp;&nbsp;</h4>
                        <span><button class="btn btn-primary" style="" type="submit" onclick="send()">在线咨询</button></span>
                    </form>
                </div>
                <div class="panel-body">
                        
                    <h4 style="color: darkblue;">${houseInfo.houseDescription}</h4>
                </div>
            </div>
        </div>

    </div>

    <%--suppress JSUnresolvedLibraryURL --%>
    <script type="text/javascript" src="https://cdn-hangzhou.goeasy.io/goeasy.js"></script>
    <script type="text/javascript">
        var goeasy = new GoEasy({
            appkey:'BC-a996257032c5470597d8213b461e44f3'
        })
        function send() {
            goeasy.publish({
                channel: '${houseInfo.agentId}',
                message: "用户${user.userId}想看${houseInfo.houseId}号房",
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
