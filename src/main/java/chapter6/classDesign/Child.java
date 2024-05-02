package chapter6.classDesign;

import java.io.FileNotFoundException;
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
	
	public Child(String x) {
		super();
	}
	
	public Child(short x) {
		this();
//		super(); // not allowed
	}
	
//	public Child (var v) {} // var not allowed for parameter method or contructor
	
	@Override // annotation not required but can be useful in avoiding errors
//	private Integer getAge() { // cannot reduce accessibility for override
//	public Integer getAge() throws IOException { // cannot throw broadening CHECKED exception
//	public Integer getAge() throws FileSystemException { // cannot throw new CHECKED exception
//	public Object getAge() throws FileNotFoundException, RuntimeException { // return type must be same or subtype 
	public Integer getAge() throws FileNotFoundException, RuntimeException { // CAN throw broadening RUNTIME exception 
		// cannot subtract Objects Number
		// object on heap is an Autoboxed Integer
		return super.getAge().intValue() - (short) age; 
	}
	
	// redeclared method, not an override
	private int getSize() {
		return 10;
	}
	
	// hidden method NOT overridden because static makes it a class member not instance member
//	@Override // produces compiler error
	public static String greeting() {
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
	
	public List<String> hairy(List<String> list){ // triangle in gutter indicates override
		return null;
	}
//	@Override // this is NOT an override; it is overloading the inherited/overridden method above method
	public List<String> hairy(ArrayList<String> list) {
		return null;
	}

	public static void main(String[] args) {
		System.out.println("run main");
		System.out.println(staticNum);
	}
}
