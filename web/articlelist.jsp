<%--
  Created by IntelliJ IDEA.
  User: tanhaiyuan
  Date: 2015/7/5
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文章列表</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        li {
            list-style: none;
        }

        a {
            text-decoration: none;
        }
    </style>

</head>
<body>
<%@ include file="header.jsp" %>

<section class="content-wrap">
    <div class="container">
        <div class="row">
            <!--左侧 content-->
            <jsp:include page="articlelistcontent.jsp" flush="true"/>
            <!--右侧 sidebar-->
            <jsp:include page="sidebar.jsp" flush="true"/>
        </div>
    </div>
</section>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

