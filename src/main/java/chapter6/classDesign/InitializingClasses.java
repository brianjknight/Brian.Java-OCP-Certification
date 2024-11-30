package chapter6.classDesign;

public class InitializingClasses {
	static {  // A
		System.out.println("static initializer A");
		printOneAndTwo();
		new InitializingClasses().print(); // does compile and run; call initialization first makes methods and default variables values available
		System.out.println();
	}

	{
		System.out.println("instance initializer");
		this.print();
		System.out.println();
	}
	
	static int one = 1;
	static int two = 2;
	
	static { // B
		System.out.println("static initializer B");
		printOneAndTwo();
		System.out.println();
	}
	
	static { // C
		System.out.println("static initializer C");
		// although class initialization creates memory space and default value for members, 
		// you cannot forward reference them directly
//		System.out.println("three = " + three); // does not compile; 
		printThree();  // however you can forward methods that use the variable
		System.out.println();
	}
	static int three; // not a final field
	
	static { // D
		System.out.println("static initializer D");
		System.out.println("three = " + three);
		printThree();
		System.out.println();
	}
	static { // E
		System.out.println("static initializer E");
		three = 3;
		printThree();
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("main method");
		new InitializingClasses();
	}
	
	
	// methods
	
	static void printOneAndTwo() {
		System.out.println("one = " + one);
		System.out.println("two = " + two);
	}
	
	static void printThree() {
		System.out.println("three = " + three);
	}
	
	void print() {
		System.out.println("instance method print()");
		System.out.println("one = " + one);
		System.out.println("two = " + two);
	}
}
