<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC Employee List **</title>
</head>
<body>
<h3>** Spring_MVC Employee **</h3>
<img src="resources/image/line.gif">
<table width=800 border="1">
<tr align="center" height=30 bgcolor="pink">
	<td>I D</td><td>Password</td><td>Name</td>
	<td>Level</td><td>Enter</td><td>Gender</td>
	<td>Phone</td>
</tr>
<c:forEach var="mm" items="${banana}">
	<tr align="center" height=30>
	
<td><a href="edetail?id=${mm.id}">${mm.id}</td>
	<td>${mm.password}</td>
	<td>${mm.name}</td>
	<td>${mm.lev}</td>
	<td>${mm.enter}</td>
	<td>${mm.gender}</td>
	<td>${mm.phone}</td>

	</tr>
</c:forEach>
</table>

<a href="home">[HOME]</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="#" onclick="history.back()">[사원등록]</a> 
</body>
</html>

