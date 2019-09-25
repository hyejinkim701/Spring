<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Board Insert **</title>
</head>
<style>
 
 body {
 background-color:Linen
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
</style>
<body>
<h3>** Board Insert **</h3>
<form action="binsert" method="post">
<table>
  <tr><td bgcolor="FFCC66">I  D</td>
      <td><input type="text" name="id" value="${loginID}" readonly="readonly">
  </td></tr>
  <tr><td bgcolor="FFCC66">Title</td>
      <td><input type="text" name="title" value="">
  </td></tr>
  <tr><td bgcolor="FFCC66">Content</td>
      <td><textarea name="content" rows="10" cols="40"></textarea>
  </td></tr>
  <tr><td></td>
  	  <td><input type="submit" value="글등록">&nbsp;
  	      <input type="reset"  value="Reset">
  </td></tr>
</table>
</form><br>
<a href="blist"><input id=btn type=button value='게시판'></a>&nbsp;
<a href="home"><input id=btn type=button value='홈'></a>
</body>
</html>