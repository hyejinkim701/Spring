<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Member Join Spring Image**</title>
<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/inCheck2.js"></script>
<script src="resources/jsLib/axTest1.js"></script>
<script>
//1. ID 중복 확인하기
//1) ID 입력 오류 확인 : 길이, 영문과 숫자만 입력 가능
//2) 중복 확인 요청 (서버로)
//3) 요청 결과에 따른 처리
//=> 중복이면 : id 다시입력 중복확인 ..반	복
//=> 사용가능 : 사용 여부 확인 
//  -> yes : joinForm 에서  pw입력 ..,
//  -> no : 재 선택
//2),3) 실행 => 요청 
//-> 서버의 서블릿 (Controller) -> DB 확인 -> 결과 Page

function idDupCheck(){
	
	document.getElementById('sss').disabled="";
	if(idCheck()==false) return;
	
	//window.open()
	//=> 자바스크립트에서 새창을 띄워주는 함수
	//=> window.open("[요청명]","[창이름 또는 로딩되는 창]","[창 속성]")
	var url='idcheck?id='+$('#id').val();
	
	window.open(url,"_blank"
		,"toolbar=no,menubar=yes,scrollbars=yes,resizable=yes,width=450,height=300");
	
}; // idDupCheck 



function idCheck(){
	alert("중복 된 ID인지 확인하시겠습니까?");
// id 확인	
	var id=$('#id').val();
	// id : 길이확인 (4이하 오류)
	if (id.length<4) {
		$('#iMessage').text('ID 를 4글자 이상 정확하게 입력 하세요 ~~**') ;
		$('#id').focus() ;  // 해당태그에 focus In
		return false ;
	}else if (id.replace(/[a-z.0-9]/gi,'').length>0) {
		$('#iMessage').text('ID 를 영문자와 숫자로만 정확하게 입력 하세요 ~~~') ;
		$('#id').focus() ;  // 해당태그에 focus In
		return false ;
	}
		
		$('#iMessage').text('') ;
		 //return true ;
	 
}

// 2. 입력 오류 : 
//=> 입력 했는지 여부 확인하기
//=> password ~ weight
//** 실습 => input Tag 에 id 부여하고 function 작성

</script>

</head>
<style>
 span {
      color:red; font-style: italic; font-size:x-small;
      }
		
 body {
    background-color:linen;
 }
 </style>
<body>
<div align="center">
<h3>** memberJoin [InCheck & IDdup & Image] **</h3>
<form id=myForm action="mjoin"  method="post" enctype="multipart/form-data">
<!-- => enctype="multipart/form-data" : 화일 upload 를 가능하게 해줌 -->
<table>
<tr height="40"><td bgcolor="FFCC00">I D</td>
	<td><input type="text" id="id" name="id" value="">
		<input type="button" value="ID 중복확인" onclick="idDupCheck()"><br>
	<span id=iMessage></span></td></tr>
<tr height="40"><td bgcolor="FFCC33">Password</td>
	<td><input type="password" id="password" name="password" value=""><br>
	<span id=pMessage></span></td></tr>
<tr height="40"><td bgcolor="silver">Password</td>
	<td><input type="password" id="password2" name="password2"><br>
	<span id=pwMessage></span></td></tr>
	
	
<tr height="40"><td bgcolor="FFCC33">Name</td>
	<td><input type="text" id="name" name="name" value=""><br>
	<span id=nMessage></span></td></tr>
<tr height="40"><td bgcolor="FFCC99" >Level</td>
	<td>  
	<!-- input Tag 를 select 로 변경하기 -->
	<!-- <input type="text" name="lev" value=""> -->
	  <select name=lev>
		<option value="A">관리자</option>
		<option value="B">나무</option>
		<option value="C">잎새</option>
		<option value="D">새싹</option>
	  </select>
	  <span id=lMessage></span>
	</td></tr>
<tr height="40"><td bgcolor="FFCC99">BirthDay</td>
	<td><input type="date" id="birthd" name="birthd" value=""><br>
	<span id=bMessage></span></td></tr>
<tr height="40"><td bgcolor="FFCC99">Pay</td>
	<td><input type="text" id="pay" name="pay" value=""><br>
	<span id=ppMessage></span></td></tr>
<tr height="40"><td bgcolor="#FFE08C">Weight</td>
	<td><input type="text" id="weight" name="weight" value=""><br>
	<span id=wMessage></span></td></tr>
<tr height="40"><td bgcolor="#FFE08C">Image</td>
	<td><input type="file" name="uploadfilef"></td></tr>

	
<tr><td></td><td><input type="submit" value="가입" onclick="return insertCheck()"
               disabled="disabled" id="sss">
&nbsp;&nbsp;&nbsp;
                 <input type="reset" value="취소">
                 <input type="button" value="AJoin" id=ajoin></td>   
<tr><td></td><td><a href="home"><input id=btn type=button value='HOME'></a>


</table>
</form>
</div>
</body>
</html>