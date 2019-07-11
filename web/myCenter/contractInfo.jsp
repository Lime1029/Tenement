<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/4
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Contract</title>
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

            <c:choose>
                <c:when test="${sessionScope.myContract.size() == 0}">
                    目前暂未有房屋合同
                </c:when>
                <c:otherwise>
                    <c:forEach items="${sessionScope.myContract}" var="contract" varStatus="contractStatus">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title" style="font-size: 25px;width: auto;display: inline;" >合同${contractStatus.index + 1}</h3>

                            </div>
                            <div class="panel-body">
                                <h4>出租人（甲方）：
                                    <c:choose>
                                        <c:when test="${contract.landlord} != null">
                                            ${contract.landlord}
                                        </c:when>
                                        <c:otherwise>
                                            ${contract.landlordTel}
                                        </c:otherwise>
                                    </c:choose></h4>
                                <h4>承租人（乙方）：
                                    <c:choose>
                                        <c:when test="${contract.tenant != null}">
                                            ${contract.tenant}
                                        </c:when>
                                        <c:otherwise>
                                            ${contract.tenantTel}
                                        </c:otherwise>
                                    </c:choose></h4>
                                <h4>居间人（丙方）：${contract.agentName}</h4>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">房屋情况</h4>
                                    </div>
                                    <div class="panel-body">
                                        <h5>房屋坐落：北京市${contract.districtName}${contract.plotName}${contract.address}</h5>
                                        <h5>建筑面积：${contract.area}平米</h5>
                                        <h5>其他信息：&nbsp;&nbsp;&nbsp;&nbsp;户型：${contract.houseType}</h5>

                                    </div>
                                </div>

                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">交付日期和租赁期限</h4>
                                    </div>
                                    <div class="panel-body">
                                        <h5>甲乙双方约定：甲方于${contract.stime}前向乙方交付该房屋，租赁期限为${contract.stime}到${contract.etime}</h5>
                                    </div>
                                </div>

                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">租金和租金支付</h4>
                                    </div>
                                    <div class="panel-body">
                                        <h5>租金标准：${contract.rent}元/月。</h5>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>



        </div>


    </div>

</body>
</html>
