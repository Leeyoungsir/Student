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
            background: url(/images/2002059.jpg) no-repeat center/cover;
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
        .Login-content input[type="submit"]{
            background-color: red;
            text-indent: 0;
            color:#FFFFFF;
        }
        .YZM{
            height: 72px;
            margin: 0 auto;
            width: 72%;
            line-height: 10px;
            position: relative;
            margin-bottom: 4px;
        }
        .YZM_code{
            width: 20px;
            height: 35%;
            margin: 0 0 0 2px;
            border: 0;
            border-color: transparent;
            font-size: 16px;
            padding-left: 0;
        }
        .YZM_pic{
            display: block;
            width: 30%;
            height: 50%;
            background-color: #3498DB;
            color: #FFFFFF;
            position: absolute;
            top: 0;
            left: 65%;
            border-right: 5px;
            text-align: center;
        }
        .YZM_error{
            width: 70%;
            color: #E74C3C;
            font-size: 14px;
            margin: 0 auto;
            height: 20px;
            line-height: 20px;
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
                    $("form").subimt();
                }
            });
        });
    </script>
</head>
<body>
<div class="Login">
    <h2 class="title">Login</h2>
    <form class="Login-content" action="#" method="post">
        <input type="text" placeholder="请输入用户名" id="user" naame="user" class="name">
        <input type="password" placeholder="请输入密码" id="pwd" name="pwd" class="pwd">
        <p class="YZM">
            <input type="text" name="code" placeholder="请输入验证码" id="YZM_Input" class="YZM_code">
            &nbsp;&nbsp;&nbsp;<span id="code" class="YZM_pic" title="看不清，换一张!"></span>
        </p>
        <p class="YZM_error" id="errorTips">
        </p>
       <input type="submit" onclick="return check()" value="登录" id="Button">
    </form>
    <a href="Registered.jsp" >&nbsp;&nbsp;&nbsp;注册</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="FindPassword.jsp">忘记密码？</a>
</div>
<script>
    document.getElementById("code").onclick=changelmg;
    function changelmg() {
        var array=new Array(
            '1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'
            ,'T','U','V','W','S','Y','Z'
        );
        code=""
        //随机获得四个验证码
        for(var i=0;i<4;i++){
            var r=parseInt(Math.random()*array.length);
            code+=array[r];
        }
        document.getElementById("code").innerHTML=code;
    }
    //验证验证码
    function check() {
        var error;
        var codeInput=document.getElementById("YZM-Input").value;
        if(codeInput.toLowerCase()==code.toLowerCase()){
            console.log("123");
            return true;
        }else{
            error='验证码错误，请重新输入！';
            document.getElementById("errorTips").innerHTML=error;
            return false;
        }
    }
</script>
</body>
</html>
