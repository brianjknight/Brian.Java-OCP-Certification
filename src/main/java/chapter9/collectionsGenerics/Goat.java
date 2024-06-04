package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.List;

public class Goat extends Mammal {
//	public List<String> play() { return new ArrayList<>(); } // DOES NOT COMPILE
//	public ArrayList<String> play() {return new ArrayList<>();} // does not compile
//	public List<CharSequence> play() {return new ArrayList<>();} // compiles matching return type
	public ArrayList<CharSequence> play() {return new ArrayList<>();} // compiles returns subtype same generic type
	public String sleep() {return ""; }
	
	// Overloading
	List<Number> play(List<Integer> in) {
		return new ArrayList<>();
	}
//	List<Character> play(List<Double> in) { // invalid overload; considered same signature
//		return new ArrayList<>();
//	}
	
}
