package chapter7.beyondClasses;

public non-sealed interface OneInterface extends MyFirstInterface {
	
	void divide();
	
	public default int multiply() {
		return 2*3;
	}
	
	private static void staticHelper() {
		System.out.println("static helper");
	}
	
	static void caller() {
		staticHelper();
//		nonStaticHelper();
//		divide();
	}
	
	private void nonStaticHelper() {
		staticHelper();
		
		divide();
	}
	
	default int doMath() {
		staticHelper();
		divide(); // access to an abstract method not yet implemented
		return 1 + 2;
	}
	
	// if not declared private, default, or static methods are implicitly abstract
//	public int getFive() {
//		return 5;
//	}
}
