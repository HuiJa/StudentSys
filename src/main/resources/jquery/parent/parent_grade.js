var url = '${request.contextPath}/';//取项目首页url

    var course1url = url + 'api/course?sid=${child.sid?c}&cyear=1';
    var grade1url = url + 'api/grade?sid=${child.sid?c}&cyear=1';
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

    var course2url = url + 'api/course?sid=${child.sid?c}&cyear=2';
    var grade2url = url + 'api/grade?sid=${child.sid?c}&cyear=2';
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

    var course3url = url + 'api/course?sid=${child.sid?c}&cyear=3';
    var grade3url = url + 'api/grade?sid=${child.sid?c}&cyear=3';
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

    var course4url = url + 'api/course?sid=${child.sid?c}&cyear=4';
    var grade4url = url + 'api/grade?sid=${child.sid?c}&cyear=4';
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

    var fheigurl = url + 'api/fheig?sid=${child.sid?c}';
    var fweigurl = url + 'api/fweig?sid=${child.sid?c}';
    var frunurl = url + 'api/frun?sid=${child.sid?c}';
    var fjumpurl = url + 'api/fjump?sid=${child.sid?c}';
    var fwalkurl = url + 'api/fwalk?sid=${child.sid?c}';
    var fupurl = url + 'api/fup?sid=${child.sid?c}';
    var faheadurl = url + 'api/fahead?sid=${child.sid?c}';
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