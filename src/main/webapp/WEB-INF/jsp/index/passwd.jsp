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
    <title>修改密码</title>
    <%@include file="../common/head_css.jsp" %>
</head>

<body class="bg-danger">
<div class="container"> 
    <form class="form-signin" name="form" action="/user/passd-execution" method="post">
        <div class="row" style="margin-top:30px;">
            <div class="col-md-6" style="border-right:1px solid #ddd;">
                <div class="well col-md-10">
                    <h3>密码修改</h3>
                    <div class="input-group input-group-md">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"
                                                           aria-hidden="true"></i></span>
                        <input type="password" class="form-control" placeholder="新密码" name="passwd1" required autofocus>
                    </div>
                    <div class="input-group input-group-md">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" class="form-control" placeholder="密码确认" name="passwd2" required>
                    </div>
                    <c:if test="${requestScope.PasswdError == 1 }">
                        <span style="color:#f44336;">请确认你是否输入新的密码而且两次密码一致!</span>
                    </c:if>
                    <button type="submit" class="btn btn-success btn-block">
                        修改
                    </button>
                </div>
            </div>
            <div class="col-md-6">
                <h3>
                    密码修改，请修改默认密码并牢记。
                </h3>
                <ul>
                    <li>学生初始密码为<em>now888</em>，登录后请及时修改密码</li>
                    <li>老师初始密码为<em>now888</em>，登录后请及时修改密码</li>
                </ul>
            </div>
        </div>
        <%--<a class="btn btn-lg btn-primary btn-block" href="admin_register.html" target="_blank">注册</a>--%>
    </form>

</div>
  
<%@include file="../common/end_js.jsp" %>
</body>

</html>
