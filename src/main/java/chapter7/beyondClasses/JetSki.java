package chapter7.beyondClasses;

//public class JetSki extends Vehicle {
public class JetSki {
	private String j = "jet ski";
	
	public static void main(String[] args) {
//		A.B.C c = new A().new B().new C();
//		int x = c.x; // private member not visible
		
		// instance of A is not required for nested static class D
		System.out.println(A.B.D.y);
//		System.out.println(A.B.D.z); // z is private and not accessible outside of the enclosing class/file
	}
}
