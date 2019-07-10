<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/6
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>add plot</title>
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
<form class="form-group" action="addDistrict.action" method="post" role="form">

    <div class="form-group">
        <label>小区名称</label>
        <input class="form-control" type="text" placeholder="" name="districtName" id="districtName1">
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
                    <option value="${plotDistrict.districtId}" id="${plotDistrict.districtName}">${plotDistrict.districtName}</option>
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
    $('#citySelect').change(function () {
        var myselect = document.getElementById("citySelect")
        var index = myselect.selectedIndex;
        var cityId1 = myselect.options[index].value;

        $.ajax({
            url :"/getDistrictByCity.action",  //后台处理程序
            type:"post",    //数据发送方式
            async:false,
            dataType:"json",   //接受数据格式
            data: {
                cityId: cityId1
            },

            error: function(){
                alert(cityId1);
            },


            success: function(json){
                alert(json)
                /*var listArray = eval(json).titlelist;


                for(var i=0;i<listArray.length;i++)
                {
                    $(".index_leftlist ul").append("<li>"+listArray[i]+"</li>");

                }*/

            }
        });
    })
</script>
</body>
</html>
