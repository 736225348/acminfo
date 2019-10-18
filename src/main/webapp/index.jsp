<%--
  Created by IntelliJ IDEA.
  User: luo
  Date: 2019/10/18
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
<script>
    function aaa() {
        <%--alert(username + " " + password);--%>
        $.ajax({
            url: "luo/succ2",
            contentType: "application/json",
            data: '{"username:"hehe","password:"123"}',
            dataType: "json",
            type: "post",
            success: function (data) {
                alert(data.username + " " + data.password);
            }
        })
        ;
    }
</script>
<body>
<a href="/luo/succ1">点击1</a>
<button onclick="aaa()">点击</button>

<a href="/luo/succ"></a>
<form action="/luo/succ2" method="post">
    账号 <input name="username" type="text"><br>
    密码<input name="password" type="password"><br>
    <button>提交</button>
</body>
</html>
