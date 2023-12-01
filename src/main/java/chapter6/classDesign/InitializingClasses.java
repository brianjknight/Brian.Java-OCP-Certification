package chapter6.classDesign;

public class InitializingClasses {
	static int one = 1;
	static int two = 2;
	
	// rule is static variables initialized before static initializers
	// however you still cannot reference static variable before it is declared
	static {
		System.out.println("static initializer A");
//		System.out.println("three = " + three); // does not compile
	}
	static int three;
	
	static {
		System.out.println("three = " + three);
		three = 3;
	}
	static {
		System.out.println("three = " + three);
	}
	
	public static void main(String[] args) {
		System.err.println("main method");
	}
}
