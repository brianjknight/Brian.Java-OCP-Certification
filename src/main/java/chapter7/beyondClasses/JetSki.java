package chapter7.beyondClasses;

//public class JetSki extends Vehicle {
public class JetSki {
	private String j = "jet ski";
	
	public static void main(String[] args) {
		A.B.C c = new A().new B().new C();
//		int x = c.x; // private member not visible
	}
}
