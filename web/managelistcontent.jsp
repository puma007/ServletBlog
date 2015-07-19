<%--
  Created by IntelliJ IDEA.
  User: tanhaiyuan
  Date: 2015/7/9
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 博客内容管理列表 左侧-->
<div class="col-md-8">
    <c:forEach var="article" items="${articleList}">
        <div class="panel panel-default" style="height: 195px;padding:0;margin-top:30px;">
            <!-- //上面文章标题-->
            <div class="col-md-12 panel-heading"><a
                    href=<%=request.getContextPath() + "/articledetail"%>?id=${article.id}><span
                    class="glyphicon glyphicon-star">&nbsp;</span>${article.title}</a>
            <span style="float: right"> <a style="text-decoration:none; " href=<%=request.getContextPath() + "/edit"%>?id=${article.id}>编辑</a>
                    <a style="text-decoration:none; " href=<%=request.getContextPath() + "/delete"%>?id=${article.id}">删除</a></span>

            </div>

            <!-- //下面-->
            <div class="col-md-12 panel-body">
                <!-- //下面左边：缩略图-->
                <div class="col-md-2" style="margin:0;padding:0;height:150px;">
                    <img src="img/article01.jpg" style="height: 120px;"/>
                </div>
                <!-- //下面右边-->
                <div class="col-md-10" style="padding:0;">
                    <!-- //下面右边上面：文章简短说明-->
                    <div class="col-md-12"><p>${article.content}</p></div>
                    <!--//下面右边下面： 时间等信息-->
                    <div class="col-md-12" style="margin:0;padding:0;position:absolute;bottom:-52px;">
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
</div>