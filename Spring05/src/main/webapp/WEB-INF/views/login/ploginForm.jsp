<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** PopUp Login Form **</title>
</head>
<body>

<h3>** PopUp Login Form **</h3>
<form action="plogin" method="post">
	User ID : 
	<input type="text" id="id" name="id" value="banana"><br>
	Password:
	<input type="text" id="password" name="password" value="12345"><br>
	<input type="submit" value="popLogin"><br>
</form>
<div>
	<c:if test="${loginR=='T'}">
		부모창에 alert로 로그인 성공 메세지 출력 후 현재창 닫기
		안녕하세요 ~~ ${id} 님!!!
		<script>
		opener.alert("${id} 님이 로그인 했습니다. !!!");
		self.close();
		</script>
	</c:if>
	<c:if test="${loginR=='F'}">
	${id}님 로그인 실패!!!<br>
	다시하세요! <br>
	</c:if>
</div>
</body>
</html>