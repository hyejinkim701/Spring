package aop02;

//** xml 방식의 공통적 관심 사항 구현 1.
// => 횡적 관심사항 ( cross concerns => Aspect )
// => 개별 advice 메서드 구현
//    Before, After_returning, After_throwing, After 

//** Boy, Girl => 핵심 관심사항 (core concerns) 만 구현하면 됨.

public class MyAspect {
	
	// 핵심적 관심사항 수행이전 _before
	public void myBefofre() {
		System.out.println("** 배 고파요 ~~~ => Before !!!");
	}
	// 핵심적 관심사항 정상종료
	public void myAfter_returning() {
		System.out.println("** 맛있게 먹기 => 핵심적 관심사항 정상종료 !!!");
	}
	// 핵심적 관심사항 비정상종료
	public void myAfter_throwing() {
		System.out.println("** 엄마한테 혼나요 ~~ => 예외 발생으로 핵심적 관심사항 비정상종료 !!!");
	}
	// 핵심적 관심사항 수행이후 _after
	// => 정상 종료이건, 비정상 종료이건 무조건시행
	public void myAfter() {
		System.out.println("** finally: 설겆이 하기 ~~ => 아무튼 최종 종료 !!");
	}
} // class
