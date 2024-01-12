package chapter8.lambdasFunctionalInterfaces;

public class CheckIsDangerous implements TraitChecker{

	@Override
	public String test(Animal a) {
		return a.isDangerous() ? "dangerous" : "not dangerous";
	}

}
