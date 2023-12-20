package chapter7.beyondClasses;

public interface OneInterface {

	
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
		divide();
		return 1 + 2;
	}
	
	
}
