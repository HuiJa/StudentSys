<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2018/5/11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
    <div class="list-group">
        <!--active写到class里可以判断区分那一页,但是我想单独拿出来,后面自己写个来区分-->
        <a href="${pageContext.request.contextPath}/student/grade" class="list-group-item">课程成绩</a>
        <a href="${pageContext.request.contextPath}/student/fitness" class="list-group-item">体侧成绩</a>
        <a href="${pageContext.request.contextPath}/student/reviews" class="list-group-item">他人评价</a>
        <a href="${pageContext.request.contextPath}/student/own" class="list-group-item">自我评价</a>
    </div>
</div><!--/.sidebar-offcanvas-->
