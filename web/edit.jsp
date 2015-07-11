<%--
  Created by IntelliJ IDEA.
  User: tanhaiyuan
  Date: 2015/7/3
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑</title>
    <title>index</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/blogapp.css">
    <link rel="stylesheet" href="fonts/font">
</head>
<body>
<!--编辑区-->
<section class="content-wrap">
    <div class="container">
        <div class="row">
            <!-- 编辑框 左侧-->
            <div class="col-md-8" style="display:block">
                <form action="edit" class="form-horizontal" method="post">
                    <!--文章标题-->

                    <div class="form-group" style="margin-top:30px">
                        <label class="control-label" style="float:left">标题</label>

                        <div class="col-md-11">
                            <input type="text" class="form-control" id="title" placeholder="输入文章标题...">
                        </div>
                    </div>
                    <!--文章分类-->
                    <div class="form-group">
                        <label class="control-label" style="float:left">分类</label>

                        <div class="col-md-5">
                            <select class="form-control">
                                <c:forEach var="category" items="${categoryList}">
                                    <option>${category.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <!--文章内容-->
                    <div class="form-group">
                    	<textarea rows="20" style="width:730px" class="form-control">
                    	</textarea>
                    </div>
                    <!--发布按钮-->
                    <div class="form-group" style="width:730px">
                        <button type="button" class="btn btn-primary btn-lg btn-block">发布</button>
                    </div>
                </form>
            </div>

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

<!--管理分类的模态框-->
<div class="modal fade" id="manageCategoryModal" tabindex="-1" role="dialog" aria-labelledby="manageCategoryModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title text-center" id="manageCategoryModalLabel">分类管理</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <div class="col-md-10">
                        <input type="text" class="form-control" placeholder="输入分类...">
                    </div>
                    <button type="button" class="btn btn-primary">添加</button>
                </div>

                <div class="form-group" style=" margin-left:12px;">
                    <table class="table table-hover table-condensed">
                        <thead>
                        <tr>
                            <th>类别名</th>
                            <th>文章数</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="category" items="${categoryList}">
                            <tr style="border-bottom:1px solid #ddd;">
                                <td>${category.name}</td>
                                <td>${category.articleCount}</td>
                                <td style="float: right;width:12%"><span class="glyphicon glyphicon-trash"
                                                                         style="color:orange"></span>&nbsp;&nbsp;&nbsp;
                                    <span class="glyphicon glyphicon-edit" style="color:red"></span></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="form-group" style="margin-top:30px"></div>
                <div class="form-group" style="margin-top:30px"></div>
                <div class="form-group" style="margin-top:30px"></div>
                <div class="form-group" style="margin-top:30px"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!--管理标签的模态框-->
<div class="modal fade" id="manageTagModal" tabindex="-1" role="dialog" aria-labelledby="manageTagModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title text-center" id="manageTagModalLabel">标签管理</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <div class="col-md-10">
                        <input type="text" class="form-control" placeholder="输入分类...">
                    </div>
                    <button type="button" class="btn btn-primary">添加</button>
                </div>

                <div class="form-group" style=" margin-left:12px;">
                    <table class="table table-hover table-condensed">
                        <thead>
                        <tr>
                            <th>标签名</th>
                            <th>文章数</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="tag" items="${tagList}">
                            <tr style="border-bottom:1px solid #ddd;">
                                <td>${tag.name}</td>
                                <td>${tag.articleCount}</td>
                                <td style="float: right;width:12%"><span class="glyphicon glyphicon-trash"
                                                                         style="color:orange"></span>&nbsp;&nbsp;&nbsp;
                                    <span class="glyphicon glyphicon-edit" style="color:red"></span></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="form-group" style="margin-top:30px"></div>
                <div class="form-group" style="margin-top:30px"></div>
                <div class="form-group" style="margin-top:30px"></div>
                <div class="form-group" style="margin-top:30px"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
