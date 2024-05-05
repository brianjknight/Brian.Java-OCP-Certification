package chapter8.lambdasFunctionalInterfaces;

import java.util.List;
import java.util.function.BiFunction;

public class LambdaTest {
	public static void main(String[] args) {
		Animal dog = new Animal("dog", 4, false);
		Animal fish = new Animal("shark", 0, true);
		Animal ostrich = new Animal("ostrich", 2, true);
		Animal ant = new Animal("ant", 6, false);
		
		List<Animal> animals = List.of(dog, fish, ostrich, ant); 
		
		for (Animal a : animals) {
			System.out.println("Animal: " + a);
			
//			var testLambda = a -> a.numLegs();
//			var testLambda = (Animal a) -> a.numLegs();
//			var testLambda = a -> (Object) a.numLegs();
//			var varLambda = (Integer a, Integer b) -> a + b;
			var varLambda = (BiFunction<Integer, Integer, Integer>) (x,y) -> x + y;
			var testLambda = (TraitChecker) z -> z.numLegs() + "";
			
			// passing in the created class which implements TraitChecker interface:
			String legsA = testTrait(a, new CheckIsBiped());
			
			// !!!!!! testTrait() method requires param of TraitChecker interface type returning a String  !!!!!!
			
			// notice legsB and LegsC are both lambdas with 1 param returning a string as required by TraitChecker interface
			
			// lambda for legsB is the same as the implementing class without needing to create it
			// functional interface is effectively declaring and using an anonymous class and its method
			// single statement does not require return and code block
			String legsB = testTrait(a, x -> x.numLegs()  == 2 ? "biped" : "not biped" );
			
			// more than ONE statement requires code block with return
			String legsBreturn = testTrait(a, x -> {  // Java infers type for required TraitChecker param with a method that takes an Animal
					int numLegs = x.numLegs(); // inferred param knows numLegs() method is available
					if (numLegs == 2) {return "biped";}
					return "not biped";
				}
			); // don't forget the semi-colon when assigning the return to a variable
			
			// returns String to match TraitChecker input/return type but different from CheckIsBiped class
			String legsC = testTrait(a, x -> Integer.toString(x.numLegs())); 
			
			System.out.println("\t legsA: " + legsA + " || legsB: " + legsB + 
					" || legsBreturn: " + legsBreturn + " || legsC: " + legsC);
			
			TraitChecker tc = x -> x.isDangerous() ? "dangerous" : "not dangerous";
			TraitCheckerChild tcChild = new CheckIsDangerous();
			CheckIsDangerous chIsDang = new CheckIsDangerous();
			String dangA = testTrait(a, tc);
//			String dangA = testTrait(a, tcChild); // valid
//			String dangA = testTrait(a, chIsDang); // valid
			String dangB = testTrait(a, x -> x.isDangerous() ? "dangerous" : "not dangerous" );
			String dangC = testTrait(a, x -> Boolean.toString(x.isDangerous()) );
			System.out.println("\t dangA: " + dangA + " || dangB: " + dangB + " || dangC: " + dangC);
			
			// method reference
			String species = testTrait(a, Animal::species); // .species() returns String compatible with TraitChecker interface param
			System.out.println("\t Species: " + species);

			// Java is trying to map the lambda to method declared in TraitChecker
			// must take an Animal for the test(Animal a) method declared
			// must return string
//			String speciesSSS = testTrait(a, () -> "dog"); 
			String speciesRRR = testTrait(a, xyz -> "dog"); 
			
			
		}
	}
	
	private static String testTrait(Animal a, TraitChecker checker) {
		return checker.test(a);
	}
}
