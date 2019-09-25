<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Employee DoFinish Spring MVC **</title>
</head>
<body>
<h3>** Employee DoFinish Spring MVC **

	

<c:if test="${fCode=='U'}">
	<h3> 정보 수정에 실패했습니다.</h3>
	<a href="elist">employeeList</a>
</c:if>
<c:if test="${fCode=='JS'}">
	<h3>${joinID} 님 사원 등록 되었습니다~~</h3>
	
</c:if>
<c:if test="${fCode=='JF'}">
	<h3>사원 등록 실패~~</h3>
	<h3>다시 하시겠습니까 ?</h3>
	<a href="joinf">[사원등록]</a>&nbsp;&nbsp;
	<a href="#" onclick="history.back()">[다시 하기]</a> 
</c:if>
<c:if test="${fCode=='DS'}">
	<h3>정보 삭제 되었습니다</h3>
</c:if>
<c:if test="${fCode=='DF'}">
	<h3>정보 삭제 실패~~</h3>
	<a href="javascript:history.go(-1)">[다시 하기]</a> 
</c:if>
<br>
<a href="home">HOME</a>
</body>
</html>