package chapter2.operators;

public class AssignmentOperators {

	public static void main(String[] args) {
		byte num = 6;
		byte two = num=2;
		long twotwo = (num=22);
		
		long other = twotwo=11;
		
		
		System.out.println("num:" + num);
		System.out.println("two:"+two);
		System.out.println("twotwo:"+twotwo);
		System.out.println("other:"+other);
		
	}
}
