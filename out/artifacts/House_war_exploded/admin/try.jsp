<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/11
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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

<script>
    var obj = document.getElementById("citySelect1"); //定位id

    var index = obj.selectedIndex; // 选中索引

    var cityId = obj.options[index].value; // 选中值
    $.post("getDistrictByCity.action?cityId=" + cityId, function (message, status) {
        return false;
    });

    $('#citySelect1').change(function () {
        var obj = document.getElementById("citySelect1"); //定位id

        var index = obj.selectedIndex; // 选中索引

        var cityId = obj.options[index].value; // 选中值
        $.post("getDistrictByCity.action?cityId=" + cityId, function (message, status) {
            return false;
        });
    });
</script>
</body>
</html>
