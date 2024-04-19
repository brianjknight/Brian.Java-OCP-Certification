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
		
		
		int k = 1;
		k += 3 + ++k;
//		k = k + 3 + ++k;
//		k = k + 3 * ++k;
//		k = k + 3 + (++k); // k on left is not updated even though ++k is in parenthesis; different than explicitly reassigning?
//		k = ++k + 3 + k; // ++k is considered to happen first here
		System.out.println(k);
		
		int m = 1;
		m += 3 * ++m; // m = m + 3 * ++m;
		System.out.println(m);
	}
}
