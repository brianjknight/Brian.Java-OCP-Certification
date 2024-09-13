package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.List;

public class Monkey extends Mammal {
	
	// valid override return type is subtype
	public ArrayList<CharSequence> play() { return new ArrayList<>(); }
//	public ArrayList<String> play() { return new ArrayList<>(); } // does not compile

	
//	public List<CharSequence> run(List<Integer> nums) {	return new ArrayList<>();}
//	public List<CharSequence> run(List<Object> nums) {	return new ArrayList<>();}
	public ArrayList<CharSequence> run(List<Number> nums) {	return new ArrayList<>();} // valid override
	public List<CharSequence> run(ArrayList<Number> nums) {	return new ArrayList<>();} // overloading NOT overriding
	
	
}


