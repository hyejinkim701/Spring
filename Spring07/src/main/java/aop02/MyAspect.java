package aop02;

//** xml ����� ������ ���� ���� ���� 1.
// => Ⱦ�� ���ɻ��� ( cross concerns => Aspect )
// => ���� advice �޼��� ����
//    Before, After_returning, After_throwing, After 

//** Boy, Girl => �ٽ� ���ɻ��� (core concerns) �� �����ϸ� ��.

public class MyAspect {
	
	// �ٽ��� ���ɻ��� �������� _before
	public void myBefofre() {
		System.out.println("** �� ���Ŀ� ~~~ => Before !!!");
	}
	// �ٽ��� ���ɻ��� ��������
	public void myAfter_returning() {
		System.out.println("** ���ְ� �Ա� => �ٽ��� ���ɻ��� �������� !!!");
	}
	// �ٽ��� ���ɻ��� ����������
	public void myAfter_throwing() {
		System.out.println("** �������� ȥ���� ~~ => ���� �߻����� �ٽ��� ���ɻ��� ���������� !!!");
	}
	// �ٽ��� ���ɻ��� �������� _after
	// => ���� �����̰�, ������ �����̰� �����ǽ���
	public void myAfter() {
		System.out.println("** finally: ������ �ϱ� ~~ => �ƹ�ư ���� ���� !!");
	}
} // class
