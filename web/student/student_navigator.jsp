<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/22
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/selectCourse.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="main">
    <div class="top navbar-header">
        <div class="title"><span>学生管理系统-学生端</span></div>
        <div class="right">
            <span class="userinfo">${sessionScope.user.username}</span>
            <span><a href="${pageContext.request.contextPath}/student/student_index.jsp">首页</a> </span>
        </div>
    </div>
    <div class="tabbar">
        <a href="${pageContext.request.contextPath}/ListSelectedCourseServlet"><div class="selected_course">已 选 课 程 </div></a>
        <a href="${pageContext.request.contextPath}/ListSelectCourseServlet"><div class="selected_course">可 选 课 程 </div></a>
        <a href="${pageContext.request.contextPath}/ListMyScoreServlet"><div class="selected_course">我的成绩单 </div></a>
    </div>
</div>
</body>
</html>
