package chapter14.IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Map;

public class InteractingWithUsersPart1 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("What is your name?");
		var reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		
		System.out.println("hello " + input);

//		System.out.close(); // close OUT
		System.out.println("world"); // PrintStream OutputSreams do not throw checked exceptions
		
		InputStream systemIn = System.in;
		System.out.println("enter a byte:");
		int byteIn = systemIn.read();
		System.out.println("System in int: " + byteIn);
		System.out.println("System in (char): " + (char)byteIn);
		System.out.println();
		
		var charInpStr = new InputStreamReader(System.in);
		System.out.println("enter for charInpStr:");
		int charIn = charInpStr.read(); // '\n' charater is still in the System.in stream from entering name so int value is 10
		System.out.println(charIn);
		
		System.in.close(); 
//		String bad = reader.readLine(); // System.in InputStream DOES throw checked IOException
		// note if the above line is NOT commented out, the system waits for user input before proceeding
		// There is not prompt to enter anything so appears nothing is happening.
		
		
		Map<String,String> env = System.getenv();
//		System.out.println("env size:" + env.size());
//		env.forEach((k,v) -> System.out.println(k + ":" + v));
		
		// Input/OutputStreams and Reader/Writers are part of java.io NOT java.nio
//		var pathReader = new BufferedReader(new FileReader(Path.of("/fake/path"))); // does not compile
		
		
	}
}


