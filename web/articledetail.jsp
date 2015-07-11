<%--
  Created by IntelliJ IDEA.
  User: tanhaiyuan
  Date: 2015/7/7
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文章详情</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/article.css"/>
</head>
<body style="background-color: lightgrey">
<div class="container" style="margin-top:30px;">
    <!--左边文章内容-->
    <div class="col-lg-8 panel panel-default" style="padding: 0; ">
        <!--左边文章头部-->
        <div class="col-lg-12 panel-heading" >

            <h3 style="display: inline-block;">${article.title}</h3><br/>

            <div style="color:gray"><span class="glyphicon glyphicon-folder-open" style="font-size: 10px;"></span>&nbsp;
            <span style="font-size: 10px; ">${article.category.name}</span>&nbsp;<span style="font-size: 10px;" class="glyphicon glyphicon-tags"></span>&nbsp;
            <span style="font-size: 10px; ">这是标签名</span></div>
        </div>
        <!--左边文章主体-->
        <div class="col-lg-12 panel-body">
            <p>${article.content}</p>
        </div>
    </div>
    <!--右边目录-->
    <div class="col-lg-3  panel panel-default" style="padding: 0;margin-left:30px;">
        <div class="col-lg-12 panel-heading" style="padding-left: 33px;padding-top:0;padding-bottom:0;">
            <a href="#"><span class="glyphicon glyphicon-list" style="font-size: 22px;"></span>
                <h3 style="display: inline-block;" > 目录</a></h3>
        </div>
        <div class="col-lg-12 panel-body" style="padding-left: 12px;">
            <ul style=" font-size: 18px;">
                <a>
                    <li>xsss</li>
                </a>
                <a>
                    <li>ddddd</li>
                </a>
                <a>
                    <li>sddsfsf</li>
                </a>
                <a>
                    <li>sdfsdfsf</li>
                </a>
                <a>
                    <li>sdfsdfsfd</li>
                </a>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
