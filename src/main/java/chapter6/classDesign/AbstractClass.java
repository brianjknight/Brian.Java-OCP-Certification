package chapter6.classDesign;

public abstract class AbstractClass {
//	abstract String name = "Brian"; // only instance methods can be abstract
	String name = "Brian";
	
//	abstract AbstractClass() {} // only instance methods can be abstract
	
	public static void sayHi() {
		System.out.println("Hi");
	}
	
//	abstract static void sayHello(); // static methods cannot be abstract
	
	public abstract String getName();
	
	
}
