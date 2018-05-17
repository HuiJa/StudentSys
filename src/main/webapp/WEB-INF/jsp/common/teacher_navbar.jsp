<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2018/5/11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--导航栏-->
<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/Introduction">StudentSys</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/teacher/index-show">主页</a></li>
                <li><a href="#about">个人信息</a></li>
                <li><a href="#contact">学生信息</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li style="font-size: 25px;color: #888888">Hello,${requestScope.teacher.tname}</li>
                <li>
                    <a href="${pageContext.request.contextPath }/teacher/exit">
                        <button class="btn btn-xs btn-danger" type="button">exit</button>
                    </a>
                </li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->
