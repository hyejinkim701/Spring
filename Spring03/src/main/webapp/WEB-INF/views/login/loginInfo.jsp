<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Login Info Spring MVC **</title>
</head>
<body>
 
<h3>** Login Info Spring MVC **</h3>
session ID : <%=session.getId()%><br>
session 유효시간 설정 : 10초 설정<br>
=> session 객체의 메서드  또는  web.xml 에서 <br><br>
<% session.setMaxInactiveInterval(10);%>
=> 강사 PC 에 접근하여 Test 해 보세요 ~~~<br>
 
</body>
</html>