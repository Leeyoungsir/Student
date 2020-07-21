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
    <style>
        html,body{
            height: 100%
        }
        body{
            display: flex;
            justify-content: center;
            align-content: center;
            background: url(../images/1002025.jpg) no-repeat center/cover;
        }
        .wrap{
            width: 480px;
            height: 600px;
            background-color:#678E9F;
            margin: auto;
            border-radius: 8px;
        }
        .title{
            line-height: 80px;
            color: #000000;
            text-align: center;
            font-size: 2em;
        }
        .wrap input{
            border:1px solid red;
            text-indent: 0px;
            border-raduis: 5px ;
            outline: none;
        }
        .Registered-content input[type="button"]{
            width:64px;
            height:32px;
            line-height:18px;
            border:1px solid red;
            margin:4px 0 0 10px;
            background-color: #678E9F;
            text-indent: 0;
            color: #000000;
        }
    </style>
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
<div class="wrap">
    <h1 class="title">用户注册界面</h1>
    <form class="Registered-content" action="${pageContext.request.contextPath}/RegisterServlet" method="post">
        <input id="Uid" type="hidden" name="id">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名: <input id="name" type="text" name="username"/></p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码: <input id="pwd" type="password"  name="password"/></p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号: <input id="id" type="text" name="sno" /></p>
        <p>确认密码: <input id="pwd1" type="password"/></p>

        <p><input type="button" value="提交" id="check"></input></p>
    </form>
</div>
</body>
</html>
