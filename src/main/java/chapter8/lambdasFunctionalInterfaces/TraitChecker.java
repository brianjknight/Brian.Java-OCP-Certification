package chapter8.lambdasFunctionalInterfaces;

@FunctionalInterface
public interface TraitChecker {
	int num = 0;

	// Functional interface has a single abstract method
	String test(Animal a);
	
	private void helper() {
		System.out.println("helper");
	}
	
	default String defaultMethod() {
		return "still a single abstract method";
	}
	
	// exception for single abstract method rule is for overridden Object methods
	@Override
	public abstract String toString();
//	public int toString(); // incompatible return type to override Object method
	
	// implicit abstract
	public boolean equals(Object o);
//	public boolean equals(Number o); // this is overloaded not overridden therefore an extra abstract method
	
	// implicit public abstract for an interface
	int hashCode();
}
