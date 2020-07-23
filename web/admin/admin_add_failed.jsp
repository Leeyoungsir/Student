<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/22
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加失败</title>
    <meta name="description" content="Blueprint: Tooltip Menu" />
    <meta name="keywords" content="Tooltip Menu, navigation, tooltip, menu, css, web development, template" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/modernizr.custom.js"></script>
</head>
<body>
<%@include file="admin_navigator.jsp"%>
添加失败！！！
<br>
<c:if test="${param.aId==1}"><a style="color: deepskyblue" href="${pageContext.request.contextPath}/ListStudentServlet">返回学生管理</a></c:if>
<c:if test="${param.aId==2}"><a style="color: deepskyblue" href="${pageContext.request.contextPath}/ListCourseServlet">返回课程管理</a></c:if>
<c:if test="${param.aId==3}"><a style="color: deepskyblue" href="${pageContext.request.contextPath}/ListClassServlet">返回班级管理</a></c:if>

</body>
</html>
