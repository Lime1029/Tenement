<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sky
  Date: 2019/7/4
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>经纪人端</title>
    <!--经纪人端的登陆成功欢迎页面，没有什么功能所以也没有什么功能性代码，提供跳转-->
    <!--bootstrap及bootstrap-table的引用-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.2/dist/bootstrap-table.min.css">
    <!--CSS样式设置-->
    <style>
        .top{
            background-color: #4169E1;
            height: 50px;
        }
    </style>
</head>
<body>
<!--假装有的装饰性TOP部分-->
<div class="top">
    <div class="row">
        <div class="col-md-2">
            <!--h1 style="color: white">Hello,Agent!</h1-->
        </div>
    </div>
</div>

<!--Middle-->
<div>
    <div class="row" style="height: 100%">

        <!--页面左部导航栏，暂时只有一个订单管理功能-->
        <div class="col-md-3">
            <nav class="navbar" style="background-color: aliceblue">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="agent_information.jsp" style="color: black">个人中心</a>
                        <a class="nav-link" href="#" style="color: black">我的消息</a>
                        <a class="nav-link" href="agent_upload_order.jsp" style="color: black">添加订单</a>
                        <a class="nav-link" href="agent_manage_order.jsp" style="color: black">我管理的订单</a>
                        <a class="nav-link" href="agent_houseinfo.jsp" style="color: black">我管理的房源</a>
                    </li>
                </ul>
            </nav>
        </div>
        <!--导航栏End-->

        <!--页面主体：欢迎页pic-->
        <div class="col-md-9">
            <!--可替换部分-->
            <s:iterator value="pageBean.list">
            <s:property value="title"/>
          <!--  <a href="getMyHouse.action?id=<s:property value="id"/>">modify</a>
            <a href="deleteArticle.action?id=<s:property value="id"/>" onclick="return askDel()"/>delete</a><br/>
          !-->
                待定加入
            </s:iterator>
            共<s:property value="pageBean.allRow"/> 条记录
            共<s:property value="pageBean.totalPage"/> 页
            当前第<s:property value="pageBean.currentPage"/>页<br/>
            <div class="table-responsive">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th style="text-align: center;">房源ID</th>
                        <th style="text-align: center;">所在小区</th>
                        <th style="text-align: center;">所在地区</th>
                        <th style="text-align: center;">房东姓名</th>
                        <th style="text-align: center;">详细地址</th>
                        <th style="text-align: center;">租金</th>
                        <th style="text-align: center;">类别</th>
                        <th style="text-align: center;">楼层</th>
                        <th style="text-align: center;">面积</th>
                        <th style="text-align: center;">额外描述</th>
                        <th style="text-align: center;">经纪人ID</th>
                        <th style="text-align: center;">提交修改</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.aaaa}" var="houses">
                        <tr class="text-center">
                            <script>
                                $(function() {
                                    $(":text").focus(function() {
                                        $(this).css('border-color', '#0f0');
                                    }).blur(function() {
                                        $(this).css('border-color', '');
                                    })
                                });
                            </script>
                            <s:form role="form" id="updateHouseInfo" action="updateHouse">
                                <!--
                            <td> <div name = "plotname" value=${houses[0]}  style="width:130px;" /></td>
                            <td><input name = "districtname" value=${houses[1]} style="width:130px;"/></td>
                            <td><input name = "landlordName" value=${houses[2]}  style="width:130px;"/></td>
                            <td><input name = "address" value=${houses[3]}  style="width:130px;"/></td>
                            <td><input name = "rent" value=${houses[4]}  style="width:80px;"/></td>
                            <td><input name = "housetype" value=${houses[5]}  style="width:80px;"/></td>
                            <td><input name = "floor" value=${houses[6]} style="width:80px;"/></td>
                            <td><input name = "area" value=${houses[7]}  style="width:80px;"/></td>
                            <td><input name = "housedescription" value=${houses[8]}  style="width:130px;"/></td>
                            <td><input name = "agentId" value=${houses[9]}  style="width:130px;"/></td>
                            <td><input name = "houseID" value=${houses[10]}  style="width:130px;"/></td>
                            !-->
                                <td  style="width:130px;" >${houses[10]}</td>
                                <td  style="width:130px;" >${houses[0]}</td>
                                <td style="width:130px;">${houses[1]}</td>
                                <td style="width:130px;">${houses[2]}</td>
                                <td style="width:130px;">${houses[3]}</td>
                                <td style="width:80px;">${houses[4]}</td>
                                <td style="width:80px;">${houses[5]}</td>
                                <td style="width:80px;">${houses[6]}</td>
                                <td style="width:130px;">${houses[7]}</td>
                                <td style="width:130px;">${houses[8]}</td>
                                <td style="width:130px;">${houses[9]}</td>
                                <td>
                                    <input type="button" value="修改" data-target="#modifyHouse" onclick="edit(this)" data-toggle="modal"
                                       style="color: #fff;width: 70px;height: 30px;
                                       background: rgb(86,132,190);border-radius: 3px;border:none;">

                            </td>
                            </s:form>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <s:if test="%{pageBean.currentPage == 1}">
                第一页 上一页
            </s:if>
            <s:else>
                <a href="getMyHouse.action?page=1">第一页</a>
                <a href="getMyHouse.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
            </s:else>
            <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
                <a href="getMyHouse.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
                <a href="getMyHouse.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
            </s:if>
            <s:else>
                下一页 最后一页
            </s:else>


        </div>
    </div>

</div>
<!--页面内容End-->
<!--bootstrap及bootstrap-table引用-->
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-table@1.15.2/dist/bootstrap-table.min.js"></script>



<div id="modifyHouse" class="modal hide fade in" style="display: none; >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-title">
                <h1 class="text-center">修改房源信息</h1>
            </div>
            <div class="modal-body">
                <form class="form-group" action="updateHouse.action" method="post">
                    <div class="form-group">
                        <label>房源ID</label>
                        <input class="form-control" type="text" placeholder="" name="houseId" id="houseId" readonly>
                        <input hidden name="houseId" id="houseId1">
                    </div>
                    <div class="form-group">
                        <label>小区名字</label>
                        <input class="form-control" type="text" placeholder="" name="plotName" id="plotName">
                    </div>
                    <div class="form-group">
                        <label>房东姓名</label>
                        <input class="form-control" type="text" placeholder="" name="landlordName" id="landlordName">
                    </div>
                    <div class="form-group">
                        <label>详细地址</label>
                        <input class="form-control" type="text" placeholder="" name="address" id="address">
                    </div>
                    <div class="form-group">
                        <label>租金</label>
                        <input class="form-control" type="text" placeholder="" name="rent" id="rent">
                    </div>
                    <div class="form-group">
                        <label>类别</label>
                        <input class="form-control" type="text" placeholder="" name="housetype" id="districtName">
                    </div>
                    <div class="form-group">
                        <label>楼层</label>
                        <input class="form-control" type="text" placeholder="" name="districtName" id="districtName">
                    </div>
                    <div class="form-group">
                        <label>面积</label>
                        <input class="form-control" type="text" placeholder="" name="districtName" id="districtName">
                    </div>
                    <div class="form-group">
                        <label>额外描述</label>
                        <input class="form-control" type="text" placeholder="" name="districtName" id="districtName">
                    </div>
                    <div class="col-sm-4 tips"></div>


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
        var houseId = $(id).text();
        $('#houseId').val(houseId);
        $('#houseId1').val(houseId);

        var name = $(obj).parent().parent().find('td')[1];
        var districtName = $(name).text();
        $('#districtName').val(districtName);

        var city = $(obj).parent().parent().find('td')[2];
        var cityId = $(city).text();




    }

</script>
</body>
</html>