<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2018/5/24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>学生信息页</title>
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
            <div id="chart1"></div>
            <div id="chart2"></div>
            <div class="col-md-6">
                <form action="${pageContext.request.contextPath }/student/comment" method="post">
                    <div class="input-group">
                        <input type="text" name="comment" class="form-control input-lg" placeholder="给他一个评价">
                        <button type="submit" class="btn btn-success btn-block">提交</button>
                    </div>
                </form>
            </div><!--add comment-->
        </div>

        <%@include file="../common/student_sidebar.jsp" %>
    </div>

    <%@include file="../common/foot.jsp" %>
</div>
<!--js调用时效果比如侧边栏拉动-->
<%@include file="../common/end_js.jsp" %>
<script>
    const data1 = {
        labels: ["大一", "大二", "大三", "大四"],
        datasets: [
            {
                name: "身高/cm", chartType: "line",
                values: [173, 174, 175, 175]
            },
            {
                name: "跳远/cm", chartType: "line",
                values: [210, 205, 190, 200]
            }
        ]
    }

    const chart1 = new frappe.Chart("#chart1", {  // or a DOM element,
        // new Chart() in case of ES6 module with above usage
        title: "身高,跳远/cm",
        data: data1,
        type: 'axis-mixed', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
        height: 300,
        colors: ['#7cd6fd', '#743ee2']
    })
    const data2 = {
        labels: ["算法", "微机原理", "离散数学", "数据结构"],
        datasets: [
            {
                name: "成绩/分", chartType: "bar",
                values: [88, 74, 60, 90]
            }
        ]
    }
    const chart2 = new frappe.Chart("#chart2", {  // or a DOM element,
        // new Chart() in case of ES6 module with above usage
        title: "大二选课程及成绩",
        data: data2,
        type: 'bar', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
        height: 300,
        colors: ['#51fd4d']
    })
</script>
</body>
</html>
