<%--
  Created by IntelliJ IDEA.
  User: tanhaiyuan
  Date: 2015/7/7
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/article.css"/>
</head>
<body>
<div class="form-group" style=" margin-left:12px;">
    <table class="table table-hover table-condensed">
        <thead>
        <tr>
            <th>文章名</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="article" items="${articleList}">
            <tr style="border-bottom:1px solid #ddd;">
                <td>${article.title}</td>
                <td style="float: right;width:12%"><span class="glyphicon glyphicon-trash"
                                                         style="color:orange"></span>&nbsp;&nbsp;&nbsp;
                    <span class="glyphicon glyphicon-edit" style="color:red"></span></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
