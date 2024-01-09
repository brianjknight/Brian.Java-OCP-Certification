package chapter7.beyondClasses;

public class A {
	private int x = 10;
	
	class B {
		private int x = 10 + A.this.x;
		
		final class C {
			private int x = 30;
			
			public void printX() {
				System.out.println(this.x);
				
				B b = new B();
				System.out.println(b.x);
				
				System.out.println(B.this.x);
				System.out.println(A.this.x);
			}
		}
	}
	
	static class D {
		public int y = 25;
		private int z = 50;
	}
	
	public static void doSomething() {
//		B b0 = new B(); // inside this class/static method needs an instance of A
		B b1 = new A().new B();
		System.out.println(b1.x);

		// instance of A is not required for nested static class D
		D d = new D();
		System.out.println(d.y);
		System.out.println(d.z);
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
	}
	
}
