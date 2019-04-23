$(function () {

    $("#loginBtn").click(function () {
        var input_ID = $("#_inputID").val();
        var input_password = $("#_inputPassword").val();

        var url = `http://www.google.com/Test_StudentManagementSystem/StudentLoginServlet?password=${input_password}&id=${input_ID}`;

        $.ajax({
            type: "GET",
            url: url,
            dataType: "json",
            xhrFields: {withCredentials: true},
            success: function (response) {
                if (response.status == 0) {
                    $("#alert").text(response.msg);
                    location.href = `ChooseCourse.html`;
                } else {
                    $("#alert").text(response.msg);
                }
            },
            error: function () {
                alert("地址无法获取！");
            }
        })
    })

})