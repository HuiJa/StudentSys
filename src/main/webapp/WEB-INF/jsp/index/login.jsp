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
<html lang="zh-CN">
<head>
    <title>登录页面</title>
    <%@include file="../common/head_css.jsp" %>
</head>

<body class="bg-info">
<div class="container"> 
    <form class="form-signin" name="form" action="/user/login-exection" method="post">
        <div class="row" style="margin-top:30px;">
            <div class="col-md-6" style="border-right:1px solid #ddd;">
                <div class="well col-md-10">
                    <h3>用户登录</h3>
                    <div class="input-group input-group-md">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"
                                                           aria-hidden="true"></i></span>
                        <input type="text" class="form-control" placeholder="用户名" name="id" required autofocus>
                    </div>
                    <div class="input-group input-group-md">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" class="form-control" placeholder="密码" name="passwd" required>
                    </div>
                    <div class="well well-sm" style="text-align:center;">
                        <input type="radio" name="kind" value="tea" required> 老师
                        <input type="radio" name="kind" value="stu" required> 学生
                    </div>
                    <c:if test="${requestScope.LoginError == 1 }">
                        <span style="color:#f44336;">用户名不存在或者密码错误!请检查后重新输入</span>
                    </c:if>
                    <button type="submit" class="btn btn-success btn-block">
                        登录
                    </button>
                </div>
            </div>
            <div class="col-md-6">
                <h3>
                    欢迎使用学生"成长轨迹"管理与评价系统
                </h3>
                <ul>
                    <li>学生使用<em>学号</em>登录，初始密码为<em>now888</em>，登录后请及时修改密码</li>
                    <li>老师请使用<em>工号</em>登录，初始密码为<em>now888</em>，登录后请及时修改密码</li>
                </ul>
            </div>
        </div>
        <%--<a class="btn btn-lg btn-primary btn-block" href="admin_register.html" target="_blank">注册</a>--%>
    </form>

</div>
  
<%@include file="../common/end_js.jsp" %>
</body>

</html>
