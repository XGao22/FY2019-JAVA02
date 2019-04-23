$(function () {

    var totalPage = 0;
    var currentPage = 1;
    var hasBefore = false;
    var hasNext = false;

    function a(num) {
        console.log(num);
    }

    function exchange(num) {
        var pageNo = $(this).attr("value");
        console.log(pageNo);
        var url = "http://www.google.com/Test_StudentManagementSystem/StudentChooseCourseServlet?operation=1&pageNo=" + num + "";
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            xhrFields: {withCredentials: true},
            success: function (response) {

                $("#showChosenTable").remove();
                $(".btnTab").remove();
                $(".btnOption").remove();
                $(".right").empty();
                $(".right").append(`
                        <table id="showChosenTable">
                            <tr>
                                <th>选课ID</th>
                                <th>学生姓名</th>
                                <th>课程名称</th>
                            </tr>
                        </table>
                    `);
                var totalPage = response.data.totalPage;
                var currentPage = response.data.currentPage;
                var hasBefore = response.data.hasBefore;
                var hasNext = response.data.hasNext;
                $(".right").append(`
                       <button class="btnOption" id="before"><-</button>
                    `);
                if (!hasBefore) {
                    $("#before").prop("disabled", true);
                }
                for (var i = 1; i <= totalPage; i++) {
                    if (currentPage == i) {
                        $(".right").append(`
                       <button class="btnTab" style="background: blue" value="${i}">${i}</button>
                    `);
                    } else {
                        $(".right").append(`
                       <button class="btnTab" style="background: white" value="${i}">${i}</button>
                    `);
                    }
                }
                $(".btnTab").click(function () {
                    var pageNo = $(this).attr("value");
                    console.log(pageNo);
                    exchange(pageNo);
                })
                $(".right").append(`
                       <button class="btnOption" id="next">-></button>
                    `);
                if (!hasNext) {
                    $("#next").prop("disabled", true);
                }
                $("#before").click(function () {
                    exchange(--currentPage);
                })
                $("#next").click(function () {
                    exchange(++currentPage);
                })
                for (var i = 0; i <= response.data.data.length; i++) {
                    var info = response.data.data[i];
                    $("#showChosenTable").append("<tr><td>" + info.id + "</td><td>" + info.studentId + "</td><td>" + info.courseId + "</td></tr>");
                }
            },
            error: function () {
                alert("地址无法获取！");
            }
        })
    }

    function findAll() {
        var url = 'http://www.google.com/Test_StudentManagementSystem/ShowAllCourseServLet';
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            xhrFields: {withCredentials: true},
            success: function (response) {
                for (var i = 0; i <= response.data.length; i++) {
                    var info = response.data[i];
                    $("#showTable").append("<tr><td>" + info.courseId + "</td><td>" + info.courseName + "</td><td>" + info.createTime + "</td><td>" + info.modifyTime + "</td></tr>");
                }
            },
            error: function () {
                alert("地址无法获取！");
            }
        })
    }

    function init() {


        var url = 'http://www.google.com/Test_StudentManagementSystem/StudentChooseCourseServlet?operation=1&pageNo=1';
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            xhrFields: {withCredentials: true},
            success: function (response) {

                $("#showChosenTable").remove();
                $(".btnTab").remove();
                $(".btnOption").remove();
                $(".right").empty();
                $(".right").append(`
                        <table id="showChosenTable">
                            <tr>
                                <th>选课ID</th>
                                <th>学生姓名</th>
                                <th>课程名称</th>
                            </tr>
                        </table>
                    `);
                var totalPage = response.data.totalPage;
                var currentPage = response.data.currentPage;
                var hasBefore = response.data.hasBefore;
                var hasNext = response.data.hasNext;
                $(".right").append(`
                       <button class="btnOption" id="before"><-</button>
                    `);
                if (!hasBefore) {
                    $("#before").prop("disabled", true);
                }
                for (var i = 1; i <= totalPage; i++) {

                    if (currentPage == i) {
                        $(".right").append(`
                       <button class="btnTab" style="background: blue" value="${i}">${i}</button>
                    `);
                    } else {
                        $(".right").append(`
                       <button class="btnTab" style="background: white" value="${i}">${i}</button>
                    `);
                    }
                }
                $(".btnTab").click(function () {
                    var pageNo = $(this).attr("value");
                    exchange(pageNo);
                })
                $(".right").append(`
                       <button class="btnOption" id="next">-></button>
                    `);
                if (!hasNext) {
                    $("#next").prop("disabled", true);
                }
                $("#before").click(function () {
                    exchange(--currentPage);
                })
                $("#next").click(function () {
                    exchange(++currentPage);
                })
                for (var i = 0; i <= response.data.data.length; i++) {
                    var info = response.data.data[i];
                    $("#showChosenTable").append("<tr><td>" + info.id + "</td><td>" + info.studentId + "</td><td>" + info.courseId + "</td></tr>");
                }
            },
            error: function () {
                alert("地址无法获取！");
            }
        })
    }

    function choose() {
        var input_ID = $("#_input").val();
        var url = `http://www.google.com/Test_StudentManagementSystem/StudentChooseCourseServlet?operation=2&courseId=${input_ID}`;
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            xhrFields: {withCredentials: true},
            success: function (response) {
                if (response.status == 0) {
                    alert(response.msg);
                    init();
                } else {
                    alert(response.msg);
                }
            },
            error: function () {
                alert("地址无法获取！");
            }
        })
    }

    function cancel() {
        var input_ID = $("#_input").val();
        var url = `http://www.google.com/Test_StudentManagementSystem/StudentChooseCourseServlet?operation=3&courseId=${input_ID}`;
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            xhrFields: {withCredentials: true},
            success: function (response) {
                if (response.status == 0) {
                    alert(response.msg);
                    init();
                } else {
                    alert(response.msg);
                }
            },
            error: function () {
                alert("地址无法获取！");
            }
        })
    }


    $("#showAllCourse").click(function () {
        findAll();
    })
    $("#showChosenCourse").click(function () {
        init();
    })
    $("#choose").click(function () {
        choose();
    })
    $("#cancel").click(function () {
        cancel();
    })


})