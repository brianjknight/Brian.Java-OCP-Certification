package chapter6.classDesign;

import java.io.FileNotFoundException;

public class Child extends Parent{
	// variables are never overridden only hidden
	private Number age = 15;
	final String name = "James";
	
	public Child() {}
	
	public Child(int x) {
		this();
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
//	public Integer getAge() throws FileSystemException { // cannot throw new exception
//	public Object getAge() throws FileNotFoundException, RuntimeException { // return type must be same or subtype 
	public Integer getAge() throws FileNotFoundException, RuntimeException { // CAN throw broadening RUNTIME exception 
		return super.getAge().intValue() - 20;
	}
	
	// redeclared method, not an override
	private int getSize() {
		return 10;
	}
	
	// hidden method NOT overridden because static makes it a class member not instance member
	public static String greeting() {
		return "hi";
	}
	
	// cannot override final methods. Will not compile
//	public boolean isCitizen() {
//		return true;
//	}
	
	public void sayGoodBye() {
		System.out.println("good bye from child");
	}

	public static void main(String[] args) {
		System.out.println("run main");
	}
}
