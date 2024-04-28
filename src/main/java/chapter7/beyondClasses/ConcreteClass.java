package chapter7.beyondClasses;

public class ConcreteClass implements TwoInterface {

	@Override
	public void divide() {
		System.out.println("doing division");
	}

	public void methodA() {
		
	}

	@Override
	public void methodB() {
		
	}

	public static void main(String[] args) {
		ConcreteClass cc = new ConcreteClass();
		
		System.out.println(cc.doMath());
		
		System.out.println(ONE); // constants are inherited
		
		System.out.println(MyFirstInterface.ONE);
		
//		ONE = 2; // fields in interfaces are implicitly constants
		
		System.out.println("***********");
		
		OneInterface.caller();
		
//		TwoInterface.caller(); // static interface members are not inherited
	}
}
