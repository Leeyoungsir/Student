<%--
  Created by IntelliJ IDEA.
  User: 27785
  Date: 2020/7/16
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>密码找回</title>
    <link rel="stylesheet" type="text/css" href="../css/login&registered.css">
    <script>
        $(document).ready(function () {
            $("#check").click(function () {
                var name=$("#name").val();
                var pwd=$("#pwd").val();
                var pwd1=$("#pwd1").val();
                //判断是否为空
                if(name==''&&pwd==''){
                    alert("用户名和密码不能为空!");
                }else if(name==''&&pwd!=''){
                    alert("用户名不能为空");
                }else if(pwd==''&&name!=''){
                    alert("密码不能为空");
                }
                else if(pwd!=pwd1) {
                    alert("两次密码不一致");
                }else{
                    //提交表单
                    $("form").subimt();
                }
            });
        });
    </script>
</head>
<body>
<header>
    <nav>
        <ul>
            <li>学生信息管理系统</li>
            <a href=signin.jsp><li>登录</li></a>
            <a href="Registered.jsp"><li>注册</li></a>
        </ul>
    </nav>
</header>
<main>
    <div class="container">
        <img class="login_bg" src="../image/login.png">
        <form class="form" action="#" method="post">
            <h3>找回密码</h3>
            <input id="name" type="text" autofocus="autofocus" name="username" value placeholder="用户名" required="required">
            <input id="id" type="text" name="sno" value placeholder="学号" required="required">
            <input id="pwd" type="password" name="password" value placeholder="密码" required="required">
            <input id="pwd1" type="password"  value placeholder="确认密码" required="required">
            <div><input type="text" name="code" size="10"value placeholder="验证码" ><img border=0 src=" "></div>
            <input id="submit" type="submit" onclick="return check()" value="提交" id="Button">
        </form>
    </div>
</main>
</body>
</html>
