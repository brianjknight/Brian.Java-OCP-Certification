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
	
	// abstract methods cannot be private, final, or static
//	abstract static void sayHello();
//	final abstract void abstractVoid();
//	private abstract void abstractVoid();
	
	abstract void abstractVoid();

	abstract public String getName() throws FileNotFoundException; // exceptions are allowed
	
	protected abstract void abstractProtectedVoid();
}
