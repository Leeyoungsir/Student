<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!-- 导航栏 -->
<header id="header">
    <nav id="navigation">
        <div class="nav-header">
            <h1 class="nav-brand"><a href="#">学生成绩管理系统</a></h1>
        </div>
        <ul id="cbp-tm-menu" class="cbp-tm-menu nav-menu">
            <li><a href="admin_course_info.jsp">管理课程</a></li>
            <li><a href="${pageContext.request.contextPath}/ListStudentServlet">管理学生</a></li>
            <li><a href="admin_notice_info.jsp">管理公告</a></li>
            <li>
                <a href="#">赵强</a>
                <ul class="cbp-tm-submenu user-submenu">
                    <li><a href="#">个人信息<span class="glyphicon glyphicon-user"></span></a></li>
                    <li><a href="#">修改密码<span class="glyphicon glyphicon-lock"></span></a></li>
                </ul>
            </li>
        </ul>
    </nav><!-- 导航栏 -->
</header>
