<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
 div>span {
      color:red; font-style: italic; font-size:small;
      }
      
#header {
   background-color: #FFB4B4;
   width: 100%;
   height: 30px;
}

#btn_top {
   position: fixed;
   right: 2%;
   bottom: 50px;
   display: none;
   z-index: 9999;
   cursor: pointer;
}

body {
	background-color: linen
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

<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/axTest1.js"></script>
<script src="resources/jsLib/axTest2.js"></script>
<script src="resources/jsLib/axTest3.js"></script>
<script>
$(document).ready(function() {
   $(window).scroll(function(){
      // 상단 Header고정
      if($(this).scrollTop() > 0) {
         $('#header').css({
            position: "fixed",
            top: 0
         });
         $('#top_margin').show();
      }
      if($(this).scrollTop() > 300) {
         $('#btn_top').fadeIn();
      } else {
         $('#btn_top').fadeOut();
      }
   });
   $('#btn_top').click(function(){
      $('html,body').animate({
         scrollTop: 0
      },200);
   });
   
});
</script>

</head>
<body>
<h3>** Ajax Test Main Form **</h3>
<div id="header" align="center">
<span id=aloginf class=textLink>LOGIN </span>&nbsp;|&nbsp;
<span id=ajoinf class=textLink>JOIN </span>&nbsp;|&nbsp;
<span id=ploginf class=textLink>POPUPLOGIN </span>&nbsp;|&nbsp;
<span id=amlist class=textLink>AX MEMBERLIST </span>&nbsp;|&nbsp;
<span id=ablist class=textLink>AX BOARDLIST</span>&nbsp;|&nbsp;
<span id=jsloginf class=textLink>JS LOGIN</span>&nbsp;</div>


바바바바보보보보<br>
바바바바보보보보<br>
바바바바보보보보<br>
바바바바보보보보<br>
바바바바보보보보<br>
바바바바보보보보<br>
바바바바보보보보<br>
바바바바보보보보<br>

<hr>
<div id=resultArea></div>
<!-- <div id=resultArea2></div> -->
<div id="btn_top">
   <img src="resources/image/top_button.png" width=50/>
</div>
</body>
</html>