package chapter7.beyondClasses;

public class A {
	private int x = 10;
	
	class B {
		private int x = 10 + A.this.x;
		
		final class C {
			private int x = 30;
			
			public void printX() {
				int xOfC = x;
				class F {
										
					int getXofC() {
						return xOfC;
					}
				}
				
//				xOfC += 1; // local classes like F can only access effectively final local variables like xOfC
				
				F f = new F();
				System.out.println(f.getXofC());
				
				B b = new B();
				System.out.println(b.x);
				System.out.println(B.this.x);
				System.out.println(A.this.x);
			}
		}
		
		void changeX() {
			x += 1;
		}
		
		// look in JetSki class
		static class D {
			public static int y = 25;
			private static int z = 50;
		}
	}
	
	
	public static void doSomething() {
//		B b0 = new B(); // inside this class/static method needs an instance of A
		B b1 = new A().new B();
		System.out.println(b1.x);
	}
	
	public static void main(String[] args) {
		A a = new A();
		
//		B b0 = new B(); // does not compile, needs enclosing outer class
		B b = a.new B(); // works because One is a member of Outer and Java know where to find it within THIS class
		A.B b1 = new A().new B();
		
		A.B.C c = b.new C();
		A.B.C c1 = new A().new B().new C();
		
		c1.printX();
		System.out.println("******************");
		
		// or try this
		new A().new B().new C().printX();
		System.out.println("******************");

		System.out.println("c1.x = " + c1.x); // private variable of nested class is accessible within the file declaration
		
//		System.out.println("for js j=" + new JetSki().j); // private field not visible outside of class declaration
		
		// instance of A is not required for nested static class D
		System.out.println(A.B.D.y);
		System.out.println(A.B.D.z); // private member is accessible within the enclosing class/file
	}
	
}
