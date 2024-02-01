package chapter9.collectionsGenerics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingData {

	public static void main(String[] args) {
		
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
		System.out.println("natrual comparable sort");
		ducks.forEach(System.out::println); // prints sorted by natural ordering of Comparable
		System.out.println();
		
		ducks.sort(Comparator.reverseOrder()); // using List sort() method
		System.out.println("reverse order");
		ducks.forEach(System.out::println); 
		System.out.println();
		
		Collections.sort(ducks, Comparator.comparingInt(Duck::getAge).reversed());
		System.out.println("oldest to youngest");
		ducks.forEach(System.out::println); 
		System.out.println();
		
		Comparator<Duck> wealthiest = new Comparator<Duck>() {
			@Override
			public int compare(Duck d1, Duck d2) {
				return d2.getMoney() - d1.getMoney() ;
			}
		};
		Collections.sort(ducks, wealthiest);
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
				if (d1.getFavFood().compareTo(d2.getFavFood()) == 0) 
					return (int) (d2.getWeight() - d1.getWeight());
				else return d1.getFavFood().compareTo(d2.getFavFood());
			}
		};
		Comparator<Duck> foodThenLighter = Comparator.comparing(Duck::getFavFood).thenComparingDouble(Duck::getWeight);
		Collections.sort(ducks, foodThenLighter);
		System.out.println("foodThenHeaviest Comparator");
		ducks.forEach(System.out::println);
		System.out.println();
	}
}


