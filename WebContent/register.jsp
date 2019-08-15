<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<style type="text/css">
.pTitle {
	display: block;
	height: 40px;
	padding: 40px;
	font-size: 30px;
	line-height: 40px;
	text-align: center;
	border-bottom: 1px solid #eee;
	overflow: hidden;
	background: #fff
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<%
				String action = request.getParameter("action");
			    if((action!= null?action:"").equals("add")){			    	
			%>
			   <div class="pTitle">新增</div>
			<%}else{%>
					
				<div class="pTitle">注册</div>
			  
			  <%} %>	
			<form action="registerServlet" method="post" name="registerForm"
				id="registerForm" class="form-horizontal" style="margin: 20px">
				<div class="form-group">
					<span>${requestScope.msg}</span> <label for="username"
						class="col-sm-offset-2 col-sm-2 control-label">账号</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" maxlength="18" value=""
							id="username" name="username" placeholder="字母，数字，下划线，长度不能超过18">
					</div>
				</div>
				<div class="form-group">
					<label for="password"
						class="col-sm-offset-2 col-sm-2 control-label">密码</label>
					<div class="col-sm-6">
						<input type="password" id="password" name="password"
							maxlength="15" class="form-control" placeholder="字母，数字组成">
					</div>
				</div>
				<div class="form-group">
					<label for="password"
						class="col-sm-offset-2 col-sm-2 control-label">确认密码</label>
					<div class="col-sm-6">
						<input type="password" id="confirmPwd" name="confirmPwd"
							maxlength="15" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="sex" class="col-sm-offset-2 col-sm-2 control-label">性别</label>
					<div class="col-sm-6">
						<label class="radio-inline"> <input type="radio"
							name="sex" id="sexM" value="0"> 男
						</label> <label class="radio-inline"> <input type="radio"
							name="sex" id="sexW" value="1"> 女
						</label>
					</div>
				</div>
				<div class="form-group">
					<label for="birthplace"
						class="col-sm-offset-2 col-sm-2 control-label">出生地</label>
					<div class="col-sm-6">
						<select class="form-control" name="birthplace" id="birthplace">
							<option value="SX">陕西</option>
							<option value="BJ">北京</option>
							<option value="SH">上海</option>
							<option value="SC">四川</option>
							<option value="HB">河北</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-6">
						<button type="submit" class="btn btn-success">注册</button>
					</div>
				</div>

			</form>
		</div>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>