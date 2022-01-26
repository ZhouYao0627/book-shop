// 验证用户名是否已经存在
function checkUser(obj) {
    // alert(obj.value)
    // 提交到后台去验证用户名是否已经存在，需异步校验
    $.ajax({
        url: contextPath + "/user/checkUserName",
        data: {
            "username": obj.value
        },
        method: "post",
        success: function (data) {
            // alert(data);
            $("#msg").css("display", "block");
            if (data == 102) { // 表示用户已存在
                $("#tip").html("用户名已存在");
                $("#tip").removeClass("alert-success");
                $("#tip").addClass("alert-danger");
            } else {
                $("#tip").html("用户名可以注册");
                $("#tip").removeClass("alert-danger");
                $("#tip").addClass("alert-success");
            }
        }
    })
}

// 用户注册
function register() {
    var datas = $("#regForm").serialize(); // 序列化表单的数据
    $.ajax({
        url: contextPath + "/user/register",
        data: datas,
        method: "post",
        success: function (data) {
            // alert(data);
            if (data == 'success') {
                alert("注册成功，请登录！");
                $("#register").modal('hide');
            }
        }
    })
}

// 用户登录
function login() {
    var datas = $("#loginForm").serialize(); // 序列化表单的数据
    $.ajax({
        url: contextPath + "/user/login",
        data: datas,
        method: "post",
        success: function (data) {
            $("#userTip").css("display", "none");
            $("#pwdTip").css("display", "none");
            if (data == 100) { // 登录成功，模态窗关闭
                $("#loginModal").modal('hide');
                Window.location.href = contextPath + "/book/index"; /* 登录成功则跳转到首页*/
            } else if (data == 101) { // 用户不存在
                $("#userTip").css("display", "block"); // 让它显示出来
            } else { // 密码输入错误
                $("#pwdTip").css("display", "block");
            }
        }
    })
}