<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/30
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>personal information</title>

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.css" rel="stylesheet">
    <link href="../css/font-awesome.min.css" rel="stylesheet">

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
    <script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>

    <style>
        .modal-content {
            position: relative;
        .box-shadow(0 3px 9px rgba(0,0,0,.5));
            background-clip: border-box;
            outline: 0;
        }
    </style>
</head>
<body>
    <div class="container" >
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
                                <a href="logout.action">&nbsp;&nbsp;退出</a>
                            </li>
                        </ul>
                    </div>

                </nav>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-2 column">
                <ul class="nav nav-pills nav-stacked" style="background:#eee;border-radius: 10px">
                    <li class="active"><a href="#">个人信息</a></li>
                    <li><a href="searchMyHouse.action?userId=${user.userId}">我的房源</a></li>
                    <li><a href="getMyOrders.action?userId=${user.userId}">我的订单</a></li>

                </ul>
            </div>

            <div class="col-md-offset-4 column">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title" style="font-size: 25px">我的账户信息</h3>
                    </div>
                    <div class="panel-body">
                        <h4>Welcome! <c:choose>
                            <c:when test="${sessionScope.user.username != null}">
                                ${user.username}
                            </c:when>
                            <c:otherwise>
                                ${user.telephone}
                            </c:otherwise>
                        </c:choose>
                        </h4>
                        <ul class="list-group" >
                            <li class="list-group-item">联系方式：&nbsp;&nbsp;${sessionScope.user.telephone}</li>
                            <li class="list-group-item">
                                用户名：&nbsp;&nbsp;<c:choose>
                                <c:when test="${user.username != null}">
                                    ${user.username}
                                </c:when>
                                <c:otherwise>
                                    还未设置
                                </c:otherwise>
                            </c:choose></li>
                            <li class="list-group-item">
                                真实姓名：&nbsp;&nbsp;<c:choose>
                                <c:when test="${user.name != null}">
                                    ${user.name}
                                </c:when>
                                <c:otherwise>
                                    还未填写
                                </c:otherwise>
                            </c:choose></li>
                            <li class="list-group-item">密码：&nbsp;&nbsp;${sessionScope.user.password}</li>
                        </ul>
                        <a class="btn btn-primary" style="float: right;" data-toggle="modal" data-target="#updateUser" href="" >修改信息</a>
                    </div>

                </div>
            </div>


        </div>

    </div>

    <div id="updateUser" class="modal fade" tabindex="-1" data-keyboard=”static”>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">修改账户信息</h1>
                </div>
                <div class="modal-body">
                    <form id="modifyUser" class="form-group" action="modifyUser.action" method="post" onsubmit="return checkUpdateUser()">

                        <div class="form-group">
                            <label>真实姓名</label>
                            <input class="form-control" id="name" type="text" placeholder="" name="user.name" value="${user.name}">
                        </div>
                        <div class="form-group">
                            <label>用户名</label>
                            <input class="form-control" id="username" type="text" placeholder="" name="user.username" value="${user.username}" minlength="1" maxlength="10">
                        </div>
                        <div class="form-group">
                            <label>手机号</label>
                            <input class="form-control" id="telephone" type="text" placeholder="输入正确格式" name="user.telephone" value="${user.telephone}" maxlength="11">
                        </div>
                        <div class="form-group">
                            <label>修改密码</label>
                            <input class="form-control" id="password" type="password" placeholder="6-15位字母、数字或_" name="user.password" value="${user.password}" maxlength="15" minlength="6">
                        </div>
                        <input name="user.userId" value="${user.userId}" hidden>
                        <div class="text-right">
                            <button class="btn btn-primary" type="submit" id="updateSubmit">提交</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div><!--data-dismiss="modal"-->
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        var telephone_boolean = true;
        var password_boolean = true;
        var name_boolean = true;
        var username_boolean = true;
        var hint = "";
            $('#name').blur(function () {
                if((/^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,4}$/).test($('#name').val())) {
                    name_boolean = true;
                    $('#name').parent().addClass("has-success").removeClass('has-error');

                }
                else {
                    name_boolean = false;
                    $('#name').parent().addClass("has-error").removeClass('has-success');
                    hint += "名字格式错误.\n";
                }
            })
            $('#username').blur(function () {
                if ((/^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]{1,10}$/).test($('#username').val())) {
                    username_boolean = true;
                    $('#username').parent().addClass('has-success').removeClass('has-error');
                }
                else {
                    username_boolean = false;
                    $('#username').parent().addClass("has-error").removeClass('has-success');
                    hint += "用户名由1-10位数字、字母或汉字组成.\n";
                }
            })
            $('#telephone').blur(function () {
                if ((/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/).test($('#telephone').val())) {
                    telephone_boolean = true;
                    $('#telephone').parent().addClass('has-success').removeClass('has-error');
                }
                else {
                    telephone_boolean = false;
                    $('#telephone').parent().addClass("has-error").removeClass('has-success');
                    hint += "手机号格式错误.\n";
                }
            })
            $('#password').blur(function () {
                if ((/^[a-z0-9_-]{6,15}$/).test($('#password').val())) {
                    password_boolean = true;
                    $('#password').parent().addClass('has-success').removeClass('has-error');
                }
                else {
                    password_boolean = false;
                    $('#password').parent().addClass("has-error").removeClass('has-success');
                    hint += "密码由6-15位数字、字母或_组成.\n";
                }
            })

            /*$('#modifyUser').bootstrapValidator({
                message: '输入值不合法',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    username: {
                        message: '用户名不合法',
                        validators: {
                            /*notEmpty: {
                                message: '用户名不能为空'
                            },
                            stringLength: {
                                min: 3,
                                max: 30,
                                message: '请输入3到30个字符'
                            },                            regexp: {
                                regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                                message: '用户名只能由字母、数字、点、下划线和汉字组成 '
                            }
                        }
                    },
                    name: {
                        validators: {
                            regexp: {
                                regexp: /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/,
                                message: '按正确格式输入'
                            }
                        }
                    },
                    /*email: {
                       validators: {
                           notEmpty: {
                               message: 'email不能为空'
                           },
                           emailAddress: {
                               message: '请输入正确的邮件地址如：123@qq.com'
                           }
                       }
                   },
                    telephone: {
                        validators: {
                            notEmpty: {
                                message: '手机号不能为空'
                            },
                            regexp: {
                                regexp: /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/,
                                message: '手机号码格式错误'
                            }
                        }
                    },
                    password: {
                        validators: {
                            regexp: {
                                regexp: /^[a-z0-9_-]{6,15}$/,
                                message: '密码由6-15位数字，字母或_组成'
                            }
                        }
                    }
                    /*address: {
                        validators: {
                            notEmpty: {
                                message: '地址不能为空'
                            }, stringLength: {
                                min: 8,
                                max: 60,
                                message: '请输入5到60个字符'
                            }
                        }
                    }
                }
            });
        }

        //$('#modifyUser').bootstrapValidator('validate');
        function checkUpdateUser() {
            var bv = $('#modifyUser').data('bootstrapValidator');
            bv.validate();

            if (bv.isValid()) {
                console.log(form.serialize());
                $('#modifyUser').submit();
                return true;

            }
            else {
                return false;
            }*/


        function checkUpdateUser() {
            if ((telephone_boolean && password_boolean && name_boolean && username_boolean) !== true) {
                alert(hint);
                return false;

            }
            else {
                return true;
            }
        }
    </script>



</body>
</html>
