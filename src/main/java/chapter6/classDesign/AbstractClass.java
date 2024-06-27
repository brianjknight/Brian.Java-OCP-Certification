package chapter6.classDesign;

import java.io.FileNotFoundException;

public abstract class AbstractClass {
//	abstract String name = "Brian"; // only instance methods can be abstract
	String name = "Brian";
	static int age = 39;
	int num = 10;
	
//	abstract AbstractClass() {} // only instance methods can be abstract
	
	// constructors are allowed
	AbstractClass() {}
	// Abstract classes follow same rules for initialization
	
	public static void sayHi() {
		System.out.println("Hi");
	}
	
//	abstract static void sayHello(); // static methods cannot be abstract
	
	public abstract String getName() throws FileNotFoundException; // exceptions are allowed
	
	abstract void abstractVoid();
//	final abstract void abstractVoid(); // cannot be final
//	private abstract void abstractVoid();
	protected abstract void abstractProtectedVoid();
}
