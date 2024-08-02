package chapter7.beyondClasses;

public abstract interface TwoInterface extends OneInterface {
	
	int ONE = 2; 
	
	public abstract void methodA();
	
	void methodB();
	
//	protected void methodC();
//	private void methodD();
	
	private void methodE() {}

	private static void methodF() {
//		methodE();
		System.out.println("methodF");
	}
	
	private void methodX() {
		OneInterface.caller();
//		caller() // static methods are not inherited
	}
	
	public static void main(String[] args) {
		methodF();
		System.out.println(ONE);
//		caller(); 
	}
}
