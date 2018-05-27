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
    <title>体测图表页</title>
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
            <!--1:身高,跳远cm 2:体重:kg 3:1000,50,引体,屈体...写到这发现忘记肺活量了-->
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
        labels: ["大一", "大二", "大三", "大四"],
        datasets: [
            {
                name: "体重/kg", chartType: "line",
                values: [73, 74, 75, 75]
            }
        ]
    }
    const chart2 = new frappe.Chart("#chart2", {  // or a DOM element,
        // new Chart() in case of ES6 module with above usage
        title: "体重/kg",
        data: data2,
        type: 'axis-mixed', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
        height: 300,
        colors: ['#fd2215']
    })

    const data3 = {
        labels: ["大一", "大二", "大三", "大四"],
        datasets: [
            {
                name: "1000/min", chartType: "line",
                values: [3.3, 3.8, 3.7, 4.0]
            },
            {
                name: "50/s", chartType: "line",
                values: [7.1, 7.3, 6.8, 8.0]
            },
            {
                name: "引体/个", chartType: "line",
                values: [0, 2, 3, 8]
            },
            {
                name: "屈体/cm", chartType: "line",
                values: [7.1, 11, 12, 5]
            }
        ]
    }

    const chart3 = new frappe.Chart("#chart3", {  // or a DOM element,
        // new Chart() in case of ES6 module with above usage
        title: "杂项",
        data: data3,
        type: 'axis-mixed', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
        height: 300,
        colors: ['#fd28d4', '#39e231','#7cd6fd', '#743ee2']
    })
</script>
</body>
</html>