<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>所有学生</title>
		<meta name="description" content="Blueprint: Tooltip Menu" />
		<meta name="keywords" content="Tooltip Menu, navigation, tooltip, menu, css, web development, template" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/component.css" />
		<link rel="stylesheet" type="text/css" href="../css/admin.css">
		<script src="../js/modernizr.custom.js"></script>
	</head>
	<body>
		<%@include file="admin_navigator.jsp"%>>

		<div class="container-fluid">
			<div style="align-content: center">
				<form action="${pageContext.request.contextPath}/ListStudentServlet" method="post" class="form-inline">
					<div class="form-group">
						<label for="find_name">姓名：</label>
						<input type="text" value="${conditionMap.sname[0]}" id="find_name" name="sname" class="form-control">
					</div>
					<div class="form-group">
						<label for="find_age">年龄：</label>
						<input type="text" value="${conditionMap.sage[0]}" id="find_age" name="sage" class="form-control" >
					</div>
					<div class="form-group">
						<label for="find_major">专业：</label>
						<input type="text" value="${condiyionMap.smajor[0]}" id="find_major" name="smajor" class="form-control" >
					</div>
					<div class="form-group">
						<label for="find_c_no">班号：</label>
						<input type="text" value="${condiyionMap.c_no[0]}" id="find_c_no" name="c_no" class="form-control" >
					</div>
					<button type="submit" class="btn btn-primary">查询</button>
				</form>
			</div>
			<div class="panel panel-default">
			  <div class="panel-heading" style="color: #0f0f0f">
			  	学生列表<a style="color: #0f0f0f"  href="/admin/admin_student_add.jsp"><span class="glyphicon glyphicon-plus"></span>添加学生</a>
			  </div>
			  <div class="panel-body">
			    <table class="table table-bordered table-hover">
			    	<tr>
			    		<th>学号</th>
			    		<th>姓名</th>
			    		<th>性别</th>
			    		<th>年龄</th>
			    		<th>年级</th>
			    		<th>专业</th>
						<th>班号</th>
			    		<th>修改</th>
			    		<th>删除</th>
			    	</tr>
			    	<c:forEach items="${pageBean.list}" varStatus="i" var="student">
						<tr>
							<td>${student.sno}</td>
							<td>${student.sname}</td>
							<td>${student.ssex}</td>
							<td>${student.sage}</td>
							<td>${student.syear}</td>
							<td>${student.smajor}</td>
							<td>${student.c_no}</td>
							<td class="opration"><a href="${pageContext.request.contextPath}/UpdateStudentServlet?sno=${student.sno}"><span class="glyphicon glyphicon-wrench"></span></a></td>
							<td class="opration"><a href="${pageContext.request.contextPath}/DeleteStudentServlet?sno=${student.sno}"><span class="glyphicon glyphicon-remove"></span></a></td>
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

							  <a href="${pageContext.request.contextPath}/ListStudentServlet?currentpage=${pageBean.currentPage-1}&rows=10&sname=${conditionMap.sname[0]}&sage=${conditionMap.sage[0]}&smajor=${conditionMap.smajor[0]}&c_no=${conditionMap.c_no[0]}" aria-label="Previous">
								  <span aria-hidden="true">&laquo;</span>
							  </a>

						  </li>
						  <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
							  <c:if test="${pageBean.currentPage==i}">
								  <li class="active"><a href="${pageContext.request.contextPath}/ListStudentServlet?currentpage=${i}&rows=10&sname=${conditionMap.sname[0]}&sage=${conditionMap.sage[0]}&smajor=${conditionMap.smajor[0]}&c_no=${conditionMap.c_no[0]}">${i}</a></li>
							  </c:if>
							  <c:if test="${pageBean.currentPage!=i}">
								  <li ><a href="${pageContext.request.contextPath}/ListStudentServlet?currentpage=${i}&rows=10&sname=${conditionMap.sname[0]}&sage=${conditionMap.sage[0]}&smajor=${conditionMap.smajor[0]}&c_no=${conditionMap.c_no[0]}">${i}</a></li>
							  </c:if>

						  </c:forEach>
						  <c:if test="${pageBean.currentPage==pageBean.totalPage}">
						  <li class="disabled">
							  </c:if>

							  <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
						  <li >
							  </c:if>
							  <a href="${pageContext.request.contextPath}/ListStudentServlet?currentpage=${pageBean.currentPage==pageBean.totalPage? pageBean.currentPage:pageBean.currentPage+1}&rows=10&sname=${conditionMap.sname[0]}&sage=${conditionMap.sage[0]}&smajor=${conditionMap.smajor[0]}&c_no=${conditionMap.c_no[0]}" aria-label="Previous">
								  <span aria-hidden="true">&raquo;</span>
							  </a>

						  </li>
						  <span style="font-size: 25px; margin-left: 10px">共${pageBean.totalCount}条记录,共${pageBean.totalPage}页</span>

					  </ul>
				  </nav>
			  </div>
			</div>
		</div>



		<script src="../js/cbpTooltipMenu.min.js"></script>
		<script>
			var menu = new cbpTooltipMenu( document.getElementById( 'cbp-tm-menu' ) );
		</script>
	</body>
</html>
