package chapter9.collectionsGenerics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BinaryOperator;

public class UsingMaps {
	
	public static void main(String[] args) {
		
		Map<String, Integer> of = Map.of("Brian",39,"Allison",42);
//		of.put("Josie", 13); // of is immutable
		
		Map<String, Integer> ofEntries = 
				Map.ofEntries(
						Map.entry("Brian",39),
						Map.entry("Allison", 42)
						);
//		ofEntries.put("Bryson", 11); // ofEntries is immutable
		
	
		Map<String, Integer> ages = new HashMap<>();
		ages.put("Brian", 39);
		ages.put("Allison", null);
		System.out.println(ages);

		Integer brianAge = ages.putIfAbsent("Brian", 100);
		Integer allisonAge = ages.putIfAbsent("Allison", 42);
		Integer chaseAge = ages.put("Chase", 1);
		System.out.println("brianAge: " + brianAge);
		System.out.println("allisonAge: " + allisonAge);
		System.out.println("chaseAge: " + chaseAge);
		System.out.println(ages);
		
		
		Map<String, String> favs = new HashMap<>();
		favs.put("Sally", "bike");
		favs.put("Ann", "shuttle");
		favs.put("Zach", null);
		favs.put("Tim", "unicycle");
		System.out.println(favs);
		
		BinaryOperator<String> longer = (a,b) -> a.length() > b.length() ? a : b;
		String sally = favs.merge("Sally", "airplane", longer);
		String zach = favs.merge("Zach", "boat", longer); // note because Zach value is null the function is NOT called. merge() just adds the value
		String tim = favs.merge("Tim", "walk" , longer);
		System.out.println("returns set value: " + sally + " | " + zach + " | " + tim);
		System.out.println(favs);
		
		BinaryOperator<String> nullRemovesKey = (a,b) -> a.length() > b.length() ? a : null;
		favs.merge("Sally", "airplane", nullRemovesKey);
		favs.merge("Zach", "motorcycle", nullRemovesKey);
		System.out.println(favs);
		
		favs.put("Ann", null);
		favs.put("TIM", "tricycle");
		System.out.println(favs);
		
		
		Map<String, String> treeMap = new TreeMap<>();
		treeMap.put("A", "value");
		treeMap.put("F", "value");
		treeMap.put("D","value");
		treeMap.put("B", null);
//		treeMap.put(null, "value"); // sorted data structure does not allow null key
		System.out.println(treeMap);
		
		
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.add(10);
		treeSet.add(3);
		treeSet.add(7);
//		treeSet.add(null); // compiles but throws runtime NullPointerException
		System.out.println(treeSet);
	}
	
}


