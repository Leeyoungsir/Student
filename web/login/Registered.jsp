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
<div class="wrap">
    <h1 class="title">用户注册界面</h1>
    <form class="Registered-content" action="###" method="post">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名: <input id="name" type="text" name="username"/></p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码: <input id="pwd" type="password"  name="pwd"/></p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号: <input id="id" type="text" name="id" /></p>
        <p>确认密码: <input id="pwd1" type="password" name="pwd1"/></p>
        <p>电子邮件: <input id="e-mail" type="text"  name="e-mail"/></p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：<label><input name="Fruit" type="radio" value="" checked />保密 </label>
            <label><input name="Fruit" type="radio" value="" />男</label>
            <label><input name="Fruit" type="radio" value="" />女 </label>
        </p>
        <p>生日：<select name="select" class="xla_k">
            <option value="请选择">请选择</option>
            <option value="2015">2015</option>
            <option value="2016">2016</option>
            <option value="2017">2017</option>
            <option value="2018">2018</option>
            <option value="2019">2019</option>
            <option value="2020">2020</option>
        </select>年
            <select name="select"  class="xla_k">
                <option value="请选择">请选择</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">122</option>
            </select>月
            <select name="select"  class="xla_k">
                <option value="请选择">请选择</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option><option value="17">17</option>
                <option value="7">7</option>
                <option value="8">8</option>
            </select>日
        </p>
        </p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;爱好：<input type=checkbox checked> 读书
        <input type=checkbox>旅游
        <input type=checkbox value=1>足球
        <input type=checkbox value=1>篮球
        <input type=checkbox value=1>乒乓球
        <input type=checkbox value=1>其他
        </p>
        <p>个人说明：<textarea name="yj" cols="30" rows="6"></textarea>
        </p>
       <p><input type="button" value="提交" id="check"></p>
    </form>
</div>
</body>
</html>
