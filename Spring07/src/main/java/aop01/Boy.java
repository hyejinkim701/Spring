package aop01;

import java.util.Random;

public class Boy implements Person {
	@Override
	public void doSomething() {
		System.out.println("** 배 고파요~~~=>Before !!!");
		try {
			System.out.println("** 짜장면 만들기 => 핵심적 관심사항!!!");
			if( new Random().nextBoolean()) {
				//오류상황
				throw new Exception("~~ 몽땅 다 태웠다~~~");
			}
			System.out.println("** 맛있게먹기=> 핵심적 관심사항 정상종료!!");
		}catch(Exception e) {

			System.out.println("Boy Exception =>"+e.toString());
			System.out.println("** 엄마한테 혼나요~~~=> 예외 발생으로 핵심적 관심사항 비정상종료");
		}finally {
			System.out.println("** finally: 설거지 하기 ==> 아무튼 최종 종료!!");
		}
		
	}//dosomething
}//class
