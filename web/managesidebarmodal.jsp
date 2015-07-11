<%--
  Created by IntelliJ IDEA.
  User: tanhaiyuan
  Date: 2015/7/9
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--管理部分的模态框-->
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
                                <td style="float: right;width:12%"><a href=<%=request.getContextPath() + "/managecategorys"%>?method=del&&id=${category.id} class="glyphicon glyphicon-trash"
                                                                         style="color:orange"></a>&nbsp;&nbsp;&nbsp;
                                    <a href=<%=request.getContextPath() + "/managecategorys"%>?method=modify&&id=${category.id} class="glyphicon glyphicon-edit" style="color:red"></a></td>
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
                                <td style="float: right;width:12%"><a href=<%=request.getContextPath() + "/managetags"%>?method=del&&id=${tag.id} class="glyphicon glyphicon-trash"
                                                                         style="color:orange"></a>&nbsp;&nbsp;&nbsp;
                                    <a href=<%=request.getContextPath() + "/managetags"%>?method=modify&&id=${tag.id} class="glyphicon glyphicon-edit" style="color:red"></a></td>
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
