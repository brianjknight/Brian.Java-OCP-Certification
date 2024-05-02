package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsBasics {
	public static void main(String[] args) {
		
		Collection<String> coll = new ArrayList<>();
//		Collection<> bad = new ArrayList<String>();
		Set<String> strSet = new HashSet<>();
		List<String> strList = new ArrayList<>(strSet);
		List objsList = new ArrayList();
		List otherList = new ArrayList<>();
		List myList = new ArrayList<String>();
		
		boolean addedA = coll.add("a");
		System.out.println("s.add(\"a\"): " + addedA); 
		coll.add("b");
		coll.add("a");
		coll.add("c");
		coll.add("b");
		coll.add("a");
		coll.add("c");
		
		coll.forEach(System.out::print);
		
		System.out.println();
		System.out.println(coll.remove("a")); // removes SINGLE first element
		System.out.println(coll);
		System.out.println();
		System.out.println(coll.removeAll(List.of("a")));
		System.out.println(coll);
		System.out.println();
		System.out.println(coll.remove("a"));
		System.out.println();
		System.out.println(coll.removeIf(x -> x.equals("b")));
		System.out.println(coll);
		System.out.println();
		coll.clear();
		System.out.println(coll);
		
	}
}


