package chapter8.lambdasFunctionalInterfaces;

public class MethodReference {
	public static void main(String[] args) {
		String name = "Brian";
		
		StringChecker lambda = () -> name.startsWith("B");
		System.out.println("lambda: " + lambda.check());
		
		// StringChecker interface has check() method with no params
		// startsWith(prefix) requires param
//		StringChekcer methRef = name::startsWith;
		
		// invalid syntax for method reference
//		StringChecker methRef2 = name::startsWith("B");
		
		StringParamChecker paramChecker = name::startsWith;
		System.out.println("method reference startsWith(A): " + paramChecker.check("A"));
		
		// first param is always the object
		StringParamChecker paramCheckerX = String::isEmpty;  // technically not a static method?
		System.out.println("method reference isEmpty(): " + paramCheckerX.check(name));
		
		
		StringTwoParamChecker lambdaTwoParamChecker = (s,p) -> s.startsWith(p);
		System.out.println("lambdaTwoParamChecker: " + lambdaTwoParamChecker.check(name, "B"));
		// first param is always the object
		// following params are method params
		StringTwoParamChecker paramTwoChecker = String::startsWith;  // technically not a static method
		System.out.println("paramTwoChecker: " + paramTwoChecker.check(name, "B"));
		
		StringCreator strCreator = String::new;
		System.out.println("create string: " + strCreator.create());
		System.out.println("create string isEmpty: " + strCreator.create().isEmpty());
		
		StringCopier strCopier = String::new;
		System.out.println("copy string: " + strCopier.copy("hello"));
		
		AnimalCreator animalCreator = Animal::new;
		System.out.println("Animal: " + animalCreator.create("milipede", 1000, false));
		
	}
}

@FunctionalInterface
interface StringChecker {
	boolean check();
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
