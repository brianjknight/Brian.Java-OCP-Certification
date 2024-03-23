package chapter14.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class InteractingWithUsersPart1 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("What is your name?");
		var reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		
		System.out.println("hello " + input);

//		System.out.close();
		System.out.println("world"); // PrintStream OutputSreams do not throw checked exceptions
		
//		System.in.close(); 
//		String bad = reader.readLine(); // System.in InputStream DOES throw checked IOException
		// note if the above line is NOT commented out, the system waits for user input before proceeding
		
		
		Map<String,String> env = System.getenv();
		System.out.println("env size:" + env.size());
		env.forEach((k,v) -> System.out.println(k + ":" + v));
	}
}


