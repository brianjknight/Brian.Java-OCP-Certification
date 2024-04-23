package chapter6.classDesign;

public abstract class AbstractChild extends AbstractClass {

	// overriding rules apply to IMPLEMENTING abstract methods
//	abstract String getName(); // restricting access
//	public int getName(); // incompatible return
//	public String getName(); // cannot override in child abstract class
	
	public String getName() { // concrete of AbstractChild no longer needs to implement since it would be inherited 
		return name;
	}
	
}
