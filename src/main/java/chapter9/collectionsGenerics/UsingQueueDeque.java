package chapter9.collectionsGenerics;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class UsingQueueDeque {
	public static void main(String[] args) {
		
		Queue<String> names = new LinkedList<>();
//		System.out.println(names.remove()); // throws exception
//		System.out.print(names.element()); // throws exception
		
		System.out.println(names.poll()); // returns null if empty
		System.out.println(names.peek());// returns null if empty
		
		Deque<String> animals = new LinkedList<>(); // extends Queue; using as FIFO?
		animals.add("eagle");
		animals.offer("bear");
//		animals.addLast("snake");
//		animals.offerLast("rhino");
		animals.add("snake");
		animals.add("rhino");
		animals.push("penguin");
		
		System.out.println(animals);
		System.out.println(animals.element());
		System.out.println(animals.peek());
		System.out.println(animals.getFirst());
		
		
		Deque<String> other = new ArrayDeque<>(); // using as Stack/LIFO?
		other.add("eagle");
		other.offer("bear");
		other.addLast("snake");
		other.offerLast("rhino");
		other.push("penguin");
		System.out.println(other);
	}
}


