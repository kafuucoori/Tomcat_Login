// 该方法已被下方checkNameByJQuery()替代
function checkName() {

    var name = document.getElementById("name").value;
    var span = document.getElementById("sname");

    if (name == null || name == "") {
        span.innerHTML = "用户名不能为空";
        span.style.color = "yello";
        return false;
    } else {
        var xhr = new XMLHttpRequest();
        var url = "/Tomcat_Login/checkname?name=" + name;
        // 开启一个请求（请求方式，请求路径，请求类型是否异步）
        xhr.open("get", url, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            // readyState 请求状态编号 0-4
            // 请求初始化 请求连接中 请求处理中 请求响应中 请求处理完成
            // status 页面状态码 404 500 200表示未出错
            if (xhr.readyState == 4 && xhr.status == 200) {
                var resText = xhr.responseText;
                if (resText == "true") {
                    span.innerHTML = "当前用户名可使用";
                    span.style.color = "green";
                    return true;
                } else {
                    span.innerHTML = "用户名已存在";
                    span.style.color = "red";
                    return false;
                }
            }
        }
    }
}

function checkNameByJQuery() {

    var name = $("#name").val();
    var span = $("#sname");

    if (name == null || name == "") {
        span.css("color", "yellow").html("用户名不能为空");
        return false;
    } else {
        $.ajax({
            url: "/Tomcat_Login/checkname",
            data: {"name": name},
            type: "post",
            success: function (result) {
                if (result == "true") {
                    span.css("color", "green").html("当前用户名可使用");
                    return true;
                } else {
                    span.css("color", "red").html("用户名已存在");
                    return false;
                }
            }
        });
    }
}

function checkNameByJQueryGet() {

    var name = $("#name").val();
    var span = $("#sname");

    if (name == null || name == "") {
        span.css("color", "yellow").html("用户名不能为空");
        return false;
    } else {
        $.get("/Tomcat_Login/checkname?name=" + name, function(result) {
            if (result == "true") {
                span.css("color", "green").html("当前用户名可使用");
                return true;
            } else {
                span.css("color", "red").html("用户名已存在");
                return false;
            }
        });
    }
}

function checkNameByJQueryPost() {

    var name = $("#name").val();
    var span = $("#sname");

    if (name == null || name == "") {
        span.css("color", "yellow").html("用户名不能为空");
        return false;
    } else {
        $.post("/Tomcat_Login/checkname", {"name": name}, function(result) {
            if (result == "true") {
                span.css("color", "green").html("当前用户名可使用");
                return true;
            } else {
                span.css("color", "red").html("用户名已存在");
                return false;
            }
        });
    }
}
