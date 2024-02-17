package chapter11.exceptionsLocalizations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResources {
	
	public static void main(String[] args) {
		
		MyFileClass readerTwo = new MyFileClass(2);
		
		try (MyFileClass readerOne = new MyFileClass(1);
			 readerTwo;) {  // must be effectively final if using variable
			System.out.println("Try block");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Catch block");
		} finally {
			System.out.println("Finally block");
		}
		
//		readerTwo = new MyFileClass(3);
	}
	
	public void readFile(String file) {
		try (FileInputStream is = new FileInputStream("myfile.txt")) {
		 // Read file data
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readOtherFile(String file) throws FileNotFoundException, IOException {
		try (FileInputStream is = new FileInputStream("myfile.txt")) {
			// Read file data
		} // try-with-resources does not require catch block
	}
	
//	public void notAutoCloseable(String input) {
//		try (String str = input) { // try-with-resources param must implement AutoCloseable or subtype Closeable
//			
//		}
//	}
	
	
}


