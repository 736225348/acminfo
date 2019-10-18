<%--
  Created by IntelliJ IDEA.
  User: luo
  Date: 2019/10/18
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<script src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
<script>
    <%--function aaa() {--%>

    <%--    var username = $("#username").val();--%>
    <%--    var password = $("#password").val();--%>


    <%--    &lt;%&ndash;alert(username + " " + password);&ndash;%&gt;--%>
    <%--    $.ajax({--%>
    <%--        url: "login2",--%>
    <%--        type: "post",--%>
    <%--        data: JSON.stringify({--%>
    <%--            username:--%>
    <%--            username, password:--%>
    <%--            password--%>
    <%--        }),--%>
    <%--        ContentType: "application/json;charset=UTF-8",--%>
    <%--        dataType: "json",--%>
    <%--        success:--%>
    <%--            function (data) {--%>
    <%--                alert(data.username + " " + data.password)--%>

    <%--            }--%>

    <%--    })--%>
    <%--    ;--%>
    <%--}--%>

</script>
<body>

<a href="/luo/succ"></a>
<form action="/luo/succ" method="post">
    账号 <input name="username" type="text"><br>
    密码<input name="password" type="password"><br>
    密码1<input name="luo.a1" type="text"><br>
    密码2<input name="luo.a2" type="text"><br>
    <button>提交</button>
</form>
</body>
</html>
