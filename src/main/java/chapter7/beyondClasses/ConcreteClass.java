package chapter7.beyondClasses;

public class ConcreteClass implements TwoInterface {

	@Override
	public void divide() {
		// TODO Auto-generated method stub
		System.out.println("doing division");
	}

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		ConcreteClass cc = new ConcreteClass();
		
		System.out.println(cc.doMath());
		
		System.out.println("***********");
		
		OneInterface.caller();
	}
}
