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
    <title>评价显示</title>
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

            <div class="panel panel-default">
                <div class="panel-heading text-center">
                    <h2>老师评价</h2>
                </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>评价时间</th>
                            <th>评价内容</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="teacherReview" items="${requestScope.teacherReviews}">
                            <tr>
                                <td><fmt:formatDate value="${teacherReview.rdate}" pattern="yyyy-MM-dd"/></td>
                                <td>${teacherReview.rcont}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><!--table1-->
            <div class="panel panel-default">
                <div class="panel-heading text-center">
                    <h2>同学评价</h2>
                </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>评价时间</th>
                            <th>评价内容</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="studentReview" items="${requestScope.studentReviews}">
                            <tr>
                                <td><fmt:formatDate value="${studentReview.rdate}" pattern="yyyy-MM-dd"/></td>
                                <td>${studentReview.rcont}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><!--table2-->
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
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="ownReview" items="${requestScope.ownReviews}">
                            <tr>
                                <td><fmt:formatDate value="${ownReview.rdate}" pattern="yyyy-MM-dd"/></td>
                                <td>${ownReview.rcont}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><!--table3-->
        </div>

        <%@include file="../common/student_sidebar.jsp" %>
    </div>

    <%@include file="../common/foot.jsp" %>
</div>
<!--js调用时效果比如侧边栏拉动-->
<%@include file="../common/end_js.jsp" %>
</body>
</html>
