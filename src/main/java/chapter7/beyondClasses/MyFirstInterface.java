package chapter7.beyondClasses;

// abstract is implicit
public sealed interface MyFirstInterface permits OneInterface {
	int ONE = 0; // fields are implicitly and can ONLY be public static final
//	int two; // implicitly final so must be initialized
//	private int three = 3;
//	protected int four = 4;
	static int five = 5;
	public static int six = 6;
	
//	public MyFirstInterface(){} // constructors not allowed for interfaces
	
	interface nestedInterface {}
	
	public static void main(String[] args) {
		// allowed
	}
}


interface OtherInterface {}