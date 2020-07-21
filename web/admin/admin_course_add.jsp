<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>添加课程</title>
		<meta name="description" content="Blueprint: Tooltip Menu" />
		<meta name="keywords" content="Tooltip Menu, navigation, tooltip, menu, css, web development, template" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/component.css" />
		<link rel="stylesheet" type="text/css" href="../css/admin.css">
		<script src="../js/modernizr.custom.js"></script>
	</head>
	<body>
		<%@include file="admin_navigator.jsp"%>

		<div class="wrap">
			<form action="${pageContext.request.contextPath}/addCourseServlet">
				<div class="form-group controls">
					<input id="cno" name="cno" type="text" class="form-control floatLabel">
					<label for="cno">课程号</label>
				</div>
			  <div class="form-group controls">
			    <input id="cname" name="cname" type="text" class="form-control floatLabel">
			    <label for="cname">课程名称</label>
			  </div>

			  <div class="form-group controls">
			    <input id="cteacher" name="cteacher" type="text" class="form-control floatLabel">
			    <label for="cteacher">任课教师</label>
			  </div>
				<div class="form-group controls">
					<input id="ccredit" name="ccredit" type="text" class="form-control floatLabel">
					<label for="ccredit">学分</label>
				</div>

			  <div class="check">
			  	<input type="submit" class="btn" value="确定">
			  </div>
			</form>
		</div>


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
