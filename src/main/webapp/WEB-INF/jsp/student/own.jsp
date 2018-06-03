<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2018/5/26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>个人查询评价页面</title>
    <%@include file="../common/head_css.jsp" %>
</head>
<body>
<%@include file="../common/student_navbar.jsp" %>
<div class="container">
    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
            <!--这个是侧边栏按钮,PC全屏默认隐藏,变窄后出现-->
            <p class="pull-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">SideBar</button>
            </p>
            <!--主体内容-->
            <div class="panel panel-default">
                <div class="panel-heading text-center">
                    <h2>${sessionScope.student.sname}的课外活动</h2>
                </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>活动开始时间</th>
                            <th>活动结束时间</th>
                            <th>活动类型</th>
                            <th>活动内容</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="ownExtra" items="${requestScope.ownExtras}">
                            <tr>
                                <td><fmt:formatDate value="${ownExtra.estime}" pattern="yyyy-MM-dd"/></td>
                                <td><fmt:formatDate value="${ownExtra.eetime}" pattern="yyyy-MM-dd"/></td>
                                <td>${ownExtra.etype}</td>
                                <td>${ownExtra.ename}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><!--table1-->
            <div class="panel panel-default">
                <div class="panel-heading text-center">
                    <h2>自我评价</h2>
                </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>评价时间</th>
                            <th>评价内容</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="ownReview" items="${requestScope.ownReviews}">
                            <tr>
                                <td><fmt:formatDate value="${ownReview.rdate}" pattern="yyyy-MM-dd"/></td>
                                <td>${ownReview.rcont}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath }/student/deleteReview?rid=${ownReview.rid}">
                                        <button class="btn btn-xs btn-danger" type="button">删除</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><!--table3-->
            <div class="col-md-6">
                <form action="${pageContext.request.contextPath }/student/addReview" method="post">
                    <div class="input-group">
                        <input type="text" name="comment" class="form-control input-lg" placeholder="给自己一个评价">
                        <button type="submit" class="btn btn-success btn-block">添加</button>
                    </div>
                </form>
            </div><!--Add Comment-->
            <div class="col-md-6">
                <form action="${pageContext.request.contextPath }/student/search" method="post">
                    <div class="input-group">
                        <div class="input-group">
                            <input type="text" name="aim" class="form-control input-lg" placeholder="自己的大学目标">
                            <button type="submit" class="btn btn-success btn-block">搜索</button>
                        </div>
                        </span>
                    </div>
                </form>
            </div><!--Search-->
        </div>

        <%@include file="../common/student_sidebar.jsp" %>
    </div>

    <%@include file="../common/foot.jsp" %>
</div>
<!--js调用时效果比如侧边栏拉动-->
<%@include file="../common/end_js.jsp" %>

</body>
</html>
