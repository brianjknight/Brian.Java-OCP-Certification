package chapter6.classDesign;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Child extends Parent {
	// variables are never overridden only hidden
	private Number age = 15;
	final String name = "James";
	// staticNum is inherited from Parent
	
	public Child() {
		staticNum = 88;
	}
	
	public Child(int x) {
		this();
//		this(""); // only one other constructor call allowed
	}
	
	public Child(String x) throws IOException {
		super();
	}
	
	public Child(short x) {
		this();
//		super(); // not allowed with this()
	}
	
//	public Child (var v) {} // var not allowed for parameter method or contructor
	
	@Override // annotation not required but can be useful in avoiding errors
//	private Integer getAge() { // cannot reduce accessibility for override
//	public Integer getAge() throws IOException { // cannot throw broadening CHECKED exception
//	public Integer getAge() throws FileSystemException { // cannot throw new CHECKED exception
//	public Object getAge() throws FileNotFoundException, RuntimeException { // return type must be same or subtype 
	public Integer getAge() throws FileNotFoundException, RuntimeException { // CAN throw new or broadening RUNTIME exception 
		// cannot subtract Number objects
		// object on heap is an Autoboxed Integer
		return super.getAge().intValue() - (short) age; 
	}
	
	// redeclared method, not an override
	private int getSize() {
		return 10;
	}
	
	// static methods can only be hidden in child not overridden, however overriding rules still apply
//	@Override // produces compiler error
	public static String greeting() {
		doStaticWork(); // inherited static method
		return "hi";
	}
//	public String greeting() {} // instance method cannot override a static parent method
	
	// cannot override final methods. Will not compile
//	public boolean isCitizen() {
//		return true;
//	}
	
	public void sayGoodBye() {
		System.out.println("good bye from child");
	}
	
//	void doStaticWork() {} // cannot override static methods; only hide
	
	public ArrayList<String> hairy(List<String> list){ // triangle in gutter indicates override
		return null;
	}
	
//	@Override // this is NOT an override; it is overloading the inherited/overridden method above method
	public List<String> hairy(ArrayList<String> list) {
		return null;
	}
	
	void testMisc( ) {
		String temp = misc;
		String superTemp = super.misc;
	}

	public static void main(String[] args) {
		System.out.println("run main");
		System.out.println(staticNum);
		
		Child c = new Child();
//		System.out.println(c.secret); // private in Parent
		System.out.println("secret: " + c.getSecret());
		
		System.out.println(Child.staticNum);
		System.out.println(Parent.staticNum);
		
		System.out.println("greeting():" + greeting());
		System.out.println();
		
	}
}
