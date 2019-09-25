<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<html>
<head>
<style> 
body {
	background-color:linen

}

 #btn { 

  padding: 5px 10px 5px 10px; 

  border: 5px solid pink; 

  background-color: white; 

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

</style> 
	<title>Home</title>
</head>
<body>
<div align="center">
<h1>Hello Spring MVC !!! </h1>
<P>  현 서버의 시간은 ${serverTime} 입니다. </P>

<img src="resources/image/xxx.gif" width="300"><br><br><br><br>
<c:if test="${loginID==null}"> &nbsp;&nbsp;
	<a href="loginf"><input id=btn type=button value='로그인'></a>
</c:if>
&nbsp;&nbsp;
<c:if test="${loginID!=null}"> &nbsp;&nbsp;
	<a href="logout"><input id=btn type=button value='로그아웃'></a>&nbsp;&nbsp;
</c:if>


<a href="joinf"><input id=btn type=button value='회원가입'></a>&nbsp;&nbsp;

<a href="mlist"><input id=btn type=button value='회원목록'></a> &nbsp;&nbsp;
<a href="blist"><input id=btn type=button value='게시판'></a>  &nbsp;&nbsp;
<a href="plist"><input id=btn type=button value='게시판2'></a> &nbsp;&nbsp;
<a href="plist2"><input id=btn type=button value='게시판3'></a> &nbsp;&nbsp;
</div>
</body>
</html>
