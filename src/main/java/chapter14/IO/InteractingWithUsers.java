package chapter14.IO;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractingWithUsers {

	public static void main(String[] args) throws IOException {
//		var reader = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("What is your name?");
//		String userInput = reader.readLine();
//		System.out.println("Hello " + userInput);
		
		// NOTE using Console within an IDE might be unavailable
		
		Console c = System.console();
		if (c != null) {
			System.out.println("Name a cookie: ");
			String in = c.readLine();
			c.writer().println("You entered: " + in + " mmmm");
		} else {
			System.err.println("console not available");
		}
//		c.writer().println("not available"); null pointer if not available
		
		
		Console console = System.console();
		if (console == null) {
			throw new RuntimeException("Console not available");
		} else {
			console.writer().println("Welcome to Our Zoo!");
			console.format("It has %d animals and employs %d people", 391, 25);
			console.writer().println();
			console.printf("The zoo spans %5.1f acres", 128.91);
		}
		
	}
	
}


