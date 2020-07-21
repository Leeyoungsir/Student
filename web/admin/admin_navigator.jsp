<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!-- 导航栏 -->
<header id="header">
    <nav id="navigation">
        <div class="nav-header">
            <h1 class="nav-brand"><a href="#">学生管理系统-管理员端</a></h1>
        </div>
        <ul id="cbp-tm-menu" class="cbp-tm-menu nav-menu">
            <li><a href="${pageContext.request.contextPath}/ListCourseServlet">管理课程</a></li>
            <li><a href="${pageContext.request.contextPath}/ListStudentServlet">管理学生</a></li>
            <li><a href="${pageContext.request.contextPath}/ListClassServlet">管理班级</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/admin_index.jsp">首页</a></li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/admin_detail.jsp">管理员--${sessionScope.user.username}</a>

            </li>
        </ul>
    </nav><!-- 导航栏 -->
</header>
