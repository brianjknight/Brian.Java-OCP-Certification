package chapter9.collectionsGenerics;

import java.util.*;

public class UsingQueueDeque {
	public static void main(String[] args) {
		
//		Queue<String> bad = new Deque<>();
//		Queue<String> other = new ArrayList<>(); // does not compile; ArrayList does not implement Queue interface
		Queue<String> names = new LinkedList<>();
//		System.out.println(names.remove()); // throws exception
//		System.out.print(names.element()); // throws exception
//		names.offer(null); // LinkedList allows null
//		System.out.println(names.size());
		
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
		System.out.println(animals);
		System.out.println(animals.poll());
		System.out.println(animals);
		System.out.println();
		
		
		Deque<String> stack = new ArrayDeque<>(); // using as Stack/LIFO?
//		stack.add("eagle"); // these methods are available since Deque inherits from Queue but is not treating it as a Stack
//		stack.offer("bear");
//		stack.addLast("snake");
//		stack.offerLast("rhino");
		
		stack.push("penguin");
		stack.push("eagle");
		stack.push("bear");
		stack.push("snake");
		stack.push("rhino");
//		stack.push(null); // ArrayDeque does not allow null
		
		System.out.println(stack);
		System.out.println("peek(): " + stack.peek());
		System.out.println("pop(): " + stack.pop());
		System.out.println(stack);
	}
}


