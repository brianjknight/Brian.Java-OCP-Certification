package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.List;

public class CollectionsBasics {
	public static void main(String[] args) {
		
		List<String> s = new ArrayList<>();
//		List<> bad = new ArrayList<String>();
		
		s.add("a");
		s.add("b");
		s.add("a");
		s.add("c");
		s.add("b");
		s.add("a");
		s.add("c");
		
		s.forEach(System.out::print);
		
		System.out.println();
		System.out.println(s.remove("a")); // removes SINGLE first element
		System.out.println(s);
		System.out.println("******");
		System.out.println(s.removeAll(List.of("a")));
		System.out.println(s);
		System.out.println(s.remove("a"));
		System.out.println(s.removeIf(x -> x.equals("b")));
		System.out.println(s);
		s.clear();
		System.out.println(s);
		
		
	}
}


