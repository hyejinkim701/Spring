package aop02;

import java.util.Random;
//=> �ٽ� ���ɻ��� (core concerns) �� �����ϸ� ��.
public class Boy implements Person {
	
	@Override
	public void doSomething() throws Exception {
		System.out.println("** ¥��� ����� => �ٽ��� ���ɻ��� !!!");
		// if (new Random().nextBoolean()) {
		if (false) {	
			// ������Ȳ
			throw new Exception("~~ Ȧ�� �� �¿��� ~~~") ;
		}
	} // doSomething()
} // class
