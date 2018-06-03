<%--
  Created by IntelliJ IDEA.
  User: HuiJa
  Date: 2018/6/1
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>孩子成绩页</title>
    <%@include file="../common/head_css.jsp" %>
</head>
<body>
<%@include file="../common/parent_navbar.jsp" %>
<div class="container">
    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
            <!--这个是侧边栏按钮,PC全屏默认隐藏,变窄后出现-->
            <p class="pull-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">SideBar</button>
            </p>
            <!--主体内容-->
            <div class="panel-heading text-center">
                <h2>学生数据</h2>
            </div>
            <div id="chart1"></div>
            <div id="chart2"></div>
            <div id="chart3"></div>
            <div id="chart4"></div>
            <div id="chart5"></div>
            <div id="chart6"></div>
            <div id="chart7"></div>
            <div class="panel panel-default">
                <div class="panel-heading text-center">
                    <h2>${sessionScope.child.sname}的课外活动</h2>
                </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>活动开始时间</th>
                            <th>活动结束时间</th>
                            <th>活动类型</th>
                            <th>活动内容</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="studentExtra" items="${requestScope.studentExtras}">
                            <tr>
                                <td><fmt:formatDate value="${studentExtra.estime}" pattern="yyyy-MM-dd"/></td>
                                <td><fmt:formatDate value="${studentExtra.eetime}" pattern="yyyy-MM-dd"/></td>
                                <td>${studentExtra.etype}</td>
                                <td>${studentExtra.ename}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><!--table1-->
            <div class="col-md-6">
                <form action="${pageContext.request.contextPath }/parent/child_comment" method="post">
                    <div class="input-group">
                        <input type="text" name="comment" class="form-control input-lg" placeholder="给他一个评价">
                        <button type="submit" class="btn btn-success btn-block">提交</button>
                    </div>
                </form>
            </div><!--add comment-->
            <div class="col-md-6">
                <form action="${pageContext.request.contextPath }/parent/search" method="post">
                    <div class="input-group">
                        <div class="input-group">
                            <input type="text" name="aim" class="form-control input-lg" placeholder="为您的孩子选一个目标">
                            <button type="submit" class="btn btn-success btn-block">搜索</button>
                        </div>
                        </span>
                    </div>
                </form>
            </div><!--Search-->
        </div>

        <%@include file="../common/parent_sidebar.jsp" %>
    </div>

    <%@include file="../common/foot.jsp" %>
</div>
<!--js调用时效果比如侧边栏拉动-->
<%@include file="../common/end_js.jsp" %>
<script>
    var url = '${pageContext.request.contextPath }/';//取项目首页url

    var course1url = url + 'api/course?sid=${sessionScope.child.sid}&cyear=1';
    var grade1url = url + 'api/grade?sid=${sessionScope.child.sid}&cyear=1';
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

    var course2url = url + 'api/course?sid=${sessionScope.child.sid}&cyear=2';
    var grade2url = url + 'api/grade?sid=${sessionScope.child.sid}&cyear=2';
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

    var course3url = url + 'api/course?sid=${sessionScope.child.sid}&cyear=3';
    var grade3url = url + 'api/grade?sid=${sessionScope.child.sid}&cyear=3';
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

    var course4url = url + 'api/course?sid=${sessionScope.child.sid}&cyear=4';
    var grade4url = url + 'api/grade?sid=${sessionScope.child.sid}&cyear=4';
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

    var fheigurl = url + 'api/fheig?sid=${sessionScope.child.sid}';
    var fweigurl = url + 'api/fweig?sid=${sessionScope.child.sid}';
    var frunurl = url + 'api/frun?sid=${sessionScope.child.sid}';
    var fjumpurl = url + 'api/fjump?sid=${sessionScope.child.sid}';
    var fwalkurl = url + 'api/fwalk?sid=${sessionScope.child.sid}';
    var fupurl = url + 'api/fup?sid=${sessionScope.child.sid}';
    var faheadurl = url + 'api/fahead?sid=${sessionScope.child.sid}';
    var fheig, fweig, frun, fjump, fwalk, fup, fahead;
    Ajax(fheigurl, function (res) {
        fheig = JSON.parse(res);
        Ajax(fjumpurl, function (res) {
            fjump = JSON.parse(res);
            const data5 = {
                labels: ["大一", "大二", "大三", "大四"],
                datasets: [
                    {
                        name: "身高/cm", chartType: "line",
                        values: fheig
                    },
                    {
                        name: "跳远/cm", chartType: "line",
                        values: fjump
                    }
                ]
            }

            const chart5 = new frappe.Chart("#chart5", {  // or a DOM element,
                // new Chart() in case of ES6 module with above usage
                title: "身高,跳远/cm",
                data: data5,
                type: 'axis-mixed', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
                height: 300,
                colors: ['#7cd6fd', '#743ee2']
            })
        })
    })

    Ajax(fweigurl, function (res) {
        fweig = JSON.parse(res);
        const data6 = {
            labels: ["大一", "大二", "大三", "大四"],
            datasets: [
                {
                    name: "体重/kg", chartType: "line",
                    values: fweig
                }
            ]
        }
        const chart6 = new frappe.Chart("#chart6", {  // or a DOM element,
            // new Chart() in case of ES6 module with above usage
            title: "体重/kg",
            data: data6,
            type: 'axis-mixed', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
            height: 300,
            colors: ['#fd2215']
        })
    })


    Ajax(fwalkurl, function (res) {
        fwalk = JSON.parse(res);
        Ajax(frunurl, function (res) {
            frun = JSON.parse(res);
            Ajax(fupurl, function (res) {
                fup = JSON.parse(res);
                Ajax(faheadurl, function (res) {
                    fahead = JSON.parse(res);
                    const data7 = {
                        labels: ["大一", "大二", "大三", "大四"],
                        datasets: [
                            {
                                name: "1000/min", chartType: "line",
                                values: fwalk
                            },
                            {
                                name: "50/s", chartType: "line",
                                values: frun
                            },
                            {
                                name: "引体/个", chartType: "line",
                                values: fup
                            },
                            {
                                name: "屈体/cm", chartType: "line",
                                values: fahead
                            }
                        ]
                    }

                    const chart7 = new frappe.Chart("#chart7", {  // or a DOM element,
                        // new Chart() in case of ES6 module with above usage
                        title: "杂项",
                        data: data7,
                        type: 'axis-mixed', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
                        height: 300,
                        colors: ['#fd28d4', '#39e231', '#7cd6fd', '#743ee2']
                    })
                })
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
