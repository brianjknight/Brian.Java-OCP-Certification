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
		System.out.println();
		
		int k = 1;
		k += 3 + ++k;
//		k = k + 3 + ++k;
//		k = k + 3 * ++k;
//		k = k + 3 + (++k); // k on left is not updated even though ++k is in parenthesis; different than explicitly reassigning?
//		k = ++k + 3 + k; // ++k is considered to happen first here
		System.out.println("k = " + k);
		
		Integer v = 1;
		Integer x = v;
		x += 3 + ++x; // kk = 1 + 3 + 2 
		System.out.println("x = " + x);
		System.out.println("v = " + v); // unary operator on a wrapper returns a new wrapper object
		
		int m = 1;
		m += 3 * ++m; // m = m + 3 * ++m;
		System.out.println(m);
		
		boolean bool = false;
//		bool ? "true" : "false";
		String result = bool ? "true" : "false";
//		String bad = bool ? "true" : System.out.println("false");
		
	}
}
