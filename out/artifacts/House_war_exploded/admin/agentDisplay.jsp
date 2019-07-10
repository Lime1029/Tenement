<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/3
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>agent administration</title>

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

    <style>
        .modal-content {
            position: relative;
        .box-shadow(0 3px 9px rgba(0,0,0,.5));
            background-clip: border-box;
            outline: 0;

            width: 400px;
        }

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
            text-align: center;
        }

        table td {
            height: 56px;
            font-size: 16px;
            color: rgb(86, 132, 190);
        }

        #search {
            float: right;
            display: inline;
            width: 300px;
            margin-right: 0px;
        }

        #search input {
            display: inline;
            width: 300px;
            font-size: 15px;
        }
    </style>

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
                            <li >
                                <a href="../home/admin.jsp">首页</a>
                            </li>
                            <li >
                                <a href="<s:url action="houseDisplay"/>">房源管理</a>
                            </li>
                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    用户管理<b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu active">
                                    <li><a href="<s:url action="userDisplay"/>">普通用户</a></li>
                                    <li><a href="<s:url action="agentDisplay"/>">经理人</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    地区管理<b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="<s:url action="plotDisplay"/>">小区</a></li>
                                    <li><a href="<s:url action="districtDisplay"/>">区域</a></li>
                                    <li><a href="<s:url action="cityDisplay"/>">城市</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="getAllOrder.action?start=0&count=1">订单管理</a>
                            </li>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="logout.action">&nbsp;&nbsp;退出</a>
                            </li>
                        </ul>
                    </div>
                </nav>

            </div>
        </div>

        <div class="row clearfix">

            <form role="form" id="search" action="agentSearch.action">
                <input type="search" maxlength="15" placeholder="请输入经纪人ID，手机号或姓名搜索" class="form-control" name="condition">
            </form>
            <span><button class="btn btn-primary" data-toggle="modal" data-target="#addAgent" href="" style="">新增经纪人</button></span>
            <div class="middle ">
                <c:choose>
                    <c:when test="${sessionScope.agents.size() == 0}">
                        共找到0条记录
                    </c:when>
                    <c:otherwise>
                        <table>
                            <tr>
                                <th>用户ID</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>密码</th>
                                <th>删除</th>
                            </tr>
                            <!--略醉，我发现查询所有数据就可以这样访问-->
                            <s:iterator value="#session.agents" var="agent">
                                <tr style="border-bottom: 1px solid rgb(224,232,242);">
                                    <td>${agent.agentId}</td>
                                    <td>${agent.name}</td>
                                    <td>${agent.telephone}</td>
                                    <td>${agent.password}</td>
                                    <td>
                                        <form action="deleteAgent.action" method="post">
                                            <input type="hidden" value=${agent.agentId} name="agentId">
                                            <input type="submit" value="删除" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                                        </form>
                                    </td>
                                </tr>
                            </s:iterator>


                        </table>
                    </c:otherwise>
                </c:choose>

            </div>



        </div>

    </div>

    <div id="addAgent" class="modal fade" tabindex="-1" data-keyboard=”static”>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">新增经纪人</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="insertAgent.action" method="post" id="insertAgent" onsubmit="return checkAddAgent()">

                        <div class="form-group">
                            <label>姓名</label>
                            <input class="form-control" type="text" placeholder="" name="agentName" id="agentName" minlength="2" maxlength="20">
                        </div>
                        <div class="form-group">
                            <label>手机号</label>
                            <input class="form-control" type="text" placeholder="输入正确格式" name="agentTelephone" id="agentTel" maxlength="11">
                        </div>
                        <div class="form-group">
                            <label>初始密码</label>
                            <input class="form-control" type="password" placeholder="6-15位字母、数字或_" name="agentPassword" id="agentPassword" minlength="6" maxlength="15">
                        </div>

                        <div class="text-right">
                            <button class="btn btn-primary" type="submit">提交</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        var agent_name_boolean = false;
        var agent_telephone_boolean = false;
        var agent_password_boolean = false;
        var hint = "", hint1="", hint2="", hint3="";

        //当输入框的文本改变时调用
        $('#agentName').blur(function () {
            if ((/^(?:[\u4e00-\u9fa5]+)(?:●[\u4e00-\u9fa5]+)*$|^[a-zA-Z0-9]+\s?[\.·\-()a-zA-Z]*[a-zA-Z]{2,20}$/).test($('#agentName').val())) {
                agent_name_boolean = true;
                $('#agentName').parent().addClass('has-success').removeClass('has-error');
            }
            else {
                agent_name_boolean = false;
                $('#agentName').parent().addClass('has-error').removeClass('has-success');
                hint1 = "姓名格式错误\n";
            }
        })

        $('#agentTel').blur(function () {
            if ((/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/).test($('#agentTel').val())) {
                agent_telephone_boolean = true;
                $('#agentTel').parent().addClass('has-success').removeClass('has-error');
            }
            else {
                agent_telephone_boolean = false;
                $('#agentTel').parent().addClass('has-error').removeClass('has-success');
                hint2 = "手机号格式错误\n";
            }
        })

        $('#agentPassword').blur(function () {
            if ((/^[a-z0-9_-]{6,15}$/).test($('#agentPassword').val())) {
                agent_password_boolean = true;
                $('#agentPassword').parent().addClass('has-success').removeClass('has-error');
            }
            else {
                agent_password_boolean = false;
                $('#agentPassword').parent().addClass('has-error').removeClass('has-success');
                hint3 = "密码由6-15位数字、字母或_组成\n";
            }
        })

        function checkAddAgent() {
            if ((agent_password_boolean && agent_telephone_boolean && agent_name_boolean) !== true) {
                hint = hint1 + hint2 + hint3;
                if (hint == "") {
                    alert("请填写完整信息");
                }
                else {
                    alert(hint);
                }

                return false;
            }
            else return true;
        }
    </script>

</body>
</html>
