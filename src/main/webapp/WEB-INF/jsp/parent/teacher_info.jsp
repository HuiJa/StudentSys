<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2018/6/1
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>教师信息页</title>
    <%@include file="../common/head_css.jsp" %>
</head>
<body>
<%@include file="../common/parent_navbar.jsp" %>
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
                    <h2>个人信息</h2>
                </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>电话</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${requestScope.teacherMessage.tname}</td>
                            <td>${requestScope.teacherMessage.ttele}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div><!--table1-->
        </div>

        <%@include file="../common/parent_sidebar.jsp" %>
    </div>

    <%@include file="../common/foot.jsp" %>
</div>
<!--js调用时效果比如侧边栏拉动-->
<%@include file="../common/end_js.jsp" %>

</body>
</html>