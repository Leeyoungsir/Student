<%--
  Created by IntelliJ IDEA.
  User: 27785
  Date: 2020/7/17
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>学生登录</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        html,body{
            height: 100%;
        }
        a{
            text-decoration:none;
        }
        body{
            display: flex;
            justify-content: center;
            align-content: center;
            background: url(../images/2002059.jpg) no-repeat center/cover;
        }
        .Login{
            width: 320px;
            height: 420px;
            background-color:#FFFFFF;
            margin: auto;/*设置外边距*/
            border-radius: 8px;
            border-style:solid;
            border-color:white red red red;
            border-width: 1px;
        }
        .Login:before{
            display:block;
            content:  ' ';
            width: 100%;
            height: 20px;
            background-image:-webkit-linear-gradient(left,#27AE60 0%,#27AE60 25%,#8E44AD 25%,#8E44AD 50%,
            #3498DB 50%,#3498DB 75%, #E74C3C 75%,#E74C3C 100%);
            border-radius: 6px 6px 0 0;
        }
        .title{
            line-height: 80px;
            color: #27AE60;
            text-align: center;
            font-size: 2em;
        }
        .Login-content{
            display: flex;
            justify-content: space-around;
            align-items: center;
            align-content: space-around;
            flex-direction: column;
            height: 300px;
        }
        .Login-content input{
            width: 80%;
            height: 36px;
            border:1px solid red;
            text-indent: 1em;
            border-raduis: 5px;
            outline: none;
        }
        .login-bottom{
            background-color: red;
            text-indent: 0;
            color:#FFFFFF;
        }
        #regist{
            width: 20%;
            margin-right:10px;
        }

    </style>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#Button").click(function () {
                var user=$("#user").val();
                var pwd=$("#pwd").val();
                //判断是否为空
                if(user==''&&pwd==''){
                    alert("账号和密码不能为空!");
                }else if(user==''&&pwd!=''){
                    alert("账号不能为空");
                }else if(pwd==''&&user!=''){
                    alert("密码不能为空");
                }else{
                    //提交表单
                    $("form").submit();
                }
            });
        });
    </script>
</head>
<body>
<div class="Login">
    <%
        if(request.getParameter("loginInfo") !=null){
            out.print(request.getParameter("loginInfo"));
        }
    %>
    <h2 class="title">Login</h2>
    <form class="Login-content" action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <input type="text" placeholder="请输入用户名" id="user" name="username" class="name">
        <input type="password" placeholder="请输入密码" id="pwd" name="password" class="pwd">
       <input value="登录" class="login-bottom" id="Button">
    </form>
    <div id="regist">
        <a  href="${pageContext.request.contextPath}/login/Registered.jsp" >&nbsp;&nbsp;&nbsp;注册</a>
    </div>


<%--    <a id="change-password" href="${pageContext.request.contextPath}/login/FindPassword.jsp">忘记密码？</a>--%>
</div>
</body>
</html>
