<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生登录</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            font-family: "PingFangSC-Regular","Microsoft Yahei",sans-serif;
        }
        body{
            background-image: url(../images/bg.jpg);
            background-position: center center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;

        }
        ul{
            list-style: none;
        }

        ul li{
            display: inline-block;
        }

        header{
            position: absolute;
            top: 12px;
            z-index: 11;
            font-size:15px;
            line-height: 34px;
            width: 100%;
        }

        header nav{
            float: right;
            margin-right: 40px;
            text-align: center;
            line-height: 40px;
        }

        header nav ul li{
            margin: 0 15px;
            float: left;
            height: 38px;
        }

        a{
            color: #fff;
            text-decoration:none;
        }
        a:hover{
            font-size: 15px;
            color: #E0555A;
        }
        main{
            display: block;
            position: absolute;
            width: 100%;
            height: 100%;
            overflow: hidden;
            z-index: 1;
        }
        .container{
            background: #fff;
            position: relative;
            margin: 5em auto 0;
            height: 482px;
            width: 760px;
            box-shadow: 4px 4px 20px rgba(0,0,0,.5);
        }
        .login_bg{
            display: block;
            height: 100%;
            width: 100%;
            line-height: 0;
            border: 0;
        }
        .title{
            line-height: 80px;
            color: #0f0f0f;
            text-align: center;
            font-size: 2em;
        }
        .form{
            position: absolute;
            top: 0em;
            right: 0em;
            width: 36%;
            padding: 6em 5em;
            font-weight: 300;
        }
        .form h3{
            font-weight: 600;
            font-size: 1.5em;
            margin-bottom: 1.2em;
        }
        .form p{
            display: block;
            font-size: 1.2em;
            line-height: 1.2em;
            margin-bottom: 1.2em;
        }
        .form input{
            display: block;
            border: 1px solid #666;
            background-color: #fff;
            height:2.5em;
            width: 90%;
            padding: 0.5em 1em;
            margin-bottom: 1em;
        }
        #other{
            color: #0f0f0f;
            text-align: right;

        }
        #submit{
            color: #fff;
            background-color: #333;
            border: none;
            line-height: 1em;
            padding: 0.5em 0;
            width: 100%;
            height: 2.5em;
            text-align: center;
            cursor: pointer;
            margin-top: 1.5em;
        }
    </style>

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
            <a href=signin.jsp><li>登录</li></a>
            <a href="Registered.jsp"><li>注册</li></a>
        </ul>
    </nav>
</header>
<main>
    <div class="container">
        <img class="login_bg" src="../images/login.png">

        <form name="loginForm" class="form" action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <h3>学生信息管理系统</h3>
            <input type="text" autofocus="autofocus" name="username" value placeholder="用户名" required="required">
            <input type="password" name="password" value placeholder="密码" required="required">
            <input type="text" name="code" size="10"value placeholder="验证码" >
            <img name="imgValidate" border=0 src="${pageContext.request.contextPath}/checkCode" onclick="refresh()"><br>
            <a id="other" href="FindPassword.jsp">忘记密码</a>

            <input id="submit" type="submit" onclick="return check()" value="登录" id="Button">
        </form>
    </div>
</main>
</body>
</html>
