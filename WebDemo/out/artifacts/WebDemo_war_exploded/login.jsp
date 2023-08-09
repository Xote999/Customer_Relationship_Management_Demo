<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/6/12
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <title>ログイン画面</title>
</head>
<body>
<div class="mx-auto" style="width: 300px;">
    <h1 class="mb-3" style="text-align: center">管理者ログイン画面</h1>
    <form action="login" method="post" id="loginForm">
        <div class="mb-3">
            <label for="uname" class="form-label" >管理者ID</label>
            <input type="text" class="form-control" id="uname" name="uname" value="${messageModel.object.userName}">
        </div>
        <div class="mb-3">
            <label for="upwd" class="form-label">パスワード</label>
            <input type="password" class="form-control" id="upwd" name="upwd" value="${messageModel.object.userPwd}">
        </div>
        <span id="msg" style="font-size: 15px;color: red">${messageModel.msg}</span><br>
        <button type="button" class="btn btn-primary" id="loginBtn">ログイン</button>
    </form>
</div>
</body>

<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">

    $("#loginBtn").click(function (){
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();
        if(isEmpty(uname)){
            $("#msg").html("ユーザーIDを空白にすることができません!");
            return;
        }
        if(isEmpty(upwd)){
            $("#msg").html("パスワードを空白にすることができません!");
            return;
        }
        $("#loginForm").submit();
    });

    function isEmpty(str) {
        if (str == null || str.trim() == "") {
            return true;
        }
        return false;
    }

</script>
</html>

