<%@page import="com.bean.People"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<%--
   
    <%@ include file="inlayingJsp.jsp" %>  

　　 <jsp:include   page="inlayingJsp.jsp" flush="true"/> 

--%>

	<c:import url="common.jsp?user=${username}">
		<%-- <c:param name="username" value="${username}" /> --%>
	</c:import>

	<div class="container">
		<div class="row">
			<div class="col-md-offset-1 col-md-10">
				<span style="font-size: 18px; font-weight: bold;">用户列表</span>
				<div class="pull-right">
					<a href="register.jsp?" class="btn btn-primary"> <span
						class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增
					</a>
				</div>
				当前页数据条目： 
				<select name="count">
					<option>10</option>
					<option>20</option>
					<option>50</option>
				</select>
				<hr style="border-top-width: 2px">
				
				<span style="color: red;">${message}</span>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>账号</th>
							<th>密码</th>
							<th>性别</th>
							<th>出生地</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${peopleList}" var="people">
							<tr>
								<td>${people.username}</td>
								<td>******</td>
								<td><c:if test="${people.sex == 0}">
							     男
							  </c:if> <c:if test="${people.sex ==1}">
							     女
							  </c:if></td>
								<td><c:choose>
										<c:when test="${people.birthplace == 'BJ' }">
									   北京
									</c:when>
										<c:when test="${people.birthplace == 'HB' }">
									   河北
									</c:when>
										<c:when test="${people.birthplace == 'SH' }">
									   上海
									</c:when>
										<c:otherwise>
									    陕西
									</c:otherwise>
									</c:choose></td>
								<td><a class="btn btn-success"
									href='<c:url value="/editPeople?id=${people.id}"/>'> <span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
								</a> 
								
								<%-- href='<c:url value="/deletePeople?id=${people.id}"/>' --%>
								<a class="btn btn-danger" peopleId="${people.id}" peopleName="${people.username}" id="deletePeople_${people.id}">
								   <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
								</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="<c:url value="/peopleList?page=1"/>">首页</a></li>
						<li><a
							href="<c:url value="/peopleList?page=${currentPage>1?(currentPage-1):1}"/>"
							aria-label="Previous"> <span aria-hidden="true">上一页</span>
						</a></li>
						<c:forEach begin="1" end="${totalPage}" varStatus="loop">
							<li class="${loop.index == currentPage?'active':''}"><a
								href="<c:url value="/peopleList?page=${loop.index}"/>">${loop.index}</a></li>
						</c:forEach>
						<li><a
							href="<c:url value="/peopleList?page=${currentPage < totalPage ?(currentPage+1):totalPage}"/>"
							aria-label="Next"> <span aria-hidden="true">下一页</span>
						</a></li>
						<li class="page-item"><a class="page-link"
							href="<c:url value="/peopleList?page=${totalPage}"/>">尾页</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	    $("a[id^='deletePeople_']").click(function () {
			//console.log($(this).attr("peopleId"));
			//attr()方法标签中属性的值
			var pId= $(this).attr("peopleId");
			if(confirm("您确定要删除"+$(this).attr("peopleName")+"?")){
				window.location.href="<%=request.getContextPath() %>/deletePeople?id="+pId;
			}
		})
	
	</script>
</body>
</html>