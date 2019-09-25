/*
	
	var iCheck=false ;
	var pCheck=false ;
	var nCheck=false ;	
	var ppCheck=false;
	var wCheck=false;
	var bCheck=false;
	var idCheck=false;
	var pwCheck=false;
	var lCheck=false;

	$(function() {
		
	 	 var password='';
		 // password
		 $('#password').focusout(function() {
			 password=$('#password').val();
			 var pLength=password.length;
			 if (password.length<4) {
				 	$('#pMessage').text('Password 를 4글자 이상 정확하게 입력 하세요 ~~');
					$('#password').focus() ;   
					pCheck=false ;
			 }else if (password.replace(/[!-*]/g,'').length>=pLength) {
					$('#pMessage').text('password는 특수문자를 반드시 입력해야 됩니다 ~~~');
					$('#password').focus();  
					pCheck=false ;
			 }else if (password.replace(/[!-*.0-9]/g,'').length>0) {
					$('#pMessage').text('password는 숫자와 특수문자로만 정확하게 입력하세요 ~~~');
					$('#password').focus();
					pCheck=false ;
			 }else {
					pCheck=true ;
					$('#pMessage').text('') ;
				} 
		  }); // password
		  
		 // password2 와 동일성 확인 기능 추가
		 $('#password2').focusout(function() {
			 var password2=$('#password2').val();
			
			
			 if (password!=password2) {
				 	$('#pwMessage').text('password1, 2가 다릅니다~~\정확하게 입력하세요 ~~~');
					$('#password2').focus() ;   
					pwCheck=false;
			  
			 };
		 
		 });// password2
		 
		 
		 
		 
		 // name
		 var name='';
		 $('#name').focusout(function() {
			 name=$('#name').val();
			 if (name.length<2) {
				 	$('#nMessage').text('Name을  2글자 이상 정확하게 입력 하세요 ~~') ;
					$('#name').focus() ;   
					nCheck=false ;
			 }else if (name.replace(/[가-힣.a-z]/gi,'').length>0) {
				 	$('#nMessage').text('Name을  한글과 영문으로만 정확하게 입력 하세요 ~~') ;
					$('#name').focus() ;   
					nCheck=false ;
			 }else {
					nCheck=true ;
					$('#nMessage').text('') ;
				} 
		  }); // name
		 
		 //level
		 $('#lev').focusout(function() {
			 var lev=$('#lev').val();
		 if (lev.length<0) {
			 $('#lMessage').text('level을 입력하세요.') 
				$('#lev').focus();
				lCheck=false;
				
			}//level
		 });
		 
		 
		 // birthday
		 $('#birthday').focusout(function() {
			 var birthday=$('#birthday').val();
			
			 if (weight.length<1 || $.isNumeric(weight)==false) {
				 	$('#bMessage').text('birthday를 정확하게 입력하세요.') ;
					$('#birthday').focus() ;   
					bCheck=false ;	
					
			 }else if(parseFloat(weight)<20 || parseFloat(weight)>200){
	
					 $('#bMessage').text('birthday의 값이 범위를 벗어납니다.') ;
					 $('#birthday').focus() ; 
					 bCheck=false ;	
					 
			 }else  {
					bCheck=true ;
					$('#bMessage').text('') ;
				} 
		  }); // birthday
		 
		 
		   var pay='';
	       $('#pay').focusout(function() {
	        
	          pay=$('#pay').val();
	          var paLength=pay.length ;
	         
	          if (pay.length<1 || $.isNumeric(pay)==false ) {
	        	
	               $('#ppMessage').text('pay를 정확하게 입력하세요 ') ;
	               $('#pay').focus() ;   
	               ppCheck=false ;
	             
	          } else if(pay.replace('.','').length < paLength) {
	        	
	            $('#ppMessage').text('pay 를 정수로 정확하게 입력하세요 ~~~') ;   
	          $('#pay').focus();
	          ppCheck=false ;
	          }else {
	        	
	               ppCheck=true ;
	               $('#ppMessage').text('') ;
	            } 
	        }); // pay
			  
		 // weight
		 $('#weight').focusout(function() {
			 var weight=$('#weight').val();
				
			 if (weight.length<1 || $.isNumeric(weight)==false) {
				 	$('#wMessage').text('weight를 정확하게 입력하세요.') ;
					$('#weight').focus() ;   
					wCheck=false ;	
					
			 }else if(parseFloat(weight)<20 || parseFloat(weight)>200){
		
					 $('#wMessage').text('weight의 값이 범위를 벗어납니다.') ;
					 $('#weight').focus() ; 
					 wCheck=false ;	
						 
			 }else  {
					wCheck=true ;
					$('#wMessage').text('') ;
				} 
		  }); // weight
			  
			  
		}) // ready	
		
	// 3) 전체적으로 입력 오류 가 없음을 확인하고 submit 여부를 판단하는 function
		function insertCheck() {
	
			if (iCheck==true && pCheck==true && nCheck==true && ppCheck==true && wCheck==true && pwCheck==true && lCheck==true && bCheck==true
					&& idCheck==true) 
				 return true;   // submit 진행
			
			else {
				alert('입력 자료에 오류가 있습니다.~~\n확인 후 전송 버튼을 누르세요 ~~') ;
				return false ; // submit 무효화
			}
		}; // inputCheck

*/
	
	
	
