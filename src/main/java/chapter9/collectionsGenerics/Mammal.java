package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.List;

public class Mammal {
	String type;
	String name;
	
	public List<CharSequence> play() { return new ArrayList<>(); }
//	public List<String> play() {return new ArrayList<>();};
	public CharSequence sleep() { return ""; }
	
	public List<CharSequence> run(List<Number> nums) {
		return new ArrayList<>();
	}
	
	public List<? super Number> getObj() {return null;}
	public List<? extends Number> getWild() {return null;}
	public List<Number> getNums() {return null;}
}


