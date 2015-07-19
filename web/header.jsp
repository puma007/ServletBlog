<%--
  Created by IntelliJ IDEA.
  User: tanhaiyuan
  Date: 2015/7/8
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--博客导航-->
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">导航栏</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a herf="#">首页</a></li>
                <li><a href=<%=request.getContextPath() + "/articlelist"%>>文章列表</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a herf="baidu.com">订阅</a></li>
                <li><a href=<%=request.getContextPath() + "/manage"%>>管理</a></li>
                <li><a href=<%=request.getContextPath() + "/edit"%>>添加</a></li>
            </ul>
        </div>
    </div>
</nav>