<%--
  Created by IntelliJ IDEA.
  User: 27785
  Date: 2020/7/17
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功注册后返回登录界面</title>
    <link rel="stylesheet" type="text/css" href="../css/return.css">
</head>
<body>
<script language="javascript">
    function doReload()
    {
        location.href="signin.jsp";
    }
    setTimeout("doReload()",3000);
</script>

<main>
    <div class="container">
        <div class="message">
            <h1 class="h1">注册成功</h1>
            <h3 class="h3">3秒后返回登录界面......</h3>
        </div>
    </div>
    </div>
</main>
</body>
</html>
