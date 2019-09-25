package aop03;

import org.aspectj.lang.ProceedingJoinPoint;

//** xml 방식의 공통적 관심 사항 구현 2. 
// => 횡적 관심사항 ( cross concerns => Ascept )
//** Around => method 1개로 처리
//=> Aspect 와 Pointcut의 모든 Joinpoint를 아우르는 연결고리 
//=> 반드시 joinPoint.proceed(); 로 핵심적 관심사항을 처리	

//** Joinpoint 클래스	
//=> 핵심관심사항으로 들어가는 모든 데이터 (before를 통해) 사항을
//	  가지고 있으며 처리할 수 있도록 해줌	
//** ProceedingJoinPoint : JoinPoint 를 상속 했으며 proceed() 메서드를 가짐
//=> 예외상황 처리시에  Throwable 사용해야됨.
//=> 계층도 : Object -> Throwable -> Error,Exception 
public class MyAspect {
	public void myAround(ProceedingJoinPoint joinpoint) {
		// Before
		System.out.println("** 배 고파요 ~~~ => Before !!!");
		try {
			// 핵심사항	
			joinpoint.proceed() ;
			// 정상종료	
			System.out.println("** 맛있게 먹기 => 핵심적 관심사항 정상종료 !!!");
		}catch (Throwable e) {
			// 핵심사항 비정상종료
			System.out.println("** 엄마한테 혼나요 ~~ => 예외 발생으로 핵심적 관심사항 비정상종료 !!!");
		}finally {
			// After
			System.out.println("** finally: 설겆이 하기 ~~ => 아무튼 최종 종료 !!");
		}
	} // myAround
} // class
