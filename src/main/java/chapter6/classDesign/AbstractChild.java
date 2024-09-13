package chapter6.classDesign;

abstract class AbstractChild extends AbstractClass {

	// overriding rules apply to IMPLEMENTING abstract methods
//	abstract String getName(); // restricting access
//	public int getName(); // incompatible return
	protected abstract void abstractProtectedVoid(); // override allowed
	
	public String getName() { // concrete implementation of AbstractChild no longer needs to implement since it would be inherited 
		return name;
	}
	
}
