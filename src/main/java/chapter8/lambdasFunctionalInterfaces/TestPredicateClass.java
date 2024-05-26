package chapter8.lambdasFunctionalInterfaces;

import java.util.function.Predicate;

//@FunctionalInterface // this is a class NOT an interface
public class TestPredicateClass implements Predicate<String>{

	@Override
	public boolean test(String t) {
		// TODO Auto-generated method stub
		return this.equals(t);
	}

}


