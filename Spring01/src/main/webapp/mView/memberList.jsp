<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MyDispatcher MemberList **</title>
</head>
<body>
<h3>** Spring_MyDispatcher MemberList **</h3>
<img src="/Spring01/image/bar.gif">
<table width=800 border="1">
<tr align="center" height=30 bgcolor="pink">
   <td>I D</td><td>Password</td><td>Name</td>
   <td>Lev</td><td>BirthDay</td><td>Pay</td>
   <td>Weight</td>
</tr>
<c:forEach var="mm" items="${banana}">
   <tr align="center">
   <!-- 관리자 기능 추가 -->
   <c:if test="${loginID=='admin'}"><td><a href="/Spring01/mdetail.do?id=${mm.id}">${mm.id}</a></td></c:if>
   <c:if test="${loginID!='admin'}"><td>${mm.id}</td></c:if>
   
   <!-- 
   lev 옆에 한글로 등급표시, birthd는 '1999년 09월 09일'
   pay는 1,234,567로 출력되도록 수정
    -->
    <%-- <fmt:formatDate value="${mm.birthd}" pattern="yyyy년 MM월 dd일"/> --%>
    
   <td>${mm.password}</td><td>${mm.name}</td><td>${mm.lev}
   <c:choose>
      <c:when test="${mm.lev=='A'}"> VIP</c:when>
      <c:when test="${mm.lev=='B'}"> 나무</c:when>
      <c:when test="${mm.lev=='C'}"> 잎새</c:when>
      <c:when test="${mm.lev=='D'}"> 새싹</c:when>
      <c:otherwise> ERROR </c:otherwise></c:choose></td>
   <td>${mm.birthd}</td><td><fmt:formatNumber value="${mm.pay}" pattern="##,###,###"/></td><td>${mm.weight}</td>
   </tr>
   
</c:forEach>
</table>
</body>
</html>