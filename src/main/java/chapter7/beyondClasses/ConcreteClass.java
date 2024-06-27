package chapter7.beyondClasses;

public class ConcreteClass implements OneInterface,TwoInterface {

	@Override
	public void divide() {
		System.out.println("doing division");
	}

	public void methodA() {
//		otherCaller(); // static METHODS are NOT inherited from interfaces
	}

	@Override
	public void methodB() {
		
	}
	
	public void testDefault() {
		System.out.println(doMath());
//		System.out.println(super.doMath()); // super refers to parent object not interface
//		System.out.println(OneInterface.super.doMath()); // no conflicting default method so does not compile
	}

	public static void main(String[] args) {
		ConcreteClass cc = new ConcreteClass();
		
		System.out.println(cc.doMath());
//		System.out.println(doMath()); // non-static method
		System.out.println();
		
		System.out.println("ONE: " + ONE); // constants are inherited
		System.out.println("TwoInterface.ONE: " + TwoInterface.ONE); // constants are inherited
		
		System.out.println("MyFirstInterface.ONE: " + MyFirstInterface.ONE);
		
//		ONE = 2; // fields in interfaces are implicitly constants
		
		System.out.println("");
		
		OneInterface.caller();
		
//		TwoInterface.caller(); // static interface members are not inherited
	}
}
