<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/7/1
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user administration</title>

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
        }

        table td {
            height: 56px;
            font-size: 16px;
            color: rgb(86, 132, 190);
        }
    </style>
</head>
<body>
    <!--<script>
        $(function () {

            $('#usertab').bootstrapTable('destroy');

            $('#usertab').bootstrapTable({
                url:"user.json",
                dataType:"json",
                method: 'get',
                cache: false,// 默认true 设置为 false 禁用 AJAX 数据缓存
                //height: 400,
                striped: true,//是否显示行间隔色
                pagination: true,//是否显示分页
                pageSize: 20,
                pageNumber:1,// 默认显示第几页
                pageList: [10, 20, 50, 100, 200, 500],
                sidePagination:'client',
                /*queryParams : function (params) {
                    var temp = {
                        limit : params.limit, // 每页显示数量
                        offset : params.offset, // SQL语句起始索引
                        page: (params.offset / params.limit) + 1,   //当前页码

                        Name:$('#search_name').val(),
                        Tel:$('#search_tel').val()
                    };
                    return temp;
                },*/
                //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
                //设置为limit可以获取limit, offset, search, sort, order
                //queryParamsType : "undefined",
                search: true,
                showColumns: true,//显示隐藏列列选择按钮
                showRefresh: true,//切换显示样式
                showFooter: false, //显示Table脚部
                showExport: false,
                exportTypes: ['csv','txt','xml'],
                search: true,
                clickToSelect: true,
                height: $("body").height - 38,
                columns:
                    [
                        //{field:"checked",checkbox:true},

                        {field:"user_id",title:"用户ID",align:"center",valign:"middle",sortable:"true"},
                        {field:"username",title:"用户名",align:"center",valign:"middle",},
                        {field:"password",title:"密码",align:"center",valign:"middle",},
                        {field:"telephone",title:"联系方式",align:"center",valign:"middle",},
                        {field:"operate",title:"操作",align:"center",valign:"middle", formatter: option},

                    ],


                onLoadSuccess: function () {
                    //加载成功时执行
                    console.log("加载成功!");
                }, onLoadError: function () {
                    //加载失败时执行
                    console.log("加载失败!");

                }, formatLoadingMessage: function () {
                    //正在加载
                    return "请稍等，正在加载中...";
                }, formatNoMatches: function () {
                    //没有匹配的结果
                    return '无符合条件的记录';
                }
                //data:datas,//从数据库取则删掉data，用url
            });
        });

        function option(value, row, index){

            var path1 = "del_user.jsp?user_id=" + row.user_id;
            var path2 = "modify_user.jsp?user_id=" + row.user_id;
            //var htm = '<a href=' + path + ' title="删除用户">'+  '<span class="glyphicon glyphicon-trash"></span></a>'
            var htm = '<ul style="list-style-type:none">\n\
                                <li style="float:left"><a href="' + path1 + '">删除</a></li>\n\
                                <li style="float:left"><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></li>\n\
                                <li style="float:left"><a href="' + path2 + '">修改</a></li>\n\
                                </ul>';
            return htm;
        }


    </script>-->


    <div class="middle ">
        <table>
            <tr>
                <th>用户ID</th>
                <th>手机号</th>
                <th>密码</th>
                <th>删除</th>
            </tr>

            <s:iterator value="#session.users" var="user">
                <tr style="border-bottom: 1px solid rgb(224,232,242);">
                    <td>${user.userId}</td>
                    <td>${user.telephone}</td>
                    <td>${user.password}</td>
                    <td>
                        <form action="DeleteOrder.action" method="post">
                            <input type="hidden" value=${user.userId} name="UserID">
                            <input type="submit" value="删除" style="color: #fff;width: 70px;height: 30px;background: rgb(86,132,190);border-radius: 3px;border:none;">
                        </form>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </div>
    <!--<table id="usertable" class="table table-hover"></table>-->
</body>
</html>
