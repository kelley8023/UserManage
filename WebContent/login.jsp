<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
#pManage {
	color: antiquewhite;
	font-size: 25px;
	font-weight: bold;
	text-align: center;
}

#registerButton {
	color: cornsilk;
	font-weight: bold;
	margin-right: 220px;
	margin-top: 10px;
	float: right;
}
</style>
</head>
<body style="margin: 20px">	
<c:import url="common.jsp"></c:import>
	<p id="pManage">用户管理系统</p>

	<div style="border: 2px solid #ccc;" class="col-sm-offset-2 col-sm-8 ">
		<span style="color: red">${message}</span>
		<form class="form-horizontal" action="login" method="post" id="userLogin"
			style="margin-top: 20px" name="uesrLogin">
			<div class="form-group">
				<label for="userName" class="col-sm-offset-2 col-sm-2 control-label">userName</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="username"
						name="username" placeholder="username">
					<%-- <span>${requestScope.userErrorMsg}</span> --%>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-offset-2 col-sm-2 control-label">Password</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="Password">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">登录</button>
					<div id="registerButton">
						<a href="register.jsp?"> <span>没有账号，请注册</span></a>
					</div>
				</div>
			</div>
		</form>
	</div>	
</body>
</html>