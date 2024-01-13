package chapter8.lambdasFunctionalInterfaces;

import java.util.List;

public class LambdaTest {
	public static void main(String[] args) {
		Animal dog = new Animal("dog", 4, false);
		Animal fish = new Animal("shark", 0, true);
		Animal ostrich = new Animal("ostrich", 2, true);
		Animal ant = new Animal("ant", 6, false);
		
		List<Animal> animals = List.of(dog, fish, ostrich, ant); 
		
		for (Animal a : animals) {
			System.out.println("Animal: " + a);
			
			// passing in the created class which implements TraitChecker interface:
			String legsA = testTrait(a, new CheckIsBiped());
			
			// !!!!!! testTrait() method requires param of TraitChecker interface type returning a String  !!!!!!
			
			// notice legsB and LegsC are both lambdas returning a string as required by TraitChecker interface
			
			// lambda for legsB is the same as the implementing class without needing to create it
			// functional interface is effectively declaring and using an anonymous class
			// single statement does not require return and code block
			String legsB = testTrait(a, x -> x.numLegs()  == 2 ? "biped" : "not biped" );
			
			// more than one statement requires code block with return
			String legsBreturn = testTrait(a, x -> {
					int numLegs = x.numLegs();
					if (numLegs == 2) {return "biped";}
					return "not biped";
				}
			);
			
			// returns String to match TraitChecker input/return type but different from CheckIsBiped class
			String legsC = testTrait(a, x -> Integer.toString(x.numLegs())); 
			
			System.out.println("\t legsA: " + legsA + " || legsB: " + legsB + " || legsBreturn: " + legsBreturn + " || legsC: " + legsC);
			
			String dangA = testTrait(a, new CheckIsDangerous());
			String dangB = testTrait(a, x -> x.isDangerous() ? "dangerous" : "not dangerous" );
			String dangC = testTrait(a, x -> Boolean.toString(x.isDangerous()) );
			System.out.println("\t dangA: " + dangA + " || dangB: " + dangB + " || dangC: " + dangC);
			
			// method reference
			String species = testTrait(a, Animal::species); // .species() returns String compitable with TraitChecker interface param
			System.out.println("\t Species: " + species);
		}
	}
	
	private static String testTrait(Animal a, TraitChecker checker) {
		return checker.test(a);
	}
}
