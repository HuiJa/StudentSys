<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2018/5/11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>Introduction of StudentSys</title>
    <%@include file="../common/head_css.jsp" %>
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/cover.css" rel="stylesheet">
</head>

<body>

<div class="site-wrapper">
    <div class="site-wrapper-inner">
        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">StudentSys</h3>
                    <nav>
                        <ul class="nav masthead-nav">
                            <li class="active"><a
                                    href="${pageContext.request.contextPath}/Introduction">Introduction</a></li>
                            <c:if test="${requestScope.student != null }">
                                <li><a href="${pageContext.request.contextPath}/student/index-show">StudentHome</a></li>
                            </c:if>
                            <c:if test="${requestScope.teacher != null }">
                                <li><a href="${pageContext.request.contextPath}/teacher/index-show">TeacherHome</a></li>
                            </c:if>
                            <c:if test="${requestScope.parent != null }">
                                <li><a href="${pageContext.request.contextPath}/parent/index-show">ParentHome</a></li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">大学生"成长轨迹"管理与评价系统</h1>
                <p class="lead">将大学生成长的研究与大数据时代接轨，创建一个实时的、互动的网络平台，
                    汇集教师、家长和学生三方的评价，记录学生课程学习、业余活动、项目实践等方面的连续信息，
                    在此基础上分析研究大学生成长情况并提出阶段性建议。</p>
                <p class="lead">
                    <a href="https://huija.github.io" target="_blank" class="btn btn-lg btn-default">Welcome to my blogs</a>
                </p>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>Repository of <a href="https://github.com/HuiJa/StudentSys" target="_blank">StudentSys</a>, by <a
                            href="https://github.com/huija" target="_blank">@huija</a>.</p>
                </div>
            </div>

        </div>
    </div>
</div>

<%@include file="../common/end_js.jsp" %>
</body>
</html>
