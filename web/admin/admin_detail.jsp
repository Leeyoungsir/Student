<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/7/21
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/component.css" />
    <link rel="stylesheet" type="text/css" href="../css/admin.css">
    <script src="../js/modernizr.custom.js"></script>
</head>
<body>
<%@include file="admin_navigator.jsp"%>
<div class="wrap">
    <form action="${pageContext.request.contextPath}/AdminUpdateServlet">
        <input type="hidden" name="id" value="${sessionScope.user.id}">
        <div class="form-group controls">
            <input id="username" name="username" value="${sessionScope.user.username}" type="text" class="form-control floatLabel">
            <label for="username">用户名</label>
        </div>
        <div class="form-group controls">
            <input id="password" name="password" value="${sessionScope.user.password}" type="password" class="form-control floatLabel">
            <label for="password">密码</label>
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
