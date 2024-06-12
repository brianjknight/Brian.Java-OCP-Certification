package chapter14.IO;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class InteractingWithUsersPart2 {

	public static void main(String[] args) throws IOException {

		// NOTE using Console within an IDE might be unavailable
		
		Console c = System.console();
		if (c != null) {
			System.out.println("Name a cookie: ");
			String in = c.readLine();
			c.writer().println("You entered: " + in + " mmmm"); // gets a PrintWriter
			c.format("You entered: %s", in); // format on a console obj prints without a new line
		} else {
			System.err.println("console not available");
		}
		
		c.writer().println("not available"); // null pointer if not available
		
		
		Console console = System.console();
		if (console == null) {
			throw new RuntimeException("Console not available");
		} else {
			console.writer().println("Welcome to Our Zoo!");
			console.format("It has %d animals and employs %d people", 391, 25); // Console format() DOES print to console
			console.writer().println(); // empty line since format does not add it
			console.printf("The zoo spans %5.1f acres", 128.91);
			console.writer().println();
			console.writer().format("writer().format() %d", 12345); 
		}
		
	}
	
}


