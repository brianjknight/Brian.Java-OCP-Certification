package chapter11.exceptionsLocalizations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class TryWithResources {
	
	public static void main(String[] args) {
		
		MyFileClass readerTwo = new MyFileClass(2);
		
		try (var readerOne = new MyFileClass(1); readerTwo) {  // must be effectively final if using variable
			System.out.println("Try block");
//			readerTwo = new MyFileClass(3);
//			throw new RuntimeException();
			RuntimeException e = new RuntimeException();
			throw e;
//			throw new Exception(); // must be caught or use throws
		} 
		// implicit finally block runs closing resources prior to explicit catch/finally
		catch (Exception e) {
			System.out.println("Catch block");
		} 
		finally {
			System.out.println("Finally block");
		}
		
		// readerTwo is still in scope, however reassigning is not allowed. must be effectively final if used in try with resources
//		readerTwo = null; 
		
//		try(String a = "a") { // not autocloseable
//			// code
//		} 
		
//		try() {} // resource required to compile
//		try {} // normal try always requires catch or finally block
		try {} finally {}
	}
	
	public void readFile(String file) {
		try (FileInputStream is = new FileInputStream("myfile.txt")) {
		 // Read file data
		} 
		catch (IOException e) { // required to catch or propagate as most IO classes throw IOExceptions
			e.printStackTrace();
		}
	}
	
	public void readOtherFile(String file) throws FileNotFoundException, IOException {
		try (FileInputStream is = new FileInputStream("myfile.txt")) {
			// Read file data
//			throw new SQLException(); 
		} // try-with-resources does not require catch block or exception declaration
		  // UNLESS try block can throw a CHECKED exception
	}
	
	public void anotherRead() throws IOException {
		try(FileInputStream is = new FileInputStream("myfile.txt"); is; is) { // odd but allowed to compile
			// code
		} // catch/finally not required if method declares throws
		
	}
	
//	public void notAutoCloseable(String input) {
//		try (String str = input) { // try-with-resources param must implement AutoCloseable or subtype Closeable
//			
//		}
//	}

}


