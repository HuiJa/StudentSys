<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2018/5/8
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>学生主页</title>
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
            <div class="jumbotron">
                <h1>StudentSys</h1>
                <p>关于大学生成长轨迹,先进行如下分类:</p>
                <p style="text-indent: 2em">首先,大学生的健康成长大致分成三大方面:生活方面,知识方面,心灵方面.</p>
                <p style="text-indent: 2em">其次,按照阶段来可以分为四个阶段:初始阶段,积累阶段,拓展阶段,应用阶段.</p>
            </div>
            <div class="row">
                <div class="col-xs-6 col-lg-4">
                    <h2>新闻1</h2>
                    <p>所以到底发生了什么？1 </p>
                    <p><a class="btn btn-default" href="#" role="button">点击查看 &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <h2>新闻2</h2>
                    <p>所以最近发生啥了？2 </p>
                    <p><a class="btn btn-default" href="#" role="button">点击查看 &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <h2>新闻3</h2>
                    <p>所以最近发生啥了？3</p>
                    <p><a class="btn btn-default" href="#" role="button">点击查看 &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <h2>新闻4</h2>
                    <p>所以最近发生啥了？4 </p>
                    <p><a class="btn btn-default" href="#" role="button">点击查看 &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <h2>新闻5</h2>
                    <p>所以最近发生啥了？5 </p>
                    <p><a class="btn btn-default" href="#" role="button">点击查看 &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-4">
                    <h2>新闻6</h2>
                    <p>所以最近发生啥了？6 </p>
                    <p><a class="btn btn-default" href="#" role="button">点击查看 &raquo;</a></p>
                </div><!--/.col-xs-6.col-lg-4-->
            </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

        <%@include file="../common/student_sidebar.jsp" %>
    </div><!--/row-->

    <%@include file="../common/foot.jsp" %>

</div><!--/.container-->

<%@include file="../common/end_js.jsp" %>
</body>

</html>
