<%--
  Created by IntelliJ IDEA.
  User: Lime
  Date: 2019/6/24
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>爱家</title>
  <link rel="stylesheet" href="css/reset.css" /><!--不仅用于清除默认样式，更是一种全局样式定义-->
  <link rel="stylesheet" href="css/swiper.min.css" /><!--移动设备触控滑块的js框架，主要用于移动端网站-->
  <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
  <link rel="stylesheet" href="css/head.css" />

</head>
<body>
<!-- 导航 -->
<header class="header">
  <div class="container clearfix">
    <div class="fl left">
      <a href="javascript:void(0)" ><img src="images/logo5.jpg" alt="" class="img1" /></a>
      </div>
    <div class="fl nav">
      <ul class="navbar_nav" data-in="fadeInDown" data-out="fadeOutUp">
        <li class="active">
          <a href="javascript:void(0)">首页</a>
        </li>
        <li class="dropdown">
          <a href="javascript:void(0)">
            租房
          </a>
          <div class="dropdown_menu">
            <a href="#">Custom Menu</a>
            <a href="#">Custom Menu</a>
            <a href="#">Custom Menu</a>
          </div>
        </li>
        <li class="dropdown">
          <a href="javascript:void(0)">发布房源</a>
          <div class="dropdown_menu">
            <a href="#">Custom Menu</a>
            <a href="#">Custom Menu</a>
            <a href="#">Custom Menu</a>
          </div>
        </li>
        <li>
          <a href="javascript:void(0)">行知资讯</a>
        </li>
        <li>
          <a href="javascript:void(0)">关于我们</a>
        </li>
        <li>
          <a href="javascript:void(0)">联系合作</a>
        </li>

      </ul>
    </div>
    <div class="fr nav">
      <ul class="navbar_nav" data-in="fadeInDown" data-out="fadeOutUp">
        <li>
          <a href="registerLogin/register.jsp"><span class="glyphicon glyphicon-user"></span> 注册</a>
        </li>
        <li>
          <a href="registerLogin/login.jsp"><span class="glyphicon glyphicon-log-in"></span> 登录</a>
        </li>
      </ul>
    </div>
    <a href="javascript:void(0)" id="navToggle">
      <span></span>
    </a>
  </div>
</header>
<!--移动端的导航-->
<div class="m_nav">
  <div class="top clearfix">
    <img src="images/closed.png" alt="" class="closed" />
  </div>
  <div class="logo">
    <img src="images/logo.jpg" alt="" />
  </div>
  <ul class="ul" data-in="fadeInDown" data-out="fadeOutUp">
    <li class="active">
      <a href="javascript:void(0)">首页</a>
    </li>
    <li class="dropdown">
      <a href="javascript:void(0)">
        租房
      </a>
      <div class="dropdown_menu">
        <a href="#">Custom Menu</a>
        <a href="#">Custom Menu</a>
        <a href="#">Custom Menu</a>
      </div>
    </li>
    <li class="dropdown">
      <a href="javascript:void(0)">发布房源</a>
      <div class="dropdown_menu">
        <a href="#">Custom Menu</a>
        <a href="#">Custom Menu</a>
        <a href="#">Custom Menu</a>
      </div>
    </li>
    <li>
      <a href="javascript:void(0)">行知资讯</a>
    </li>
    <li>
      <a href="javascript:void(0)">关于我们</a>
    </li>
    <li>
      <a href="javascript:void(0)">联系合作</a>
    </li>
    <li>
      <a href=""><span class="glyphicon glyphicon-user"></span> 注册</a>
    </li>
    <li>
      <a href=""><span class="glyphicon glyphicon-log-in"></span> 登录</a>
    </li>
  </ul>
</div>


<div class="banner">
  <img src="images/家背景4.jpg">
</div>
<!--
<div class="box" style="height: 1000px;">
  <h3 style="text-align: center; color: aliceblue">调整浏览器宽度大小查看效果</h3>
</div>
-->

<script>
  $(function(){
    //超过一定高度导航添加类名
    var nav=$("header"); //得到导航对象
    var win=$(window); //得到窗口对象
    var sc=$(document);//得到document文档对象。
    win.scroll(function(){
      if(sc.scrollTop()>=100){
        nav.addClass("on");
      }else{
        nav.removeClass("on");
      }
    })

    //移动端展开nav
    $('#navToggle').on('click',function(){
      $('.m_nav').addClass('open');
    })
    //关闭nav
    $('.m_nav .top .closed').on('click',function(){
      $('.m_nav').removeClass('open');
    })

    //二级导航  移动端
    $(".m_nav .ul li").click(function() {
      $(this).children("div.dropdown_menu").slideToggle('slow')
      $(this).siblings('li').children('.dropdown_menu').slideUp('slow');
    });

  })
</script>
</body>
</html>