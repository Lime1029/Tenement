<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/6
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>district administration</title>

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


                    </div>
                </nav>

            </div>
        </div>

        <div class="row clearfix">

            <form role="form" id="search" action="searchDistrict.action">
                <input type="search" maxlength="15" placeholder="输入区域或城市搜索" class="form-control" name="condition">
            </form>
            <span><button class="btn btn-primary" data-toggle="modal" data-target="#addDistrict" href="" style="">新增区域</button></span>

            <div class="middle ">
                <c:choose>
                    <c:when test="${sessionScope.districts.size() == 0}">
                        共找到0条记录
                    </c:when>
                    <c:otherwise>
                        <table>
                            <tr>
                                <th>区域ID</th>
                                <th>区域名</th>
                                <th>所属城市ID</th>
                                <th>所属城市名称</th>
                                <th>修改</th>
                                <th>删除</th>
                            </tr>

                            <s:iterator value="#session.districts" var="district">
                                <tr style="border-bottom: 1px solid rgb(224,232,242);">
                                    <td>${district[0]}</td>
                                    <td>${district[1]}</td>
                                    <td>${district[2]}</td>
                                    <td>${district[3]}</td>
                                    <td>
                                        <input type="button" value="修改" data-target="#modifyDistrict" data-toggle="modal" onclick="edit(this)" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                                    </td>
                                    <td>
                                        <form action="deleteDistrict.action" method="post">
                                            <input type="hidden" value=${district[0]} name="districtId">
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

    <div id="modifyDistrict" class="modal fade" tabindex="-1" data-keyboard=”static”>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">修改区域信息</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="modifyDistrict.action" method="post">

                        <div class="form-group">
                            <label>区域ID</label>
                            <input class="form-control" type="text" placeholder="" name="districtId1" id="districtId1" readonly>
                            <input hidden name="districtId" id="districtId">
                        </div>
                        <div class="form-group">
                            <label>区域名称</label>
                            <input class="form-control" type="text" placeholder="" name="districtName" id="districtName">
                        </div>
                        <div class="form-group">
                            <label>所属城市</label>
                            <div class="col-sm-16">
                                <!-- 样式1 -->
                                <select class="form-control" name="cityId" id="citySelect">
                                    <s:iterator value="#session.disCities" var="disCity">
                                        <option value="${disCity.id}" >${disCity.name}</option>
                                    </s:iterator>
                                </select>
                                <!-- 样式2 -->
                                <!--<div class="btn-group dropdown" id="dropdown">
                                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    超级管理员 <span class="caret"></span>
                                  </button>
                                  <input type="hidden" name="hidedrop_1" id="hidedrop_1" value="超级管理员" />
                                  <ul class="dropdown-menu">
                                    <li><a href="#">超级管理员</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">设计总监</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">运维人员</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">发布人员</a></li>
                                  </ul>
                                </div>-->

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

    <div id="addDistrict" class="modal fade" tabindex="-1" data-keyboard=”static”>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">新增区域</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" action="addDistrict.action" method="post">

                        <div class="form-group">
                            <label>区域名称</label>
                            <input class="form-control" type="text" placeholder="" name="districtName" id="districtName1">
                        </div>
                        <div class="form-group">
                            <label>所属城市</label>
                            <div class="col-sm-16">

                                <select class="form-control" name="cityId">
                                    <s:iterator value="#session.disCities" var="disCity">
                                        <option value="${disCity.id}" id="cityId">${disCity.name}</option>
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
            var districtId = $(id).text();
            $('#districtId').val(districtId);
            $('#districtId1').val(districtId);

            var name = $(obj).parent().parent().find('td')[1];
            var districtName = $(name).text();
            $('#districtName').val(districtName);

            var city = $(obj).parent().parent().find('td')[2];
            var cityId = $(city).text();


            var selectItem = document.getElementById("citySelect");
            for(i=0;i<selectItem.length;i++){
                if(selectItem[i].value === cityId)
                    selectItem[i].selected = true;
                else selectItem[i].selected = false;
            }

        }
    </script>
</body>
</html>
