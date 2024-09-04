package chapter7.beyondClasses;

import chapter6.classDesign.ConcreteChild;

public class ConcreteClass implements OneInterface,TwoInterface, Ainterface, Binterface {

	ConcreteChild concChild = null; // import package from project
	
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

	@Override
	public String getLetter() {
		return "C";
	}

	public void testDefaultMethods() {
		System.out.println("Testing default methods: ");
		System.out.println(doMath());
//		System.out.println(super.doMath()); // super refers to parent object not interface
//		System.out.println(OneInterface.super.doMath()); // no conflicting default method so does not compile
		
		System.out.println(getLetter());
//		System.out.println(super.getLetter());
		System.out.println(Ainterface.super.getLetter()); // notice different syntax for calling multiple inherited super methods
		System.out.println(Binterface.super.getLetter());
	}


	public static void main(String[] args) {
		ConcreteClass cc = new ConcreteClass();
		
		System.out.println(cc.doMath());
//		System.out.println(doMath()); // default are non-static methods
		System.out.println();
		
//		System.out.println("ONE: " + ONE); // constants are inherited however this cannot be used in an ambiguous context when inherited by more than one interface
		System.out.println("MyFirstInterface.ONE: " + MyFirstInterface.ONE);
		System.out.println("OneInterface.ONE: " + OneInterface.ONE);
		System.out.println("TwoInterface.ONE: " + TwoInterface.ONE); // constants are inherited		
		
//		ONE = 2; // fields in interfaces are implicitly constants
		
		System.out.println("");
		
		OneInterface.caller();
		
//		TwoInterface.caller(); // static interface members are not inherited
		System.out.println();
		cc.testDefaultMethods();
	}
}
