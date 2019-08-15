<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>页头</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
img {
	border: 0;
	vertical-align: top;
	margin: 0;
	padding: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<img src="img/qq_logo.png" alt="腾讯网" width="100%">
			</div>
			<!-- param:[user:zhangsan,id:20] -->
			<c:if test="${param.user != null}">
					<div class="col-md-7" style="padding: 10px">
						<ul class="nav nav-pills" style="float: right;">
							<li role="presentation" ><a href="#">Home</a></li>
							<li role="presentation"><a href="#">Profile</a></li>
							<li role="presentation"><a href="#">Messages</a></li>
							<li role="presentation"><a href="<%=request.getContextPath() %>/peopleList">用户管理</a></li>
						</ul>
					</div>
					<div class="col-md-2">
						<div class="btn-group" style="margin: 10px">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								${param.user}<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">修改密码</a></li>
								<li><a href="#">个人信息</a></li>
								<li><a href="#">书单列表</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">退出</a></li>
							</ul>
						</div>
					</div>


				</c:if>
			<!-- <div class="col-md-offset-7 col-md-2">
				
			</div> -->
		</div>
	</div>




</body>
</html>