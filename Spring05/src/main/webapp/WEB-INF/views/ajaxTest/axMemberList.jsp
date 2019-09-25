<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring_MVC Ajax_MemberList</title>
<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/axTest2.js"></script>
<script src="resources/jsLib/axTest1.js"></script> 
<style>


 body {
 background-color:Linen;
 }

 
 #btn { 

  padding: 5px 10px 5px 10px; 
  border: 5px solid pink; 
  background-color:#FFFCFC; 
  border-top-left-radius: 15px; 
  border-top-right-radius: 15px; 
  border-bottom-left-radius: 15px; 
  border-bottom-right-radius: 15px; 
   zoom: 1; 

 } 

 #btn:hover { 

  padding: 5px 10px 5px 10px; 
  border: 5px solid pink; 
  background-color: pink; 
  border-top-left-radius: 15px; 
  border-top-right-radius: 15px; 
  border-bottom-left-radius: 15px; 
  border-bottom-right-radius: 15px; 
  zoom: 1; 
  
  }
   table{border:1px solid #FFCBCB; border-collapse:collapse;}
 	td, th{border: 1px solid #FFCBCB;
</style>
</head>

<body>
<div align=center>
<h3>** Spring_MVC axMemberList_Mybatis **</h3>
<img src="resources/image/line.gif" width=800>
<table width=800>
<tr align="center" height=30 bgcolor="pink">
   <td>I D</td><td>Password</td><td>Name</td>
   <td>Lev</td><td>BirthDay</td><td>Pay</td>
   <td>Weight</td><td>Image</td>
</tr>
<c:forEach var="mm" items="${Banana}" varStatus="vs">
<tr align="center" height=30>
	<%-- <td><a href="#" onclick="axBoard('${mm.id}')">${mm.id}</a></td> --%>
	<td><span class='cc textLink' id='id${vs.index}'>${mm.id}</span></td>
	<td>${mm.password}</td><td>${mm.name}</td>
	<td>${mm.lev}</td><td>${mm.birthd}</td>
	<td><fmt:formatNumber value="${mm.pay}" pattern="##,###,###"/></td>
	<td>${mm.weight}</td>
	<td><img src="${mm.uploadfile}" width="50" height="50"/></td>
</tr>
</c:forEach>
</table><br>


<a href="home"><input id=btn type=button value='홈'></a>&nbsp;&nbsp;
<a href="#" onclick="history.back()"><input id=btn type=button value='이전으로'></a> <br><br>
<div id=resultArea2></div>
</div>
</body>
</html>