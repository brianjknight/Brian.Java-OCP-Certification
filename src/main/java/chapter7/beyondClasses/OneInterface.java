package chapter7.beyondClasses;

public non-sealed interface OneInterface extends MyFirstInterface {
	
	void divide();
	
	public default int multiply() {
		return 2*3;
	}
	
	private static void staticHelper() { // no implicit modifiers for private methods
		System.out.println("static helper");
	}
	
	static void caller() { // implicitly public for static methods
		staticHelper();
//		nonStaticHelper();
//		divide();
	}
	
	private void nonStaticHelper() { // no implicit modifiers for private methods
		staticHelper();
		
		divide();
	}
	
//	private void nothing(); // private cannot be abstract so must have a body
	
	default int doMath() { // implicitly public for default method
		staticHelper();
		divide(); // access to an abstract method not yet implemented
		return 1 + 2;
	}
	
	// if not declared private, default, or static methods are implicitly abstract
	// therefore cannot have a body
//	public int getFive() {
//		return 5;
//	}
}
