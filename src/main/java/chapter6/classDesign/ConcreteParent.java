package chapter6.classDesign;

import java.io.FileNotFoundException;

public class ConcreteParent extends AbstractClass {

	static int age = 100;
	int num = 22;
	
	
	@Override
	public String getName() throws FileNotFoundException {
		
		return null;
	}

	public static void main(String[] args) {
		sayHi();
		System.out.println("age: " + age);
		System.out.println("AbstractClass.age:" + AbstractClass.age);
		
		ConcreteParent cp = new ConcreteParent();
		AbstractClass ac = cp;
		System.out.println("cp.num: " + cp.num);
		System.out.println("cp.sayHi(): ");
		cp.sayHi();
		System.out.println("ac.num: " + ac.num);
		System.out.println("ac.sayHi(): ");
		ac.sayHi();
	}
	
	public static void sayHi() {
		System.out.println("hello");
	}

	@Override
	void abstractVoid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void abstractProtectedVoid() {
		// TODO Auto-generated method stub
		
	}
}


