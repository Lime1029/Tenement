<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/6
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>plot administration</title>

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

        .modal-content {
            position: relative;
        .box-shadow(0 3px 9px rgba(0,0,0,.5));
            background-clip: border-box;
            outline: 0;

            width: 400px;
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
                            <li>
                                <a href="<s:url action="houseDisplay"/>">房源管理</a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    用户管理<b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="<s:url action="userDisplay"/>">普通用户</a></li>
                                    <li><a href="<s:url action="agentDisplay"/>">经理人</a></li>
                                </ul>
                            </li>
                            <li class="dropdown active">
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

            <form role="form" id="search" action="searchPlot.action">
                <input type="search" placeholder="输入小区，区域或城市搜索" maxlength="15" class="form-control" name="condition">
            </form>
            <span><button class="btn btn-primary" data-toggle="modal" data-target="#addPlot" href="" style="">新增小区</button></span>

            <div class="middle ">
                <table>
                    <tr>
                        <th>小区ID</th>
                        <th>小区名</th>
                        <th>所属城市ID</th>
                        <th>所属城市名</th>
                        <th>所属区域ID</th>
                        <th>所属区域名</th>
                        <th>经纪人ID</th>
                        <th>经纪人</th>
                        <th>修改</th>
                        <th>删除</th>
                    </tr>
                    <c:choose>
                    <c:when test="${sessionScope.plots.size() == 0}">
                        共找到0条记录
                    </c:when>
                    <c:otherwise>


                            <s:iterator value="#session.plots" var="plot">
                                <tr style="border-bottom: 1px solid rgb(224,232,242);">
                                    <td>${plot[0]}</td>
                                    <td>${plot[1]}</td>
                                    <td>${plot[2]}</td>
                                    <td>${plot[3]}</td>
                                    <td>${plot[4]}</td>
                                    <td>${plot[5]}</td>
                                    <td>${plot[6]}</td>
                                    <td>${plot[7]}</td>
                                    <td>
                                        <input type="button" value="修改" data-target="#modifyPlot" data-toggle="modal" onclick="edit(this)" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                                    </td>
                                    <td>
                                        <form action="deletePlot.action" method="post">
                                            <input type="hidden" value=${plot[0]} name="plotId">
                                            <input type="submit" value="删除" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                                        </form>
                                    </td>
                                </tr>
                            </s:iterator>


                    </c:otherwise>
                </c:choose>
                </table>
            </div>

        </div>

    </div>


    <div id="addPlot" class="modal fade" tabindex="-1" data-keyboard=”static”>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h3 class="text-center">新增小区</h3>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="addPlot.action" method="post" onsubmit="return checkAddPlot()">

                        <div class="form-group">
                            <label>小区名称</label>
                            <input class="form-control" type="text" placeholder="" name="plotName" id="plotName1" minlength="3" maxlength="10">
                        </div>
                        <div class="form-group">
                            <label>所属城市</label>
                            <div class="col-sm-16">

                                <select class="form-control" name="cityId" id="citySelect">
                                    <s:iterator value="#session.plotCities" var="plotCity">
                                        <option value="${plotCity.id}" id="${plotCity.name}">${plotCity.name}</option>
                                    </s:iterator>
                                </select>

                            </div>
                            <div class="col-sm-4 tips"></div>
                        </div>
                        <div class="form-group">
                            <label>所属区域</label>
                            <div class="col-sm-16">

                                <select class="form-control" name="districtId" id="districtSelect">
                                    <s:iterator value="#session.plotDistricts" var="plotDistrict">
                                        <option value="${plotDistrict[0]}" id="${plotDistrict[1]}">${plotDistrict[1]}</option>
                                    </s:iterator>
                                </select>

                            </div>
                            <div class="col-sm-4 tips"></div>
                        </div>
                        <div class="form-group">
                            <label>经纪人</label>
                            <div class="col-sm-16">

                                <select class="form-control" name="agentId" id="agentSelect">
                                    <s:iterator value="#session.plotAgents" var="plotAgent">
                                        <option value="${plotAgent.agentId}" id="${plotAgent.name}">${plotAgent.name}</option>
                                    </s:iterator>
                                </select>

                            </div>
                            <div class="col-sm-4 tips"></div>
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

    <div id="modifyPlot" class="modal fade" tabindex="-1" data-keyboard=”static”>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h3 class="text-center">修改小区信息</h3>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="modifyPlot.action" method="post" onsubmit="return checkUpdatePlot()">

                        <div class="form-group">
                            <label>小区ID</label>
                            <input class="form-control" type="text" placeholder="" id="plotId1" readonly>
                            <input id="plotId" name="plotId" hidden>
                        </div>
                        <div class="form-group">
                            <label>小区名称</label>
                            <input class="form-control" type="text" placeholder="" name="plotName" id="plotName" minlength="3" maxlength="10">
                        </div>
                        <div class="form-group">
                            <label>所属城市</label>
                            <div class="col-sm-16">

                                <select class="form-control" name="cityId" id="citySelect1">
                                    <s:iterator value="#session.plotCities" var="plotCity">
                                        <option value="${plotCity.id}" id="${plotCity.name}">${plotCity.name}</option>
                                    </s:iterator>
                                </select>

                            </div>
                            <div class="col-sm-4 tips"></div>
                        </div>
                        <div class="form-group">
                            <label>所属区域</label>
                            <div class="col-sm-16">

                                <select class="form-control" name="districtId" id="districtSelect1">
                                    <s:iterator value="#session.plotDistricts" var="plotDistrict">
                                        <option value="${plotDistrict[0]}" id="${plotDistrict[1]}">${plotDistrict[1]}</option>
                                    </s:iterator>
                                </select>

                            </div>
                            <div class="col-sm-4 tips"></div>
                        </div>
                        <div class="form-group">
                            <label>经纪人</label>
                            <div class="col-sm-16">

                                <select class="form-control" name="agentId" id="agentSelect1">
                                    <s:iterator value="#session.plotAgents" var="plotAgent">
                                        <option value="${plotAgent.agentId}" id="${plotAgent.name}">${plotAgent.name}</option>
                                    </s:iterator>
                                </select>

                            </div>
                            <div class="col-sm-4 tips"></div>
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
        function edit(obj){
            var id = $(obj).parent().parent().find('td')[0];
            var plotId = $(id).text();
            $('#plotId').val(plotId);
            $('#plotId1').val(plotId);

            var name = $(obj).parent().parent().find('td')[1];
            var plotName = $(name).text();
            $('#plotName').val(plotName);

            var city = $(obj).parent().parent().find('td')[2];
            var cityId = $(city).text();
            var selectItem = document.getElementById("citySelect1");
            for(i=0;i<selectItem.length;i++){
                if(selectItem[i].value === cityId)
                    selectItem[i].selected = true;
                else selectItem[i].selected = false;
            }

            var district = $(obj).parent().parent().find('td')[4];
            var districtId = $(district).text();
            var select2 = document.getElementById("districtSelect1");
            for(i=0;i<select2.length;i++){
                if(select2[i].value === districtId)
                    select2[i].selected = true;
            }

            var agent = $(obj).parent().parent().find('td')[6];
            var agentId = $(agent).text();
            var select3 = document.getElementById("agentSelect1");
            for(i=0;i<select3.length;i++){
                if(select3[i].value === agentId)
                    select3[i].selected = true;
            }

        }


        var add_plot_boolean = false;
        var plot_hint1 = "";

        $('#plotName1').blur(function () {
            if((/^[\u4E00-\u9FA5]{3,10}$/).test($('#plotName1').val())) {
                $('#plotName1').parent().addClass('has-success').removeClass('has-error');
                add_plot_boolean = true;
            }
            else {
                $('#plotName1').parent().addClass('has-error').removeClass('has-success');
                add_plot_boolean = false;
                plot_hint1 = "小区名称格式错误";
            }
        })

        function checkAddPlot() {
            if (add_plot_boolean !== true) {
                if (plot_hint1 == "") {
                    alert("请填写完整信息");
                }
                else {
                    alert(plot_hint1);
                }
                return false;
            }
            else return true;
        }

        var update_plot_boolean = true;
        var plot_hint2 = "";

        $('#plotName').blur(function () {
            if((/^[\u4E00-\u9FA5]{3,10}$/).test($('#plotName').val())) {
                $('#plotName').parent().addClass('has-success').removeClass('has-error');
                update_plot_boolean = true;
            }
            else {
                $('#plotName').parent().addClass('has-error').removeClass('has-success');
                update_plot_boolean = false;
                plot_hint2 = "小区名称格式错误";
            }
        })

        function checkUpdatePlot() {
            if (update_plot_boolean !== true) {
                if (plot_hint2 == "") {
                    alert("请填写完整信息");
                }
                else {
                    alert(plot_hint2);
                }
                return false;
            }
            else return true;
        }

    </script>
</body>
</html>
