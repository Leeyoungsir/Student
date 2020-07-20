<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/20
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生欢迎功能主页面</title>
    <link rel="stylesheet" type="text/css" href="css/welcome.css">
</head>
<body>
<header>
    <div class="title">
        <span>功能主页面</span>

    </div>
    <nav>
        <div class="userinfo">
            <ul>
                <li>Username</li>
                <li>退出登录</li>
                <li>返回首页</li>
            </ul>
        </div>
    </nav>
</header>
<main>
    <div class="container">
        <div class="select">
            <h3>请选择功能</h3>
            <ul id="accordion"class="accordion">
                <li>
                    <div id="user-info"class="link"></i>学生信息管理</div>
                </li>
                <li>
                    <div class="link"></i>班级信息管理</div>
                </li>
            </ul>
        </div>
        <div id="result" class="result">
            <p class="welcome">欢迎使用学生信息管理系统！</p>
        </div>
    </div>
</main>

<html>
<head>
    <title>学生欢迎功能主页面</title>
</head>
<body>
<header>
    <div class="title">
        <span>功能主页面</span>
    </div>
    <nav>
        <div class="userinfo">
            <ul>
                <li>Username</li>
                <li>退出登录</li>
                <li>返回首页</li>
            </ul>
        </div>
    </nav>
</header>
<main>
    <div class="container">
        <div class="select">
            <h3>请选择功能</h3>
            <ul id="accordion"class="accordion">
                <li>
                    <div id="user-info"class="link"></i>选课</div>
                </li>
                <li>
                    <div class="link"></i>成绩</div>
                </li>
            </ul>
        </div>
        <div id="result" class="result">
            <p class="welcome">欢迎使用学生信息管理系统！</p>
        </div>
    </div>
</main>

</body>
</html>
