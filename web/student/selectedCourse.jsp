<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/20
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>已选课</title>
</head>
<link href="${pageContext.request.contextPath}/css/selectCourse.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<body>
<%@include file="student_navigator.jsp"%>
  <div class="content">
      <table class="table table-hover table-condensed">
        <tr>
          <th>课程号</th>
          <th>课程名</th>
          <th>任课教师</th>
          <th>学分</th>
          <th>选课/退课</th>
        </tr>
       <c:forEach items="${pageBean.list}" var="c" varStatus="i">
         <tr>
           <td>${c.cno}</td>
           <td>${c.cname}</td>
           <td>${c.cteacher}</td>
           <td>${c.ccredit}</td>
           <td><a href="${pageContext.request.contextPath}/RemoveCourseServlet?cno=${c.cno}"><button class="xuanke btn-danger">退课</button></a></td>
         </tr>
       </c:forEach>

<!--退课的class为btn-danger-->
      </table>
    <nav class="nav">
      <ul class="pagination">
        <c:if test="${pageBean.currentPage==1}">
        <li class="disabled">
          </c:if>
          <c:if test="${pageBean.currentPage!=1}">
        <li>

          </c:if>

          <a href="${pageContext.request.contextPath}/ListSelectedCourseServlet?currentpage=${pageBean.currentPage-1}&rows=10" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
          </a>

        </li>
        <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
          <c:if test="${pageBean.currentPage==i}">
            <li class="active"><a href="${pageContext.request.contextPath}/ListSelectedCourseServlet?currentpage=${i}&rows=10">${i}</a></li>
          </c:if>
          <c:if test="${pageBean.currentPage!=i}">
            <li ><a href="${pageContext.request.contextPath}/ListSelectedCourseServlet?currentpage=${i}&rows=10">${i}</a></li>
          </c:if>

        </c:forEach>
        <c:if test="${pageBean.currentPage==pageBean.totalPage}">
        <li class="disabled">
          </c:if>

          <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
        <li >
          </c:if>
          <a href="${pageContext.request.contextPath}/ListSelectedCourseServlet?currentpage=${pageBean.currentPage==pageBean.totalPage? pageBean.currentPage:pageBean.currentPage+1}&rows=10" aria-label="Previous">
            <span aria-hidden="true">&raquo;</span>
          </a>

        </li>
        <span style="font-size: 25px; margin-left: 10px">共${pageBean.totalCount}条记录,共${pageBean.totalPage}页</span>

      </ul>
    </nav>
  </div>
</div>

</body>
</html>
