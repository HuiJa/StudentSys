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
            <div class="panel-heading text-center">
                <h2>体测轨迹</h2>
            </div>
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
    var url = '${pageContext.request.contextPath }/';

    var fheigurl = url + 'api/fheig?sid=${sessionScope.student.sid}';
    var fweigurl = url + 'api/fweig?sid=${sessionScope.student.sid}';
    var frunurl = url + 'api/frun?sid=${sessionScope.student.sid}';
    var fjumpurl = url + 'api/fjump?sid=${sessionScope.student.sid}';
    var fwalkurl = url + 'api/fwalk?sid=${sessionScope.student.sid}';
    var fupurl = url + 'api/fup?sid=${sessionScope.student.sid}';
    var faheadurl = url + 'api/fahead?sid=${sessionScope.student.sid}';
    var fheig, fweig, frun, fjump, fwalk, fup, fahead;
    Ajax(fheigurl, function (res) {
        fheig = JSON.parse(res);
        Ajax(fjumpurl, function (res) {
            fjump = JSON.parse(res);
            const data1 = {
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

            const chart1 = new frappe.Chart("#chart1", {  // or a DOM element,
                // new Chart() in case of ES6 module with above usage
                title: "身高,跳远/cm",
                data: data1,
                type: 'axis-mixed', // 'axis-mixed' or 'bar', 'line', 'scatter', 'pie', 'percentage'
                height: 300,
                colors: ['#7cd6fd', '#743ee2']
            })
        })
    })

    Ajax(fweigurl, function (res) {
        fweig = JSON.parse(res);
        const data2 = {
            labels: ["大一", "大二", "大三", "大四"],
            datasets: [
                {
                    name: "体重/kg", chartType: "line",
                    values: fweig
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
    })


    Ajax(fwalkurl, function (res) {
        fwalk = JSON.parse(res);
        Ajax(frunurl, function (res) {
            frun = JSON.parse(res);
            Ajax(fupurl, function (res) {
                fup = JSON.parse(res);
                Ajax(faheadurl, function (res) {
                    fahead = JSON.parse(res);
                    const data3 = {
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

                    const chart3 = new frappe.Chart("#chart3", {  // or a DOM element,
                        // new Chart() in case of ES6 module with above usage
                        title: "杂项",
                        data: data3,
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