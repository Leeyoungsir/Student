<%--
  Created by IntelliJ IDEA.
  User: 27785
  Date: 2020/7/16
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login&registered.css">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        function formatDateTime() {
            var date = new Date();
            var y = date.getFullYear();
            var m = date.getMonth();
            var d = date.getDate();
            d = d < 10 ? ('0' + d) : d;
            var h = date.getHours();
            var minute = date.getMinutes();
            var second = date.getSeconds();
            return y + m + d + h + minute + second;
        }
        $(document).ready(function () {
            $("#check").click(function () {
                var name=$("#name").val();
                var pwd=$("#pwd").val();
                var pwd1=$("#pwd1").val();
                var uuid = formatDateTime() + Math.random()*10000;
                uuid = parseInt(uuid);
                $("#Uid").val(uuid);
                var u=$("#Uid").val();
                console.log(uuid);
                console.log(u);
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
                    console.log("ok")
                    //提交表单
                    $("form").submit();
                }
            });
        });
    </script>
</head>
<body>
<script type ="text/javascript">
    function refresh() {
        loginForm.imgValidate.src="${pageContext.request.contextPath}/checkCode?id="+Math.random();
    }
</script >
<header>
    <nav>
        <ul>
            <a href="${pageContext.request.contextPath}/login/signin.jsp"><li>登录</li></a>
            <a href="${pageContext.request.contextPath}/login/Registered.jsp"><li>注册</li></a>
        </ul>
    </nav>
</header>
<main>
    <div class="container">
        <img class="login_bg" src="../images/login.png">
        <form name="loginForm" class="form" action="${pageContext.request.contextPath}/RegisterServlet" method="post">
            <h3>学生信息管理系统</h3>
            <!-- 出错显示的信息框 -->
            <div class="alert alert-warning alert-dismissible" role="alert">
                <strong style="color: red">${reg_msg}</strong>
            </div>
            <input id="Uid" type="hidden" name="id">
            <input id="name" type="text" autofocus="autofocus" name="username" value placeholder="用户名" required="required">
            <input id="id" type="text" name="sno" value placeholder="学号" required="required">
            <input id="pwd" type="password" name="password" value placeholder="密码" required="required">
            <input id="pwd1" type="password"  value placeholder="确认密码" required="required">
            <div><input type="text" name="code" size="10"value placeholder="验证码" >
                <img name="imgValidate" border=0 src="${pageContext.request.contextPath}/checkCode" onclick="refresh()">
            </div>
            <input id="submit" type="submit" onclick="return check()" value="提交" id="Button">
        </form>
    </div>
</main>
</body>
</html>
