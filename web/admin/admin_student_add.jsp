<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>添加学生</title>
		<meta name="description" content="Blueprint: Tooltip Menu" />
		<meta name="keywords" content="Tooltip Menu, navigation, tooltip, menu, css, web development, template" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/component.css" />
		<link rel="stylesheet" type="text/css" href="../css/admin.css">
		<script src="../js/modernizr.custom.js"></script>
	</head>
	<body>
		<!-- 导航栏 -->
		<nav id="navigation">
			<div class="nav-header">
				<h1 class="nav-brand"><a href="#">学生成绩管理系统</a></h1>
			</div>
			<ul id="cbp-tm-menu" class="cbp-tm-menu nav-menu">
				<li><a href="admin_course_info.html">管理课程</a></li>
				<li><a href="${pageContext.request.contextPath}/ListStudentServlet">管理学生</a></li>
				<li><a href="admin_notice_info.html">管理公告</a></li>
				<li>
					<a href="#">赵强</a>
					<ul class="cbp-tm-submenu user-submenu">
						<li><a href="#">个人信息<span class="glyphicon glyphicon-user"></span></a></li>
						<li><a href="#">修改密码<span class="glyphicon glyphicon-lock"></span></a></li>
					</ul>
				</li>
			</ul>
		</nav><!-- 导航栏 -->

		<div class="wrap">
			<form action="${pageContext.request.contextPath}/AddStudentServlet">
			  <div class="form-group controls">
			    <input id="sno" name="sno" type="text" class="form-control floatLabel">
			    <label for="sno">学号</label>
			  </div>

			  <div class="form-group controls">
			    <input id="sname" name="sname" type="text" class="form-control floatLabel">
			    <label for="sname">姓名</label>
			  </div>
				<div class="form-group controls">
					<input id="ssex" name="ssex" type="text" class="form-control floatLabel">
					<label for="ssex">性别</label>
				</div>
				<div class="form-group controls">
					<input id="sage" name="sage" type="text" class="form-control floatLabel">
					<label for="sage">年龄</label>
				</div>
				<div class="form-group controls">
					<input id="syear" name="syear" type="text" class="form-control floatLabel">
					<label for="syear">年级</label>
				</div>
				<div class="form-group controls">
					<input id="smajor" name="smajor" type="text" class="form-control floatLabel">
					<label for="smajor">专业</label>
				</div>

			  <div class="check">
			  	<input type="submit" class="btn" value="确定">
			  </div>
			</form>
		</div>



		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery-3.0.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
		<script src="../js/cbpTooltipMenu.min.js"></script>
		<script>
			var menu = new cbpTooltipMenu( document.getElementById( 'cbp-tm-menu' ) );
		</script>
		<script>
			$(document).ready(function(){
      	checkValue();
        floatLabel('.floatLabel');
      });

      //浮动标签效果
      function floatLabel(inputType) {
        $(inputType).each(function () {
          var $this = $(this);
          $this.focus(function () {
              $this.next().addClass('lb-active');
          });
          $this.blur(function () {
              if ($this.val() === '' || $this.val() === 'blank') {
                  $this.next().removeClass();
              }
          });
        });
      }

      //检查表单里的数据，当表单里的数据不为空时，为标签添加浮动样式
      function checkValue(){
      	$("input").each(function(){
          var $this=$(this);
          if($this.val()!=""){
            $this.next().addClass('lb-active');
          }
        });
      }
		</script>
	</body>
</html>
