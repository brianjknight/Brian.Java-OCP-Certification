package chapter7.beyondClasses;

public class ConcreteClass implements TwoInterface {

	@Override
	public void divide() {
		System.out.println("doing division");
	}

	@Override
	public void methodA() {
		
	}

	@Override
	public void methodB() {
		
	}

	public static void main(String[] args) {
		ConcreteClass cc = new ConcreteClass();
		
		System.out.println(cc.doMath());
		
		System.out.println("***********");
		
		OneInterface.caller();
		
//		TwoInterface.caller(); // static interface members are not inherited
	}
}
