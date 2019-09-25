<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<style>
* {cursor: url(http://cur.cursors-4u.net/cursors/cur-9/cur271.cur), auto !important;}

body {
   background-color: #FDF5E6
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
div.snow {
   position : absolute;
   font-size : 40px;
   color : white;
   padding : 0px;
   margin : 0px;
}

</style>
<title>Home_Mybatis</title>
<script>
var snow = new Array(10);               // 눈송이 30개에 대한 배열
var x = new Array(10);                  // 눈송이 각각의 x좌표
var y = new Array(10);                  // 눈송이 각각의 y좌표
var speedOfFall = new Array(90);            // 눈송이의 낙하하는 속도
var speedOfwind = new Array(10);             // 떨어지며 풍속의 영향을 받는 정도
var step = new Array(90);                   // 풍속영향력의 변화도

function fall() {
   for(i=0; i<30; i++){
      y[i] += speedOfFall[i]              //눈송이의 다음 y좌표
      x[i] += Math.cos(speedOfwind[i]);     //눈송이의 다음 x좌표, 코사인함수곡선을 이용
      if(y[i] >= window.innerHeight-90) {  //땅에 닿은 눈송이에 대해 새로운 눈송이를 생성
         x[i] = Math.floor(Math.random()*window.innerWidth);      
         y[i] = 0;
         speedOfFall[i] = Math.random()*2+2;               
      }

      if(x[i] >= window.innerWidth-50) x[i] = window.innerWidth - 50;  //브라우저의 크기를 넘어가는 눈송이에 대한 처리
      else if(x[i] < 0) x[i] = 50;
      
      snow[i].style.top = y[i] + "px";     
      snow[i].style.left = x[i] + "px";

      speedOfwind[i] += step[i]; 
   }
   setTimeout("fall()",50);
   setClock();
}
</script>
<script type="text/javascript">
function setClock(){
   var now= new Date();
   var t ='DateTime: '+now.getFullYear()+'년'+(now.getMonth()+1)+'월'+now.getDate()+'일'+
         '_'+now.getHours()+':'+now.getMinutes()+':'+now.getSeconds() ;
   document.getElementById("clock").innerHTML=t;
   setTimeout("setClock()",1000)
   
}

</script>
</head>
<body onload="fall()">
<script>
makeSnow(); // 문서가 로딩되는 단계에서 눈(*)을 출력하는 <div> 객체 생성

function makeSnow() {
   // window.innerHeight는 현재 윈도우의 브라우저 영역의 높이
   // window.innerWidth는 현재 윈도우의 브라우저 영역의 폭
   
   for(var i=0; i<30; i++) { // 30 개의 눈송이 생성
      x[i] = Math.floor(Math.random()*window.innerWidth-10);       //눈송이의 x좌표 지정
      y[i] = Math.floor(Math.random()*window.innerHeight+10);    //최초 눈송이의 y좌표 지정
      speedOfFall[i] = Math.random()*2+2;               //눈송이의 낙하속도 지정
      speedOfwind[i] = 1;                               //최초 바람의 영향
      step[i] = Math.random()*0.1+0.05;                 // 눈송이가 받는 바람의 영향의 변화도
      
      // <div id="snowobj012...">*</div> 생성
      var divtag = "<div class='snow' id=snowobj" + i
               + " style='top:" + x[i] + "px;left:" + y[i] + "px'>*</div>";
      document.write(divtag);
      
      // <div> DOM 객체 기억
      snow[i] = document.getElementById("snowobj"+i)
   }
}
</script>
   <div align="center">
      <h1>Hello Spring MVC !!!</h1>
      <h5 id=clock>DateTime</h5>

      <img src="resources/image/xxx.gif" width="300"><br>
      <br>
      <br>
      <br>
      <c:if test="${loginID==null}"> &nbsp;&nbsp;
   <a href="loginf"><input id=btn type=button value='로그인'></a>
      </c:if>
      &nbsp;&nbsp;
      <c:if test="${loginID!=null}"> &nbsp;&nbsp;
   <a href="logout"><input id=btn type=button value='로그아웃'></a>&nbsp;&nbsp;
</c:if>

      <a href="joinf"><input id=btn type=button value='회원가입'></a>&nbsp;&nbsp;

      <a href="mlist"><input id=btn type=button value='회원목록'></a>
      &nbsp;&nbsp; <a href="blist"><input id=btn type=button value='게시판'></a>
      &nbsp;&nbsp; <a href="plist2"><input id=btn type=button value='게시판2'></a> 
      &nbsp;&nbsp; <a href="ajaxtest"><input id=btn type=button value='ajax테스트'></a>
      
<a href="http://www.cursors-4u.com/cursor/2011/12/01/light-red-pointer-2.html" target="_blank" title="Light Red Pointer"><img src="http://cur.cursors-4u.net/cursor.png" border="0" alt="Light Red Pointer" style="position:absolute; top: 0px; right: 0px;" /></a>
   </div>
</body>
</html>