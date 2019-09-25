package iocDI03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Speaker {
	public Speaker() {
		System.out.println("***Speaker ����~~");
	}
	
	public void volumeUp() {
		System.out.println("** Speaker volumeUp");
	}

	public void volumeDown() {
		System.out.println("** Speaker volumeDown");
	}
} // Speaker

//DI : ������ ���� -> �ܺο��� Control -> (������ ���� :IOC)
@Component("tv1")
class LgTVs implements TV {
// Test1. ������ ��� : ���� ����	
	Speaker sp = new Speaker();

	public LgTVs() {
		System.out.println("** LgTVs ���� ~~");
	}

	public void powerOn() {
		System.out.println("** LgTV ���� On");
	}

	public void powerOff() {
		System.out.println("** LgTV ���� Off");
	}

	public void volumeUp() {
		sp.volumeUp();
	}

	public void volumeDown() {
		sp.volumeDown();
	}

} // LgTV

// Test2. �����ڸ� ���� ����
@Component("tv2")
class SsTVs implements TV {
	//��� ������ ���� ������ �ּҰ��� ����
	@Autowired //�ڵ� ����
	Speaker sp ;
	//Speaker sp = new.Speaker();
	// =: @Autowired
	// new Speaker() : @component, ������
	
	int price ;
	String sno ;

	public SsTVs() {
		System.out.println("** SsTVs ���� ~~");
	}

	public SsTVs(Speaker sp, String sno, int p) {
		this.sp = sp;
		this.price=p;
		this.sno=sno;
		System.out.println("** SsTVs ������ : Speaker���� ~~Price, sno =>"
							+price+" , "+sno);
	}

	public void powerOn() {
		System.out.println("** SsTV ���� On");
	}

	public void powerOff() {
		System.out.println("** SsTV ���� Off");
	}

	public void volumeUp() {
		sp.volumeUp();
	}

	public void volumeDown() {
		sp.volumeDown();
	}
} // SsTV

//Test3. Setter �޼��带 ���� Speaker�� ���� �ޱ�
// => Speaker �� ���� �ޱ����� Setter �޼��� �߰�
// => ����ȭ�Ͽ� �±� �߰�
// setter �޼���� <bean> ���� ���� �����̳ʰ� �ڵ� ȣ�� ��.
// �̶� �Ű������� ���� �������ָ� ��.
// -> <property> �� ����
@Component("tv3")
class AiTVs implements TV {
	
	@Autowired //������ �����ʰ� ���Ը� ���ִ� ������!
	private Speaker sp;
	private int price;
	
	public AiTVs() {
		System.out.println("** AiTVs �⺻ ������  ~~~");
	}
	public void setSpeaker(Speaker sp) {
		System.out.println("** AiTVs : Speaker �� ���� �ޱ����� Setter  ~~~");
		this.sp = sp;
	}
	public void setPrice(int price) {
		System.out.println("** AiTVs : price �� �� ���� �ޱ����� Setter  ~~~");
		System.out.println("** AiTVs Setter price =>" + price);
		this.price = price;
	}
	public void powerOn() {
		System.out.println("** AiTVs ���� ON ~~~");
	}
	public void powerOff() {
		System.out.println("** AiTVs ���� OFF ~~~");
	}
	public void volumeUp() {
		sp.volumeUp();
	}
	public void volumeDown() {
		sp.volumeDown();
	}
} // SsTVs

public class TvUser06_Ano02 {

	public static void main(String[] args) {
		AbstractApplicationContext sc = new GenericXmlApplicationContext("iocDI03/applicationC05.xml");
		System.out.println("** Test 1 : ������ ��� (���� ����)");
		TV tv = (TV) sc.getBean("tv1");
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		System.out.println("** Test 2 : �����ڸ� ���� ����");
		TV tvs = (TV) sc.getBean("tv2");
		tvs.powerOn();
		tvs.volumeDown();
		tvs.volumeUp();
		tvs.powerOff();
		System.out.println("** Test 3 : setter �޼��带 ���� ����");
		TV tva = (TV) sc.getBean("tv3");
		tvs.powerOn();
		tvs.volumeDown();
		tvs.volumeUp();
		tvs.powerOff();

		sc.close();
	} // main
} // class
