package chapter7.beyondClasses;

public interface TwoInterface extends OneInterface {
	public abstract void methodA();
	
	void methodB();
	
//	protected void methodC();
//	private void methodD();
	
	private static void methodF() {
		System.out.println("methodF");
	}
	
	public static void main(String[] args) {
		methodF();
	}
}
