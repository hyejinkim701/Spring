package aop02;

import java.util.Random;
//=> �ٽ� ���ɻ��� (core concerns) �� �����ϸ� ��.
public class Girl implements Person {
	@Override
	public void doSomething() throws Exception {
		System.out.println("** «�� ����� => �ٽ��� ���ɻ��� !!!");
		//if (new Random().nextBoolean()) {
		if (true) {	
			// ������Ȳ
			throw new Exception("~~ Ȧ�� �� �¿��� ~~~") ;
		}
	} // doSomething()
} // class
