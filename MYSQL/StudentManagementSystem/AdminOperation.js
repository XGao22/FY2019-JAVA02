$(function () {

    function findAll(){
        var url = 'http://www.google.com/Test_StudentManagementSystem/student.do?operation=1';
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            xhrFields: {withCredentials: true},
            success: function (response) {
                $(".the_Big").remove();
                $(".right").append(`
                        <table id="showTable" class="the_Big">
                            <tr>
                                <th>ID</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>注册时间</th>
                                <th>最近修改时间</th>
                            </tr>
                        </table>
                    `);
                for(var i = 0;i<=response.data.length;i++){
                    var info = response.data[i];
                    $("#showTable").append("<tr><td>"+info.id+"</td><td>"+info.name+"</td><td>"+info.sex+"</td><td>"+info.strRegisterTime+"</td><td>"+info.strLastedSetTime+"</td></tr>");
                }
            },
            error: function () {
                alert("地址无法获取！");
            }
        })

        $("#show").text();
    }




    $("#add_By_Id").click(function () {
        $(".the_Big").remove();

        $(".right").append(`<form class="the_Big" onsubmit="return false">
            ID:<input type="text" id="input_id">
            name:<input type="text" id="input_name">
            sex:<input type="text" id="input_sex">
            password:<input type="password" id="input_password">
            <button id="confirm">确认</button>
        </form>`);

        $("#confirm").click(function () {
            var id = $("#input_id").val();
            var name = $("#input_name").val();
            var sex = $("#input_sex").val();
            var password = $("#input_password").val();
            var url = `http://www.google.com/Test_StudentManagementSystem/student.do?operation=3&id=${id}&name=${name}&sex=${sex}&password=${password}`;
            $.ajax({
                type: "GET",
                url: url,
                dataType: "json",
                xhrFields: {withCredentials: true},
                success: function (response) {
                    alert(response.msg);
                    findAll();
                },
                error: function () {
                    alert("地址无法获取！");
                }
            })
        })
    })


    $("#delete_By_Id").click(function () {
        $(".the_Big").remove();

        $(".right").append(`<form class="the_Big" onsubmit="return false">
            ID:<input type="text" id="input_id">
            <button id="confirm_delete">确认删除</button>
        </form>`)

        $("#confirm_delete").click(function () {
            var id = $("#input_id").val();
            var url = `http://www.google.com/Test_StudentManagementSystem/student.do?operation=4&id=${id}`;
            $.ajax({
                type: "GET",
                url: url,
                dataType: "json",
                xhrFields: {withCredentials: true},
                success: function (response) {
                    alert(response.msg);
                    findAll();
                },
                error: function () {
                    alert("地址无法获取！");
                }
            })
        })
    })


    function update(){
        $(".the_Big").remove();

        $(".right").append(`<form class="the_Big" onsubmit="return false">
            ID:<input type="text" id="input_id">
            name:<input type="text" id="input_name">
            sex:<input type="text" id="input_sex">
            password:<input type="password" id="input_password">
            <button id="confirmUpdate">确认</button>
        </form>`);

        $("#confirmUpdate").click(function () {
            var id = $("#input_id").val();
            var name = $("#input_name").val();
            var sex = $("#input_sex").val();
            var password = $("#input_password").val();
            var url = `http://www.google.com/Test_StudentManagementSystem/student.do?operation=5&id=${id}&name=${name}&sex=${sex}&password=${password}`;
            $.ajax({
                type: "GET",
                url: url,
                dataType: "json",
                xhrFields: {withCredentials: true},
                success: function (response) {
                    alert(response.msg);
                    findAll();
                },
                error: function () {
                    alert("地址无法获取！");
                }
            })
        })
    }

    function findById(){
        $(".the_Big").remove();

        $(".right").append(`<form class="the_Big" onsubmit="return false">
            ID:<input type="text" id="input_id">
            <button id="confirm_find">确认查找</button>
        </form>`)

        $("#confirm_find").click(function () {
            var id = $("#input_id").val();
            var url = `http://www.google.com/Test_StudentManagementSystem/student.do?operation=2&id=${id}`;
            $.ajax({
                type: "GET",
                url: url,
                dataType: "json",
                xhrFields: {withCredentials: true},
                success: function (response) {
                    $(".right").append(`
                        <table id="showTable" class="the_Big">
                            <tr>
                                <th>ID</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>注册时间</th>
                                <th>最近修改时间</th>
                            </tr>
                        </table>
                    `);
                    var info = response.data;
                    $("#showTable").append("<tr><td>"+info.id+"</td><td>"+info.name+"</td><td>"+info.sex+"</td><td>"+info.strRegisterTime+"</td><td>"+info.strLastedSetTime+"</td></tr>");
                },
                error: function () {
                    alert("地址无法获取！");
                }
            })
        })
    }

    function registerAdmin(){
        $(".the_Big").remove();

        $(".right").append(`<form class="the_Big" onsubmit="return false">
            ID:<input type="text" id="input_id">
            name:<input type="text" id="input_name">
            password:<input type="password" id="input_password">
            passwordCheck:<input type="password" id="input_passwordCheck">
            <button id="confirm_register">确认注册</button>
        </form>`);

        $("#confirm_register").click(function () {
            var id = $("#input_id").val();
            var name = $("#input_name").val();
            var password = $("#input_password").val();
            var passwordCheck = $("#input_passwordCheck").val();
            var url = `http://www.google.com/Test_StudentManagementSystem/admin.do?operation=2&username=${name}&password=${password}&passwordCheck=${passwordCheck}&id=${id}`;
            $.ajax({
                type: "GET",
                url: url,
                dataType: "json",
                xhrFields: {withCredentials: true},
                success: function (response) {
                    alert(response.msg);
                },
                error: function () {
                    alert("地址无法获取！");
                }
            })
        })
    }

    function findAllCourse(){
        var url = 'http://www.google.com/Test_StudentManagementSystem//CourseServlet?operation=1';
        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            xhrFields: {withCredentials: true},
            success: function (response) {
                $(".the_Big").remove();
                $(".right").append(`
                        <table id="showTable" class="the_Big">
                            <tr>
                                <th>课程ID</th>
                                <th>课程名称</th>
                                <th>创建时间</th>
                                <th>最近修改时间</th>
                            </tr>
                        </table>
                    `);
                for(var i = 0;i<=response.data.length;i++){
                    var info = response.data[i];
                    $("#showTable").append("<tr><td>"+info.courseId+"</td><td>"+info.courseName+"</td><td>"+info.createTime+"</td><td>"+info.modifyTime+"</td></tr>");
                }
            },
            error: function () {
                alert("地址无法获取！");
            }
        })

        $("#show").text();
    }
    function findCourseById(){}
    function addCourseById(){}
    function updateCourseById(){}
    function deleteCourseById(){}

    $("#find_All_Students").click(function () {
        findAll();
    });
    $("#find_By_Id").click(function () {
        findById();
    });
    $("#update_By_Id").click(function () {
        update();
    });
    $("#btnAdminRegister").click(function () {
        registerAdmin();
    })
    $("#find_All_Course").click(function () {
        findAllCourse();
    })
    $("#findCourse_By_Id").click(function () {
        findCourseById();
    })
    $("#addCourse_By_Id").click(function () {
        addCourseById();
    })
    $("#updateCourse_By_Id").click(function () {
        updateCourseById();
    })
    $("#deleteCourse_By_Id").click(function () {
        deleteCourseById();
    })



})