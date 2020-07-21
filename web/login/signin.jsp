<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生登录</title>
    <link rel="stylesheet" type="text/css" href="../css/login&registered.css">
</head>
<body>
<header>
    <nav>
        <ul>
            <a href=signin.jsp><li>登录</li></a>
            <a href="Registered.jsp"><li>注册</li></a>
        </ul>
    </nav>
</header>
<main>
    <div class="container">
        <img class="login_bg" src="../image/login.png">
        <form class="form" action="#" method="post">
            <h3>学生信息管理系统</h3>
            <input type="text" autofocus="autofocus" name="user" value placeholder="用户名" required="required">
            <input type="password" name="pwd" value placeholder="密码" required="required">
            <input type="text" name="code" size="10"value placeholder="验证码" ><img border=0 src=""><br>
            <a id="other" href="FindPassword.jsp">忘记密码</a>

            <input id="submit" type="submit" onclick="return check()" value="登录" id="Button">
        </form>
    </div>
</main>
</body>
</html>
