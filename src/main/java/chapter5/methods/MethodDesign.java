package chapter5.methods;

public class MethodDesign {
	public static void main(String[] args) {
		
	}
	
	void doNothing() {	
	}
	
//	default void nothing() {
//	}
	
//	package void notValid() {
//	}
	
	public static void method1() {
	}
	static public void method2() {
	}
	
	void method4() {
		return;
	}
	// does not compile
//	void method5() {
//		return "hello";
//	}
	
	// compiles but with unreachable code
	public String method6(int x) {
		if (5<10) return "less";
		return "greater";
	}

	
}	
