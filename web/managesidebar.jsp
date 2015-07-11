<%--
  Created by IntelliJ IDEA.
  User: tanhaiyuan
  Date: 2015/7/9
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--管理右侧-->
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
</div>

