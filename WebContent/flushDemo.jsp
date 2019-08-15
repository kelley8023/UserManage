<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>局部刷新测试</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
   <%=request.getContextPath() %>
   <p>局部刷新获取数据</p>
   <p>局部刷新获取数据</p>
   <p>局部刷新获取数据</p>
   <p>局部刷新获取数据</p>
   
   <div id="userList"></div>
   
   <script type="text/javascript">
     var url = "<%=request.getContextPath() %>/index";
     //alert(url);
 	$("#userList").load(url);    
   </script> 
</body>
</html>