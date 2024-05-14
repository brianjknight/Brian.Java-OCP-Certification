package chapter10.streams;

import static java.util.stream.Collectors.toMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedStreams {
	
	public static void main(String[] args) {
		
		var ohMy = Stream.of("lions", "tigers", "bears");
		Map<String, Integer> map = ohMy.collect(toMap(s -> s, String::length)); // static import example Collectors.toMap()
		var ohMy2 = Stream.of("lions", "tigers", "bears");
		Map<String, Integer> mapWithIdentity = ohMy2.collect(toMap(Function.identity(), String::length));
		System.out.println("map: " + map);
		System.out.println("mapWithIdentity: " + mapWithIdentity);
		System.out.println();
		
		Stream<String> countingStream = Stream.of("b", "b", "a", "a", "a", "c");
		Map<String, Integer> counts = countingStream.collect(
				Collectors.toMap(
						Function.identity(), // same as x -> x
						c -> 1, // Function that just returns 1 to initiate count
						(v1, v2) -> v1 + v2, // BinaryOperator for duplicate keys to combine existing '1' value with current '1' value
						TreeMap::new)); // supplier returns as an ordered TreeMap instead of default HashMap
		System.out.println("counts: " + counts);
		System.out.println();
		
		Stream<String> anotherCountingStream = Stream.of("b", "b", "a", "a", "a", "c");
		Map<String, List<String>> anotherCount = anotherCountingStream.collect(Collectors.groupingBy(x -> x));
//		Map<String, Set<String>> toset = anotherCountingStream.collect(Collectors.groupingBy(x -> x, Collectors.toSet()));
		System.out.println("anotherCount: " + anotherCount);
		List<String> abc = List.of("b", "b", "a", "a", "a", "c");
		Map<String, Long> abcCount = abc.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println("abc: " + abcCount);
		System.out.println();
		
		var ohMyIntKey = Stream.of("lions", "tigers", "bears");
		Map<Integer, String> mapIntString = ohMyIntKey.collect(Collectors.toMap(
				String::length,
				k -> k,
				(s1, s2) -> s1 + "," + s2)); // BinaryOperator to handle dupalicate keys
		System.out.println("mapIntString: " + mapIntString);
		System.out.println();
		
		var ohMyTree = Stream.of("lions", "tigers", "bears");
		TreeMap<Integer, String> mapTree = ohMyTree.collect(Collectors.toMap(
				String::length,
				k -> k,
				(s1, s2) -> s1 + "," + s2,
				TreeMap::new)); // Supplier to specify Map type to return
		System.out.println("mapTree: " + mapTree);
		System.out.println();
	
		Stream<String> words = Stream.of("jack", "jack","jack", "jack", "jill","ant", "and", "amy", "bike", "bin", "balloon", "coolers");
		Map<Character, List<String>> firstLetter = words.collect(
				Collectors.groupingBy(
						s -> s.charAt(0)));
		System.out.println("firstLetter type: " + firstLetter.getClass().getSimpleName());
		System.out.println("firstLetter: " + firstLetter);
		System.out.println();
				
		
		Stream<String> wordsVerbose = Stream.of("jack", "jack","jack", "jack", "jill","ant", "and", "amy", "bike", "bin", "balloon", "coolers");
		Map<Character, List<String>> firstLetterVerbose = wordsVerbose.collect(
				Collectors.groupingBy(
						s -> s.charAt(0),
						HashMap::new,
						Collectors.toList()));
		System.out.println("firstLetterVerbose type: " + firstLetterVerbose.getClass().getSimpleName());
		System.out.println("firstLetterVerbose: " + firstLetterVerbose);
		System.out.println();
		

		Stream<String> wordsTreeSet = Stream.of("jack", "jack", "jill", "jill","ant", "and", "amy", "bike", "bin", "balloon", "coolers");
		Map<Character, Set<String>> firstLetterTreeMapMapTypeTreeSetValues = wordsTreeSet.collect(
				Collectors.groupingBy( 
				s -> s.charAt(0), 
				TreeMap::new, // Supplier to specify type of Map to return
				Collectors.toCollection(TreeSet::new))); // Collector to specify how to return the VALUE
		System.out.println("firstLetterTreeMap(MapType)TreeSetValues: " + firstLetterTreeMapMapTypeTreeSetValues);
		System.out.println();
		
		
		Stream<String> wordsPartioning = Stream.of("jack", "jack", "jill", "jill","ant", "and", "amy", "bike", "bin", "balloon", "coolers");
		Map<Boolean, Set<String>> partitionFour = wordsPartioning.collect(Collectors.partitioningBy(s -> s.length()==4, Collectors.toSet()));
		System.out.println("partition length of 4: " + partitionFour);
		System.out.println();
		
		Stream<String> teeing = Stream.of("jack", "jack", "jill", "jill","ant", "and", "amy", "bike", "bin", "balloon", "coolers");
		String teeingExample = teeing.filter(s -> s.startsWith("a")).sorted()
				.collect(Collectors.teeing(
						Collectors.joining(":"), 
						Collectors.joining("|"), 
						(colonSep, pipeSep) -> new String(colonSep + pipeSep)));
		System.out.println("teeingExample: " + teeingExample);
		
		
		
	}
}
