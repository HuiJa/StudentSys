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
            <div class="panel-heading text-center">
                <h2>课程成绩</h2>
            </div>
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
    var url = '${pageContext.request.contextPath }/';

    var course1url = url + 'api/course?sid=${sessionScope.student.sid}&cyear=1';
    var grade1url = url + 'api/grade?sid=${sessionScope.student.sid}&cyear=1';
    var course1, grade1;
    Ajax(course1url, function (res) {
        course1 = JSON.parse(res);
        Ajax(grade1url, function (res) {
            grade1 = JSON.parse(res);
            const data1 = {
                labels: course1,
                datasets: [
                    {
                        name: "成绩/分", chartType: "bar",
                        values: grade1
                    }
                ]
            }
            const chart1 = new frappe.Chart("#chart1", {  // or a DOM element,
                // new Chart() in case of ES6 module with above usage
                title: "大一选课程及成绩",
                data: data1,
                type: 'bar', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
                height: 300,
                colors: ['#fd1d27']
            })
        })
    })

    var course2url = url + 'api/course?sid=${sessionScope.student.sid}&cyear=2';
    var grade2url = url + 'api/grade?sid=${sessionScope.student.sid}&cyear=2';
    var course2, grade2;
    Ajax(course2url, function (res) {
        course2 = JSON.parse(res);
        Ajax(grade2url, function (res) {
            grade2 = JSON.parse(res);
            const data2 = {
                labels: course2,
                datasets: [
                    {
                        name: "成绩/分", chartType: "bar",
                        values: grade2
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
        })
    })

    var course3url = url + 'api/course?sid=${sessionScope.student.sid}&cyear=3';
    var grade3url = url + 'api/grade?sid=${sessionScope.student.sid}&cyear=3';
    var course3, grade3;
    Ajax(course3url, function (res) {
        course3 = JSON.parse(res);
        Ajax(grade3url, function (res) {
            grade3 = JSON.parse(res);
            const data3 = {
                labels: course3,
                datasets: [
                    {
                        name: "成绩/分", chartType: "bar",
                        values: grade3
                    }
                ]
            }
            const chart3 = new frappe.Chart("#chart3", {  // or a DOM element,
                // new Chart() in case of ES6 module with above usage
                title: "大三选课程及成绩",
                data: data3,
                type: 'bar', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
                height: 300,
                colors: ['#3363fd']
            })
        })
    })

    var course4url = url + 'api/course?sid=${sessionScope.student.sid}&cyear=4';
    var grade4url = url + 'api/grade?sid=${sessionScope.student.sid}&cyear=4';
    var course4, grade4;
    Ajax(course4url, function (res) {
        course4 = JSON.parse(res);
        Ajax(grade4url, function (res) {
            grade4 = JSON.parse(res);
            const data4 = {
                labels: course4,
                datasets: [
                    {
                        name: "成绩/分", chartType: "bar",
                        values: grade4
                    }
                ]
            }
            const chart4 = new frappe.Chart("#chart4", {  // or a DOM element,
                // new Chart() in case of ES6 module with above usage
                title: "大四选课程及成绩",
                data: data4,
                type: 'bar', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
                height: 300,
                colors: ['#fd2de2']
            })
        })
    })

    function Ajax(url, callback) {
        var xhr = new XMLHttpRequest();

        xhr.open('GET', url, true);

        xhr.send();

        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    callback(xhr.responseText);
                }
            }
        }
    }
</script>
</body>
</html>
