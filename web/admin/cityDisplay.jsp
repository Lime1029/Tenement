<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/5
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>city administration</title>

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

            <form role="form" id="search" action="searchCity.action">
                <input type="search" maxlength="15" placeholder="输入城市名搜索" class="form-control" name="condition">
            </form>
            <span><button class="btn btn-primary" data-toggle="modal" data-target="#addCity" href="" style="">新增城市</button></span>
            <div class="middle ">
                <table>
                    <tr>
                        <th>城市ID</th>
                        <th>城市名</th>
                        <th>修改</th>
                        <th>删除</th>
                    </tr>
                    <c:choose>
                    <c:when test="${sessionScope.cities.size() == 0}">
                        共找到0条记录
                    </c:when>
                    <c:otherwise>

                            <s:iterator value="#session.cities" var="city">
                                <tr style="border-bottom: 1px solid rgb(224,232,242);">
                                    <td>${city.id}</td>
                                    <td>${city.name}</td>
                                    <td>
                                        <input type="button" value="修改" data-target="#modifyCity" data-toggle="modal" onclick="edit(this)" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                                    </td>
                                    <td>
                                        <form action="deleteCity.action" method="post">
                                            <input type="hidden" value=${city.id} name="cityId">
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

    <div id="modifyCity" class="modal fade" tabindex="-1" data-keyboard=”static”>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">修改城市信息</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="modifyCity.action" method="post" onsubmit="return checkUpdateCity()">

                        <div class="form-group">
                            <label>城市ID</label>
                            <input class="form-control" type="text" placeholder="" name="cityId1" id="cityId1" disabled>
                            <input name="cityId" id="cityId" hidden>
                        </div>
                        <div class="form-group">
                            <label>城市名称</label>
                            <input class="form-control" type="text" placeholder="" name="cityName" id="cityName" minlength="2" maxlength="10">
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

    <div id="addCity" class="modal fade" tabindex="-1" data-keyboard=”static”>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">新增城市</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="addCity.action" method="post" id="insertCity" onsubmit="return checkAddCity()">
                        <div class="form-group">
                            <label>城市名称</label>
                            <input class="form-control" type="text" placeholder="" name="cityName" id="cityName1" minlength="2" maxlength="10">
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
            var cityId = $(id).text();
            $('#cityId').val(cityId);
            $('#cityId1').val(cityId);

            var name = $(obj).parent().parent().find('td')[1];
            var cityName = $(name).text();
            $('#cityName').val(cityName);
        }


        var add_city_boolean = false;
        var hint1 = "";

        $('#cityName1').blur(function () {
            if ((/^[\u4E00-\u9FA5]{2,10}$/).test($('#cityName1').val())) {
                $('#cityName1').parent().addClass('has-success').removeClass('has-error');
                add_city_boolean = true;
            }
            else {
                $('#cityName1').parent().addClass('has-error').removeClass('has-success');
                add_city_boolean = false;
                hint1 = "城市名称格式错误\n";
            }
        })

        function checkAddCity() {
            if (add_city_boolean !== true) {
                if (hint1 == "") {
                    alert("请填写完整信息");
                }
                else {
                    alert(hint1);
                }
                return false;
            }
            else return true;
        }


        var update_city_boolean = true;
        var hint2 = "";

        $('#cityName').blur(function () {
            if ((/^[\u4E00-\u9FA5]{2,10}$/).test($('#cityName').val())) {
                $('#cityName').parent().addClass('has-success').removeClass('has-error');
                update_city_boolean = true;
            }
            else {
                $('#cityName').parent().addClass('has-error').removeClass('has-success');
                update_city_boolean = false;
                hint2 = "城市名称格式错误";
            }
        })

        function checkUpdateCity() {
            if (update_city_boolean !== true) {
                if (add_city_boolean !== true) {
                    if (hint2 == "") {
                        alert("请填写完整信息");
                    }
                    else {
                        alert(hint2);
                    }
                    return false;
                }
                else return true;
            }
        }

    </script>
</body>
</html>
