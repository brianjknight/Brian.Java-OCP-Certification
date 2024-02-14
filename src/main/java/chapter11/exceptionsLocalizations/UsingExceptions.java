package chapter11.exceptionsLocalizations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class UsingExceptions {
	
	public static void main(String[] args) {
		
		
	}
	
	
	void methodA(int i) {
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
			System.out.println(e);
		} 
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	void methoB(int i) {
		try {
			if (i < 0) {
				throw new FileNotFoundException();
			} else if (i > 0) {
				throw new IOException();
			} else {
				throw new SQLException(); 
			}
		} 
//		catch (FileNotFoundException | IOException e) { // multi-catch cannot use related Exceptions  
//			System.out.println(e); 
//		}
//		catch (FileNotFoundException | SQLException e) {  // does not handle IOException
//			System.out.println(e);
//		}
		catch (IOException | SQLException e) { // Super IOException includes FileNotFoundException
			System.out.println(e);
		}
		
	}
	
	
}


