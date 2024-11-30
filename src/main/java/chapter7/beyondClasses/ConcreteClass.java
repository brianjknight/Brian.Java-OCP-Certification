package chapter7.beyondClasses;

import chapter6.classDesign.ConcreteChild;

public class ConcreteClass implements OneInterface,TwoInterface, Ainterface, Binterface {

	ConcreteChild concChild = null; // testing import other package from project
	
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

	@Override // required override since Ainterface & Binterface both provide default
	public String getLetter() {
		return "C";
	}
	
	public String methodZZZ() { // compatible with AInterface & BInterface
		return "ZZZ";
	}

	public void testDefaultMethods() {
		System.out.println("Testing default methods: ");
		System.out.println(doMath());
//		System.out.println(super.doMath()); // super refers to parent object not interface
//		System.out.println(OneInterface.super.doMath()); // cannot bypass a more specific super interface; TwoInterface inherits the method
		System.out.println(TwoInterface.super.doMath());
		
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
		
//		TwoInterface.caller(); // static interface METHODS are not inherited
		OneInterface.caller();
//		System.out.println("ONE: " + ONE); // constants are inherited however this cannot be used in an ambiguous context when inherited by more than one interface
		System.out.println("MyFirstInterface.ONE: " + MyFirstInterface.ONE);
		System.out.println("OneInterface.ONE: " + OneInterface.ONE);
		System.out.println("TwoInterface.ONE: " + TwoInterface.ONE); // constants are inherited		
		System.out.println(TEN); // inherited only once
		
//		ONE = 2; // fields in interfaces are implicitly constants i.e. final
		
		System.out.println();		
		
		System.out.println();
		cc.testDefaultMethods();
		
	}
}
