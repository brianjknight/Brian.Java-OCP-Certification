package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.List;

public class Mammal {
	String type;
	String name;
	
	public List<CharSequence> play() { return new ArrayList<>(); }
//	public List<String> play() {return new ArrayList<>();};
	public CharSequence sleep() { return ""; }
}


