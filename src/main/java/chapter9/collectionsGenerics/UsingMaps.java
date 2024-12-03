package chapter9.collectionsGenerics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiFunction;
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
		ages.put(null, 1);
		System.out.println(ages);
		ages.remove(null);

		Integer brianAge = ages.putIfAbsent("Brian", 100); // returns existing value or null
		Integer allisonAge = ages.putIfAbsent("Allison", 42); // existing key with null value is considered absent
		Integer chaseAge = ages.put("Chase", 1);
		System.out.println("brianAge: " + brianAge);
		System.out.println("allisonAge: " + allisonAge);
		System.out.println("chaseAge: " + chaseAge);
		System.out.println(ages);
		System.out.println();
		
		
		Map<String, String> favs = new HashMap<>();
		favs.put("Sally", "bike");
		favs.put("Ann", "shuttle");
		favs.put("Zach", null);
		favs.put("Tim", "unicycle");
		System.out.println(favs);
		System.out.println("getOrDefault(\"Brian\", \"unknown\"): " + favs.getOrDefault("Brian", "unknown"));
		System.out.println("getOrDefault(\"Zach\", \"unknown\"): " + favs.getOrDefault("Zach", "unknown"));
		
		System.out.println("\nmerge BinaryOperator longer: ");
		BinaryOperator<String> longer = (a,b) -> a.length() > b.length() ? a : b;
		String sally = favs.merge("Sally", "airplane", longer);
		String zach = favs.merge("Zach", "boat", longer); // note because Zach value is null the function is NOT called. merge() just adds the value
		String tim = favs.merge("Tim", "walk" , longer);
		System.out.println("returns the value after operation: ");
		System.out.println("sally: " + sally);
		System.out.println("zach: " + zach);
		System.out.println("tim: " + tim);
		System.out.println(favs);
		System.out.println();
		
		System.out.println("merge with null function return:");
		BiFunction<String,String,String> nullRemovesKey = (a,b) -> a.length() > b.length() ? a : null;
		// merge first looks up the key, it's value becomes first param 'a'; 'b' is merge value param
		favs.merge("Sally", "airp", nullRemovesKey); // is airplane length > airp length?
		favs.merge("Zach", "motorcycle", nullRemovesKey); // is boat length > motorcycle length?
		System.out.println(favs);
		System.out.println();
		
		System.out.println(favs.put("Ann", null));
		System.out.println(favs.put("TIM", "tricycle")); // different key than "Tim"
		favs.put(null, null);
		System.out.println(favs);
		System.out.println();
		
		Map<String, String> treeMap = new TreeMap<>();
		treeMap.put("A", "valueA");
		treeMap.put("F", "valueF");
		treeMap.put("D","valueD");
		treeMap.put("B", null);
//		treeMap.put(null, "value"); // sorted data structures does not allow null key, runtime exception
		System.out.println("treeMap");
		System.out.println(treeMap);
		
		System.out.println();
		Set<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
		treeSet.add(10);
		treeSet.add(3);
		treeSet.add(7);
//		treeSet.add(null); // compiles but throws runtime NullPointerException
		System.out.println("treeSet");
		System.out.println(treeSet);
	}
	
}


