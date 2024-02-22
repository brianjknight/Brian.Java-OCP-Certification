package chapter11.exceptionsLocalizations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class UsingExceptions {
	
	public static void main(String[] args) throws FileNotFoundException  {
//		System.out.println(1/0); runtime ArithmeticException
		
		UsingExceptions ue = new UsingExceptions();
		
//		ue.methodE("input", null);
		
//		ue.methodB(-1); system.exit() terminates before finally
		ue.methodB(1);
		
		int result = ue.methodC(1);
		System.out.println("result: " + result);
		
		ue.methodA(-1);
	}
	
	
	void methodA(int i) throws FileNotFoundException {
		try {
			if (i < 0) {
				throw new FileNotFoundException();
			} else if (i > 0) {
				throw new IOException();
			} 
		} 
//		catch (IOException  e) {
//			System.out.println(e);
//		} 
//		catch (FileNotFoundException e) { // unreachable code subtype
//			System.out.println(e);
//		}
		catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} 
		catch (IOException e) {
			System.out.println(e);
		}
		finally {
			System.out.println("finally method A"); // finally still runs even if an exception is thrown in the catch block
		}
		System.out.println("end of method A");
	}
	
	void methodB(int i) {
		try {
			if (i < 0) {
				System.out.println("excecute System.exit(0)");
				System.exit(0); // finally does NOT execute
				throw new FileNotFoundException();
			} else if (i > 0) {
				throw new IOException();
			} else {
				throw new SQLException("throwing SQL exception"); 
			}
		} 
//		catch (FileNotFoundException | IOException e) { // multi-catch cannot use related Exceptions  
//			System.out.println(e); 
//		}
//		catch (FileNotFoundException | SQLException e) {  // does not handle IOException
//			System.out.println(e);
//		}
//		catch (FileNotFoundException  | SQLException e) { // good multi-catch
//			System.out.println(e);
//		}
		catch (IOException | SQLException e) { // Super IOException includes FileNotFoundException
			System.out.println(e);
		}
		finally {
			System.out.println("finally method B part one");
			
//			int[] arr = new int[0]; // finally ALWAYS executes but all of its code may not
//			System.out.println(arr[1]);
			
			System.out.println("finally method B part two");
		}
		System.out.println("end of method B");
	}
	
	int methodC(int i) {
		try {
			methodB(i);
			return 10;
		} finally {
			System.out.println("finally method c: catch block not required with finally block");
			return -10;
		}
	}
	
//	void methodD() {
//		try {
//			System.out.println("method d"); // cannot throw an IOException
//		} catch (IOException e) {
//			System.out.println("method d catch");
//		}
//	}
	
	void methodE(String a, String b) {
		System.out.println(a.toUpperCase() + " " + b.toUpperCase());
	}
}


