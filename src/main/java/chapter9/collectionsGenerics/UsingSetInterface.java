package chapter9.collectionsGenerics;

import java.util.*;

public class UsingSetInterface {
	
	public static void main(String[] args) {
		
		Set<Double> dubSet = Set.of(1.0,2d,3.5);
//		dubSet.remove(1.0);// immutable Set
		
		Integer[] tens = {0,20,40,60,80,100,30,10,70,90,50};
		
		Set<Integer> intSet = new HashSet<>();
		for (Integer i : tens) 
			intSet.add(i);
		System.out.println("intSet:  " + intSet);
		
		Set<Integer> treeSet = new TreeSet<>();
		for (Integer i : tens) 
			treeSet.add(i); // preserves order; inserts on natural ordering
		System.out.println("treeSet: " + treeSet);
		
		System.out.println();
		System.out.println("add existing return: " + intSet.add(0));
		System.out.println("add new return: " + intSet.add(1000));
		
		Set<Integer> intCopy = Set.copyOf(intSet);
//		intCopy.add(50); // immutable copy cannot add elements
	}
}


