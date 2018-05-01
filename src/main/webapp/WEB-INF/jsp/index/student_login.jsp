<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2018/4/17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!--后面用到的标签例如c-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>学生登录</title>
    <!--移动设备支持-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css">
    <!--重写宽度css-->
    <style type="text/css">
        .form-signin {
            max-width: 450px;
            padding: 15px;
            margin: 0 auto;
        }

        input {
            margin-bottom: 3px;
        }
    </style>

</head>

<body>
<div class="container"> 
        
    <form class="form-signin" name="form" action="/student/login-exection" method="post">
        <div>
            <img src="${pageContext.request.contextPath }/resources/img/centos.png"
                 style="width:30px; height: 30px; float: left; margin-top:14px; margin-left: 15px; margin-right: 10px;">
        </div>
        <h2 class="form-signin-heading">学生登录</h2>

        <input type="text" class="form-control" placeholder="请输入学号" name="sid" required autofocus>
        <input type="password" class="form-control" placeholder="请输入密码" name="spasswd" required>

        <c:if test="${requestScope.LoginError == 1 }">
            <span style="color:#f44336;">用户名或密码输入有误!请检查后重新输入</span>
        </c:if>

        <%--<label class="checkbox">
            <input type="checkbox" value="remremver-me">阅读用户协议
        </label>--%>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <%--<a class="btn btn-lg btn-primary btn-block" href="admin_register.html" target="_blank">注册</a>--%>
    </form>

</div>
  
</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath }/resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件,绝对路径引入,其实不加好像也可以 -->
<script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>

</html>
