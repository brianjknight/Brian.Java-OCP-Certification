package chapter9.collectionsGenerics;

import java.util.HashMap;
import java.util.Map;

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
		
	}
	
}


