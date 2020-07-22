<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/22
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="admin_navigator.jsp"%>
添加失败！！！
<c:if test="${aId==1}"><a href="${pageContext.request.contextPath}/ListStudentServlet">返回学生管理</a></c:if>
<c:if test="${aId==2}"><a href="${pageContext.request.contextPath}/ListCourseServlet">返回课程管理</a></c:if>
<c:if test="${aId==3}"><a href="${pageContext.request.contextPath}/ListClassServlet">返回班级管理</a></c:if>

</body>
</html>
