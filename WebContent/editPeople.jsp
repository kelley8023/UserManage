<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户编辑</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
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
	<c:import url="common.jsp?user=${username}" />
	<div class="container">
		<div class="row">
			<div class="pTitle">编辑</div>
			<form action="editPeople" method="post" name="updateForm"
				id="updateForm" class="form-horizontal" style="margin: 20px">
				<input type="hidden" name="id" value="${people.id}"/>
				<div class="form-group">
					<label for="username"
						class="col-sm-offset-2 col-sm-2 control-label">账号</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" maxlength="18"
							id="username" name="username" value="${people.username}"
							placeholder="字母，数字，下划线，长度不能超过18">
					</div>
				</div>

				<div class="form-group">
					<label for="sex" class="col-sm-offset-2 col-sm-2 control-label">性别</label>
					<div class="col-sm-6">
						 <c:if test="${people.sex == 0}">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="sexM" value="0" checked="checked"> 男
							</label>
							<label class="radio-inline"> <input type="radio"
								name="sex" id="sexW" value="1"> 女
							</label>
						</c:if>
						<c:if test="${people.sex == 1}">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="sexM" value="0"> 男
							</label>
							<label class="radio-inline"> <input type="radio"
								name="sex" id="sexW" value="1" checked="checked"> 女
							</label>
						</c:if> 


					</div>
				</div>
				<div class="form-group">
					<label for="birthplace"
						class="col-sm-offset-2 col-sm-2 control-label">出生地</label>
					<div class="col-sm-6">
						<select class="form-control" name="birthplace" id="birthplace">
							<option value="SX" >陕西</option>
							<option value="BJ">北京</option>
							<option value="SH">上海</option>
							<option value="SC">四川</option>
							<option value="HB">河北</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-6">
						<button type="submit" class="btn btn-success">更新</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	    var birthPlace = "${people.birthplace}";
	    
	    $("option").each(function(index) {
			if($(this).val() == birthPlace){
				$(this).attr("selected","selected");
				return false;
			}
		});
	    
	   /*  var selectOption = document.getElementById("birthplace");
	    chooseDefaultOption(selectOption,birthPlace);
	    
		function chooseDefaultOption(selectOptions, defaultValue) {
			for (var i = 0; i < selectOptions.options.length; i++) {
				if (selectOptions.options[i].value == defaultValue) {
					selectOptions.options[i].selected = true;
					break;
				}
			}

		} */
	</script>
</body>
</html>