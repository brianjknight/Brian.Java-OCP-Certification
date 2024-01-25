package chapter1.building_blocks;

public class Comments {
	
	/**  javadoc comment for methodA()
	 * 
 	
 		starting each line with '*' is default and good practice but not required
 	
 		still same javadoc comment
 
	 * 
	 */
	void methodA() {}
	
	/*
	 * multiline comment
	 *  
	 *  // not considered a single line comment inside multiline
	 * 
	 */

	/* still a multi-line comment */
	
	
//	/*
//	 * 
//	 *   */  end of multi-line
//	 */   does not compile
	
	// single line comment /** not a javadoc */
	
	// single line /* not a multi-line comment */
	
	
}