<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<style> 

body{
background-color:Linen
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
<meta charset="UTF-8">
<title>** Member DoFinish Spring MVC **</title>
</head>
<body>

<h3>** Member DoFinish Spring MVC **</h3>
<c:if test="${fCode=='D'}">
	<h3> 당신의 정보는 없습니다~~~</h3>
	<a href="loginf">로그인 하기</a>
</c:if>
<c:if test="${fCode=='U'}">
	<h3> 정보 수정에 실패했습니다~~~</h3>
	<a href="mlist">memberList</a>
</c:if>
<c:if test="${fCode=='JS'}">
	<h3>${joinID} 님 회원 가입 되었습니다~~</h3>
	<a href="loginf">로그인 하기</a>
</c:if>
<c:if test="${fCode=='JF'}">
	<h3>회원 가입 실패~~</h3>
	<h3>다시 하시겠습니까 ?</h3>
	<a href="joinf">[회원가입]</a>&nbsp;&nbsp;
	<a href="#" onclick="history.back()">[다시 하기]</a> 
</c:if>
<c:if test="${fCode=='DS'}">
	<h3>회원 탈퇴 되었습니다~~</h3>
</c:if>
<c:if test="${fCode=='DF'}">
	<h3>회원 탈퇴 실패~~</h3>
	<a href="javascript:history.go(-1)">[다시 하기]</a> 
</c:if>

<c:if test="${fCode=='BF'}">
	<h3>게시판 없음</h3>
	<a href="javascript:history.go(-1)">[Try Again]</a> 
</c:if>


<br>
<a href="home">HOME</a>
</body>
</html>