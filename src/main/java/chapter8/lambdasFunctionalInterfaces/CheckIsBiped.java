package chapter8.lambdasFunctionalInterfaces;

public class CheckIsBiped implements TraitChecker {
	public String test(Animal a) {
		return a.numLegs() == 2 ? "biped" : "not biped";
	}
	
	// abstract overrides in TraitChecker do not need to be explicitly implemented since they are inherited from Object
}
