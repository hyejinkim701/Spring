package aop03;

import org.aspectj.lang.ProceedingJoinPoint;

//** xml ����� ������ ���� ���� ���� 2. 
// => Ⱦ�� ���ɻ��� ( cross concerns => Ascept )
//** Around => method 1���� ó��
//=> Aspect �� Pointcut�� ��� Joinpoint�� �ƿ츣�� ����� 
//=> �ݵ�� joinPoint.proceed(); �� �ٽ��� ���ɻ����� ó��	

//** Joinpoint Ŭ����	
//=> �ٽɰ��ɻ������� ���� ��� ������ (before�� ����) ������
//	  ������ ������ ó���� �� �ֵ��� ����	
//** ProceedingJoinPoint : JoinPoint �� ��� ������ proceed() �޼��带 ����
//=> ���ܻ�Ȳ ó���ÿ�  Throwable ����ؾߵ�.
//=> ������ : Object -> Throwable -> Error,Exception 
public class MyAspect {
	public void myAround(ProceedingJoinPoint joinpoint) {
		// Before
		System.out.println("** �� ���Ŀ� ~~~ => Before !!!");
		try {
			// �ٽɻ���	
			joinpoint.proceed() ;
			// ��������	
			System.out.println("** ���ְ� �Ա� => �ٽ��� ���ɻ��� �������� !!!");
		}catch (Throwable e) {
			// �ٽɻ��� ����������
			System.out.println("** �������� ȥ���� ~~ => ���� �߻����� �ٽ��� ���ɻ��� ���������� !!!");
		}finally {
			// After
			System.out.println("** finally: ������ �ϱ� ~~ => �ƹ�ư ���� ���� !!");
		}
	} // myAround
} // class
