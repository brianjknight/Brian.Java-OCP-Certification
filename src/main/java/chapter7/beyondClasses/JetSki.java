package chapter7.beyondClasses;

//public class JetSki extends Vehicle {
public class JetSki {
	private String j = "jet ski";
	
	public static void main(String[] args) {
		A.B.C c = new A().new B().new C();
		var varC = new A().new B().new C();
//		int x = c.x; // private member not visible
		
		// instance of A is not required for nested static class static members
		System.out.println(A.B.D.y);
//		System.out.println(A.B.D.z); // z is private and not accessible outside of the enclosing class/file
		
		A.B b = new A().new B();
//		A.B.D d = b.new D(); // using an instance to create a static not allowed
//		A.B.D dd = new A().new B().new D();
//		A.B.D ddd = new b.D();
		A.B.D dddd = new A.B.D(); // creating static without instantiating specific instance
		
	}
}
