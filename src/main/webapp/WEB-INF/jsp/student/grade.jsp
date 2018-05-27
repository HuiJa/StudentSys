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
    <title>课程成绩页</title>
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
            <div id="chart3"></div>
            <div id="chart4"></div>
        </div>

        <%@include file="../common/student_sidebar.jsp" %>
    </div>

    <%@include file="../common/foot.jsp" %>
</div>
<!--js调用时效果比如侧边栏拉动-->
<%@include file="../common/end_js.jsp" %>
<script>
    const data1 = {
        labels: ["大学英语", "高等数学", "大学物理", "C语言程序设计"],
        datasets: [
            {
                name: "成绩/分", chartType: "bar",
                values: [73, 74, 75, 75]
            }
        ]
    }
    const chart1 = new frappe.Chart("#chart1", {  // or a DOM element,
        // new Chart() in case of ES6 module with above usage
        title: "大一选课程及成绩",
        data: data1,
        type: 'bar', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
        height: 300,
        colors: ['#fd28d4']
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

    const data3 = {
        labels: ["计算机网络", "数据库原理", "编程语言设计", "软件工程"],
        datasets: [
            {
                name: "成绩/分", chartType: "bar",
                values: [66, 74, 88, 90]
            }
        ]
    }
    const chart3 = new frappe.Chart("#chart3", {  // or a DOM element,
        // new Chart() in case of ES6 module with above usage
        title: "大三选课程及成绩",
        data: data3,
        type: 'bar', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
        height: 300,
        colors: ['#556bfd']
    })

    const data4 = {
        labels: ["Web程序设计", "Linux操作系统", "安卓程序开发", "信息安全技术"],
        datasets: [
            {
                name: "成绩/分", chartType: "bar",
                values: [55, 74, 66, 90]
            }
        ]
    }
    const chart4 = new frappe.Chart("#chart4", {  // or a DOM element,
        // new Chart() in case of ES6 module with above usage
        title: "大四选课程及成绩",
        data: data4,
        type: 'bar', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
        height: 300,
        colors: ['#fdca36']
    })
</script>
</body>
</html>
