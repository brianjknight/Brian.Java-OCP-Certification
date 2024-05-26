package chapter6.classDesign;

public class InitializingClasses {
	static int one = 1;
	static int two = 2;
	
	static {
		System.out.println("static initializer A");
//		System.out.println("three = " + three); // does not compile
	}
	static int three; // not a final field
	
	static {
		System.out.println("three = " + three);
	}
	static {
		three = 3;
		System.out.println("three = " + three);
	}
	
	public static void main(String[] args) {
		System.out.println("main method");
	}
}
