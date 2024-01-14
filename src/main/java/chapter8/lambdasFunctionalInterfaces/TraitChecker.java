package chapter8.lambdasFunctionalInterfaces;

@FunctionalInterface
public interface TraitChecker {
	int num = 0;

	String test(Animal a);
	
	private void helper() {
		System.out.println("helper");
	}
	
	// Functional interface has a single abstract method
//	int num();
	
	// exception for single abstract method rule for overridden Object methods
	@Override
	public abstract String toString();
//	public int toString(); // incompatible override for Object
	
	// implicit abstract
	public boolean equals(Object o);
	
	// implicit public abstract
	int hashCode();
}
