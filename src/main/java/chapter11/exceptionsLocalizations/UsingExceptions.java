package chapter11.exceptionsLocalizations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.sql.SQLException;

public class UsingExceptions {
	
	public static void main(String[] args) throws FileNotFoundException  {
		int j = 1;
	    try {
	    	int i = doIt() / j++; // prints 1; exception is thrown prior to j++ executing
//	    	int i = j++ / doIt(); // prints 2; j++ executes before doIt() throws exception
	    } catch (Exception e) {
	    	System.out.println(" j = " + j);
	    }
		
	    try {
	    	// code
	    } catch (Error e) {
	    	System.out.println("compiles but don't do this");
	    }
		
//		System.out.println(1/0); // runtime ArithmeticException
		
		UsingExceptions ue = new UsingExceptions();
		
//		ue.methodE("input", null);
		
//		ue.methodB(-1); // system.exit() terminates before finally
		ue.methodB(1);
		
		int result = ue.methodC(1);
		System.out.println("result: " + result);
		
		ue.methodA(-1);
	}
	
	void useless() throws Exception, Exception, IOException, IOException, FileNotFoundException {}
	
	void methodA(int i) throws FileNotFoundException { // catch clause throws the exception
		try {
			if (i < 0) {
				throw new FileNotFoundException();
			} else if (i > 0) {
				throw new IOException();
			} 
		} 
//		catch (IOException  e) { // creates unreachable code subtype exception
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
	
	void methodB(int i) { // exception is handled throws not required
		try {
			if (i < 0) {
				System.out.println("excecute System.exit(0)");
				System.exit(0); // finally does NOT execute
				throw new FileNotFoundException();
			} else if (i > 10) {
				throw new NotSerializableException();
			} else if (i > 20) { 
				throw new IOException();
			} else {
				throw new SQLException("throwing SQL exception"); 
			}
		} 
//		catch (FileNotFoundException | IOException e) { // multi-catch cannot use subtype & parent  
//			System.out.println(e); 
//		}
//		catch (FileNotFoundException | SQLException e) {  // does not handle IOException
//			System.out.println(e);
//		}
		catch (FileNotFoundException | NotSerializableException e) {
			System.out.println(e);
		}
		catch (IOException | SQLException e) { // Super IOException includes FileNotFoundException
			System.out.println(e);
		}
		finally {
			System.out.println("finally method B part ONE");
			
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
		} 
		finally {
			System.out.println("finally method c: catch block not required with finally block");
			return -10;
		}
	}
	
	void methodD() {
//		try {
//			System.out.println("method d"); // cannot throw a checked IOException
//		} catch (IOException e) {
//			System.out.println("method d catch");
//		}
		try {
			System.out.println("try methodD()");
		} catch(NullPointerException | ArithmeticException e) { // allows catching runtime exceptions that can't be thrown
			System.out.println("catch methodD()");
		}
	}
	
	void methodE(String a, String b) {
		System.out.println(a.toUpperCase() + " " + b.toUpperCase());
	}
	
	public void other() {
		try {
			System.out.println("any UNCHECKED exceptions can be added in catch blocks");
		} catch(ArithmeticException e) {
			System.out.println();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println();
		} 
//		catch (SQLException e) { // try block MUST be able to throw the CHECKED exception
//			System.out.println();
//		}
	}
	
	void another() {
		try {
			// catch is only unreachable for more specific CHECKED exceptions
		} catch (Exception e) {
//		} catch (IOException e) { // unreachable code
			System.out.println("exception");
		}
	}
	
	public static int doIt() throws Exception {  throw new Exception("FORGET IT");  }
}


