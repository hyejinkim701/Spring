package iocDI03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

// 스프링이 제공하는 BeanFactory => Spring 컨테이너
// => @ , Anotation 어노테이션 활용

interface TV {
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
}

//@Component("tv")
class LgTV implements TV {
	
	public LgTV() {
		System.out.println("** LgTV 생성 ~~");
	}
	
	public void powerOn() {
		System.out.println("** LgTV 전원 On");
	}
	public void powerOff() {
		System.out.println("** LgTV 전원 Off");
	}
	public void volumeUp() {
		System.out.println("** LgTV volumeUp");
	}
	public void volumeDown() {
		System.out.println("** LgTV volumeDown");
	}
} // LgTV
@Component("tv")
class SsTV implements TV {
	
	public SsTV() {
		System.out.println("** SsTV 생성 ~~");
	}
	
	public void powerOn() {
		System.out.println("** SsTV 전원 On");
	}
	public void powerOff() {
		System.out.println("** SsTV 전원 Off");
	}
	public void volumeUp() {
		System.out.println("** SsTV soundUp");
	}
	public void volumeDown() {
		System.out.println("** SsTV soundDown");
	}
} // SsTV

public class TVUser05_Ano01 {

	public static void main(String[] args) {
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext sc = new
			GenericXmlApplicationContext("iocDI03/applicationC05.xml") ;	
		
		// 2. 필요한 객체를 설정화일을 이용해서 Spring 컨테이너 에게 요청 
		// => Spring 컨테이너는 getBean 를 실행해서 해당객체를 제공
		TV tv = (TV)sc.getBean("tv") ;
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
		// 3. SingleTon Test 
		// => 스프링 프레임웤의 모든 작업은 싱글톤을 기본으로함.
		// => 싱글톤 (한개의 인스턴스만 허용 하는것) 적용 Test
		// => 각 TV 클래스에 생성자 추가 후,
		// => 설정화일의 scope 속성 에 "prototype" / "singleton" (default 는 싱글톤)
		// => 생성자가 한번 실행횟수와 아래의 주소값  확인
		
		
		sc.close();
	} // main
} // class
