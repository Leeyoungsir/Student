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
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        html,body{
            height: 100%;
        }
        body{
            display: flex;
            justify-content: center;
            align-content: center;
            background: url("image/2003287.jpg")no-repeat center/cover;
        }
        .password{
            width: 360px;
            height: 380px;
            margin: auto;
            background-color: #FFFFFF;
            border-radius: 8px;
        }
        .title{
            line-height: 60px;
            color: #27AE60;
            text-align: center;
            font-size: 2em;
        }
        .password-content{
            display: flex;
            justify-content: space-around;
            align-items: center;
            flex-direction: column;
            height: 300px;

        }
        .password-content input{
            width: 80%;
            height: 36px;
            border:1px solid red;
            text-indent: 1em;
            border-raduis: 5px ;
            outline: none;
        }
        .password-content input[type="submit"]{
            font-size: 18px;
            text-indent: 0;
            background-color: #3498DB;
        }
    </style>
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
<div class="password">
    <h1 class="title">找回密码</h1>
    <form class="password-content" action="#" method="post">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名: <input id="name" type="text" name="username" placeholder="输入用户名"/></p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码: <input id="pwd" type="password"  name="pwd" placeholder="输入新密码"/></p>
        <p>确认密码: <input id="pwd1" type="password" name="pwd1" placeholder="再次输入新密码"/></p>
        <p><input type="button" value="提交" id="check"></p>

    </form>
</div>
</body>
</html>
