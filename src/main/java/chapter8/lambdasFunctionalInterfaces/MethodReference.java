package chapter8.lambdasFunctionalInterfaces;

import java.util.List;

public class MethodReference {
	public static void main(String[] args) {
		String name = "Brian";
		
		StringChecker<Boolean> lambda = () -> name.startsWith("B");
		System.out.println("lambda: " + lambda.check());
		
		// StringChecker interface has check() method with no params
		// startsWith(prefix) requires param
//		StringChekcer methRef = name::startsWith;
		
		// invalid syntax for method reference
//		StringChecker methRef2 = name::startsWith("B");
		
		StringParamChecker paramChecker = name::startsWith;
		System.out.println("method reference startsWith(A): " + paramChecker.check("A"));
		
		// first param is always the object
		StringParamChecker paramCheckerX = String::isEmpty;  // technically not a static method
		System.out.println("method reference isEmpty(): " + paramCheckerX.check(name));
		
		StringTwoParamChecker lambdaTwoParamChecker = (s,p) -> s.startsWith(p);
		System.out.println("lambdaTwoParamChecker: " + lambdaTwoParamChecker.check(name, "B"));
		// first param is always the object
		// following params are method params
		StringTwoParamChecker paramTwoChecker = String::startsWith;  // not a static method reference
		System.out.println("paramTwoChecker: " + paramTwoChecker.check(name, "B"));
		
		StringCreator strCreator = String::new; // String here is a static
		System.out.println("create string: " + strCreator.create());
		System.out.println("create string isEmpty: " + strCreator.create().isEmpty());
		
		StringCopier strCopier = String::new; // String here is type of object in the param
		System.out.println("copy string: " + strCopier.copy("hello"));
		
		AnimalCreator animalCreator = Animal::new;
		System.out.println("Animal: " + animalCreator.create("milipede", 1000, false));
		
//		StringParamChecker p1 = List::isEmpty; // bad parameter
	}
}

@FunctionalInterface
interface StringChecker<T> {
	T check();
}

interface StringParamChecker {
	boolean check(String prefix);
}

interface StringTwoParamChecker {
	boolean check(String str, String prefix);
}

interface StringCreator {
	String create();
}

interface StringCopier {
	String copy(String str);
}

interface AnimalCreator {
	Animal create(String species, int numLegs, boolean isDangerous);
}


