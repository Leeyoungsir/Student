<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>成绩</title>
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
                <th>分数</th>
                <th>状态</th>
            </tr>
            <c:forEach items="${pageBean.list}" varStatus="i" var="sc">
                <tr>
                    <td>${sc.cno}</td>
                    <td>${sc.cname}</td>
                    <td>${sc.cteacher}</td>
                    <td>${sc.ccredit}</td>
                    <td>${sc.score}</td>
                    <td>${sc.status}</td>
                </tr>

            </c:forEach>
        </table>
        <nav class="nav">
            <ul class="pagination">
                <c:if test="${pageBean.currentPage==1}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pageBean.currentPage!=1}">
                <li>

                    </c:if>

                    <a href="${pageContext.request.contextPath}/ListMyScoreServlet?currentpage=${pageBean.currentPage-1}&rows=10" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>

                </li>
                <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                    <c:if test="${pageBean.currentPage==i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/ListMyScoreServlet?currentpage=${i}&rows=10">${i}</a></li>
                    </c:if>
                    <c:if test="${pageBean.currentPage!=i}">
                        <li ><a href="${pageContext.request.contextPath}/ListMyScoreServlet?currentpage=${i}&rows=10">${i}</a></li>
                    </c:if>

                </c:forEach>
                <c:if test="${pageBean.currentPage==pageBean.totalPage}">
                <li class="disabled">
                    </c:if>

                    <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
                <li >
                    </c:if>
                    <a href="${pageContext.request.contextPath}/ListMyScoreServlet?currentpage=${pageBean.currentPage==pageBean.totalPage? pageBean.currentPage:pageBean.currentPage+1}&rows=10" aria-label="Previous">
                        <span aria-hidden="true">&raquo;</span>
                    </a>

                </li>
                <span style="font-size: 25px; margin-left: 10px">共${pageBean.totalCount}条记录,共${pageBean.totalPage}页</span>

            </ul>
        </nav>
</div>


</body>
</html>