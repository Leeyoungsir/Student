<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>班级列表</title>
		<meta name="description" content="Blueprint: Tooltip Menu" />
		<meta name="keywords" content="Tooltip Menu, navigation, tooltip, menu, css, web development, template" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
		<script src="${pageContext.request.contextPath}/js/modernizr.custom.js"></script>
	</head>
	<body>
		<%@include file="admin_navigator.jsp"%>

		<div class="container-fluid">
			<div class="panel panel-default">
				<div class="panel-heading" style="color: #0f0f0f">
					班级列表<a style="color: black"  href="${pageContext.request.contextPath}/admin/admin_class_add.jsp"><span class="glyphicon glyphicon-plus"></span>添加班级</a>
				</div>
				<div class="panel-body">
					<table class="table table-bordered table-hover">
						<tr>
							<th>班级号</th>
							<th>班级名</th>
							<th>院系号</th>
							<th>总人数</th>
						</tr>
						<c:forEach items="${pageBean.list}" varStatus="i" var="c">
							<tr>
								<td>${c.c_no}</td>
								<td>${c.c_name}</td>
								<td>${c.dno}</td>
								<td><a style="color: blue" href="${pageContext.request.contextPath}/ListStudentServlet?c_no=${c.c_no}">${c.member}</a> </td>
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

								<a href="${pageContext.request.contextPath}/ListClassServlet?currentpage=${pageBean.currentPage-1}&rows=10" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>

							</li>
							<c:forEach begin="1" end="${pageBean.totalPage}" var="i">
								<c:if test="${pageBean.currentPage==i}">
									<li class="active"><a href="${pageContext.request.contextPath}/ListClassServlet?currentpage=${i}&rows=10">${i}</a></li>
								</c:if>
								<c:if test="${pageBean.currentPage!=i}">
									<li ><a href="${pageContext.request.contextPath}/ListClassServlet?currentpage=${i}&rows=10">${i}</a></li>
								</c:if>

							</c:forEach>
							<c:if test="${pageBean.currentPage==pageBean.totalPage}">
							<li class="disabled">
								</c:if>

								<c:if test="${pageBean.currentPage!=pageBean.totalPage}">
							<li >
								</c:if>
								<a href="${pageContext.request.contextPath}/ListClassServlet?currentpage=${pageBean.currentPage==pageBean.totalPage? pageBean.currentPage:pageBean.currentPage+1}&rows=10" aria-label="Previous">
									<span aria-hidden="true">&raquo;</span>
								</a>

							</li>
							<span style="font-size: 25px; margin-left: 10px">共${pageBean.totalCount}条记录,共${pageBean.totalPage}页</span>

						</ul>
					</nav>
				</div>
			</div>
		</div>

		<script src="${pageContext.request.contextPath}/js/cbpTooltipMenu.min.js"></script>
		<script>
			var menu = new cbpTooltipMenu( document.getElementById( 'cbp-tm-menu' ) );
		</script>
>	</body>
</html>
