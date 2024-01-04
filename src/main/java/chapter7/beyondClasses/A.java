package chapter7.beyondClasses;

public class A {
	private int x = 10;
	
	class B {
		private int x = 20;
		
		
		class C {
			private int x = 30;
			
			public void printX() {
				System.out.println(this.x);
				
				B in = new B();
				System.out.println(in.x);
				
				System.out.println(B.this.x);
				System.out.println(A.this.x);
			}
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		
//		Inner in = new Inner(); // does not compile, needs enclosing outer class
		B b = a.new B(); // works because One is a member of Outer and Java know where to find it within THIS class
		A.B b1 = new A().new B();
		
//		Two two = one.new Two(); // does not compile; we are in an instance of Outer. Two is not a member of Outer
		A.B.C c = b.new C();
		A.B.C c1 = new A().new B().new C();
		
		c1.printX();
	}
}
