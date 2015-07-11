<%--
  Created by IntelliJ IDEA.
  User: tanhaiyuan
  Date: 2015/7/2
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/blogapp.css">
    <link rel="stylesheet" href="fonts/font">
</head>
<body>
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
                <li class="active"><a herf="#">首页</a></li>
                <li><a herf="${pageContext.request.contextPath}/toarticlelist">文章列表</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a herf="#">订阅</a></li>
                <li><a href=<%=request.getContextPath() + "/toarticlelist"%>>管理</a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="content-wrap">
    <div class="container">
        <div class="row">
            <!-- 博客内容展示 左侧-->
            <c:forEach var="article" items="${articleList}">
                <div class="col-md-8 panel panel-default" style="height: 195px;padding:0;margin-top:30px;">
                    <!-- //上面文章标题-->
                    <div class="col-md-12 panel-heading"><a href=""><span
                            class="glyphicon glyphicon-star">&nbsp;</span>${article.title}</a></div>
                    <!--  //下面-->
                    <div class="col-md-12 panel-body">
                        <!-- //下面左边：缩略图-->
                        <div class="col-md-2" style="margin:0;padding:0;height:150px;">
                            <img src="img/article01.jpg" style="height: 120px;"/>
                        </div>
                        <!-- //下面右边-->
                        <div class="col-md-10" style="padding:0;">
                            <!-- //下面右边上面：文章简短说明-->
                            <div class="col-md-12"><p>公司第一年我们也没有什么战略，全是
                                抢市场老大的意识，在员经过思考换算对市场预测的分析后， 在第二年我们小组的成员经过思考换算对市场预测的分析后，
                                在第二年我们小组的成员经过思考换算对市场预测的分析后， 此，</p></div>
                            <!--//下面右边下面： 时间等信息-->
                            <div class="col-md-12" style="margin:0;padding:0;">
                                <div class="col-md-2"><span class="glyphicon glyphicon-folder-open"
                                                            style="font-size: 3px;"></span>&nbsp;<span>${article.category.name}</span>
                                </div>
                                <div class="col-md-3"><span class="glyphicon glyphicon-calendar"
                                                            style="font-size: 3px;"></span>&nbsp;<span>${article.createdate}</span>
                                </div>
                                <div class="col-md-2"><span class="glyphicon glyphicon-eye-open"
                                                            style="font-size: 3px;"></span>&nbsp;<span>${article.viewcount}</span>
                                </div>
                                <div class="col-md-2"><span class="glyphicon glyphicon-comment"
                                                            style="font-size: 3px;"></span>&nbsp;<span>x条评论</span>
                                </div>
                                <div class="col-md-3"><span class="glyphicon glyphicon-tags"
                                                            style="font-size: 3px;"></span>&nbsp;<span>xx,xx,xx</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

             <!--右侧-->
            <!--分类-->
            <div class="col-md-4 sidebar">
                <div style="margin-top:30px;padding-top:0" class="display widget  well">
                    <header>
                        <h3 style="display:inline-block">分类</h3>
                        <!--<span style="font:18px;float:right;margin-top:20px;"><a
                                href="${pageContext.request.contextPath}/tomanagetags">管理</a></span>-->
                        <a data-toggle="modal" data-target="#manageCategoryModal"
                           style="font:18px;float:right;margin-top:13px;text-decoration: none">管理</a>
                    </header>
                    <ul class="list-group">
                        <c:forEach var="category" items="${categoryList}">
                            <li class="list-group-item">
                                <span class="badge">${category.articleCount}</span>
                                <a href="#">${category.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

                <!--标签 -->
                <div style="padding-top:0" class="display widget well">
                    <header>
                        <h3 style="display:inline-block">标签</h3>
                        <a data-toggle="modal" data-target="#manageTagModal"
                           style="font:18px;float:right;margin-top:13px;text-decoration: none">管理</a>
                    </header>
                    <ul class="list-group">
                        <c:forEach var="tag" items="${tagList}">
                            <li class="list-group-item">
                                <span class="badge">${tag.articleCount}</span>
                                <a href="#">${tag.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

                <!--文章存档 -->
                <div style="padding-top:0" class="display widget well">
                    <header>
                        <h3>文章存档</h3>
                    </header>
                    <ul class="list-group">
                        <c:forEach var="category" items="${categoryList}">
                            <li class="list-group-item">
                                <span class="badge">${category.articleCount}</span>
                                <a href="#">${category.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
