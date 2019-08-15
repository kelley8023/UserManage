<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<table cellspacing="0" border="1" cellpadding="0" border="0" width="100%" align="center" id="infoTable">  
    <tr>  
  
        <td>内容1</td>  
        <td>内容2</td>  
        <td>内容3</td>  
        <td>内容4</td>  
    </tr>    
  
    <c:forEach items="${userInfoList}" var="people">  
        <tr>            
            <td>${people.username}</td>  
            <td>${people.username}</td>  
            <td></td>  
            <td></td>  
        </tr>  
    </c:forEach>  
</table>  