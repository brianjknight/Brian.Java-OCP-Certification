package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortingData {

	public static void main(String[] args) {
		
		Set<String> tree = new TreeSet<>();
//		tree.add(null); // compiles but throws runtime exception; Sorted data structures (Trees) NOT allowed null value
		
		List<DuckNotComparable> badDucks = new ArrayList<>();
		badDucks.add(new DuckNotComparable("a", 1, 1.0, "x", 1));
		badDucks.add(new DuckNotComparable("b", 2, 2.0, "y", 2));
//		Collections.sort(badDucks); // does not compile on trying to sort
		
//		Set<DuckNotComparable> moreBadDucksCompiles = new TreeSet<>(); // throws runtime when adding object
		Set<DuckNotComparable> moreBadDucks = new TreeSet<>(Comparator.comparing(DuckNotComparable::getName));
		moreBadDucks.add(new DuckNotComparable("c", 3, 3.0, "r", 3)); // compiles but throws exception if adding to an ordered list 
		moreBadDucks.add(new DuckNotComparable("d", 4, 4.0, "s", 4));
		
		
		List<Duck> ducks = new ArrayList<>();
		Duck donald = new Duck("Donald", 16, 14.5, "oreo", 50);
		Duck daffy = new Duck("Daffy", 20, 15.5, "pie", 100);
		Duck daffyYounger = new Duck("Daffy", 2, 0.5, "raspberry", 0);
		Duck scrooge = new Duck("Scrooge", 70, 20.9, "pie", 5_000_000);
		Duck daisy = new Duck("Daisy", 18, 10.5, "pie", 1_000);
		
		ducks.add(donald);
		ducks.add(daffy);
		ducks.add(daffyYounger);
		ducks.add(scrooge);
		ducks.add(daisy);
		
		System.out.println("initial ordered list");
		ducks.forEach(System.out::println); // prints order added
		System.out.println();
		
		Collections.sort(ducks);
//		ducks.sort(); // takes a comparator
		System.out.println("natrual comparable sort");
		ducks.forEach(System.out::println); // prints sorted by natural ordering of Comparable
		System.out.println();
		
		ducks.sort(Comparator.reverseOrder()); // using List sort() method
//		Collections.reverse(ducks);
		System.out.println("reverse order");
		ducks.forEach(System.out::println); 
		System.out.println();
		
		Collections.sort(ducks, Comparator.comparingInt(Duck::getAge).reversed());
//		ducks.sort(Comparator.comparingInt(Duck::getAge).reversed()); // works same as previous line
		System.out.println("oldest to youngest");
		ducks.forEach(System.out::println); 
		System.out.println();
		
		Comparator<Duck> wealthiest = new Comparator<Duck>() {
			@Override
			public int compare(Duck d1, Duck d2) {
				return d2.getMoney() - d1.getMoney() ;
			}
		};
		Comparator<Duck> wealthiestLambda = (d1,d2) -> d2.getMoney() - d1.getMoney();
		Comparator<Duck> wealthiestOther = Comparator.comparingInt(Duck::getMoney).reversed();
		Collections.sort(ducks, wealthiest);
//		Collections.sort(ducks, wealthiestLambda);
//		Collections.sort(ducks, wealthiestOther);
//		Collections.sort(ducks, Comparator.comparingInt(Duck::getMoney).reversed());
		System.out.println("wealthiest Comparator");
		ducks.forEach(System.out::println);
		System.out.println();
		
		Comparator<Duck> food = (d1,d2) -> d1.getFavFood().compareTo(d2.getFavFood());
		// convenience method indeed:
		Comparator<Duck> foodConvMet = Comparator.comparing(Duck::getFavFood);
		Collections.sort(ducks, foodConvMet);
		System.out.println("food Comparator");
		ducks.forEach(System.out::println);
		System.out.println();

		
		Comparator<Duck> foodThenHeaviest = new Comparator<Duck>() {
			public int compare(Duck d1, Duck d2) { // not explicitly using the compare() method
				if (d1.getFavFood().compareTo(d2.getFavFood()) == 0) // if the food String is null we have an exception
					return (int) (d2.getWeight() - d1.getWeight());
				else return d1.getFavFood().compareTo(d2.getFavFood());
			}
		};
		Comparator<Duck> foodThenHeaviestConv = 
				Comparator.comparing(Duck::getFavFood).thenComparing(Comparator.comparingDouble(Duck::getWeight).reversed());
		Collections.sort(ducks, foodThenHeaviestConv);
		System.out.println("foodThenHeaviest Comparator");
		ducks.forEach(System.out::println);
		System.out.println();
		
		Comparator<Duck> foodThenLighter = Comparator.comparing(Duck::getFavFood).thenComparingDouble(Duck::getWeight);
		Collections.sort(ducks, foodThenLighter);
		System.out.println("foodThenLighter: ");
		ducks.forEach(System.out::println);
		System.out.println();
		
		List<Duck> noFavFood =  new ArrayList<>();
		Duck a = new Duck();
		a.setName("A");
		Duck b = new Duck();
		b.setName("B");
		noFavFood.add(a);
		noFavFood.add(b);
		
//		Collections.sort(noFavFood, Comparator.comparing(Duck::getFavFood)); // exception will be thrown comparing null
		System.out.println(noFavFood);
		
	}
}


